package frc.team4069.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team4069.robot.commands.CommandBase;
import frc.team4069.robot.commands.SimpleDriveCommand;

// The core robot class that calls everything else
class Robot extends IterativeRobot {

    // An instance of the command scheduler
    private Scheduler scheduler;

    // Called when the robot first starts up
    public void robotInit() {
        // Set the instance of the scheduler
        scheduler = Scheduler.getInstance();

        // Initialize all subsystems
        CommandBase.init();
    }

    // Called at the beginning of autonomous mode
    public void autonomousInit() {
        // Add a simple drive drive command to the scheduler
        scheduler.add(new SimpleDriveCommand());

        // Update all subsystems
        CommandBase.update();
    }
}
