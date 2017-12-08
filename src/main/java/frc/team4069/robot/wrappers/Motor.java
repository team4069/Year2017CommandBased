package frc.team4069.robot.wrappers;

// A simple motor wrapper that handles constant speed and ramping up and down
public abstract class Motor {
    // An instance of the motor state enum
    private MotorState state = MotorState.CONSTANT_SPEED;

    // Update the motor controls
    public abstract void update();

    // Stops the motor immediately
    public abstract void stop();

    // Set the speed of the motor, as a number from -1 to 1
    public void setSpeed(double speed) {
        if(speed < -1 || speed > 1) {
            throw new IllegalArgumentException("Speed must be between 1 and -1.");
        }
    }

    // An enum that contains the possible states of the motor
    private enum MotorState {
        // Rotating at a constant speed or stopped
        CONSTANT_SPEED
    }
}
