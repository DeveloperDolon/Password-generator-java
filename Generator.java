import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Generator {
    private Alphabet alphabet;
    private BufferedReader input;
    public Generator(BufferedReader bufferedReader){
        this.input = bufferedReader;
    }
    public Generator(boolean IncludeUppercase, boolean IncludeLowercase, boolean IncludeNumber, boolean IncludeSymbol){
        alphabet = new Alphabet(IncludeUppercase, IncludeLowercase, IncludeNumber, IncludeSymbol);
    }

    public void mainLoop() throws IOException {
        Scanner sc = new Scanner(System.in);
        showMenu();
        int option = sc.nextInt();

        if (option == 1) {
            creatingPassword();
            mainLoop();
        }else if (option == 2){
            checkPassword();
            mainLoop();
        }else if (option == 3){
            System.out.println("Your are quited.");
        }
    }
    private void creatingPassword() throws IOException {
        int score = 0;
        boolean IncludeUpperCase = false;
        boolean IncludeLowerCase = false;
        boolean IncludeNumbers = false;
        boolean IncludeSymbol = false;
        boolean correctParams = false;

        System.out.println("I ask You more and more question, You just answer Yes or No");
        do {
            System.out.print("Do you want to add Uppercase letters in your password?");
            String answer = input.readLine();
            if (answer.equalsIgnoreCase("Yes")) {IncludeUpperCase = true; score++;}

            System.out.print("Do you want to add Lowercase letters in your password?");
            answer = input.readLine();
            if (answer.equalsIgnoreCase("Yes")) {IncludeLowerCase = true; score++;}

            System.out.print("Do you want to add Numbers in your password?");
            answer = input.readLine();
            if (answer.equalsIgnoreCase("Yes")) {IncludeNumbers = true; score++;}

            System.out.print("Do you want to add Symbols in your password?");
            answer = input.readLine();
            if (answer.equalsIgnoreCase("Yes")) {IncludeSymbol = true; score++;}

            if (score < 2){
                System.out.println("Your password request is failed.");
                correctParams = true;
                continue;
            }
            System.out.print("Now enter your password length : ");
            Scanner sc = new Scanner(System.in);
            int length = sc.nextInt();

            final Generator generator = new Generator(IncludeUpperCase, IncludeLowerCase, IncludeNumbers, IncludeSymbol);
            final Password password = generator.genaratePassword(length);
            System.out.println("Your password is : " + password.toString());

        }while (correctParams);
    }

    private Password genaratePassword(int length){
        final StringBuilder pass = new StringBuilder();
        for (int i = 0; i < length; i++) {
            String allAlpha = alphabet.getPool();
            int max = allAlpha.length() - 1;
            int min = 0;
            int range = max - min + 1;
            int index = (int)(Math.random() * range) + min;
            pass.append(allAlpha.charAt(index));
        }
        return new Password(pass.toString());
    }

    private void checkPassword() throws IOException {
        System.out.print("Enter your password : ");
        String password = input.readLine();
        Password password1 = new Password(password);
        System.out.println(password1.checkPassword());
    }
    private void showMenu(){
        System.out.println();
        System.out.println("--------Welcome to Dolon Roy Password System--------");
        System.out.println("1 - Create Password");
        System.out.println("2 - View password strength");
        System.out.println("3 - Quit");
        System.out.println("Choice : ");
    }
}
