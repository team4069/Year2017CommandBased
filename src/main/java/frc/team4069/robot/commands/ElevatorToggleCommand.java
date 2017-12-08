package frc.team4069.robot.commands;

public class ElevatorToggleCommand extends CommandBase {

    @Override
    protected void initialize() {
        if(elevator.isStarted()) {
            elevator.stop();
        }else {
            elevator.start();
        }
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
