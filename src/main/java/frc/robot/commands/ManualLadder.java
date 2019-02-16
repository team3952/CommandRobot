package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.SubController;

public class ManualLadder extends Command {
    public ManualLadder() {
        requires(Robot.ladder);
        setInterruptible(true);
    }

    @Override
    protected void initialize() {}

    @Override
    protected void execute() {
        if(SubController.extendLadder()) {
            Robot.ladder.extend();
        } else if(SubController.retractLadder()) {
            Robot.ladder.retract();
        } else {
            Robot.ladder.stop();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.ladder.stop();
    }

    @Override
    protected void interrupted() {
        Robot.ladder.stop();
    }
}