package frc.team4069.robot.motors

import kotlin.properties.Delegates

// A simple motor wrapper that defines common APIs for motors
// Implementation-specific internal APIs are implemented by subclasses
// This class should contain higher-level APIs that work regardless of the specific type of motor
abstract class Motor {

    // An instance of the motor state enum
    private val state = MotorState.CONSTANT_SPEED

    // Get the current speed of the motor
    // Set the speed of the motor, as a number from -1 to 1
    // If the speed is outside the range of -1 to 1
    // Stop the motor to ensure safety
    // Throw an error
    // Otherwise, set the speed of the motor to the supplied value
//    var speed: Double
//        set(speed) = if (speed < -1 || speed > 1) {
//            stop()
//            throw IllegalArgumentException("Speed must be between 1 and -1.")
//        } else {
//            setSpeedUnsafe(speed)
//        }

    abstract var speed: Double

    // Update the motor controls (for states such as ramp up and ramp down)
    fun update() {
        // Do nothing yet
    }

    // Set the speed of the motor without checking its validity
    // Called in the setSpeed function and must be overridden by subclasses
//    internal abstract fun setSpeedUnsafe(speed: Double)

    // Stops the motor immediately
    fun stop() {
        // Set the speed of the motor to zero
        speed = 0.0
    }

    // An enum that contains the possible states of the motor
    private enum class MotorState {
        // Rotating at a constant speed or stopped
        CONSTANT_SPEED
    }
}
