package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * @author David
 */
public class BarChart implements Draw {

    @Override
    public void draw(Graphics g, Panel p) {
    
    
        g.clearRect(0, 0, p.getWidth(), p.getHeight());
        g.setColor(Color.BLACK);
        
        int width = (p.getSize().width / p.getNumbers().length);
        int height = p.getHeight();
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 10)); 
        
        for (int i =0 ; i<  p.getNumbers().length; i++ ) {

            double auxh = ((double) p.getNumbers()[i] *100) / (double)height;

            int calculatedHeight =   (int) (auxh * 10);
            
            //draw borders
            g.setColor(new Color(0, 0, 0));
            g.drawRect( i * width - 1 , height - calculatedHeight   , width + 1,   calculatedHeight + 1 );
            
            //fill rectangle
            int red =  p.getNumbers().length > 127 ? i : i*2;
            int green = (int) ( p.getNumbers().length > 127 ? i + 50 :  i* 1.74);
            int blue =   p.getNumbers().length > 127 ? i : i + 54 ;
            
            g.setColor(new Color(red, green, blue));
            
            g.fillRect(i * width ,  height - calculatedHeight, width , calculatedHeight );
            g.drawString( p.getNumbers()[i]+"", i * width , height - calculatedHeight);
            
        }
    }
}
