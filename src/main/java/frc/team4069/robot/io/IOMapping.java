package frc.team4069.robot.io;

// A class containing static constants that contain the port numbers for connected devices
public class IOMapping {

    // PWM ports for the left and right drive motors
    public static final int LEFT_DRIVE_PWM = 8;
    public static final int RIGHT_DRIVE_PWM = 9;

    // Left encoder Digital I/O ports.
    public static final int LEFT_DRIVE_ENCODER_1 = 0;
    public static final int LEFT_DRIVE_ENCODER_2 = 1;
    // Right encoder Digital I/O ports.
    public static final int RIGHT_DRIVE_ENCODER_1 = 2;
    public static final int RIGHT_DRIVE_ENCODER_2 = 3;

    // PWM port for the elevator motor
    public static final int ELEVATOR_PWM = 2;
    // PWM port for the climber motor
    public static final int CLIMBER_PWM = 6;
    // PWM port for the feeder motor
    public static final int FEEDER_PWM = 3;

    // CAN bus port for the shooter
    public static final int SHOOTER_CAN_BUS = 0;
    // CAN bus port for the turret
    public static final int TURRET_CAN_BUS = 1;

    // The port number of the drive joystick
    static final int DRIVE_JOYSTICK_NUMBER = 0;

    // Axis numbers for steering and speed on the drive joystick
    // The steering axis is the horizontal axis of the left stick
    static final int DRIVE_STEERING_AXIS = 0;

    // Right trigger drives forward
    static final int DRIVE_FORWARD_AXIS = 3;

    // Left trigger drives backward
    static final int DRIVE_BACKWARD_AXIS = 2;

    // The number of the POV (directional pad) used for quick turning
    static final int QUICK_TURN_POV = 0;

    // The A button should toggle the elevator
    static final int ELEVATOR_TOGGLE_BUTTON = 1;
    // The X button should run the shooter
    static final int SHOOTER_BUTTON = 3;
    // The Y button should the climber
    static final int CLIMBER_BUTTON = 4;
    // The left bumper should turn the turret left
    static final int TURRET_LEFT_BUTTON = 5;
    // The right bumper should turn the turret right
    static final int TURRET_RIGHT_BUTTON = 6;
}
