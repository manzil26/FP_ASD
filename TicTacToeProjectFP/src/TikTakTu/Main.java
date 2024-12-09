package TikTakTu;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Pilih mode permainan
        boolean isAIMode = true; // true untuk manusia vs AI, false untuk manusia vs manusia

        SwingUtilities.invokeLater(() -> {
            // Buat JFrame untuk game
            JFrame frame = new JFrame(GameMain.TITLE); // Judul dari GameMain
            GameMain game = new GameMain();           // Instance GameMain
            game.initGame(isAIMode);                  // Inisialisasi dengan mode AI
            frame.setContentPane(game);               // Atur konten menjadi GameMaingit
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Tutup aplikasi saat JFrame ditutup
            frame.pack();                             // Menyesuaikan ukuran dengan preferensi GameMain
            frame.setLocationRelativeTo(null);        // Tempatkan JFrame di tengah layar
            frame.setVisible(true);                   // Tampilkan JFrame
        });
    }
}
