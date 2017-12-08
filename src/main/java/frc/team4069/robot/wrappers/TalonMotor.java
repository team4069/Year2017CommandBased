package frc.team4069.robot.wrappers;

import edu.wpi.first.wpilibj.Talon;

public class TalonMotor extends Motor {
    Talon talon;

    public TalonMotor(int portNumber) {
        talon = new Talon(portNumber);
    }

    @Override
    public void update() {

    }

    @Override
    public void stop() {
        talon.setSpeed(0);
    }

    @Override
    public void setSpeed(double speed) {
        talon.setSpeed(speed);
    }
}
