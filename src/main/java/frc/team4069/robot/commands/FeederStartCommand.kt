package frc.team4069.robot.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team4069.robot.Robot

class FeederStartCommand : Command() {

    override fun initialize() {
        requires(Robot.feeder)

        Robot.feeder.start()
    }

    override fun isFinished(): Boolean {
        return true
    }
}
