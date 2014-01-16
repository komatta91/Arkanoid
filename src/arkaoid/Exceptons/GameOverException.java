package arkaoid.Exceptons;

@SuppressWarnings("serial")
public class GameOverException extends GameException
{
	public GameOverException()
	{
		super();
	}

	public GameOverException(String message)
	{
		super(message);
	}
}
