package by.epam.procube.util;

public class IdGenerator {
    private static final long MIN_ID = 1;
    private static final long MAX_ID = 1_333_777_999;
    private static long idCounter;

    private IdGenerator() {
    }

    public static long generateId() {
        ++idCounter;
        if (MIN_ID + idCounter >= MAX_ID) {
            idCounter = 0;
        }
        return idCounter;
    }

    public static void setId(long id) {
        if (id >= MIN_ID && id <= MAX_ID) {
            idCounter = id;
        } else {
            idCounter = 0;
        }
    }

}