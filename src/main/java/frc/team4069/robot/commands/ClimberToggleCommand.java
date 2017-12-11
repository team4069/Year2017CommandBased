package frc.team4069.robot.commands;

public class ClimberToggleCommand extends CommandBase {

    @Override
    protected void initialize() {
        if(climber.isStarted()) {
            climber.stop();
        }else {
            climber.start();
        }
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
