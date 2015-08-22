package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;
import org.usfirst.frc.team1306.robot.commands.TeleopDrive;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MecanumDrive extends Subsystem {

	public MecanumDrive() {
	}

	public void initDefaultCommand() {
		setDefaultCommand(new TeleopDrive());
	}

	public void drive(double x, double y, double rotation) {
		RobotMap.drivetrain.mecanumDrive_Cartesian(-x, y, -rotation, 0.0);
	}

	public void stop() {
		RobotMap.drivetrain.mecanumDrive_Cartesian(0.0, 0.0, 0.0, 0.0);
	}
	
}
