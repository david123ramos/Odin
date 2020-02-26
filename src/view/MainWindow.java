package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
        
        //area de inserção do tamanho do array
        JPanel insert = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel t = new JLabel("Insira o tamanho do array (1 - 200)");
        JTextField f = new JTextField();
        
        System.out.println("asudasidua"+f.getText()+"<-----");
        
        //permitir apenas numeros
        f.addKeyListener(new KeyListener() {
            boolean errorKey = false;
            @Override
            public void keyTyped(KeyEvent ke) {}

            @Override
            public void keyPressed(KeyEvent ke) {
               if( !Character.toString(ke.getKeyChar()).matches("^([0-9]|[0-9][0-9]|1[0-9][0-9]|2[0][0])$") || f.getText().length() > 2){
                    errorKey = true;
                }else{
                    errorKey = false;
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                if(f.getText().length() > 2){
                    if(! f.getText().matches("^([0-9]|[0-9][0-9]|1[0-9][0-9]|2[0][0])$")){
                        errorKey = true;
                    }
                }
                if(errorKey){f.setText("");}
            }
        });
        
        f.setPreferredSize(new Dimension(30, 25));
        insert.add(t);
        insert.add(f);
    
        
        
        //recebe o painel que ele vai ficar 'observando'

        Randomize btn = new Randomize("Gerar números", p, f);
        
        //recebe o painel, cria um novo array, seta no painel e repinta a tela quando clicado
        SortButton sort = new SortButton("Organize!", p);
        
        
        top.add(title);
        buttons.add(insert);
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

