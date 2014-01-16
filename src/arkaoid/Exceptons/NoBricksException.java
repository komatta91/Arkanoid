package arkaoid.Exceptons;

@SuppressWarnings("serial")
public class NoBricksException extends GameException
{
	public NoBricksException()
	{
		super();
	}

	public NoBricksException(String message)
	{
		super(message);
	}
}
