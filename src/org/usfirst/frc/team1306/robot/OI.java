package org.usfirst.frc.team1306.robot;

import org.usfirst.frc.team1306.robot.commands.elevator.SnapDown;
import org.usfirst.frc.team1306.robot.commands.elevator.SnapUp;
import org.usfirst.frc.team1306.robot.commands.grabber.GrabberClamp;
import org.usfirst.frc.team1306.robot.commands.grabber.GrabberRelease;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	private static final double DEADBAND = 0.15;

	private final XboxController xbox;
	
	private final Button rightBumper, leftBumper;
	private final Button buttonA, buttonB;

	public OI() {
		xbox = new XboxController(0);
		
		rightBumper = new JoystickButton(xbox, XboxController.RB);
		leftBumper = new JoystickButton(xbox, XboxController.LB);
		
		buttonA = new JoystickButton(xbox, XboxController.A);
		buttonB = new JoystickButton(xbox, XboxController.B);
		
		rightBumper.whenPressed(new SnapUp());
		leftBumper.whenPressed(new SnapDown());
		
		buttonA.whenPressed(new GrabberClamp());
		buttonB.whenPressed(new GrabberRelease());
	}

	public double elevatorDir() {
		return xbox.getRT() - xbox.getLT();
	}
	
	/**
	 * Returns the input rounded to zero within the pre-specified deadband.
	 * 
	 * @param value
	 *            Initial value to be rounded
	 * @return Rounded value
	 */
	private double deadband(double original) {
		if (original < -DEADBAND) {
			return (original + DEADBAND) / (1.0 - DEADBAND);
		} else if (original > DEADBAND) {
			return (original - DEADBAND) / (1.0 - DEADBAND);
		} else {
			return 0.0;
		}
	}
}
