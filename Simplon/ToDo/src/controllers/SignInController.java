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
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.User;

public class SignInController implements Initializable{
	

	implement_dao implDao = new implement_dao();

	User user; 
	Stage stage;
	
    @FXML
    private Hyperlink createaccountbtn;

    @FXML
    private Hyperlink forgetpasswordbtn;

    @FXML
    private PasswordField password;

    @FXML
    private Button signinbtn;

    @FXML
    private TextField username;
	
    @FXML
    private Label usernamelabel;
    
    @FXML
    private Label namelabel; 
    
    @FXML
    private Label passwordlabel;
    
    //Alert alert = new Alert(AlertType.NONE);
    //Alert alert2 = new Alert(AlertType.WARNING);
    
    void clear() {
        username.setText(null); 
        password.setText(null);
        signinbtn.setDisable(false);
    }



    @FXML
    private void signinbtn(ActionEvent event) throws IOException{
    	
        Window owner = signinbtn.getScene().getWindow();

        System.out.println(username.getText());
        System.out.println(password.getText());
    	
        if (username.getText().isEmpty() && password.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter username and password ");
            return;
        }else if(username.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter your username");
                return; 
        }else if(password.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter a password");
        }else {  
        	
        	String nom = username.getText();
        	String pass = password.getText();
        	
        	boolean flag = implDao.login(nom, pass);
        	

    		try { 

		    			if(flag) {
		    	   
			    	            infoBox("Login Successful!", null, "Failed");
			    	            
			            		try {
			    	        		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/interfaces/Home.fxml")));
			    	                stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
			    	                stage.setScene(scene);   
			    	                stage.show(); 
			            		} 
			            		catch(Exception e){
			            			e.printStackTrace(); 
			            			System.out.println("problem in link");
			            		}		
		    				
		    			}
		    			else if(!flag) {
		    				
		    				infoBox("Please enter correct Email and Password", null, "Failed");
		    			}
		    			
    			
    		} catch (Exception e) {
    			e.printStackTrace();
    			System.err.println("problem in lister...");
    		}
    		
    	}
       
    }
        	
   

	public static void infoBox(String infoMessage, String headerText, String title) {
	    Alert alert = new Alert(AlertType.CONFIRMATION);
	    alert.setContentText(infoMessage);
	    alert.setTitle(title);
	    alert.setHeaderText(headerText);
	    alert.showAndWait();
	}
    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

	@FXML
    private void createaccountbtn(ActionEvent event) throws IOException {
    	try {
    		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/interfaces/SignUp.fxml")));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			//Image icon = new Image("images/task.png");
			//primaryStage.getIcons().add(icon);
            stage.setScene(scene);  
            stage.show(); 
    		}
    		catch(Exception e){
    			e.printStackTrace(); 
    			System.out.println("problem in link ");
    		}
    }
    
    @FXML
    private void forgetpasswordbtn() throws IOException{ 
    	
    }
    
	public void initialize(URL url, ResourceBundle rb) {
		
	}

}
