package sudoku;
import java.awt.*;
import javax.swing.*;
/**
 * The main Sudoku program
 */
public class SudokuMain extends JFrame {
    private static final long serialVersionUID = 1L;  // to prevent serial warning

    // private variables
    GameBoardPanel board = new GameBoardPanel();
    JButton btnNewGame = new JButton("New Game");

    // Constructor
    public SudokuMain() {
        // getContentPane itu  dari jframe
        //Container	getContentPane()
        //Returns the contentPane object for this frame.
        Container cp = getContentPane();

        //
        cp.setLayout(new BorderLayout());

        cp.add(board, BorderLayout.CENTER); // board masuk ke j panel
        // menambahkan j panel  board ke tengah

        // Add a button to the south to re-start the game via board.newGame()
        // manzil
        cp.add(btnNewGame, BorderLayout.SOUTH);

        // Initialize the game board to start the game
        board.newGame(); // biar fleksible buat sizenya, kla ful,l screen menyesuaikan

        pack();     // Pack the UI components, instead of using setSize()
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // to handle window-closing
        setTitle("Sudoku");
        setVisible(true);
    }


}