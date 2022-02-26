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


// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class BallIndexer extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private WPI_TalonSRX beltMotorLeft;
private WPI_TalonSRX beltMotorRight;
private DigitalInput bottomSensor;
private DigitalInput topSensor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

public static boolean shootyMode = false;
    /**
    *
    */
    //public static DigitalInput topSensor;
    public BallIndexer() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
beltMotorLeft = new WPI_TalonSRX(9);
 
 

beltMotorRight = new WPI_TalonSRX(14);
 
 

bottomSensor = new DigitalInput(7);
 addChild("bottomSensor", bottomSensor);
 

topSensor = new DigitalInput(9);
 addChild("topSensor", topSensor);
 


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    }

    @Override
    public void periodic() {
        // (This method will be called once per scheduler run
        if (!shootyMode){
            if (sensorTripped()){
                startIndexer(-.5);
                System.out.println("Sensor Tripped");
            }else{
                stopIndexer();
            }
        } else{
            startIndexer(-.7);
            System.out.println("Running Indexer");
        }
        SmartDashboard.putBoolean("sensor bottom", bottomSensor.get());
        SmartDashboard.putBoolean("sensor top", topSensor.get());
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }
    public void startIndexer(double speed){
    
        beltMotorLeft.set(speed);
        beltMotorRight.set(-speed);
    
    }
    public void stopIndexer(){
        beltMotorLeft.set(0);
        beltMotorRight.set(0);
    }
    public boolean sensorTripped(){
        if (isBottomSensor() && !isTopsensor()){
            return true;
        } else{
            return false; 
        }
    }
    public boolean isTopsensor() {
        return !topSensor.get();
    }
    public boolean isBottomSensor(){
        return !bottomSensor.get();
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void reinitializeIndexer(){
        shootyMode = false;
        beltMotorLeft.stopMotor();
        beltMotorRight.stopMotor();
    }
}

