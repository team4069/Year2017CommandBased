package frc.team4069.robot.io;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team4069.robot.commands.ElevatorToggleCommand;
import frc.team4069.robot.commands.FeederStartCommand;
import frc.team4069.robot.commands.FeederStopCommand;

// Class that provides accessors for joystick inputs
public class Input {

    // The main joystick
    private static Joystick joystick;

    private static Button elevatorStartButton;
    private static Button shooterButton;

    // Initializer that handles mapping of the joysticks to real port numbers
    public static void init() {
        joystick = new Joystick(IOMapping.DRIVE_JOYSTICK_NUMBER);
        elevatorStartButton = new JoystickButton(joystick, IOMapping.ELEVATOR_START_BUTTON);
        elevatorStartButton.whenPressed(new ElevatorToggleCommand());

        shooterButton = new JoystickButton(joystick, IOMapping.SHOOTER_BUTTON);
        shooterButton.whenPressed(new FeederStartCommand());
        shooterButton.whenReleased(new FeederStopCommand());
    }

    // Accessor for the steering axis on the drive joystick
    public static double getSteeringAxis() {
        return joystick.getRawAxis(IOMapping.DRIVE_STEERING_AXIS);
    }

    // Accessor for the speed axis on the drive joystick
    public static double getSpeedAxis() {
        return joystick.getRawAxis(IOMapping.DRIVE_SPEED_AXIS);
    }
}
