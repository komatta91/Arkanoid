package arkaoid.view.action;

public class TimerAction extends AbstractGameAction
{

	@Override
	public int compareTo(Object arg0)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hashCode()
	{
		// TODO Auto-generated method stub
		return this.getClass().toString().hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		// TODO Auto-generated method stub
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		return true;
	}	

}
