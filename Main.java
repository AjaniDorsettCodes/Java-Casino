import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//EnterInfo();
        CasinoGUI casinoGUI = new CasinoGUI();

//        int number = 50;
//        int number2 = -50;
//        int number3 = number + number2;
//        System.out.println(number3);
       // double cash = BlackjackGUI.Money;
        //MoneyChecker.MoneyChecker();
       // System.out.println("This is money: zbby " + BlackjackGUI.Money);
    }

    public static void EnterInfo() {

        String GameChoice = "hi";
        String LowerCaseGameChoice;
        double GamblingAmount = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("How much money do you want to deposit?");
        GamblingAmount = scanner.nextDouble();
        System.out.println("What game u wanna play?");
        GameChoice = scanner.next();
        LowerCaseGameChoice = GameChoice.toLowerCase();
        System.out.println(LowerCaseGameChoice);
        //User enters deposit and chooses what game they want

        if (LowerCaseGameChoice.equals("blackjack")) {
            // Blackjack(GamblingAmount);
            GamblingAmount = Blackjack(GamblingAmount);
            System.out.println("The gambling amount is: " + GamblingAmount);
        }//Enters the game the user chose

    }


    public static double Blackjack(double GamblingAmount){
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        String choice;
        double BettingAmount = 0;
        String LowerCaseChoice;
        int sentinel = 0;

        int RandomBlackjackNumber = rand.nextInt(21);
        int RandomHitNumber = rand.nextInt(20);
        int RandomCPUNumber = rand.nextInt(20);

        System.out.println("How much money are you willing to bet?");
        BettingAmount = scanner.nextDouble();

        while(BettingAmount > GamblingAmount){
            System.out.println("You don't even have that much money");
            System.out.println("Please try again");
            BettingAmount = scanner.nextDouble();
        }//if the user tries to bet more money than they deposited

        System.out.println("This is the blackjack: "+ RandomBlackjackNumber);


        do{
            System.out.println("do you want to stand or hit?");
            choice = scanner.next();
            LowerCaseChoice = choice.toLowerCase();
            System.out.println(LowerCaseChoice);

            if(LowerCaseChoice.equals("hit")){
                RandomHitNumber = rand.nextInt(10);
                RandomBlackjackNumber = RandomBlackjackNumber + RandomHitNumber;
                System.out.println("This is the random hit number: " +RandomBlackjackNumber);
            }//hit

            else if(choice.equals("stand") && sentinel != 1){
                if(RandomBlackjackNumber > RandomCPUNumber){
                    GamblingAmount = GamblingAmount + BettingAmount;
                    System.out.println("You have"+ RandomBlackjackNumber);
                    System.out.println("The house has: " + RandomCPUNumber);
                    System.out.println("You win");
                    sentinel = 1;
                }//you win

                if(RandomCPUNumber > RandomBlackjackNumber){
                    GamblingAmount = GamblingAmount - BettingAmount;
                    System.out.println("You have: "+ RandomBlackjackNumber);
                    System.out.println("The house has: " + RandomCPUNumber);
                    System.out.println("You lose");
                    sentinel = 1;
                }//house wins

                if(RandomCPUNumber == RandomBlackjackNumber){
                    System.out.println("You have: "+ RandomBlackjackNumber);
                    System.out.println("The house has: " + RandomCPUNumber);
                    System.out.println("It's a tie");
                    sentinel = 1;
                }// it's a tie

            }//if the user chooses to stand

        }while( RandomBlackjackNumber <= 21 && sentinel != 1);

        if(RandomBlackjackNumber > 21){
            GamblingAmount = GamblingAmount - BettingAmount;
            System.out.println("You lost because you went higher than 21");
            System.out.println("Looks like you lost money");
        }// if user hits too hard and goes over 21

        return GamblingAmount;
    }//end of blackjack

}//end of class

