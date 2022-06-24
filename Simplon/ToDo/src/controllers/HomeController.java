package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import dao.implement_dao_task;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Tache;


public class HomeController implements Initializable {
	implement_dao_task implDao = new implement_dao_task();
	Tache tache;
	Stage stage;

	@FXML
	private ChoiceBox<String> categorieaction;

	@FXML
	private TableColumn<Tache, String> categoriecol;

    @FXML
    private TextField dateaction;

	@FXML
	private TableColumn<Tache, String> datecol;

	@FXML
	private TableColumn<Tache, String> desciptioncol;

	@FXML
	private TextField discriptionaction;

	@FXML
	private ChoiceBox<String> statutaction;

	@FXML
	private TableColumn<Tache, String> statutcol;

	@FXML
	private TableView<Tache> tableview;

	@FXML
	private TextField titreaction;

	@FXML
	private TableColumn<Tache, String> titrecol;

	@FXML
	private Button add;

	@FXML
	private Button delete;

	@FXML
	private Button update;
	
    @FXML
    private Button logout;
    
	private String[] statut = { "pas encore", "en cours", "terminée" };

	private String[] categorie = { "présentation", "veille", "recherche" };

	public final ObservableList<Tache> data = FXCollections.observableArrayList();

	public void clear() { 
		dateaction.setText(null);
		titreaction.setText(null); 
		discriptionaction.setText(null);
		add.setDisable(false);
 
	} 
	
//	public void  ClickMous(MouseEvent event) {
//		Tache tache = tableview.getSelectionModel().getSelectedItem();
//		
//		System.out.println(tache.getTitre());
//		titreaction.setText(tache.getTitre());
//		discriptionaction.setText(tache.getDescription());
//		statutaction.setValue(tache.getStatut());
//		dateaction.setText(tache.getDeadline());
//		categorieaction.setValue(tache.getNom_category());
//    } 
	
	public void affiche() {
		tableview.getItems().clear();
		data.addAll(implDao.select());
		datecol.setCellValueFactory(new PropertyValueFactory<Tache, String>("deadline"));
		titrecol.setCellValueFactory(new PropertyValueFactory<Tache, String>("titre"));
		desciptioncol.setCellValueFactory(new PropertyValueFactory<Tache, String>("description"));
		statutcol.setCellValueFactory(new PropertyValueFactory<Tache, String>("statut"));
		categoriecol.setCellValueFactory(new PropertyValueFactory<Tache, String>("nom_category"));
		tableview.refresh();
		tableview.setItems(data);
	}

	@FXML
	void add(ActionEvent event) throws IOException {
		Tache tache = new Tache();
		tache.setNom_category(categorieaction.getValue());
		tache.setTitre(titreaction.getText());
		tache.setDescription(discriptionaction.getText());
		tache.setStatut(statutaction.getValue());
		tache.setDeadline(dateaction.getText());
		 
		/* 
		 * dateaction.setSelectedDate(tache.getDeadline().getTime());
		 * 
		 * dateaction.setDeadline(tache.getDeadline().getTime());
		 * 
		 * if (tache.getDeadline() != null) { //tache.setNom_category(dateaction.get());
		 * 
		 * } else { dateaction.setSelectedDate(null);
		 * 
		 * } implDao.insert(tache);
		 */

		implDao.insert(tache);
		affiche();
		clear();
	}

	@FXML 
	void delete(ActionEvent event) throws IOException {
		Tache tache = new Tache (titreaction.getText());
		implDao.delete(tache);
	    affiche();
		clear();
	}

	@FXML
	void update(ActionEvent event) throws IOException {
		Tache tache = new Tache (categorieaction.getValue(),titreaction.getText(),discriptionaction.getText(),statutaction.getValue(),dateaction.getText());
		System.out.println(implDao.update(tache));
		affiche();
		clear();
	}
	
	@FXML
	private void logout(ActionEvent event) throws IOException{
		try {
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/interfaces/SignIn.fxml")));
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
		tableview.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		    	
				
				System.out.println(newSelection.getTitre());
				titreaction.setText(newSelection.getTitre());
				discriptionaction.setText(newSelection.getDescription());
				statutaction.setValue(newSelection.getStatut());
				dateaction.setText(newSelection.getDeadline());
				categorieaction.setValue(newSelection.getNom_category());
		    	

		    }
		});


		affiche();
		statutaction.getItems().addAll(statut);
		categorieaction.getItems().addAll(categorie);
		
	}

}
