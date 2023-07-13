import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
           JFrame Form = new JFrame();
           Form.setLayout(null);
           Form.setSize(600, 600);
           ImageIcon icon = new ImageIcon("F:\\Paint-IO\\src\\icon.png");
           Form.setIconImage(icon.getImage());
           Form.setTitle("Paint.IO");
           Form.setVisible(true);

           int rowcol = 25;
           int size = 20;
           int Xi = rowcol/2;
           int Yi = rowcol/2;

           JLabel [][] cells = new JLabel[rowcol][rowcol];

        for(int r=0; r<rowcol; r++){
            for(int c=0; c<rowcol; c++){
                cells[r][c] = new JLabel();
                cells[r][c].setLocation(r*size, c*size);
                cells[r][c].setSize(size, size);
                Border bd = LineBorder.createGrayLineBorder();
                cells[r][c].setBorder(bd);
                Form.add(cells[r][c]);
            }
        }
        Form.setVisible(true);


           Form.addWindowListener(new WindowAdapter() {
               @Override
               public void windowClosing(WindowEvent e) {
                   super.windowClosing(e);
                   System.exit(0);
               }
           });
    }
}