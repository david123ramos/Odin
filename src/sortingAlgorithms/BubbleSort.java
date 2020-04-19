/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingAlgorithms;

import java.awt.Color;
import java.util.ArrayList;
import utils.Value;
import view.Panel;

/**
 *
 * @author David
 */
public class BubbleSort implements SortingInterface {
    
    private Panel panel;

    public BubbleSort(Panel p) {
        this.panel = p;
    }
    

    @Override
    public void sort(ArrayList numbers) {
        
        
        this.panel.setRamdomized(false);
        int aux;
        boolean done;
        ArrayList<Value> arr = new ArrayList<>(this.panel.getNumbers());
        int SIZE = numbers.size();
        do{
            done = true;
            
            for(int i = 0;  i < SIZE - 1; i++){
                
                Value a =  (Value) arr.get(i);
                Value b =  (Value) arr.get(i + 1);
                
                arr.set(i, new Value(a.getKey(), Color.BLUE));
                arr.set(i+1, new Value(b.getKey(), Color.BLUE ) );
                
                panel.setNumbers(arr); 
                panel.repaint();
                
                try { Thread.sleep( this.panel.getSpeed() );} catch (InterruptedException ex) {}
            
                if(a.getKey()  > b.getKey()){
                    aux = a.getKey();
                    arr.set(i, b);
                    arr.set(i + 1, new Value(aux, Color.BLACK));
                    this.panel.setNumbers(arr);
                    done = false;
                }else{
                    a.setColor(Color.BLACK);
                    arr.set(i, a);
                    arr.set(i + 1, b);
                    this.panel.setNumbers(arr);
                    this.panel.repaint();
                    
                }
            }
            SIZE--;
        }while(!done);
        
    }

    @Override
    public String getName() {
        return "BubbleSort";
    }
}
