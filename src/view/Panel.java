
package view;

import Painters.BarChart;
import Painters.Painter;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JPanel;
import sortingAlgorithms.BubbleSort;
import sortingAlgorithms.SortingInterface;
import utils.Value;

/**
 *
 * @author David
 */
public class Panel extends JPanel{
    
    //private List numbers;
    //ArrayList<Integer> numbers  = (ArrayList<Integer>) Arrays.stream(aux).boxed().collect((Collector) Collectors.toList()) ;
    private Painter drawForm = new BarChart();
    private SortingInterface algorithm;
    private boolean ramdomized;
    private ArrayList<Value> numbers;
    private int speed;
    private Thread executionAlg;
    
    public Panel(){
        this.numbers = new ArrayList<>();
        //default
        this.algorithm = new BubbleSort(this);
        for(int i =0; i<100; i++){
            this.numbers.add(new Value(i, Color.BLACK ));
        }
        
        Collections.shuffle(numbers);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        drawForm.draw(g, this);
    }

    public ArrayList getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList numbers) {
        this.numbers = numbers;
    }
    
    public void sort(){

        this.algorithm.sort( this.numbers);
        this.repaint(true);
    }

    public SortingInterface getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(SortingInterface algorithm) {
        this.algorithm = algorithm;
    }

    public Painter getD() {
        return drawForm;
    }

    public void setD(Painter d) {
        this.drawForm = d;
    }

    public boolean isRamdomized() {
        return ramdomized;
    }

    public void setRamdomized(boolean ramdomized) {
        this.ramdomized = ramdomized;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Thread getExecutionAlg() {
        return executionAlg;
    }

    public void setExecutionAlg(Thread executionAlg) {
        this.executionAlg = executionAlg;
    }
    
    //seta a cor default pro array de valores e usa o método de repaint
    public void repaint(boolean reset){
        this.numbers.forEach((v) -> {
            v.setColor(Color.BLACK);
        });
        this.repaint();
    }
}
