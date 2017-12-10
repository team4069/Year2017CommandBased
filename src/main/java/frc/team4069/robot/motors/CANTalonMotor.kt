package frc.team4069.robot.motors

import com.ctre.CANTalon

// The CANTalon-specific implementation of Motor
class CANTalonMotor(portNumber: Int) : Motor() {

    // An instance of the CANTalon motor API
    private val canTalon: CANTalon = CANTalon(portNumber)

    // Accessor for the currently commanded speed of the CANTalon
    override var speed: Double
        get() = canTalon.get()
        set(speed) = if (speed !in -1..1) {
            throw IllegalArgumentException("Speed must be within -1 and 1.")
        } else {
            canTalon.set(speed)
        }
}
