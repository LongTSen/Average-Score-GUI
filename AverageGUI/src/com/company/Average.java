package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Average extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 150;

    public JTextField scoreBox;
    public JTextField aveScoreBox;
    public JTextField GPABox;
    public Listener listener;



    public Average() {
        setTitle("GPA Calculator");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);
    }

    public void createContents() {
        JPanel scorePannel;
        JPanel avePannel;
        JPanel GPAPannel;
        JPanel addPannel;
        JPanel restartPannel;
        JLabel scoreLable;
        JLabel aveScoreLable;
        JLabel GPALable;
        JButton addScore;
        JButton restart;

        setLayout(new GridLayout(2, 3));

        scoreLable = new JLabel("score:");
        scoreBox = new JTextField(8);
        scorePannel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        scorePannel.add(scoreLable);
        scorePannel.add(scoreBox);

        addScore = new JButton("Add Score");
        addPannel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addPannel.add(addScore);

        restart = new JButton("Restart");
        restartPannel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        restartPannel.add(restart);

        aveScoreLable = new JLabel("Average Score:");
        aveScoreBox = new JTextField(8);
        avePannel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        avePannel.add(aveScoreLable);
        avePannel.add(aveScoreBox);

        GPALable = new JLabel("GPA");
        GPABox = new JTextField(8);
        GPAPannel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        GPAPannel.add(GPALable);
        GPAPannel.add(GPABox);

        add(scorePannel);
        add(addPannel);
        add(avePannel);
        add(new JLabel());
        add(restartPannel);
        add(GPAPannel);
        listener = new Listener();
            addScore.addActionListener(listener);
            restart.addActionListener(listener);

    }

    public class Listener implements ActionListener {

        private double x;
        private double aveScore;
        private int i=0;
        private double totalScore = 0;
        private double GPA;
        private double totalGPA=0;
        public void actionPerformed(ActionEvent e) {
            boolean valid = false;
            String input;
            input = scoreBox.getText();
            if (e.getActionCommand().equalsIgnoreCase("Add Score")) {
                try {
                    x = Double.parseDouble(input);
                    valid = true;
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Enter double");
                }
                if(x>10||x<0&&valid)
                {
                    valid = false;
                    JOptionPane.showMessageDialog(null,"Enter 0.00 to 10.00");
                }
            if(scoreBox.getText()!=null&&valid==true) {
                    i++;
                    totalScore += x;
                    aveScore = totalScore / i;
                    if (x >= 9) {
                        totalGPA += 4;
                        GPA = totalGPA / i;
                    } else if (x >= 8 && x < 9) {
                        totalGPA += 3;
                        GPA = totalGPA / i;
                    } else if (x >= 7 && x < 8) {
                        totalGPA += 2;
                        GPA = totalGPA / i;
                    } else if (x >= 6 && x < 7) {
                        totalGPA += 1;
                        GPA = totalGPA / i;
                    } else {
                        GPA = totalGPA / i;
                    }
                    aveScoreBox.setText(String.format("%7.2f", aveScore));
                    GPABox.setText(String.format("%7.2f", GPA));
                    scoreBox.setText("");
                }
            }
            if (e.getActionCommand().equalsIgnoreCase("Restart")) {
                    i = 0;
                    totalScore = 0;
                    totalGPA = 0;
                    aveScoreBox.setText("");
                    scoreBox.setText("");
                    GPABox.setText("");
                }
            }
            }
        }
