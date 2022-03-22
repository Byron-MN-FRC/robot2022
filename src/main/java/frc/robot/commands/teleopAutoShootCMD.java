// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.BallShooterConstants;
import frc.robot.LimelightUtility;
import frc.robot.RobotContainer;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import frc.robot.subsystems.BallShooter;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class teleopAutoShootCMD extends CommandBase {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
        private final BallShooter m_ballShooter;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    double area = 0;
    double rpms = 0;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS


    public teleopAutoShootCMD(BallShooter subsystem) {


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        m_ballShooter = subsystem;
        addRequirements(m_ballShooter);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    runIndexBelt indexBeltRunner;
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        // turns limelight on
        LimelightUtility.WriteDouble("ledMode", 3);
        LimelightUtility.RefreshTrackingData();
        // Calculate optimal RPMS based on area (if target seen)
        if (LimelightUtility.ValidTargetFound()) {
            area = LimelightUtility.TargetAreaPercentage * 100; 
            rpms = area *-30 + 5700;

            // rpms = BallShooterConstants.targetPercent2ShooterParms.floorEntry((int)area).getValue()[0];
        } else {
            System.out.println("No target");
            area = 0;
            rpms = 3400;
        }  
        if (rpms >= 5700) {
            rpms = 5700;
        }
        
        
        RobotContainer.getInstance().m_ballIndexer.setAutoIndex(false);
        
        indexBeltRunner = new runIndexBelt(RobotContainer.getInstance().m_ballIndexer);
        // rpms = 4500;
        
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        System.out.println("area = " + area);
        System.out.println("RPMS = " + rpms);
        m_ballShooter.setMasterShootRPMS(rpms);
        if (m_ballShooter.ready2Shoot(rpms)) {
            if (!indexBeltRunner.isScheduled()) {
                indexBeltRunner.schedule();
                
                
            } 
        } else {
            if (!indexBeltRunner.isFinished()) {            
                indexBeltRunner.cancel();   
            }
       }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
            // Turns off Limelight
            LimelightUtility.WriteDouble("ledMode", 1);
            if (!indexBeltRunner.isFinished()) {            
   
                indexBeltRunner.cancel();
            }
            RobotContainer.getInstance().m_ballIndexer.setAutoIndex(true);   
            m_ballShooter.setMasterShootRPMS(0);
        }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
}
