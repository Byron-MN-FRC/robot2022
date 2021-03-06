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
import edu.wpi.first.wpilibj2.command.CommandBase;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import frc.robot.subsystems.Climb;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class Climb2Point extends CommandBase {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
        private final Climb m_climb;
    private double m_BarX;
    private double m_BarY;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS


    public Climb2Point(double BarX, double BarY, Climb subsystem) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_BarX = BarX;
        m_BarY = BarY;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        m_climb = subsystem;
        addRequirements(m_climb);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // if (m_side == ("left")) {
             
            if (m_climb.leftArmElbowMath(m_BarX, m_BarY)) {
                m_climb.startLeftElbow(.3);
            }else {
                m_climb.stopLeftElbow();
            }
            if (m_climb.leftArmShoulderMath(m_BarX, m_BarY)) {
                m_climb.startLeftShoulder(-.3);
            }else {
                m_climb.stopLeftShoulder();
            }
            System.out.println("JFDKSLFJDSKLJFDSLK:");
        //}
        // if (m_side == ("right")) {
        //     if (m_climb.leftArmElbowMath(m_BarX, m_BarY)) {
        //         m_climb.startLeftElbow(.3);
        //     }else {
        //         m_climb.stopLeftElbow();
        //     }
        //     if (m_climb.leftArmShoulderMath(m_BarX, m_BarY)) {
        //         m_climb.startLeftShoulder(.3);
        //     }else {
        //         m_climb.stopLeftShoulder();
        //     }
        // }
        
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_climb.stopLeftShoulder();
        m_climb.stopLeftElbow();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return m_climb.leftArmShoulderMath(m_BarX, m_BarY) & m_climb.leftArmElbowMath(m_BarX, m_BarY);
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
}
