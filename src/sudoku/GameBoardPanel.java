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
    private Puzzle puzzle =  Puzzle.getInstance();;

    /** Constructor */

    public GameBoardPanel() {
        super.setLayout(new GridLayout(SudokuConstants.GRID_SIZE, SudokuConstants.GRID_SIZE));  // JPanel
       // panggil j panel
        // Allocate the 2D array of Cell, and added into JPanel.
        for (int row = 0; row < SudokuConstants.GRID_SIZE; ++row) {
            for (int col = 0; col < SudokuConstants.GRID_SIZE; ++col) {
                cells[row][col] = new Cell(row, col);
                super.add(cells[row][col]);   // JPanel  // ,etode dari jpanel
                // jpanel di tambah cells textfield ( row dan colom )
            }
        }

        // [TODO 3] Allocate a common listener as the ActionEvent listener for all the
        //  Cells (JTextFields)
        // manzil
        CellInputListener listener = new CellInputListener();

        // [TODO 4] Adds this common listener to all editable cells
        // manzil
        // Assuming SudokuConstants.GRID_SIZE is defined as 9 (or another grid size if needed)
        for (int row = 0; row < SudokuConstants.GRID_SIZE; row++) {  // Use the constant for row iteration
            for (int col = 0; col < SudokuConstants.GRID_SIZE; col++) {  // Use the constant for column iteration
                if (cells[row][col].isEditable()) {  // Check if the cell is editable
                    cells[row][col].addActionListener(listener);   // Add the action listener to the editable cell
                }
            }
        }

        super.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        // hanya ditambahkan di cell yang to gueest
    }

    // menambahkan metode difficult

    /**
     * Generate a new puzzle; and reset the game board of cells based on the puzzle.
     * You can call this method to start a new game.
     */
    public void newGame() {
        // Generate a new puzzle
        puzzle.newPuzzle(+1 );

        // Initialize all the 9x9 cells, based on the puzzle.
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

    // [TODO 2] Define a Listener Inner Class for all the editable Cells
    // manzil
    // [TODO 2] Define a Listener Inner Class for all the editable Cells
    private class CellInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) { // ketika sudah diisi apa yang kita lakukan

            // Get a reference of the JTextField that triggers this action event
            Cell sourceCell = (Cell)e.getSource();


            /*
             * [TODO 5] (later - after TODO 3 and 4)
             * Check the numberIn against sourceCell.number.
             * Update the cell status sourceCell.status,
             * and re-paint the cell via sourceCell.paint().
             */
            /*
             * [TODO 6] (later)
             * Check if the player has solved the puzzle after this move,
             *   by calling isSolved(). Put up a congratulation JOptionPane, if so.
             */

            // Retrieve the int entered
            int numberIn = Integer.parseInt(sourceCell.getText());
            // For debugging
            System.out.println("You entered " + numberIn);


            //chech duplicate (manzil to do )
            if (isDuplicate(sourceCell.row, sourceCell.col, numberIn)) {
                sourceCell.status = CellStatus.WRONG_GUESS; // Mark as wrong guess if there's a duplicate
                sourceCell.paint(); // Repaint the cell
            } else {
                // Check if the number entered is correct
                if (numberIn == sourceCell.number) {
                    sourceCell.status = CellStatus.CORRECT_GUESS; // Correct guess
                } else {
                    sourceCell.status = CellStatus.WRONG_GUESS; // Wrong guess
                    sourceCell.paint();
                }
                sourceCell.paint(); // Repaint the cell
            }
            if (!isDuplicateFound()) { // Ensure no duplicates exist
                if (isSolved()) {
                    JOptionPane.showMessageDialog(null, "Congratulations Bro");
                }
            }  else {
                JOptionPane.showMessageDialog(null, "Your number is duplicate bro ");

            }

            }

        }

        // manzil to do
        private boolean isDuplicate(int row, int col, int number) {
            // Check the row
            for (int c = 0; c < SudokuConstants.GRID_SIZE; c++) {
                if (c != col && cells[row][c].getText().equals(String.valueOf(number))) {
                    return true; // Duplicate found in the row
                }
            }

            // Check the column
            for (int r = 0; r < SudokuConstants.GRID_SIZE; r++) {
                if (r != row && cells[r][col].getText().equals(String.valueOf(number))) {
                    return true; // Duplicate found in the column
                }
            }

            // Check the sub-grid
            int subGridRowStart = (row / SudokuConstants.SUBGRID_SIZE) * SudokuConstants.SUBGRID_SIZE;
            int subGridColStart = (col / SudokuConstants.SUBGRID_SIZE) * SudokuConstants.SUBGRID_SIZE;

            for (int r = subGridRowStart; r < subGridRowStart + SudokuConstants.SUBGRID_SIZE; r++) {
                for (int c = subGridColStart; c < subGridColStart + SudokuConstants.SUBGRID_SIZE; c++) {
                    if ((r != row || c != col) && cells[r][c].getText().equals(String.valueOf(number))) {
                        return true; // Duplicate found in the sub-grid
                    }
                }
            }

            return false; // No duplicates found
        }
    private boolean isDuplicateFound() {
        for (int r = 0; r < SudokuConstants.GRID_SIZE; r++) {
            for (int c = 0; c < SudokuConstants.GRID_SIZE; c++) {
                // Only check cells that are not empty
                if (!cells[r][c].getText().isEmpty()) {
                    int numberIn = Integer.parseInt(cells[r][c].getText());
                    if (isDuplicate(r, c, numberIn)) {
                        return true; // If duplicate is found, return true
                    }
                }
            }
        }
        return false; // No duplicates found
    }





    }

