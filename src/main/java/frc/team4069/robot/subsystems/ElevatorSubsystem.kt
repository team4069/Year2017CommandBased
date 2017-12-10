package frc.team4069.robot.subsystems

import frc.team4069.robot.io.IOMapping
import frc.team4069.robot.motors.TalonMotor

// A relatively simple control subsystem for the elevator
class ElevatorSubsystem : SubsystemBase() {

    // The speed of the elevator when running
    private val speed = 0.5

    // The single elevator motor
    private val elevatorMotor: TalonMotor = TalonMotor(IOMapping.ELEVATOR_PWM)


    val isStarted: Boolean
        get() = elevatorMotor.speed == speed

    // Start running the elevator at full speed
    fun start() {
        // Set the motor speed to the predefined constant
        elevatorMotor.speed = speed
    }

    // Stop the elevator
    fun stop() {
        // Stop the motor immediately
        elevatorMotor.stop()
    }

    companion object {

        // A singleton instance of the elevator subsystem
        val instance: ElevatorSubsystem by lazy {
            ElevatorSubsystem()
        }
    }
}
