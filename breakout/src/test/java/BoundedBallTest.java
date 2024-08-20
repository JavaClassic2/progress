import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.nhn.ball.BoundedBall;
import com.nhn.exception.OutOfBoundsException;
import com.nhn.world.MovableWorld;
import com.nhn.world.World;

public class BoundedBallTest{
    static Random random = new Random();
    static final int FRAME_WIDTH = 400;
    static final int FRAME_HEIGHT = 300;
    static final int BALL_COUNT = 3;
    static final int MIN_RADIUS = 10;
    static final int MAX_RADIUS = 50;
    static final Color[] colors = {Color.BLUE, Color.RED, Color.WHITE, Color.BLACK, Color.GREEN};

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        MovableWorld world = new MovableWorld();
        frame.add(world);

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        addBall(world);

        world.run();
    }

    private static void addBall(World world) {
        System.out.println(world.getSize());
        while(world.getCount() < BALL_COUNT) {
            try {
                BoundedBall ball = new BoundedBall(
                    random.nextInt(FRAME_WIDTH)+1, 
                    random.nextInt(FRAME_HEIGHT)+1, 
                    random.nextInt(MAX_RADIUS-MIN_RADIUS)+MIN_RADIUS, 
                    colors[random.nextInt(colors.length)]
                );
                
                ball.setBounds(world.getBounds());
                
                world.add(ball);
            } catch (OutOfBoundsException e) {
                addBall(world);
            }
        }
    }
}
