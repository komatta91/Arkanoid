package arkaoid.view;

public class ButtonAction extends AbstractGameAction
{

	private final String name;

	public ButtonAction(String name)
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
