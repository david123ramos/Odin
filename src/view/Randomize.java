package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author David
 */
public class Randomize extends JButton {

    public Randomize(String name, Panel p, JTextField j) {
        super(name);
        Random r = new Random();
        
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = j.getText();
                int arrTam = text.equals("") ? 0 : Integer.parseInt(text);
                int[] aux = r.ints(arrTam, 1, 101).toArray();
                //for(int i : aux){System.out.println(i);}
                
                p.setNumbers(aux);
                p.repaint();
            }
        });
        
    }
    
}
