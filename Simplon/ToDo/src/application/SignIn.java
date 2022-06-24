package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignIn extends Application { 
	 
	@Override  
public void start(Stage stage) {
		try {
			Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Interfaces/SignIn.fxml")));
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args); 
	}

} 
 