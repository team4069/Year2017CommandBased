package frc.team4069.robot;

import edu.wpi.first.wpilibj.Joystick;

// Input wrapper class that provides accessors for joystick inputs
public class OI {

    // The main joystick
    private static Joystick joystick;

    // Initializer that handles mapping of the joysticks to real port numbers
    static void init() {
        joystick = new Joystick(1);
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
