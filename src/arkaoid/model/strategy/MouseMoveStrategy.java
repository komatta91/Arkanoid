package arkaoid.model.strategy;

import arkaoid.model.Model;

public class MouseMoveStrategy extends AbstractStrategy
{
	private int dx;

	public MouseMoveStrategy(int dx)
	{
		this.setDx(dx);
	}

	public MouseMoveStrategy()
	{
		this.setDx(0);
	}

	@Override
	public void doStrategy(Model model)
	{
		model.doStrategy(this);
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
