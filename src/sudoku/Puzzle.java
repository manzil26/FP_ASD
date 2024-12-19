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

import java.util.Random;

/**
 * The Sudoku number puzzle to be solved.
 */
public class Puzzle {
    // All variables have package access
    // The numbers on the puzzle
    int[][] numbers = new int[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE];
    // The clues - isGiven (no need to guess) or need to guess
    boolean[][] isGiven = new boolean[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE];

    private static Puzzle instance;

    // Constructor (private for Singleton)
    private Puzzle() {
        super();
    }

    // Singleton pattern to get the single instance of Puzzle
    public static Puzzle getInstance() {
        if (instance == null) {
            instance = new Puzzle();
        }
        return instance;
    }

    /**
     * Generate a new puzzle given the difficulty level (easy, medium, hard).
     * This method sets (or updates) the arrays `numbers` and `isGiven`.
     *
     * @param difficulty the level of difficulty ("easy", "medium", "hard")
     */
    public void newPuzzle(String difficulty) {
        // Hardcoded solution (kunci jawaban)
        int[][] hardcodedNumbers = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        // Copy the hardcoded solution into the `numbers` array
        for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
            for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
                numbers[row][col] = hardcodedNumbers[row][col];
            }
        }

        // Determine the number of cells to guess based on the difficulty
        int cellsToGuess;
        switch (difficulty.toLowerCase()) {
            case "easy":
                cellsToGuess = 20; // Easy: fewer empty cells
                break;
            case "medium":
                cellsToGuess = 40; // Medium: moderate number of empty cells
                break;
            case "hard":
                cellsToGuess = 60; // Hard: many empty cells
                break;
            default:
                cellsToGuess = 40; // Default to medium if invalid
        }

        // Initialize all cells as "given" (true)
        for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
            for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
                isGiven[row][col] = true;
            }
        }

        // Randomly empty cells to match the difficulty
        Random random = new Random();
        int count = 0;
        while (count < cellsToGuess) {
            int row = random.nextInt(SudokuConstants.GRID_SIZE);
            int col = random.nextInt(SudokuConstants.GRID_SIZE);

            // Only mark as "not given" if it's not already marked
            if (isGiven[row][col]) {
                isGiven[row][col] = false;
                count++;
            }
        }
    }

    /**
     * Display the current puzzle for testing purposes.
     */
    public void printPuzzle() {
        System.out.println("Puzzle:");
        for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
            for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
                if (isGiven[row][col]) {
                    System.out.print(numbers[row][col] + " ");
                } else {
                    System.out.print(". "); // Empty cells as "."
                }
            }
            System.out.println();
        }
    }
}
