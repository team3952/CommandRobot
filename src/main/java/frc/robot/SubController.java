package frc.robot;

public class SubController {
    public static final double DELTA = 0.5;

    public static final int GRAB_DISC = 3;
    public static final int RELEASE_DISC = 4;
    public static final int RESET_CLAW = 5;
    public static final int DEPLOY_CLAW = 8;
    public static final int MOVE_LADDER_UP = 1;
    public static final int MOVE_LADDER_DOWN = 2;
    public static final int OVERRIDE = 6;

    public static boolean extendLadder() {
        return OI.subJoystick.getY() >= DELTA;
    } 

    public static boolean retractLadder() {
        return OI.subJoystick.getY() <= -DELTA;
    }

    public static boolean grabDisc() {
        return OI.subJoystick.getRawButton(GRAB_DISC);
    }

    public static boolean releaseDisc() {
        return OI.subJoystick.getRawButton(RELEASE_DISC);
    }

    public static boolean deployClaw() {
        return OI.subJoystick.getRawButton(DEPLOY_CLAW);
    }

    public static boolean resetClaw() {
        return OI.subJoystick.getRawButton(RESET_CLAW);
    }
}