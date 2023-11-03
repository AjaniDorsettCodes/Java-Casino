import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import static java.lang.Double.parseDouble;

public class LuckyNumberGUI extends JFrame implements ActionListener {
    JButton LabelButton = new JButton();
    JButton HigherOrLowerButton = new JButton();
    JButton HintButton = new JButton();
    JButton FactorsButton = new JButton();
    JButton MultiplesButton = new JButton();
    JButton  EnterNumberButton = new JButton();
    JTextField textField = new JTextField();
    Random rand = new Random();
    int LuckyNumber = rand.nextInt(100 - 1) + 1;
    JFrame frame = new JFrame();
    public void LuckyNumberGUI(){
        System.out.println("This is the Lucky Number: " + LuckyNumber);

        textField.setBounds(205, 150, 90, 25);
        textField.setText("Enter AMT.");

        EnterNumberButton.setBounds(197,300,100,50);
        EnterNumberButton.setText("LuckyNumber");
        EnterNumberButton.addActionListener(this);

        HintButton.setBounds(0, 200, 200, 50);
        HintButton.setText("Hint");
        HintButton.addActionListener(this);

        FactorsButton.setBounds(0,90,200,50);
        FactorsButton.setText("Factors");
        FactorsButton.addActionListener(this);

        MultiplesButton.setBounds(300,90,200,50);
        MultiplesButton.setText("Multiples");
        MultiplesButton.addActionListener(this);

        HigherOrLowerButton.setBounds(300, 200, 200, 50);
        HigherOrLowerButton.setText("Higher or Lower");
        HigherOrLowerButton.addActionListener(this);

        JLabel uselesslabel = new JLabel();
        uselesslabel.setBounds(500,500,0,0);

        LabelButton.setBounds(1, 1, 500, 25);
        LabelButton.setText("Welcome to Lucky Number. Click here for the rules :)");
        LabelButton.addActionListener(this);

        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(LabelButton);
        frame.add(HigherOrLowerButton);
        frame.add(HintButton);
        frame.add(FactorsButton);
        frame.add(MultiplesButton);
        frame.add(textField);
        frame.add(EnterNumberButton);
        frame.add(uselesslabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        String factorsListString = "These are the factors: ";

        if(e.getSource() == LabelButton){
            JOptionPane.showMessageDialog(null,"Press the Factor Button to get the factors of the LuckyNumber.");
            JOptionPane.showMessageDialog(null,"Press the Hint Button to get a better idea of what the LuckyNumber");
            JOptionPane.showMessageDialog(null,"Press the Multiples button to guess a multiple of the LuckyNumber");
            JOptionPane.showMessageDialog(null, "Press the Higher or Lower Button to guess a number and we'll tell you if the LuckyNumber is Higher or Lower ");

        }

        if (e.getSource() == FactorsButton){
            for( int i = 1; i < LuckyNumber; i++){
                if (LuckyNumber % i  == 0) {
                    factorsListString += i + " ";

                }//if i is a factor of luckynumber
            }//for loop

            JOptionPane.showMessageDialog(null,factorsListString);

        }//factors button

        if (e.getSource() == HigherOrLowerButton){
            int HigherOrLowerNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter the number, we'll tell u if the lucky Number is higher or lower"));
            System.out.println(HigherOrLowerNumber);

            if(HigherOrLowerNumber  > LuckyNumber){
                JOptionPane.showMessageDialog(null,"Your guess was too high");
            }//the number was too high
            if(HigherOrLowerNumber < LuckyNumber){
                JOptionPane.showMessageDialog(null,"Your number was too low");
            }//the number was too low
            if (HigherOrLowerNumber == LuckyNumber){
                JOptionPane.showMessageDialog(null,"Congrats, you got the right number");
            }//guessed the right number
            HigherOrLowerButton.setEnabled(false);
        }//HigherOrLowerButton

        if(e.getSource() == MultiplesButton){
            int MultipleNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter the number, we'll tell u if its a multiple of the LuckyNumber"));

            if(MultipleNumber % LuckyNumber == 0){
                JOptionPane.showMessageDialog(null,"Yeah, " + MultipleNumber + " is a multiple of the LuckyNumber");
            }//if Multiple Number is a multiple of the LuckyNumber

            else if (MultipleNumber % LuckyNumber != 0) {
                JOptionPane.showMessageDialog(null,"Unlucky, " + MultipleNumber + " is not a multiple of the LuckyNumber");
            }//if Multiple Number is not a multiple of the LuckyNumber

        }//Multiples Button

        if (e.getSource() == HintButton){

            if(LuckyNumber >= 90 && LuckyNumber <= 100){
                JOptionPane.showMessageDialog(null,"The LuckyNumber is between 90 and 100");
            }
            if(LuckyNumber >= 80 && LuckyNumber <=89 ){
                JOptionPane.showMessageDialog(null,"The LuckyNumber is between 80 and 90");
            }
            if(LuckyNumber >= 70 && LuckyNumber <=79){
                JOptionPane.showMessageDialog(null,"The LuckyNumber is between 70 and 80");
            }
            if(LuckyNumber >= 60 && LuckyNumber <= 69){
                JOptionPane.showMessageDialog(null,"The LuckyNumber is between 60 and 70");
            }
            if(LuckyNumber >= 50 && LuckyNumber <= 59){
                JOptionPane.showMessageDialog(null,"The LuckyNumber is between 50 and 60");
            }
            if(LuckyNumber >= 40 && LuckyNumber <= 49){
                JOptionPane.showMessageDialog(null,"The LuckyNumber is between 40 and 50");
            }
            if(LuckyNumber >= 30 && LuckyNumber <= 39){
                JOptionPane.showMessageDialog(null,"The LuckyNumber is between 30 and 40");
            }
            if(LuckyNumber >= 20 && LuckyNumber <= 29){
                JOptionPane.showMessageDialog(null,"The LuckyNumber is between 20 and 30");
            }
            if(LuckyNumber >= 10 && LuckyNumber <= 19){
                JOptionPane.showMessageDialog(null,"The LuckyNumber is between 10 and 20");
            }
            if(LuckyNumber >= 1 && LuckyNumber <= 9){
                JOptionPane.showMessageDialog(null,"The LuckyNumber is between 1 and 10");
            }
        }//Hint Button

        if(e.getSource() == EnterNumberButton){
            BlackjackGUI.increment = parseDouble(textField.getText());

            int LuckyNumberGuess = Integer.parseInt(JOptionPane.showInputDialog("If you're confident, ENTER THE LUCKYNUMBER"));
            if(LuckyNumberGuess == LuckyNumber){
                JOptionPane.showMessageDialog(null,"You're a genius, YOU GOT THE LUCKYNUMBER");
            }
            else{
                JOptionPane.showMessageDialog(null,"Unlucky and dumb, that wasn't the LUCKYNUMBER");
                BlackjackGUI.increment = BlackjackGUI.increment * -1;
            }
            frame.setVisible(false);
        }//EnterNumbersButton

        }//action performed

        }//LuckyNumberGUI class

