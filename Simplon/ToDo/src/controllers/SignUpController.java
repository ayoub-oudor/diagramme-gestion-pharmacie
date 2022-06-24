package controllers;
 
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import dao.implement_dao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.User;

 

public class SignUpController implements Initializable{
	implement_dao implDao = new implement_dao(); 
	User user;
	Stage stage;
	Alert alert = new Alert(AlertType.NONE);
	Alert alert2 = new Alert(AlertType.WARNING);
	
	String pattern = "[a-z A-Z]*[0-9]+[a-z A-Z]";
	String pass = "[]";
    @FXML
    private Button btnconnexion;

    @FXML
    private Button btnenregistrer;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;
    
    void clear() {
        username.setText(null); 
        name.setText(null);
        password.setText(null);
        btnenregistrer.setDisable(false);
    }
    
	public void insertion(){
		User user = new User(username.getText(),name.getText(),password.getText());
		implDao.insert(user);
	}
	
	
	@FXML 
    private void btnenregistrer(ActionEvent event) throws IOException {
		insertion();   
		clear();  
//		if(username.getText().isEmpty() && (name.getText().isEmpty() || password.getText().isEmpty())) {
//            alert.setAlertType(AlertType.ERROR);
//            alert.show();
//            alert2.setAlertType(AlertType.WARNING);
//            alert2.show();
//            alert.setTitle("les champs est vide");
//            alert.setHeaderText("Please Enter username , name and password");
//            alert.setContentText("Please Enter username , name and password");
//		}else if (username.getText().isEmpty() ||  (name.getText().isEmpty() && password.getText().isEmpty())) {
//            alert.setAlertType(AlertType.ERROR);
//            alert.show();
//            alert2.setAlertType(AlertType.WARNING);
//            alert2.show();
//            alert.setTitle("un champ ou plusieures champs sont vide");
//            alert.setHeaderText("Please Enter username , name or password");
//            alert.setContentText("Please Enter username , name and password");
//		}else {
			
		try {
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Interfaces/SignIn.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);  
        stage.show(); 
		} 
		catch(Exception e){
			e.printStackTrace();
			System.out.println("problem in link "); 
		}	
	  } 
	//}
	@FXML  
	private void btnconnexion(ActionEvent event) throws IOException {
		try {
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Interfaces/SignIn.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);  
        stage.show(); 
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("problem in link ");
		}
	}
	
	public void initialize(URL url, ResourceBundle rb) {
		 
	}

}
