package frc.robot.commands;

import edu.wpi.first.wpilibj.command.*;
import frc.robot.*;

public class ManualDrive extends Command {
    public ManualDrive() {
        requires(Robot.drive);
        setInterruptible(true);
    }

    @Override
    public void execute() {
        double x = MainController.getHorizontalMovement();
        double y = MainController.getAxialMovement();
        double r = MainController.getRotation();

        Robot.drive.drive(x, y, r);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end() {
        Robot.drive.stop();
    }

    @Override
    public void interrupted() {
        Robot.drive.stop();
    }
}