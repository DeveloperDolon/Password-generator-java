public class Password {
    String value;
    int length;
    public Password(String password){
        this.value = password;
        this.length = value.length();
    }

    public String checkPassword(){
        int score = 0;

        boolean IncludeUpperCase = false;
        boolean IncludeLowerCase = false;
        boolean IncludeNumbers = false;
        boolean IncludeSymbol = false;

        for (int i = 0; i < length; i++) {
            char a = value.charAt(i);
            if ((int)a >= 65 && (int)a <= 90){
                IncludeUpperCase = true;
            }else if ((int)a >= 97 && (int)a <= 122){
                IncludeLowerCase = true;
            }else if ((int)a >= 48 && (int)a <= 57){
                IncludeNumbers = true;
            }else {
                IncludeSymbol = true;
            }
        }

       if (IncludeUpperCase) score++;
       if (IncludeLowerCase) score++;
       if (IncludeNumbers) score++;
       if (IncludeSymbol) score++;
       if (length >= 8) score++;
       if (length >= 16) score++;

       if (score == 6){
           return "Your password is too strong. Good.";
       }else if (score >= 4){
           return "Good, But you can more good.";
       }else if (score == 3){
           return "This password is not so good, Try to do more strong.";
       }else {
           return "Your password is not a good password.";
       }
    }

    @Override
    public String toString() {
        return value;
    }
}
