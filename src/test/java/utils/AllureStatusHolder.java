package utils;

public class AllureStatusHolder {

    private static final ThreadLocal<Boolean> testPassed = ThreadLocal.withInitial(() -> true);

    public static void setPassed(boolean isPassed) {
        testPassed.set(isPassed);
    } // default = başarılıdır

    public static boolean isPassed() {
        return testPassed.get();
    }

    public static void clear() {
        testPassed.remove();
    }
}