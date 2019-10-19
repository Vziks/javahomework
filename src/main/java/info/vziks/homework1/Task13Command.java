package info.vziks.homework1;

import info.vziks.utils.Command;

/**
 * Class Task13Command
 *
 * @author Anton Prokhorov
 */
public class Task13Command implements Command {

    private int[] array;
    private int findSum;
    private StringBuilder sb = new StringBuilder();

    public Task13Command(int[] array, int findSum) {
        this.array = array;
        this.findSum = findSum;
    }

    public Task13Command() {
        this.array = new int[]{2, 4, 3, 7, 2, 11, 4};
        this.findSum = 7;
    }

    @Override
    public void execute() {
        System.out.println(find());
    }

    public String find() {

        int max_index;
        int min_index;

        for (int i = 0; i < array.length; i++) {
            max_index = array.length - 1;
            min_index = i;
            while (min_index < max_index) {
                if (array[min_index] + array[max_index - min_index] == findSum) {
                    sb.append(String.format("{%d,%d}{%d+%d}",
                            min_index,
                            max_index - min_index,
                            array[min_index],
                            array[max_index - min_index]
                    ));

                }
                max_index--;
            }
        }

        return sb.toString();

    }
}
