package frc.team4069.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team4069.robot.commands.CommandBase;
import frc.team4069.robot.commands.OperatorDriveCommand;
import frc.team4069.robot.commands.SimpleDriveCommand;
import frc.team4069.robot.io.Input;

// The core robot class that calls everything else
public class Robot extends IterativeRobot {

    // An instance of the command scheduler
    private Scheduler scheduler;

    // Called when the robot first starts up
    public void robotInit() {
        // Initialize the joystick input class
        Input.init();
        // Set the instance of the scheduler
        scheduler = Scheduler.getInstance();
        // Initialize all subsystems
        CommandBase.init();
    }

    // Called at the beginning of autonomous mode
    public void autonomousInit() {
        // Add a simple drive drive command to the scheduler
        scheduler.add(new SimpleDriveCommand());
    }

    // Called at the beginning of tele-operated mode
    public void teleopInit() {
        // Remove all commands from the scheduler so no autonomous tasks continue running
        scheduler.removeAll();
        // Add an operator control command to the scheduler which should never exit
        scheduler.add(new OperatorDriveCommand());
    }

    // A universal update method that is called during both autonomous and operator control
    private void universalPeriodic() {
        // Update all subsystems
        CommandBase.update();
        // Update the scheduler
        scheduler.run();
    }

    // Called often during autonomous mode
    public void autonomousPeriodic() {
        // Call the universal update method
        universalPeriodic();
    }

    // Called often during operator control mode
    public void teleopPeriodic() {
        // Call the universal update method
        universalPeriodic();
    }
}
