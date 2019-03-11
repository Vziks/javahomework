package info.vziks.homework1;

import java.util.Arrays;

/**
 * Class Task6Command
 *
 * @author Anton Prokhorov
 */
public class Task6Command implements Command {

    private int[] numbers = {208, 774, 613};

    @Override
    public void execute() {

        for (int i = 0; i < getNumbers().length; i++) {
            System.out.printf("At %d, the highest number is %d with getMaxWithByte function\n", getNumbers()[i], getMaxWithByte(getNumbers()[i]));
        }

        for (int i = 0; i < getNumbers().length; i++) {
            System.out.printf("At %d, the highest number is %d with getMaxWithString function\n", getNumbers()[i], getMaxWithString(getNumbers()[i]));
        }

        for (int i = 0; i < getNumbers().length; i++) {
            System.out.printf("At %d, the highest number is %d with getMaxWithRecursive function\n", getNumbers()[i], getMaxWithRecursive(getNumbers()[i]));
        }

    }

    /**
     * Gets max with byte.
     *
     * @param number the number
     * @return the max with byte
     */
    public int getMaxWithByte(int number) {
        byte maxDigit = (byte) (number % 10);
        while (number > 0) {
            byte curDigit = (byte) (number % 10);
            if (curDigit > maxDigit)
                maxDigit = curDigit;
            number /= 10;
        }
        return maxDigit;
    }

    /**
     * Gets max with string.
     *
     * @param number the number
     * @return the max with string
     */
    public int getMaxWithString(int number) {

        String str = String.valueOf(number);

        char[] tempArray = str.toCharArray();

        Arrays.sort(tempArray);

        return Character.getNumericValue(tempArray[tempArray.length - 1]);
    }

    /**
     * Gets max with recursive.
     *
     * @param number the number
     * @return the max with recursive
     */
    public int getMaxWithRecursive(int number) {
        return number == 0 ? 0 : Math.max(number % 10, getMaxWithRecursive(number / 10));
    }

    /**
     * Get numbers int [ ].
     *
     * @return the int [ ]
     */
    public int[] getNumbers() {
        return numbers;
    }

    /**
     * Sets numbers.
     *
     * @param numbers the numbers
     */
    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
}
