package frc.team4069.robot.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team4069.robot.Robot

// An example command for driving straight five meters
class SimpleDriveCommand : Command() {

    // Called to initialize the drive base
    override fun initialize() {
        // Claim exclusive use of the drive base
        requires(Robot.driveBase)
        // Start driving straight at 50% speed
        Robot.driveBase.driveContinuousSpeed(0.0, 0.5)
    }

    // Called to check whether this command has completed
    override fun isFinished(): Boolean = Robot.driveBase.distanceTraveledMeters >= 5
}
