package Latihan_1;


import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;


public class HelloBorderLayout extends JFrame{
   public HelloBorderLayout (){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel labelsatu = new JLabel ("Apakah Ibu kota Indonesia ?");
    JLabel labeldua = new JLabel("Apa jawaban anda");

    JButton ButtonA = new JButton("Jakarta");
    JButton ButtonB = new JButton("Bandung");
    JButton ButtonC = new JButton("Surabaya");

    ButtonA.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            labeldua.setText("Jawaban anda benar");
        }
    });

    ButtonB.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            labeldua.setText("Jawaban anda salah");
        }
    });

    ButtonC.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            labeldua.setText("Jawaban anda salah");
        }
    });

    this.add(labelsatu, BorderLayout.NORTH);
    this.add(labeldua,BorderLayout.SOUTH);
    this.add(ButtonA,BorderLayout.WEST);
    this.add(ButtonB, BorderLayout.CENTER);
    this.add(ButtonC, BorderLayout.EAST);
    this.setSize(400,200);


   }
   public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable(){
        public void run(){
            HelloBorderLayout h = new HelloBorderLayout();
                h.setVisible(true);
            }
        });
    
   }
}
