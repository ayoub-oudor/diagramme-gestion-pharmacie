package application;

import dao.implement_dao_task;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Tache extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/interfaces/Home.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show(); 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

	} 
 
	public static void main(String[] args) {

		  launch(args);

		
//		  implement_dao_task imp = new implement_dao_task(); 
//		  models.Tache task = new models.Tache("presentation", "metaverse", "ar vr xr", "en cours", "20-06-2022");
//		  System.out.println(imp.insert(task));
//		  models.Tache task = new models.Tache("metaverse");
//		  imp.delete(task);
//		  models.Tache task = new models.Tache("presentation", "metaverse", "AR VR XR NFTS", "en cours", "20-06-2022");
//		  System.out.println(imp.update(task));
		  

	}
}
