import java.awt.*;
import javax.swing.*;

public class MainApp extends JFrame {

    public MainApp() {
        // Set title and default close operation
        setTitle("Aplikasi Java dengan Multi Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem menuItem1 = new JMenuItem("Form Input 1");
        JMenuItem menuItem2 = new JMenuItem("Form Input 2");
        menu.add(menuItem1);
        menu.add(menuItem2);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Main panel with CardLayout for switching between forms
        JPanel mainPanel = new JPanel(new CardLayout());

        // Create and add Form 1 and Form 2 to main panel
        JPanel formPanel1 = new FormPanel1();
        JPanel formPanel2 = new FormPanel2();
        mainPanel.add(formPanel1, "Form Input 1");
        mainPanel.add(formPanel2, "Form Input 2");

        // Add action listeners for menu items to switch forms
        menuItem1.addActionListener(e -> showForm(mainPanel, "Form Input 1"));
        menuItem2.addActionListener(e -> showForm(mainPanel, "Form Input 2"));

        // Add main panel to frame
        add(mainPanel);

        setVisible(true);
    }

    private void showForm(JPanel mainPanel, String formName) {
        CardLayout cl = (CardLayout) mainPanel.getLayout();
        cl.show(mainPanel, formName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainApp::new);
    }
}
