package application;

import java.util.Optional;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class SampleController implements Initializable  {

    @FXML
    private TextField txt1vol;

    @FXML
    private Tab accueil;

    @FXML
    private Tab Temperature;

    @FXML
    private TextField txt2vol;

    @FXML
    private TextField txt2long;

    @FXML
    private TextField txt2temp;

    @FXML
    private ComboBox<String> box2vol;

    @FXML
    private ComboBox<String> box1temp;

    @FXML
    private Tab Longeurs;

    @FXML
    private ComboBox<String> box1vol;

    @FXML
    private ComboBox<String> box1long;

    @FXML
    private Tab Volumes;

    @FXML
    private TextField txt1long;

    @FXML
    private ComboBox<String> box2temp;

    @FXML
    private TextField txt1temp;

    @FXML
    private ComboBox<String> box2long;
    
    @FXML
    void check1() {
    	verifNum(txt1long); }
    
    @FXML
    void check2() {
    	verifNum(txt2long); }
    
    @FXML
    void check3() {
    	verifNum(txt1vol); }
    
    @FXML
    void check4() {
    	verifNum(txt2vol); }
    
    @FXML
    void check5() {
    	verifNum(txt1temp); }
    
    @FXML
    void check6() {
    	verifNum(txt2temp); }
  
    
    @FXML
    private void Quitter()
    {
    Alert alert=new Alert(AlertType.CONFIRMATION);
    alert.setHeaderText("Quitter?");
    alert.setTitle("CONFIRMATION");
    alert.setContentText("Voulez vous quitter?");
    Optional<ButtonType> result=alert.showAndWait();
    if(result.get()==ButtonType.OK)
    {
    System.exit(0);
    }
    }

     
//longeur
    private ObservableList<String> listelong = (ObservableList<String>)FXCollections.observableArrayList("Kilomètre (km)", "Hectomètre (hm)", "Décamètre (dam)", "Mètre (m)", "Décimètre (dm)","Centimètre (cm)", "Millimètre (mm)", "Pouce (in)", "Pied (ft)", "Cour (yd)", "Mile (Mile)");
//Volumes
    private ObservableList<String> listevol = (ObservableList<String>)FXCollections.observableArrayList("Kilolitre (kl)", "Hectolitre (hl)", "Décalitre (dal", "Litre (l)", "Décilitre (dl)", "centilitre (cl)", "Millilitre (ml)", "Once liquide (fl oz)", "Pinte (pt)", "Quart (qt)", "Gallon (gal)");
 //tempurature
    private ObservableList<String> listetemp = (ObservableList<String>)FXCollections.observableArrayList("Kelvin (K)", "Celsius (C)", "Fahrenheit (F)");

    
    double []Longeurs1= {0.001,0.01,0.1,1.0,10.0,100.0,1000.0,39.37007874,3.28084,1.09361,0.000621371};
    
    double []Volume1= {0.001,0.01,0.1,1.0,10.0,100.0,1000.0,0.0295735,0.0520421,0.0260211,0.00650527};

    double []Temp1= {274.15,1.0,33.8};

    public void initialize(URL location, ResourceBundle resources)
    {
    	//longueurs
    	box1long.getItems().addAll(listelong);    	
    	box2long.getItems().addAll(listelong);
    	box1long.getSelectionModel().selectFirst();
    	box2long.getSelectionModel().selectFirst();
    	//volumes
    	box1vol.getItems().addAll(listevol);
    	box2vol.getItems().addAll(listevol);
    	box1vol.getSelectionModel().selectFirst();
    	box2vol.getSelectionModel().selectFirst();
    	//tempuratire
    	box1temp.getItems().addAll(listetemp);
    	box2temp.getItems().addAll(listetemp);
    	box1temp.getSelectionModel().selectFirst();
    	box2temp.getSelectionModel().selectFirst();
    }

    @FXML
    void calculer1long()
    {
    	convertir(txt1long,txt2long,box1long,box2long,listelong);	
    }
     
    @FXML
    void calculer2long()
    {
    	convertir(txt2long,txt1long,box2long,box1long,listelong);	
    }
//volume
    
    @FXML
    void calculer1vol()
    {
    	convertir(txt1vol,txt2vol,box1vol,box2vol,listevol);	
    }
    private void convertir(TextField txt1vol2, TextField txt2vol2, ComboBox<String> box1vol2, ComboBox<String> box2vol2,
		ObservableList<String> listevol2) {
	// TODO Auto-generated method stub
	
}
	@FXML
    void calculer2vol()
    {
    	convertir(txt2vol,txt1vol,box2vol,box1vol,listevol);	
    }
 //temp
    @FXML
    void calculer1temp()
    {
    	convertir(txt1temp,txt2temp,box1temp,box2temp,listetemp);	
    }
    @FXML
    void calculer2temp()
    {
    	convertir(txt2temp,txt1temp,box2temp,box1temp,listetemp);
    
    }
  void convertir(TextField txtA,TextField txtB,ComboBox<String> boxA,ComboBox<String> boxB,double [] tab)
    {
    	verifNum(txtA);
    	
    	int item1=boxA.getSelectionModel().getSelectedIndex();
    	int item2=boxB.getSelectionModel().getSelectedIndex();
    	try
    	{
    		double taux=tab[item2]/tab[item1];
    		double res=taux*(Double.parseDouble(txtA.getText()));
    		txtB.setText(Double.toString(res));
    	} catch (NumberFormatException e)
    	{
    		txtA.setText("0");
    	}	
    }

    void verifNum(TextField a)
    {
    	if(a.getText().equals("")) 
    	a.setText("0");

    	
    	a.textProperty().addListener((observable,oldValue,newValue)->
    	{
    		if(!newValue.matches("^[0-9](\\.[0-9]+)?$"))
    		{
    			a.setText(newValue.replaceAll("[^\\d*\\.]", ""));
    		}
    		
    	});
    	
    	
    }

	@Override
	public void initialize(java.net.URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	
		
	}
        
        
 
