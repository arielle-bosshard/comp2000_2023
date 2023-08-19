import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
      Main window = new Main();
      window.run();
    }

    class Canvas extends JPanel {
      Grid grid = new Grid();

      Actor[] actors = {
        new Dog(grid.cells[1][1]),
        new Cat(grid.cells[2][2]), 
        new Bird(grid.cells[3][3]) 
      };

      Stage stage = new Stage(grid, actors);
      
      public Canvas() {
        setPreferredSize(new Dimension(720, 720));
      }
      
      @Override
      public void paint(Graphics g) {
        grid.paint(g, getMousePosition());
        stage.paint(g);
      }
    }

    private Main() {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Canvas canvas = new Canvas();
      this.setContentPane(canvas);
      this.pack();
      this.setVisible(true);
    }

    public void run() {
      while(true) {
        repaint();
        try {
          Thread.sleep(20);
        } catch (InterruptedException e) {}
      }
    }
}
