package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;
import frc.robot.*;
import frc.robot.commands.*;

public class PneumaticsSystem extends Subsystem {
    public boolean extended = false;

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new ManualPneumaticsSystem());
    }

    public void extend() {
        if(!extended) {
            RobotMap.solenoid.set(DoubleSolenoid.Value.kForward);
            extended = true;
        }
    }

    public void retract() {
        if(extended) {
            RobotMap.solenoid.set(DoubleSolenoid.Value.kReverse);
            extended = false;
        }
    }

    public void stop() {
        RobotMap.solenoid.set(DoubleSolenoid.Value.kOff);
    }
}