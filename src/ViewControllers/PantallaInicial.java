package ViewControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * Controller for Pantalla Inicial
 */
public class PantallaInicial {

    private Motor motor;
    @FXML
    private ImageView userImageView;

    @FXML
    private TextField userNameTextField;
    @FXML
    private Group userNameGroup;
    @FXML
    private Group characterGroup;
    @FXML
    private Group pokemonsGroup;
    @FXML
    private ImageView firstStageNextButton;
    @FXML
    private ImageView secondStageNextButton, bulbasaurName, squirtleName, charmanderName;
    @FXML
    private Label oakDialogue;
    @FXML
    private ImageView startButton, femaleImg, maleImg, maleUserImg, femaleUserImg, bulbasaurSelectImg, squirtleSelectImg, charmanderSelectImg, bulbasaurImg, squirtleImg, charmanderImg;

    private String userName;
    private String gender="";
    private int coins;
    private String starterPokemon = "";

    /**
     * character selection
     * @param event
     */

    /**
     * radio button selections for each starter pokemon
     */

    public void receiveMotorInstance(Motor m){
        this.motor = m;
    }

    public void showSecondStage(MouseEvent event) {
        /**
         * shows character selection scene
         */
        if (userNameTextField.getText().equals("")){
            oakDialogue.setText("Oops! you must choose a name");
        }
        else if (userNameTextField.getText().length()>15){
            oakDialogue.setText("Oops! your name is longer than 15 characters");
        }
        else{
            userName = userNameTextField.getText();
            userNameGroup.setVisible(false);
            firstStageNextButton.setVisible(false);
            characterGroup.setVisible(true);
            secondStageNextButton.setVisible(true);
            oakDialogue.setText("Alright! "+userName+", \nnow pick a character");
        }
    }
    public void showThirdStage(MouseEvent event) {
        /**
         * shows pokemon selection scene
         */
        if(gender==""){
            oakDialogue.setText("Oops! you need to pick a character");
        } else {
            characterGroup.setVisible(false);
            secondStageNextButton.setVisible(false);
            pokemonsGroup.setVisible(true);
            startButton.setVisible(true);
            oakDialogue.setText("Ok, choose a pokemon \nto start on the adventure!");
        }
    }
    public void startGame(MouseEvent event) {
        /**
         * sets starting data to useer and sends it to Motor class
         */
        if (starterPokemon==""){
            oakDialogue.setText("Oops! you need to pick a pokemon");
        } else {
            coins = 20;
            motor.setStartingData(userName, gender, starterPokemon, coins);
            motor.showPantallaBosque(event);
        }
    }

    public void setMaleGender(MouseEvent mouseEvent) {
        femaleUserImg.setVisible(true);
        femaleImg.setVisible(false);
        maleUserImg.setVisible(false);
        maleImg.setVisible(true);
        gender="male";
    }

    public void setFemaleGender(MouseEvent mouseEvent) {
        maleUserImg.setVisible(true);
        maleImg.setVisible(false);
        femaleUserImg.setVisible(false);
        femaleImg.setVisible(true);
        gender="female";
    }

    public void selectBulbasaur(MouseEvent mouseEvent) {
        bulbasaurImg.setVisible(true);
        starterPokemon = "Bulbasaur";
        bulbasaurSelectImg.setVisible(false);
        squirtleImg.setVisible(false);
        squirtleSelectImg.setVisible(true);
        charmanderImg.setVisible(false);
        charmanderSelectImg.setVisible(true);
        bulbasaurName.setVisible(true);
        squirtleName.setVisible(false);
        charmanderName.setVisible(false);

    }

    public void selectSquirtle(MouseEvent mouseEvent) {
        squirtleImg.setVisible(true);
        starterPokemon="Squirtle";
        squirtleSelectImg.setVisible(false);
        bulbasaurSelectImg.setVisible(true);
        bulbasaurImg.setVisible(false);
        charmanderSelectImg.setVisible(true);
        charmanderImg.setVisible(false);
        squirtleName.setVisible(true);
        bulbasaurName.setVisible(false);
        charmanderName.setVisible(false);
    }

    public void selectCharmander(MouseEvent mouseEvent) {
        charmanderImg.setVisible(true);
        starterPokemon="Charmander";
        charmanderSelectImg.setVisible(false);
        bulbasaurImg.setVisible(false);
        bulbasaurSelectImg.setVisible(true);
        squirtleSelectImg.setVisible(true);
        squirtleImg.setVisible(false);
        charmanderName.setVisible(true);
        bulbasaurName.setVisible(false);
        squirtleName.setVisible(false);
    }
}