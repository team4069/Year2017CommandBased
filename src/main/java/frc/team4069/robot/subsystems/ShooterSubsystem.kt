package frc.team4069.robot.subsystems

import frc.team4069.robot.io.IOMapping
import frc.team4069.robot.motors.CANTalonMotor

// A relatively simple control subsystem for the shooter
class ShooterSubsystem : SubsystemBase() {

    // The speed of the shooter when running
    private val speed = 0.5

    // The single shooter motor
    private val shooterMotor: CANTalonMotor = CANTalonMotor(IOMapping.SHOOTER_CAN_BUS)

    // Start running the shooter at full speed
    fun start() {
        // Set the motor speed to the predefined constant, but negative
        shooterMotor.speed = -speed
    }

    // Stop the shooter
    fun stop() = shooterMotor.stop()

    companion object {
        // A singleton instance of the shooter subsystem
        val instance by lazy {
            ShooterSubsystem()
        }
    }
}
