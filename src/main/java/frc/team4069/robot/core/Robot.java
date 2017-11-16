package frc.team4069.robot.core;

import edu.wpi.first.wpilibj.IterativeRobot;
import frc.team4069.robot.commands.Command;
import frc.team4069.robot.commands.SimpleDriveCommand;
import frc.team4069.robot.subsystems.DriveBase;
import frc.team4069.robot.subsystems.Subsystem;
import java.util.ArrayList;
import java.util.Stack;

// The core robot class that calls everything else
public class Robot extends IterativeRobot {

    // The robot drive base
    public DriveBase driveBase;

    // The stack of commands that are executed sequentially
    private Stack<Command> commands = new Stack<>();

    // The currently executing command
    private Command currentCommand;

    // The list of subsystems that each get updated every tick
    private ArrayList<Subsystem> subsystems = new ArrayList<>();

    // Call the update function on each of the subsystems
    private void updateSubsystems() {
        // Update each of the subsystems in sequence
        for (Subsystem subsystem : subsystems) {
            subsystem.update();
        }
    }

    // Called when the robot is first initialized
    @Override
    public void robotInit() {
        // Initialize the drive base and add it to the list of subsystems
        driveBase = new DriveBase();
        subsystems.add(driveBase);

        // Add a simple drive command to the command stack
        commands.push(new SimpleDriveCommand(this));

        // Start executing the first command
        switchToNextCommand();
    }

    // A common update function called during autonomous and tele-operated mode
    private void update() {
        // Update all of the subsystems
        updateSubsystems();

        // Update the current command, and if it has completed execution, switch to the next command
        if (currentCommand.update()) {
            switchToNextCommand();
        }
    }

    // Stop the current command and start executing the next one
    private void switchToNextCommand() {
        // Pop the next command off the stack and set the current command
        currentCommand = commands.pop();

        // Call the command's initializer function
        currentCommand.init();
    }

    // Called as often as possible during autonomous mode
    @Override
    public void autonomousPeriodic() {
        // Call the common update function
        update();
    }

    // Called as often as possible during tele-operated mode
    public void teleopPeriodic() {
        // Call the common update function
        update();
    }
}
