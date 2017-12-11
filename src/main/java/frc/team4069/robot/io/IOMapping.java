package frc.team4069.robot.io;

// A class containing static constants that contain the port numbers for connected devices
public class IOMapping {

    // PWM ports for the left and right drive motors
    public static final int LEFT_DRIVE_PWM = 8;
    public static final int RIGHT_DRIVE_PWM = 9;

    // PWM port for the elevator motor
    public static final int ELEVATOR_PWM = 2;

    public static final int CLIMBER_PWM = 6;

    // PWM port for the feeder
    public static final int FEEDER_PWM = 3;

    // CAN bus port for the shooter
    public static final int SHOOTER_CAN_BUS = 0;

    // The port number of the drive joystick
    static final int DRIVE_JOYSTICK_NUMBER = 0;


    // Axis numbers for steering and speed on the drive joystick
    // The steering axis is the horizontal axis of the right stick
    static final int DRIVE_STEERING_AXIS = 4;
    // The speed axis is the vertical axis of the right stick
    static final int DRIVE_SPEED_AXIS = 5;

    // Button numbers for elevator control
    // The A button should toggle the elevator
    static final int ELEVATOR_TOGGLE_BUTTON = 1;

    // The X button should run the shooter
    static final int SHOOTER_BUTTON = 3;

    // Driver Y button runs the climber
    static final int CLIMBER_BUTTON = 4;
}
