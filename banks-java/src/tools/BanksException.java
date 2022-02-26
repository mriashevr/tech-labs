package tools;

public class BanksException extends Exception
{
    public BanksException()
    {
    }

    public BanksException(String message) {
        super(message);
    }

    public BanksException(String message, Exception innerException) {
        super(message);
    }
}