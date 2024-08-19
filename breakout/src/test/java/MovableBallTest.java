import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.nhn.ball.MovableBall;
import com.nhn.world.World;

public class MovableBallTest {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        World world = new World();
        frame.add(world);

        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        MovableBall ball = new MovableBall(100, 100, 50);

        world.add(ball);
        System.out.println(ball);

        while(ball.getX() < world.getWidth() && ball.getY() < world.getHeight()) {
            ball.move();
            Thread.sleep(1000);
            world.repaint();
        }
    }
}
