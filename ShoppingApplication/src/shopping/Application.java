package shopping;

import shopping.Views.AuthenticationPanel;
import shopping.Views.MasterPanel;

public class Application {
	public static void main(String[] args) {
//		mainWindow.setVisible(true);
		
		AuthenticationPanel authenticationWindow = new AuthenticationPanel();
		authenticationWindow.setVisible(true);
	}
}
