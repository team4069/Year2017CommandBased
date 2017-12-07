package frc.team4069.robot.commands;

import frc.team4069.robot.OI;

// The main command for tele-op control
public class OperatorControlCommand extends CommandBase {

    // Multiplier applied to the joystick's X axis to get the inverse turning radius
    private final double xAxisMultiplier = 5.0;

    // Called to initialize the drive base
    protected void initialize() {
        // Claim exclusive use of the drive base
        requires(driveBase);
        // The drive base should start out idle
        driveBase.stop();
    }

    // Set drive base speeds using the joystick inputs
    protected void execute() {
        // The inverse turning radius should be a direct multiple of the joystick X axis
        double inverseTurningRadius = OI.getDriveX() * xAxisMultiplier;
        // Use the joystick's Y axis as the speed of the drive base
        double speed = OI.getDriveY();
        // Set the speed of the robot
        driveBase.driveContinuousSpeed(inverseTurningRadius, speed);
    }

    // Called to check whether this command has completed
    protected boolean isFinished() {
        // Always return false because this command should never finish
        return false;
    }

}
