package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SerialPort;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  private WPI_TalonSRX frontLeft = new WPI_TalonSRX(Constants.DriveConstants.frontL);
  private WPI_TalonSRX backLeft = new WPI_TalonSRX(Constants.DriveConstants.backL);
  private WPI_TalonSRX frontRight = new WPI_TalonSRX(Constants.DriveConstants.frontR);
  private WPI_TalonSRX backRight = new WPI_TalonSRX(Constants.DriveConstants.backR);
  private AHRS gyroscope = new AHRS(SerialPort.Port.kUSB);

  private MecanumDrive mecanumDrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
  
  public Drivetrain() {
    frontRight.setInverted(true);
    backRight.setInverted(true);
    gyroscope.zeroYaw();
    gyroscope.reset();
  }

  public void drive(double x, double y, double rot) {
    mecanumDrive.driveCartesian(x, y, rot, gyroscope.getRotation2d());
  }


  @Override
  public void periodic() {
    System.out.println(gyroscope.getRotation2d().getDegrees());
  }

  @Override
  public void simulationPeriodic() {}
}
