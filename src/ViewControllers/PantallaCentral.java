package ViewControllers;

import ViewControllers.Motor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.awt.*;

public class PantallaCentral {
    @FXML
    private ImageView avatarImg;
    @FXML
    private ImageView starterPokemonImg;

    private Motor motor;

    public void receiveMotorInstance(Motor m){
        this.motor = m;
    }
    public void receiveInitialData(String starterPokemon, String gender){
        Image pokemon = new Image("/Images/pokemons/"+starterPokemon+"/"+starterPokemon+".png");
        starterPokemonImg.setImage(pokemon);
        Image genderAvatar = new Image("/Images/pokemons/"+gender+"UserImg.png");
        avatarImg.setImage(genderAvatar);
    }

    public void catchPokemonButton(ActionEvent event) {
        System.out.println("cazemos pokemones");
    }
}
