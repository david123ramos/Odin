
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author David
 */
public class Panel extends JPanel{
    
    private int[] numbers;
    //ArrayList<Integer> numbers  = (ArrayList<Integer>) Arrays.stream(aux).boxed().collect((Collector) Collectors.toList()) ;
    
    public Panel(){
        Random random = new Random();
        this.numbers = random.ints(100, 1,101).toArray();
    }

    @Override
    protected void paintComponent(Graphics g) {
        
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.BLACK);
        
        int width = (this.getSize().width / numbers.length);
        int height = this.getHeight();
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 10)); 
        
        for (int i =0 ; i< numbers.length; i++ ) {

            double auxh = ((double)numbers[i] *100) / (double)height;

            int calculatedHeight =   (int) (auxh * 10);
            
            //draw borders
            g.setColor(new Color(0, 0, 0));
            g.drawRect( i * width - 1 , height - calculatedHeight   , width + 1,   calculatedHeight + 1 );
            
            //fill rectangle
            g.setColor(new Color(i*2 , calculatedHeight / 3, width * 4));
            g.fillRect(i * width ,  height - calculatedHeight, width , calculatedHeight );
            g.drawString(numbers[i]+"", i * width , height - calculatedHeight);
            
        }
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
    
    public void sort(){
        Arrays.sort(this.numbers);
        this.repaint();
    }
    
   
}
