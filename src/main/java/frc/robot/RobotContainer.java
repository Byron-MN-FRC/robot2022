// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutoBlueLeft;
import frc.robot.commands.AutoBlueRight;
import frc.robot.commands.AutoPixyDrive;
import frc.robot.commands.AutoRedLeft;
import frc.robot.commands.AutoRedRight;
import frc.robot.commands.ClimbHardStop;
import frc.robot.commands.acquire;
import frc.robot.commands.alexaFindBall;
import frc.robot.commands.climbCommandGroup;
import frc.robot.commands.cmdDriverCamera;
import frc.robot.commands.doNothing;
import frc.robot.commands.driveWithJoystick;
import frc.robot.commands.enableClimb;
import frc.robot.commands.enableLimeLight;
import frc.robot.commands.flip;
import frc.robot.commands.idleShooter;
import frc.robot.commands.manualMagazineDown;
import frc.robot.commands.reverseAcquire;
import frc.robot.commands.runIndexer;
import frc.robot.commands.runManualClimb;
import frc.robot.commands.toggeGearShift;
import frc.robot.commands.toggleAcquisition;
import frc.robot.commands.togglePixyColor;
import frc.robot.subsystems.BallAcquisition;
import frc.robot.subsystems.BallIndexer;
import frc.robot.subsystems.BallShooter;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Shifter;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot
 * (including subsystems, commands, and button mappings) should be declared
 * here.
 */
public class RobotContainer {

    private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems
    public final Shifter m_shifter = new Shifter();
    public final Climb m_climb = new Climb();
    public final BallAcquisition m_ballAcquisition = new BallAcquisition();
    public final BallIndexer m_ballIndexer = new BallIndexer();
    public final BallShooter m_ballShooter = new BallShooter();
    public final Drive m_drive = new Drive();

// Joysticks
private final Joystick operatorTwo = new Joystick(1);
private final Joystick operatorOne = new Joystick(0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // A chooser for autonomous commands
    SendableChooser<Command> m_chooser = new SendableChooser<>();

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    private RobotContainer() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems


    // SmartDashboard Buttons
    SmartDashboard.putData("enableLimeLight", new enableLimeLight( m_drive ));
    SmartDashboard.putData("togglePixyColor", new togglePixyColor( m_drive ));
    SmartDashboard.putData("climbCommandGroup", new climbCommandGroup( m_climb ));
    SmartDashboard.putData("AutoPixyDrive", new AutoPixyDrive( m_drive ));
    SmartDashboard.putData("toggeGearShift", new toggeGearShift( m_shifter ));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
        // Configure the button bindings
        configureButtonBindings();

        // Configure default commands
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
    m_ballShooter.setDefaultCommand(new idleShooter( m_ballShooter ) );
    m_drive.setDefaultCommand(new driveWithJoystick( m_drive ) );


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
    m_chooser.addOption("AutoBlueLeft", new AutoBlueLeft( m_ballAcquisition, m_ballIndexer, m_ballShooter, m_drive ));
    m_chooser.addOption("AutoBlueRight", new AutoBlueRight( m_ballAcquisition, m_ballIndexer, m_ballShooter, m_drive));
    m_chooser.addOption("AutoRedLeft", new AutoRedLeft( m_ballAcquisition, m_ballIndexer, m_ballShooter, m_drive ));
    m_chooser.addOption("AutoRedRight", new AutoRedRight( m_ballAcquisition, m_ballIndexer, m_ballShooter, m_drive ));
    m_climb.setDefaultCommand(new runManualClimb(m_climb));
        // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    m_chooser.addOption("doNothing", new doNothing());
    m_chooser.setDefaultOption("doNothing", new doNothing());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        SmartDashboard.putData("Auto Mode", m_chooser);
    }

    public static RobotContainer getInstance() {
        return m_robotContainer;
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
     * it to a
     * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {

        final JoystickButton btnAutoBall = new JoystickButton(operatorOne, 6);        
        btnAutoBall.whileHeld(new AutoPixyDrive(m_drive) ,true);
        final JoystickButton btnSafty = new JoystickButton(operatorTwo, 8);        
        btnSafty.whenPressed(new enableClimb(m_climb) ,true);
            // SmartDashboard.putData("btnAutoBall",new Auto() );
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
// Create some buttons
final JoystickButton btnDriverCamera = new JoystickButton(operatorTwo, 3);        
btnDriverCamera.whileHeld(new cmdDriverCamera() ,true);
    SmartDashboard.putData("btnDriverCamera",new cmdDriverCamera() );

final JoystickButton btnMagazineOut = new JoystickButton(operatorTwo, 9);        
btnMagazineOut.whileHeld(new runIndexer( m_ballIndexer ) ,true);
    SmartDashboard.putData("btnMagazineOut",new runIndexer( m_ballIndexer ) );

final JoystickButton btnEnableClimbTwo = new JoystickButton(operatorTwo, 7);        
btnEnableClimbTwo.whenPressed(new climbCommandGroup( m_climb ) ,true);
    SmartDashboard.putData("btnEnableClimbTwo",new climbCommandGroup( m_climb ) );

final JoystickButton btnMagazineIn = new JoystickButton(operatorTwo, 11);        
btnMagazineIn.whileHeld(new manualMagazineDown() ,true);
    SmartDashboard.putData("btnMagazineIn",new manualMagazineDown() );

final JoystickButton btnEnableLimelight = new JoystickButton(operatorTwo, 2);        
btnEnableLimelight.whileHeld(new enableLimeLight( m_drive ) ,true);
    SmartDashboard.putData("btnEnableLimelight",new enableLimeLight( m_drive ) );

final JoystickButton btnHardStopTest = new JoystickButton(operatorOne, 8);        
btnHardStopTest.whileHeld(new ClimbHardStop( m_climb ) ,true);
    SmartDashboard.putData("btnHardStopTest",new ClimbHardStop( m_climb ) );

final JoystickButton btnGearShift = new JoystickButton(operatorOne, 10);        
btnGearShift.whenPressed(new toggeGearShift( m_shifter ) ,true);
    SmartDashboard.putData("btnGearShift",new toggeGearShift( m_shifter ) );

final JoystickButton btnFlip = new JoystickButton(operatorOne, 12);        
btnFlip.whenPressed(new flip( m_drive ) ,true);
    SmartDashboard.putData("btnFlip",new flip( m_drive ) );

final JoystickButton btnTogglePixyColor = new JoystickButton(operatorOne, 3);        
btnTogglePixyColor.whenPressed(new togglePixyColor( m_drive ) ,true);
    SmartDashboard.putData("btnTogglePixyColor",new togglePixyColor( m_drive ) );

final JoystickButton brnToggleAcquistion = new JoystickButton(operatorOne, 11);        
brnToggleAcquistion.whenPressed(new toggleAcquisition( m_ballAcquisition ) ,false);
    SmartDashboard.putData("brnToggleAcquistion",new toggleAcquisition( m_ballAcquisition ) );

final JoystickButton btnAcquire = new JoystickButton(operatorOne, 1);        
btnAcquire.whileHeld(new acquire( m_ballAcquisition ) ,false);
    SmartDashboard.putData("btnAcquire",new acquire( m_ballAcquisition ) );

final JoystickButton btnReverseAcquire = new JoystickButton(operatorOne, 4);        
btnReverseAcquire.whileHeld(new reverseAcquire( m_ballAcquisition ) ,false);
    SmartDashboard.putData("btnReverseAcquire",new reverseAcquire( m_ballAcquisition ) );

final JoystickButton btnFindBall = new JoystickButton(operatorOne, 2);        
btnFindBall.whenHeld(new alexaFindBall( m_drive ) ,true);
    SmartDashboard.putData("btnFindBall",new alexaFindBall( m_drive ) );



    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS

    // SmartDashboard.putData("btnTurn2LimeLight",new turn2LimeLight( m_driveTrain ).withTimeout(5.0) );
        // final JoystickButton btnTurn2LimeLight = new JoystickButton(joystick, 2);
        // btnTurn2LimeLight.whenPressed(new turn2LimeLight( m_drive ).withTimeout(5.0)
        // ,true);
        // SmartDashboard.putData("btnTurn2LimeLight",new turn2LimeLight( m_driveTrain
        // ).withTimeout(5.0) );

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
public Joystick getoperatorOne() {
        return operatorOne;
    }

public Joystick getoperatorTwo() {
        return operatorTwo;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // The selected command will be run in autonomous
        return m_chooser.getSelected();
    }

}
