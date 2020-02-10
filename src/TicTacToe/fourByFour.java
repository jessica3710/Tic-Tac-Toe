/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToe;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Jessica
 */
public class fourByFour extends javax.swing.JFrame {

    //counter set to 0 and increases when a turn is made
    int counter = 0;
    //an array that stores the four by four tic tac toe board
    int[] tBoard = new int[16];

    Boolean winner = false;

    //when called gets the counter, number of button and which button it is
    //when it is pressed it will appear as an X on the button, next person to press it gives them an O
    //alternates turns
    private void pressed(int count, int button, JButton a) {
        if (winner) {
            return;
        }
        //when counter is even, X is placed in an empty spot
        if (count % 2 == 0) {
            tBoard[button] = 1; //all squares are set to two in the beginning, if a square has a 1 it is an X
            turn.setText("It is o's turn"); //changes the turn to alert the person playing in the position of O that it is their turn
            a.setText("X"); //sets button to show an X 
        } else {
            tBoard[button] = 0; //all squares are set to two in the beginning, if a square has a 0 it is an O
            turn.setText("It is x's turn"); //changes the turn to alert the person playing in the position of X that it is their turn
            a.setText("O"); //sets button to show an O
        }
        //disables the button that is pressed
        a.setEnabled(false);

    }

    //checks if they win, lose or tie then returns it
    private Boolean win(int counter) {

        winner = false;
        //if the counter is greater than 15, recognizes that it is a draw
        if (counter >= 15) {
            announce.setText("Draw");
            turn.setText(""); //game ends and it is no ones turn
        }
        //list of all of the winning options
        if ((tBoard[0] == tBoard[1] && tBoard[1] == tBoard[2] && tBoard[2] == tBoard[3] && tBoard[0] != 2)
                || (tBoard[0] == tBoard[5] && tBoard[5] == tBoard[10] && tBoard[10] == tBoard[15] && tBoard[0] != 2)
                || (tBoard[3] == tBoard[6] && tBoard[6] == tBoard[9] && tBoard[9] == tBoard[12] && tBoard[3] != 2)
                || (tBoard[4] == tBoard[5] && tBoard[5] == tBoard[6] && tBoard[6] == tBoard[7] && tBoard[4] != 2)
                || (tBoard[8] == tBoard[9] && tBoard[9] == tBoard[10] && tBoard[10] == tBoard[11] && tBoard[8] != 2)
                || (tBoard[12] == tBoard[13] && tBoard[13] == tBoard[14] && tBoard[14] == tBoard[15] && tBoard[12] != 2)
                || (tBoard[0] == tBoard[4] && tBoard[4] == tBoard[8] && tBoard[8] == tBoard[12] && tBoard[0] != 2)
                || (tBoard[1] == tBoard[5] && tBoard[5] == tBoard[9] && tBoard[9] == tBoard[13] && tBoard[1] != 2)
                || (tBoard[2] == tBoard[6] && tBoard[6] == tBoard[10] && tBoard[10] == tBoard[14] && tBoard[2] != 2)
                || (tBoard[3] == tBoard[7] && tBoard[7] == tBoard[11] && tBoard[11] == tBoard[15] && tBoard[3] != 2)) {
            //if counter is even then recognizes that it is the person who has the X symbol and knows that X won 
            if (counter % 2 == 0) {
                announce.setText("X is the Winner"); //announces that X has won
                turn.setText(""); //no ones turn anymore
            } //if it is not X, O has won the game and recognizes
            else {
                announce.setText("O is the Winner"); //announces that O has won
                turn.setText(""); //no ones turn anymore

            }
            //winner is set to true and stops allowing user to press other squares through pressed method
            winner = true;

        }
        //returns winner
        return winner;

    }

    //a method that runs the pressed method which allows both users to play, if winner is not true checks for a winner and increases the turn count
    private void playTurns(int countTurns, int buttonNumber, JButton buttonText) {
        //allows both players to choose a button
        pressed(countTurns, buttonNumber, buttonText);
        //when winner is not found yet, continues to check for the winner and increases the count
        if (!winner) {
            winner = win(counter); //checks for a winner
            counter++;
        }
    }

    /**
     * Creates new form fourByFour
     */
    public fourByFour() {
        initComponents();
        //disables the turn box
        turn.setEditable(false);
        //when i is smaller than 16, initializes all squares to 2
        for (int i = 0; i < 16; i++) {
            tBoard[i] = 2;
        }
        //set to x's turn, alerting that it is the player with the X symbol
        turn.setText("It is x's turn");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        zero = new javax.swing.JButton();
        one = new javax.swing.JButton();
        two = new javax.swing.JButton();
        three = new javax.swing.JButton();
        four = new javax.swing.JButton();
        five = new javax.swing.JButton();
        six = new javax.swing.JButton();
        seven = new javax.swing.JButton();
        eight = new javax.swing.JButton();
        nine = new javax.swing.JButton();
        ten = new javax.swing.JButton();
        eleven = new javax.swing.JButton();
        twelve = new javax.swing.JButton();
        thirteen = new javax.swing.JButton();
        fourteen = new javax.swing.JButton();
        fifteen = new javax.swing.JButton();
        mode = new javax.swing.JLabel();
        announce = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        turn = new javax.swing.JTextPane();
        menu = new javax.swing.JButton();
        replay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        eight.setFont(new java.awt.Font("Tahoma", 0, 75)); // NOI18N
        eight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightActionPerformed(evt);
            }
        });

        nine.setFont(new java.awt.Font("Tahoma", 0, 75)); // NOI18N
        nine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nineActionPerformed(evt);
            }
        });

        ten.setFont(new java.awt.Font("Tahoma", 0, 75)); // NOI18N
        ten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenActionPerformed(evt);
            }
        });

        eleven.setFont(new java.awt.Font("Tahoma", 0, 75)); // NOI18N
        eleven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elevenActionPerformed(evt);
            }
        });

        twelve.setFont(new java.awt.Font("Tahoma", 0, 75)); // NOI18N
        twelve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twelveActionPerformed(evt);
            }
        });

        thirteen.setFont(new java.awt.Font("Tahoma", 0, 75)); // NOI18N
        thirteen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thirteenActionPerformed(evt);
            }
        });

        fourteen.setFont(new java.awt.Font("Tahoma", 0, 75)); // NOI18N
        fourteen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fourteenActionPerformed(evt);
            }
        });

        fifteen.setFont(new java.awt.Font("Tahoma", 0, 75)); // NOI18N
        fifteen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fifteenActionPerformed(evt);
            }
        });

        mode.setFont(new java.awt.Font("Sitka Text", 0, 45)); // NOI18N
        mode.setText("Four by Four Mode");

        announce.setFont(new java.awt.Font("Sitka Text", 0, 20)); // NOI18N
        announce.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        turn.setFont(new java.awt.Font("Sitka Text", 0, 15)); // NOI18N
        jScrollPane1.setViewportView(turn);

        menu.setText("Menu");
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        replay.setText("Replay");
        replay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(mode))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eight, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(twelve, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nine, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(thirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ten, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eleven, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(zero, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(six, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(replay, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(announce, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(mode)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(zero, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(six, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(announce, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(eight, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(twelve, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nine, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(thirteen, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ten, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(fourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(replay, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(eleven, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(fifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void zeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zeroActionPerformed
        playTurns(counter, 0, zero);
    }//GEN-LAST:event_zeroActionPerformed

    private void oneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oneActionPerformed
        playTurns(counter, 1, one);
    }//GEN-LAST:event_oneActionPerformed

    private void twoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twoActionPerformed
        playTurns(counter, 2, two);
    }//GEN-LAST:event_twoActionPerformed

    private void threeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threeActionPerformed
        playTurns(counter, 3, three);
    }//GEN-LAST:event_threeActionPerformed

    private void fourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fourActionPerformed
        playTurns(counter, 4, four);
    }//GEN-LAST:event_fourActionPerformed

    private void fiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveActionPerformed
        playTurns(counter, 5, five);
    }//GEN-LAST:event_fiveActionPerformed

    private void sixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sixActionPerformed
        playTurns(counter, 6, six);
    }//GEN-LAST:event_sixActionPerformed

    private void sevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sevenActionPerformed
        playTurns(counter, 7, seven);
    }//GEN-LAST:event_sevenActionPerformed

    private void eightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightActionPerformed
        playTurns(counter, 8, eight);
    }//GEN-LAST:event_eightActionPerformed

    private void nineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nineActionPerformed
        playTurns(counter, 9, nine);
    }//GEN-LAST:event_nineActionPerformed

    private void tenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenActionPerformed
        playTurns(counter, 10, ten);
    }//GEN-LAST:event_tenActionPerformed

    private void elevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elevenActionPerformed
        playTurns(counter, 11, eleven);
    }//GEN-LAST:event_elevenActionPerformed

    private void twelveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twelveActionPerformed
        playTurns(counter, 12, twelve);
    }//GEN-LAST:event_twelveActionPerformed

    private void thirteenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thirteenActionPerformed
        playTurns(counter, 13, thirteen);
    }//GEN-LAST:event_thirteenActionPerformed

    private void fourteenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fourteenActionPerformed
        playTurns(counter, 14, fourteen);
    }//GEN-LAST:event_fourteenActionPerformed

    private void fifteenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fifteenActionPerformed
        playTurns(counter, 15, fifteen);
    }//GEN-LAST:event_fifteenActionPerformed

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        //closes current screen and returns back to the main menu
        JFrame tic = new TicTacToe();
        tic.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuActionPerformed

    private void replayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replayActionPerformed
        //closes the current screen and shows another four by four mode screen that is reset
        JFrame fourByFour = new fourByFour();
        fourByFour.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_replayActionPerformed

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
            java.util.logging.Logger.getLogger(fourByFour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fourByFour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fourByFour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fourByFour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fourByFour().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel announce;
    private javax.swing.JButton eight;
    private javax.swing.JButton eleven;
    private javax.swing.JButton fifteen;
    private javax.swing.JButton five;
    private javax.swing.JButton four;
    private javax.swing.JButton fourteen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton menu;
    private javax.swing.JLabel mode;
    private javax.swing.JButton nine;
    private javax.swing.JButton one;
    private javax.swing.JButton replay;
    private javax.swing.JButton seven;
    private javax.swing.JButton six;
    private javax.swing.JButton ten;
    private javax.swing.JButton thirteen;
    private javax.swing.JButton three;
    private javax.swing.JTextPane turn;
    private javax.swing.JButton twelve;
    private javax.swing.JButton two;
    private javax.swing.JButton zero;
    // End of variables declaration//GEN-END:variables
}
