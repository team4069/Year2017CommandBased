package frc.team4069.robot.wrappers;

// A simple motor wrapper that handles constant speed and ramping up and down
public abstract class Motor {

    // The Talon controller for the motor
//    private Talon talon;

    // An instance of the motor state enum
    private MotorState state = MotorState.CONSTANT_SPEED;

    // Initialize given a motor port number
//    public Motor(int portNumber) {
        // Initialize the Talon
//        talon = new Talon(portNumber);
//    }

    // Update the motor controls
    public abstract void update();
        // Switch on the current state
//        switch (state) {
            // If we are not in a mode that requires changing of speed
//            default:
                // Do nothing
//                break;
//        }
//    }

    // Stop the motor immediately
//    public void stop() {
        // Set the speed to zero
//        setSpeed(0);
//    }

    public abstract void stop();

    // Set the speed of the motor, as a number from -1 to 1
//    public void setSpeed(double speedMinus1To1) {
        // Set the state to constant speed
//        state = MotorState.CONSTANT_SPEED;
        // Set the speed of the motor
//        talon.set(speedMinus1To1);
//    }

    public abstract void setSpeed(double speed);

    // An enum that contains the possible states of the motor
    private enum MotorState {
        // Rotating at a constant speed or stopped
        CONSTANT_SPEED
    }
}
