// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: SequentialCommandGroup.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import frc.robot.subsystems.BallAcquisition;
import frc.robot.subsystems.BallIndexer;
import frc.robot.subsystems.BallShooter;
import frc.robot.subsystems.Drive;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class AutoBlueRight extends SequentialCommandGroup {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    public AutoBlueRight(BallAcquisition m_ballAcquisition, BallIndexer m_ballIndexer, BallShooter m_ballShooter, Drive m_Drive){

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    addCommands(
        new enableLimeLight(m_Drive).withTimeout(1),
        new teleopAutoShootCMD(m_ballShooter).withTimeout(5),
        new driveForward(.2, m_Drive),
        new driveForward(-.2, m_Drive),
        new AutoPixyDrive(m_Drive),
        new acquire(m_ballAcquisition),
    
         new enableLimeLight(m_Drive).withTimeout(1),
         new teleopAutoShootCMD(m_ballShooter).withTimeout(5)
      

        );
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
}
