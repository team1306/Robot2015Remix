package org.usfirst.frc.team1306.robot.commands.elevator;

import org.usfirst.frc.team1306.robot.RobotMap;
import org.usfirst.frc.team1306.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SnapUp extends Command {

    public SnapUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(RobotMap.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (RobotMap.elevator.getPoint() < Elevator.Level.ONE.getHeight()) {
    		RobotMap.elevator.goTo(Elevator.Level.ONE);
    	} else if (RobotMap.elevator.getPoint() < Elevator.Level.TWO.getHeight()) {
    		RobotMap.elevator.goTo(Elevator.Level.TWO);
    	} else if (RobotMap.elevator.getPoint() < Elevator.Level.THREE.getHeight()) {
    		RobotMap.elevator.goTo(Elevator.Level.THREE);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.elevator.onTarget() && RobotMap.elevator.isStopped();
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.elevator.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
