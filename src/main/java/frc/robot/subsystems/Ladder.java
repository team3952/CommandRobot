package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.*;
import frc.robot.*;
import frc.robot.commands.*;

public class Ladder extends Subsystem {
    public static final double LADDER_EXTENDING_SPEED = 0.65;
    public static final double LADDER_RETRACTING_SPEED = 0.4;

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new ManualLadder());
    }

    public void extend() {
        RobotMap.ladder.set(LADDER_EXTENDING_SPEED);
    }

    public void retract() {
        RobotMap.ladder.set(-LADDER_RETRACTING_SPEED);
    }

    public void set(double speed) {
        RobotMap.ladder.set(speed);
    }

    public void stop() {
        RobotMap.ladder.set(0);
    }
}