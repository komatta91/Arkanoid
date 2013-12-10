package arkaoid.view.action;

import java.awt.Point;

public class MouseMoveAction extends AbstractGameAction
{
	private Point point;

	public MouseMoveAction(Point point)
	{
		this.point = point;
	}

	public MouseMoveAction()
	{

	}

	@Override
	public int compareTo(Object o)
	{
		// TODO Auto-generated method stub
		return this.getClass().toString().hashCode();
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	public Point getPoint()
	{
		return point;
	}

	public void setPoint(Point point)
	{
		this.point = point;
	}

}
