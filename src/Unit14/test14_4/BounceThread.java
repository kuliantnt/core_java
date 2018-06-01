package Unit14.test14_4;

import Unit14.test14_2.Ball;
import Unit14.test14_3.BallComponent;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BounceThread{

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("BounceThread");
            frame.setVisible(true);
        });
    }
}

class BallRunnable implements Runnable{
    private Ball ball;
    private Component comparator;
    private static final int STEPS = 1000;
    private static final int DELAY = 5;
    BallRunnable(Ball ball, Component component){
        this.ball = ball;
        this.comparator = component;

    }

    @Override
    public void run() {
        try{
            for (int i = 0; i <= STEPS; i++) {
                ball.move(comparator.getBounds());
                comparator.repaint();
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException e) {
            System.out.println("over");
            Thread.currentThread().interrupt();
        }
    }
}

class BounceFrame extends JFrame {

    private BallComponent comp;

    BounceFrame() {

        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", e -> addBall());
        addButton(buttonPanel, "Close", e -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    private void addBall() {
        Ball ball = new Ball();
        comp.add(ball);
        Runnable r = new BallRunnable(ball, comp);
        Thread t = new Thread(r);
        t.start();
    }


    private void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }
}
