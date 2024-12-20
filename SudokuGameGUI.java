

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuGameGUI extends JFrame {
    private static final int SIZE = 9;
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 630;
    private JTextField[][] cells = new JTextField[SIZE][SIZE];

    public SudokuGameGUI() {
        setTitle("Sudoku Game");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Tạo bảng Sudoku
        JPanel sudokuPanel = new JPanel(new GridLayout(SIZE, SIZE));
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                cells[row][col] = new JTextField();
                cells[row][col].setHorizontalAlignment(JTextField.CENTER);
                cells[row][col].setFont(new Font("Arial", Font.BOLD, 20));
                cells[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                if ((row / 3 + col / 3) % 2 == 0) {
                    cells[row][col].setBackground(Color.LIGHT_GRAY); // Thêm màu nền cho ô lưới
                } else {
                    cells[row][col].setBackground(Color.WHITE);
                }
                sudokuPanel.add(cells[row][col]);
            }
        }

        // Tạo các nút điều khiển và bàn phím số
        JPanel controlPanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
        JButton undoButton = new JButton("Undo");
        JButton eraseButton = new JButton("Erase");
        JButton notesButton = new JButton("Notes");
        JButton hintButton = new JButton("Hint");

        undoButton.setBackground(Color.CYAN);
        eraseButton.setBackground(Color.ORANGE);
        notesButton.setBackground(Color.GREEN);
        hintButton.setBackground(Color.PINK);

        buttonPanel.add(undoButton);
        buttonPanel.add(eraseButton);
        buttonPanel.add(notesButton);
        buttonPanel.add(hintButton);

        JPanel keypadPanel = new JPanel(new GridLayout(3, 3));
        for (int i = 1; i <= 9; i++) {
            JButton numButton = new JButton(String.valueOf(i));
            numButton.setBackground(new Color(135, 206, 250)); // Màu xanh nhạt
            numButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Hành động khi nhấn nút số
                }
            });
            keypadPanel.add(numButton);
        }

        controlPanel.add(buttonPanel, BorderLayout.CENTER);
        controlPanel.add(keypadPanel, BorderLayout.SOUTH);

        // Thông tin trò chơi
        JPanel infoPanel = new JPanel(new GridLayout(1, 4));
        JLabel difficultyLabel = new JLabel("Difficulty: Easy");
        JLabel mistakesLabel = new JLabel("Mistakes: 2/3");
        JLabel scoreLabel = new JLabel("Score: 595");
        JLabel timeLabel = new JLabel("Time: 03:46");

        difficultyLabel.setForeground(Color.BLUE);
        mistakesLabel.setForeground(Color.RED);
        scoreLabel.setForeground(Color.MAGENTA);
        timeLabel.setForeground(Color.GREEN);

        infoPanel.add(difficultyLabel);
        infoPanel.add(mistakesLabel);
        infoPanel.add(scoreLabel);
        infoPanel.add(timeLabel);

        // Thêm các panel vào JFrame
        add(sudokuPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.EAST);
        add(infoPanel, BorderLayout.NORTH);

        // Nút New Game
        JButton newGameButton = new JButton("New Game");
        newGameButton.setFont(new Font("Arial", Font.BOLD, 20));
        newGameButton.setBackground(Color.YELLOW);
        add(newGameButton, BorderLayout.SOUTH);

        // Hiển thị cửa sổ
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SudokuGameGUI();
        });
    }
}






// import javax.swing.*;
// import java.awt.*;

// public class SudokuGUI extends JFrame {
//     private static final int SIZE = 9;
//     private static final int WIDTH = 1000;
//     private static final int HEIGHT = 630;
//     private JTextField[][] cells = new JTextField[SIZE][SIZE];

//     public SudokuGUI() {
//         setTitle("Sudoku Game");
//         setSize(WIDTH, HEIGHT);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLocationRelativeTo(null);

//         // Thiết lập layout cho cửa sổ chính
//         setLayout(new BorderLayout());

//         // Tạo bảng Sudoku
//         JPanel sudokuPanel = new JPanel();
//         sudokuPanel.setLayout(new GridLayout(SIZE, SIZE));

//         for (int row = 0; row < SIZE; row++) {
//             for (int col = 0; col < SIZE; col++) {
//                 cells[row][col] = new JTextField();
//                 cells[row][col].setHorizontalAlignment(JTextField.CENTER);
//                 cells[row][col].setFont(new Font("Arial", Font.BOLD, 20));
//                 cells[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));
//                 sudokuPanel.add(cells[row][col]);
//             }
//         }

//         // Thêm bảng Sudoku vào cửa sổ chính
//         add(sudokuPanel, BorderLayout.CENTER);

//         // Tạo nút để kiểm tra giải pháp
//         JButton checkButton = new JButton("Check Solution");
//         checkButton.setFont(new Font("Arial", Font.BOLD, 20));
//         add(checkButton, BorderLayout.SOUTH);

//         // Hiển thị cửa sổ
//         setVisible(true);
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             new SudokuGUI();
//         });
//     }
// }
