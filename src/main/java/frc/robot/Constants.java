// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public class Constants {
   /**
    * public static final class DriveConstants {
    *   public static final int kLeftMotor1Port = 0;
    *   public static final int kLeftMotor2Port = 1;
    *   public static final int kRightMotor1Port = 2;
    *   public static final int kRightMotor2Port = 3; 
    * }
    */ 
    // Drive Train constants
    public static final boolean kEnableCurrentLimiting_DT = true;
    // public final static double kAmpLimit_DT = 12; public static final String kAmpLimitName_DT = "DriveTrain/Amp Limit";
    // public final static double kAmpPeak_DT = 15; public static final String kAmpPeakLimitName_DT = "DriveTrain/Amp Peak Limit";
    public final static double kAmpLimit_DT = 40; public static final String kAmpLimitName_DT = "test/drive/Amp Limit";
    public final static double kAmpPeak_DT = 60; public static final String kAmpPeakLimitName_DT = "test/drive/Amp Peak Limit";

    public static final double kthreshholdTime = 0;
 
    // Pixy constants
    //public final static boolean pixyOnDashboard = true;
    //public final static boolean pixyDebug = true;
    //public final static boolean pixyLogTimes = true;

    public static final double encodeUnitsToFeet = -22684.24;//Real robot

    public final static int kTimeoutMs = 30;

    public final static Gains kGains_Distanc = new Gains(0.1, 0.0, 0.0, 0.0, 100, 0.50);
    public final static Gains kGains_Turning = new Gains(.95, 0.001, 0.0, 0.0, 0, 0.4);
    public final static Gains kGains_Velocit = new Gains(0.1, 0.0, 20.0, 1023.0 / 6800.0, 300, 0.50);
    public final static Gains kGains_MotProf = new Gains(1.0, 0.0, 0.0, 1023.0 / 6800.0, 400, 1.00);
    public static final Gains kGains = new Gains(0.2, 0.001, 0.0, 0.2, 0, 1.0);
    public static final int kPIDLoopIdx = 0; // Check how it is done with talon

    public final static int kPigeonUnitsPerRotation = 8192;

    public final static double kNeutralDeadband = 0.01;

    public final static int PID_PRIMARY = 0;
    public final static int PID_TURN = 1;

    public final static int SLOT_0 = 0;
    public final static int SLOT_1 = 1;
    public final static int SLOT_2 = 2;
    public final static int SLOT_3 = 3;

    public final static int kSlot_Distanc = SLOT_0;
    public final static int kSlot_Turning = SLOT_1;
    public final static int kSlot_Velocit = SLOT_2;
    public final static int kSlot_MotProf = SLOT_3; 

    public static final double bicepLenght = 25.5;
    public static final double forearmLength = 29;
    public static final double encoderToDegree = .00266667;
 }

