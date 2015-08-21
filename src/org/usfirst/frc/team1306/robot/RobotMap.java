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
	public static SpeedController driveFrontLeft;
	public static SpeedController driveRearLeft;
	public static SpeedController driveFrontRight;
	public static SpeedController driveRearRight;

	public static RobotDrive drivetrain;

	public static Relay lights;

	// Misc inputs
	public static DigitalInput elevatorBottomLimit;
	public static DigitalInput elevatorTopLimit;
	public static DigitalInput toteSwitch;
	public static Gyro gyro;
	public static Accelerometer accelerometer;
	public static AnalogInput rangeFinder;
	public static Encoder driveFrontLeftEncoder;
	public static Encoder driveRearLeftEncoder;
	public static Encoder driveFrontRightEncoder;
	public static Encoder driveRearRightEncoder;

	// Manipulator actuators
	public static Talon elevatorMotor;
	public static Encoder elevatorEncoder;
	public static CanTalonSRX grabberMotor;
	public static Encoder grabberEncoder;

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

		driveFrontLeft = new Talon(1);
		driveRearLeft = new Talon(3);
		driveFrontRight = new Talon(0);
		driveRearRight = new Talon(2);

		drivetrain = new RobotDrive(driveFrontLeft, driveRearLeft, driveFrontRight, driveRearRight);
		drivetrain.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, false);
		drivetrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		drivetrain.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);
		drivetrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

		lights = new Relay(0);
		lights.set(Value.kForward);

		elevatorBottomLimit = new DigitalInput(1);
		elevatorTopLimit = new DigitalInput(0);
		toteSwitch = new DigitalInput(2);
		gyro = new Gyro(0);
		accelerometer = new BuiltInAccelerometer();
		rangeFinder = new AnalogInput(1);

		elevatorMotor = new Talon(4);
		elevatorEncoder = new Encoder(18, 19);

		grabberMotor = new CanTalonSRX(0);

		oi = new OI();

		elevator = new Elevator();
	}
}
