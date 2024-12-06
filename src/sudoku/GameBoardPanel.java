package sudoku;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameBoardPanel extends JPanel {
    private static final long serialVersionUID = 1L;  // to prevent serial warning

    // Define named constants for UI sizes
    public static final int CELL_SIZE = 60;   // Cell width/height in pixels
    // bujur sangkar
    public static final int BOARD_WIDTH  = CELL_SIZE * SudokuConstants.GRID_SIZE;
    public static final int BOARD_HEIGHT = CELL_SIZE * SudokuConstants.GRID_SIZE;
    // Board width/height in pixels

    // Define properties
    /** The game board composes of 9x9 Cells (customized JTextFields) */
    private Cell[][] cells = new Cell[SudokuConstants.GRID_SIZE][SudokuConstants.GRID_SIZE];
    /** It also contains a Puzzle with array numbers and isGiven */
    public Puzzle puzzle =  Puzzle.getInstance();;

    /** Constructor */
    public GameBoardPanel() {
        // Remove difficulty selector and control panel section
        super.setLayout(new GridLayout(SudokuConstants.GRID_SIZE, SudokuConstants.GRID_SIZE));  // JPanel

        // Allocate the 2D array of Cell, and added into JPanel.
        for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
            for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
                cells[row][col] = new Cell(row, col);
                super.add(cells[row][col]);   // JPanel
            }
        }

        // [TODO 3] Allocate a common listener as the ActionEvent listener for all the
        //  Cells (JTextFields)
        CellInputListener listener = new CellInputListener();

        // [TODO 4] Adds this common listener to all editable cells
        for (int row = 0; row < SudokuConstants.GRID_SIZE; row++) {
            for (int col = 0; col < SudokuConstants.GRID_SIZE; col++) {
                if (cells[row][col].isEditable()) {  // Check if the cell is editable
                    cells[row][col].addActionListener(listener);   // Add the action listener to the editable cell
                }
            }
        }

        super.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
    }

    /**
     * Generate a new puzzle; and reset the game board of cells based on the puzzle.
     * You can call this method to start a new game.
     */
    public void newGame() {
        // Since difficulty selector is removed, you might want to directly set a puzzle, for example:
        puzzle.newPuzzle("easy");

        // Reset all cells based on the new puzzle
        for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
            for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
                cells[row][col].newGame(puzzle.numbers[row][col], puzzle.isGiven[row][col]);
            }
        }
    }

    /**
     * Return true if the puzzle is solved
     * i.e., none of the cell have status of TO_GUESS or WRONG_GUESS
     */
    public boolean isSolved() {
        for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
            for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
                if (cells[row][col].status == CellStatus.TO_GUESS || cells[row][col].status == CellStatus.WRONG_GUESS) {
                    return false;
                }
            }
        }
        return true;
    }

    // Listener for editable cells
    private class CellInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Cell sourceCell = (Cell)e.getSource();
            int numberIn = Integer.parseInt(sourceCell.getText());

            // Check if the number is duplicate
            if (isDuplicate(sourceCell.row, sourceCell.col, numberIn)) {
                sourceCell.status = CellStatus.WRONG_GUESS;
                sourceCell.paint();
            } else {
                if (numberIn == sourceCell.number) {
                    sourceCell.status = CellStatus.CORRECT_GUESS;
                } else {
                    sourceCell.status = CellStatus.WRONG_GUESS;
                }
                sourceCell.paint();
            }
            if (!isDuplicateFound()) {
                if (isSolved()) {
                    JOptionPane.showMessageDialog(null, "Congratulations Bro");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Your number is duplicate bro ");
            }
        }
    }

    private boolean isDuplicate(int row, int col, int number) {
        for (int c = 0; c < SudokuConstants.GRID_SIZE; c++) {
            if (c != col && cells[row][c].getText().equals(String.valueOf(number))) {
                return true;
            }
        }
        for (int r = 0; r < SudokuConstants.GRID_SIZE; r++) {
            if (r != row && cells[r][col].getText().equals(String.valueOf(number))) {
                return true;
            }
        }

        int subGridRowStart = (row / SudokuConstants.SUBGRID_SIZE) * SudokuConstants.SUBGRID_SIZE;
        int subGridColStart = (col / SudokuConstants.SUBGRID_SIZE) * SudokuConstants.SUBGRID_SIZE;
        for (int r = subGridRowStart; r < subGridRowStart + SudokuConstants.SUBGRID_SIZE; r++) {
            for (int c = subGridColStart; c < subGridColStart + SudokuConstants.SUBGRID_SIZE; c++) {
                if ((r != row || c != col) && cells[r][c].getText().equals(String.valueOf(number))) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isDuplicateFound() {
        for (int r = 0; r < SudokuConstants.GRID_SIZE; r++) {
            for (int c = 0; c < SudokuConstants.GRID_SIZE; c++) {
                if (!cells[r][c].getText().isEmpty()) {
                    int numberIn = Integer.parseInt(cells[r][c].getText());
                    if (isDuplicate(r, c, numberIn)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
