/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Painters.Painter;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

/**
 *
 * @author David
 */
public class SelectDrawForm extends JComboBox{

    public SelectDrawForm(Painter[] forms, Panel p) {
       

        for (Painter form : forms) {
            this.addItem(form.getName());
        }
        this.setToolTipText("Escolha o modo de visualização");
        this.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String n = (String) SelectDrawForm.this.getSelectedItem();
                
                for(Painter d : forms){
                    if(d.getName().equals(n)){
                        p.setD(d);
                        p.repaint();
                    }
                }
            }
        });
    }
}
