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

public class ScoreEntry {
    private String playerName;
    private int score;

    public ScoreEntry(String playerName, int score){
        this.playerName = playerName;
        this.score = score;

    }

    public String getPlayerName(){
        return playerName;

    }

    public int getScore(){
        return score;
    }
}
