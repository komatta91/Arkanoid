package arkaoid.view.action;

public class MouseMoveLeftAction extends MouseMoveAction
{

	public MouseMoveLeftAction(int dx)
	{
		super(dx);
	}

	public MouseMoveLeftAction()
	{
		super();
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
