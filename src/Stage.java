import java.awt.Graphics;

public class Stage {
    // fields
    Grid grid;
    Actor[] actors;
    
    // constructors
    public Stage(Grid grid, Actor[] actors) {
        this.grid = grid;
        this.actors = actors;
    }

    // methods
    public void paint(Graphics g) {
        for (Actor actor : this.actors) {
            actor.paint(g);
        }
    }

}
