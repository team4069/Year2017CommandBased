package frc.team4069.robot.motors;

import edu.wpi.first.wpilibj.Talon;

// The PWM Talon-specific implementation of Motor
public class TalonMotor extends Motor {

    // An instance of the Talon motor API
    private Talon talon;

    // Create a new instance with a provided port number
    public TalonMotor(int portNumber) {
        // Create a Talon using the provided port number
        talon = new Talon(portNumber);
    }

    // Accessor for the currently commanded speed of the Talon
    public double getSpeed() {
        return talon.get();
    }

    // Set the speed of the motor without any checks or processing
    public void setSpeedUnsafe(double speed) {
        // Set the speed of the Talon directly
        talon.set(speed);
    }
}
