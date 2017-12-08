package frc.team4069.robot.commands;

public class ElevatorStartCommand extends CommandBase {

    @Override
    protected void initialize() {
        elevator.start();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
