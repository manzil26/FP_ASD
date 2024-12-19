/**
 * ES234317-Algorithm and Data Structures
 * Semester Ganjil, 2024/2025
 * Group Capstone Project
 * Group #1
 * 1 - 5026231037 - Al-khiqmah Manzilatul Mukaromah
 * 2 - 5026231095 - Akhtar Zia Faizarrobbi
 * 3 - 5026231227 - Arjuna Veetaraq
 */

package sudoku;
import javax.sound.sampled.*;
import java.io.InputStream;

public class SoundEffect {
    private Clip clip;

    public SoundEffect(String soundFileName) {
        try {
            // Use getResourceAsStream to load files inside the src folder
            InputStream audioSrc = getClass().getClassLoader().getResourceAsStream(soundFileName);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioSrc);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metode untuk memulai audio secara loop
    public void play() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    // Metode untuk menghentikan audio
    public void stop() {
        if (clip != null) {
            clip.stop();
        }
    }
}