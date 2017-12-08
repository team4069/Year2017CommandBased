package frc.team4069.robot.subsystems;

import frc.team4069.robot.io.IOMapping;
import frc.team4069.robot.motors.TalonMotor;

// A relatively simple control subsystem for the elevator
public class ElevatorSubsystem extends SubsystemBase {

    // A singleton instance of the elevator subsystem
    private static ElevatorSubsystem instance;

    // The speed of the elevator when running
    private final double speed = 0.5;

    // The single elevator motor
    private TalonMotor elevatorMotor;

    // Initialize the elevator motor
    private ElevatorSubsystem() {
        // Initialize the motor with the predefined port number
        elevatorMotor = new TalonMotor(IOMapping.ELEVATOR_PWM);
    }

    // A public getter for the instance
    public static ElevatorSubsystem getInstance() {
        // If the instance is null, create a new one
        if (instance == null) {
            instance = new ElevatorSubsystem();
        }

        return instance;
    }

    // Start running the elevator at full speed
    public void start() {
        // Set the motor speed to the predefined constant
        elevatorMotor.setSpeed(speed);
    }

    // Stop the elevator
    public void stop() {
        // Stop the motor immediately
        elevatorMotor.stop();
    }


    public boolean isStarted() {
        return elevatorMotor.getSpeed() == speed;
    }
}
