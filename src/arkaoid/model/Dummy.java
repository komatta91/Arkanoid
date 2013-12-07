package arkaoid.model;

public class Dummy
{
	private boolean menu = false;
	private boolean exit = false;
	private boolean timer = false;
	private boolean game = false;

	public boolean isMenu()
	{
		return menu;
	}

	public void setMenu(boolean menu)
	{
		this.menu = menu;
	}

	public boolean isExit()
	{
		return exit;
	}

	public void setExit(boolean exit)
	{
		this.exit = exit;
	}

	public boolean isTimer()
	{
		return timer;
	}

	public void setTimer(boolean timer)
	{
		this.timer = timer;
	}

	public boolean isGame()
	{
		return game;
	}

	public void setGame(boolean game)
	{
		this.game = game;
	}

}
