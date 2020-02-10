/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToe;

import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Jessica
 */
public class aiUnbeatable extends javax.swing.JFrame {

    //counter set to 0 and increases when a turn is made
    int counter = 0;
    //an array that stores the tic tac toe board
    int[] ai = new int[9];

    Boolean winner = false;
    //initializes a random, used in creating random moves
    Random rand = new Random();

    //when called gets the counter, number of button and which button it is
    //when it is pressed it will appear as an X on the button
    private void pressed(int count, int button, JButton a) {
        if (winner) {
            return;
        }
        //human starts the game and is the X symbol in the game
        //if counter is even then execute the code
        if (count % 2 == 0) {
            ai[button] = 1; //all squares are set to two in the beginning, if a square has a 1 it is an X
            turn.setText(""); //sets the turn to nothing allows the AI to do their turn
            a.setText("X"); //sets button to show an X
        }
        //disables the button that is pressed
        a.setEnabled(false);
    }

    //finds the button and returns the number
    private JButton findButton(int buttonNumber) {
        //for each button it will return its number and allow other methods to recognize its number
        switch (buttonNumber) {
            case 0:
                return zero;
            case 1:
                return one;
            case 2:
                return two;
            case 3:
                return three;
            case 4:
                return four;
            case 5:
                return five;
            case 6:
                return six;
            case 7:
                return seven;
            case 8:
                return eight;
        }
        return null; //returns nothing if none of the buttons are found
    }

    //counts the number of empty squares 
    private int count() {
        int empty = 0;
        for (int i = 0; i < 9; i++) {
            //all squares are set to 2 in the beginning, so if empty it will be a 2
            if (ai[i] == 2) {
                empty++;
            }
        }
        return empty; //returns the number of empty squares
    }

    //checks if two out of three spots are filled in with an O, if third spot is open places it there to win
    private boolean winningSpots(int one, int two, int three) {
        return (ai[one] == ai[two] && ai[one] == 0 && ai[three] == 2);
    }

    //checks if two out of three spots are filled in a line while third spot is still open
    //method that defends the player from winning
    private boolean checkRow(int first, int second, int third) {
        return (ai[first] == ai[second] && ai[first] != 2 && ai[third] == 2);
    }

    //checks for traps and puts it in an assigned position which forces to draw 
    private boolean smart(int one, int two, int three) {
        return (ai[one] == ai[two] && ai[one] == 1 && ai[three] == 0);
    }

    //fills the assigned spot with an O
    //initializes the square to a 0 and sets the button to an O
    private void fillSquare(int i) {
        ai[i] = 0;
        turn.setText("It is your turn"); //switches the turns to alert the human that it is their turn
        findButton(i).setText("O"); //fills the button with an O
        findButton(i).setEnabled(false); //disables the button
    }

    //checks for win spots, then defends by blocking and then checks for traps, if none apply then chooses a randomized empty spot
    private void aIntelligence() {

        int emptyCells = 0;
        //all the combinations that may lead to a win, if so takes it immediately to win
        if (winningSpots(1, 2, 0)) {
            fillSquare(0);
        } else if (winningSpots(0, 2, 1)) {
            fillSquare(1);
        } else if (winningSpots(0, 1, 2)) {
            fillSquare(2);
        } else if (winningSpots(3, 4, 5)) {
            fillSquare(5);
        } else if (winningSpots(3, 5, 4)) {
            fillSquare(4);
        } else if (winningSpots(4, 5, 3)) {
            fillSquare(3);
        } else if (winningSpots(6, 7, 8)) {
            fillSquare(8);
        } else if (winningSpots(6, 8, 7)) {
            fillSquare(7);
        } else if (winningSpots(7, 8, 6)) {
            fillSquare(6);
        } else if (winningSpots(0, 3, 6)) {
            fillSquare(6);
        } else if (winningSpots(3, 6, 0)) {
            fillSquare(0);
        } else if (winningSpots(0, 6, 3)) {
            fillSquare(3);
        } else if (winningSpots(1, 4, 7)) {
            fillSquare(7);
        } else if (winningSpots(4, 7, 0)) {
            fillSquare(0);
        } else if (winningSpots(1, 7, 0)) {
            fillSquare(0);
        } else if (winningSpots(2, 5, 8)) {
            fillSquare(8);
        } else if (winningSpots(5, 8, 2)) {
            fillSquare(2);
        } else if (winningSpots(2, 8, 5)) {
            fillSquare(5);
        } else if (winningSpots(0, 4, 8)) {
            fillSquare(8);
        } else if (winningSpots(4, 8, 0)) {
            fillSquare(0);
        } else if (winningSpots(0, 8, 4)) {
            fillSquare(4);
        } else if (winningSpots(2, 4, 6)) {
            fillSquare(6);
        } else if (winningSpots(4, 6, 2)) {
            fillSquare(2);
        } else if (winningSpots(6, 2, 4)) {
            fillSquare(4);
        } //if no winning spots are there checks if we can block the human from winning
        //all combinations for blocking the human from winning
        else if (checkRow(0, 1, 2)) {
            fillSquare(2);
        } else if (checkRow(1, 2, 0)) {
            fillSquare(0);
        } else if (checkRow(0, 3, 6)) {
            fillSquare(6);
        } else if (checkRow(0, 4, 8)) {
            fillSquare(8);
        } else if (checkRow(1, 4, 7)) {
            fillSquare(7);
        } else if (checkRow(2, 5, 8)) {
            fillSquare(8);
        } else if (checkRow(2, 4, 6)) {
            fillSquare(6);
        } else if (checkRow(3, 4, 5)) {
            fillSquare(5);
        } else if (checkRow(4, 5, 3)) {
            fillSquare(3);
        } else if (checkRow(3, 6, 0)) {
            fillSquare(0);
        } else if (checkRow(6, 4, 2)) {
            fillSquare(2);
        } else if (checkRow(8, 4, 0)) {
            fillSquare(0);
        } else if (checkRow(7, 4, 1)) {
            fillSquare(1);
        } else if (checkRow(8, 5, 2)) {
            fillSquare(2);
        } else if (checkRow(6, 7, 8)) {
            fillSquare(8);
        } else if (checkRow(7, 8, 6)) {
            fillSquare(6);
        } else if (checkRow(0, 2, 1)) {
            fillSquare(1);
        } else if (checkRow(0, 6, 3)) {
            fillSquare(3);
        } else if (checkRow(0, 8, 4)) {
            fillSquare(4);
        } else if (checkRow(6, 8, 7)) {
            fillSquare(7);
        } else if (checkRow(3, 5, 4)) {
            fillSquare(4);
        } else if (checkRow(6, 2, 4)) {
            fillSquare(4);
        } else if (checkRow(1, 7, 4)) {
            fillSquare(4);
        } else if (checkRow(2, 8, 5)) {
            fillSquare(5);
        } //when counter greater than three and opponent has not choosen the middle spot, take the middle spot
        else if (counter >= 3 && ai[4] == 2) {
            fillSquare(4);
        } //combinations of traps that might appear and has an assigned spot to go to if it is empty
        else if (smart(2, 4, 6) && ai[7] == 2) {
            fillSquare(7);
        } else if (smart(6, 4, 2) && ai[8] == 2) {
            fillSquare(8);
        } else if (smart(2, 6, 4) && ai[3] == 2) {
            fillSquare(3);
        } else if (smart(1, 7, 4) && ai[0] == 2) {
            fillSquare(0);
        } else if (smart(4, 7, 1) && ai[0] == 2) {
            fillSquare(0);
        } else if (smart(7, 1, 4) && ai[0] == 2) {
            fillSquare(0);
        } else if (smart(3, 4, 5) && ai[2] == 2) {
            fillSquare(2);
        } else if (smart(4, 5, 3) && ai[2] == 2) {
            fillSquare(2);
        } else if (smart(5, 4, 3) && ai[2] == 2) {
            fillSquare(2);
        } else if (smart(8, 0, 4) && ai[7] == 2) {
            fillSquare(7);
        } else if (smart(4, 8, 0) && ai[6] == 2) {
            fillSquare(6);
        } else if (smart(0, 4, 8) && ai[7] == 2) {
            fillSquare(7);
        } //when they choose the corners take the middle spot if available
        else if (ai[0] == 1 && ai[4] == 2) {
            fillSquare(4);
        } else if (ai[2] == 1 && ai[4] == 2) {
            fillSquare(4);
        } else if (ai[8] == 1 && ai[4] == 2) {
            fillSquare(4);
        } else if (ai[6] == 1 && ai[4] == 2) {
            fillSquare(4);
        } //when move is placed on any of the sides except the corners go to designated corner if available
        else if (ai[5] == 1 && ai[8] == 2) {
            fillSquare(8);
        } else if (ai[7] == 1 && ai[8] == 2) {
            fillSquare(8);
        } else if (ai[3] == 1 && ai[6] == 2) {
            fillSquare(6);
        } else if (ai[1] == 1 && ai[2] == 2) {
            fillSquare(2);
        } //when first move goes to the middle then go to top left corner if available
        else if (ai[4] == 1 && ai[0] == 2) {
            fillSquare(0);
        } else if (ai[4] == 1 && ai[2] == 2) {
            fillSquare(2);
        } else if (ai[4] == 1 && ai[6] == 2) {
            fillSquare(6);
        } else if (ai[4] == 1 && ai[8] == 2) {
            fillSquare(8);
        } else {
            //if computer is in no threat, generates a random number between the number of empty squares
            int randNum = rand.nextInt(count()) + 1;
            //keeps looking for one until finds one that is empty
            for (int i = 0; i < ai.length; i++) {
                //if the current character in the array is empty, executes the following code
                if (ai[i] == 2) {

                    emptyCells++;
                    //when emptyCells is equal to the randNum, places an O in the button and disables the button
                    if (emptyCells == randNum) {

                        fillSquare(i); //fills the chosen spot and inserts an O, disables it and switches the turns

                    }

                }

            }
        }

    }

    //checks if they win, lose or tie then returns it
    private Boolean win(int counter) {
        //winner is set to false
        winner = false;
        //if the counter is greater than 8, recognizes that it is a draw
        if (counter >= 8) {
            announce.setText("Draw");
            turn.setText(""); //game ends and is no ones turn
        }
        //list of all of the winning options
        if ((ai[0] == ai[1] && ai[1] == ai[2] && ai[0] != 2)
                || (ai[0] == ai[3] && ai[3] == ai[6] && ai[0] != 2)
                || (ai[3] == ai[4] && ai[4] == ai[5] && ai[3] != 2)
                || (ai[6] == ai[7] && ai[7] == ai[8] && ai[6] != 2)
                || (ai[1] == ai[4] && ai[4] == ai[7] && ai[1] != 2)
                || (ai[2] == ai[5] && ai[5] == ai[8] && ai[2] != 2)
                || (ai[0] == ai[4] && ai[4] == ai[8] && ai[0] != 2)
                || (ai[2] == ai[4] && ai[4] == ai[6] && ai[2] != 2)) {
            //if counter is even then recognizes that it is the human and knows that you won
            if (counter % 2 == 0) {
                announce.setText("You Won!"); //announces that the human has won
                turn.setText(""); //no ones turn anymore
            } //if computer won the game prints out you lost
            else {
                announce.setText("You Lost"); //shows the human that they lost
                turn.setText(""); //no ones turn anymore, computer won

            }
            //winner is set to true and stops allowing user to press other squares through pressed method
            winner = true;

        }
        //returns winner
        return winner;

    }

    //a method which calls all the methods in the order, human goes first then AI
    private void playTurns(int buttonNumber, JButton buttonText) {
        //if no winner is found keeps running and allowing the human to press on squares
        if (winner == false) {
            pressed(counter, buttonNumber, buttonText); //allows the human to press a square
            winner = win(counter); //checks for a winner
            //when the turns made is less than eight and winner is not found yet, it allows the computer to go
            if (counter < 8 && winner == false) {
                counter++; //counter increases for the humans turn
                /*checks if the computer won first, defends the human, places it in the middle if empty, 
                checks for potential traps or generates a random number and places it there*/
                aIntelligence();
                winner = win(counter); //checks for a winner
                counter++; //increases counter for the computer's turn
            }
        }
    }

    /**
     * Creates new form aiHard2
     */
    public aiUnbeatable() {
        initComponents();
        //when i is smaller than 9, initializes all squares to 2
        for (int i = 0; i < 9; i++) {
            ai[i] = 2;
        }
        //disables the turn box
        turn.setEditable(false);
        //set to your turn, alerting the human that they make the first move
        turn.setText("It is your turn");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mode = new javax.swing.JLabel();
        eight = new javax.swing.JButton();
        zero = new javax.swing.JButton();
        one = new javax.swing.JButton();
        two = new javax.swing.JButton();
        three = new javax.swing.JButton();
        four = new javax.swing.JButton();
        five = new javax.swing.JButton();
        six = new javax.swing.JButton();
        seven = new javax.swing.JButton();
        announce = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        turn = new javax.swing.JTextPane();
        replay = new javax.swing.JButton();
        menu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(834, 604));

        mode.setFont(new java.awt.Font("Sitka Text", 0, 45)); // NOI18N
        mode.setText("Unbeatable Mode");

        eight.setFont(new java.awt.Font("Tahoma", 0, 75)); // NOI18N
        eight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightActionPerformed(evt);
            }
        });

        zero.setFont(new java.awt.Font("Tahoma", 0, 75)); // NOI18N
        zero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroActionPerformed(evt);
            }
        });

        one.setFont(new java.awt.Font("Tahoma", 0, 75)); // NOI18N
        one.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneActionPerformed(evt);
            }
        });

        two.setFont(new java.awt.Font("Tahoma", 0, 75)); // NOI18N
        two.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twoActionPerformed(evt);
            }
        });

        three.setFont(new java.awt.Font("Tahoma", 0, 75)); // NOI18N
        three.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threeActionPerformed(evt);
            }
        });

        four.setFont(new java.awt.Font("Tahoma", 0, 75)); // NOI18N
        four.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fourActionPerformed(evt);
            }
        });

        five.setFont(new java.awt.Font("Tahoma", 0, 75)); // NOI18N
        five.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveActionPerformed(evt);
            }
        });

        six.setFont(new java.awt.Font("Tahoma", 0, 75)); // NOI18N
        six.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sixActionPerformed(evt);
            }
        });

        seven.setFont(new java.awt.Font("Tahoma", 0, 75)); // NOI18N
        seven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sevenActionPerformed(evt);
            }
        });

        announce.setFont(new java.awt.Font("Sitka Text", 0, 45)); // NOI18N
        announce.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        turn.setFont(new java.awt.Font("Sitka Text", 0, 15)); // NOI18N
        jScrollPane1.setViewportView(turn);

        replay.setText("Replay");
        replay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replayActionPerformed(evt);
            }
        });

        menu.setText("Menu");
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(mode, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(zero, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(announce, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(six, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eight, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(replay, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(mode)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(zero, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(announce, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(six, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(eight, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(replay, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightActionPerformed
        playTurns(8, findButton(8));
    }//GEN-LAST:event_eightActionPerformed

    private void zeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zeroActionPerformed
        playTurns(0, findButton(0));
    }//GEN-LAST:event_zeroActionPerformed

    private void oneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oneActionPerformed
        playTurns(1, findButton(1));
    }//GEN-LAST:event_oneActionPerformed

    private void twoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twoActionPerformed
        playTurns(2, findButton(2));
    }//GEN-LAST:event_twoActionPerformed

    private void threeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threeActionPerformed
        playTurns(3, findButton(3));
    }//GEN-LAST:event_threeActionPerformed

    private void fourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fourActionPerformed
        playTurns(4, findButton(4));
    }//GEN-LAST:event_fourActionPerformed

    private void fiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveActionPerformed
        playTurns(5, findButton(5));
    }//GEN-LAST:event_fiveActionPerformed

    private void sixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sixActionPerformed
        playTurns(6, findButton(6));
    }//GEN-LAST:event_sixActionPerformed

    private void sevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sevenActionPerformed
        playTurns(7, findButton(7));
    }//GEN-LAST:event_sevenActionPerformed

    private void replayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replayActionPerformed
        //closes the current screen and shows another unbeatable mode screen that is reset
        JFrame aiUnbeatable = new aiUnbeatable();
        aiUnbeatable.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_replayActionPerformed

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        //closes current screen and returns back to the main menu
        JFrame tic = new TicTacToe();
        tic.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(aiUnbeatable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(aiUnbeatable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(aiUnbeatable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(aiUnbeatable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new aiUnbeatable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel announce;
    private javax.swing.JButton eight;
    private javax.swing.JButton five;
    private javax.swing.JButton four;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton menu;
    private javax.swing.JLabel mode;
    private javax.swing.JButton one;
    private javax.swing.JButton replay;
    private javax.swing.JButton seven;
    private javax.swing.JButton six;
    private javax.swing.JButton three;
    private javax.swing.JTextPane turn;
    private javax.swing.JButton two;
    private javax.swing.JButton zero;
    // End of variables declaration//GEN-END:variables
}
