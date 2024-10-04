package Latihan_4;

import java.awt.TextArea;
import java.awt.event.*;
import javax.swing.*;

public class HelloTextArea2 extends JFrame {

    public HelloTextArea2() {
        // Mengatur operasi penutupan JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat JLabel dengan teks "Hello World"
        JLabel labelInput = new JLabel("Masukkan Nama : ");
        labelInput.setBounds(130, 40, 400, 10);

        JTextField text = new JTextField();
        text.setBounds(130, 50, 100, 30);

        JLabel labelInput2 = new JLabel("Masukkan Nomor Telepon : ");
        labelInput2.setBounds(130, 85, 400, 10);

        JTextField text2 = new JTextField();
        text2.setBounds(130, 100, 100, 30);

        // Membuat JButton dengan teks "Klik"
        JButton button = new JButton("Klik");
        button.setBounds(130, 150, 100, 40);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(130,200,100,100);

        // Menambahkan ActionListener ke tombol
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mengubah teks label saat tombol diklik
                String nama = text.getText();
                String no = text2.getText();
                txtOutput.append("Nama : " + nama + "\n"+ "no : " + no);
                text.setText("");
            }
        });

        // Menambahkan tombol dan label ke JFrame
        this.add(button);
        this.add(text);
        this.add(labelInput);
        this.add(text2);
        this.add(labelInput2);
        this.add(txtOutput);

        // Mengatur ukuran JFrame dan layout
        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        // Menjalankan aplikasi menggunakan SwingUtilities
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloTextArea2 h = new HelloTextArea2();
                h.setVisible(true);
            }
        });
    }
}
