package frc.team4069.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4069.robot.subsystems.DriveBase;

// A generic command class that contains references to all of the subsystems and initializes them
public abstract class CommandBase extends Command {

    // An instance of the drive base
    static DriveBase driveBase;

    // An function that handles initialization of subsystems
    public static void init() {
        // Get the singleton instance of the drive base
        driveBase = DriveBase.getInstance();
    }

    // A function called periodically to update all subsystems
    public static void update() {
        driveBase.update();
    }
}
