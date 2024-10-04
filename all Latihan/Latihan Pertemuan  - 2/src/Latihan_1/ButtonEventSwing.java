package Latihan_1;

import java.awt.event.*;
import javax.swing.*;

public class ButtonEventSwing extends JFrame {

    public ButtonEventSwing() {
        // Mengatur operasi penutupan JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat JLabel dengan teks "Hello World"
        JLabel label = new JLabel("Hello World");
        label.setBounds(130, 40, 400, 10);

        // Membuat JButton dengan teks "Klik"
        JButton button = new JButton("Klik");
        button.setBounds(130, 100, 100, 40);

        // Menambahkan ActionListener ke tombol
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mengubah teks label saat tombol diklik
                label.setText("Hello Pemrograman II");
            }
        });

        // Menambahkan tombol dan label ke JFrame
        this.add(button);
        this.add(label);

        // Mengatur ukuran JFrame dan layout
        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        // Menjalankan aplikasi menggunakan SwingUtilities
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ButtonEventSwing b = new ButtonEventSwing();
                b.setVisible(true);
            }
        });
    }
}
