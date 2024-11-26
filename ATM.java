import java.util.Scanner;

public class ATM {
    private int balance;
    private int pin;

    public ATM(int balance, int pin){// constructor for initialising/assigning the balance and pin
        this.balance = balance;
        this.pin = pin;
    }

    //This function is used for Displaying the Menu the User
    public void displayMenu(){
        System.out.println("1: Check Balance");
        System.out.println("2: Deposit");
        System.out.println("3: Withdraw");
        System.out.println("4: Change pin");
        System.out.println("5: Exit");
    }


    //This function is for depositing the amount/cash in your account
    public void deposit(int amount){
        balance += amount;
    }

    //This function is for cash withdrawal
    public void withdraw(int amount){
        if(balance<amount){
            System.out.println("Insufficient Funds!");
            return;
        }
        balance -= amount;
    }


    //This function is to check the current Balance in your Account
    public int getBalance(){
        return balance;
    }


    //This function is to check if the entered pin was correct or not
    public boolean validatePin(int pin){
        return this.pin == pin;
    }


    //This function to change the current Pin for your Account
    public void changePin(int newPin){
        pin = newPin;
        System.out.println("Pin was Changed!");
    }

    public static void main(String[] args){
        ATM atm = new ATM(1000,1234);
        System.out.print("Enter the Pin: ");

        //int pin = Integer.parseInt(System.console().readLine()); is showing error
        Scanner sc = new Scanner(System.in);//so, I am using scanner method for taking input by the user

        int pin = sc.nextInt();//variable for storing PIN

        if(atm.validatePin(pin)){//to check the pin is correct or not
            int option = 0;

            while (option!=5){//if option other than 5 than this loop repeatedly showing the Menu infinitely!
                atm.displayMenu();
                option = sc.nextInt();

                //Switch statement is used to perform the operations of the ATM!
                switch (option){
                    case 1:
                        System.out.println("Balance: "+atm.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter Amount: ");
                        int amount = sc.nextInt();
                        atm.deposit(amount);
                        break;
                    case 3:
                        System.out.print("Enter Amount: ");
                        amount = sc.nextInt();
                        atm.withdraw(amount);
                        break;
                    case 4:
                        System.out.print("Enter New Pin: ");
                        int newPin = sc.nextInt();
                        atm.changePin(newPin);
                        break;
                    case 5:
                        System.out.println("Thank you for using ATM!");
                        break;
                    default:
                        break;
                }
            }
        }else{
            System.out.println("You have entered the Invalid Pin!");
        }
    }
}
