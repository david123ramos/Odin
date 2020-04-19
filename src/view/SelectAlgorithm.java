/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import sortingAlgorithms.SortingInterface;

/**
 *
 * @author David
 */
public class SelectAlgorithm extends JComboBox{

    public SelectAlgorithm(SortingInterface [] algs, Panel p, JSpinner vel) {
        
        for(SortingInterface alg: algs){
            this.addItem(alg.getName());
        }
        
        int velocidade = (int) vel.getValue();
        this.setToolTipText("Escolha qual algoritmo de ordenação você vai executar");
        
        this.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ie) {
                String n = (String) SelectAlgorithm.this.getSelectedItem();
                for(SortingInterface i : algs){
                    if(i.getName().equals(n)){
                        p.setSpeed(velocidade);
                        p.setAlgorithm(i);
                        if( p.getExecutionAlg() != null ){
                            p.getExecutionAlg().stop();
                        }
                    }
                }
            }            
        });
    }
}
