

import com.nhn.ball.Ball;
import com.nhn.exception.OutOfRangeException;

public class BallTest {
    public static void main(String[] args) {
        creationTest();
    }

    
    private static void creationTest() {
        System.out.println("==============================");
        System.out.println("Default Creation Test");
        defaultTest();
        System.out.println("==============================");
        System.out.println("Invalid Size Exception Test");
        System.out.println("==============================");
        invalidSizeExceptionTest();
        System.out.println("==============================");
        System.out.println("Out of Range Exception Test");
        System.out.println("==============================");
        outOfRangeExceptionTest();
        System.out.println("==============================");
    }

    private static void ballTest(int[][] testCase) {
        for (int i=0; i<testCase.length; i++){
            try{
                System.out.printf("test %d%ncreate : (%d, %d), radius : %d%n",i, testCase[i][0], testCase[i][1], testCase[i][2]);
                Ball ball = new Ball(testCase[i][0], testCase[i][1], testCase[i][2]);
                
                if (ball.getX() != testCase[i][0] || ball.getY() != testCase[i][1]) {
                    System.out.println("ball이 다른 위치에 생성되었습니다.");
                    System.out.printf("expected : (%d, %d), real : (%d, %d)%n", testCase[i][0], testCase[i][1], ball.getX(), ball.getY());
                }
                
                if (ball.getRadius() != testCase[i][2]) {
                    System.out.println("ball의 반지름이 기대한 값과 다릅니다.");
                    System.out.printf("expected : %d, real : %d%n", testCase[i][2], ball.getRadius());
                }
            } catch (OutOfRangeException e) {
                System.out.println("생성 실패 : " +e.getClass());
            } catch (IllegalArgumentException e) {
                System.out.println("생성 실패 : " + e.getClass());
            }
        }
    }

    private static void defaultTest() {
        int[][] trueCase = {
            {0, 0, 1}, 
            {0, 0, Integer.MAX_VALUE},
            {100, 100, 100},
            {100, -100, 100},
            {-100, 100, 100},
            {-100, -100, 100},
            {Integer.MIN_VALUE + 1, Integer.MIN_VALUE + 1, 1},
            {Integer.MIN_VALUE + 1, Integer.MAX_VALUE - 1, 1},
            {Integer.MAX_VALUE - 1, Integer.MIN_VALUE + 1, 1},
            {Integer.MAX_VALUE - 1, Integer.MIN_VALUE - 1, 1},
        };

        ballTest(trueCase);
    }

    private static void invalidSizeExceptionTest() {
        int[][] testCase = {
            {0, 0, 0}, 
            {0, 0, -0},
            {0, 0, Integer.MIN_VALUE}
        };

        ballTest(testCase);
    }

    private static void outOfRangeExceptionTest() {
        int[][] testCase = {
            {Integer.MAX_VALUE, 0, 1}, 
            {0, Integer.MAX_VALUE, 1},
            {Integer.MIN_VALUE, 0, 1},
            {0, Integer.MIN_VALUE, 1},
            {Integer.MIN_VALUE, Integer.MIN_VALUE, 1},
            {Integer.MAX_VALUE, Integer.MIN_VALUE, 1},
            {Integer.MIN_VALUE, Integer.MAX_VALUE, 1},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 1},
            {Integer.MAX_VALUE, 0, Integer.MAX_VALUE},
            {0, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {Integer.MIN_VALUE, 0, Integer.MAX_VALUE},
            {0, Integer.MIN_VALUE, Integer.MAX_VALUE}

        };

        ballTest(testCase);
    }
}