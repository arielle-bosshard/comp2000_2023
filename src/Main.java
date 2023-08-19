import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
      Main window = new Main();
      window.run();
    }

    class Canvas extends JPanel {
      Stage stage;
      public Canvas() throws IOException {
        setPreferredSize(new Dimension(1024, 720));
        stage = StageReader.readStage("data/stage1.rvb");
      }

      @Override
      public void paint(Graphics g) {
        stage.paint(g, getMousePosition());
      }
    }

    private Main() {
      try {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Canvas canvas = new Canvas();
      this.setContentPane(canvas);
      this.pack();
      this.setVisible(true);
      } 
      catch (IOException e){
        e.printStackTrace();
        System.err.println("I shat.");
      }
    }

    public void run() {
      while(true) {
        repaint();
      }
    }
}
