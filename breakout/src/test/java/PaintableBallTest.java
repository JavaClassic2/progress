import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

import com.nhn.ball.PaintableBall;
import com.nhn.world.World;

public class PaintableBallTest{
    static Random random = new Random();

    public static void main(String[] args) {
        Frame frame = new JFrame();
        World world = new World();
        frame.add(world);

        frame.setSize(400, 300);
        frame.setVisible(true);
        
        addBall(world);
    }

    private static void addBall(World world) {
        Color[] colors = {Color.BLUE, Color.RED, Color.WHITE, Color.BLACK, Color.GREEN};

        for (int i=0; i<10; i++) {
            PaintableBall ball = new PaintableBall(random.nextInt(400), random.nextInt(300), random.nextInt(50), colors[random.nextInt(5)]);
            world.add(ball);
            System.out.println("ball added : " + ball);
        }
    }
}
