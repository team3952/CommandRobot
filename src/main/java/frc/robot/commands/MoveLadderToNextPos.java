package frc.robot.commands;

import edu.wpi.first.wpilibj.command.*;
import frc.robot.*;

public class MoveLadderToNextPos extends Command {
    public static final double TIMEOUT = 8.0;
    // todo
    public static final double[] POSITIONS = new double[] {200, //panel #1
                                                           300, //ball #1
                                                           400, //panel #2
                                                           500, //ball #2
                                                           600, //panel #3
                                                           700  //ball #3
                                                          };
    public static final int DELTA = 15;
    public static final int MIN = 0;
    public static final int MAX = 5;
    public static final double X_MAX = 1000;
    public static final double V_MAX = 1.0;
    public static final double V_MIN = 0.0;
    public static final double K = 4 * (V_MAX - V_MIN) / X_MAX / X_MAX / Math.log(3952 * X_MAX + 1);

    public boolean dir;
    public double init;
    public double curr;
    public double dest;
    public double spd;

    public MoveLadderToNextPos(boolean dir) {
        requires(Robot.ladder);
        setTimeout(TIMEOUT);
        setInterruptible(false);
        this.dir = dir;
    }

    @Override
    protected void initialize() {
        curr = init = RobotMap.ladderEncoder.getDistance();
        if(dir) {
            int position = MIN;
            while(init >= POSITIONS[position] && position < MAX) {
                ++position;
            }
            dest = POSITIONS[Math.min(position - 1, MIN)];
        } else {
            int position = MAX;
            while(init <= POSITIONS[position] && position > MIN) {
                --position;
            }
            dest = POSITIONS[Math.min(position + 1, MAX)];
        }
        spd = Math.log(3952 * (dest - init) + 1);
    }

    @Override
    protected void execute() {
        curr =  RobotMap.ladderEncoder.getDistance();
        Robot.ladder.set(K * spd * (dest - curr) * (curr - init) + V_MIN);
    }

    @Override
    protected boolean isFinished() {
        return dir ? curr >= dest : curr <= dest;
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