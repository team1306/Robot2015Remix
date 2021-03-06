package org.usfirst.frc.team1306.robot.commands;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MonitorRobot extends Command {

    public MonitorRobot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	setRunWhenDisabled(true);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("Elevator Height", RobotMap.elevatorEncoder.getDistance());
    	SmartDashboard.putNumber("Dart Position", RobotMap.grabberMotor.getPosition());
    	SmartDashboard.putNumber("Dart Setpoint", RobotMap.grabberMotor.getSetpoint());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
