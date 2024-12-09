package TikTakTu;

import java.util.*;

public class AIPlayerMinimax extends AIPlayer {

    // Constructor untuk board permainan
    public AIPlayerMinimax(Board board) {
        super(board);
    }

    // Fungsi untuk mendapatkan langkah terbaik AI
    @Override
    public int[] move() {
        int[] bestMove = minimax(4, mySeed, Integer.MIN_VALUE, Integer.MAX_VALUE);  // Depth 4, dengan Alpha-Beta Pruning
        return new int[] {bestMove[1], bestMove[2]};  // Baris, Kolom
    }

    // Algoritma Minimax dengan Alpha-Beta Pruning
    private int[] minimax(int depth, Seed player, int alpha, int beta) {
        List<int[]> validMoves = generateValidMoves();

        int bestScore = (player == mySeed) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int currentScore;
        int bestRow = -1;
        int bestCol = -1;

        if (depth == 0 || validMoves.isEmpty()) {
            bestScore = evaluate();  // Evaluasi papan
        } else {
            for (int[] move : validMoves) {
                int row = move[0];
                int col = move[1];

                // Melakukan langkah
                cells[row][col].content = player;

                // Rekursif untuk melanjutkan ke tingkat kedalaman berikutnya
                if (player == mySeed) {
                    currentScore = minimax(depth - 1, oppSeed, alpha, beta)[0];
                    if (currentScore > bestScore) {
                        bestScore = currentScore;
                        bestRow = row;
                        bestCol = col;
                    }
                    alpha = Math.max(alpha, bestScore);
                } else {
                    currentScore = minimax(depth - 1, mySeed, alpha, beta)[0];
                    if (currentScore < bestScore) {
                        bestScore = currentScore;
                        bestRow = row;
                        bestCol = col;
                    }
                    beta = Math.min(beta, bestScore);
                }

                // Undo langkah
                cells[row][col].content = Seed.NO_SEED;

                // Alpha-Beta Pruning
                if (alpha >= beta) {
                    break;
                }
            }
        }

        return new int[] {bestScore, bestRow, bestCol};
    }

    // Fungsi untuk menghasilkan langkah-langkah valid bagi AI
    private List<int[]> generateValidMoves() {
        List<int[]> validMoves = new ArrayList<>();

        for (int col = 0; col < Board.COLS; col++) {
            // Cari baris pertama yang kosong di kolom yang dipilih
            for (int row = Board.ROWS - 1; row >= 0; row--) {
                if (cells[row][col].content == Seed.NO_SEED) {
                    validMoves.add(new int[] {row, col});
                    break;
                }
            }
        }

        return validMoves;
    }

    // Fungsi untuk mengevaluasi papan dan memberikan skor
    private int evaluate() {
        int score = 0;

        // Evaluasi horizontal, vertikal, dan diagonal
        score += evaluateLines();

        return score;
    }

    private int evaluateLines() {
        int score = 0;

        // Baris horizontal
        for (int row = 0; row < Board.ROWS; row++) {
            for (int col = 0; col < Board.COLS - 3; col++) {
                score += evaluateLine(row, col, 0, 1);  // pengecekan horizontal
            }
        }

        // Baris vertikal
        for (int col = 0; col < Board.COLS; col++) {
            for (int row = 0; row < Board.ROWS - 3; row++) {
                score += evaluateLine(row, col, 1, 0);  // pengecekan vertikal
            }
        }

        // Diagonal (atas kiri ke bawah kanan)
        for (int row = 0; row < Board.ROWS - 3; row++) {
            for (int col = 0; col < Board.COLS - 3; col++) {
                score += evaluateLine(row, col, 1, 1);  // pengecekan diagonal
            }
        }

        // Diagonal (bawah kiri ke atas kanan)
        for (int row = 3; row < Board.ROWS; row++) {
            for (int col = 0; col < Board.COLS - 3; col++) {
                score += evaluateLine(row, col, -1, 1); // pengecekan anti-diagonal
            }
        }

        return score;
    }

    // Fungsi untuk mengevaluasi satu baris (horizontal, vertikal, atau diagonal)
    private int evaluateLine(int row, int col, int deltaRow, int deltaCol) {
        int score = 0;
        int playerCount = 0;
        int opponentCount = 0;

        // Hitung jumlah bidak pemain dan lawan dalam garis
        for (int i = 0; i < 4; i++) {
            int r = row + i * deltaRow;
            int c = col + i * deltaCol;

            if (cells[r][c].content == mySeed) {
                playerCount++;
            } else if (cells[r][c].content == oppSeed) {
                opponentCount++;
            }
        }

        // Penilaian berdasarkan evaluasi garis
        if (playerCount == 4) {
            score += 1000;  // AI menang
        } else if (playerCount == 3 && opponentCount == 0) {
            score += 100;  // Potensi menang untuk AI
        } else if (playerCount == 2 && opponentCount == 0) {
            score += 10;  // AI bisa menang
        }

        if (opponentCount == 4) {
            score -= 1000;  // Lawan menang
        } else if (opponentCount == 3 && playerCount == 0) {
            score -= 100;  // Lawan bisa menang
        } else if (opponentCount == 2 && playerCount == 0) {
            score -= 10;  // Lawan mendekati kemenangan
        }

        return score;
    }
}
