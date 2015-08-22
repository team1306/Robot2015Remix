package org.usfirst.frc.team1306.robot.commands;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleopDrive extends Command {

    public TeleopDrive() {
        super("Drive");
        requires(RobotMap.drivetrainSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		RobotMap.drivetrainSystem.stop();
		RobotMap.drivetrain.setSafetyEnabled(false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.drivetrainSystem.drive(RobotMap.oi.moveX(), RobotMap.oi.moveY(), RobotMap.oi.rotation());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.drivetrainSystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
