package arkaoid.Exceptons;

import java.io.IOException;

@SuppressWarnings("serial")
public abstract class GameException extends IOException
{
	public GameException()
	{
		super();
	}
	
	public GameException(String message)
	{
		super(message);
	}
}
