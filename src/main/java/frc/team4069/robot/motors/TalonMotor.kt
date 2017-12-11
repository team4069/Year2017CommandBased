package frc.team4069.robot.motors

import edu.wpi.first.wpilibj.Talon

// The PWM Talon-specific implementation of Motor
class TalonMotor(portNumber: Int) : Motor() {

    // An instance of the Talon motor API
    private val talon: Talon = Talon(portNumber)

    // Accessor for the currently commanded speed of the Talon
    override var speed: Double
        get() = talon.get()
        set(speed) = if (speed !in -1..1) {
            throw IllegalArgumentException("Speed must be within -1 and 1.")
        } else {
            talon.speed = speed
        }
}
