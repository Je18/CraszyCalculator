package application;

import java.io.InputStream;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class VueController {

    @FXML
    private ImageView imgVtt;

    @FXML
    private ImageView imgVeloVille;
    
    @FXML
    private ImageView imgCard;
    
    @FXML
    private Label titleTxt;
    
    @FXML
    private Label priceTxt;
    
    @FXML 
    private ChoiceBox<String> choiceColorBox;
    
    @FXML 
    private Label totalColorPrice;
    
    @FXML
    private ChoiceBox<String> choiceSizeBox;
    
    @FXML
    private Label totalSizePrice;
    
    @FXML
    private CheckBox labelPerso;

    Velo vtt = new Velo("VTT", "RockRider", "vttGris.jpg", 289);
    Velo ville = new Velo("Ville", "Elops", "veloVilleJaune.jpg", 299);
    
    CouleurCadre colorGa = new CouleurCadre("Gris ardoise", 180);
    CouleurCadre colorGp = new CouleurCadre("Gris perle", 380);
    CouleurCadre colorTv = new CouleurCadre("Tomate vif", 500);
    
    
    CouleurCadre colorJa = new CouleurCadre("Jaune", 300);
    CouleurCadre colorNr = new CouleurCadre("Noir", 200);
    
    Personnalisation personnalisation = new Personnalisation("Roue de secours", 120);
    
    Taille sizeS = new Taille("S", 150);
    Taille sizeM = new Taille("M", 200);
    Taille sizeL = new Taille("L", 250);
    Taille sizeXL = new Taille("XL", 300);

    @FXML
    public void onClickImage(MouseEvent e) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vue2.fxml"));
            Pane newView = loader.load();
            Stage stage = (Stage) ((ImageView) e.getSource()).getScene().getWindow();
            stage.setScene(new Scene(newView));
            
            imgCard = (ImageView) newView.lookup("#imgCard");
            titleTxt = (Label) newView.lookup("#titleTxt");
            priceTxt = (Label) newView.lookup("#priceTxt");
            choiceColorBox = (ChoiceBox) newView.lookup("#choiceColorBox");
            totalColorPrice = (Label) newView.lookup("#totalColorPrice");
            choiceSizeBox = (ChoiceBox) newView.lookup("#choiceSizeBox");
            totalSizePrice = (Label) newView.lookup("#totalSizePrice");
            labelPerso = (CheckBox) newView.lookup("#labelPerso");
            
            if (e.getSource() == imgVtt) {
                InputStream inputS = getClass().getResourceAsStream(vtt.getLienPhoto());
                if (inputS != null) {
                    Image img = new Image(inputS);
                    imgCard.setImage(img);
                }
                
                titleTxt.setText(vtt.getMarque());
                priceTxt.setText(String.valueOf(vtt.getDefaultPrice()) + "€");
                
                // Liste déroulante COLOR
                choiceColorBox.getItems().clear();
                choiceColorBox.getItems().addAll(colorGa.getColor(), colorGp.getColor(), colorTv.getColor());
                choiceColorBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        vtt.clearOption(); 
                        if (choiceColorBox.getValue().equals("Gris ardoise")) {
                            InputStream inputO = getClass().getResourceAsStream("vttGris.jpg");
                            if (inputO != null) {
                                Image img = new Image(inputO);
                                imgCard.setImage(img);
                            }
                            vtt.addOption(colorGa);
                            totalColorPrice.setText("+" + colorGa.getPrice() + "€");
                            priceTxt.setText(String.valueOf(vtt.getDefaultPrice() + colorGa.getPrice()));
                        } else if (choiceColorBox.getValue().equals("Gris perle")) {
                            InputStream inputO = getClass().getResourceAsStream("vttGris2.jpg");
                            if (inputO != null) {
                                Image img = new Image(inputO);
                                imgCard.setImage(img);
                            }
                            vtt.addOption(colorGp);
                            totalColorPrice.setText("+" + colorGp.getPrice() + "€");
                            priceTxt.setText(String.valueOf(vtt.getDefaultPrice() + vtt.calculPrix()));
                        } else if (choiceColorBox.getValue().equals("Tomate vif")) {
                            InputStream inputO = getClass().getResourceAsStream("vttOrange.jpg");
                            if (inputO != null) {
                                Image img = new Image(inputO);
                                imgCard.setImage(img);
                            }
                            vtt.addOption(colorTv);
                            totalColorPrice.setText("+" + colorTv.getPrice() + "€");
                            priceTxt.setText(String.valueOf(vtt.getDefaultPrice() + vtt.calculPrix()));
                        }
                    }
                });
                
                // Liste déroulante SIZE
                choiceSizeBox.getItems().clear();
                choiceSizeBox.getItems().addAll(sizeS.getSize(), sizeM.getSize(), sizeL.getSize(), sizeXL.getSize());
                choiceSizeBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        vtt.clearOption(); 
                        priceTxt.setText(String.valueOf(vtt.getDefaultPrice()) + "€");
                        if (choiceSizeBox.getValue().equals("S")) {
                            vtt.addOption(sizeS);
                            totalSizePrice.setText("+" + sizeS.getPrice() + "€");
                        } else if (choiceSizeBox.getValue().equals("M")) {
                            vtt.addOption(sizeM);
                            totalSizePrice.setText("+" + sizeM.getPrice() + "€");
                        } else if (choiceSizeBox.getValue().equals("L")) {
                            vtt.addOption(sizeL);
                            totalSizePrice.setText("+" + sizeL.getPrice() + "€");
                        } else if (choiceSizeBox.getValue().equals("XL")) {
                            vtt.addOption(sizeXL);
                            totalSizePrice.setText("+" + sizeXL.getPrice() + "€");
                        }
                        priceTxt.setText(String.valueOf(vtt.calculPrix()));
                    }
                });
                
                // Vérification du CheckBox labelPerso
                labelPerso.selectedProperty().addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                        if (newValue) {
                            vtt.addOption(personnalisation);
                            priceTxt.setText(String.valueOf(vtt.calculPrix()));
                        } else {
                            vtt.removeOption(personnalisation);
                        }
                    }
                });

                labelPerso.setText(personnalisation.getPerson());
            } else if (e.getSource() == imgVeloVille) {
                InputStream inputS = getClass().getResourceAsStream(ville.getLienPhoto());
                if (inputS != null) {
                    Image img = new Image(inputS);
                    imgCard.setImage(img);
                } 
                titleTxt.setText(ville.getMarque());
                priceTxt.setText(String.valueOf(ville.getDefaultPrice()) + "€");
                
                // Liste déroulante COLOR
                choiceColorBox.getItems().clear();
                choiceColorBox.getItems().addAll(colorJa.getColor(), colorNr.getColor());
                choiceColorBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    	ville.clearOption(); 
                        if (choiceColorBox.getValue().equals("Jaune")) {
                            InputStream inputO = getClass().getResourceAsStream("veloVilleJaune.jpg");
                            if (inputO != null) {
                                Image img = new Image(inputO);
                                imgCard.setImage(img);
                            }
                            ville.addOption(colorGa);
                            totalColorPrice.setText("+" + colorJa.getPrice() + "€");
                            priceTxt.setText(String.valueOf(ville.getDefaultPrice() + colorJa.getPrice()));
                        } else if (choiceColorBox.getValue().equals("Noir")) {
                            InputStream inputO = getClass().getResourceAsStream("veloVilleNoir.jpg");
                            if (inputO != null) {
                                Image img = new Image(inputO);
                                imgCard.setImage(img);
                            }
                            ville.addOption(colorNr);
                            totalColorPrice.setText("+" + colorNr.getPrice() + "€");
                            priceTxt.setText(String.valueOf(ville.getDefaultPrice() + ville.calculPrix()));
                        }
                    }
                });
                
                // Liste déroulante SIZE
                choiceSizeBox.getItems().clear();
                choiceSizeBox.getItems().addAll(sizeS.getSize(), sizeM.getSize(), sizeL.getSize(), sizeXL.getSize());
                choiceSizeBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    	ville.clearOption(); 
                        priceTxt.setText(String.valueOf(ville.getDefaultPrice()) + "€");
                        if (choiceSizeBox.getValue().equals("S")) {
                        	ville.addOption(sizeS);
                            totalSizePrice.setText("+" + sizeS.getPrice() + "€");
                        } else if (choiceSizeBox.getValue().equals("M")) {
                        	ville.addOption(sizeM);
                            totalSizePrice.setText("+" + sizeM.getPrice() + "€");
                        } else if (choiceSizeBox.getValue().equals("L")) {
                        	ville.addOption(sizeL);
                            totalSizePrice.setText("+" + sizeL.getPrice() + "€");
                        } else if (choiceSizeBox.getValue().equals("XL")) {
                        	ville.addOption(sizeXL);
                            totalSizePrice.setText("+" + sizeXL.getPrice() + "€");
                        }
                        priceTxt.setText(String.valueOf(ville.calculPrix()));
                    }
                });
                
                // Vérification du CheckBox labelPerso
                labelPerso.selectedProperty().addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                        if (newValue) {
                        	ville.addOption(personnalisation);
                            priceTxt.setText(String.valueOf(vtt.calculPrix()));
                        } else {
                        	ville.removeOption(personnalisation);
                        }
                    }
                });

                labelPerso.setText(personnalisation.getPerson());
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
