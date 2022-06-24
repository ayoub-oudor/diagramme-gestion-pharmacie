package application;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader; 
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
 

public class Home extends Application {
	@Override
	public void start(Stage primaryStage) {
		try { 
			Parent root = FXMLLoader.load(getClass().getResource("/interfaces/SignUp.fxml"));
			Scene scene = new Scene(root);
//			scene.getStylesheets().add(getsClass().getResource("/css/application.css").toExternalForm());
//			Image icon = new Image("images/icon.png");  
//			primaryStage.getIcons().add(icon);    
			primaryStage.setTitle("Sign Up");
			primaryStage.setScene(scene); 
//			primaryStage.setWidth(800);
//			primaryStage.setHeight(600);  
//			primaryStage.setMaxWidth(300);
//			primaryStage.setMinWidth(100); 
//			primaryStage.setMaxHeight(500);
//			primaryStage.setMinHeight(300);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args); 

	}
}
