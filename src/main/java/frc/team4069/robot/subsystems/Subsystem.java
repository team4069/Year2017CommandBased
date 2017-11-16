package frc.team4069.robot.subsystems;

// A standard superclass for subsystems, classes which interface directly with the hardware and
// have mostly independent functionality, save for an update function
public abstract class Subsystem {

    // A function called on every update that allows subsystems
    // to give frequent and regular instructions to the hardware
    public abstract void update();
}
