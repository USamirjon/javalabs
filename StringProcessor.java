public interface StringProcessor {
    boolean isValidCharacter(char c);
    void checkArgumentsExist(String[] args) throws CustomExceptions.NoArgumentsException;
    void checkForZerosAndOnes(String input) throws CustomExceptions.MissingZeroOrOneException;
    String separateZerosAndOnes(String input);
    void checkMinLength(String input) throws CustomExceptions.MinLengthException;
    void checkValidCharacters(String input) throws CustomExceptions.InvalidCharactersException;
    void checkExpectedLength(String input, String lengthArg)
            throws CustomExceptions.InvalidSecondArgumentException, CustomExceptions.LengthMismatchException;
}