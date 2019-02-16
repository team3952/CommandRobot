package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.*;
import frc.robot.*;
import frc.robot.commands.*;

public class MecanumDrive extends Subsystem {
    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new ManualDrive());
    }

    public void drive(double hor, double axi, double rot) {
        RobotMap.drive.driveCartesian(axi, hor, rot);
    }

    public void stop() {
        RobotMap.drive.driveCartesian(0, 0, 0);
    }
}