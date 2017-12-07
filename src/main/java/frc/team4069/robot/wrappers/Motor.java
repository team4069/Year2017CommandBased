package frc.team4069.robot.wrappers;

import com.ctre.CANTalon;

// A simple motor wrapper that handles constant speed and ramping up and down
public class Motor {

    // The Talon controller for the motor
    private CANTalon talon;

    // An instance of the motor state enum
    private MotorState state = MotorState.CONSTANT_SPEED;

    // Initialize given a motor port number
    public Motor(int portNumber) {
        // Initialize the Talon
        talon = new CANTalon(portNumber);
    }

    // Update the motor controls
    public void update() {
        // Switch on the current state
        switch (state) {
            // If we are not in a mode that requires changing of speed
            default:
                // Do nothing
                break;
        }
    }

    // Stop the motor immediately
    public void stop() {
        // Set the speed to zero
        setSpeed(0);
    }

    // Set the speed of the motor, as a number from -1 to 1
    public void setSpeed(double speedMinus1To1) {
        // Set the state to constant speed
        state = MotorState.CONSTANT_SPEED;
        // Set the speed of the motor
        talon.set(speedMinus1To1);
    }

    // An enum that contains the possible states of the motor
    private enum MotorState {
        // Rotating at a constant speed or stopped
        CONSTANT_SPEED
    }
}
