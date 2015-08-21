package org.usfirst.frc.team1306.robot.commands.elevator;

import org.usfirst.frc.team1306.robot.OI;
import org.usfirst.frc.team1306.robot.RobotMap;
import org.usfirst.frc.team1306.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Gets input from Joystick and converts it into elevator speed and direction.
 * Calculates location compared to Level and prints to SmartDashboard
 */
public class RunElevator extends Command {

	private final OI oi;

	private static double height;

	public RunElevator() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(RobotMap.elevator);
		oi = RobotMap.oi;
	}

	/**
	 * This method is called just before this Command runs the first time.
	 */
	protected void initialize() {

	}

	/**
	 * This method is called repeatedly when this Command is scheduled to run.
	 */
	protected void execute() {

		RobotMap.elevator.drive(oi.elevatorDir());

		height = RobotMap.ELEVATOR_ENCODER.getDistance();
		String level;
		if (height < Elevator.Level.ZERO.getHeight() - TOLERANCE) {
			level = "<0";
		} else if (height < Elevator.Level.ZERO.getHeight() + TOLERANCE){
			level = "0";
		} else if (height < Elevator.Level.ONE.getHeight() - TOLERANCE) {
			level = "0-1";
		} else if (height < Elevator.Level.ONE.getHeight() + TOLERANCE) {
			level = "1";
		} else if (height < Elevator.Level.TWO.getHeight() - TOLERANCE) {
			level = "1-2";
		} else if (height < Elevator.Level.TWO.getHeight() + TOLERANCE) {
			level = "2";
		} else if (height < Elevator.Level.THREE.getHeight() - TOLERANCE) {
			level = "2-3";
		} else if (height < Elevator.Level.THREE.getHeight() + TOLERANCE) {
			level = "3";
		} else {
			level = ">3";
		}
		SmartDashboard.putString("Level", level);

	}

	/**
	 * This method returns true when this Command no longer needs to run
	 * execute().
	 */
	protected boolean isFinished() {
		return false;
	}

	/**
	 * This method called once after isFinished returns true.
	 */
	protected void end() {
		RobotMap.elevator.stop();
	}

	/**
	 * This method called when another command which requires one or more of the
	 * same subsystems is scheduled to run
	 */
	protected void interrupted() {
		end();
	}

	//absolute tolerance, in encoder ticks
	private static final int TOLERANCE = 5;
}
