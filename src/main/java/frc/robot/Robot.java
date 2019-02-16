package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;
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
    public void robotPeriodic() {}

    @Override
    public void disabledInit() {}

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {}

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {}

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {}
}
