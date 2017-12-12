package frc.team4069.robot.commands;

import frc.team4069.robot.io.Input;

// The main command for operator control of the drive base
public class OperatorDriveCommand extends CommandBase {

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
        // The turning coefficient should be equal to the steering axis
        double turningCoefficient = Input.getSteeringAxis();
        // Use the negative of the joystick's speed axis as the speed of the drive base
        double speed = -Input.getSpeedAxis();
        // Set the speed of the robot
        driveBase.driveContinuousSpeed(turningCoefficient, speed);
    }

    // Called to check whether this command has completed
    protected boolean isFinished() {
        // Always return false because this command should never finish
        return false;
    }
}
