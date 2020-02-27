/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ItemEvent;
import javax.swing.JComboBox;

/**
 *
 * @author David
 */
public class SelectDrawForm extends JComboBox{

    public SelectDrawForm(Draw[] forms) {
        super(forms);
        this.addItemListener((ItemEvent e) -> {
            Draw d = (Draw)e.getItem();
            System.out.println("Você selecionou o item!");
        });
    
    }
}
