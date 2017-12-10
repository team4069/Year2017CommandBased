package frc.team4069.robot.subsystems

import frc.team4069.robot.io.IOMapping
import frc.team4069.robot.motors.TalonMotor

// A relatively simple control subsystem for the feeder
class FeederSubsystem : SubsystemBase() {

    // The speed of the feeder when running
    private val speed = 0.5

    // The single feeder motor
    private val feederMotor: TalonMotor = TalonMotor(IOMapping.FEEDER_PWM)

    // Start running the feeder at full speed
    fun start() {
        // Set the motor speed to the predefined constant, but negative
        feederMotor.speed = -speed
    }

    // Stop the feeder
    fun stop() {
        // Stop the motor immediately
        feederMotor.stop()
    }

    companion object {

        // A singleton instance of the feeder subsystem
        val instance by lazy {
            FeederSubsystem()
        }
    }
}
