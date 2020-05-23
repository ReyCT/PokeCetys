package ViewControllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Gym {
    @FXML
    private Group trainerDialogueGroup;
    private Motor motor;
    @FXML
    private ProgressBar enemyHPprogressBar, playerHPprogressBar, expBarProgressBar;
    @FXML
    private Label enemyPokemonName, playerPokemonName, enemyPokemonLevel, playerPokemonLevel, fightTextLabel, newPokemonName, newPokemonInfo;
    @FXML
    private Label beltName1, beltName2, beltName3, beltName4, beltName5, beltName6;
    @FXML
    private Label fightButton, bagButton, catchButton, runButton;
    @FXML
    private Label pokeSelectedInfo1, pokeSelectedInfo2, pokeSelectedInfo3, pokeSelectedInfo4, pokeSelectedInfo5, pokeSelectedInfo6;
    @FXML
    private Label healsQuantity, pokeballsQuantity, caughtPokemonName, exitCaughtLabel, trainerGymChatLabel;
    @FXML
    private Label hability1Button, hability2Button, hability3Button, hability4Button;
    @FXML
    private ImageView enemyPokemonImg, playerPokemonImg, trainerImg, habilityLabel1, habilityLabel2, habilityLabel3, habilityLabel4, earnedMedal, youLostSign, youWonSign;
    @FXML
    private Button exitFight;
    @FXML
    private ImageView beltPokemon1, beltPokemon2, beltPokemon3, beltPokemon4, beltPokemon5, beltPokemon6, pokeballLoading, catchPokemonButton;
    @FXML
    private ImageView newPokemonImg, gymFightBG, startGymFight, leaveGym;
    @FXML
    private Group choosePokemonScreen, mainBattleScreenGroup, habilityGroup, bagGroup, caughtGroup, pickNewPokemonGroup, catchPokemonGroup;

    private ObservableList<String> pokemonList = FXCollections.observableArrayList();
    private ArrayList<habilidad> pokemonHability = new ArrayList<habilidad>();
    private ArrayList<habilidad> enemyHability = new ArrayList<habilidad>();
    private pokemon enemy = new pokemon();
    private pokemon selectedPokemon = new pokemon();
    private double enemyHP;
    private double enemyBaseHP;
    private double playerHP;
    private double playerBaseHP;
    private int healsQty;
    private int currentEnemy=1;
    private int arrayPos=0;


    public void initialize(){
        enemyHPprogressBar.setStyle("-fx-accent: green");
        playerHPprogressBar.setStyle("-fx-accent: green");
        expBarProgressBar.setStyle("-fx-accent: yellow");
    }
    public void receiveMotorInstance(Motor m){
        this.motor = m;

        //sets all the gym interface (trainer, dialogue, pokemons)
        Image BackGround = new Image("Images/gymsBG/"+motor.getGymBG()+".png");
        gymFightBG.setImage(BackGround);
        Image Trainer = new Image("Images/gymsBG/"+motor.getTrainer()+".png");
        trainerImg.setImage(Trainer);
        if (motor.getBeltPokemon().size()<3){
            trainerGymChatLabel.setText("You need at least 3 pokemons to fight");
            leaveGym.setVisible(true);
        } else {
            trainerGymChatLabel.setText(motor.getDialogue());
        }
        for (int i=0; i<motor.getMedalsList().size(); i++){
            if (motor.getMedal().equals(motor.getMedalsList().get(i))){
                leaveGym.setVisible(true);
                trainerGymChatLabel.setText("You already have the medal");
            }
        }

        healsQty = motor.getUsrHeals();
        /**
         * searches and sets a random pokemon from AllPokemon database with specific attributes according to the area
         */

        enemy = motor.getEnemy1();
        setEnemyPokemon();

        setPlayerPokemon();

    }
    public void setPlayerPokemon(){
        /**
         * method to set pokemon whenever the fight starts or a new pokemon starts to fight
         */
        Image currentPoke = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(arrayPos).getNombre()+"/"+motor.getBeltPokemon().get(arrayPos).getNombre()+"_back.png");
        playerPokemonName.setText(motor.getBeltPokemon().get(arrayPos).getNombre());
        playerPokemonLevel.setText(String.valueOf("Lv. "+motor.getBeltPokemon().get(arrayPos).getNivel()));
        selectedPokemon = motor.getBeltPokemon().get(arrayPos);
        playerPokemonImg.setImage(currentPoke);
        playerHP = motor.getPokemonByName(selectedPokemon.getNombre()).getVida();
        playerBaseHP = motor.getPokemonByName(selectedPokemon.getNombre()).getVida();
        expBarProgressBar.setProgress(selectedPokemon.getExp()/3);
        playerHPprogressBar.setProgress(selectedPokemon.getVida()/playerBaseHP);
        addHabilitites();
    }
    public void setEnemyPokemon(){
        /**
         * method to set enemy pokemon whenever a new fight starts (or when it dies on batlle)
         */
        enemyHP = enemy.getVida();
        enemyBaseHP = enemy.getVida();
        enemy.setNivel(enemy.getNivel()+motor.getGymLevel());
        enemyPokemonName.setText(enemy.getNombre());
        enemyPokemonLevel.setText("Lv. "+enemy.getNivel());
        enemyHPprogressBar.setProgress(enemyHP/enemyBaseHP);
        Image enemyPokemon = new Image("/Images/pokemons/"+enemy.getNombre()+"/"+enemy.getNombre()+".png");
        enemyPokemonImg.setImage(enemyPokemon);
        enemyHability.add(enemy.getHabilidad1());
        enemyHability.add(enemy.getHabilidad2());
        enemyHability.add(enemy.getHabilidad3());
        enemyHability.add(enemy.getHabilidad4());
    }
    public void addHabilitites(){
        /**
         * adds the most recent pokemon habilities
         */
        pokemonHability.clear();
        pokemonHability.add(selectedPokemon.getHabilidad1());
        pokemonHability.add(selectedPokemon.getHabilidad2());
        pokemonHability.add(selectedPokemon.getHabilidad3());
        pokemonHability.add(selectedPokemon.getHabilidad4());
    }
    /**
     * in game fight options
     * @param mouseEvent
     */
    public void showHability(MouseEvent mouseEvent) {
        /**
         * shows all the habilitites that the current pokemon has
         */
        bagGroup.setVisible(false);
        fightTextLabel.setText("");
        habilityGroup.setVisible(true);
        for (int i=0; i<pokemonHability.size(); i++){
            if (i==0 && pokemonHability.get(0) != null){
                habilityLabel1.setVisible(true);
                hability1Button.setVisible(true);
                hability1Button.setText(pokemonHability.get(0).getNombre());
            }
            else if(i==1 && pokemonHability.get(1) != null){
                habilityLabel2.setVisible(true);
                hability2Button.setVisible(true);
                hability2Button.setText(pokemonHability.get(1).getNombre());
            }
            else if (i==2 && pokemonHability.get(2) != null){
                habilityLabel3.setVisible(true);
                hability3Button.setVisible(true);
                hability3Button.setText(pokemonHability.get(2).getNombre());
            }
            else if (i==3 && pokemonHability.get(3) != null){
                habilityLabel4.setVisible(true);
                hability4Button.setVisible(true);
                hability4Button.setText(pokemonHability.get(3).getNombre());
            }
        }
    }
    public void showBag(MouseEvent mouseEvent) {

        /**
         * shows healing option
         */
        fightTextLabel.setText("");
        habilityGroup.setVisible(false);
        bagGroup.setVisible(true);
        healsQuantity.setText("x"+String.valueOf(healsQty));
    }
    public void run(MouseEvent mouseEvent) {
        motor.closeGymFight(mouseEvent);
    }
    /**
     * pokemon hability buttons
     * @param mouseEvent
     */
    public void hability1(MouseEvent mouseEvent) {
        habilidad hab1 = pokemonHability.get(0);
        enemyHP = (enemyHP-(hab1.getDamage()*selectedPokemon.getNivel()/5.0));
        enemyHPprogressBar.setProgress(enemyHP/enemyBaseHP);
        if (enemyHP<=0){ //loop to make the pokemon death order work when fighting the trainer (who is next after each death)
            currentEnemy++;
            if (currentEnemy==2){
                habilityGroup.setVisible(false);
                fightTextLabel.setText("You knocked "+enemy+"\n"+motor.getTrainer()+": Go "+motor.getEnemy2().getNombre()+"!");
                enemy = motor.getEnemy2();
                setEnemyPokemon();
            }
            else if (currentEnemy==3){
                fightTextLabel.setText("You knocked "+enemy+"\n"+motor.getTrainer()+": Go "+motor.getEnemy3().getNombre()+"!");
                enemy = motor.getEnemy3();
                setEnemyPokemon();
            }
            else if (currentEnemy==4){
                motor.setCoins(motor.getCoins()+30);
                motor.getBeltPokemon().get(arrayPos).setExp(selectedPokemon.getExp()+1.5);
                motor.getBeltPokemon().get(arrayPos).setNivel(selectedPokemon.getNivel()+4);
                trainerDialogueGroup.setVisible(true);
                Image medal = new Image("/Images/gymsBG/"+motor.getMedal()+".png");
                earnedMedal.setImage(medal);
                motor.addMedalsList(motor.getMedal());
                trainerGymChatLabel.setText("well done... take my Medal");
                leaveGym.setVisible(true);
            }

        }
        Random random = new Random();
        int rand = random.nextInt(4); //randomizes the hability that the enemy will use
        playerHP = (playerHP-(enemyHability.get(rand).getDamage()*enemy.getNivel()/5.0)); //sets enemy life after the enemy move
        playerHPprogressBar.setProgress(playerHP/playerBaseHP);
        fightTextLabel.setText(enemy.getNombre()+" used "+enemyHability.get(rand).getNombre());
        habilityGroup.setVisible(false);
        if(playerHP<=0){ //sets next pokemon in line to fight
            arrayPos++;
            if (arrayPos==3){
                motor.setLosses(motor.getLosses()+1);
                trainerDialogueGroup.setVisible(true);
                trainerGymChatLabel.setText("Hahaha, you are not prepared yet! better luck next time");
                leaveGym.setVisible(true);
            }
            setPlayerPokemon();

        }
    }
    public void hability2(MouseEvent mouseEvent) {
        habilidad hab2 = pokemonHability.get(1);
        enemyHP = (enemyHP-(hab2.getDamage()*selectedPokemon.getNivel()/5.0));
        enemyHPprogressBar.setProgress(enemyHP/enemyBaseHP);
        if (enemyHP<=0){
            currentEnemy++;
            if (currentEnemy==2){
                habilityGroup.setVisible(false);
                fightTextLabel.setText("You knocked "+enemy+"\n"+motor.getTrainer()+": Go "+motor.getEnemy2().getNombre()+"!");
                enemy = motor.getEnemy2();
                setEnemyPokemon();
            }
            else if (currentEnemy==3){
                fightTextLabel.setText("You knocked "+enemy+"\n"+motor.getTrainer()+": Go "+motor.getEnemy3().getNombre()+"!");
                enemy = motor.getEnemy3();
                setEnemyPokemon();
            }
            else if (currentEnemy==4){
                trainerDialogueGroup.setVisible(true);
                motor.setCoins(motor.getCoins()+30);
                motor.getBeltPokemon().get(arrayPos).setExp(selectedPokemon.getExp()+1.5);
                motor.getBeltPokemon().get(arrayPos).setNivel(selectedPokemon.getNivel()+4);
                Image medal = new Image("/Images/gymsBG/"+motor.getMedal()+".png");
                earnedMedal.setImage(medal);
                motor.addMedalsList(motor.getMedal());
                trainerGymChatLabel.setText("well done... take my Medal");
                leaveGym.setVisible(true);
            }
        }
        Random random = new Random();
        int rand = random.nextInt(4);
        playerHP = (playerHP-(enemyHability.get(rand).getDamage()*enemy.getNivel()/5.0));
        playerHPprogressBar.setProgress(playerHP/playerBaseHP);
        fightTextLabel.setText(enemy.getNombre()+" used "+enemyHability.get(rand).getNombre());
        habilityGroup.setVisible(false);
        if(playerHP<=0){
            arrayPos++;
            if (arrayPos==3){
                motor.setLosses(motor.getLosses()+1);
                trainerDialogueGroup.setVisible(true);
                trainerGymChatLabel.setText("Hahaha, you are not prepared yet! better luck next time");
                leaveGym.setVisible(true);
            }
            setPlayerPokemon();
        }
    }
    public void hability3(MouseEvent mouseEvent) {
        habilidad hab3 = pokemonHability.get(2);
        enemyHP = (enemyHP-(hab3.getDamage()*selectedPokemon.getNivel()/5.0));
        enemyHPprogressBar.setProgress(enemyHP/enemyBaseHP);
        if (enemyHP<=0){
            currentEnemy++;
            if (currentEnemy==2){
                habilityGroup.setVisible(false);
                fightTextLabel.setText("You knocked "+enemy+"\n"+motor.getTrainer()+": Go "+motor.getEnemy2().getNombre()+"!");
                enemy = motor.getEnemy2();
                setEnemyPokemon();
            }
            else if (currentEnemy==3){
                fightTextLabel.setText("You knocked "+enemy+"\n"+motor.getTrainer()+": Go "+motor.getEnemy3().getNombre()+"!");
                enemy = motor.getEnemy3();
                setEnemyPokemon();
            }
            else if (currentEnemy==4){
                motor.setCoins(motor.getCoins()+30);
                motor.getBeltPokemon().get(arrayPos).setExp(selectedPokemon.getExp()+1.5);
                motor.getBeltPokemon().get(arrayPos).setNivel(selectedPokemon.getNivel()+4);
                trainerDialogueGroup.setVisible(true);
                Image medal = new Image("/Images/gymsBG/"+motor.getMedal()+".png");
                earnedMedal.setImage(medal);
                motor.addMedalsList(motor.getMedal());
                trainerGymChatLabel.setText("well done... take my Medal");
                leaveGym.setVisible(true);
            }
        }

        Random random = new Random();
        int rand = random.nextInt(4);
        playerHP = (playerHP-(enemyHability.get(rand).getDamage()*enemy.getNivel()/5.0));
        playerHPprogressBar.setProgress(playerHP/playerBaseHP);
        fightTextLabel.setText(enemy.getNombre()+" used "+enemyHability.get(rand).getNombre());
        habilityGroup.setVisible(false);
        if(playerHP<=0){
            arrayPos++;
            if (arrayPos==3){
                motor.setLosses(motor.getLosses()+1);
                trainerDialogueGroup.setVisible(true);
                trainerGymChatLabel.setText("Hahaha, you are not prepared yet! better luck next time");
                leaveGym.setVisible(true);
            }
            setPlayerPokemon();
        }
    }
    public void hability4(MouseEvent mouseEvent) {
        habilidad hab4 = pokemonHability.get(3);
        enemyHP = (enemyHP-(hab4.getDamage()*selectedPokemon.getNivel()/5.0));
        enemyHPprogressBar.setProgress(enemyHP/enemyBaseHP);
        if (enemyHP<=0){
            currentEnemy++;
            if (currentEnemy==2){
                habilityGroup.setVisible(false);
                fightTextLabel.setText("You knocked "+enemy+"\n"+motor.getTrainer()+": Go "+motor.getEnemy2().getNombre()+"!");
                enemy = motor.getEnemy2();
                setEnemyPokemon();
            }
            else if (currentEnemy==3){
                fightTextLabel.setText("You knocked "+enemy+"\n"+motor.getTrainer()+": Go "+motor.getEnemy3().getNombre()+"!");
                enemy = motor.getEnemy3();
                setEnemyPokemon();
            }
            else if (currentEnemy==4){
                motor.setCoins(motor.getCoins()+30);
                motor.getBeltPokemon().get(arrayPos).setExp(selectedPokemon.getExp()+1.5);
                motor.getBeltPokemon().get(arrayPos).setNivel(selectedPokemon.getNivel()+4);
                trainerDialogueGroup.setVisible(true);
                Image medal = new Image("/Images/gymsBG/"+motor.getMedal()+".png");
                earnedMedal.setImage(medal);
                motor.addMedalsList(motor.getMedal());
                trainerGymChatLabel.setText("well done... take my Medal");
                leaveGym.setVisible(true);
            }
        }

        Random random = new Random();
        int rand = random.nextInt(4);
        playerHP = (playerHP-(enemyHability.get(rand).getDamage()*enemy.getNivel()/5.0));
        playerHPprogressBar.setProgress(playerHP/playerBaseHP);
        fightTextLabel.setText(enemy.getNombre()+" used "+enemyHability.get(rand).getNombre());
        habilityGroup.setVisible(false);
        if(playerHP<=0){
            arrayPos++;
            if (arrayPos==3){
                motor.setLosses(motor.getLosses()+1);
                trainerDialogueGroup.setVisible(true);
                trainerGymChatLabel.setText("Hahaha, you are not prepared yet! better luck next time");
                leaveGym.setVisible(true);
            }
            setPlayerPokemon();
        }
    }
    public void healSelectedPokemon(MouseEvent mouseEvent) {
        /**
         * heals current pokemon
         */
        if (healsQty>0){//if user has any heals to use
            if ((playerHP + (playerBaseHP / 6))<playerBaseHP) { //if player life is below 100%
                playerHP = (playerHP + (playerBaseHP / 6));
                healsQty = healsQty - 1;
                motor.setUsrHeals(healsQty);
                healsQuantity.setText("x" + String.valueOf(healsQty));
                playerHPprogressBar.setProgress(playerHP / playerBaseHP);
            } else {
                playerHP = playerBaseHP; //if healing the player life passes the 100% of its life, the life is set to 100 to avoid overpassing it
                motor.setUsrHeals(healsQty);
                healsQuantity.setText("x" + String.valueOf(healsQty));
                playerHPprogressBar.setProgress(playerHP / playerBaseHP);
            }
            System.out.println(playerHP);
        }
        else {
            bagGroup.setVisible(false);
            fightTextLabel.setText("You dont have any heals");
        }
    }
    public void leaveFightButton(MouseEvent mouseEvent) { //leaves fight
        motor.closeGymFight(mouseEvent);
    }
    public void youWonButton(MouseEvent mouseEvent) {
        motor.setCoins(motor.getCoins()+10);
        motor.getBeltPokemon().get(arrayPos).setExp(selectedPokemon.getExp()+3.0);
        motor.getBeltPokemon().get(arrayPos).setNivel(selectedPokemon.getNivel()+1);
        motor.closeWildFight(mouseEvent);
    }
    public void startGymFight(MouseEvent mouseEvent) {
        trainerDialogueGroup.setVisible(false);
    }
}
