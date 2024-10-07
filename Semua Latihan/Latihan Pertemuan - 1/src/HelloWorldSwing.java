import javax.swing.*;

public class HelloWorldSwing {

    private static void createAndShowGUI() {
        // Membuat frame (jendela aplikasi) dengan judul
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat label dengan teks "Hello World"
        JLabel label = new JLabel("Hello Fauzan>");
        frame.getContentPane().add(label);  // Menambahkan label ke frame

        // Menyesuaikan ukuran frame sesuai komponen di dalamnya
        frame.pack();

        // Menampilkan jendela aplikasi
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Menjalankan kode GUI pada event-dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();  // Memanggil method untuk membuat dan menampilkan GUI
            }
        });
    }
}

