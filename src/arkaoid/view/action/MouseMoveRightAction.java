package arkaoid.view.action;

public class MouseMoveRightAction extends MouseMoveAction
{

	public MouseMoveRightAction(int dx)
	{
		super(dx);
		// TODO Auto-generated constructor stub
	}

	public MouseMoveRightAction()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDx()
	{
		if (super.getDx() < 0)
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
