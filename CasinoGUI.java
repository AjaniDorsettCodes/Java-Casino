import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showInputDialog;

public class CasinoGUI extends JFrame implements ActionListener {
    JButton button = new JButton();
    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    public double GamblingAmount = 0.00;

    JButton EnterMoneyButton = new JButton();
    JButton MoneyButton = new JButton();
    JButton RouletteButton = new JButton();
    JButton LuckyNumberButton = new JButton();
    JButton HorsesButton = new JButton();

    JButton labelButton = new JButton();

    public static double MyNumber = 1500;
    MoneyChecker moneyChecker = new MoneyChecker();
    CasinoGUI(){

        labelButton.setBounds(1, 1, 500, 25);
        labelButton.setText("Welcome to my casino. Click here for the rules :)");
        labelButton.addActionListener(this);

        MoneyButton = new JButton();
        MoneyButton.setBounds(197,300,100,50);
        MoneyButton.addActionListener(this);
        MoneyButton.setText("Check Money");
        MoneyButton.setFocusPainted(false);


        button.setBounds(300,200,200,50);
        button.setText("Blackjack");
        button.setFocusPainted(false);
        button.addActionListener(this);
        button.setEnabled(false);

        HorsesButton.setBounds(300,90,200,50);
        HorsesButton.setText("Horses");
        HorsesButton.setFocusPainted(false);
        HorsesButton.addActionListener(this);
        HorsesButton.setEnabled(false);

        LuckyNumberButton.setBounds(0,90,200,50);
        LuckyNumberButton.setText("LuckyNumber");
        LuckyNumberButton.setFocusPainted(false);
        LuckyNumberButton.addActionListener(this);
        LuckyNumberButton.setEnabled(false);

        RouletteButton = new JButton();
        RouletteButton.setBounds(0,200,200,50);
        RouletteButton.addActionListener(this);
        RouletteButton.setText("Roulette");
        RouletteButton.setFocusPainted(false);
        RouletteButton.setEnabled(false);

        JTextField textField = new JTextField();
       // textField.setPreferredSize(new Dimension(100, 25));
        textField.setBounds(205,150,90,25);
        textField.setText("Enter AMT.");

        EnterMoneyButton.setBounds(205,150,90,25);
        EnterMoneyButton.setText("Enter $");
        EnterMoneyButton.addActionListener(this);



        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(button);
        //frame.add(textField);
        frame.add(EnterMoneyButton);
        frame.add(RouletteButton);
        frame.add(LuckyNumberButton);
        frame.add(HorsesButton);
        frame.add(labelButton);
        frame.add(MoneyButton);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BlackjackGUI blackjackGUI = null;
        int HintChecker = 0;
        String ContinuePlayingChoice;

        if(e.getSource() == EnterMoneyButton){
            GamblingAmount = Double.parseDouble(showInputDialog(null,"Enter the amount"));
            EnterMoneyButton.setEnabled(false);
            button.setEnabled(true);
            RouletteButton.setEnabled(true);
            LuckyNumberButton.setEnabled(true);
            HorsesButton.setEnabled(true);
        }

        System.out.println("This is the total cash you have: " + GamblingAmount);

        if (e.getSource() == labelButton){
            JOptionPane.showMessageDialog(null,"Click any button to play a game");
            JOptionPane.showMessageDialog(null,"Before you start playing, make sure you enter your betting amount");
            JOptionPane.showMessageDialog(null,"THE GAMES WILL NOT WORK IF YOU DO NOT ENTER A NUMBER IN THE TEXTFIELD BEFORE YOU START");
            JOptionPane.showMessageDialog(null,"Make sure to check your money after every game");
            JOptionPane.showMessageDialog(null,"Have fun 😃");
            HintChecker ++;
        }

        if (e.getSource() == button) {

            blackjackGUI = new BlackjackGUI();
            blackjackGUI.BlackjackGUI();
            button.setEnabled(false);
            HorsesButton.setEnabled(false);
            button.setEnabled(false);
            RouletteButton.setEnabled(false);
            LuckyNumberButton.setEnabled(false);
            HorsesButton.setEnabled(false);


        }
        double cash = moneyChecker.MoneyChecker();
        System.out.println("This is cash once i pass it through all the stuff " + cash);
        GamblingAmount = GamblingAmount + (blackjackGUI.increment);
        System.out.println("This is the new total: " + GamblingAmount);
        int CasinoIncrementCheck = blackjackGUI.increment2;
        System.out.println( "This is increment 2: " + CasinoIncrementCheck);
        blackjackGUI.increment = 0;

        if (e.getSource() ==  RouletteButton){
            RouletteGUI roulette = new RouletteGUI();
            roulette.RouletteGUI();
            RouletteButton.setEnabled(false);
            HorsesButton.setEnabled(false);
            button.setEnabled(false);
            RouletteButton.setEnabled(false);
            LuckyNumberButton.setEnabled(false);
            HorsesButton.setEnabled(false);
        }

        if (e.getSource() == LuckyNumberButton){
            LuckyNumberGUI luckynumber = new LuckyNumberGUI();
            luckynumber.LuckyNumberGUI();
            LuckyNumberButton.setEnabled(false);
            HorsesButton.setEnabled(false);
            button.setEnabled(false);
            RouletteButton.setEnabled(false);
            LuckyNumberButton.setEnabled(false);
            HorsesButton.setEnabled(false);
        }

        if (e.getSource() == HorsesButton){
            HorsesGUI horses = new HorsesGUI();
            horses.Horses();
            HorsesButton.setEnabled(false);
            button.setEnabled(false);
            RouletteButton.setEnabled(false);
            LuckyNumberButton.setEnabled(false);
            HorsesButton.setEnabled(false);
        }

        if (e.getSource() == MoneyButton){
            JOptionPane.showMessageDialog(null,"This is the money you have: " + GamblingAmount);
            button.setEnabled(true);
            RouletteButton.setEnabled(true);
            LuckyNumberButton.setEnabled(true);
            HorsesButton.setEnabled(true);
        }

        if (GamblingAmount <= 0 && !(HintChecker > 0)){
            JOptionPane.showMessageDialog(null,"YOU'RE BROKE, SORRY");
            ContinuePlayingChoice = showInputDialog(null,"Do you want to keep playing? yes or no?");
            String ContinuePlayingChoiceLowerCase = ContinuePlayingChoice.toLowerCase();

            if(ContinuePlayingChoiceLowerCase.equals("yes") || ContinuePlayingChoiceLowerCase.equals("y")){
                GamblingAmount += Double.parseDouble(showInputDialog(null,"Enter more money or the casino will close"));
                if(GamblingAmount > 0){
                    EnterMoneyButton.setEnabled(false);
                }
                if(GamblingAmount <= 0){
                    while (GamblingAmount <= 0){
                       GamblingAmount += Double.parseDouble(showInputDialog(null,"Your balance is " + GamblingAmount + " You need to enter more money"));

                    }
                }
            }
            else if (!(ContinuePlayingChoiceLowerCase.equals("yes") || ContinuePlayingChoiceLowerCase.equals("y"))){

                JOptionPane.showMessageDialog(null,"Have a good day. Thank you for using the casino. 😊");
                frame.setVisible(false);
            }
        }

    }
}
