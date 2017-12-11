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
        // Create a mutable speed value that will be used to set the motor
        double boundedSpeed = speed;
        // If the motor's speed is greater than 1
        if (speed > 1) {
            boundedSpeed = 1;
        } else if (speed < -1) {
            boundedSpeed = -1;
        }
        // Otherwise, set the speed of the motor to the calculated value
        setSpeedUnsafe(boundedSpeed);
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
