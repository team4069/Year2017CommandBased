package frc.team4069.robot.io;

import edu.wpi.first.wpilibj.Joystick;

// Class that provides accessors for joystick inputs
public class Input {

    // The main joystick
    private static Joystick joystick;

    // Initializer that handles mapping of the joysticks to real port numbers
    public static void init() {
        joystick = new Joystick(IOMapping.DRIVE_JOYSTICK_NUMBER);
    }

    // Accessor for the steering axis on the drive joystick
    public static double getSteeringAxis() {
        return joystick.getRawAxis(IOMapping.DRIVE_STEERING_AXIS);
    }

    // Accessor for the speed axis on the drive joystick
    public static double getSpeedAxis() {
        return joystick.getRawAxis(IOMapping.DRIVE_SPEED_AXIS);
    }

    // Accessor for the button to enable the elevator
    public static boolean getEnableElevatorButton() {
        return joystick.getRawButton(IOMapping.ELEVATOR_START_BUTTON);
    }

    // Accessor for the button to disable the elevator
    public static boolean getDisableElevatorButton() {
        return joystick.getRawButton(IOMapping.ELEVATOR_STOP_BUTTON);
    }
}
