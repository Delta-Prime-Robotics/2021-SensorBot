// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

import static frc.robot.Constants.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // OI controllers are defined here...
  private final Joystick m_gamePad = new Joystick(Laptop.UsbPorts.kGamePad);
  
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final PDPSubsystem m_pdpSubsystem = new PDPSubsystem(); 


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    Boolean atCompetition = false;
    
    configureButtonBindings();
    
    configureDefaultCommands();

    m_pdpSubsystem.setUpShuffleboard(atCompetition);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}


  /**
   * Use this method to set the default commands for subsystems
   * Default commands can be explicit command classes, inline or use one of the
   * "convenience" subclasses of command (e.g. {@link edu.wpi.first.wpilibj2.command.InstantCommand})
   */
  private void configureDefaultCommands() {    
    // Set Arcade Drive as the default
    m_driveSubsystem.setDefaultCommand(
      new ArcadeDriveCommand(m_driveSubsystem,
      () -> m_gamePad.getRawAxis(GamePad.RightStick.kLeftRight),
      () -> -m_gamePad.getRawAxis(GamePad.RightStick.kUpDown))
    );
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
