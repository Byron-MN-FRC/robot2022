// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Command.

package frc.robot.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.LimelightUtility;
import frc.robot.RobotContainer;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import frc.robot.subsystems.Drive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class enableLimeLight extends CommandBase {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
        private final Drive m_drive;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private final double minTurnPower = 0.2;
    private final double tolerance = 6;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS


    public enableLimeLight(Drive subsystem) {


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        m_drive = subsystem;
        addRequirements(m_drive);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        LimelightUtility.EnableDriverCamera(false);
        LimelightUtility.WriteDouble("ledMode", 3); // 3 = Limelight On
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        LimelightUtility.RefreshTrackingData();

        if (LimelightUtility.ValidTargetFound()) {
            double steerCorrect = LimelightUtility.TargetHorizontalOffset / 27.0;

            if (Math.abs(LimelightUtility.TargetHorizontalOffset) < tolerance)
                steerCorrect = 0.0;
            SmartDashboard.putNumber("targHorizOffset", LimelightUtility.TargetHorizontalOffset);
            SmartDashboard.putNumber("steerCorrect raw", steerCorrect);

            if (steerCorrect < 0) {
                if (steerCorrect > -minTurnPower)
                    steerCorrect = -minTurnPower;
            } else {
                if (steerCorrect < minTurnPower)
                    steerCorrect = minTurnPower;
            }
            SmartDashboard.putNumber("steerCorrect corrected", steerCorrect);

            m_drive.JoystickDrive(RobotContainer.getInstance().getoperatorOne(),
                    steerCorrect);
        }
   }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_drive.stop();
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
