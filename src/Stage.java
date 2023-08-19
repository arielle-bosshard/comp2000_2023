import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.awt.Rectangle;
import java.awt.Color;


public class Stage {
  Grid grid;
  List<Actor> actors;

  public Stage() {
    grid = new Grid();
    actors = new ArrayList<Actor>();
  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);
    for(Actor a: actors) {
      a.paint(g);
    }
    Optional<Cell> maybeCell = grid.cellAtPoint(mouseLoc);
    String dataX = "You're off-grid!";
    String dataY = "";
    if (maybeCell.isPresent()){
      dataX = "x = " + maybeCell.get().x;
      dataY = "y = " + maybeCell.get().y;
    }

    Rectangle text = new Rectangle(20+Cell.size*grid.cells.length, 10, 280, 280);
    g.setColor(Color.WHITE);
    g.fillRect(text.x, text.y, text.width, text.height);
    g.setColor(Color.BLACK);
    g.drawRect(text.x, text.y, text.width, text.height);
    g.drawString(dataX, text.x+10, text.y+20);
    g.drawString(dataY, text.x+10, text.y+40);
  }
}
