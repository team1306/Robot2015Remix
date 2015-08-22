package org.usfirst.frc.team1306.robot.commands.grabber;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GrabberRelease extends Command {

    public GrabberRelease() {
        requires(RobotMap.grabber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.grabber.release();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.grabber.isReleased();
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.grabber.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
