package frc.robot;

public class MainController {
    public static final double C = 0.1;
    public static final double DEADZONE = 0.2;
    public static final double MAX = 0.8;
    public static final double K = (MAX - C) / Math.log(2 - DEADZONE);

    public static final double C_T = 0.08;
    public static final double DEADZONE_T = 0.08;
    public static final double MAX_T = 0.4;
    public static final double K_T = (MAX_T - C_T) / Math.log(2 - DEADZONE_T);

    public static double getHorizontalMovement() {
        double x = OI.mainJoystick.getX();
        return Math.abs(x) >= DEADZONE ? K * Math.signum(x) * (Math.log(Math.abs(x) + 1 - DEADZONE) + C) : 0;
    }

    public static double getAxialMovement() {
        double y = -OI.mainJoystick.getY();
        return Math.abs(y) >= DEADZONE ? K * Math.signum(y) * (Math.log(Math.abs(y) + 1 - DEADZONE) + C) : 0;
    }
    
    public static double getRotation() {
        double t = OI.mainJoystick.getZ();
        return Math.abs(t) >= DEADZONE_T ? K_T * Math.signum(t) * (Math.log(Math.abs(t) + 1 - DEADZONE_T) + C_T) : 0;
    }
}