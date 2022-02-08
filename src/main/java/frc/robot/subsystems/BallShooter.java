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


import frc.robot.BallShooterConstants;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.sql.Time;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.Servo;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class BallShooter extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private WPI_TalonFX shootMotor;
private Servo brickWallServo;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    
    public final SupplyCurrentLimitConfiguration currentLimiting = new SupplyCurrentLimitConfiguration(
        BallShooterConstants.kEnableCurrentLimiting_BS, BallShooterConstants.currentLimit,
        BallShooterConstants.thresholdLimit, BallShooterConstants.thresholdTime);
    private double masterShootRPM = 0;
    public BallShooter() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
shootMotor = new WPI_TalonFX(13);
 
 

brickWallServo = new Servo(0);
 addChild("brickWallServo", brickWallServo);
 


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    // brickWallServo.set(0);
    shootMotorConfig();
    }
    
    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        setMasterShootVelocity(masterShootRPM); 
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }
    private int loop = 0;
    public boolean ready2Shoot(final double rpms) {
        // final double velocityPer100ms = rpmToVelocityPer100ms(rpms);
        masterShootRPM = rpms;

        boolean iwthresh = isWithinThreshold();
       
        // report debugging information
        if (++loop >= 15) {
            toConsoleln("ShootTarget=" + rpmToVelocityPer100ms(rpms) + " Cur="
                    + shootMotor.getSelectedSensorVelocity(BallShooterConstants.kPIDLoopIdx) + " Err="
                    + shootMotor.getClosedLoopError(BallShooterConstants.kPIDLoopIdx) + " InThreshold " + iwthresh
                    + shootMotor.getSelectedSensorVelocity(BallShooterConstants.kPIDLoopIdx)*10*60/2048);
            
            toConsoleln("Returning " + (iwthresh));
        }

        // return isWithinThreshold() && hoodAtPosition();
        if (iwthresh) {
            //LimelightUtility.WriteDouble("ledMode", 1); // 1 = Limelight Off
            //LimelightUtility.EnableDriverCamera(true);
        }

       // SmartDashboard.putBoolean("Shooter/ReadyToShoot", iwthresh && hp);

        return iwthresh;
    }
    private void toConsoleln(final String s) {
        if (BallShooterConstants.debug) {
            System.out.println(s);
        }
    }

    private double _withinThresholdLoops = 0;

    /**
     * isWithinThreshold tracks the error reported by the shooter motor and
     * determines if it has "settled". It uses an error threshhold (and a counter
     * (kPIDLoopIdx)to determine if
     * 
     * @return - true if it has settled, otherwise false.
     */
    public boolean isWithinThreshold() {
        /* Check if closed loop error is within the threshld */
        double closedLpErr = Math.abs(shootMotor.getClosedLoopError(BallShooterConstants.kPIDLoopIdx));


        if (closedLpErr < BallShooterConstants.kShootMotorRPMTolerance) {
            ++_withinThresholdLoops;
            toConsoleln("incrementing threshold loops: " + _withinThresholdLoops);
        } else {
            _withinThresholdLoops = 0;
            toConsoleln("restart threshold loops: " + _withinThresholdLoops);
        }

      //  SmartDashboard.putNumber("Shooter/ShootMotorError", closedLpErr);
      //  SmartDashboard.putBoolean("Shooter/ShootMotorReady",_withinThresholdLoops > BallShooterConstants.kLoopsToSettle);

        return (_withinThresholdLoops > BallShooterConstants.kLoopsToSettle);
    }
    public void shootMotorConfig() {
        /* Factory Default all hardware to prevent unexpected behaviour */
        shootMotor.configFactoryDefault();

        /* Config neutral deadband to be the smallest possible */
        shootMotor.configNeutralDeadband(0.001);

        /* Config sensor used for Primary PID [Velocity] */
        shootMotor.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor,
                BallShooterConstants.kPIDLoopIdx, BallShooterConstants.kTimeoutMs);

        /* Config the peak and nominal outputs */
        shootMotor.configNominalOutputForward(0, BallShooterConstants.kTimeoutMs);
        shootMotor.configNominalOutputReverse(0, BallShooterConstants.kTimeoutMs);
        shootMotor.configPeakOutputForward(1, BallShooterConstants.kTimeoutMs);
        shootMotor.configPeakOutputReverse(-1, BallShooterConstants.kTimeoutMs);

        /* Config the Velocity closed loop gains in slot0 */
        shootMotor.config_kF(BallShooterConstants.kPIDLoopIdx, BallShooterConstants.kGains_shootMotor.kF,
                BallShooterConstants.kTimeoutMs);
        shootMotor.config_kP(BallShooterConstants.kPIDLoopIdx, BallShooterConstants.kGains_shootMotor.kP,
                BallShooterConstants.kTimeoutMs);
        shootMotor.config_kI(BallShooterConstants.kPIDLoopIdx, BallShooterConstants.kGains_shootMotor.kI,
                BallShooterConstants.kTimeoutMs);
        shootMotor.config_kD(BallShooterConstants.kPIDLoopIdx, BallShooterConstants.kGains_shootMotor.kD,
                BallShooterConstants.kTimeoutMs);
        /*
         * Talon FX does not need sensor phase set for its integrated sensor This is
         * because it will always be correct if the selected feedback device is
         * integrated sensor (default value) and the user calls getSelectedSensor* to
         * get the sensor's position/velocity.
         * 
         * https://phoenix-documentation.readthedocs.io/en/latest/ch14_MCSensor.html#
         * sensor-phase
         */
        // shootMotor.setSensorPhase(true);

        // Ramp motor w/ current limiting on
        shootMotor.configSupplyCurrentLimit(currentLimiting);
        // shootMotor.configOpenloopRamp(1.75, BallShooterConstants.kTimeoutMs);
        // shootMotor.configClosedloopRamp(.05, BallShooterConstants.kTimeoutMs);
    }
    public double rpmToVelocityPer100ms(final double rpm){
        return rpm * BallShooterConstants.kSensorUnitsPerRotation /600;
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void setMasterShootVelocity(double rpms) {
        if (rpms == 0) {
            shootMotor.set(ControlMode.PercentOutput, rpms);
        }else {
            shootMotor.set(ControlMode.Velocity, rpmToVelocityPer100ms(rpms));
        }
    }
    public void releaseGate() {
        brickWallServo.setPosition(1);
    }
    public double checkGate(){ 
        return brickWallServo.get();
    }
    public void shoot(){
       shootMotor.set(0.77);
       

    }
    public void stopMotor(){
        shootMotor.set(0);  
        brickWallServo.setPosition(0);
     }
}
