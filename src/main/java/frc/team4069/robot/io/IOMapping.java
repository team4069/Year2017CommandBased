package frc.team4069.robot.io;

// A class containing static constants that contain the port numbers for connected devices
public class IOMapping {

    // PWM ports for the left and right drive motors
    public static final int LEFT_DRIVE_PWM = 8;
    public static final int RIGHT_DRIVE_PWM = 9;

    // PWM port for the elevator motor
    public static final int ELEVATOR_PWM = 6;

    // The port number of the drive joystick
    static final int DRIVE_JOYSTICK_NUMBER = 0;

    // Axis numbers for steering and speed on the drive joystick
    // The steering axis is the horizontal axis of the right stick
    static final int DRIVE_STEERING_AXIS = 0;
    // The speed axis is the vertical axis of the right stick
    static final int DRIVE_SPEED_AXIS = 1;

    // Button numbers for elevator control
    // The A button should enable the elevator
    static final int ELEVATOR_START_BUTTON = 1;
    // The B button should disable the elevator
    static final int ELEVATOR_STOP_BUTTON = 2;
}
