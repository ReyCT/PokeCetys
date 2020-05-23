package ViewControllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Pokedex {
    private Motor motor;
    @FXML
    private ImageView switchButton1, switchButton2, switchButton3, switchButton4, switchButton5, switchButton6, pokemonImageView;
    @FXML
    private Label pokemonName1, pokemonName2, pokemonName3, pokemonName4, pokemonName5, pokemonName6, pokemonNameLabel;
    @FXML
    private Label pokeInfo1, pokeInfo2, pokeInfo3, pokeInfo4, pokeInfo5, pokeInfo6, pokeballsQuantity, healsQuantity, coinsQuantity, lossesQuantity, foundPokemons, playerName;
    @FXML
    private ImageView beltPokemon1, beltPokemon2, beltPokemon3, beltPokemon4, beltPokemon5, beltPokemon6, playerGenderImg;
    @FXML
    private ImageView forestMedal, plainsMedal, beachMedal, townMedal, cavesMedal, mountainsMedal, onFireMedal;
    @FXML
    private ImageView onFirePopUp, forestPopUp, plainsPopUp, townPopUp, cavesPopUp, mountainsPopUp, beachPopUp;
    @FXML
    private ListView<String> storagePokemonList, allPokemonsList;
    @FXML
    private Group selectNewPokemonGroup;
    @FXML
    private ImageView newPokemonImg;
    @FXML
    private Label newPokemonName, newPokemonInfo;
    private pokemon selectedPokemon = new pokemon();
    private int arrayPos;
    private int selectionArrayPos;

    private ObservableList<String> pokemonList = FXCollections.observableArrayList();
    private ObservableList<String> allPokemons = FXCollections.observableArrayList();

    public Pokedex(){
        
    }

    public void initialize(){
        storagePokemonList.setItems(pokemonList);
        storagePokemonList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


        allPokemonsList.setItems(allPokemons);
        allPokemonsList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public void receiveMotorInstance(Motor m){
        this.motor = m;

        allPokemons.clear();
        for (int i=0; i<motor.getAllPokemon().size(); i++){
            allPokemonsList.getItems().addAll(motor.getAllPokemon().get(i).getNombre());
        }
        //ensures that setting each pokemon to its place doesnt make null pointer exception
        int bound=0;
        for (int s=0; s<motor.getBeltPokemon().size(); s++){
            if (motor.getBeltPokemon().get(s)!=null){
                bound++;
            }
            else if (s==6){
                break;
            }
        }
        /**
         * sets each pokemon from the belt to the pokedex selection areas
         */
        for (int p=0; p<bound; p++){
            if (p==0){
                Image belt1 = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(0).getNombre()+"/"+motor.getBeltPokemon().get(0).getNombre()+".png");
                switchButton1.setVisible(true);
                pokemonName1.setText(motor.getBeltPokemon().get(0).getNombre());
                pokeInfo1.setText("Lv: "+motor.getBeltPokemon().get(0).getNivel()+"\nHP: "+motor.getBeltPokemon().get(0).getVida()+"\nType: "+motor.getBeltPokemon().get(0).getTipo());
                beltPokemon1.setImage(belt1);

            }
            else if (p==1){
                Image belt2 = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(1).getNombre()+"/"+motor.getBeltPokemon().get(1).getNombre()+".png");
                switchButton2.setVisible(true);
                pokemonName2.setText(motor.getBeltPokemon().get(1).getNombre());
                pokeInfo2.setText("Lv: "+motor.getBeltPokemon().get(1).getNivel()+"\nHP: "+motor.getBeltPokemon().get(1).getVida()+"\nType: "+motor.getBeltPokemon().get(1).getTipo());
                beltPokemon2.setImage(belt2);

            }
            else if (p==2){
                Image belt3 = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(2).getNombre()+"/"+motor.getBeltPokemon().get(2).getNombre()+".png");
                switchButton3.setVisible(true);
                pokemonName3.setText(motor.getBeltPokemon().get(2).getNombre());
                pokeInfo3.setText("Lv: "+motor.getBeltPokemon().get(2).getNivel()+"\nHP: "+motor.getBeltPokemon().get(2).getVida()+"\nType: "+motor.getBeltPokemon().get(2).getTipo());
                beltPokemon3.setImage(belt3);

            }
            else if (p==3){
                Image belt4 = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(3).getNombre()+"/"+motor.getBeltPokemon().get(3).getNombre()+".png");
                switchButton4.setVisible(true);
                pokemonName4.setText(motor.getBeltPokemon().get(3).getNombre());
                pokeInfo4.setText("Lv: "+motor.getBeltPokemon().get(3).getNivel()+"\nHP: "+motor.getBeltPokemon().get(3).getVida()+"\nType: "+motor.getBeltPokemon().get(3).getTipo());
                beltPokemon4.setImage(belt4);

            }
            else if (p==4){
                Image belt5 = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(4).getNombre()+"/"+motor.getBeltPokemon().get(4).getNombre()+".png");
                switchButton5.setVisible(true);
                pokemonName5.setText(motor.getBeltPokemon().get(4).getNombre());
                pokeInfo5.setText("Lv: "+motor.getBeltPokemon().get(4).getNivel()+"\nHP: "+motor.getBeltPokemon().get(4).getVida()+"\nType: "+motor.getBeltPokemon().get(4).getTipo());
                beltPokemon5.setImage(belt5);

            }
            else if (p==5){
                Image belt6 = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(5).getNombre()+"/"+motor.getBeltPokemon().get(5).getNombre()+".png");
                switchButton6.setVisible(true);
                pokemonName6.setText(motor.getBeltPokemon().get(5).getNombre());
                pokeInfo6.setText("Lv: "+motor.getBeltPokemon().get(5).getNivel()+"\nHP: "+motor.getBeltPokemon().get(5).getVida()+"\nType: "+motor.getBeltPokemon().get(5).getTipo());
                beltPokemon6.setImage(belt6);

            }
        }

        /**
         * updates earned medals
         */
        for (int i=0; i<motor.getMedalsList().size(); i++){
            if (i==0){
                forestMedal.setVisible(true);
            }
            else if (i==1){
                plainsMedal.setVisible(true);
            }
            else if (i==2){
                beachMedal.setVisible(true);
            }
            else if (i==3){
                townMedal.setVisible(true);
            }
            else if (i==4){
                cavesMedal.setVisible(true);
            }
            else if (i==5){
                mountainsMedal.setVisible(true);
                if (motor.getLosses()==0){
                    onFireMedal.setVisible(true);
                }
            }
        }

        playerName.setText(motor.getUserName());
        Image playerImg = new Image("Images/pokemons/"+motor.getGender()+"UserImg.png");
        playerGenderImg.setImage(playerImg);
        pokeballsQuantity.setText("x"+motor.getUsrPokeballs()+"");
        healsQuantity.setText("x"+motor.getUsrHeals()+"");
        coinsQuantity.setText("x"+motor.getCoins()+"");
        lossesQuantity.setText("x"+motor.getLosses()+"");
        foundPokemons.setText(motor.getBeltPokemon().size()+"/150");

    }

    public void switchPokemon1(MouseEvent mouseEvent) {
        arrayPos = 0;
        showPokemon(mouseEvent);
    }

    public void switchPokemon2(MouseEvent mouseEvent) {
        arrayPos = 1;
        showPokemon(mouseEvent);
    }

    public void switchPokemon3(MouseEvent mouseEvent) {
        arrayPos = 2;
        showPokemon(mouseEvent);
    }

    public void switchPokemon4(MouseEvent mouseEvent) {
        arrayPos = 3;
        showPokemon(mouseEvent);
    }

    public void switchPokemon5(MouseEvent mouseEvent) {
        arrayPos = 4;
        showPokemon(mouseEvent);
    }

    public void switchPokemon6(MouseEvent mouseEvent) {
        arrayPos = 5;
        showPokemon(mouseEvent);
    }

    public void showPokemon(MouseEvent mouseEvent) {
        selectNewPokemonGroup.setVisible(true);
        pokemonList.clear();
        for (int i=0; i<motor.getBeltPokemon().size(); i++){
            storagePokemonList.getItems().addAll(motor.getBeltPokemon().get(i).getNombre());
        }
    }

    public void refreshPokemonPick(){
        /**
         * shows selected pokemon information
         */
        String pokemonSelection;
        pokemonSelection = storagePokemonList.getSelectionModel().getSelectedItem();
        selectedPokemon = motor.getPokemonByName(String.valueOf(pokemonSelection));
        System.out.println(selectedPokemon.getNombre());
        Image newPkmImage = new Image("/Images/pokemons/"+selectedPokemon.getNombre()+"/"+selectedPokemon.getNombre()+".png");
        newPokemonImg.setImage(newPkmImage);
        newPokemonName.setText(selectedPokemon.getNombre());
        newPokemonInfo.setText("Lv: "+selectedPokemon.getNivel()+"\nHP: "+selectedPokemon.getVida()+"\nType: "+selectedPokemon.getTipo());
    }

    public void selectNewPokemon(MouseEvent mouseEvent){
        /**
         * refreshes the beltpokemon arraylist with the new selected pokemons and positions in array
         */
        selectNewPokemonGroup.setVisible(false);

        pokemon switchedPokemon = motor.getBeltPokemon().get(arrayPos);
        for (int i = 0; i<motor.getBeltPokemon().size(); i++){
            if (selectedPokemon.getNombre().equals(motor.getBeltPokemon().get(i).getNombre())){
                selectionArrayPos = i;
                break;
            }
        }
        motor.getBeltPokemon().set(arrayPos, motor.getPokemonByName(selectedPokemon.getNombre()));
        motor.getBeltPokemon().set(selectionArrayPos, switchedPokemon);

        int bound=0;
        for (int s=0; s<motor.getBeltPokemon().size(); s++){
            if (motor.getBeltPokemon().get(s)!=null){
                bound++;
            }
            else if (s==6){
                break;
            }
        }
        /**
         * refreshes images on the pokedex imageviews of the pokemon order
         */
        for (int p=0; p<bound; p++){
            if (p==0){
                Image belt1 = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(0).getNombre()+"/"+motor.getBeltPokemon().get(0).getNombre()+".png");
                switchButton1.setVisible(true);
                pokemonName1.setText(motor.getBeltPokemon().get(0).getNombre());
                pokeInfo1.setText("Lv: "+motor.getBeltPokemon().get(0).getNivel()+"\nHP: "+motor.getBeltPokemon().get(0).getVida()+"\nType: "+motor.getBeltPokemon().get(0).getTipo());
                beltPokemon1.setImage(belt1);

            }
            else if (p==1){
                Image belt2 = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(1).getNombre()+"/"+motor.getBeltPokemon().get(1).getNombre()+".png");
                switchButton2.setVisible(true);
                pokemonName2.setText(motor.getBeltPokemon().get(1).getNombre());
                pokeInfo2.setText("Lv: "+motor.getBeltPokemon().get(1).getNivel()+"\nHP: "+motor.getBeltPokemon().get(1).getVida()+"\nType: "+motor.getBeltPokemon().get(1).getTipo());
                beltPokemon2.setImage(belt2);

            }
            else if (p==2){
                Image belt3 = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(2).getNombre()+"/"+motor.getBeltPokemon().get(2).getNombre()+".png");
                switchButton3.setVisible(true);
                pokemonName3.setText(motor.getBeltPokemon().get(2).getNombre());
                pokeInfo3.setText("Lv: "+motor.getBeltPokemon().get(2).getNivel()+"\nHP: "+motor.getBeltPokemon().get(2).getVida()+"\nType: "+motor.getBeltPokemon().get(2).getTipo());
                beltPokemon3.setImage(belt3);

            }
            else if (p==3){
                Image belt4 = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(3).getNombre()+"/"+motor.getBeltPokemon().get(3).getNombre()+".png");
                switchButton4.setVisible(true);
                pokemonName4.setText(motor.getBeltPokemon().get(3).getNombre());
                pokeInfo4.setText("Lv: "+motor.getBeltPokemon().get(3).getNivel()+"\nHP: "+motor.getBeltPokemon().get(3).getVida()+"\nType: "+motor.getBeltPokemon().get(3).getTipo());
                beltPokemon4.setImage(belt4);

            }
            else if (p==4){
                Image belt5 = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(4).getNombre()+"/"+motor.getBeltPokemon().get(4).getNombre()+".png");
                switchButton5.setVisible(true);
                pokemonName5.setText(motor.getBeltPokemon().get(4).getNombre());
                pokeInfo5.setText("Lv: "+motor.getBeltPokemon().get(4).getNivel()+"\nHP: "+motor.getBeltPokemon().get(4).getVida()+"\nType: "+motor.getBeltPokemon().get(4).getTipo());
                beltPokemon5.setImage(belt5);

            }
            else if (p==5){
                Image belt6 = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(5).getNombre()+"/"+motor.getBeltPokemon().get(5).getNombre()+".png");
                switchButton6.setVisible(true);
                pokemonName6.setText(motor.getBeltPokemon().get(5).getNombre());
                pokeInfo6.setText("Lv: "+motor.getBeltPokemon().get(5).getNivel()+"\nHP: "+motor.getBeltPokemon().get(5).getVida()+"\nType: "+motor.getBeltPokemon().get(5).getTipo());
                beltPokemon6.setImage(belt6);

            }
        }
    }

    public void showOnFirePopUp(MouseEvent mouseEvent) {
        onFirePopUp.setVisible(true);
    }

    public void closeOnFirePopUp(MouseEvent mouseEvent) {
        onFirePopUp.setVisible(false);
    }

    public void showForestPopUp(MouseEvent mouseEvent) {
        forestPopUp.setVisible(true);
    }

    public void closeForestPopUp(MouseEvent mouseEvent) {
        forestPopUp.setVisible(false);
    }

    public void showPlainsPopUp(MouseEvent mouseEvent) {
        plainsPopUp.setVisible(true);
    }

    public void closePlainsPopUp(MouseEvent mouseEvent) {
        plainsPopUp.setVisible(false);
    }

    public void showBeachPopUp(MouseEvent mouseEvent) {
        beachPopUp.setVisible(true);
    }

    public void closeBeachPopUp(MouseEvent mouseEvent) {
        beachPopUp.setVisible(false);
    }

    public void showTownPopUp(MouseEvent mouseEvent) {
        townPopUp.setVisible(true);
    }

    public void closeTownPopUp(MouseEvent mouseEvent) {
        townPopUp.setVisible(false);
    }

    public void showCavesPopUp(MouseEvent mouseEvent) {
        cavesPopUp.setVisible(true);
    }

    public void closeCavesPopUp(MouseEvent mouseEvent) {
        cavesPopUp.setVisible(false);
    }

    public void showMountainsPopUp(MouseEvent mouseEvent) {
        mountainsPopUp.setVisible(true);
    }

    public void closeMountainsPopUp(MouseEvent mouseEvent) {
        mountainsPopUp.setVisible(false);
    }

    public void refreshAllPokemon(MouseEvent mouseEvent) {
        /**
         * shows allpokemons on pokemons tab in pokedex
         */
        int position=0;
        String pokemonSelection;
        pokemonSelection = allPokemonsList.getSelectionModel().getSelectedItem();
        Image newPkmImage = new Image("/Images/pokemons/"+pokemonSelection+"/"+pokemonSelection+".png");
        for (int j=0; j<motor.getBeltPokemon().size(); j++){
            if (pokemonSelection.equals(motor.getBeltPokemon().get(j).getNombre())){
                pokemonImageView.setImage(newPkmImage);
                pokemonImageView.setOpacity(1);
                for (int p=0; p<motor.getAllPokemon().size(); p++){
                    if (pokemonSelection.equals(motor.getAllPokemon().get(p).getNombre())){
                        position = p+1;
                        break;
                    }
                }
                pokemonNameLabel.setText("#"+position+" "+pokemonSelection);
                break;
            } else {
                pokemonImageView.setImage(newPkmImage);
                pokemonNameLabel.setText("????????");
                pokemonImageView.setOpacity(0.3);
            }
        }

    }
}
