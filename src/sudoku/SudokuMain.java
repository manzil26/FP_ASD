package sudoku;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        // to do add menu (manzil)
        JMenuBar menuBar = new JMenuBar();

        // Create "File" Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem newGameItem = new JMenuItem("New Game");
        JMenuItem resetGameItem = new JMenuItem("Reset Game");
        JMenuItem exitItem = new JMenuItem("Exit");


        // Add action listeners for menu items
        newGameItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.newGame();  // Start a new game
            }
        });

        resetGameItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.newGame();  // Reset the game
            }
        });

        // Add menu items to the " file" Menu
        fileMenu.add(newGameItem);
        fileMenu.add(resetGameItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // create "option" menu
        JMenu optionsMenu = new JMenu("Options");
        JMenuItem changeDifficultyItem = new JMenuItem("Change Difficulty");
        changeDifficultyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Difdiculty options can be added here. ");
            }
        });
        JMenuItem enableSoundItem = new JMenuItem("Enable Sound ");
        enableSoundItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Sound enable/ disable");

            }
        });



        optionsMenu.add(changeDifficultyItem);
        optionsMenu.add(enableSoundItem);

        // Create "Help" menu
        // Create "Help" menu
        JMenu helPMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About"); // Gunakan JMenuItem, bukan JMenu
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Sudoku Game\n\nDeveloped by Jawan Indian Lilahita'alah Group", "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JMenuItem instructionItem = new JMenuItem("Instruction");
        instructionItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "To play Sudoku:\n1. Fill in numbers.\n2. Make sure each row, column, and 3x3 box contains unique numbers.", "Instructions", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        helPMenu.add(aboutItem);
        helPMenu.add(instructionItem);

        // add menu to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(optionsMenu);
        menuBar.add(helPMenu);

        // set the menu bar to the frame
        setJMenuBar(menuBar);
        pack();     // Pack the UI components, instead of using setSize()
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // to handle window-closing
        setTitle("Sudoku");
        setVisible(true);
    }


}