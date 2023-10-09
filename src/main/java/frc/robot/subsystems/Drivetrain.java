package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  private WPI_TalonSRX frontLeft = new WPI_TalonSRX(Constants.DriveConstants.frontL);
  private WPI_TalonSRX backLeft = new WPI_TalonSRX(Constants.DriveConstants.backL);
  private WPI_TalonSRX frontRight = new WPI_TalonSRX(Constants.DriveConstants.frontR);
  private WPI_TalonSRX backRight = new WPI_TalonSRX(Constants.DriveConstants.backR);

  private MecanumDrive mecanumDrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
  
  public Drivetrain() {
    frontRight.setInverted(true);
    backRight.setInverted(true);
  }

  public void drive(double x, double y, double rot) {
    mecanumDrive.driveCartesian(x, y, rot);
  }


  @Override
  public void periodic() {}

  @Override
  public void simulationPeriodic() {}
}
