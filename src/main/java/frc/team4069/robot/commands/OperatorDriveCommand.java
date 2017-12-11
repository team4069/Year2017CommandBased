package frc.team4069.robot.commands;

import frc.team4069.robot.io.Input;

// The main command for operator control of the drive base
public class OperatorDriveCommand extends CommandBase {

    // Multiplier applied to the joystick's X axis to get the inverse turning radius
    private final double xAxisMultiplier = 5.0;

    // Called to initialize the drive base
    protected void initialize() {
        // Claim exclusive use of the drive base
        requires(driveBase);
        // It should start out idle
        driveBase.stop();
    }

    // Called frequently while this command is being run
    protected void execute() {
        // Set drive base speeds using the joystick inputs
        // The inverse turning radius should be a direct multiple of the joystick X axis
        double inverseTurningRadius = Input.getSteeringAxis() * xAxisMultiplier;
        // Use the negative of the joystick's Y axis as the speed of the drive base
        double speed = -Input.getSpeedAxis();
        // Set the speed of the robot
        driveBase.driveContinuousSpeed(inverseTurningRadius, speed);
    }

    // Called to check whether this command has completed
    protected boolean isFinished() {
        // Always return false because this command should never finish
        return false;
    }
}
