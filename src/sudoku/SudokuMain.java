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
        // Inisialisasi audio
        SoundEffect backSound = new SoundEffect("sudoku/bensound-clearday.wav");
        backSound.play(); // Memulai backsound
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

        JMenuItem toggleSoundItem = new JMenuItem("Mute sound");
        toggleSoundItem.addActionListener(new ActionListener() {
            private boolean isPlaying = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (isPlaying) {
                    backSound.stop(); // Hentikan audio
                    isPlaying = false;
                } else {
                    backSound.play(); // Putar ulang audio
                    isPlaying = true;
                }
            }
        });

        optionsMenu.add(toggleSoundItem);

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

        JButton btnShowLeaderboard = new JButton("Show Leaderboard");

        btnSubmitScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String playerName = playerNameField.getText();

                // Check if the player has entered a name
                if (playerName.isEmpty() ) {
                    JOptionPane.showMessageDialog(null, "Please enter your name.");
                    return;
                }
                if (!board.isSolved()) {
                    JOptionPane.showMessageDialog(null, "Please fill in the cells before submitting your score.");
                    return;
                }

                int score = calculateScore();

                // Check if the player has already submitted a score (duplicate)
                boolean isDuplicate = false;
                for (ScoreEntry entry : leaderBoard.getTopScores(10)) {
                    if (entry.getPlayerName().equals(playerName)) {
                        isDuplicate = true;
                        break;
                    }
                }

                // If it's a duplicate player, reduce score by 1
                if (isDuplicate) {
                    score -= 1;
                }

                // If the player hasn't started the game, set score to 0
                if (score == 0) {
                    JOptionPane.showMessageDialog(null, "You haven't started the game yet. Score is 0.");
                } else {
                    // Submit the score
                    leaderBoard.addScores(playerName, score);
                    JOptionPane.showMessageDialog(null, "Score submitted!");
                }

                // Clear the input field
                playerNameField.setText("");
            }
        });

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
        // Create a new JFrame to display the leaderboard
        JFrame leaderboardFrame = new JFrame("High Scores");

        // Create a JTextArea to display the leaderboard text
        JTextArea leaderboardArea = new JTextArea();
        leaderboardArea.setEditable(false);  // Make the text area non-editable

        // Retrieve the top scores from the leaderboard
        List<ScoreEntry> topScores = leaderBoard.getTopScores(10);  // Get the top 10 scores

        // If there are no scores, display a message
        if (topScores.isEmpty()) {
            leaderboardArea.append("No scores yet!\n");
        } else {
            // Loop through the top scores and add them to the JTextArea
            for (ScoreEntry entry : topScores) {
                leaderboardArea.append(entry.getPlayerName() + ": " + entry.getScore() + "\n");
            }
        }



        // Add the JTextArea to a JScrollPane for better readability if there are many scores
        JScrollPane scrollPane = new JScrollPane(leaderboardArea);

        // Set up the leaderboard window
        leaderboardFrame.add(scrollPane);
        leaderboardFrame.setSize(300, 400);
        leaderboardFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Close only this frame
        leaderboardFrame.setLocationRelativeTo(null);  // Center the frame
        leaderboardFrame.setVisible(true);
    }


    private int calculateScore() {
        // Implement your scoring logic here
        // For example, you could return a random score for testing
        return (int) (Math.random() * 100); // Replace with actual score calculation
    }
}