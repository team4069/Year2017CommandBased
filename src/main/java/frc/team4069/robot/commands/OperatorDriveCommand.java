package frc.team4069.robot.commands;

import frc.team4069.robot.io.Input;

// The main command for operator control of the drive base
public class OperatorDriveCommand extends CommandBase {

    // The angle to which we are currently quick turning (0 means quick turn is not being used)
    int quickTurnAngle = 0;

    // Constructor, used to claim subsystems
    public OperatorDriveCommand() {
        // Claim exclusive use of the drive base
        requires(driveBase);
    }

    // Called to initialize the drive base
    protected void initialize() {
        // It should start out idle
        driveBase.stop();
    }

    // Called frequently while this command is being run
    protected void execute() {
        // Set drive base speeds using the joystick inputs
        // The turning coefficient should be equal to the steering axis
        double turningCoefficient = Input.getSteeringAxis();
        // Use the negative of the joystick's speed axis as the speed of the drive base
        double speed = -Input.getSpeedAxis();
        // Set the speed of the robot
        driveBase.driveContinuousSpeed(turningCoefficient, speed);

        // If the driver is using the regular controls
        if (turningCoefficient != 0 || speed != 0) {
            // Disable quick turn
            quickTurnAngle = 0;
        }

        // Get output from the directional pad
        int directionalPadAngle = Input.getDirectionalPadAngleDegrees();
        // If the directional pad is being used (the output is not -1)
        if (directionalPadAngle != -1) {
            // If the angle is greater than 180
            if (directionalPadAngle > 180) {
                // Subtract 360 so that the robot rotates in the opposite direction
                directionalPadAngle -= 360;
            }
            // Set the quick turn angle to the angle of the directional pad
            quickTurnAngle = directionalPadAngle;
        }
    }

    // Called to check whether this command has completed
    protected boolean isFinished() {
        // Always return false because this command should never finish
        return false;
    }
}
