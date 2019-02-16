package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;
import frc.robot.commands.*;

public class OI {
    public static Joystick mainJoystick = new Joystick(0);
    public static Joystick subJoystick = new Joystick(1);
    public static JoystickButton moveLadderUpButton = new JoystickButton(subJoystick, SubController.MOVE_LADDER_UP);
    public static JoystickButton moveLadderDownButton = new JoystickButton(subJoystick, SubController.MOVE_LADDER_DOWN);
    public static JoystickButton deployClawButton = new JoystickButton(subJoystick, SubController.DEPLOY_CLAW);
    public static JoystickButton overrideButton = new JoystickButton(subJoystick, SubController.OVERRIDE);

    public OI() {
        moveLadderUpButton.whenPressed(new MoveLadderToNextPos(true));
        moveLadderDownButton.whenPressed(new MoveLadderToNextPos(false));
        deployClawButton.whenPressed(new DeployClaw());
        overrideButton.whenPressed(new Reset());
    }
}
