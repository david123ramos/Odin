package Painters;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Value;
import view.Panel;

/**
 * @author David
 */
public class BarChart implements Painter {

    @Override
    public void draw(Graphics g, Panel p) {

        g.clearRect(0, 0, p.getWidth(), p.getHeight());
        g.setColor(Color.BLACK);
        int arrSize = p.getNumbers().size();
        int width = (p.getSize().width / arrSize);
        int height = p.getHeight();
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));

        for (int i = 0; i < p.getNumbers().size(); i++) {

            Value v = (Value) p.getNumbers().get(i);

            int number = v.getKey();

            int actualNumber = (int) number;

            double auxh = ((double) actualNumber * 100) / (double) height;

            int calculatedHeight = (int) (auxh * 10);

            //draw borders
            g.setColor(new Color(0, 0, 0));
            g.drawRect(i * width - 1, height - calculatedHeight, width + 1, calculatedHeight + 1);

            if (v.getColor() == Color.BLACK) {
                int red = arrSize > 127 ? i : i * 2;
                int green = (int) (arrSize > 127 ? i + 50 : i * 1.74);
                int blue = arrSize > 127 ? i : i + 54;
                g.setColor(new Color(red, green, blue));

            } else {
                g.setColor(v.getColor());
            }

            g.fillRect(i * width, height - calculatedHeight, width, calculatedHeight);
            g.drawString(number + "", i * width, height - calculatedHeight);
           
        }

    }

    public String getName() {
        return "Barchart";
    }
}
