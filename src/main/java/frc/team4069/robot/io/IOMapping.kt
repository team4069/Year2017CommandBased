package frc.team4069.robot.io

// A class containing static constants that contain the port numbers for connected devices
object IOMapping {

    // PWM ports for the left and right drive motors
    val LEFT_DRIVE_PWM = 8
    val RIGHT_DRIVE_PWM = 9

    // PWM port for the elevator motor
    val ELEVATOR_PWM = 2

    // PWM port for the feeder
    val FEEDER_PWM = 3

    // CAN bus port for the shooter
    val SHOOTER_CAN_BUS = 0

    // The port number of the drive joystick
    internal val DRIVE_JOYSTICK_NUMBER = 0

    // Axis numbers for steering and speed on the drive joystick
    // The steering axis is the horizontal axis of the right stick
    internal val DRIVE_STEERING_AXIS = 4
    // The speed axis is the vertical axis of the right stick
    internal val DRIVE_SPEED_AXIS = 5

    // Button numbers for elevator control
    // The A button should enable the elevator
    internal val ELEVATOR_START_BUTTON = 1
    // The B button should disable the elevator
    internal val ELEVATOR_STOP_BUTTON = 2

    // The X button should run the shooter
    internal val SHOOTER_BUTTON = 3
}
