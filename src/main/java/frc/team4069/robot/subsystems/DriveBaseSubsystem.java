package frc.team4069.robot.subsystems;

import frc.team4069.robot.io.IOMapping;
import frc.team4069.robot.wrappers.Motor;
import frc.team4069.robot.wrappers.TalonMotor;

// A class that manages all hardware components of the drive base and provides utility functions
// for instructing it to drive and turn in a variety of ways
public class DriveBaseSubsystem extends SubsystemBase {

    // A singleton instance of the drive base subsystem
    private static DriveBaseSubsystem instance;

    // The horizontal distance from the center of the robot to the outer wheels
    private final double halfRobotWidthMeters = 0.5;

    // Left and right drive motors
    private Motor leftDriveMotor;
    private Motor rightDriveMotor;

    // A variable that records the distance traveled since the last state change in meters
    private double distanceTraveledMeters;

    // Initialize the drive motors
    private DriveBaseSubsystem() {
        // Initialize the motors with predefined port numbers
        leftDriveMotor = new TalonMotor(IOMapping.LEFT_DRIVE_PWM);
        rightDriveMotor = new TalonMotor(IOMapping.RIGHT_DRIVE_PWM);
    }

    // A public getter for the instance
    public static DriveBaseSubsystem getInstance() {
        // If the instance is null, create a new one
        if (instance == null) {
            instance = new DriveBaseSubsystem();
        }

        return instance;
    }

    // A public getter for the distance traveled in meters
    public double getDistanceTraveledMeters() {
        return distanceTraveledMeters;
    }

    // A function called periodically and used to send updates to the motors
    public void update() {
        // Update both motors
        leftDriveMotor.update();
        rightDriveMotor.update();
    }

    // Stop moving immediately
    public void stop() {
        // Set the motor speeds to zero
        leftDriveMotor.stop();
        rightDriveMotor.stop();
    }

    // Start driving with a given inverse turning radius and speed from zero to one
    public void driveContinuousSpeed(double inverseTurningRadiusMeters, double speed) {
        // Reset the distance counter to zero
        distanceTraveledMeters = 0;

        // Multiply half the width of the robot by the inverse of the turning radius to get
        // a value for the proportion of the overall speed that this wheel must travel at
        // For instance, if the overall turning radius is 1, and the distance between the wheels
        // is 1, then the left wheel will have to go triple the speed of the left wheel because
        // the circle is three times the size
        // For example, 0.5 (half the distance between the wheels) times the 1 (the turning
        // radius) equals 0.5
        double individualWheelSpeedRelativeToAverage =
                halfRobotWidthMeters * inverseTurningRadiusMeters;

        // The left wheel and right wheel speeds are each 1 +/- (respectively) the individual wheel
        // speed proportion calculated in the last step, assuming the overall speed is scaled to 1
        // This means they must be multiplied by the overall speed to get the final wheel speeds
        // Continuing the previous example, assuming the overall speed of the robot is scaled to 1,
        // indeed the left wheel should rotate at a speed of 1.5 (1 + 0.5)
        // and the right wheel should rotate at 0.5 (1 - 0.5)
        // Also, the left wheel's speed needs to be reversed because of its physical orientation
        double leftWheelSpeed = -(1 + individualWheelSpeedRelativeToAverage) * speed;
        double rightWheelSpeed = (1 - individualWheelSpeedRelativeToAverage) * speed;

        // Set the motor speeds with the previous calculated values
        leftDriveMotor.setSpeed(leftWheelSpeed);
        rightDriveMotor.setSpeed(rightWheelSpeed);
    }
}
