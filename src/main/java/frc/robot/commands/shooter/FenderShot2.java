// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TowerSubsystem;

public class FenderShot2 extends CommandBase {
  /** Creates a new FenderShot2. */
  private TowerSubsystem tower;
  private ShooterSubsystem shooter;
  private boolean done = false;
  public FenderShot2(TowerSubsystem tower, ShooterSubsystem shooter) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.tower = tower;
    this.shooter = shooter;
    addRequirements(tower, shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooter.setHeight(ShooterConstants.fenderShotHeight);
    shooter.setSpeed(ShooterConstants.fenderShotSpeed);
    Timer.delay(1);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
//    if (!tower.getIsBallInBottom() && !tower.getIsBallInTop()){
//      done = true;
//    }
//    else{
      tower.setTowerMotorsSpeed(0.34);
//    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.setHeight(0);
    shooter.setSpeed(0);
    tower.setTowerMotorsSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return done;
  }
}
