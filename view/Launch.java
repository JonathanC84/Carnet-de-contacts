package view;

import controller.Controller;

public class Launch {
	
	public static void main(String[] args) {
		
		View vue = new View();
		Controller controller1 = new Controller(vue);
		
		try {
			vue.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
