package frc.team4069.robot.subsystems

import frc.team4069.robot.io.IOMapping
import frc.team4069.robot.motors.TalonMotor

// A class that manages all hardware components of the drive base and provides utility functions
// for instructing it to drive and turn in a variety of ways
class DriveBaseSubsystem : SubsystemBase() {

    // The horizontal distance from the center of the robot to the outer wheels
    private val halfRobotWidthMeters = 0.5

    // Left and right drive motors
    private val leftDriveMotor: TalonMotor = TalonMotor(IOMapping.LEFT_DRIVE_PWM)
    private val rightDriveMotor: TalonMotor = TalonMotor(IOMapping.RIGHT_DRIVE_PWM)

    // A variable that records the distance traveled since the last state change in meters
    // A public getter for the distance traveled in meters
    var distanceTraveledMeters: Double = 0.toDouble()
        private set

    // A function called periodically and used to send updates to the motors
    fun update() {
        leftDriveMotor.update()
        rightDriveMotor.update()
    }

    // Stop moving immediately
    fun stop() {
        leftDriveMotor.stop()
        rightDriveMotor.stop()
    }

    // Start driving with a given inverse turning radius and speed from zero to one
    fun driveContinuousSpeed(inverseTurningRadiusMeters: Double, speed: Double) {
        // Reset the distance counter to zero
        distanceTraveledMeters = 0.0

        // Multiply half the width of the robot by the inverse of the turning radius to get
        // a value for the proportion of the overall speed that this wheel must travel at
        // For instance, if the overall turning radius is 1, and the distance between the wheels
        // is 1, then the left wheel will have to go triple the speed of the left wheel because
        // the circle is three times the size
        // For example, 0.5 (half the distance between the wheels) times the 1 (the turning
        // radius) equals 0.5
        val individualWheelSpeedRelativeToAverage = halfRobotWidthMeters * inverseTurningRadiusMeters

        // The left wheel and right wheel speeds are each 1 +/- (respectively) the individual wheel
        // speed proportion calculated in the last step, assuming the overall speed is scaled to 1
        // This means they must be multiplied by the overall speed to get the final wheel speeds
        // Continuing the previous example, assuming the overall speed of the robot is scaled to 1,
        // indeed the left wheel should rotate at a speed of 1.5 (1 + 0.5)
        // and the right wheel should rotate at 0.5 (1 - 0.5)
        // Also, the left wheel's speed needs to be reversed because of its physical orientation
        val leftWheelSpeed = -(1 + individualWheelSpeedRelativeToAverage) * speed
        val rightWheelSpeed = (1 - individualWheelSpeedRelativeToAverage) * speed

        // Set the motor speeds with the previous calculated values
        leftDriveMotor.speed = leftWheelSpeed
        rightDriveMotor.speed = rightWheelSpeed
    }

    companion object {
        val instance by lazy {
            DriveBaseSubsystem()
        }
    }
}
