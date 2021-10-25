package lab1.sistemZaBankarskoRabotenje;

public interface ToDouble {
    static double toDouble(String str) {
        return Double.parseDouble(str.substring(0, str.length() - 1));
    }
}
