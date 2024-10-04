package Latihan_5;

import java.awt.TextArea;
import java.awt.event.*;
import javax.swing.*;

public class HelloChecklBox extends JFrame {

    private boolean checkBoxSelected;

    public HelloChecklBox() {
        // Mengatur operasi penutupan JFrame
        this.checkBoxSelected = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat JLabel dengan teks "Hello World"
        JLabel labelInput = new JLabel("Masukkan Nama : ");
        labelInput.setBounds(15, 40, 350, 10);

        JTextField text = new JTextField();
        text.setBounds(15, 60, 350, 30);

        JCheckBox checkBox = new JCheckBox("Saya menyetujui syarat dan ketentuan yang berlaku");
        checkBox.setBounds(15,100,350,30);

        // Membuat JButton dengan teks "Klik"
        JButton button = new JButton("Klik");
        button.setBounds(15, 150, 100, 40);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15,200,350,100);

        checkBox.addItemListener( new ItemListener () {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange() == 1;
            }
        }
        );

                // Menambahkan ActionListener ke tombol
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mengubah teks label saat tombol diklik
                if (checkBoxSelected) {
                    String nama = text.getText();
                    txtOutput.append("Nama : " + nama + "\n");
                    text.setText("");
                } else {
                    txtOutput.append("Anda tidak mencentang kotak persetujuan");
                }
                
            }
        });

        // Menambahkan tombol dan label ke JFrame
        this.add(button);
        this.add(text);
        this.add(labelInput);
        this.add(txtOutput);
        this.add(checkBox);

        // Mengatur ukuran JFrame dan layout
        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        // Menjalankan aplikasi menggunakan SwingUtilities
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloChecklBox h = new HelloChecklBox();
                h.setVisible(true);
            }
        });
    }
}
