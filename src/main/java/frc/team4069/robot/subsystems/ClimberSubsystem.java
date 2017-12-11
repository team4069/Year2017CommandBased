package frc.team4069.robot.subsystems;

import frc.team4069.robot.io.IOMapping;
import frc.team4069.robot.motors.TalonMotor;

public class ClimberSubsystem extends SubsystemBase {

    private static ClimberSubsystem instance;

    private TalonMotor climberMotor;

    private double speed = 1;

    private ClimberSubsystem() {
        this.climberMotor = new TalonMotor(IOMapping.CLIMBER_PWM);
    }


    public static ClimberSubsystem getInstance() {
        if(instance == null) {
            instance = new ClimberSubsystem();
        }

        return instance;
    }

    public boolean isStarted() {
        return climberMotor.getSpeed() == speed;
    }

    public void start() {
        climberMotor.setSpeed(speed);
    }

    public void stop() {
        climberMotor.setSpeed(0);
    }
}
