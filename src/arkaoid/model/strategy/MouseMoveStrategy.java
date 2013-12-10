package arkaoid.model.strategy;

import java.awt.Point;

import arkaoid.model.Model;

public class MouseMoveStrategy extends AbstractStrategy
{
	private Point point;

	public MouseMoveStrategy(Point point)
	{
		this.setPoint(point);
	}

	public MouseMoveStrategy()
	{
		
	}

	@Override
	public void doStrategy(Model model)
	{
		// TODO Auto-generated method stub
		//System.out.println("Dziala");
		model.doStrategy(this);
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
