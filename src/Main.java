import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        String bet = "";
        float betAmt = 0;
        int randNum = random.nextInt(12+1);
        int point = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to our Craps game!");
        while(!bet.equals("PASS") && !bet.equals("NOPASS")) {
            System.out.println("Please enter your bet. (PASS or NOPASS)");
            bet = scanner.nextLine().toUpperCase();
            if(!bet.equals("PASS") && !bet.equals("NOPASS")){
                System.out.println("Invalid bet entry.");
            }
        }
        while(betAmt < 30.25) {
            System.out.println("Now, please enter the amount you would like to bet. Please enter $30.25 or more. Do not include symbols");
            try {
                betAmt = Float.parseFloat(scanner.nextLine());
            } catch(Exception ex) {
                System.out.println("Please omit any symbols from your bet amount entry.");
            }
            if(betAmt < 30.25) {
                System.out.println("Please enter an amount greater than or equal to $30.25");
            }
        }
        System.out.println("Commencing Craps game now!");
            switch(randNum) {
                case 2,3,12:
                    System.out.println("Pass line bets lose, don't pass line bets win!");
                    if(bet.equals("PASS")){
                        System.out.println("Oh no, you lost! Game concluded.");
                    } else {
                        System.out.println("Congratulations, you won! Game concluded.");
                    }
                case 7, 11:
                    System.out.println("Pass line bets win, don't pass line bets lose!");
                    if(bet.equals("PASS")) {
                        System.out.println("Congratulations, you won! Game concluded.");
                    } else {
                        System.out.println("Oh no, you lost! Game concluded.");
                    }
                case 4,5,6,8,9,10:
                    point = randNum;
                    randNum = 0;
                    System.out.println("Game continues as a point number has been rolled!");
                    while(randNum != point && randNum != 7) {
                        randNum = random.nextInt(12+1);
                    }
                    if(randNum == point) {
                        System.out.println("Pass line bets win!");
                        if(bet.equals("PASS")) {
                            System.out.println("Congratulations, you won! Game concluded.");
                        } else {
                            System.out.println("Oh no, you lost! Game concluded.");
                        }
                    } else {
                        System.out.println("Don't Pass Line bets win!");
                        if(bet.equals("PASS")) {
                            System.out.println("Oh no, you lost! Game concluded.");
                        } else {
                            System.out.println("Congratulations, you won! Game concluded.");
                        }
                    }
            }
    }
}