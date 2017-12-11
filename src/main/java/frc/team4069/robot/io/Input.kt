package frc.team4069.robot.io

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.Button
import edu.wpi.first.wpilibj.buttons.JoystickButton
import frc.team4069.robot.commands.*

// Class that provides accessors for joystick inputs
object Input {
    // The main joystick
    private lateinit var joystick: Joystick

    lateinit var elevatorStartButton: Button
    lateinit var shooterButton: Button

    // Accessor for the steering axis on the drive joystick
    val steeringAxis: Double
        get() = joystick.getRawAxis(IOMapping.DRIVE_STEERING_AXIS)

    // Accessor for the speed axis on the drive joystick
    val speedAxis: Double
        get() = joystick.getRawAxis(IOMapping.DRIVE_SPEED_AXIS)

    // Initializer that handles mapping of the joysticks to real port numbers
    fun init() {
        joystick = Joystick(IOMapping.DRIVE_JOYSTICK_NUMBER)
        elevatorStartButton = JoystickButton(joystick, IOMapping.ELEVATOR_START_BUTTON)

        // If the elevator is started, we want to stop it. If it isn't, we want to start it.
        elevatorStartButton.whenPressed(ElevatorToggleCommand(ElevatorStopCommand(),
                ElevatorStartCommand()))

        shooterButton = JoystickButton(joystick, IOMapping.SHOOTER_BUTTON).apply {
            whenPressed(FeederStartCommand())
            whenReleased(FeederStopCommand())
        }
    }
}
