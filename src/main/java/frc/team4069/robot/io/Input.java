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

    // Accessor for the X axis on the drive joystick
    public static double getDriveX() {
        // Get the value directly from the joystick
        return joystick.getX();
    }

    // Accessor for the Y axis on the drive joystick
    public static double getDriveY() {
        // Get the value directly from the joystick
        return joystick.getY();
    }
}
