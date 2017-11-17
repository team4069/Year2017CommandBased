package frc.team4069.robot.subsystems;


// A class that manages all hardware components of the drive base and provides utility functions
// for instructing it to drive and turn in a variety of ways
public class DriveBase extends Subsystem {

    // The horizontal distance from the center of the robot to the outer wheels
    private final double halfRobotWidthMeters = 0.5;

    // Left and right drive motors
    private Motor leftDriveMotor = new Motor(1);
    private Motor rightDriveMotor = new Motor(2);

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
            // The drive base is currently doing nothing
            case IDLE:
                // Do nothing
                break;

            // The robot is driving at a continuous speed
            case DRIVE_CONTINUOUS_SPEED:
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
    public void driveContinuousSpeed(double inverseTurningRadiusMeters, double speed) {
        // Set the current state
        state = DriveBaseState.DRIVE_CONTINUOUS_SPEED;

        // Reset the distance counter to zero
        distanceTraveledMeters = 0;

        // Multiply half the width of the robot by the inverse of the turning radius to get
        // a value for the proportion of the overall speed that this wheel must travel at
        // For instance, if the overall turning radius is 1, and the distance between the wheels
        // is 1, then the left wheel will have to go triple the speed of the left wheel because
        // the circle is three times the size
        // For example, 0.5 (half the distance between the wheels) times the 1 (the turning
        // radius) equals 0.5
        double individualWheelSpeedRelativeToAverage =
                halfRobotWidthMeters * inverseTurningRadiusMeters;

        // The left wheel and right wheel speeds are each 1 +/- (respectively) the individual wheel
        // speed proportion calculated in the last step, assuming the overall speed is scaled to 1
        // This means they must be multiplied by the overall speed to get the final wheel speeds
        // Continuing the previous example, assuming the overall speed of the robot is scaled to 1,
        // indeed the left wheel should rotate at a speed of 1.5 (1 + 0.5)
        // and the right wheel should rotate at 0.5 (1 - 0.5)
        double leftWheelSpeed = (1 + individualWheelSpeedRelativeToAverage) * speed;
        double rightWheelSpeed = (1 - individualWheelSpeedRelativeToAverage) * speed;

        // Set the motor speeds with the previous calculated values
        leftDriveMotor.setSpeed(leftWheelSpeed);
        rightDriveMotor.setSpeed(rightWheelSpeed);
    }

    // An enum that contains the possible states of the robot
    private enum DriveBaseState {
        IDLE,
        DRIVE_CONTINUOUS_SPEED
    }
}
