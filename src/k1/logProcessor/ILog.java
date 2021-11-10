package k1.logProcessor;

public interface ILog {
    String getType();

    String getMessage();

    void setMessage(String str);

    long getTimestamp();
}