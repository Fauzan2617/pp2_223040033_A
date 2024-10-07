import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormInputRataKiri extends JFrame {

    // Komponen GUI
    private JTextField txtNama, txtNomorHP;
    private JRadioButton rbLaki, rbPerempuan;
    private JCheckBox cbWNA;
    private JButton btnSimpan;
    private JTextArea textArea;

    public FormInputRataKiri() {
        // Set judul frame
        setTitle("Form Input Rata Kiri");

        // Buat panel utama dengan GridBagLayout
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Margin antar komponen
        gbc.anchor = GridBagConstraints.WEST; // Set komponen rata kiri

        // Label dan TextField Nama
        JLabel lblNama = new JLabel("Nama:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        panel.add(lblNama, gbc);

        txtNama = new JTextField(20);
        gbc.gridx = 1;
        panel.add(txtNama, gbc);

        // Label dan TextField Nomor HP
        JLabel lblNomorHP = new JLabel("Nomor HP:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblNomorHP, gbc);

        txtNomorHP = new JTextField(20);
        gbc.gridx = 1;
        panel.add(txtNomorHP, gbc);

        // Label dan RadioButton Jenis Kelamin
        JLabel lblJenisKelamin = new JLabel("Jenis Kelamin:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblJenisKelamin, gbc);

        rbLaki = new JRadioButton("Laki-Laki");
        rbPerempuan = new JRadioButton("Perempuan");
        ButtonGroup bgJenisKelamin = new ButtonGroup();
        bgJenisKelamin.add(rbLaki);
        bgJenisKelamin.add(rbPerempuan);
        rbLaki.setSelected(true);  // Default dipilih Laki-Laki

        // Tambahkan radio button ke panel
        JPanel panelJenisKelamin = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        panelJenisKelamin.add(rbLaki);
        panelJenisKelamin.add(rbPerempuan);
        gbc.gridx = 1;
        panel.add(panelJenisKelamin, gbc);

        // Checkbox WNA
        cbWNA = new JCheckBox("Warga Negara Asing");
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(cbWNA, gbc);

        // Tombol Simpan
        btnSimpan = new JButton("Simpan");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;  // Rata kiri tombol
        panel.add(btnSimpan, gbc);

        // TextArea untuk hasil output
        textArea = new JTextArea(5, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(scrollPane, gbc);

        // Tambahkan panel ke frame
        add(panel, BorderLayout.NORTH);

        // Event handler tombol Simpan
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = txtNama.getText();
                String nomorHP = txtNomorHP.getText();
                String jenisKelamin = rbLaki.isSelected() ? "Laki-Laki" : "Perempuan";
                String wna = cbWNA.isSelected() ? "Ya" : "Tidak";

                // Tampilkan hasil input di TextArea
                textArea.setText("Nama        : " + nama + "\n"
                        + "Nomor HP    : " + nomorHP + "\n"
                        + "Jenis Kelamin: " + jenisKelamin + "\n"
                        + "WNA         : " + wna + "\n"
                        + "=========================================");
            }
        });

        // Set ukuran frame
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center di layar
        setVisible(true);
    }

    public static void main(String[] args) {
        // Jalankan aplikasi
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormInputRataKiri();
            }
        });
    }
}
