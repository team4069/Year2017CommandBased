package frc.team4069.robot.wrappers;

import com.ctre.CANTalon;

public class CANTalonMotor extends Motor {
    private CANTalon talon;

    public CANTalonMotor(int portNumber) {
        talon = new CANTalon(portNumber);
    }

    @Override
    public void update() {

    }

    @Override
    public void stop() {
        talon.set(0);
    }

    @Override
    public void setSpeed(double speed) {
        super.setSpeed(speed);
        talon.set(speed);
    }
}
