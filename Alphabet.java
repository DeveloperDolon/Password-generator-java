public class Alphabet {
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = UPPERCASE_LETTERS.toLowerCase();
    private static final String NUMBERS = "1234567890";
    private static final String SYMBOLS = "~!@#$%^&*()_+=-?/";
    private final StringBuilder pool;
    public Alphabet(boolean IncludeUppercase, boolean IncludeLowercase, boolean IncludeNumbers, boolean IncludeSymbol){
        pool = new StringBuilder();
        if (IncludeUppercase) pool.append(UPPERCASE_LETTERS);
        if (IncludeLowercase) pool.append(LOWERCASE_LETTERS);
        if (IncludeNumbers) pool.append(NUMBERS);
        if (IncludeSymbol) pool.append(SYMBOLS);
    }

    public String getPool(){
        return pool.toString();
    }
}

