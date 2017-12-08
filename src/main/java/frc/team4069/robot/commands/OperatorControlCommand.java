package frc.team4069.robot.commands;

import frc.team4069.robot.io.Input;

// The main command for operator control
public class OperatorControlCommand extends CommandBase {

    // Multiplier applied to the joystick's X axis to get the inverse turning radius
    private final double xAxisMultiplier = 5.0;

    // Called to initialize the drive base
    protected void initialize() {
        // Claim exclusive use of the drive base and the elevator
        requires(driveBase);
        requires(elevator);
        // Both subsystems should start out idle
        driveBase.stop();
        elevator.stop();
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

        // If the shooter button is being held, spin up the feeder and shooter
//        if (Input.getShooterButton()) {
//            feeder.start();
//        }
        // If it is not being held, stop immediately
//        else {
//            feeder.stop();
//        }
    }

    // Called to check whether this command has completed
    protected boolean isFinished() {
        // Always return false because this command should never finish
        return false;
    }

}
