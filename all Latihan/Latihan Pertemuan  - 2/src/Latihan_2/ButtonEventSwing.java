package Latihan_2;

import java.awt.event.*;
import javax.swing.*;

public class ButtonEventSwing extends JFrame {

    public ButtonEventSwing() {
        // Mengatur operasi penutupan JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat JLabel dengan teks "Hello World"
        JLabel labelInput = new JLabel("Masukkan Nama : ");
        labelInput.setBounds(130, 40, 400, 10);

        JTextField text = new JTextField();
        text.setBounds(130, 60, 100, 30);

        // Membuat JButton dengan teks "Klik"
        JButton button = new JButton("Klik");
        button.setBounds(130, 100, 100, 40);

        JLabel labelOutput = new JLabel("");
        labelOutput.setBounds(130,150,100,10);

        // Menambahkan ActionListener ke tombol
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mengubah teks label saat tombol diklik
                String nama = text.getText();
                labelOutput.setText("Hello"+nama);
            }
        });

        // Menambahkan tombol dan label ke JFrame
        this.add(button);
        this.add(text);
        this.add(labelInput);
        this.add(labelOutput);

        // Mengatur ukuran JFrame dan layout
        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        // Menjalankan aplikasi menggunakan SwingUtilities
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ButtonEventSwing h = new ButtonEventSwing();
                h.setVisible(true);
            }
        });
    }
}
