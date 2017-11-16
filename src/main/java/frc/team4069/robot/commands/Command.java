package frc.team4069.robot.commands;

import frc.team4069.robot.core.Robot;

// General-purpose commands that controls all of the robot's hardware until it exits
public abstract class Command {

    // A private reference to the main robot class
    Robot robot;

    // A constructor that sets the global reference to the main robot class
    Command(Robot robot) {
        this.robot = robot;
    }

    // An initializer function in which the commands can perform configuration
    // Called when a commands begins executing, not when it is initialized
    public abstract void init();

    // A function in which the commands does what it does and returns a Boolean which is true
    // if the commands has finished and false if it must continue executing
    public abstract boolean update();
}
