package frc.team4069.robot.commands;

// An example command for driving straight five meters
public class SimpleDriveCommand extends CommandBase {

    // Called to initialize the drive base
    protected void initialize() {
        System.out.println("Init");

        // Claim exclusive use of the drive base
        requires(driveBase);

        // Start driving straight at 50% speed
        driveBase.driveContinuousSpeed(0, 0.5);
    }

    // Called to check whether this command has completed
    protected boolean isFinished() {
        // Check whether or not the drive base has driven 5 meters
        if (driveBase.getDistanceTraveledMeters() >= 5) {
            // Return true, meaning that the command has completed
            return true;
        } else {
            // Otherwise, return false, meaning that the command is still running
            return false;
        }
    }
}
