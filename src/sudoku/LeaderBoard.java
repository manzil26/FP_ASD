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

import java.util.*;

public class LeaderBoard {
    private List<ScoreEntry> scores;

    public LeaderBoard(){
        scores = new ArrayList<>();
    }

    public void addScores(String playerName, int score){
        scores.add(new ScoreEntry(playerName, score));
        Collections.sort(scores, Comparator.comparing(ScoreEntry::getScore));
    }

    public List<ScoreEntry> getTopScores(int limit) {
        return scores.subList(0, Math.min(limit, scores.size()));
    }
}
