package sortingAlgorithms;

import java.awt.Color;
import java.util.ArrayList;
import utils.Value;
import view.Panel;

/**
 *
 * @author David
 */
public class SelectionSort implements SortingInterface {

    private final Panel panel;

    public SelectionSort(Panel p) {
        this.panel = p;
    }

    @Override
    public void sort(ArrayList numbers) {
        int min, aux;
        ArrayList<Value> arr = new ArrayList<>(this.panel.getNumbers());
        for (int i = 0; i < numbers.size() ; i++) {
            
            min = i;
            
            for (int j = i + 1; j < numbers.size(); j++) {
                
                Value a = (Value) arr.get(j);
                Value b = (Value) arr.get(min);
                
                
                b.setColor(Color.BLUE);
                this.panel.setNumbers(arr);
                this.panel.repaint();
                
                if (a.getKey() < b.getKey()) {
                    
                    min = j;
                    
                }else{

                    this.panel.setNumbers(arr);
                    this.panel.repaint(true);
                    
                }
            }

            Value c = (Value) arr.get(i);
            Value d = (Value) arr.get(min);
            
            aux = c.getKey();
            d.setColor(Color.BLUE);
            arr.set(i, d);
            arr.set(min, new Value(aux, Color.BLACK));
            this.panel.setNumbers(arr);
            this.panel.repaint();
            
            
            try {Thread.sleep(this.panel.getSpeed());} catch (InterruptedException ex) {}      

        }
    }
    
    @Override
    public String getName() {
        return "SelectionSort";
    }
}
