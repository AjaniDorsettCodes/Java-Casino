import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;
import java.util.jar.JarEntry;

import static java.lang.Double.parseDouble;

public class RouletteGUI extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    Border border;
    JLabel label;
    JButton ColourButton;
    JButton MoneyButton = new JButton();
    JButton button2 = new JButton();
    JTextField MyNewTextfield = new JTextField();
    JTextField Textfield2;
    Random rand = new Random();
    JButton RedButton = new JButton();
    JButton BlackButton = new JButton();
    int RouletteCPUNumber = rand.nextInt(100 - 1) + 1;

    int RandomCPUColourNumber = rand.nextInt(100 - 1) + 1;

    String RandomCPUColour;

    String ColourChoice;
    String RouletteNumber;

    int NewRouletteNumber;
    int ChoseNumber = 0;
    int ChoseColour = 0;


    public void RouletteGUI() {

        BlackButton = new JButton();
        BlackButton.setBounds(100, 400, 50, 25);
        //RedButton.setFocusPainted(false);
        BlackButton.setBackground(Color.black);
        //RedButton.setForeground(Color.red);
        BlackButton.setOpaque(true);
        BlackButton.addActionListener(this);
        BlackButton.setBackground(Color.black);
        BlackButton.setText("Black");
        BlackButton.setVisible(false);

        RedButton = new JButton();
        RedButton.setBounds(400, 400, 50, 25);
        RedButton.setBackground(Color.red);
        RedButton.setOpaque(true);
       // RedButton.setIconTextGap(-15);
        RedButton.setFocusable(false);
        RedButton.addActionListener(this);
        RedButton.setBackground(Color.red);
        RedButton.setText("Red");
        RedButton.setVisible(false);

        MoneyButton = new JButton();
        MoneyButton.setBounds(197, 300, 100, 50);
        MoneyButton.addActionListener(this);
        MoneyButton.setText("Play roulette");
        MoneyButton.setEnabled(false);
        MoneyButton.setFocusPainted(false);

        JTextField Textfield2 = new JTextField();
        Textfield2.setPreferredSize(new Dimension(0, 0));
        Textfield2.setBounds(5000, 5000, 0, 0);

       // button2 = new JButton();
        button2.setBounds(303, 200, 200, 50);
        button2.setText("Numbers");
        button2.setFocusPainted(false);
        button2.addActionListener(this);

        JTextField t2 = new JTextField();
        t2.setPreferredSize(new Dimension(0, 0));
        t2.setBounds(500, 500, 0, 0);
        t2.setBackground(Color.black);

        //JTextField MyNewTextfield = new JTextField();
        MyNewTextfield.setBounds(205, 150, 90, 25);
        MyNewTextfield.setText("Enter AMT.");

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        JLabel label = new JLabel();
        label.setText("Roulette, pick a number between 0 and 100, pick a colour, or do both ");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setBorder(border);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(1, 1, 500, 25);

        ColourButton = new JButton();
        ColourButton.setBounds(0, 200, 200, 50);
        ColourButton.addActionListener(this);
        ColourButton.setText("Colour");
        ColourButton.setFocusPainted(false);

        JLabel label2 = new JLabel();
        label2.setBounds(500, 500, 0, 0);

        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(ColourButton);
        frame.add(label);
        frame.add(MyNewTextfield);
        frame.add(button2);
        frame.add(Textfield2);
        frame.add(MoneyButton);
        frame.add(RedButton);
        frame.add(BlackButton);
        frame.add(label2);
        //frame.add(t2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int ColourWin = 0;
        int NumberWin = 0;
        BlackjackGUI.increment = parseDouble(MyNewTextfield.getText());

        if (e.getSource() == ColourButton) {
            RedButton.setVisible(true);
            BlackButton.setVisible(true);

        }// colour button

        if (e.getSource() == button2) {
            //JOptionPane.showInputDialog();
            RouletteNumber = JOptionPane.showInputDialog("Enter the number pls");
            NewRouletteNumber = Integer.parseInt(RouletteNumber);
            System.out.println(NewRouletteNumber);
            ChoseNumber = 1;
            button2.setEnabled(false);
            MoneyButton.setEnabled(true);
        }// number button

        if (e.getSource() == RedButton) {
            ColourChoice = "Red";
            RedButton.setVisible(false);
            BlackButton.setVisible(false);
            ColourButton.setEnabled(false);
            MoneyButton.setEnabled(true);
            ChoseColour = 1;
        }// they chose red

        if (e.getSource() == BlackButton) {
            ColourChoice = "Black";
            BlackButton.setVisible(false);
            RedButton.setVisible(false);
            ColourButton.setEnabled(false);
            MoneyButton.setEnabled(true);
            ChoseColour = 1;
        }//they chose black

        if (RandomCPUColourNumber % 2 == 0) {
            RandomCPUColour = "Red";
        }//Colour is red

        if (RandomCPUColourNumber % 2 != 0) {
            RandomCPUColour = "Black";
        }//Colour is black


        // ALL OF THIS IS AFTER THEY CLICK THE ROULETTE BUTTON!!!!
        if (e.getSource() == MoneyButton) {
            JOptionPane.showMessageDialog(null, "LETS ROULETTE");
            if (ChoseColour == 1) {
                if (Objects.equals(RandomCPUColour, ColourChoice)) {
                    ColourWin = 1;
                }//if they won a colour
            }//if they chose a colour

            if (ChoseNumber == 1) {
                if (NewRouletteNumber == RouletteCPUNumber) {
                    NumberWin = 1;
                }// they won the number

            }// pressed the roulette button

            if ((ChoseNumber == 1 && ChoseColour == 0)&& NumberWin == 1) {
                JOptionPane.showMessageDialog(null, "Congrats, u got the right number");
            }// guessed only numbers and got it right

            if ((ChoseColour == 1 && ChoseNumber == 0) && ColourWin == 1){
                JOptionPane.showMessageDialog(null,"Congrats, u got the right colour");
            }//guessed only colours and got it right

            if ((ChoseNumber == 1 && ChoseColour == 0) && NumberWin == 0){
                JOptionPane.showMessageDialog(null,"Didn't get the number, looks like you're dumb");
                BlackjackGUI.increment = BlackjackGUI.increment * -1;
            }//guessed the wrong number and didn't guess a colour

            if ((ChoseColour == 1 && ChoseNumber == 0) && ColourWin == 0){
                JOptionPane.showMessageDialog(null,"Wrong colour dummy, u had a 50-50 shot and you still blew it");
                BlackjackGUI.increment = BlackjackGUI.increment * -1;
            }//guessed the wrong colour and didn't guess a number

            if ((ChoseNumber == 1 && ChoseColour == 1)&& (NumberWin == 0 && ColourWin == 0)){
                JOptionPane.showMessageDialog(null,"Wow,u got both the number and the colour wrong. Hold this : L");
                BlackjackGUI.increment = BlackjackGUI.increment * -1;
            }//guessed both, got both wrong

            if ((ChoseNumber == 1 && ChoseColour == 1) && (NumberWin == 1 && ColourWin == 1)){
                JOptionPane.showMessageDialog(null,"CONGRATULATIONS, YOU WON THE WHOLE THING");
                BlackjackGUI.increment = BlackjackGUI.increment * 2;
            }//guessed both, got both right

            if ((ChoseColour == 1 && ChoseNumber == 1)&& (NumberWin == 0 && ColourWin == 1)){
                JOptionPane.showMessageDialog(null,"Nice try, at least u got the colour right");
                BlackjackGUI.increment = BlackjackGUI.increment/2;
            }//guessed both, only got colour right

            if ((ChoseColour == 1 && ChoseNumber == 1) && (NumberWin == 1 && ColourWin == 0)){
                JOptionPane.showMessageDialog(null,"Nice try, at least u got the number right");
                BlackjackGUI.increment = BlackjackGUI.increment/2;
            }//guessed both, only got the number right

            System.out.println("This is the colour number" + RandomCPUColourNumber);
            System.out.println("This is roulette Number: " + NewRouletteNumber);
            System.out.println("Number win: " + NumberWin);
            System.out.println("Chose Number =" + ChoseNumber);
            System.out.println("Chose colour =" + ChoseColour);

           // System.out.println("This is the money in Roulette: " + BlackjackGUI.increment);
            frame.setVisible(false);
        }// Pressed the roulette button
    }//This is where the actions happen
}//roulette class
