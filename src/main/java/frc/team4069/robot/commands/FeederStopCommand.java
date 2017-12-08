package frc.team4069.robot.commands;

public class FeederStopCommand extends CommandBase {

    @Override
    protected void initialize() {
        feeder.stop();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
