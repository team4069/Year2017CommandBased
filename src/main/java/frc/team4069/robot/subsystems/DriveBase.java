package frc.team4069.robot.subsystems;

// A class that manages all hardware components of the drive base and provides utility functions
// for instructing it to drive and turn in a variety of ways
public class DriveBase extends Subsystem {

    // An instance of the state enum that is used to remember what the drive base is currently doing
    private DriveBaseState state = DriveBaseState.IDLE;

    // A variable that records the distance traveled since the last state change in meters
    private double distanceTraveledMeters;

    // A public getter for the distance traveled in meters
    public double getDistanceTraveledMeters() {
        return distanceTraveledMeters;
    }

    // Update the hardware depending on what state the drive base is currently in
    public void update() {

        // Switch on the current state
        switch (state) {
            // The robot is not currently doing anything
            case IDLE:
                // Do nothing
                break;
            // The robot is driving
            case DRIVE:
                // Do nothing for now
                break;
        }
    }

    // Stop driving
    public void stop() {

        // Set the current state
        state = DriveBaseState.IDLE;

        // Do nothing else for now
    }

    // Start driving with a given inverse turning radius and speed from zero to one
    public void drive(double inverseTurningRadius, double speed) {

        // Set the current state
        state = DriveBaseState.DRIVE;

        // Reset the distance counter to zero
        distanceTraveledMeters = 0;

        // Do nothing else for now
    }

    // An enum that contains the possible states of the robot
    private enum DriveBaseState {
        IDLE,
        DRIVE
    }
}
