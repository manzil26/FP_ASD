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
