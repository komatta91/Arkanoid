package arkaoid.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;

import arkaoid.ArkanoidStatic;

public class LayoutMenuMenager implements LayoutManager
{
	private int buttonHeight = 50;
	/** Domyślna szerokość przycisku stanowiąca 75% szerokości okna */
	private int buttonWidth = (int)(ArkanoidStatic.MENU_DIMENSION.getWidth() * 3 / 4);
	private int gap = buttonHeight * 1 / 2;
	private int imageBottom = 0;
	private boolean sizesSet = false;

	@Override
	public void addLayoutComponent(String name, Component comp)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void layoutContainer(Container parent)
	{
		if (!sizesSet)
			setSizes(parent);
		// TODO Auto-generated method stub
		int n = parent.getComponentCount();
		int x = parent.getWidth() / 2 - buttonWidth / 2;
		int y = imageBottom - buttonHeight;

		// System.out.println(imageBottom);

		for (int i = 0; i < n; ++i)
		{
			// System.out.println(y);
			y += gap + buttonHeight;
			// System.out.println(DEFAULT_BUTTON_WIDTH );
			// System.out.println(y);
			Component c = parent.getComponent(i);
			c.setBounds(x, y, buttonWidth, buttonHeight);
		}
	}

	@Override
	public Dimension minimumLayoutSize(Container parent)
	{
		// TODO Auto-generated method stub
		if (!sizesSet)
			setSizes(parent);
		return preferredLayoutSize(parent);
	}

	@Override
	public Dimension preferredLayoutSize(Container parent)
	{
		// TODO Auto-generated method stub
		if (!sizesSet)
			setSizes(parent);
		Insets insets = parent.getInsets();
		int width = buttonWidth + insets.left + insets.right;
		int height = buttonHeight + insets.top + insets.top;
		return new Dimension(width, height);
	}

	@Override
	public void removeLayoutComponent(Component comp)
	{
		// TODO Auto-generated method stub
	}

	public void setImageBottom(int imageBottom)
	{
		this.imageBottom = imageBottom;
	}

	private void setSizes(Container parent)
	{
		int gap = 0;
		int h = 0;
		int place = parent.getHeight() - imageBottom;
		int n = parent.getComponentCount();
		int s = place / (n * 3 + 1);
		h = 2 * s;
		gap = s;
		buttonHeight = h;
		this.gap = gap;
		sizesSet = true;

		// System.out.println(buttonHeight);
		// System.out.println(this.gap);
	}
}
