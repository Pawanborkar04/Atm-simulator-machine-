import java.util.ArrayList;
import java.util.List;
import java.util.*;

public  class Atm {
    private int balance;
    private int pin;
    private List<String> transactionHistory = new ArrayList<>();

    public Atm(int balance,int pin){
        this.balance=balance;
        this.pin=pin;
    }

    public void displayMenu(){
        System.out.println("1. check balance");
        System.out.println("2. deposite cash");
        System.out.println("3. withdrow cash");
        System.out.println("4. change Pin");
        System.out.println("5. exit ");

    }
    public void deposite(int amount){
        balance+=amount;

    }

    public void withdrow(int amount)
    {
        if(balance<amount){
            System.out.println("Insufficent funds");
            return;
        }
        balance-=amount;
    }

    public int getbalance(){
        return balance;
    } 
    public boolean validatePin(int pin){
        return this.pin==pin;
    }

    public void changePin(int newpin){
        this.pin=newpin;

    }
    
    public static void main(String args[]){
      Atm atm = new Atm(1000,1234);
      atm.displayMenu();
      
      System.out.println("Enter the pin:");
      int pin = Integer.parseInt(System.console().readLine());
      if(atm.validatePin(pin))
      {
        int option=0;
        while(option!=5){
            atm.displayMenu();
            option = Integer.parseInt(System.console().readLine());
            switch(option){
                case 1:
                System.out.println("balance :"+atm.getbalance());
                break;
                case 2 :
                System.out.println("Enter Amount:");
                int amount=Integer.parseInt(System.console().readLine());
                atm.deposite(amount);
                break;
                case 3:
                System.out.println("Enter  amount :");
                amount = Integer.parseInt(System.console().readLine());
                atm.withdrow(amount);
                break;
                
                case 4:
                System.out.println("Enter new pin :");
                int newpin = Integer.parseInt(System.console().readLine());
                atm.changePin(newpin);
                break;
                case 5:
                    System.out.println("thank you for visiting the Atm");
                break;
                
                default :
                System.out.println("invalide option");             
            }
        }

      }
      else
      {
        System.out.println("you have entered Invalide pin!");
      }
    }

}
