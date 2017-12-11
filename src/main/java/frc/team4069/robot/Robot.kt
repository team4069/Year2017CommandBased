package frc.team4069.robot

import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.command.Scheduler
import frc.team4069.robot.commands.OperatorControlCommand
import frc.team4069.robot.commands.SimpleDriveCommand
import frc.team4069.robot.io.Input
import frc.team4069.robot.subsystems.DriveBaseSubsystem
import frc.team4069.robot.subsystems.ElevatorSubsystem
import frc.team4069.robot.subsystems.FeederSubsystem
import frc.team4069.robot.subsystems.ShooterSubsystem

// The core robot class that calls everything else
class Robot : IterativeRobot() {

    companion object {
        lateinit var driveBase: DriveBaseSubsystem
        lateinit var elevator: ElevatorSubsystem
        lateinit var feeder: FeederSubsystem
        lateinit var shooter: ShooterSubsystem
    }

    // An instance of the command scheduler
    private lateinit var scheduler: Scheduler

    // Called when the robot first starts up
    override fun robotInit() {
        // Initialize the joystick input class
        Input.init()
        // Set the instance of the scheduler
        scheduler = Scheduler.getInstance()
        // Initialize all subsystems
        initSubsystems()
    }

    // Called at the beginning of autonomous mode
    override fun autonomousInit() {
        // Add a simple drive drive command to the scheduler
        scheduler.add(SimpleDriveCommand())
    }

    // Called at the beginning of tele-operated mode
    override fun teleopInit() {
        // Remove all commands from the scheduler so no autonomous tasks continue running
        scheduler.removeAll()
        // Add an operator control command to the scheduler which should never exit
        scheduler.add(OperatorControlCommand())
    }

    // A universal update method that is called during both autonomous and operator control
    private fun universalPeriodic() {
        // Update all subsystems
        driveBase.update()
        // Update the scheduler
        scheduler.run()
    }

    // Called often during autonomous mode
    override fun autonomousPeriodic() {
        // Call the universal update method
        universalPeriodic()
    }

    // Called often during operator control mode
    override fun teleopPeriodic() {
        // Call the universal update method
        universalPeriodic()
    }

    private fun initSubsystems() {
        driveBase = DriveBaseSubsystem.instance
        shooter = ShooterSubsystem.instance
        feeder = FeederSubsystem.instance
        elevator = ElevatorSubsystem.instance
    }
}
