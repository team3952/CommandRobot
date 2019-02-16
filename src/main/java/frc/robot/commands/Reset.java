package frc.robot.commands;

import edu.wpi.first.wpilibj.command.*;
import frc.robot.*;

public class Reset extends Command {
    public Reset() {
        requires(Robot.drive);
        requires(Robot.ladder);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}