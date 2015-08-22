package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grabber extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Grabber() {
		RobotMap.grabberMotor.setSafetyEnabled(false);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void clamp() {
    	RobotMap.grabberMotor.set(1.0);
    }
    
    public void release() {
    	RobotMap.grabberMotor.set(-1.0);
    }
    
    public boolean isClamped() {
    	return RobotMap.toteSwitch.get();
    }
    
    public void stop() {
    	RobotMap.grabberMotor.set(0.0);
    }
}

