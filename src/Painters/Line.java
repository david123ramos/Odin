package Painters;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import utils.Value;
import view.Panel;

/**
 * @author David
 */
public class Line implements Painter {

    @Override
    
    public void draw(Graphics g, Panel p) {
        
        g.clearRect(0, 0, p.getWidth(), p.getHeight());
        g.setColor(Color.BLACK);
        
        int arrSize = p.getNumbers().size();
        
        int width = (p.getSize().width / arrSize);
        int height = p.getHeight();
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 10)); 
        int x[] = new int[arrSize];
        int y[] = new int[arrSize];
        
        

        for(int i =0 ; i< p.getNumbers().size(); i++){
            Value v = (Value) p.getNumbers().get(i);
            int number = v.getKey();


            double auxh = ((double) number *100) / (double)height;
            int calculatedHeight =   (int) (auxh * 10);
          
            //draw borders
            g.setColor(new Color(0, 0, 0));
            //g.drawOval( i * width - 1 , height - calculatedHeight   , width + 1,   calculatedHeight + 1 );
            
            //fill rectangle
            int red = 255;
            int green = 0;
            int blue = 0; 
            
            if(v.getColor() == Color.BLACK){
                red = arrSize > 127 ? i : i*2;
                green = (int) ( arrSize > 127 ? i + 50 :  i* 1.74);
                blue=  arrSize > 127 ? i : i + 54 ;
            }
            
            g.setColor(new Color(red, green, blue));
            x[i] = i * width;
            y[i] = height - calculatedHeight;
            
            //g.fillOval(i * width ,  height - calculatedHeight, 6 , 6 );
            g.drawString( number+"", i * width , height - calculatedHeight);
            
        }

        g.drawPolyline(x, y, arrSize);
       
    }

    @Override
    public String getName() {
        return "Line";
    }
}
