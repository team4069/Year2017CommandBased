package frc.team4069.robot.commands;

public class FeederStartCommand extends CommandBase {

    @Override
    protected void initialize() {
        feeder.start();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
