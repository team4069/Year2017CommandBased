package frc.team4069.robot.motors;

// A simple motor wrapper that defines common APIs for motors
// Implementation-specific internal APIs are implemented by subclasses
// This class should contain higher-level APIs that work regardless of the specific type of motor
abstract class Motor {

    // An instance of the motor state enum
    private MotorState state = MotorState.CONSTANT_SPEED;

    // Update the motor controls (for states such as ramp up and ramp down)
    public final void update() {
        // Do nothing yet
    }

    // Get the current speed of the motor
    public abstract double getSpeed();

    // Set the speed of the motor, as a number from -1 to 1
    public final void setSpeed(double speed) {
        // If the speed is outside the range of -1 to 1
        if (speed < -1 || speed > 1) {
            // Stop the motor to ensure safety
            stop();
            // Throw an error
            throw new IllegalArgumentException("Speed must be between 1 and -1.");
        }
        // Otherwise, set the speed of the motor to the supplied value
        else {
            setSpeedUnsafe(speed);
        }
    }

    // Set the speed of the motor without checking its validity
    // Called in the setSpeed function and must be overridden by subclasses
    abstract void setSpeedUnsafe(double speed);

    // Stops the motor immediately
    public final void stop() {
        // Set the speed of the motor to zero
        setSpeed(0);
    }

    // An enum that contains the possible states of the motor
    private enum MotorState {
        // Rotating at a constant speed or stopped
        CONSTANT_SPEED
    }
}
