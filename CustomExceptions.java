public class CustomExceptions implements StringProcessor {

    // Exception for when no arguments are provided
    public static class NoArgumentsException extends Exception {
        public NoArgumentsException(String message) {
            super(message);
        }
    }

    // Exception for when string length is less than minimum
    public static class MinLengthException extends Exception {
        public MinLengthException(String message) {
            super(message);
        }
    }

    // Exception for invalid characters in the input
    public static class InvalidCharactersException extends Exception {
        public InvalidCharactersException(String message) {
            super(message);
        }
    }

    // Exception for when input doesn't contain both 0 and 1
    public static class MissingZeroOrOneException extends Exception {
        public MissingZeroOrOneException(String message) {
            super(message);
        }
    }

    // Exception for invalid second argument (not a number)
    public static class InvalidSecondArgumentException extends Exception {
        public InvalidSecondArgumentException(String message) {
            super(message);
        }
    }

    // Exception for when input length doesn't match expected length
    public static class LengthMismatchException extends Exception {
        public LengthMismatchException(String message) {
            super(message);
        }
    }

    @Override
    public boolean isValidCharacter(char c) {
        return c == '0' || c == '1';
    }

    @Override
    public void checkArgumentsExist(String[] args) throws NoArgumentsException {
        if (args.length == 0) {
            throw new NoArgumentsException(Constants.ERROR_NO_ARGUMENTS);
        }
    }

    @Override
    public void checkMinLength(String input) throws MinLengthException {
        if (input.length() < Constants.MIN_STRING_LENGTH) {
            throw new MinLengthException(
                    String.format(Constants.ERROR_MIN_LENGTH, Constants.MIN_STRING_LENGTH));
        }
    }

    @Override
    public void checkValidCharacters(String input) throws InvalidCharactersException {
        for (char c : input.toCharArray()) {
            if (!isValidCharacter(c)) {
                throw new InvalidCharactersException(Constants.ERROR_INVALID_CHARACTERS);
            }
        }
    }

    @Override
    public void checkForZerosAndOnes(String input) throws MissingZeroOrOneException {
        boolean hasZero = false;
        boolean hasOne = false;

        for (char c : input.toCharArray()) {
            if (c == '0') {
                hasZero = true;
            } else if (c == '1') {
                hasOne = true;
            }
        }

        if (!hasZero || !hasOne) {
            throw new MissingZeroOrOneException(Constants.ERROR_MISSING_ZERO_OR_ONE);
        }
    }

    @Override
    public void checkExpectedLength(String input, String lengthArg)
            throws InvalidSecondArgumentException, LengthMismatchException {
        int expectedLength;
        try {
            expectedLength = Integer.parseInt(lengthArg);
        } catch (NumberFormatException e) {
            throw new InvalidSecondArgumentException(Constants.ERROR_INVALID_SECOND_ARG);
        }

        if (input.length() != expectedLength) {
            throw new LengthMismatchException(
                    String.format(Constants.ERROR_LENGTH_MISMATCH, input.length(), expectedLength));
        }
    }

    @Override
    public String separateZerosAndOnes(String input) {
        StringBuilder zeros = new StringBuilder();
        StringBuilder ones = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (c == '0') {
                zeros.append(c);
            } else if (c == '1') {
                ones.append(c);
            }
        }

        return zeros.toString() + ones.toString();
    }
}
