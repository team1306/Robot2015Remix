package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;
import org.usfirst.frc.team1306.robot.commands.elevator.RunElevator;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Elevator extends PIDSubsystem {

	public enum Level {
		ZERO(0), ONE(200), TWO(400), THREE(600);

		private int height;

		private Level(int height) {
			this.height = height;
		}

		public int getHeight() {
			return height;
		}
	}

	// Initialize your subsystem here
	public Elevator() {
		super("Elevator", 0.002, 0.0, 0.0);

		getPIDController().setContinuous(false);
		setInputRange(0.0, 18000.0); // range of encoder values
		setOutputRange(-1.0, 1.0); // range of motor speeds
		setAbsoluteTolerance(TOLERANCE); // tolerance in encoder ticks
		
		RobotMap.elevatorEncoder.setDistancePerPulse(0.00218981931);

		SmartDashboard.putData("Elevator PID", getPIDController());

		RobotMap.elevatorMotor.setSafetyEnabled(false);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new RunElevator());
	}

	protected double returnPIDInput() {
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage;
		return getPoint();
	}

	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);
		if (hitTop() && output > 0.0 || hitBottom() && output < 0.0) {
			output = 0.0;
		}
		RobotMap.elevatorMotor.set(-output);
	}

	public void goTo(Level level) {
		switch (level) {
		case ZERO:
			setSetpoint(Level.ZERO.getHeight());
			break;
		case ONE:
			setSetpoint(Level.ONE.getHeight());
			break;
		case TWO:
			setSetpoint(Level.TWO.getHeight());
			break;
		case THREE:
			setSetpoint(Level.THREE.getHeight());
			break;
		}
		enable();
	}

	public void drive(double speed) {
		if (speed == 0.0) {
			enable();
		} else {
			disable();
			setSetpoint(getPoint());

			if (!(hitTop() && speed > 0 || hitBottom() && speed < 0))
				RobotMap.elevatorMotor.set(-speed);
		}
		SmartDashboard.putBoolean("Hit Top", hitTop());
		SmartDashboard.putBoolean("Hit Bottom", hitBottom());
	}

	public void stop() {
		drive(0.0);
	}

	/**
	 * Gets the elevator's current position
	 * 
	 * @return elevator's position
	 */
	public double getPoint() {
		return RobotMap.elevatorEncoder.getDistance();
	}

	/**
	 * Tells if elevator hits the top
	 * 
	 * @return true if at upper limit
	 */
	public boolean hitTop() {
		return !RobotMap.elevatorTopLimit.get();
	}

	/**
	 * Tells if elevator hits the bottom
	 * 
	 * @return true if at bottom limit
	 */
	public boolean hitBottom() {
		boolean hit = !RobotMap.elevatorBottomLimit.get();
		if (hit) {
			RobotMap.elevatorEncoder.reset();
		}
		return hit;
	}

	public boolean isStopped() {
		return Math.abs(RobotMap.elevatorEncoder.getRate()) < SPEED_TOLERANCE;
	}

	// The maximum distance (in) that the encoder can be from its target and
	// still be considered on target
	public static final double TOLERANCE = 0.5;
	// The maximum speed the elevator can be moving (in/s) and still be
	// considered stopped
	private static final double SPEED_TOLERANCE = 0.5;
}
