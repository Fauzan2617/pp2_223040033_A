import javax.swing.*;
import java.awt.event.*;
import java.util.Date;

public class AplikasiInputData extends JFrame {

    private JRadioButton male, female;
    private JCheckBox foreign;
    private ButtonGroup genderGroup;
    private boolean checkBoxSelected;
    private JList<String> listJenisTabungan;
    private JSpinner spinnerFrekuensi, spinnerTanggalLahir;
    private JPasswordField passwordField, confirmPasswordField;
    private JTextField textNama, textHP;
    private JTextArea txtOutput;

    public AplikasiInputData() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 700);
        this.setLayout(null);

        // MenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem resetMenuItem = new JMenuItem("Reset");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        resetMenuItem.addActionListener(e -> resetForm());
        exitMenuItem.addActionListener(e -> System.exit(0));

        menu.add(resetMenuItem);
        menu.add(exitMenuItem);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        // Input Nama
        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(15, 20, 100, 20);
        textNama = new JTextField();
        textNama.setBounds(120, 20, 200, 20);

        // Input Nomor HP
        JLabel labelHP = new JLabel("Nomor HP:");
        labelHP.setBounds(15, 50, 100, 20);
        textHP = new JTextField();
        textHP.setBounds(120, 50, 200, 20);

        // Input Jenis Kelamin
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

        // Input WNA
        foreign = new JCheckBox("Warga Negara Asing");
        foreign.setBounds(15, 110, 350, 30);

        // Input Jenis Tabungan menggunakan JList
        JLabel labelJenisTabungan = new JLabel("Jenis Tabungan:");
        labelJenisTabungan.setBounds(15, 150, 100, 20);
        String[] jenisTabungan = {"Tabungan Pendidikan", "Tabungan Haji", "Tabungan Berjangka", "Tabungan Rencana"};
        listJenisTabungan = new JList<>(jenisTabungan);
        listJenisTabungan.setBounds(120, 150, 200, 60);
        listJenisTabungan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Input Frekuensi Transaksi per bulan menggunakan JSpinner
        JLabel labelFrekuensi = new JLabel("Frekuensi Transaksi:");
        labelFrekuensi.setBounds(15, 230, 150, 20);
        SpinnerNumberModel modelFrekuensi = new SpinnerNumberModel(1, 1, 100, 1);
        spinnerFrekuensi = new JSpinner(modelFrekuensi);
        spinnerFrekuensi.setBounds(170, 230, 50, 20);

        // Input Tanggal Lahir menggunakan JSpinner
        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir:");
        labelTanggalLahir.setBounds(15, 260, 150, 20);
        spinnerTanggalLahir = new JSpinner(new SpinnerDateModel(new Date(), null, null, java.util.Calendar.YEAR));
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerTanggalLahir, "dd/MM/yyyy");
        spinnerTanggalLahir.setEditor(editor);
        spinnerTanggalLahir.setBounds(170, 260, 100, 20);

        // Input Password dan Confirm Password
        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(15, 290, 100, 20);
        passwordField = new JPasswordField();
        passwordField.setBounds(120, 290, 200, 20);

        JLabel labelConfirmPassword = new JLabel("Konfirmasi Password:");
        labelConfirmPassword.setBounds(15, 320, 150, 20);
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(170, 320, 200, 20);

        // Checkbox Syarat dan Ketentuan
        JCheckBox checkBox = new JCheckBox("Saya menyetujui syarat dan ketentuan yang berlaku");
        checkBox.setBounds(15, 350, 400, 30);

        JButton button = new JButton("Simpan");
        button.setBounds(15, 400, 100, 40);
        txtOutput = new JTextArea("");
        txtOutput.setBounds(15, 460, 550, 150);

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
                    String jenisTabungan = listJenisTabungan.getSelectedValue();
                    int frekuensi = (int) spinnerFrekuensi.getValue();
                    Date tanggalLahir = (Date) spinnerTanggalLahir.getValue();
                    String password = new String(passwordField.getPassword());
                    String confirmPassword = new String(confirmPasswordField.getPassword());
                    String passwordStatus = password.equals(confirmPassword) ? "Cocok" : "Tidak Cocok";

                    txtOutput.setText("Nama          : " + nama + "\n"
                            + "Nomor HP      : " + hp + "\n"
                            + "Jenis Kelamin : " + gender + "\n"
                            + "WNA           : " + wnaStatus + "\n"
                            + "Jenis Tabungan: " + jenisTabungan + "\n"
                            + "Frekuensi Transaksi: " + frekuensi + " kali per bulan\n"
                            + "Tanggal Lahir : " + editor.getFormat().format(tanggalLahir) + "\n"
                            + "Password      : " + passwordStatus + "\n");
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
        this.add(listJenisTabungan);
        this.add(labelJenisTabungan);
        this.add(labelFrekuensi);
        this.add(spinnerFrekuensi);
        this.add(labelTanggalLahir);
        this.add(spinnerTanggalLahir);
        this.add(labelPassword);
        this.add(passwordField);
        this.add(labelConfirmPassword);
        this.add(confirmPasswordField);
        this.add(txtOutput);
        this.add(checkBox);
    }

    private void resetForm() {
        textNama.setText("");
        textHP.setText("");
        genderGroup.clearSelection();
        female.setSelected(true);
        foreign.setSelected(false);
        listJenisTabungan.clearSelection();
        spinnerFrekuensi.setValue(1);
        spinnerTanggalLahir.setValue(new Date());
        passwordField.setText("");
        confirmPasswordField.setText("");
        txtOutput.setText("");
        checkBoxSelected = false;
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
