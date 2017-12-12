package frc.team4069.robot.commands;

// A command to stop the shooter and feeder
public class ShooterStopCommand extends CommandBase {

    // Stop running the shooter and feeder when initialized
    @Override
    protected void initialize() {
        shooter.stop();
        feeder.stop();
    }

    // This command does not need to run for any length of time
    @Override
    protected boolean isFinished() {
        return true;
    }
}
