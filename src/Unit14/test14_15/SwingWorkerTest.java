package Unit14.test14_15;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class SwingWorkerTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new SwingWorkerFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

}
class SwingWorkerFrame extends JFrame {

    private JFileChooser chooser;
    private JTextArea textArea;
    private JLabel statusLine;
    private JMenuItem openItem;
    private JMenuItem cancelItem;
    private SwingWorker<StringBuilder, ProgressData> textReader;
    private static final int TEXT_ROWS = 20;
    private static final int TEXT_COLUMNS = 60;

    SwingWorkerFrame() {
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        textArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
        add(new JScrollPane(textArea));
        statusLine = new JLabel(" ");
        add(statusLine, BorderLayout.SOUTH);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        openItem = new JMenuItem("Open");
        menu.add(openItem);

        openItem.addActionListener(e -> {
            int result = chooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                textArea.setText("");
                openItem.setEnabled(false);
                textReader = new TextReader(chooser.getSelectedFile());
                textReader.execute();
                cancelItem.setEnabled(true);
            }
        });

        cancelItem = new JMenuItem("Cancel");
        menu.add(cancelItem);
        cancelItem.setEnabled(false);
        cancelItem.addActionListener(e -> textReader.cancel(true));
        pack();
    }

    private class ProgressData {

        int number;
        String line;
    }

    private class TextReader extends SwingWorker<StringBuilder, ProgressData> {

        private File file;
        private StringBuilder text = new StringBuilder();

        TextReader(File file) {
            this.file = file;
        }

        @Override
        protected StringBuilder doInBackground() throws Exception {
            int lineNumber = 0;
            try (Scanner in = new Scanner(new FileInputStream(file))) {
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    lineNumber++;
                    text.append(line);
                    text.append("\n");
                    ProgressData data = new ProgressData();
                    data.number = lineNumber;
                    data.line = line;
                    publish(data);
                    Thread.sleep(1);
                }
            }
            return text;
        }

        @Override
        public void process(List<ProgressData> data) {
            if (isCancelled()) {
                return;
            }
            StringBuilder b = new StringBuilder();
            statusLine.setText("" + data.get(data.size() - 1).number);
            for (ProgressData d : data) {
                b.append(d.line);
                b.append("\n");
            }
            textArea.append(b.toString());
        }

        @Override
        protected void done() {
            try {
                StringBuilder result = get();
                textArea.setText(result.toString());
                statusLine.setText("Done");
            } catch (InterruptedException e) {
            } catch (ExecutionException e) {
                statusLine.setText("" + e.getCause());
            } catch (CancellationException e) {
                textArea.setText("");
                statusLine.setText("Cancelled");
            }
            cancelItem.setEnabled(false);
            openItem.setEnabled(true);
        }
    }
}

