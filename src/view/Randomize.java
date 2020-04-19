package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JTextField;
import utils.Value;

/**
 *
 * @author David
 */
public class Randomize extends JButton {

    public Randomize(String name, Panel p, JTextField j) {
        super(name);
        
        this.addActionListener((ActionEvent e) -> {

            String text1 = j.getText();
            int arrTam = text1.equals("") ? 100 : Integer.parseInt(text1);
            
            ArrayList aux = new ArrayList<>();
            
            for(int i =0 ; i< arrTam; i++){
                aux.add(new Value(i, Color.BLACK));
            }
            Collections.shuffle(aux);
            p.setNumbers(aux);
            p.repaint();
            
        });
    }
}
