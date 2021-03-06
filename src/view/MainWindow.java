package view;

import Painters.BarChart;
import Painters.Painter;
import Painters.Line;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import sortingAlgorithms.BubbleSort;
import sortingAlgorithms.SelectionSort;
import sortingAlgorithms.SortingInterface;

/**
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
        
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttons.setMaximumSize(new Dimension(1280, 200));
        
        JLabel title = new JLabel("☼ Odin ☉");
        title.setFont(new Font("Serif", Font.BOLD, 70));
        
        Panel p = new Panel();
        
        //area de inserção do tamanho do array
        JPanel insert = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel t = new JLabel("Insira o tamanho do array (1 - 200)");
        JTextField f = new JTextField();
        
        
        //permitir apenas numeros
        f.addKeyListener(new KeyListener() {
            boolean errorKey = false;
            @Override
            public void keyTyped(KeyEvent ke) {}

            @Override
            public void keyPressed(KeyEvent ke) {
               if( !Character.toString(ke.getKeyChar()).matches("^([0-9]|[0-9][0-9]|1[0-9][0-9]|2[0][0])$") ){
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
        
        //recebe o painel que ele vai ficar 'observando' e o field da escolha do tamanho do array
        Randomize btn = new Randomize("Gerar números", p, f);
        
        //recebe o painel, cria um novo array, seta no painel e repinta a tela quando clicado
        SortButton sort = new SortButton("Organize!", p);
        
        //Escolhe a forma de vizualização do gráfico
        Painter[] d = {new BarChart(), new Line()};
        SelectDrawForm select = new SelectDrawForm(d, p);
        
        //Velocidade de execução do algoritmo
        JSpinner vel = new JSpinner(new SpinnerNumberModel(1, 0, 500, 10));
        vel.setToolTipText("Escolha a velocidade que o algoritmo vai executar");
        
        vel.addChangeListener(cg-> {
            p.setSpeed((int) vel.getValue() );
        });
        p.setSpeed((int) vel.getValue() );
        
        
        JButton close = new JButton("Parar Algoritmo");
        close.addActionListener(ev -> {
           if( p.getExecutionAlg() != null){
               p.getExecutionAlg().stop();
               p.repaint(true);
           }
        });
        

        //escolhe o algoritmo a ser usado;
        SortingInterface[] algs = {new BubbleSort(p), new SelectionSort(p)};
        SelectAlgorithm selectAlg = new SelectAlgorithm(algs, p, vel);
        
        top.add(title);
        buttons.add(insert);
        buttons.add(btn);
        buttons.add(sort);
        buttons.add(select);
        buttons.add(selectAlg);
        buttons.add(vel);
        buttons.add(close);
        
        //this.setResizable(false);
        this.add(top);
        this.add(buttons);
        this.add(p);
        this.pack();
    }
    
    public static void main(String[] args) {
        MainWindow w =  new MainWindow();
    }
}

