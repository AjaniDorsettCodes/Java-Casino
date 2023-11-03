import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class BlackjackGUI extends JFrame implements ActionListener {
     JFrame frame = new JFrame();
     JLabel label = new JLabel();
     JLabel BlackJackNumberLabel = new JLabel();
     JLabel HitLabel = new JLabel();
     JButton HitButton = new JButton();
     JButton StandButton = new JButton();
     Double GamblingAmount;
     static double increment = 0.00;
     static int increment2;
     static double MoneyTest;
     Random rand = new Random();
     int RandomBlackjackNumber = rand.nextInt(21 - 1) + 1;
     int RandomHitNumber = rand.nextInt(10 -1) + 1;
     int NewHitNumber;
     int RandomCPUNumber = rand.nextInt(21);
     static double Money = 50000;
     int loserNumber;
     JTextField t = new JTextField();
     JButton labelButton = new JButton();
     //JTextField textField = new JTextField();


     BlackjackGUI() {

     }

     public void BlackjackGUI() {



          RandomBlackjackNumber = rand.nextInt(21 - 1) + 1;


          labelButton.setBounds(1, 1, 500, 25);
          labelButton.setText("Hello, let's play some blackjack (: " + "You're starting off with " + RandomBlackjackNumber);
          labelButton.addActionListener(this);
         // labelButton.setEnabled(false);


          HitButton = new JButton();
          HitButton.setBounds(0, 200, 200, 50);
          HitButton.addActionListener(this);
          HitButton.setText("Hit");
          HitButton.setFocusPainted(false);

          StandButton = new JButton();
          StandButton.setBounds(300, 200, 200, 50);
          StandButton.setText("Stand");
          StandButton.setFocusPainted(false);
          StandButton.addActionListener(this);


          Border border = BorderFactory.createLineBorder(Color.BLACK);
          JLabel label = new JLabel();
          label.setText("Hello, let's play some blackjack (: " + "You're starting off with " + RandomBlackjackNumber);
          label.setHorizontalTextPosition(JLabel.CENTER);
          label.setBorder(border);
          label.setHorizontalAlignment(JLabel.CENTER);
          label.setBounds(1, 1, 500, 25);

          JLabel BlackJackNumberLabel = new JLabel();
          // BlackJackNumberLabel.setBorder(border);
          //BlackJackNumberLabel.setVerticalAlignment();
          // BlackJackNumberLabel.setText(String.valueOf(RandomBlackjackNumber));
          BlackJackNumberLabel.setBounds(1, 1, 100, 25);

          //JTextField t = new JTextField();
          t.setPreferredSize(new Dimension(100, 25));
          t.setBounds(205, 150, 90, 25);
          t.setText("Enter AMT.");

          JTextField t2 = new JTextField();
          t2.setPreferredSize(new Dimension(0, 0));
          t2.setBounds(500, 500, 0, 0);
          //t2.setBackground(Color.black);

          JLabel label2 = new JLabel();
          label2.setBounds(500, 500, 0, 0);


          frame.setSize(500, 500);
          frame.setResizable(false);
          frame.setVisible(true);
          //frame.add(label);
          frame.add(HitButton);
          frame.add(StandButton);
          frame.add(BlackJackNumberLabel);
          frame.add(t);
          frame.add(t2);
          frame.add(labelButton);
          frame.add(label2);


          //System.out.println("This is the money " + Money);
          NewHitNumber = RandomBlackjackNumber + RandomHitNumber;
          //Money = 5000;
          //System.out.println("This is the Number: " + CasinoGUI.MyNumber);

          //MoneyChecker.MoneyChecker();
          System.out.println(Money);

     }// end of blackjackGUI method

     public double getMoney() {
          return Money;
     }

     public void setMoney(double money) {
          Money = money;
     }

     @Override
     public void actionPerformed(ActionEvent e) {
          increment = 0;


          increment = parseDouble(t.getText());


          if (e.getSource() == labelButton) {
               if (loserNumber > 0) {
                    JOptionPane.showMessageDialog(null,"You have " + NewHitNumber);
               }
               else{
                    JOptionPane.showMessageDialog(null,"You have " + RandomBlackjackNumber);
               }
          }


               if (e.getSource() == HitButton) {


                    System.out.println(RandomBlackjackNumber);
                    RandomHitNumber = rand.nextInt(10);
                    NewHitNumber = RandomHitNumber + NewHitNumber;
                    loserNumber = rand.nextInt(100);
                    loserNumber = loserNumber + NewHitNumber;

                    JOptionPane.showMessageDialog(null, "you now have " + NewHitNumber + " Hit or Stand?");
                    labelButton.setEnabled(true);

                    if (NewHitNumber > 21) {
                         JOptionPane.showMessageDialog(null, "You hit too hard, that means u lose");
                         increment = increment * -1;
                         frame.setVisible(false);
                    }//Went over 21, you lose


               }// hit button

               if (e.getSource() == StandButton && loserNumber > 0) {

                    JOptionPane.showMessageDialog(null, "You have " + NewHitNumber + " And i think you're great");

                    if (RandomCPUNumber > NewHitNumber) {
                         JOptionPane.showMessageDialog(null, "They have " + RandomCPUNumber + " You have " + NewHitNumber + " Looks like you're an ugly LOSER");
                         increment = increment * -1;
                    } else if (RandomCPUNumber < NewHitNumber) {
                         JOptionPane.showMessageDialog(null, "You have " + NewHitNumber + " They have " + RandomCPUNumber + " Looks like you're a chad WINNER");
                    } else if (RandomCPUNumber == NewHitNumber) {
                         JOptionPane.showMessageDialog(null, "You have " + NewHitNumber + " And they have " + RandomCPUNumber + " Looks like it's a tie");
                    }
                    frame.setVisible(false);

               }//stand button if the player hit

               else if (e.getSource() == StandButton) {
                    JOptionPane.showMessageDialog(null, "You have " + RandomBlackjackNumber + " you won't believe this, but you're still very great");
                    if (RandomBlackjackNumber > RandomCPUNumber) {
                         JOptionPane.showMessageDialog(null, "You have " + RandomBlackjackNumber + " and they have " + RandomCPUNumber + " Looks like you're a chad WINNER");
                    } else if (RandomBlackjackNumber < RandomCPUNumber) {
                         JOptionPane.showMessageDialog(null, "They have " + RandomCPUNumber + " You have " + RandomBlackjackNumber + " Looks like you're an ugly LOSER");
                         increment = increment * -1;
                    } else if (RandomBlackjackNumber == RandomCPUNumber) {
                         JOptionPane.showMessageDialog(null, "You have " + RandomBlackjackNumber + " And they have " + RandomCPUNumber + " Looks like it's a tie");
                         increment = 0;
                    }
                    System.out.println(RandomBlackjackNumber);
                    System.out.println(NewHitNumber);
                    frame.setVisible(false);
               }//stand button if the player did not hit
               increment2++;
          }//action performed

     }//class


