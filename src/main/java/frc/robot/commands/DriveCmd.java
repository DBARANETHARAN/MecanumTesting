package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveCmd extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain mecanumDrivetrain;
  private final Joystick driverJoystick;

  public DriveCmd(Drivetrain mecanumDrivetrain, Joystick driverJoystick) {
    this.mecanumDrivetrain = mecanumDrivetrain;
    this.driverJoystick = driverJoystick;
    addRequirements(mecanumDrivetrain);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    double turnVal = ( Math.abs(driverJoystick.getX()) > 0.1) ? -driverJoystick.getX() : 0;
    double rotVal = ( Math.abs(driverJoystick.getZ()) > 0.2) ? -driverJoystick.getZ() : 0;
    mecanumDrivetrain.drive(driverJoystick.getY(), turnVal, rotVal);
  }

  @Override
  public void end(boolean interrupted) {
    mecanumDrivetrain.drive(0,0,0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
