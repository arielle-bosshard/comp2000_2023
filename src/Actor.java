import java.awt.Color;
import java.awt.Graphics;

public class Actor {
    //field
    Cell cell;
    Color color;

    //contructor 
    public Actor(Cell actor, Color color) {
        this.cell = actor;
        this.color = color;
    }

    public void paint(Graphics g){
        g.setColor(this.color);
        g.fillRect(
            this.cell.x, 
            this.cell.y, 
            this.cell.size, 
            this.cell.size
        );
    }   

}
