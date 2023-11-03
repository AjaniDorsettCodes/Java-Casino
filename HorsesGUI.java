import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static java.lang.Double.parseDouble;

public class HorsesGUI extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    private Random rand = new Random();
    private int Horse1 = rand.nextInt(10);
    private JButton Horse1Button = new JButton();
    private JProgressBar Horse1Bar = new JProgressBar();
    private JProgressBar Horse2Bar = new JProgressBar();
    private JProgressBar Horse3Bar = new JProgressBar();
    private JProgressBar Horse4Bar = new JProgressBar();
    private JButton Horse2Button = new JButton();
    private JButton Horse3Button = new JButton();
    private JButton Horse4Button = new JButton();
    public JTextField textField = new JTextField();
    private Timer progressBarTimer;
    public int progress1RandomIncrement = rand.nextInt(10 - 1) + 1;
    public int progress2RandomIncrement = rand.nextInt(10 - 1) + 1;
    public int progress3RandomIncrement = rand.nextInt(10 - 1) + 1;
    public int getProgress4RandomIncrement = rand.nextInt(10 - 1) + 1;
    public static int ChoseHorse1;
    public static int ChoseHorse2;
    public static int ChoseHorse3;
    public static int ChoseHorse4;

    public void Horses() {

        textField.setBounds(205, 150, 90, 25);
        textField.setText("Enter AMT.");

        Horse1Bar.setValue(0);
        Horse1Bar.setString("Horse 1");
        Horse1Bar.setBounds(0, 315, 500, 110);
        Horse1Bar.setStringPainted(true);

        Horse2Bar.setValue(0);
        Horse2Bar.setString("Horse 2");
        Horse2Bar.setBounds(0, 335, 500, 110);
        Horse2Bar.setStringPainted(true);

        Horse3Bar.setValue(0);
        Horse3Bar.setString("Horse 3");
        Horse3Bar.setBounds(0, 355, 500, 110);
        Horse3Bar.setStringPainted(true);

        Horse4Bar.setValue(0);
        Horse4Bar.setString("Horse 4");
        Horse4Bar.setBounds(0, 375, 500, 110);
        Horse4Bar.setStringPainted(true);

        Horse1Button.setBounds(0, 90, 200, 50);
        Horse1Button.setText("Horse 1");
        Horse1Button.addActionListener(this);

        Horse2Button.setBounds(300, 90, 200, 50);
        Horse2Button.setText("Horse 2");
        Horse2Button.addActionListener(this);

        Horse3Button.setBounds(0, 200, 200, 50);
        Horse3Button.setText("Horse 3");
        Horse3Button.addActionListener(this);

        Horse4Button.setBounds(300, 200, 200, 50);
        Horse4Button.setText("Horse 4");
        Horse4Button.addActionListener(this);

        JLabel uselesslabel = new JLabel();
        uselesslabel.setBounds(500, 500, 0, 0);

        frame.setTitle("Horses Race");
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(Horse1Bar);
        frame.add(Horse1Button);
        frame.add(Horse2Bar);
        frame.add(Horse2Button);
        frame.add(Horse3Bar);
        frame.add(Horse4Bar);
        frame.add(Horse3Button);
        frame.add(Horse4Button);
        frame.add(textField);
        frame.add(uselesslabel);

        // Create a timer to increment the progress
        progressBarTimer = new Timer(100, new ActionListener() {


            int progress1 = 0;
            int progress2 = 0;
            int progress3 = 0;
            int progress4 = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (progress1 < 100 || progress2 < 100 || progress3 < 100 || progress4 < 100) {
                    progress1 += progress1RandomIncrement;
                    progress2 += progress2RandomIncrement;
                    progress3 += progress3RandomIncrement;
                    progress4 += getProgress4RandomIncrement;
                    Horse1Bar.setValue(progress1);
                    Horse2Bar.setValue(progress2);
                    Horse3Bar.setValue(progress3);
                    Horse4Bar.setValue(progress4);
                } else {
                    progressBarTimer.stop();
                    System.out.println("This is the chosen horse: " + ChoseHorse1);

                    //chose horse 1
                    if (ChoseHorse1 == 1) {
                        System.out.println("Horse 1 was chosen here");
                        if ((progress1 > progress2) && (progress1 > progress3) && (progress1 > progress4)) {
                            JOptionPane.showMessageDialog(null, "You win");
                            BlackjackGUI.increment = BlackjackGUI.increment;

                        }//you win

                        else if ((progress1 == progress2) || (progress1 == progress3) || (progress1 == progress4)) {
                            if ((progress1 >= progress2) && (progress1 >= progress3) && (progress1 >= progress4)) {
                                JOptionPane.showMessageDialog(null, "You got a tie");
                                BlackjackGUI.increment = BlackjackGUI.increment / 2;

                            }//got a tie for like first place or maybe second

                            else if ((progress1 < progress2) || (progress1 < progress3) || (progress1 < progress4)) {
                                JOptionPane.showMessageDialog(null, "You tied but still lost");
                                BlackjackGUI.increment = BlackjackGUI.increment * -1;

                            }//tied for last

                        } else {
                            JOptionPane.showMessageDialog(null, "You lost");
                            BlackjackGUI.increment = BlackjackGUI.increment * -1;

                        }//lost
                        ChoseHorse1 = 0;
                    }//chose horse1


                    //chose horse 2
                    if (ChoseHorse2 == 1) {
                        if ((progress2 > progress1) && (progress2 > progress3) && (progress2 > progress4)) {
                            JOptionPane.showMessageDialog(null, "You win");
                            BlackjackGUI.increment = BlackjackGUI.increment;
                        }//you win
                        else if ((progress2 == progress1) || (progress2 == progress3) || (progress2 == progress4)) {
                            if ((progress2 >= progress1) && (progress2 >= progress3) && (progress1 >= progress4)) {
                                JOptionPane.showMessageDialog(null, "You got a tie");
                                BlackjackGUI.increment = BlackjackGUI.increment / 2;
                            } //got a tie for like first place or maybe second

                            else if ((progress2 < progress1) || (progress2 < progress3) || (progress2 < progress4)) {
                                JOptionPane.showMessageDialog(null, "You tied but still lost");
                                BlackjackGUI.increment = BlackjackGUI.increment * -1;
                            }//tied for last

                        } else {
                            JOptionPane.showMessageDialog(null, "You lost");
                            BlackjackGUI.increment = BlackjackGUI.increment * -1;
                        }//lost
                        ChoseHorse2 = 0;
                    }//chose horse 2


                    //chose horse 3
                    if (ChoseHorse3 == 1) {
                        if ((progress3 > progress1) && (progress3 > progress2) && (progress3 > progress4)) {
                            JOptionPane.showMessageDialog(null, "You win");
                            BlackjackGUI.increment = BlackjackGUI.increment;
                        }//you win

                        else if ((progress3 == progress1) || (progress3 == progress2) || (progress3 == progress4)) {
                            if ((progress3 >= progress1) && (progress3 >= progress2) && (progress1 >= progress4)) {
                                JOptionPane.showMessageDialog(null, "You got a tie");
                                BlackjackGUI.increment = BlackjackGUI.increment / 2;
                            } //got a tie for like first place or maybe second

                            else if ((progress3 < progress1) || (progress3 < progress2) || (progress3 < progress4)) {
                                JOptionPane.showMessageDialog(null, "You tied but still lost");
                                BlackjackGUI.increment = BlackjackGUI.increment * -1;
                            }//tied for last

                        } else {
                            JOptionPane.showMessageDialog(null, "You lost");
                            BlackjackGUI.increment = BlackjackGUI.increment * -1;
                        }//lost
                        ChoseHorse3 = 0;
                    }//chose horse 3


                    //chose horse 4
                    if (ChoseHorse4 == 1) {
                        if ((progress4 > progress1) && (progress4 > progress2) && (progress4 > progress3)) {
                            JOptionPane.showMessageDialog(null, "You win");
                            BlackjackGUI.increment = BlackjackGUI.increment;
                        }//you win

                        else if ((progress4 == progress1) || (progress4 == progress2) || (progress4 == progress3)) {
                            if ((progress4 >= progress1) && (progress4 >= progress2) && (progress4 >= progress3)) {
                                JOptionPane.showMessageDialog(null, "You got a tie");
                                BlackjackGUI.increment = BlackjackGUI.increment / 2;
                            } //got a tie for like first place or maybe second

                            else if ((progress4 < progress1) || (progress4 < progress2) || (progress4 < progress3)) {
                                JOptionPane.showMessageDialog(null, "You tied but still lost");
                                BlackjackGUI.increment = BlackjackGUI.increment * -1;
                            }//tied for last

                        } else {
                            JOptionPane.showMessageDialog(null, "You lost");
                            BlackjackGUI.increment = BlackjackGUI.increment * -1;
                        }//lost
                        ChoseHorse4 = 0;
                    }//chose horse 4

                    frame.setVisible(false);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BlackjackGUI.increment = parseDouble(textField.getText());

        if (e.getSource() == Horse1Button) {
            JOptionPane.showMessageDialog(null, "You chose Horse 1");
            ChoseHorse1 = 1;
            JOptionPane.showMessageDialog(null,"Please wait for the race to finish before you exit");

            progressBarTimer.start();

        }
        if (e.getSource() == Horse2Button) {
            JOptionPane.showMessageDialog(null, "You chose Horse 2");
            ChoseHorse2 = 1;
            JOptionPane.showMessageDialog(null,"Please wait for the race to finish before you exit");
            progressBarTimer.start();

        }
        if (e.getSource() == Horse3Button) {
            JOptionPane.showMessageDialog(null, "You chose Horse 3");
            ChoseHorse3 = 1;
            JOptionPane.showMessageDialog(null,"Please wait for the race to finish before you exit");
            progressBarTimer.start();

        }
        if (e.getSource() == Horse4Button) {
            JOptionPane.showMessageDialog(null, "You chose Horse 4");
            ChoseHorse4 = 1;
            JOptionPane.showMessageDialog(null,"Please wait for the race to finish before you exit");
            progressBarTimer.start();
        }

    }
}


