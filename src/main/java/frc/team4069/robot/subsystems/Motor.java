package frc.team4069.robot.subsystems;

// A simple motor wrapper that handles constant speed and ramping up and down
class Motor {

    // An instance of the motor state enum
    private MotorState state = MotorState.IDLE;

    // Initialize given a motor port number
    Motor(int portNumber) {
        // Do nothing for now
    }

    // Update the motor controls
    void update() {
        // Do nothing for now
    }

    // Stop the motor immediately
    void stop() {
        // Set the state to idle
        state = MotorState.IDLE;

        // Do nothing else for now
    }

    // Set the speed of the motor, as a number from -1 to 1
    void setSpeed(double speedMinus1To1) {
        // Set the state to constant speed
        state = MotorState.CONSTANT_SPEED;

        // Do nothing for now
    }

    // An enum that contains the possible states of the motor
    private enum MotorState {
        IDLE,
        CONSTANT_SPEED
    }
}
