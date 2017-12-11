package frc.team4069.robot.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team4069.robot.Robot

class ElevatorStopCommand : Command() {

    override fun initialize() {
//        requires(Robot.elevator)

        Robot.elevator.stop()
    }

    override fun isFinished(): Boolean {
        return true
    }
}
