public class Main {
    public static void main(String[] args) {
        CustomExceptions exception = new CustomExceptions();

        try {
            // Check if arguments are provided
            exception.checkArgumentsExist(args);

            String input = args[0];

            // Check minimum length
            exception.checkMinLength(input);

            // Check valid characters
            exception.checkValidCharacters(input);

            // Check for zeros and ones
            exception.checkForZerosAndOnes(input);

            // Check string length if second argument is provided
            if (args.length > 1) {
                exception.checkExpectedLength(input, args[1]);
            } else {
                System.out.println("Внимание: Второй аргумент не указан. Продолжаем без проверки длины строки.");
            }

            // Separate zeros and ones
            String result = exception.separateZerosAndOnes(input);

            System.out.println(result);

        } catch (CustomExceptions.NoArgumentsException
                 | CustomExceptions.MinLengthException
                 | CustomExceptions.InvalidCharactersException
                 | CustomExceptions.MissingZeroOrOneException
                 | CustomExceptions.InvalidSecondArgumentException
                 | CustomExceptions.LengthMismatchException e) {

            System.err.println(e.getMessage());
        }
    }
}