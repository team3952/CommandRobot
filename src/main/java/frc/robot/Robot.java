package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;
import frc.robot.commands.DeployClaw;
import frc.robot.subsystems.*;

public class Robot extends TimedRobot {
    public static OI oi;
    public static MecanumDrive drive;
    public static Ladder ladder;
    public static PneumaticsSystem pneumaticsSystem;

    @Override
    public void robotInit() {
        RobotMap.init();
        oi = new OI();
        drive = new MecanumDrive();
        ladder = new Ladder();
        pneumaticsSystem = new PneumaticsSystem();
    }

    @Override
    public void teleopInit() {
        Scheduler.getInstance().add(new DeployClaw());
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
}
