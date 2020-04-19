
package view;

import java.awt.event.ActionEvent;
import java.util.Arrays;
import javax.swing.JButton;

/**
 *
 * @author David
 */

//When this button is clicked, the array is sorted
public class SortButton extends JButton{

    public SortButton(String name, Panel p) {
        super(name);
        
        

        this.addActionListener((ActionEvent e) -> {
            
           if(p.getExecutionAlg() != null){
               p.getExecutionAlg().stop();
               p.repaint(true);
           }
            
            Thread t = new Thread( new Runnable() {
                @Override
                public void run() {
                    p.sort();
                }
            });
            
            t.start();
            p.setExecutionAlg(t);
        });
    
    }
    
    public void sortArray(int[] arr){
        Arrays.sort(arr);
    }
    
}
