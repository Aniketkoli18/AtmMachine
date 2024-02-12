import java.util.Scanner;

class BankAccount{

    int mobile_number=7670;// last four digit of mobile number.
    int balance=1000;
    public void Accountdetails(){
        String name="Aniket sanjay koli";
       String Accountnumber="xxxxxxxxxx1213";
        System.out.println( name);
         System.out.println(Accountnumber);
        System.out.println(mobile_number);
    }

    public void deposit(int amount){
        balance+=amount;
        System.out.println("The "+amount+" credited on your account.The balance is "+balance);
    }
    public void withdraw(int amount){
        if(balance>amount) {
            balance -= amount;
            System.out.println("The " + amount + " debited from your account.the balance is " + balance);
        }
        else{
            System.out.println("your account have insufficient bank balance so transaction is fail.");
        }
    }

    public void checkbalance(){
        System.out.println("the balance of your account is: "+balance);
    }

}
class Atm extends BankAccount{
    Scanner ac=new Scanner(System.in);
    int pin=1213;//default atm pin for using atm machine.
    public void setpin(int mobile){
        if(mobile==mobile_number){
            System.out.println("enter a pin number for set.");
            int number=ac.nextInt();
            pin=number;

        }
        else{
            System.out.println("wrong mobile number enter.");

        }
    }
    public void workinng(int work,int number){
        switch(work){
            case 1:
                if(pin==number){
                    System.out.println("enter how many amount you want to deposit.");
                    int amount= ac.nextInt();
                    deposit(amount);
                }
                else{
                    System.out.println("transaction is fail due to wrong pin number.");
                }
                break;
            case 2:
                if(pin==number) {
                    System.out.println("enter how many amount you want to withdraw.");
                    int amount= ac.nextInt();
                    withdraw(amount);
                }
                else{
                    System.out.println("transaction is fail due to wrong pin number.");
                }
                break;
            case 3:
                if(pin== number) {
                    checkbalance();
                }
                else{
                    System.out.println("pin is wrong.enter pin again.");
                }
                break;
        }
    }

}
public class Task2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Atm obj=new Atm();
        System.out.println("if you want to set pin number then enter 1 other wise enter 2");
        int set=sc.nextInt();
        if(set==1){
            System.out.println("enter mobile number for conformation.");
            int mobile=sc.nextInt();
            obj.setpin(mobile);
        }
        System.out.println("how many times you use a atm machine.");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("if you only want bank details then type 1 otherwise type 2");
            int order=sc.nextInt();
            if(order==1){
                obj.Accountdetails();
            }
            else{
                System.out.println("1:deposit,2:withdraw,3:check balance.");
                System.out.println("enter work which you want to do.");
                int work=sc.nextInt();
                System.out.println("enter a pin.");
                int pin_num=sc.nextInt();
                obj.workinng(work,pin_num);
            }
        }

    }
}
