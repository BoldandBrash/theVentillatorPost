package b.boldandbrash;

/**
 * Created by Benjamin on 11/11/2017.
 */

public class QuestionsCounter {
    private static int count = 0;

    private QuestionsCounter() {}

    public static void incrementCount() {
        ++count;
    }

    public static int getCount() {
        return count;
    }
}
