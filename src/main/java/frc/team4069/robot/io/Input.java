package frc.team4069.robot.io;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team4069.robot.commands.ClimberToggleCommand;
import frc.team4069.robot.commands.ElevatorToggleCommand;
import frc.team4069.robot.commands.ShooterStartCommand;
import frc.team4069.robot.commands.ShooterStopCommand;

// Class that provides accessors for joystick inputs and maps them to commands
public class Input {

    // The main joystick
    private static Joystick joystick;

    // Initializer that handles mapping of the joysticks to commands
    public static void init() {
        // Create the joystick using the port number
        joystick = new Joystick(IOMapping.DRIVE_JOYSTICK_NUMBER);

        // Map the elevator toggle button to enable or disable the elevator
        Button elevatorToggleButton = new JoystickButton(joystick,
                IOMapping.ELEVATOR_TOGGLE_BUTTON);
        elevatorToggleButton.whenPressed(new ElevatorToggleCommand());

        // Map the shooter button to run the shooter when held and stop it when released
        Button shooterButton = new JoystickButton(joystick, IOMapping.SHOOTER_BUTTON);
        shooterButton.whenPressed(new ShooterStartCommand());
        shooterButton.whenReleased(new ShooterStopCommand());

        // Map the climber button to toggle the climber
        Button climberButton = new JoystickButton(joystick, IOMapping.CLIMBER_BUTTON);
        climberButton.whenPressed(new ClimberToggleCommand());
    }

    // Accessor for the steering axis on the drive joystick
    public static double getSteeringAxis() {
        return joystick.getRawAxis(IOMapping.DRIVE_STEERING_AXIS);
    }

    // Accessor for the speed axis on the drive joystick
    public static double getSpeedAxis() {
        return joystick.getRawAxis(IOMapping.DRIVE_SPEED_AXIS);
    }

    // Accessor for the directional pad on the joystick
    // Returns an angle in degrees, clockwise from the top of the pad
    // Returns -1 if no input is registered
    public static int getDirectionalPadAngleDegrees() {
        // This functionality is built into the joystick library exactly as described
        return joystick.getPOV(IOMapping.QUICK_TURN_POV);
    }
}
