/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.*;

public class RobotMap {
  //PWM
	public static final int REAR_LEFT_WHEEL_PORT = 2;
	public static final int REAR_RIGHT_WHEEL_PORT = 1;
	public static final int FRONT_LEFT_WHEEL_PORT = 0;
	public static final int FRONT_RIGHT_WHEEL_PORT = 3;
	public static final int LADDER_PORT = 4;
	public static final int ROBOT_CLAW_ENABLER_PORT = 5;
	

	
	//DIO
	//public static final int FRONT_RIGHT_ENCODER_PORT_1 = 0;
	//public static final int FRONT_RIGHT_ENCODER_PORT_2 = 1;
	//public static final int FRONT_LEFT_ENCODER_PORT_1 = 2;
	//public static final int FRONT_LEFT_ENCODER_PORT_2 = 3;

	//Map values still needs to be mapped, mech's fault
	
	public static final int REAR_LEFT_ENCODER_PORT_1 = 0;
	public static final int REAR_LEFT_ENCODER_PORT_2 = 1;
	public static final int REAR_RIGHT_ENCODER_PORT_1 = 2;
	public static final int REAR_RIGHT_ENCODER_PORT_2 = 3;
	public static final int LADDER_ENCODER_PORT_1 = 4;
	public static final int LADDER_ENCODER_PORT_2 = 5;
	public static final int LADDER_TOP_LIMIT_PORT = 6;
	public static final int LADDER_BOTTOM_LIMIT_PORT = 7;
    
	//PNEUMATIC BOARD (PCM)
	public static final int DISC_SOLENOID_PORT_1 = 2;
	public static final int DISC_SOLENOID_PORT_2 = 1;
	
	//ANALOG IN
	public static final int QTI_SENSOR_PORT = 0;
	public static final int ULTRASONIC_PORT = 1;
	
	public static Talon frontLeftWheel;
	public static Talon frontRightWheel;
	public static Talon rearLeftWheel;
	public static Talon rearRightWheel;
	public static MecanumDrive drive;
	public static Encoder rearLeftEncoder;
	public static Encoder frontRightEncoder;
	public static Encoder frontLeftEncoder;
	public static Encoder rearRightEncoder;
	public static ADXRS450_Gyro gyro;
	public static PWMVictorSPX ladder;
	public static Encoder ladderEncoder;
	public static DigitalInput ladderTopLimit;
	public static DigitalInput ladderBottomLimit;
	public static DoubleSolenoid solenoid;
	public static AnalogInput qtiSensor;
	public static AnalogInput ultrasonicSensor;
	public static Servo servo;
	
	
	public static void init() {
		frontLeftWheel = new Talon(FRONT_LEFT_WHEEL_PORT);
		frontRightWheel = new Talon(FRONT_RIGHT_WHEEL_PORT);
		rearLeftWheel = new Talon(REAR_LEFT_WHEEL_PORT);
		rearRightWheel = new Talon(REAR_RIGHT_WHEEL_PORT);
		drive = new MecanumDrive(frontLeftWheel, frontRightWheel, rearLeftWheel, rearRightWheel);
		servo = new Servo(ROBOT_CLAW_ENABLER_PORT);
		gyro = new ADXRS450_Gyro();
		
		rearLeftEncoder = new Encoder(REAR_LEFT_ENCODER_PORT_1, REAR_LEFT_ENCODER_PORT_2, false, Encoder.EncodingType.k1X);
		rearLeftEncoder.setDistancePerPulse(-0.007266115676069);
		rearRightEncoder = new Encoder(REAR_RIGHT_ENCODER_PORT_1, REAR_RIGHT_ENCODER_PORT_2, false, Encoder.EncodingType.k1X);
		rearRightEncoder.setDistancePerPulse(-0.007604813285879);
		

		ladder = new PWMVictorSPX(LADDER_PORT);
		ladderEncoder = new Encoder(LADDER_ENCODER_PORT_1, LADDER_ENCODER_PORT_2, false, Encoder.EncodingType.k2X);
		ladderTopLimit = new DigitalInput(LADDER_TOP_LIMIT_PORT);
		ladderBottomLimit = new DigitalInput(LADDER_BOTTOM_LIMIT_PORT);
		
		solenoid = new DoubleSolenoid(DISC_SOLENOID_PORT_1, DISC_SOLENOID_PORT_2);
		qtiSensor = new AnalogInput(QTI_SENSOR_PORT);
		ultrasonicSensor = new AnalogInput(ULTRASONIC_PORT);
	}
}
