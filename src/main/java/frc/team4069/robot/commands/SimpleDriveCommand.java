package frc.team4069.robot.commands;

import frc.team4069.robot.core.Robot;

// An example command for driving straight five meters
public class SimpleDriveCommand extends Command {

    // Use the constructor provided by the superclass
    public SimpleDriveCommand(Robot robot) {
        super(robot);
    }

    // This command has just begun executing
    public void init() {
        // Set the drive base to drive with an inverse turning radius of zero and a speed of 50%
        this.robot.driveBase.driveContinuousSpeed(0, 0.5);
    }

    // Called several times per second
    public boolean update() {
        // Check whether or not the drive base has driven 5 meters
        if (this.robot.driveBase.getDistanceTraveledMeters() >= 5) {
            // If it has, stop the drive base
            this.robot.driveBase.stop();
            // Return true, meaning that the command has completed
            return true;
        } else {
            // Otherwise, return false, meaning that the command is still running
            return false;
        }

    }
}
