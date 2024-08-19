import java.awt.Color;
import java.awt.Frame;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.nhn.ball.PaintableBall;
import com.nhn.world.World;

public class PaintableBallTest{
    static Random random = new Random();

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        World world = new World();
        frame.add(world);

        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        addBall(world);
    }

    private static void addBall(World world) {
        Color[] colors = {Color.BLUE, Color.RED, Color.WHITE, Color.BLACK, Color.GREEN};

        for (int i=0; i<10; i++) {
            PaintableBall ball = new PaintableBall(random.nextInt(400)+1, random.nextInt(300)+1, random.nextInt(40)+10, colors[random.nextInt(5)]);
            world.add(ball);
            System.out.println("ball added : " + ball);
        }
    }
}
