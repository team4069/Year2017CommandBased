package frc.team4069.robot.commands;

// A command that simply ensures the drive base remains idle
public class DriveBaseIdleCommand extends CommandBase {

    // Called to initialize the drive base
    protected void initialize() {
        // Claim exclusive use of the drive base
        requires(driveBase);

        // Tell the drive base to stop immediately
        driveBase.stop();
    }

    // This command should always return that it has completed
    protected boolean isFinished() {
        return true;
    }
}
