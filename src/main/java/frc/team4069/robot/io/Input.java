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
    // Joystick button to toggle the elevator
    private static Button elevatorToggleButton;
    // Joystick button to run the shooter and feeder when held
    private static Button shooterButton;
    // Joystick button to toggle the climber
    private static Button climberButton;

    // Initializer that handles mapping of the joysticks to commands
    public static void init() {
        // Create the joystick using the port number
        joystick = new Joystick(IOMapping.DRIVE_JOYSTICK_NUMBER);

        // Map the elevator toggle button to enable or disable the elevator
        elevatorToggleButton = new JoystickButton(joystick, IOMapping.ELEVATOR_TOGGLE_BUTTON);
        elevatorToggleButton.whenPressed(new ElevatorToggleCommand());

        // Map the shooter button to run the shooter when held and stop it when released
        shooterButton = new JoystickButton(joystick, IOMapping.SHOOTER_BUTTON);
        shooterButton.whenPressed(new ShooterStartCommand());
        shooterButton.whenReleased(new ShooterStopCommand());

        climberButton = new JoystickButton(joystick, IOMapping.CLIMBER_BUTTON);
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
}
