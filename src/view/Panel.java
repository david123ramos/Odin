
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
    private Draw drawForm = new BarChart();

    public Panel(){
        Random random = new Random();
        this.numbers = random.ints(100, 1,101).toArray();
    }

    @Override
    protected void paintComponent(Graphics g) {
        drawForm.draw(g, this);
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

    public Draw getD() {
        return drawForm;
    }

    public void setD(Draw d) {
        this.drawForm = d;
    }
}
