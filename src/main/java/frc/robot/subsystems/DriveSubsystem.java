// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class DriveSubsystem extends SubsystemBase {

  private static final double kRampPeriod = 0.3;
  // Estimate. Need to confirm this with the actual robot
  private static final double kDistancePerRotation = 2 * Math.PI * 6.0; 

  private CANSparkMax m_leftLeaderMotor;
  private CANSparkMax m_leftFollowerMotor;  
  private CANSparkMax m_rightLeaderMotor;
  private CANSparkMax m_rightFollowerMotor;

  private DifferentialDrive m_diffDrive;

  private CANEncoder m_leftEncoder;
  private CANEncoder m_rightEncoder;


  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    m_leftLeaderMotor = new CANSparkMax(RoboRio.CanID.kLeftLeader, MotorType.kBrushless);
    m_leftFollowerMotor = new CANSparkMax(RoboRio.CanID.kLeftFollower, MotorType.kBrushless);
    m_rightLeaderMotor = new CANSparkMax(RoboRio.CanID.kRightLeader, MotorType.kBrushless);
    m_rightFollowerMotor = new CANSparkMax(RoboRio.CanID.kRightFollower, MotorType.kBrushless);

    m_leftEncoder = m_leftLeaderMotor.getEncoder();
    m_rightEncoder = m_rightLeaderMotor.getEncoder();

    setRampRate(kRampPeriod);

    m_leftFollowerMotor.follow(m_leftLeaderMotor);
    m_rightFollowerMotor.follow(m_rightLeaderMotor);

    m_diffDrive = new DifferentialDrive(m_leftLeaderMotor, m_rightLeaderMotor);
  }

  @Override  
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setRampRate(double ramp) {
    this.m_leftLeaderMotor.setClosedLoopRampRate(ramp);
    this.m_rightLeaderMotor.setClosedLoopRampRate(ramp);
  }

  public void resetEncoders() {
    m_leftEncoder.setPosition(0.0);
    m_rightEncoder.setPosition(0.0);
  }

  public double getLeftDistance() {
    return m_leftEncoder.getPosition();
  }

  public double getRightDistance() {
    return m_rightEncoder.getPosition();
  }

  public void stop() {
    m_diffDrive.tankDrive(0, 0);
  }

  public void setIdleMode(IdleMode mode) {
		m_leftLeaderMotor.setIdleMode(mode);
		m_leftFollowerMotor.setIdleMode(mode);
		m_rightLeaderMotor.setIdleMode(mode);
		m_rightFollowerMotor.setIdleMode(mode);
	}

  public void arcadeDrive(double forwardSpeed, double rotation) {
    m_diffDrive.arcadeDrive(forwardSpeed, rotation);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    m_diffDrive.tankDrive(leftSpeed, rightSpeed);
  }
}
