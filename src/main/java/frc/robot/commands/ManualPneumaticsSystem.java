package frc.robot.commands;

import edu.wpi.first.wpilibj.command.*;
import frc.robot.*;

public class ManualPneumaticsSystem extends Command {
    public boolean extended = false;

    public ManualPneumaticsSystem() {
        requires(Robot.pneumaticsSystem);
    }

    @Override
    public void execute() {
        if(SubController.releaseDisc()) {
            Robot.pneumaticsSystem.extend();
        } else if(SubController.grabDisc()) {
            Robot.pneumaticsSystem.retract();
        } else {
            Robot.pneumaticsSystem.stop();
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end() {
        Robot.pneumaticsSystem.stop();
    }

    @Override
    public void interrupted() {
        Robot.pneumaticsSystem.stop();
    }
}