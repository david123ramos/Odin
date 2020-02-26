package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author David
 */
public class MainWindow extends JFrame{

    public MainWindow()  {
        
        super("Sorting Algorithms");
        this.setPreferredSize(new Dimension(1280, 500));
        this.setDefaultCloseOperation(MainWindow.EXIT_ON_CLOSE);
        this.setVisible(true);
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        
        JPanel top = new JPanel(new FlowLayout(FlowLayout.CENTER));
        top.setMaximumSize(new Dimension(600, 200));
        
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttons.setMaximumSize(new Dimension(600, 200));
        
        JLabel title = new JLabel("☼ Odin ☉");
        title.setFont(new Font("Serif", Font.BOLD, 70));
        
        Panel p = new Panel();
        
        //recebe o painel que ele vai ficar 'observando'
        Randomize btn = new Randomize("Gerar números", p);
        
        SortButton sort = new SortButton("Organize!", p);
        
        
        top.add(title);
        buttons.add(btn);
        buttons.add(sort);
        
        this.setResizable(false);
        this.add(top);
        this.add(buttons);
        this.add(p);
        this.pack();
    }
    
    public static void main(String[] args) {
        MainWindow w =  new MainWindow();
    }
}

