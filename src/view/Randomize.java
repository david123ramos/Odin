package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;

/**
 *
 * @author David
 */
public class Randomize extends JButton {

    public Randomize(String name, Panel p) {
        super(name);
        Random r = new Random();
        
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int[] aux = r.ints(100, 1, 101).toArray();
                for(int i : aux){System.out.println(i);}
                
                p.setNumbers(aux);
                p.repaint();
            }
        });
        
    }
    
}
