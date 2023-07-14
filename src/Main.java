import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class Main {
       static int rowcol = 25;
       static int size = 20;
       static int X = rowcol/2;
       static int Y = rowcol/2;
       static Dir dir = Dir.UNMOVED;

    public static void main(String[] args) {
           JFrame Form = new JFrame();
           Form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           Form.setLayout(null);
           Form.setSize(600, 600);
           ImageIcon icon = new ImageIcon("F:\\Paint-IO\\src\\icon.png");
           Form.setIconImage(icon.getImage());
           Form.setTitle("Paint.IO");

           JPanel [][] cells = new JPanel[rowcol][rowcol];

        for(int r=0; r<rowcol; r++){
            for(int c=0; c<rowcol; c++){
                cells[r][c] = new JPanel();
                cells[r][c].setLocation(r*size, c*size);
                cells[r][c].setSize(size, size);
                Border bd = LineBorder.createGrayLineBorder();
                cells[r][c].setBorder(bd);
                Form.add(cells[r][c]);
            }
        }
        Form.setVisible(true);

        Form.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                   switch(e.getKeyCode()){
                            case 39:
                                 if(dir!=Dir.LEFT)
                                    dir = Dir.RIGHT;
                                 break;
                            case 37:
                                 if(dir!=Dir.RIGHT)
                                    dir = Dir.LEFT;
                                 break;
                            case 40:
                                 if(dir!=Dir.UP)
                                    dir = Dir.DOWN;
                                 break;
                            case 38:
                                 if(dir!=Dir.DOWN)
                                    dir = Dir.UP;
                                 break;
                   }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        Timer timer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cells[X][Y].setBackground(Color.YELLOW);
                if(dir == Dir.RIGHT){
                    if(X<rowcol-1){
                       X++;
                    }
                }
                if(dir == Dir.LEFT){
                    if(X>0){
                       X--;
                    }
                }
                if(dir == Dir.DOWN){
                    if(Y<rowcol-1){
                       Y++;
                    }
                }
                if(dir == Dir.UP){
                    if(Y>0){
                       Y--;
                    }
                }
                cells[X][Y].setBackground(Color.ORANGE);
            }
        });
        timer.start();
    }
}