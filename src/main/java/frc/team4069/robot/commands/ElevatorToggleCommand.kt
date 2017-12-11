package frc.team4069.robot.commands

import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.ConditionalCommand
import frc.team4069.robot.Robot

class ElevatorToggleCommand(onTrue: Command,
                            onFalse: Command) : ConditionalCommand(onTrue, onFalse) {

    override fun condition(): Boolean = Robot.elevator.isStarted

    override fun isFinished(): Boolean {
        return true
    }
}
