package arkaoid.view;

public class WindowAction extends AbstractGameAction
{
	private final String name;
	
	public WindowAction(String name)
	{
		this.name = name;
	}
	
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return name;
	}

}
