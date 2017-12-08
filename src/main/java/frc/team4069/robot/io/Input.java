package frc.team4069.robot.io;

import edu.wpi.first.wpilibj.Joystick;

// Input class that provides accessors for joystick inputs
public class Input {

    // The main joystick
    private static Joystick joystick;

    // Initializer that handles mapping of the joysticks to real port numbers
    public static void init() {
        joystick = new Joystick(IOMapping.DRIVE_JOYSTICK);
    }

    // Accessor for the steering axis on the drive joystick
    public static double getSteeringAxis() {
        // Get the value directly from the joystick
        return joystick.getRawAxis(IOMapping.STEERING_AXIS);
    }

    // Accessor for the speed axis on the drive joystick
    public static double getDriveY() {
        // Get the value directly from the joystick
        return joystick.getRawAxis(IOMapping.SPEED_AXIS);
    }
}
