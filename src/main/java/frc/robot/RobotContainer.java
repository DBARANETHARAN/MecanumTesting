package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.DriveCmd;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {
  private final Drivetrain mecanumDrivetrain = new Drivetrain();

  private final Joystick driverJoystick =
      new Joystick(OperatorConstants.driverJoystickPort);

  public RobotContainer() {
    mecanumDrivetrain.setDefaultCommand(new DriveCmd(mecanumDrivetrain, driverJoystick));
    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Autos.exampleAuto(mecanumDrivetrain);
  }
}
