import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.nhn.ball.PaintableBall;
import com.nhn.world.World;

public class PaintableBallTest{
    static Random random = new Random();
    static final int FRAME_WIDTH = 400;
    static final int FRAME_HEIGHT = 300;
    static final int BALL_COUNT = 10;
    static final int MIN_RADIUS = 10;
    static final int MAX_RADIUS = 50;
    static final Color[] colors = {Color.BLUE, Color.RED, Color.WHITE, Color.BLACK, Color.GREEN};

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        World world = new World();
        frame.add(world);

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        addBall(world);
    }

    private static void addBall(World world) {
        for (int i=0; i<BALL_COUNT; i++) {
            PaintableBall ball = new PaintableBall(random.nextInt(FRAME_WIDTH)+1, random.nextInt(FRAME_HEIGHT)+1, random.nextInt(MAX_RADIUS-MIN_RADIUS)+MIN_RADIUS, colors[random.nextInt(colors.length)]);
            world.add(ball);
        }
    }
}
