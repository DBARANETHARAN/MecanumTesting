package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;

public final class Autos {
  /** Example static factory for an autonomous command. */
  public static CommandBase exampleAuto(Drivetrain mecanumDrivetrain) {
    return Commands.sequence(new DriveCmd(mecanumDrivetrain, null));
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
