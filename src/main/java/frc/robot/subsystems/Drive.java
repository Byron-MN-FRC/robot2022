// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Drive extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private WPI_TalonFX leftMaster;
private WPI_TalonFX rightMaster;
private DifferentialDrive differentialDrive;
private PigeonIMU pigeon;
private WPI_TalonFX rightFollower;
private WPI_TalonFX leftFollower;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
double y;
double twist;

TalonFXInvertType _rightInvert = TalonFXInvertType.CounterClockwise; // Same as invert = "false"
TalonFXInvertType _leftInvert = TalonFXInvertType.Clockwise; // Same as invert = "true"
TalonFXConfiguration _rightConfig = new TalonFXConfiguration();
TalonFXConfiguration _leftConfig = new TalonFXConfiguration();
    /**
    *
    */
    public Drive() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
leftMaster = new WPI_TalonFX(3);
 
 

rightMaster = new WPI_TalonFX(1);
 
 

differentialDrive = new DifferentialDrive(leftMaster, rightMaster);
 addChild("differentialDrive",differentialDrive);
 differentialDrive.setSafetyEnabled(true);
differentialDrive.setExpiration(0.1);
differentialDrive.setMaxOutput(1.0);


pigeon = new PigeonIMU(4);
 
 

rightFollower = new WPI_TalonFX(0);
 
 

leftFollower = new WPI_TalonFX(2);
 
 


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
public void JoystickDrive(Joystick joystickP0) {
    y = joystickP0.getY();
    twist = joystickP0.getZ();
  //  DifferentialDrive.arcadeDriveIK(Math.pow(y, 5), Math.pow(twist, 5), false);
    differentialDrive.arcadeDrive(-Math.pow(twist, 5),Math.pow(y, 5));
}
// public void motorConfigFalcon() {
//     // Factory default all motors initially
//     rightMaster.configFactory Default();
//     rightFollower.configFactoryDefault();
//     leftMaster.configFactoryDefault();
//     leftFollower.configFactoryDefault();

//     // Set Neutral Mode
//     leftMaster.setNeutralMode(NeutralMode.Brake);
//     leftFollower.setNeutralMode(NeutralMode.Brake);
//     rightMaster.setNeutralMode(NeutralMode.Brake);
//     rightFollower.setNeutralMode(NeutralMode.Brake);

//     // Configure output and sensor direction
//     leftMaster.setInverted(_leftInvert);
//     leftFollower.setInverted(_leftInvert);
//     rightMaster.setInverted(_rightInvert);
//     rightFollower.setInverted(_rightInvert);

//     // configure the max current for motor. Thought is that
//     // other motors will follow.
//     double ampLimit = SmartDashboard.getNumber(Constants.kAmpLimitName_DT, Constants.kAmpLimit_DT);
//     double ampPeakLimit = SmartDashboard.getNumber(Constants.kAmpPeakLimitName_DT, Constants.kAmpPeak_DT);

//     SupplyCurrentLimitConfiguration currentLimitingFalcons = new SupplyCurrentLimitConfiguration(
//             Constants.kEnableCurrentLimiting_DT, ampLimit, ampPeakLimit, Constants.kthreshholdTime);

//     rightMaster.configSupplyCurrentLimit(currentLimitingFalcons);

//     // Reset Pigeon Configs
//     pigeon.configFactoryDefault();

//     _leftConfig.primaryPID.selectedFeedbackSensor = FeedbackDevice.IntegratedSensor; // Local Feedback Source

//     // * Configure the Remote (Left) Talon's selected sensor as a remote sensor for
//     // * the right Talon

//     _rightConfig.remoteFilter0.remoteSensorDeviceID = leftMaster.getDeviceID(); // Device ID of Remote Source
//     _rightConfig.remoteFilter0.remoteSensorSource = RemoteSensorSource.TalonSRX_SelectedSensor; // Remote Source
//                                                                                                 // Type

//     // * Now that the Left sensor can be used by the master Talon, set up the Left
//     // * (Aux) and Right (Master) distance into a single Robot distance as the
//     // * Master's Selected Sensor 0.

//     setRobotDistanceConfigs(_rightInvert, _rightConfig);
//     // FPID for Distance
//     _rightConfig.slot0.kF = Constants.kGains_Distanc.kF;
//     _rightConfig.slot0.kP = Constants.kGains_Distanc.kP;
//     _rightConfig.slot0.kI = Constants.kGains_Distanc.kI;
//     _rightConfig.slot0.kD = Constants.kGains_Distanc.kD;
//     _rightConfig.slot0.integralZone = Constants.kGains_Distanc.kIzone;
//     _rightConfig.slot0.closedLoopPeakOutput = Constants.kGains_Distanc.kPeakOutput;

//     // * Heading Configs
//     _rightConfig.remoteFilter1.remoteSensorDeviceID = pigeon.getDeviceID(); // Pigeon Device ID
//     _rightConfig.remoteFilter1.remoteSensorSource = RemoteSensorSource.Pigeon_Yaw; // This is for a Pigeon over CAN
//     _rightConfig.auxiliaryPID.selectedFeedbackSensor = FeedbackDevice.RemoteSensor1; // Set as the Aux Sensor
//     _rightConfig.auxiliaryPID.selectedFeedbackCoefficient = 3600.0 / Constants.kPigeonUnitsPerRotation; // Convert
//                                                                                                         // Yaw to
//                                                                                                         // tenths of
//                                                                                                         // a degree

//     // * false means talon's local output is PID0 + PID1, and other side Talon is
//     // PID0
//     // * - PID1 This is typical when the master is the right Talon FX and using
//     // Pigeon
//     // *
//     // * true means talon's local output is PID0 - PID1, and other side Talon is
//     // PID0
//     // * + PID1 This is typical when the master is the left Talon FX and using
//     // Pigeon

//     _rightConfig.auxPIDPolarity = false;
//     // FPID for Heading
//     _rightConfig.slot1.kF = Constants.kGains_Turning.kF;
//     _rightConfig.slot1.kP = Constants.kGains_Turning.kP;
//     _rightConfig.slot1.kI = Constants.kGains_Turning.kI;
//     _rightConfig.slot1.kD = Constants.kGains_Turning.kD;
//     _rightConfig.slot1.integralZone = Constants.kGains_Turning.kIzone;
//     _rightConfig.slot1.closedLoopPeakOutput = Constants.kGains_Turning.kPeakOutput;

//     // Config the neutral deadband.
//     _leftConfig.neutralDeadband = Constants.kNeutralDeadband;
//     _rightConfig.neutralDeadband = Constants.kNeutralDeadband;

//     // *
//     // * 1ms per loop. PID loop can be slowed down if need be. For example, - if
//     // * sensor updates are too slow - sensor deltas are very small per update, so
//     // * derivative error never gets large enough to be useful. - sensor movement is
//     // * very slow causing the derivative error to be near zero.

//     int closedLoopTimeMs = 1;
//     rightMaster.configClosedLoopPeriod(0, closedLoopTimeMs, Constants.kTimeoutMs);
//     rightMaster.configClosedLoopPeriod(1, closedLoopTimeMs, Constants.kTimeoutMs);

//     // Motion Magic Configs
//     _rightConfig.motionAcceleration = 9500; // (distance units per 100 ms) per second
//     _rightConfig.motionCruiseVelocity = 17000; // distance units per 100 ms

//     // APPLY the config settings
//     leftMaster.configAllSettings(_leftConfig);
//     leftFollower.configAllSettings(_leftConfig);
//     rightMaster.configAllSettings(_rightConfig);
//     rightFollower.configAllSettings(_rightConfig);

//     // Set status frame periods to ensure we don't have stale data

//     // * These aren't configs (they're not persistant) so we can set these after the
//     // * configs.

//     rightMaster.setStatusFramePeriod(StatusFrame.Status_12_Feedback1, 20, Constants.kTimeoutMs);
//     rightMaster.setStatusFramePeriod(StatusFrame.Status_13_Base_PIDF0, 20, Constants.kTimeoutMs);
//     rightMaster.setStatusFramePeriod(StatusFrame.Status_14_Turn_PIDF1, 20, Constants.kTimeoutMs);
//     rightMaster.setStatusFramePeriod(StatusFrame.Status_10_Targets, 10, Constants.kTimeoutMs);
//     leftMaster.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 5, Constants.kTimeoutMs);
//     pigeon.setStatusFramePeriod(PigeonIMU_StatusFrame.CondStatus_9_SixDeg_YPR, 5, Constants.kTimeoutMs);

//     rightFollower.follow(rightMaster);
//     leftFollower.follow(leftMaster);
//     // WPI drivetrain classes assume by default left & right are opposite
//     // - call this to apply + to both sides when moving forward


//     // set on call from autonomous
//     rightMaster.selectProfileSlot(Constants.kSlot_Distanc, Constants.PID_PRIMARY);
//     rightMaster.selectProfileSlot(Constants.kSlot_Turning, Constants.PID_TURN);

// }
}

