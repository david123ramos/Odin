
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.sort();
            }
        });
    
    }
    
    public void sortArray(int[] arr){
        Arrays.sort(arr);
    }
    
}
