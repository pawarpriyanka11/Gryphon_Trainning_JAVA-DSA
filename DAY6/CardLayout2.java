package DAY6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardLayout2 extends JFrame implements ActionListener {

    CardLayout mainCL, subCL;
    JPanel mainPanel, numbersPanel, alphabetsPanel, subPanel;
    JButton num1, num2, num3;

    public CardLayout2() {

        setTitle("CardLayout Example");
        setLayout(new FlowLayout());

        // Main CardLayout
        mainCL = new CardLayout();
        mainPanel = new JPanel(mainCL);

        // ---------------- Numbers Panel ----------------
        numbersPanel = new JPanel(new BorderLayout());

        JPanel numberButtons = new JPanel();
        num1 = new JButton("1");
        num2 = new JButton("2");
        num3 = new JButton("3");

        numberButtons.add(num1);
        numberButtons.add(num2);
        numberButtons.add(num3);

        // Sub CardLayout
        subCL = new CardLayout();
        subPanel = new JPanel(subCL);

        // Panel for button 1
        JPanel onePanel = new JPanel();
        onePanel.add(new JButton("1i"));
        onePanel.add(new JButton("1ii"));
        onePanel.add(new JButton("1iii"));
        onePanel.add(new JButton("1iv"));

        // Calculator panel
        JPanel calculatorPanel = createCalculator();

        // Histogram panel
        JPanel histPanel = createHist();

        subPanel.add(new JPanel(), "EMPTY");
        subPanel.add(onePanel, "ONE");
        subPanel.add(calculatorPanel, "CALC");
        subPanel.add(histPanel, "HIST");

        subCL.show(subPanel, "EMPTY");

        numbersPanel.add(numberButtons, BorderLayout.NORTH);
        numbersPanel.add(subPanel, BorderLayout.CENTER);

        // ---------------- Alphabets Panel ----------------
        alphabetsPanel = new JPanel();
        alphabetsPanel.add(new JButton("A"));
        alphabetsPanel.add(new JButton("B"));
        alphabetsPanel.add(new JButton("C"));
        alphabetsPanel.add(new JButton("D"));

        // Add to main panel
        mainPanel.add(numbersPanel, "Numbers");
        mainPanel.add(alphabetsPanel, "Alphabets");

        // Top buttons
        JButton numbersBtn = new JButton("Numbers");
        JButton alphabetsBtn = new JButton("Alphabets");

        add(numbersBtn);
        add(alphabetsBtn);
        add(mainPanel);

        // Listeners
        numbersBtn.addActionListener(this);
        alphabetsBtn.addActionListener(this);
        num1.addActionListener(this);
        num2.addActionListener(this);
        num3.addActionListener(this);

        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    // ---------------- Calculator ----------------
    JPanel createCalculator() {
        JPanel calc = new JPanel(new GridLayout(4, 4, 5, 5));

        String[] buttons = {
            "7","8","9","-",
            "4","5","6","*",
            "1","2","3","+",
            ".","0","=","/"
        };

        for (String text : buttons) {
            calc.add(new JButton(text));
        }
        return calc;
    }

    // ---------------- Histogram ----------------
    JPanel createHist() {
        JPanel panel = new JPanel();
        int[] arr = {60, 20, 50, 40, 10, 50, 60};

        int maxArea = getMaxArea(arr);
        panel.add(new JLabel("Max Histogram Area = " + maxArea));

        return panel;
    }

    int getMaxArea(int[] arr) {
        int res = 0, n = arr.length;

        for (int i = 0; i < n; i++) {
            int curr = arr[i];

            for (int j = i - 1; j >= 0 && arr[j] >= arr[i]; j--)
                curr += arr[i];

            for (int j = i + 1; j < n && arr[j] >= arr[i]; j++)
                curr += arr[i];

            res = Math.max(res, curr);
        }
        return res;
    }

    // ---------------- Actions ----------------
    public void actionPerformed(ActionEvent ae) {

        String cmd = ae.getActionCommand();

        if (cmd.equals("Numbers")) {
            mainCL.show(mainPanel, "Numbers");
        }
        else if (cmd.equals("Alphabets")) {
            mainCL.show(mainPanel, "Alphabets");
        }
        else if (cmd.equals("1")) {
            subCL.show(subPanel, "ONE");
        }
        else if (cmd.equals("2")) {
            subCL.show(subPanel, "CALC");
        }
        else if (cmd.equals("3")) {
            subCL.show(subPanel, "HIST");
        }
    }

    public static void main(String[] args) {
        new CardLayout2();
    }
}
