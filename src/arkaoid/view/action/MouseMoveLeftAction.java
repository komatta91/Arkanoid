package arkaoid.view.action;

public class MouseMoveLeftAction extends MouseMoveAction
{

	public MouseMoveLeftAction(int dx)
	{
		super(dx);
		// TODO Auto-generated constructor stub
	}
	
	public MouseMoveLeftAction()
	{
		// TODO Auto-generated constructor stub
		super(0);
	}

	public int getDx()
	{
		if (super.getDx() > 0)
		{
			return -super.getDx();
		}
	return super.getDx();
	}
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
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}
