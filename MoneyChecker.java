public class MoneyChecker {

   public static double MoneyChecker(){

        BlackjackGUI.Money = BlackjackGUI.Money + 500;
       System.out.println("This is my new method that checks if the money is passed "+ BlackjackGUI.Money);

       return BlackjackGUI.Money;
    }
}
