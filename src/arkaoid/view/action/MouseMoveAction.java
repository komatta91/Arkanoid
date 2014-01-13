package arkaoid.view.action;


public class MouseMoveAction extends AbstractGameAction
{
	private int dx;
	
	public MouseMoveAction()
	{
		dx = 0;
	}
	
	public MouseMoveAction(int dx)
	{
		this.setDx(dx);
	}


	@Override
	public int compareTo(Object o)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hashCode()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Object obj)
	{
		// TODO Auto-generated method stub
		return false;
	}
	public int getDx()
	{
		return dx;
	}
	public void setDx(int dx)
	{
		this.dx = dx;
	}
}
