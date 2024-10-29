import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FormPanel1 extends JPanel {
    private JTextField textField;
    private JTextArea textArea;
    private JRadioButton radioButton1, radioButton2;
    private JCheckBox checkBox;
    private JComboBox<String> comboBox;
    private JList<String> list;
    private JSlider slider;
    private JSpinner spinner;
    private JTable table;
    private DefaultTableModel tableModel;

    public FormPanel1() {
        setLayout(new BorderLayout());

        // Panel untuk memasukkan komponen input
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(9, 2, 5, 5));

        // JTextField
        inputPanel.add(new JLabel("Text Field:"));
        textField = new JTextField();
        inputPanel.add(textField);

        // JTextArea
        inputPanel.add(new JLabel("Text Area:"));
        textArea = new JTextArea(3, 20);
        inputPanel.add(new JScrollPane(textArea));

        // JRadioButton
        inputPanel.add(new JLabel("Radio Button:"));
        radioButton1 = new JRadioButton("Option 1");
        radioButton2 = new JRadioButton("Option 2");
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        JPanel radioPanel = new JPanel();
        radioPanel.add(radioButton1);
        radioPanel.add(radioButton2);
        inputPanel.add(radioPanel);

        // JCheckBox
        inputPanel.add(new JLabel("Check Box:"));
        checkBox = new JCheckBox("Agree?");
        inputPanel.add(checkBox);

        // JComboBox
        inputPanel.add(new JLabel("Combo Box:"));
        comboBox = new JComboBox<>(new String[] { "Option 1", "Option 2", "Option 3" });
        inputPanel.add(comboBox);

        // JList
        inputPanel.add(new JLabel("List:"));
        list = new JList<>(new String[] { "Item 1", "Item 2", "Item 3" });
        inputPanel.add(new JScrollPane(list));

        // JSlider
        inputPanel.add(new JLabel("Slider:"));
        slider = new JSlider(0, 100, 50);
        inputPanel.add(slider);

        // JSpinner
        inputPanel.add(new JLabel("Spinner:"));
        spinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        inputPanel.add(spinner);

        // Panel untuk menampung input dan tombol
        add(inputPanel, BorderLayout.CENTER);

        // JTable
        String[] columns = { "Field", "Value" };
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.SOUTH);

        // Button to add input data to table
        JButton addButton = new JButton("Add to Table");
        addButton.addActionListener(e -> addToTable());
        add(addButton, BorderLayout.NORTH);
    }

    private void addToTable() {
        tableModel.addRow(new Object[] { "TextField", textField.getText() });
        tableModel.addRow(new Object[] { "TextArea", textArea.getText() });
        tableModel.addRow(new Object[] { "RadioButton", radioButton1.isSelected() ? "Option 1" : "Option 2" });
        tableModel.addRow(new Object[] { "CheckBox", checkBox.isSelected() ? "Checked" : "Unchecked" });
        tableModel.addRow(new Object[] { "ComboBox", comboBox.getSelectedItem().toString() });
        tableModel.addRow(new Object[] { "List", list.getSelectedValue() });
        tableModel.addRow(new Object[] { "Slider", slider.getValue() });
        tableModel.addRow(new Object[] { "Spinner", spinner.getValue() });
    }
}
