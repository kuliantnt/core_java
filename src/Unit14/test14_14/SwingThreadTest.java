package Unit14.test14_14;

import java.awt.EventQueue;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingThreadTest {

    public static void main(String[] args) {
        JFrame frame = new SwingThreadFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("SwingThreadTest");
        frame.setVisible(true);
    }

}

class SwingThreadFrame extends JFrame {

    public SwingThreadFrame() {
        final JComboBox<Integer> combo = new JComboBox<>();
        combo.insertItemAt(Integer.MAX_VALUE, 0);
        combo.setPrototypeDisplayValue(combo.getItemAt(0));
        combo.setSelectedIndex(0);

        JPanel panel = new JPanel();
        JButton goodButton = new JButton("Good");
        goodButton.addActionListener(e -> new Thread(new GoodWorkerRunnable(combo)).start());

        panel.add(goodButton);
        JButton badButton = new JButton("bad");
        badButton.addActionListener(e -> new Thread(new BadWorkerRunnable(combo)).start());
        panel.add(badButton);
        panel.add(combo);
        add(panel);
        pack();
    }

}

class BadWorkerRunnable implements Runnable {

    private JComboBox<Integer> combo;
    private Random generator;

    BadWorkerRunnable(JComboBox<Integer> combo) {
        this.combo = combo;
        generator = new Random();
    }

    @Override
    public void run() {

        try {
            while (true) {
                int i = Math.abs(generator.nextInt());
                if (i % 2 == 0)
                    combo.insertItemAt(i, 0);
                else if (combo.getItemCount() > 0)
                    combo.removeItemAt(i % combo.getItemCount());
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
        }
    }
}

class GoodWorkerRunnable implements Runnable {

    private JComboBox<Integer> combo;
    private Random generator;

    GoodWorkerRunnable(JComboBox<Integer> combo) {
        this.combo = combo;
        generator = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                EventQueue.invokeLater(() -> {
                    int i = Math.abs(generator.nextInt());
                    if (i % 2 == 0)
                        combo.insertItemAt(i, 0);
                    else if (combo.getItemCount() > 0)
                        combo.removeItemAt(i % combo.getItemCount());
                });
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
        }

    }
}