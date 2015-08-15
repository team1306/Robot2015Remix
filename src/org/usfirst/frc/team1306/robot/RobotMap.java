package org.usfirst.frc.team1306.robot;

import org.usfirst.frc.team1306.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.hal.CanTalonSRX;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;

	// Drive train motors
	public static SpeedController DRIVE_FRONT_LEFT;
	public static SpeedController DRIVE_REAR_LEFT;
	public static SpeedController DRIVE_FRONT_RIGHT;
	public static SpeedController DRIVE_REAR_RIGHT;

	public static RobotDrive DRIVETRAIN;

	public static Relay LIGHTS;

	// Misc inputs
	public static DigitalInput ELEVATOR_BOTTOM_LIMIT;
	public static DigitalInput ELEVATOR_TOP_LIMIT;
	public static DigitalInput TOTE_SWITCH;
	public static Gyro GYRO;
	public static Accelerometer ACCEL;
	public static AnalogInput SONIC;
	public static Encoder DRIVE_FRONT_LEFT_ENCODER;
	public static Encoder DRIVE_REAR_LEFT_ENCODER;
	public static Encoder DRIVE_FRONT_RIGHT_ENCODER;
	public static Encoder DRIVE_REAR_RIGHT_ENCODER;

	// Manipulator actuators
	public static Talon ELEVATOR_MOTOR;
	public static Encoder ELEVATOR_ENCODER;
	public static CanTalonSRX GRABBER_MOTOR;
	public static Encoder GRABBER_ENCODER;

	// Operator Interface
	public static OI oi;
	
	public static Elevator elevator;

	static void init() {
		/*
		 * DRIVE_FRONT_LEFT = new PIDMotor(new Talon(0),
		 * DRIVE_FRONT_LEFT_ENCODER); DRIVE_REAR_LEFT = new PIDMotor(new
		 * Talon(1), DRIVE_REAR_LEFT_ENCODER); DRIVE_FRONT_RIGHT = new
		 * PIDMotor(new Talon(2), DRIVE_FRONT_RIGHT_ENCODER); DRIVE_REAR_RIGHT =
		 * new PIDMotor(new Talon(3), DRIVE_REAR_RIGHT_ENCODER);
		 */

		DRIVE_FRONT_LEFT = new Talon(1);
		DRIVE_REAR_LEFT = new Talon(3);
		DRIVE_FRONT_RIGHT = new Talon(0);
		DRIVE_REAR_RIGHT = new Talon(2);

		DRIVETRAIN = new RobotDrive(DRIVE_FRONT_LEFT, DRIVE_REAR_LEFT,
				DRIVE_FRONT_RIGHT, DRIVE_REAR_RIGHT);
		DRIVETRAIN.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, false);
		DRIVETRAIN.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		DRIVETRAIN.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);
		DRIVETRAIN.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

		LIGHTS = new Relay(0);
		LIGHTS.set(Value.kForward);

		ELEVATOR_BOTTOM_LIMIT = new DigitalInput(1);
		ELEVATOR_TOP_LIMIT = new DigitalInput(0);
		TOTE_SWITCH = new DigitalInput(2);
		GYRO = new Gyro(0);
		ACCEL = new BuiltInAccelerometer();
		SONIC = new AnalogInput(1);

		ELEVATOR_MOTOR = new Talon(4);
		ELEVATOR_ENCODER = new Encoder(18, 19);

		GRABBER_MOTOR = new CanTalonSRX(0);

		oi = new OI();
		
		elevator = new Elevator();
	}
}
