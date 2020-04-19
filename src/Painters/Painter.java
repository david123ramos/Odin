package Painters;

import java.awt.Graphics;
import view.Panel;

/**
 * @author David
 */

public interface Painter {
    public void draw(Graphics g, Panel p);
    public String getName();
}
