package ViewControllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

public class wildFight {
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
    private Label healsQuantity, pokeballsQuantity, caughtPokemonName, exitCaughtLabel;
    @FXML
    private Label hability1Button, hability2Button, hability3Button, hability4Button;
    @FXML
    private ImageView enemyPokemonImg, playerPokemonImg, habilityLabel1, habilityLabel2, habilityLabel3, habilityLabel4, caughtPokemonImg, youLostSign, youWonSign;
    @FXML
    private Button exitFight;
    @FXML
    private ImageView beltPokemon1, beltPokemon2, beltPokemon3, beltPokemon4, beltPokemon5, beltPokemon6, pokeballLoading, catchPokemonButton;
    @FXML
    private ImageView newPokemonImg, fightBackground;
    @FXML
    private Group choosePokemonScreen, mainBattleScreenGroup, habilityGroup, bagGroup, caughtGroup, pickNewPokemonGroup, catchPokemonGroup;

    private ArrayList<habilidad> pokemonHability = new ArrayList<habilidad>();
    private ArrayList<habilidad> enemyHability = new ArrayList<habilidad>();
    private pokemon enemy = new pokemon();
    private pokemon selectedPokemon = new pokemon();
    private double enemyHP;
    private double enemyBaseHP;
    private double playerHP;
    private double playerBaseHP;
    private int arrayPos;
    private int healsQty;
    private int pokeballsQty;


    public void initialize(){
        enemyHPprogressBar.setStyle("-fx-accent: green");
        playerHPprogressBar.setStyle("-fx-accent: green");
        expBarProgressBar.setStyle("-fx-accent: yellow");

    }
    public void receiveMotorInstance(Motor m){
        this.motor = m;

        Image BackGround = new Image("Images/fightsBG/"+motor.getBackground()+".png");
        fightBackground.setImage(BackGround);

        healsQty = motor.getUsrHeals();
        pokeballsQty = motor.getUsrPokeballs();
        /**
         * searches and sets a random pokemon from AllPokemon database with specific attributes according to the area
         */
        for (int i =0; i<151; i++){
            enemy = motor.randomPokemon();
            enemyHP = enemy.getVida();
            enemyBaseHP = enemy.getVida();
            if (enemy.getTipo().equals(motor.getType1()) || enemy.getTipo().equals(motor.getType2()) || enemy.getTipo().equals(motor.getType3())){
                enemyPokemonName.setText(enemy.getNombre());
                enemyPokemonLevel.setText("Lv. "+enemy.getNivel());
                enemyHPprogressBar.setProgress(enemyHP/enemyBaseHP);
                Image enemyPokemon = new Image("/Images/pokemons/"+enemy.getNombre()+"/"+enemy.getNombre()+".png");
                enemyPokemonImg.setImage(enemyPokemon);
                break;
            }
        }
        enemyHability.add(enemy.getHabilidad1());
        enemyHability.add(enemy.getHabilidad2());
        enemyHability.add(enemy.getHabilidad3());
        enemyHability.add(enemy.getHabilidad4());

        /**
         * sets each belt pokemon to a selection area on the pokemon selection for battles scene
         */
        int bound=0;
        for (int s=0; s<motor.getBeltPokemon().size(); s++){
            if (motor.getBeltPokemon().get(s)!=null){
                bound++;
            }
            else if (s==6){
                break;
            }
        }
        for (int p=0; p<bound; p++){
            if (p==0){
                Image belt1 = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(0).getNombre()+"/"+motor.getBeltPokemon().get(0).getNombre()+".png");
                beltPokemon1.setVisible(true);
                beltName1.setText(motor.getBeltPokemon().get(0).getNombre());
                pokeSelectedInfo1.setText("Lv: "+motor.getBeltPokemon().get(0).getNivel()+"\nHP: "+motor.getBeltPokemon().get(0).getVida()+"\nType: "+motor.getBeltPokemon().get(0).getTipo());
                beltPokemon1.setImage(belt1);

            }
            else if (p==1){
                Image belt2 = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(1).getNombre()+"/"+motor.getBeltPokemon().get(1).getNombre()+".png");
                beltPokemon2.setVisible(true);
                beltName2.setText(motor.getBeltPokemon().get(1).getNombre());
                pokeSelectedInfo2.setText("Lv: "+motor.getBeltPokemon().get(1).getNivel()+"\nHP: "+motor.getBeltPokemon().get(1).getVida()+"\nType: "+motor.getBeltPokemon().get(1).getTipo());
                beltPokemon2.setImage(belt2);

            }
            else if (p==2){
                Image belt3 = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(2).getNombre()+"/"+motor.getBeltPokemon().get(2).getNombre()+".png");
                beltPokemon3.setVisible(true);
                beltName3.setText(motor.getBeltPokemon().get(2).getNombre());
                pokeSelectedInfo3.setText("Lv: "+motor.getBeltPokemon().get(2).getNivel()+"\nHP: "+motor.getBeltPokemon().get(2).getVida()+"\nType: "+motor.getBeltPokemon().get(2).getTipo());
                beltPokemon3.setImage(belt3);

            }
            else if (p==3){
                Image belt4 = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(3).getNombre()+"/"+motor.getBeltPokemon().get(3).getNombre()+".png");
                beltPokemon4.setVisible(true);
                beltName4.setText(motor.getBeltPokemon().get(3).getNombre());
                pokeSelectedInfo4.setText("Lv: "+motor.getBeltPokemon().get(3).getNivel()+"\nHP: "+motor.getBeltPokemon().get(3).getVida()+"\nType: "+motor.getBeltPokemon().get(3).getTipo());
                beltPokemon4.setImage(belt4);

            }
            else if (p==4){
                Image belt5 = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(4).getNombre()+"/"+motor.getBeltPokemon().get(4).getNombre()+".png");
                beltPokemon5.setVisible(true);
                beltName5.setText(motor.getBeltPokemon().get(4).getNombre());
                pokeSelectedInfo5.setText("Lv: "+motor.getBeltPokemon().get(4).getNivel()+"\nHP: "+motor.getBeltPokemon().get(4).getVida()+"\nType: "+motor.getBeltPokemon().get(4).getTipo());
                beltPokemon5.setImage(belt5);

            }
            else if (p==5){
                Image belt6 = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(5).getNombre()+"/"+motor.getBeltPokemon().get(5).getNombre()+".png");
                beltPokemon6.setVisible(true);
                beltName6.setText(motor.getBeltPokemon().get(5).getNombre());
                pokeSelectedInfo6.setText("Lv: "+motor.getBeltPokemon().get(5).getNivel()+"\nHP: "+motor.getBeltPokemon().get(5).getVida()+"\nType: "+motor.getBeltPokemon().get(5).getTipo());
                beltPokemon6.setImage(belt6);

            }
        }
    }
    /**
     * buttons for belt pokemon selection
     * @param mouseEvent
     */
    public void beltPokemon1selected(MouseEvent mouseEvent) {
        choosePokemonScreen.setVisible(false);
        Image belt1 = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(0).getNombre()+"/"+motor.getBeltPokemon().get(0).getNombre()+"_back.png");
        playerPokemonName.setText(motor.getBeltPokemon().get(0).getNombre());
        playerPokemonLevel.setText(String.valueOf("Lv. "+motor.getBeltPokemon().get(0).getNivel()));
        selectedPokemon = motor.getBeltPokemon().get(0);
        playerPokemonImg.setImage(belt1);
        playerHP = motor.getPokemonByName(selectedPokemon.getNombre()).getVida();
        playerBaseHP = motor.getPokemonByName(selectedPokemon.getNombre()).getVida();
        arrayPos = 0;
        expBarProgressBar.setProgress(selectedPokemon.getExp()/3);
        playerHPprogressBar.setProgress(selectedPokemon.getVida()/playerBaseHP);
        addHabilitites();

    }
    public void beltPokemon2selected(MouseEvent mouseEvent) {
        choosePokemonScreen.setVisible(false);
        Image belt2 = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(1).getNombre()+"/"+motor.getBeltPokemon().get(1).getNombre()+"_back.png");
        playerPokemonName.setText(motor.getBeltPokemon().get(1).getNombre());
        playerPokemonLevel.setText(String.valueOf("Lv. "+motor.getBeltPokemon().get(1).getNivel()));
        selectedPokemon = motor.getBeltPokemon().get(1);
        playerPokemonImg.setImage(belt2);
        playerHP = motor.getPokemonByName(selectedPokemon.getNombre()).getVida();
        playerBaseHP = motor.getPokemonByName(selectedPokemon.getNombre()).getVida();
        arrayPos = 1;
        expBarProgressBar.setProgress(selectedPokemon.getExp()/3);
        playerHPprogressBar.setProgress(motor.getBeltPokemon().get(1).getVida()/playerBaseHP);
        System.out.println(motor.getBeltPokemon().get(1).getVida());
        System.out.println(playerBaseHP);
        System.out.println(motor.getPokemonByName(selectedPokemon.getNombre()).getVida());
        addHabilitites();

    }
    public void beltPokemon3selected(MouseEvent mouseEvent) {
        choosePokemonScreen.setVisible(false);
        Image belt3 = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(2).getNombre()+"/"+motor.getBeltPokemon().get(2).getNombre()+"_back.png");
        playerPokemonName.setText(motor.getBeltPokemon().get(2).getNombre());
        playerPokemonLevel.setText(String.valueOf("Lv. "+motor.getBeltPokemon().get(2).getNivel()));
        selectedPokemon = motor.getBeltPokemon().get(2);
        playerPokemonImg.setImage(belt3);
        playerHP = motor.getPokemonByName(selectedPokemon.getNombre()).getVida();
        playerBaseHP = motor.getPokemonByName(selectedPokemon.getNombre()).getVida();
        arrayPos = 2;
        expBarProgressBar.setProgress(selectedPokemon.getExp()/3);
        playerHPprogressBar.setProgress(motor.getBeltPokemon().get(2).getVida()/playerBaseHP);
        addHabilitites();

    }
    public void beltPokemon4selected(MouseEvent mouseEvent) {
        choosePokemonScreen.setVisible(false);
        Image belt4 = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(3).getNombre()+"/"+motor.getBeltPokemon().get(3).getNombre()+"_back.png");
        playerPokemonName.setText(motor.getBeltPokemon().get(3).getNombre());
        playerPokemonLevel.setText(String.valueOf("Lv. "+motor.getBeltPokemon().get(3).getNivel()));
        selectedPokemon = motor.getBeltPokemon().get(3);
        playerPokemonImg.setImage(belt4);
        playerHP = motor.getPokemonByName(selectedPokemon.getNombre()).getVida();
        playerBaseHP = motor.getPokemonByName(selectedPokemon.getNombre()).getVida();
        arrayPos = 3;
        expBarProgressBar.setProgress(selectedPokemon.getExp()/3);
        playerHPprogressBar.setProgress(motor.getBeltPokemon().get(3).getVida()/playerBaseHP);
        addHabilitites();

    }
    public void beltPokemon5selected(MouseEvent mouseEvent) {
        choosePokemonScreen.setVisible(false);
        Image belt5 = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(4).getNombre()+"/"+motor.getBeltPokemon().get(4).getNombre()+"_back.png");
        playerPokemonName.setText(motor.getBeltPokemon().get(4).getNombre());
        playerPokemonLevel.setText(String.valueOf("Lv. "+motor.getBeltPokemon().get(4).getNivel()));
        selectedPokemon = motor.getBeltPokemon().get(4);
        playerPokemonImg.setImage(belt5);
        playerHP = motor.getPokemonByName(selectedPokemon.getNombre()).getVida();
        playerBaseHP = motor.getPokemonByName(selectedPokemon.getNombre()).getVida();
        arrayPos = 4;
        expBarProgressBar.setProgress(selectedPokemon.getExp()/3);
        playerHPprogressBar.setProgress(motor.getBeltPokemon().get(4).getVida()/playerBaseHP);
        addHabilitites();

    }
    public void beltPokemon6selected(MouseEvent mouseEvent) {
        choosePokemonScreen.setVisible(false);
        Image belt6 = new Image("/Images/pokemons/"+motor.getBeltPokemon().get(5).getNombre()+"/"+motor.getBeltPokemon().get(5).getNombre()+"_back.png");
        playerPokemonName.setText(motor.getBeltPokemon().get(5).getNombre());
        playerPokemonLevel.setText(String.valueOf("Lv. "+motor.getBeltPokemon().get(5).getNivel()));
        selectedPokemon = motor.getBeltPokemon().get(5);
        playerPokemonImg.setImage(belt6);
        playerHP = motor.getPokemonByName(selectedPokemon.getNombre()).getVida();
        playerBaseHP = motor.getPokemonByName(selectedPokemon.getNombre()).getVida();
        arrayPos = 5;
        expBarProgressBar.setProgress(selectedPokemon.getExp()/3);
        playerHPprogressBar.setProgress(motor.getBeltPokemon().get(5).getVida()/playerBaseHP);
        addHabilitites();

    }
    public void addHabilitites(){
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
         * shows current pokemon habilities (in battle)
         */
        catchPokemonGroup.setVisible(false);
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
        catchPokemonGroup.setVisible(false);
        bagGroup.setVisible(true);
        healsQuantity.setText("x"+String.valueOf(healsQty));
    }

    public void run(MouseEvent mouseEvent) {
        motor.closeWildFight(mouseEvent);
    }
    /**
     * pokemon hability buttons
     * @param mouseEvent
     */
    public void hability1(MouseEvent mouseEvent) {
        habilidad hab1 = pokemonHability.get(0);
        enemyHP = (enemyHP-(hab1.getDamage()*selectedPokemon.getNivel()/5.0));
        enemyHPprogressBar.setProgress(enemyHP/enemyBaseHP);
        if (enemyHP<=0){
            fightButton.setDisable(true);
            bagButton.setDisable(true);
            catchButton.setDisable(true);
            youWonSign.setVisible(true);
        }
        Random random = new Random();
        int bound=0;
        for (int i=0; i<enemyHability.size(); i++){
            if (enemyHability.get(i)!=null){
                bound++;
            }
        }
        int rand = random.nextInt(bound);
        playerHP = (playerHP-(enemyHability.get(rand).getDamage()*enemy.getNivel()/5.0));
        playerHPprogressBar.setProgress(playerHP/playerBaseHP);
        fightTextLabel.setText(enemy.getNombre()+" used "+enemyHability.get(rand).getNombre());
        habilityGroup.setVisible(false);
        if(playerHP<=0){
            fightButton.setDisable(true);
            bagButton.setDisable(true);
            catchButton.setDisable(true);
            youLostSign.setVisible(true);
        }
    }
    public void hability2(MouseEvent mouseEvent) {
        habilidad hab2 = pokemonHability.get(1);
        enemyHP = (enemyHP-(hab2.getDamage()*selectedPokemon.getNivel()/5.0));
        enemyHPprogressBar.setProgress(enemyHP/enemyBaseHP);
        if (enemyHP<=0){
            fightButton.setDisable(true);
            bagButton.setDisable(true);
            catchButton.setDisable(true);
            youWonSign.setVisible(true);
        }
        Random random = new Random();
        int bound=0;
        for (int i=0; i<enemyHability.size(); i++){
            if (enemyHability.get(i)!=null){
                bound++;
            }
        }
        int rand = random.nextInt(bound);
        playerHP = (playerHP-(enemyHability.get(rand).getDamage()*enemy.getNivel()/5.0));
        playerHPprogressBar.setProgress(playerHP/playerBaseHP);
        fightTextLabel.setText(enemy.getNombre()+" used "+enemyHability.get(rand).getNombre());
        habilityGroup.setVisible(false);
        if(playerHP<=0){
            fightButton.setDisable(true);
            bagButton.setDisable(true);
            catchButton.setDisable(true);
            youLostSign.setVisible(true);
        }

    }
    public void hability3(MouseEvent mouseEvent) {
        habilidad hab3 = pokemonHability.get(2);
        enemyHP = (enemyHP-(hab3.getDamage()*selectedPokemon.getNivel()/5.0));
        enemyHPprogressBar.setProgress(enemyHP/enemyBaseHP);
        if (enemyHP<=0){
            fightButton.setDisable(true);
            bagButton.setDisable(true);
            catchButton.setDisable(true);
            youWonSign.setVisible(true);
        }

        Random random = new Random();
        int bound=0;
        for (int i=0; i<enemyHability.size(); i++){
            if (enemyHability.get(i)!=null){
                bound++;
            }
        }
        int rand = random.nextInt(bound);
        playerHP = (playerHP-(enemyHability.get(rand).getDamage()*enemy.getNivel()/5.0));
        playerHPprogressBar.setProgress(playerHP/playerBaseHP);
        fightTextLabel.setText(enemy.getNombre()+" used "+enemyHability.get(rand).getNombre());
        habilityGroup.setVisible(false);
        if(playerHP<=0){
            fightButton.setDisable(true);
            bagButton.setDisable(true);
            catchButton.setDisable(true);
            youLostSign.setVisible(true);
        }
    }
    public void hability4(MouseEvent mouseEvent) {
        habilidad hab4 = pokemonHability.get(3);
        enemyHP = (enemyHP-(hab4.getDamage()*selectedPokemon.getNivel()/5.0));
        enemyHPprogressBar.setProgress(enemyHP/enemyBaseHP);
        if (enemyHP<=0){
            fightButton.setDisable(true);
            bagButton.setDisable(true);
            catchButton.setDisable(true);
            youWonSign.setVisible(true);
        }

        Random random = new Random();
        int bound=0;
        for (int i=0; i<enemyHability.size(); i++){
            if (enemyHability.get(i)!=null){
                bound++;
            }
        }
        int rand = random.nextInt(bound);
        playerHP = (playerHP-(enemyHability.get(rand).getDamage()*enemy.getNivel()/5.0));
        playerHPprogressBar.setProgress(playerHP/playerBaseHP);
        fightTextLabel.setText(enemy.getNombre()+" used "+enemyHability.get(rand).getNombre());
        habilityGroup.setVisible(false);
        if(playerHP<=0){
            fightButton.setDisable(true);
            bagButton.setDisable(true);
            catchButton.setDisable(true);
            youLostSign.setVisible(true);
        }
    }
    public void healSelectedPokemon(MouseEvent mouseEvent) {
        if (healsQty>0){
            if ((playerHP + (playerBaseHP / 6))<playerBaseHP) {
                playerHP = (playerHP + (playerBaseHP / 6));
                healsQty = healsQty - 1;
                motor.setUsrHeals(healsQty);
                healsQuantity.setText("x" + String.valueOf(healsQty));
                playerHPprogressBar.setProgress(playerHP / playerBaseHP);
            } else {
                playerHP = playerBaseHP;
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
    public void catchGroup(MouseEvent event) {
        catchPokemonGroup.setVisible(true);
        bagGroup.setVisible(false);
        fightTextLabel.setText("");
        pokeballsQuantity.setText("x"+String.valueOf(pokeballsQty));
        habilityGroup.setVisible(false);
    }
    public void catchPokemon(MouseEvent mouseEvent) {
        if (pokeballsQty ==0){
            catchPokemonGroup.setVisible(false);
            fightTextLabel.setText("You dont have any pokeballs");
        }
        else {
            if (enemyHP<40 && pokeballsQty>0){
                Random random = new Random();
                int randCatch = random.nextInt(2);

                //disables funcionalities to not brake the catch process
                catchPokemonButton.setDisable(true);
                fightButton.setDisable(true);
                bagButton.setDisable(true);
                runButton.setDisable(true);


                enemyPokemonImg.setVisible(false);
                pokeballLoading.setVisible(true);
                motor.setUsrPokeballs(pokeballsQty-1);

                if (randCatch == 1){
                    boolean repeated = false;
                    pokeballsQuantity.setText("x"+String.valueOf(motor.getUsrPokeballs()));
                    String enemyName = enemy.getNombre();
                    caughtPokemonName.setText(enemyName);
                    motor.setCoins(motor.getCoins()+10);
                    motor.getBeltPokemon().get(arrayPos).setExp(selectedPokemon.getExp()+0.5);
                    motor.getBeltPokemon().get(arrayPos).setNivel(selectedPokemon.getNivel()+1);
                    if ((motor.getBeltPokemon().get(arrayPos).getExp() == 3.0 || motor.getBeltPokemon().get(arrayPos).getExp() == 9.0) && motor.getBeltPokemon().get(arrayPos).getEvolucion() != null){
                        pokemon evolucionado = motor.getBeltPokemon().get(arrayPos).getEvolucion();
                        motor.getBeltPokemon().set(arrayPos, evolucionado);
                    }
                    Image enemyPokemon = new Image("/Images/pokemons/"+enemyName+"/"+enemyName+".png");
                    caughtPokemonImg.setImage(enemyPokemon);
                    for (int i=0; i<motor.getBeltPokemon().size(); i++){
                        if (enemy.getNombre().equals(motor.getBeltPokemon().get(i).getNombre())){
                            repeated = true;
                            motor.setCoins(motor.getCoins()+20);
                            break;
                        }
                    }
                    if (repeated==false) {
                        motor.addBeltPokemon(motor.getPokemonByName(enemyName));
                    }


                    Timer timer = new Timer();
                    TimerTask tarea = new TimerTask() {
                        @Override
                        public void run() {
                            caughtGroup.setVisible(true);
                            exitCaughtLabel.setVisible(true);
                            timer.cancel();
                        }
                    };
                    timer.schedule(tarea, 3000);
                }
                else {
                    int bound = 0;
                    for (int i = 0; i<enemyHability.size(); i++){
                        if (enemyHability.get(i) != null){
                            bound++;
                        }
                    }
                    Random random2 = new Random();
                    int rand = random2.nextInt(bound);
                    //activates funcionalities again


                    fightTextLabel.setVisible(false);
                    habilityGroup.setVisible(false);
                    pokeballLoading.setVisible(true);
                    pokeballsQuantity.setText("x"+String.valueOf(motor.getUsrPokeballs()));
                    Image enemyPokemon = new Image("/Images/pokemons/"+enemy.getNombre()+"/"+enemy.getNombre()+".png");
                    enemyPokemonImg.setImage(enemyPokemon);
                    fightTextLabel.setText(enemy.getNombre() + " escaped and attacked you!");
                    Timer timer = new Timer();
                    TimerTask tarea = new TimerTask() {
                        @Override
                        public void run() {
                            catchPokemonButton.setDisable(false);
                            fightButton.setDisable(false);
                            bagButton.setDisable(false);

                            motor.setUsrPokeballs(pokeballsQty+1);
                            runButton.setDisable(false);
                            catchPokemonGroup.setVisible(false);
                            pokeballLoading.setVisible(false);
                            fightTextLabel.setVisible(true);
                            enemyPokemonImg.setVisible(true);
                            playerHP = (playerHP-(enemyHability.get(rand).getDamage()*enemy.getNivel()/5.0));
                            playerHPprogressBar.setProgress(playerHP/playerBaseHP);
                            timer.cancel();
                        }
                    };
                    timer.schedule(tarea, 3000);
                }
            }
            else {
                catchPokemonGroup.setVisible(false);
                fightTextLabel.setText("Not yet!");
            }
        }
    }
    public void leaveFightButton(MouseEvent mouseEvent) {
        motor.closeWildFight(mouseEvent);
    }
    public void youWonButton(MouseEvent mouseEvent) {
        motor.setCoins(motor.getCoins()+10);
        motor.getBeltPokemon().get(arrayPos).setExp(selectedPokemon.getExp()+3.0);
        motor.getBeltPokemon().get(arrayPos).setNivel(selectedPokemon.getNivel()+1);
        motor.closeWildFight(mouseEvent);
    }
}