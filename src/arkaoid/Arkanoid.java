package arkaoid;

import arkaoid.controller.Controller;
import arkaoid.model.Model;
import arkaoid.view.View;

public class Arkanoid 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Model model = new Model();
		View widok = new View();
		Controller kontroler = new Controller(widok, model);
		kontroler.run();
	}

}
