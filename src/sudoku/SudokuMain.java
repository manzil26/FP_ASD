package sudoku;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

/**
 * The main Sudoku program
 */
public class SudokuMain extends JFrame {

    private static final long serialVersionUID = 1L;  // to prevent serial warning
    // private variables
    GameBoardPanel board = new GameBoardPanel();
    JButton btnNewGame = new JButton("New Game");

    private JButton btnSubmitScore = new JButton("Submit Score");
    private JTextField playerNameField = new JTextField(20);
    private LeaderBoard leaderBoard = new LeaderBoard();

    // Constructor
    public SudokuMain() {

        // getContentPane itu dari JFrame
        // Container getContentPane()
        // Returns the contentPane object for this frame.
        Container cp = getContentPane();

        //
        cp.setLayout(new BorderLayout());

        cp.add(board, BorderLayout.CENTER); // board masuk ke JPanel
        // menambahkan JPanel board ke tengah

        // Add a button to the south to re-start the game via board.newGame()
        // manzil
        // cp.add(btnNewGame, BorderLayout.SOUTH);

        // Initialize the game board to start the game
        board.newGame(); // biar fleksibel buat sizenya, kalau full screen menyesuaikan

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
                board.newGame();  // Langsung memulai game baru
            }
        });

        resetGameItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.newGame();  // Reset the game
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);  // Exit the program
            }
        });

        // Add menu items to the "File" Menu
        fileMenu.add(newGameItem);
        fileMenu.add(resetGameItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // Create "Options" menu
        JMenu optionsMenu = new JMenu("Options");
        JMenuItem changeDifficultyItem = new JMenuItem("Change Difficulty");
        changeDifficultyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"Easy", "Medium", "Hard"};
                int difficulty = JOptionPane.showOptionDialog(
                        null,
                        "Select Difficulty Level",
                        "Change Difficulty",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        options,
                        options[0]);

                int cellsToGuess;
                switch (difficulty) {
                    case 0:
                        cellsToGuess = 20; // Easy
                        break;
                    case 1:
                        cellsToGuess = 40; // Medium
                        break;
                    case 2:
                        cellsToGuess = 60; // Hard
                        break;
                    default:
                        return; // Cancel atau tutup
                }

                board.puzzle.newPuzzle("difficulty");
                board.newGame();
            }
        });
        JMenuItem enableSoundItem = new JMenuItem("Enable Sound");
        enableSoundItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Sound enable/disable");
            }
        });

        optionsMenu.add(changeDifficultyItem);
        optionsMenu.add(enableSoundItem);

        // Create "Help" menu
        JMenu helpMenu = new JMenu("Help");
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

        helpMenu.add(aboutItem);
        helpMenu.add(instructionItem);

        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(optionsMenu);
        menuBar.add(helpMenu);

        // Add a panel for score submission
        JPanel scorePanel = new JPanel();
        scorePanel.add(new JLabel("Player Name:"));
        scorePanel.add(playerNameField);
        scorePanel.add(btnSubmitScore);

        btnSubmitScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String playerName = playerNameField.getText();
                int score = calculateScore();
                leaderBoard.addScores(playerName, score);
                JOptionPane.showMessageDialog(null, "Score submitted!");
                playerNameField.setText(""); // Clear the input field
            }
        });

        JButton btnShowLeaderboard = new JButton("Show Leaderboard");
        btnShowLeaderboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLeaderboard();
            }
        });
        scorePanel.add(btnShowLeaderboard);

        // Add score panel to the bottom
        cp.add(scorePanel, BorderLayout.NORTH);

        // Set the menu bar to the frame
        setJMenuBar(menuBar);
        pack();     // Pack the UI components, instead of using setSize()
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // to handle window-closing
        setTitle("Sudoku");
        setVisible(true);
    }

    private void showLeaderboard() {
        JFrame leaderboardFrame = new JFrame("High Scores");
        JTextArea leaderboardArea = new JTextArea();
        leaderboardArea.setEditable(false);
        List<ScoreEntry> topScores = leaderBoard.getTopScores(10); // Use the instance variable
        for (ScoreEntry entry : topScores) {
            leaderboardArea.append(entry.getPlayerName() + ": " + entry.getScore() + "\n");
        }
        leaderboardFrame.add(new JScrollPane(leaderboardArea));
        leaderboardFrame.setSize(300, 400);
        leaderboardFrame.setVisible(true);
    }

    private int calculateScore() {
        // Implement your scoring logic here
        // For example, you could return a random score for testing
        return (int) (Math.random() * 100); // Replace with actual score calculation
    }
}
