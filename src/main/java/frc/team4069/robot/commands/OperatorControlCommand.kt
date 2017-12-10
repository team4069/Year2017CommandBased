package frc.team4069.robot.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team4069.robot.Robot
import frc.team4069.robot.io.Input

// The main command for operator control
class OperatorControlCommand : Command() {

    // Multiplier applied to the joystick's X axis to get the inverse turning radius
    private val xAxisMultiplier = 5.0

    // Called to initialize the drive base
    override fun initialize() {
        // Claim exclusive use of the drive base and the elevator
        requires(Robot.driveBase)
        requires(Robot.elevator)
        // Both subsystems should start out idle
        Robot.driveBase.stop()
        Robot.elevator.stop()
    }

    // Called frequently while this command is being run
    override fun execute() {
        // Set drive base speeds using the joystick inputs
        // The inverse turning radius should be a direct multiple of the joystick X axis
        val inverseTurningRadius = Input.steeringAxis * xAxisMultiplier
        // Use the negative of the joystick's Y axis as the speed of the drive base
        val speed = -Input.speedAxis
        // Set the speed of the robot
        Robot.driveBase.driveContinuousSpeed(inverseTurningRadius, speed)
    }

    // Called to check whether this command has completed
    override fun isFinished(): Boolean {
        // Always return false because this command should never finish
        return false
    }
}
