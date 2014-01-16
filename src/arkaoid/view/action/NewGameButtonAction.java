package arkaoid.view.action;

public class NewGameButtonAction extends ButtonAction
{

	@Override
	public int compareTo(Object o)
	{
		return 0;
	}

	@Override
	public int hashCode()
	{
		return this.getClass().toString().hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}
