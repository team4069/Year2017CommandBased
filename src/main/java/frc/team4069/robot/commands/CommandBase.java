package frc.team4069.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4069.robot.subsystems.DriveBaseSubsystem;
import frc.team4069.robot.subsystems.ElevatorSubsystem;
import frc.team4069.robot.subsystems.FeederSubsystem;

// A generic command class that contains references to all of the subsystems and initializes them
public abstract class CommandBase extends Command {

    // An instance of the drive base
    static DriveBaseSubsystem driveBase;
    // An instance of the elevator
    static ElevatorSubsystem elevator;
    // An instance of the feeder
    static FeederSubsystem feeder;

    // An function that handles initialization of subsystems
    public static void init() {
        // Get the singleton instance of each of the subsystems
        driveBase = DriveBaseSubsystem.getInstance();
        elevator = ElevatorSubsystem.getInstance();
        feeder = FeederSubsystem.getInstance();
    }

    // A function called periodically to update all subsystems
    public static void update() {
        // Update each of the subsystems that need updating
        driveBase.update();
    }
}
