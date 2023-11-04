package PassWordChecking;
import java.util.*;
public class PasswordChecking {
    public static void main(String[] butts){
        Scanner something = new Scanner(System.in);
        boolean flag= false;
        String password;
        System.out.println("Please enter a possible password please (that is at least 8 characters long): ");
        do{
            password = something.nextLine();

            if(!password.isEmpty() && !password.contains(" ")){        //this part stops the code to move if SPACES or if NOTHING is in or part of the code
                checkingThis(password);
                flag=true;

            }
            else{
                System.out.println("Sorry this does not work please try again");
                System.out.println("Please enter a possible password: ");
            }
        }while(!flag);
        something.close();
        System.exit(0);
    }

    public static void checkingThis(String password) {
        int lengthOfPassword=password.length();
        boolean hasLower=false;
        boolean hasUpper=false;
        boolean hasNumber=false;
        boolean hasSpecial=false;

        String specialLetters= "!@#$%^&*()-+";
        Set<Character> listOfSpecialLetters= Set.of('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+');

        for(char innie: password.toCharArray()){
            if(Character.isLowerCase(innie)) hasLower=true;
            if(Character.isUpperCase(innie)) hasUpper=true;
            if(Character.isDigit(innie)) hasNumber=true;
            if(listOfSpecialLetters.contains(innie)) hasSpecial=true;
        }

        System.out.println("This is how strong your password... ");
        if(hasNumber&&hasLower&&hasUpper&&hasSpecial&&(lengthOfPassword>=8)){
            System.out.println("Super Strong!!!!");
        }
        else if ((hasLower||hasUpper||hasNumber||hasSpecial)&&(lengthOfPassword>=7)){
            System.out.println("Strong Enough! But maybe a change or too and it will be the best");
        }
        else if ((hasLower||hasUpper||hasNumber||hasSpecial)&&(lengthOfPassword>=6)){
            System.out.println("Moderate. Ehh not strong enough.");
        }
        else{
            System.out.println("Sorry but this password is very weak! PLEASE FIX THIS!!! AHHH!!!");
        }
    }
}
