package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grabber extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Grabber() {
		RobotMap.grabberMotor.setSafetyEnabled(false);
		RobotMap.grabberMotor.changeControlMode(ControlMode.Position);
		RobotMap.grabberMotor.setFeedbackDevice(FeedbackDevice.AnalogPot);
		RobotMap.grabberMotor.reverseOutput(true);
		RobotMap.grabberMotor.setPID(0.005, 0.0, 0.0);
		RobotMap.grabberMotor.enableControl();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void clamp() {
    	RobotMap.grabberMotor.setPosition(220);
    }
    
    public void release() {
    	RobotMap.grabberMotor.setPosition(350);
    }
    
    public boolean isClamped() {
    	return Math.abs(RobotMap.grabberMotor.getPosition() - RobotMap.grabberMotor.getSetpoint()) < 10;
    }
    
    public boolean isReleased() {
    	return RobotMap.grabberMotor.isRevLimitSwitchClosed();
    }
    
    public void stop() {
    	RobotMap.grabberMotor.setPosition(RobotMap.grabberMotor.getPosition());
    }
}

