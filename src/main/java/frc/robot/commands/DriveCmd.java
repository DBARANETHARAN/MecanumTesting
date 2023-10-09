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
    mecanumDrivetrain.drive(-driverJoystick.getY(), -driverJoystick.getX(), -driverJoystick.getZ());
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
