package Latihan_7;

import javax.swing.*;
import java.awt.event.*;

public class AplikasiInputData extends JFrame {

    private JRadioButton male, female;
    private JCheckBox foreign;
    private ButtonGroup genderGroup;
    private boolean checkBoxSelected;

    public AplikasiInputData() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);
        this.setLayout(null);

        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(15, 20, 100, 20);
        JTextField textNama = new JTextField();
        textNama.setBounds(120, 20, 200, 20);

        JLabel labelHP = new JLabel("Nomor HP:");
        labelHP.setBounds(15, 50, 100, 20);
        JTextField textHP = new JTextField();
        textHP.setBounds(120, 50, 200, 20);

        JLabel labelGender = new JLabel("Jenis Kelamin:");
        labelGender.setBounds(15, 80, 100, 20);
        male = new JRadioButton("Laki-laki");
        female = new JRadioButton("Perempuan");
        male.setBounds(120, 80, 100, 20);
        female.setBounds(220, 80, 100, 20);
        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        female.setSelected(true);

        // Checkbox untuk pilihan WNA
        foreign = new JCheckBox("Warga Negara Asing");
        foreign.setBounds(15, 110, 350, 30);

        // Checkbox untuk persetujuan syarat dan ketentuan
        JCheckBox checkBox = new JCheckBox("Saya menyetujui syarat dan ketentuan yang berlaku");
        checkBox.setBounds(15, 140, 350, 30);

        JButton button = new JButton("Simpan");
        button.setBounds(15, 180, 100, 40);
        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15, 230, 450, 150);

        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange() == 1;
            }
        });

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBoxSelected) {
                    String nama = textNama.getText();
                    String hp = textHP.getText();
                    String gender = male.isSelected() ? "Laki-laki" : "Perempuan";
                    String wnaStatus = foreign.isSelected() ? "Ya" : "Bukan";

                    txtOutput.setText("Nama          : " + nama + "\n"
                                     + "Nomor HP      : " + hp + "\n"
                                     + "Jenis Kelamin : " + gender + "\n"
                                     + "WNA           : " + wnaStatus + "\n");
                } else {
                    txtOutput.setText("Anda tidak mencentang kotak persetujuan");
                }
            }
        });

        this.add(button);
        this.add(textNama);
        this.add(textHP);
        this.add(labelNama);
        this.add(labelHP);
        this.add(labelGender);
        this.add(male);
        this.add(female);
        this.add(foreign);
        this.add(txtOutput);
        this.add(checkBox);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AplikasiInputData app = new AplikasiInputData();
                app.setVisible(true);
            }
        });
    }
}
