package frc.team4069.robot.commands;

// An example command for driving straight for 3 meters
public class SimpleDriveCommand extends CommandBase {

    // Called to initialize the drive base
    protected void initialize() {
        // Claim exclusive use of the drive base
        requires(driveBase);
        // Start driving straight at 50% speed
        driveBase.driveContinuousSpeed(0, 0.5);
    }

    // Called to check whether this command has completed
    protected boolean isFinished() {
        // The command has finished if and only if the drive base has traveled 3 meters
        return driveBase.getDistanceTraveledMeters() >= 3;
    }

    // Called when the command is exiting
    protected void end() {
        // Stop driving and coast to a halt
        driveBase.stop();
    }
}
