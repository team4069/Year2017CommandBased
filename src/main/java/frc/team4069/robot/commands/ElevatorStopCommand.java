package frc.team4069.robot.commands;

public class ElevatorStopCommand extends CommandBase {

    @Override
    protected void initialize() {
        elevator.stop();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
