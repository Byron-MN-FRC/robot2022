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


// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.SubsystemBase;
/**
 *
 */
public class BallIndexer extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

private static WPI_TalonSRX beltMotorLeft;
private DigitalInput bottomSensor;

private static WPI_TalonSRX beltMotorRight;
public static DigitalInput topSensor;
public static boolean shootyMode = false;


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public static DigitalInput topSensor;
    public BallIndexer() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
beltMotorLeft = new WPI_TalonSRX(17);
 
 

beltMotorRight = new WPI_TalonSRX(14);
 
 

bottomSensor = new DigitalInput(8);
 addChild("bottomSensor", bottomSensor);
 

topSensor = new DigitalInput(9);
 addChild("topSensor", topSensor);
 


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    }

    @Override
    public void periodic() {
        // (This method will be called once per scheduler run
        if (!shootyMode){
            if (!sensorTripped()){
                startIndexer(-.5);
            }else{
                stopIndexer();
            }
        } else{
            startIndexer(-.7);
        }
        SmartDashboard.putBoolean("sensor bottom", bottomSensor.get());
        SmartDashboard.putBoolean("sensor top", topSensor.get());
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }
    public static void startIndexer(double speed){
    
        beltMotorLeft.set(speed);
        beltMotorRight.set(-speed);
    
    }
    public static void stopIndexer(){
        beltMotorLeft.set(0);
        beltMotorRight.set(0);
    }
    public boolean sensorTripped(){
        if (!bottomSensor.get() || topSensor.get()){
            return true;
        } else{
            return false; 
        }
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

