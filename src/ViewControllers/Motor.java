package ViewControllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.Window;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Motor{

    private String userName;
    private String gender;
    private String starterPokemon;
    private String areaBG;
    private String type1;
    private String type2;
    private String type3;
    private pokemon enemy1;
    private pokemon enemy2;
    private pokemon enemy3;
    private String trainer;
    private String gymBG;
    private String dialogue;
    private String Medal;
    private int losses=0;
    private int GymLevel;
    private int coins;
    private int usrPokeballs=2;
    private int usrHeals=3;
    private int area;


    private ArrayList<pokemon> beltpokemon = new ArrayList<pokemon>();
    private ArrayList<pokemon> storagepokemon = new ArrayList<pokemon>();
    private ArrayList<pokemon> allPokemon = new ArrayList<pokemon>();
    private ArrayList<String> MedalsList = new ArrayList<String>();
    private ArrayList<habilidad> habilityList = new ArrayList<habilidad>();

    public Motor(){

    }
    public void setStartingData(String userName, String gender, String starterPokemon, int coins){
        /**
         * sets user starting data
         */
        this.userName = userName;
        this.gender = gender;
        this.starterPokemon = starterPokemon;
        this.coins = coins;
        beltpokemon.add(getPokemonByName(starterPokemon));
        beltpokemon.add(getPokemonByName("Zapdos"));
        beltpokemon.add(getPokemonByName("Mewtwo"));


        System.out.println(beltpokemon.get(0).getNombre());
        System.out.println(this.userName+" "+this.gender+" "+this.starterPokemon+" "+this.coins);
    }
    public void showPantallaInicial(MouseEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PantallaInicial.fxml"));
            Parent root = loader.load();
            PantallaInicial controller = loader.<PantallaInicial>getController();
            controller.receiveMotorInstance(this);
            Scene PantallaInicial = new Scene(root);

            Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            currentStage.hide();
            currentStage.setScene(PantallaInicial);
            currentStage.show();
        }
        catch (Exception e){
            System.out.println("an Error has ocurred \n"+ e);
        }
    }
    public void showTownScene(MouseEvent event){
        areaBG = "townFightBG";
        type1 = "normal";
        type2 = "electrico";
        type3 = "lucha";
        gymBG = "townGymBG";
        Medal = "townMedal";
        enemy1 = getPokemonByName("Pidgeot");
        enemy2 = getPokemonByName("Raichu");
        enemy3 = getPokemonByName("Hitmonchan");
        trainer = "townTrainer";
        GymLevel = 6;
        area = 4;
        dialogue = "Hi little "+userName+", dont think this will be easy, lets fight!";
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TownScene.fxml"));
            Parent root = loader.load();
            TownScene controller = loader.<TownScene>getController();
            controller.receiveMotorInstance(this);
            Scene TownScene = new Scene(root);

            Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            currentStage.hide();
            currentStage.setScene(TownScene);
            currentStage.show();
        }
        catch (Exception e){
            System.out.println("an Error has ocurred \n"+ e);
        }
    }
    public void showBeachScene(MouseEvent event){
        areaBG = "beachFightBG";
        type1 = "agua";
        type2 = "bicho";
        type3 = "electrico";
        gymBG = "beachGymBG";
        Medal = "beachMedal";
        enemy1 = getPokemonByName("Blastoise");
        enemy2 = getPokemonByName("Parasect");
        enemy3 = getPokemonByName("Magneton");
        trainer = "beachTrainer";
        GymLevel = 4;
        area = 3;
        dialogue = "Hi "+userName+", you here for the medal? earn it then";
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BeachScene.fxml"));
            Parent root = loader.load();
            BeachScene controller = loader.<BeachScene>getController();
            controller.receiveMotorInstance(this);
            Scene BeachScene = new Scene(root);

            Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            currentStage.hide();
            currentStage.setScene(BeachScene);
            currentStage.show();
        }
        catch (Exception e){
            System.out.println("an Error has ocurred \n"+ e);
        }
    }
    public void showPlainsScene(MouseEvent event){
        areaBG = "plainsFightBG";
        type1 = "planta";
        type2 = "bicho";
        type3 = "tierra";
        gymBG = "plainsGymBG";
        Medal = "plainsMedal";
        enemy1 = getPokemonByName("Marowak");
        enemy2 = getPokemonByName("Beedrill");
        enemy3 = getPokemonByName("Vileplume");
        trainer = "plainsTrainer";
        GymLevel = 2;
        area = 2;
        dialogue = "Hi "+userName+", do you think that you will be able to defeat my troops?";
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PlainsScene.fxml"));
            Parent root = loader.load();
            PlainsScene controller = loader.<PlainsScene>getController();
            controller.receiveMotorInstance(this);
            Scene PlainsScene = new Scene(root);

            Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            currentStage.hide();
            currentStage.setScene(PlainsScene);
            currentStage.show();
        }
        catch (Exception e){
            System.out.println("an Error has ocurred \n"+ e);
        }
    }
    public void showCaves(MouseEvent event){
        areaBG = "cavesFightBG";
        type1 = "veneno";
        type2 = "psychic";
        type3 = "fuego";
        gymBG = "cavesGymBG";
        Medal = "cavesMedal";
        enemy1 = getPokemonByName("Arbok");
        enemy2 = getPokemonByName("Hypno");
        enemy3 = getPokemonByName("Charizard");
        trainer = "cavesTrainer";
        GymLevel = 8;
        area = 5;
        dialogue = "Hi Mr. "+userName+", it will be an honor for me to fight and see how keeps the medal, good luck";
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CavesScene.fxml"));
            Parent root = loader.load();
            CavesScene controller = loader.<CavesScene>getController();
            controller.receiveMotorInstance(this);
            Scene CavesScene = new Scene(root);

            Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            currentStage.hide();
            currentStage.setScene(CavesScene);
            currentStage.show();
        }
        catch (Exception e){
            System.out.println("an Error has ocurred \n"+ e);
        }
    }
    public void showMountains(MouseEvent event){
        areaBG = "mountainsFightBG";
        type1 = "hielo";
        type2 = "tierra";
        type3 = "aire";
        gymBG = "mountainsGymBG";
        Medal = "mountainsMedal";
        enemy1 = getPokemonByName("Jynx");
        enemy2 = getPokemonByName("Rhydon");
        enemy3 = getPokemonByName("Articuno");
        trainer = "mountainsTrainer";
        GymLevel = 10;
        area = 6;
        dialogue = "Hello "+userName+", welcome to your doom";
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MountainsScene.fxml"));
            Parent root = loader.load();
            MountainsScene controller = loader.<MountainsScene>getController();
            controller.receiveMotorInstance(this);
            Scene MountainsScene = new Scene(root);

            Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            currentStage.hide();
            currentStage.setScene(MountainsScene);
            currentStage.show();
        }
        catch (Exception e){
            System.out.println("an Error has ocurred \n"+ e);
        }
    }
    public void showPantallaBosque(MouseEvent event){
        areaBG = "forestFightBG";
        type1 = "hada";
        type2 = "planta";
        type3 = "bicho";
        gymBG = "forestGymBG";
        Medal = "forestMedal";
        enemy1 = getPokemonByName("Venusaur");
        enemy2 = getPokemonByName("Clefable");
        enemy3 = getPokemonByName("Venomoth");
        trainer = "forestTrainer";
        GymLevel = 0;
        area = 1;
        dialogue = "Hi "+userName+", looks like you are trying to get my medal, lets see if you can";
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PantallaBosque.fxml"));
            Parent root = loader.load();
            PantallaBosque controller = loader.<PantallaBosque>getController();
            controller.receiveMotorInstance(this);
            Scene PantallaBosqueScene = new Scene(root);

            Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            currentStage.hide();
            currentStage.setScene(PantallaBosqueScene);
            currentStage.show();
        }
        catch (Exception e){
            System.out.println("an Error has ocurred \n"+ e);
        }
    }
    public void showPokemart(MouseEvent event){
        /**
         * shows pokemart scene
         */
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Pokemart.fxml"));
            Parent root = loader.load();
            Pokemart controller = loader.<Pokemart>getController();
            controller.receiveMotorInstance(this);
            Scene PokemartScene = new Scene(root);

            Stage currentStage = new Stage();
            currentStage.setScene(PokemartScene);
            currentStage.show();
            System.out.println(this.coins);
        }
        catch (Exception e){
            System.out.println("an Error has ocurred \n"+ e);
        }
    }
    public void showMap(MouseEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Map.fxml"));
            Parent root = loader.load();
            Map controller = loader.<Map>getController();
            controller.receiveMotorInstance(this);
            Scene MapScene = new Scene(root);

            Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            currentStage.setScene(MapScene);
            currentStage.show();
            System.out.println(this.coins);
        }
        catch (Exception e){
            System.out.println("an Error has ocurred \n"+ e);
        }
    }
    public void showPokedex(MouseEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Pokedex.fxml"));
            Parent root = loader.load();
            Pokedex controller = loader.<Pokedex>getController();
            controller.receiveMotorInstance(this);
            Scene PokedexScene = new Scene(root);

            Stage currentStage = new Stage();
            currentStage.setScene(PokedexScene);
            currentStage.show();
        }
        catch (Exception e){
            System.out.println("an Error has ocurred \n"+ e);
        }
    }
    public void showGymFight(MouseEvent event) {
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Gym.fxml"));
        Parent root = loader.load();
        Gym controller = loader.<Gym>getController();
        controller.receiveMotorInstance(this);
        Scene GymScene = new Scene(root);

        Stage currentStage = new Stage();
        currentStage.setScene(GymScene);
        currentStage.show();
        }
        catch (Exception e){
            System.out.println("an Error has ocurred here in wildfightmotor \n"+ e);
        }
    }
    public void closeGymFight(MouseEvent event) {
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Gym.fxml"));
        Parent root = loader.load();
        Gym controller = loader.<Gym>getController();
        controller.receiveMotorInstance(this);
        Scene GymScene = new Scene(root);

        Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentStage.setScene(GymScene);
        currentStage.hide();
        }
        catch (Exception e){
            System.out.println("an Error has ocurred here in wildfightmotor \n"+ e);
        }
    }
    public void showWildFight(MouseEvent event)  {
        /**
         * shows wild fight scene
         */
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("wildFight.fxml"));
            Parent root = loader.load();
            wildFight controller = loader.<wildFight>getController();
            controller.receiveMotorInstance(this);
            Scene wildFightScene = new Scene(root);

            Stage currentStage = new Stage();
            currentStage.setScene(wildFightScene);
            currentStage.show();
        }
        catch (Exception e){
            System.out.println("an Error has ocurred here in wildfightmotor \n"+ e);
        }
    }
    public void closeWildFight(MouseEvent event) {
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("wildFight.fxml"));
        Parent root = loader.load();
        wildFight controller = loader.<wildFight>getController();
        controller.receiveMotorInstance(this);
        Scene wildFightScene = new Scene(root);

        Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentStage.setScene(wildFightScene);
        currentStage.hide();
        }
        catch (Exception e) {
            System.out.println("an Error has ocurred here in wildfightmotor \n" + e);
        }
    }
    /**
     * getters and setters for pokemon attributes
     * @return pokemon attributes
     */
    public String getBackground(){
        return areaBG;
    }
    public String getType1(){
        return type1;
    }
    public String getType2(){
        return type2;
    }
    public String getType3(){
        return type3;
    }
    public pokemon getEnemy1(){
        return enemy1;
    }
    public pokemon getEnemy2(){
        return enemy2;
    }
    public pokemon getEnemy3(){
        return enemy3;
    }
    public String getTrainer(){
        return trainer;
    }
    public String getDialogue(){
        return dialogue;
    }
    public String getGymBG(){
        return gymBG;
    }
    public int getGymLevel(){
        return GymLevel;
    }
    public int getLosses(){
        return losses;
    }
    public void setLosses(int losses){
        this.losses = losses;
    }
    public String getMedal(){
        return Medal;
    }
    public void addMedalsList(String addedMedal){
        MedalsList.add(addedMedal);
    }
    public ArrayList<String> getMedalsList(){
        return MedalsList;
    }
    public int getCoins(){
        return this.coins;
    }
    public void setCoins(int coins){
        this.coins = coins;
        System.out.println(this.coins);
    }
    public String getUserName(){
        return userName;
    }
    public String getGender(){
        return gender;
    }
    public String getStarterPokemon(){
        return starterPokemon;
    }
    public int getUsrPokeballs(){
        return this.usrPokeballs;
    }
    public void setUsrPokeballs(int usrPokeballs){
        this.usrPokeballs = usrPokeballs;
    }
    public int getUsrHeals(){
        return usrHeals;
    }
    public void setUsrHeals(int usrHeals){
        this.usrHeals = usrHeals;
    }
    public pokemon getPokemonByName(String pokemonName){
        /**
         * searches for the pokemon by its name
         */
        pokemon basePokemon = new pokemon();
        pokemon toReturnPokemon=null;
        for (int i=0; i<allPokemon.size(); i++){
            if (allPokemon.get(i).getNombre().equals(pokemonName)){
                basePokemon.setAllData(allPokemon.get(i));
                toReturnPokemon = basePokemon;
            }
        }
        return toReturnPokemon;
    }
    public ArrayList<pokemon> getBeltPokemon(){
        return beltpokemon;
    }
    public void addBeltPokemon(pokemon pokemonAdded){
       beltpokemon.add(pokemonAdded);
    }
    public ArrayList<pokemon> getAllPokemon(){
        return allPokemon;
    }
    public void addStoragePokemon(pokemon pokemonAdded){
        storagepokemon.add(pokemonAdded);
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public void setStarterPokemon(String starterPokemon){

        beltpokemon.add(getPokemonByName(starterPokemon));
    }
    public int getArea(){
        return area;
    }
    public pokemon randomPokemon(){
        Random random = new Random();
        int randomPokemon = random.nextInt(allPokemon.size());
        return allPokemon.get(randomPokemon);
    }
    public habilidad getHability(String habilityName){
        habilidad toReturnHabnility = new habilidad();
        for (int i=0; i<habilityList.size(); i++){
            if (habilityList.get(i).getNombre().equals(habilityName)){
                toReturnHabnility = habilityList.get(i);
            }
        }
        return toReturnHabnility;
    }
    public void createAllPokemon(){
        /**
         * creates all pokemon and habilities available
         */

        /** habilidades */
        //Veneno
        habilidad acid = new habilidad("Acid", "veneno", 2);
        habilityList.add(acid);
        habilidad toxic = new habilidad("Toxic", "veneno", 1);
        habilityList.add(toxic);
        habilidad poisongas = new habilidad("Poison Gas", "Veneno", 2);
        habilityList.add(poisongas);
        habilidad poisonpowder = new habilidad("Posion Powder", "Veneno", 3);
        habilityList.add(poisonpowder);
        habilidad smog = new habilidad("Smog", "Veneno", 1);
        habilityList.add(smog);
        habilidad sludge = new habilidad("Sludge", "Veneno", 4);
        habilityList.add(sludge);
        //Psychic
        habilidad amnesia = new habilidad("Amnesia", "psychic", 4);
        habilityList.add(amnesia);
        habilidad confusion = new habilidad("Confusion", "psychic", 1);
        habilityList.add(confusion);
        habilidad dreameater = new habilidad("Dream Eater", "psychic", 2);
        habilityList.add(dreameater);
        habilidad kinesis = new habilidad("Kinesis", "psychic", 1);
        habilityList.add(kinesis);
        habilidad psychic = new habilidad("Psychic", "psychic", 1);
        habilityList.add(psychic);
        habilidad rest = new habilidad("Rest", "psychic", 2);
        habilityList.add(rest);
        habilidad reflect = new habilidad("Reflect", "psychic", 1);
        habilityList.add(reflect);
        habilidad agility = new habilidad("Agility", "psychic", 4);
        habilityList.add(agility);
        //Hielo
        habilidad aurora = new habilidad("Aurora Beam", "hielo", 2);
        habilityList.add(aurora);
        habilidad blizzard = new habilidad("Blizzard", "hielo", 4);
        habilityList.add(blizzard);
        //Normal
        habilidad barrage = new habilidad("Barrage", "normal", 4);
        habilityList.add(barrage);
        habilidad bide = new habilidad("Bide", "normal", 2);
        habilityList.add(bide);
        habilidad bind = new habilidad("Bind", "normal", 1);
        habilityList.add(bind);
        habilidad bodyslam = new habilidad("Body Slam", "normal", 4);
        habilityList.add(bodyslam);
        habilidad cometpunch = new habilidad("Comet Punch", "normal", 1);
        habilityList.add(cometpunch);
        habilidad constrict = new habilidad("Constrict", "normal", 2);
        habilityList.add(constrict);
        habilidad conversion = new habilidad("Conversion", "normal", 4);
        habilityList.add(conversion);
        habilidad furyattack = new habilidad("Fury Attack", "normal", 4);
        habilityList.add(furyattack);
        habilidad transform = new habilidad("Transform", "normal", 1);
        habilityList.add(transform);
        //Tierra
        habilidad boneclub = new habilidad("Bone Club", "tierra", 2);
        habilityList.add(boneclub);
        habilidad boomerang = new habilidad("Boomerang", "tierra", 1);
        habilityList.add(boomerang);
        habilidad dig = new habilidad("Dig", "tierra", 2);
        habilityList.add(dig);
        habilidad fissure = new habilidad("Fissure", "tierra", 2);
        habilityList.add(fissure);
        habilidad earthquake = new habilidad("Earthquake", "tierra", 4);
        habilityList.add(earthquake);
        habilidad sandattack = new habilidad("Sand Attack", "tierra", 1);
        habilityList.add(sandattack);
        //Agua
        habilidad bubble = new habilidad("Bubble", "agua", 2);
        habilityList.add(bubble);
        habilidad clamp = new habilidad("Clamp", "agua", 4);
        habilityList.add(clamp);
        habilidad crabhammer = new habilidad("Crabhammer", "agua", 1);
        habilityList.add(crabhammer);
        habilidad surf = new habilidad("Surf", "agua", 1);
        habilityList.add(surf);
        habilidad waterfall = new habilidad("Waterfall", "agua", 4);
        habilityList.add(waterfall);
        habilidad withdraw = new habilidad("Withdraw", "agua", 2);
        habilityList.add(withdraw);
        habilidad watergun = new habilidad("Water Gun", "agua", 4);
        habilityList.add(watergun);
        //Lucha
        habilidad counter = new habilidad("Counter", "lucha", 4);
        habilityList.add(counter);
        habilidad doublekick = new habilidad("Double Kick", "lucha", 1);
        habilityList.add(doublekick);
        habilidad highjump = new habilidad("High Jump Kick", "lucha", 2);
        habilityList.add(highjump);
        habilidad karatechop = new habilidad("Karate Chop", "lucha", 4);
        habilityList.add(karatechop);
        habilidad lowkick = new habilidad("Low Kick", "lucha", 1);
        habilityList.add(lowkick);
        habilidad submission = new habilidad("submission", "lucha", 4);
        habilityList.add(submission);
        //Fuego
        habilidad ember = new habilidad("Ember", "fuego", 2);
        habilityList.add(ember);
        habilidad fireblast = new habilidad("Fire Blast", "fuego", 4);
        habilityList.add(fireblast);
        habilidad firepunch = new habilidad("Fire Punch", "fuego", 1);
        habilityList.add(firepunch);
        habilidad flamethrower = new habilidad("Flamethrower", "fuego", 2);
        habilityList.add(flamethrower);
        habilidad firespin = new habilidad("Fire Spin", "fuego", 2);
        habilityList.add(firespin);
        //Aire
        habilidad wingattack = new habilidad("Wing Attack", "aire", 2);
        habilityList.add(wingattack);
        habilidad gust = new habilidad("Gust", "aire", 4);
        habilityList.add(gust);
        //Bicho
        habilidad stringshot = new habilidad("String Shot", "bicho", 1);
        habilityList.add(stringshot);
        habilidad leechlife = new habilidad("Leech Life", "bicho", 2);
        habilityList.add(leechlife);
        habilidad twineedle = new habilidad("Twineedle", "bicho", 4);
        habilityList.add(twineedle);
        habilidad pinmissile = new habilidad("Pin Missile", "bicho", 2);
        habilityList.add(pinmissile);
        //Planta
        habilidad leechseed = new habilidad("Leech Seed", "planta", 4);
        habilityList.add(leechseed);
        habilidad solarbeam = new habilidad("Solar Beam", "planta", 1);
        habilityList.add(solarbeam);
        habilidad razorleaf = new habilidad("Razor Leaf", "planta", 2);
        habilityList.add(razorleaf);
        habilidad spore = new habilidad("Spore", "planta", 2);
        habilityList.add(spore);
        habilidad vinewhip = new habilidad("Vine Whip", "planta", 4);
        habilityList.add(vinewhip);
        //Electrico
        habilidad thunder = new habilidad("Thunder", "electrico", 4);
        habilityList.add(thunder);
        habilidad thunderpunch = new habilidad("Thunder Punch", "electrico", 2);
        habilityList.add(thunderpunch);
        habilidad thunderbolt = new habilidad("Thunderbolt", "electrico", 4);
        habilityList.add(thunderbolt);
        habilidad thundershock = new habilidad("Thunder Shock", "electrico", 2);
        habilityList.add(thundershock);
        habilidad thunderwave = new habilidad("Thunder Wave", "electrico", 1);
        habilityList.add(thunderwave);
        /**
         * pokemons
         */
        pokemon venusaur = new pokemon("planta", "Venusaur", leechseed, solarbeam, transform, conversion, 3, 10, null, 10, 0);
        allPokemon.add(venusaur);
        pokemon ivysaur = new pokemon("planta", "Ivysaur", leechseed, solarbeam, transform, null, 2, 7, venusaur, 7, 0);
        allPokemon.add(ivysaur);
        pokemon bulbasaur = new pokemon("planta", "Bulbasaur", leechseed, solarbeam, null, null, 1, 5, ivysaur, 5, 0);
        allPokemon.add(bulbasaur);
        pokemon charizard = new pokemon("fuego", "Charizard", fireblast, firepunch, flamethrower, furyattack, 3, 10, null, 10, 0);
        allPokemon.add(charizard);
        pokemon charmeleon = new pokemon("fuego", "Charmeleon", fireblast, firepunch, flamethrower, furyattack, 2, 7, charizard, 7, 0);
        allPokemon.add(charmeleon);
        pokemon charmander = new pokemon("fuego", "Charmander", fireblast, firepunch, null, null, 1, 4, charmeleon, 5, 0);
        allPokemon.add(charmander);
        pokemon blastoise = new pokemon("agua", "Blastoise", bubble, waterfall, clamp, constrict, 3, 10, null, 10, 0);
        allPokemon.add(blastoise);
        pokemon wartortle = new pokemon("agua", "Wartortle", bubble, waterfall, clamp, constrict, 2, 7, blastoise, 7, 0);
        allPokemon.add(wartortle);
        pokemon squirtle = new pokemon("agua", "Squirtle", bubble, waterfall, clamp, constrict, 1, 4, wartortle, 5, 0);
        allPokemon.add(squirtle);
        pokemon butterfree = new pokemon("bicho", "Butterfree", stringshot, leechlife, crabhammer, furyattack, 3, 10, null, 10, 0);
        allPokemon.add(butterfree);
        pokemon metapod = new pokemon("bicho", "Metapod", stringshot, leechlife, crabhammer, furyattack, 2, 7, butterfree, 7, 0);
        allPokemon.add(metapod);
        pokemon caterpie = new pokemon("bicho", "Caterpie", stringshot, leechlife, crabhammer, furyattack, 1, 4, metapod, 5, 0);
        allPokemon.add(caterpie);
        pokemon beedrill = new pokemon("bicho", "Beedrill", stringshot, transform, wingattack, furyattack, 3, 10, null, 10, 0);
        allPokemon.add(beedrill);
        pokemon kakuna = new pokemon("bicho", "Kakuna", transform, furyattack, wingattack, null, 2, 7, beedrill, 7, 0);
        allPokemon.add(kakuna);
        pokemon weedle = new pokemon("bicho", "Weedle", transform, furyattack, null, null, 1, 4, kakuna, 5, 0);
        allPokemon.add(weedle);
        pokemon pidgeot = new pokemon("normal", "Pidgeot", barrage, bide, wingattack, cometpunch, 3, 10, null, 10, 0);
        allPokemon.add(pidgeot);
        pokemon pidgeotto = new pokemon("normal", "Pidgeotto", barrage, bide, wingattack, null, 2, 7, pidgeot, 7, 0);
        allPokemon.add(pidgeotto);
        pokemon pidgey = new pokemon("normal", "Pidgey", barrage, bide, null, null, 1, 4, pidgeotto, 5, 0);
        allPokemon.add(pidgey);
        pokemon raticate = new pokemon("normal", "Raticate", bind, transform, bide, null, 2, 10, null, 10, 0);
        allPokemon.add(raticate);
        pokemon rattata = new pokemon("normal", "Rattata", bind, transform, null, null, 1, 4, raticate, 5, 0);
        allPokemon.add(rattata);
        pokemon fearow = new pokemon("normal", "Fearow", furyattack, wingattack, bodyslam, gust, 3, 10, null, 10, 0);
        allPokemon.add(fearow);
        pokemon spearow = new pokemon("normal", "Spearow", furyattack, wingattack, null, null, 1, 4, fearow, 5, 0);
        allPokemon.add(spearow);
        pokemon arbok = new pokemon("veneno", "Arbok", acid, toxic, bind, constrict, 3, 10, null, 10, 0);
        allPokemon.add(arbok);
        pokemon ekans = new pokemon("veneno", "Ekans", acid, toxic, null, null, 1, 4, arbok, 5, 0);
        allPokemon.add(ekans);
        pokemon raichu = new pokemon("electrico", "Raichu", thunder, thunderpunch, thunderbolt, counter, 3, 10, null, 10, 0);
        allPokemon.add(raichu);
        pokemon pikachu = new pokemon("electrico", "Pikachu", thunder, thunderpunch, null, null, 1, 4, raichu, 5, 0);
        allPokemon.add(pikachu);
        pokemon sandslash = new pokemon("tierra", "Sandslash", boneclub, boomerang, dig, conversion, 3, 10, null, 10, 0);
        allPokemon.add(sandslash);
        pokemon sandshrew = new pokemon("tierra", "Sandshrew", boneclub, boomerang, null, null, 1, 4, sandslash, 5, 0);
        allPokemon.add(sandshrew);
        pokemon nidoqueen = new pokemon("veneno", "Nidoqueen", smog, sludge, toxic, bodyslam, 3, 10, null, 10, 0);
        allPokemon.add(nidoqueen);
        pokemon nidorina = new pokemon("veneno", "Nidorina", smog, sludge, toxic, null, 2, 7, nidoqueen, 7, 0);
        allPokemon.add(nidorina);
        pokemon nidoranM = new pokemon("veneno", "NidoranM", smog, sludge, null, null, 1, 4, nidorina, 5, 0);
        allPokemon.add(nidoranM);
        pokemon nidoking = new pokemon("veneno", "Nidoking", smog, poisongas, acid, toxic, 3, 10, null, 10, 0);
        allPokemon.add(nidoking);
        pokemon nidorino = new pokemon("veneno", "Nidorino", smog, poisongas, acid, null, 2, 7, nidoking, 7, 0);
        allPokemon.add(nidorino);
        pokemon nidoranH = new pokemon("veneno", "NidoranH", smog, poisongas, null, null, 1, 4, nidorino, 5, 0);
        allPokemon.add(nidoranH);
        pokemon clefable = new pokemon("hada", "Clefable", barrage, bide, confusion, null, 3, 10, null, 10, 0);
        allPokemon.add(clefable);
        pokemon clefairy = new pokemon("hada", "Clefairy", barrage, bide, null, null, 1, 4, clefable, 5, 0);
        allPokemon.add(clefairy);
        pokemon ninetales = new pokemon("fuego", "Ninetales", ember, fireblast, firepunch, flamethrower, 3, 10, null, 10, 0);
        allPokemon.add(ninetales);
        pokemon vulpix = new pokemon("fuego", "Vulpix", ember, fireblast, firepunch, null, 1, 4, ninetales, 5, 0);
        allPokemon.add(vulpix);
        pokemon wigglytuff = new pokemon("normal", "Wigglytuff", transform, cometpunch, bide, null, 3, 10, null, 10, 0);
        allPokemon.add(wigglytuff);
        pokemon jigglypuff = new pokemon("normal", "Jigglypuff", transform, cometpunch, null, null, 1, 4, wigglytuff, 5, 0);
        allPokemon.add(jigglypuff);
        pokemon golbat = new pokemon("veneno", "Golbat", acid, sludge, poisonpowder, toxic, 3, 10, null, 10, 0);
        allPokemon.add(golbat);
        pokemon zubat = new pokemon("veneno", "Zubat", acid, sludge, null, null, 1, 4, golbat, 5, 0);
        allPokemon.add(zubat);
        pokemon vileplume = new pokemon("planta", "Vileplume", razorleaf, spore, leechseed, vinewhip, 3, 10, null, 10, 0);
        allPokemon.add(vileplume);
        pokemon gloom = new pokemon("planta", "Gloom", razorleaf, spore, leechseed, null, 2, 7, vileplume, 7, 0);
        allPokemon.add(gloom);
        pokemon oddish = new pokemon("planta", "Oddish", razorleaf, spore, null, null, 1, 4, gloom, 5, 0);
        allPokemon.add(oddish);
        pokemon parasect = new pokemon("bicho", "Parasect", pinmissile, twineedle, leechlife, null, 3, 10, null, 10, 0);
        allPokemon.add(parasect);
        pokemon paras = new pokemon("bicho", "Paras", pinmissile, twineedle, null, null, 1, 7, parasect, 5, 0);
        allPokemon.add(paras);
        pokemon venomoth = new pokemon("bicho", "Venomoth", pinmissile, stringshot, leechlife, highjump, 3, 10, null, 10, 0);
        allPokemon.add(venomoth);
        pokemon venonat = new pokemon("bicho", "Venonat", pinmissile, stringshot, null, null, 1, 4, venomoth, 5, 0);
        allPokemon.add(venonat);
        pokemon dugtrio = new pokemon("tierra", "Dugtrio", fissure, sandattack, dig, boomerang, 3, 10, null, 10, 0);
        allPokemon.add(dugtrio);
        pokemon diglett = new pokemon("tierra", "Diglett", fissure, sandattack, null, null, 1, 4, dugtrio, 5, 0);
        allPokemon.add(diglett);
        pokemon persian = new pokemon("normal", "Persian", furyattack, conversion, bide, null, 3, 10, null, 10, 0);
        allPokemon.add(persian);
        pokemon meowth = new pokemon("normal", "Meowth", furyattack, conversion, null, null, 1, 4, persian, 5, 0);
        allPokemon.add(meowth);
        pokemon golduck = new pokemon("agua", "Golduck", bubble, surf, waterfall, clamp, 3, 10, null, 10, 0);
        allPokemon.add(golduck);
        pokemon psyduck = new pokemon("agua", "Psyduck", bubble, surf, null, null, 1, 4, golduck, 5, 0);
        allPokemon.add(psyduck);
        pokemon primeape = new pokemon("lucha", "Primeape", counter, doublekick, highjump, bodyslam, 3, 10, null, 10, 0);
        allPokemon.add(primeape);
        pokemon mankey = new pokemon("lucha", "Mankey", counter, doublekick, null, null, 1, 4, primeape, 5, 0);
        allPokemon.add(mankey);
        pokemon arcanine = new pokemon("fuego", "Aracanine", ember, fireblast, flamethrower, firespin, 3, 10, null, 10, 0);
        allPokemon.add(arcanine);
        pokemon growlithe = new pokemon("fuego", "Growlithe", ember, fireblast, null, null, 2, 4, arcanine, 5, 0);
        allPokemon.add(growlithe);
        pokemon poliwrath = new pokemon("agua", "Poliwrath", crabhammer, waterfall, clamp, watergun, 3, 10, null, 10, 0);
        allPokemon.add(poliwrath);
        pokemon poliwhirl = new pokemon("agua", "Poliwhirl", crabhammer, waterfall, clamp, null, 2, 7, poliwrath, 7, 0);
        allPokemon.add(poliwhirl);
        pokemon poliwag = new pokemon("agua", "Poliwag", crabhammer, waterfall, null, null, 1, 4, poliwhirl, 5, 0);
        allPokemon.add(poliwag);
        pokemon alakazam = new pokemon("psychic", "Alakazam", psychic, kinesis, confusion, agility, 3, 10, null, 10, 0);
        allPokemon.add(alakazam);
        pokemon kadabra = new pokemon("psychic", "Kadabra", psychic, kinesis, confusion, null, 2, 7, alakazam, 7, 0);
        allPokemon.add(kadabra);
        pokemon abra = new pokemon("psychic", "Abra", psychic, kinesis, null, null, 1, 4, kadabra, 5, 0);
        allPokemon.add(abra);
        pokemon machamp = new pokemon("lucha", "Machamp", lowkick, highjump, counter, submission, 3, 10, null, 10, 0);
        allPokemon.add(machamp);
        pokemon machoke = new pokemon("lucha", "Machoke", lowkick, highjump, counter, null, 2, 7, machamp, 7, 0);
        allPokemon.add(machoke);
        pokemon machop = new pokemon("lucha", "machop", lowkick, highjump, null, null, 1, 4, machoke, 5, 0);
        allPokemon.add(machop);
        pokemon victreebel = new pokemon("planta", "Victreebel", solarbeam, leechseed, razorleaf, vinewhip, 3, 10, null, 10, 0);
        allPokemon.add(victreebel);
        pokemon weepinbell = new pokemon("planta", "Weepinbell", solarbeam, leechseed, razorleaf, null, 2, 7, victreebel, 7, 0);
        allPokemon.add(weepinbell);
        pokemon bellsprout = new pokemon("planta", "Bellsprout", solarbeam, leechseed, null, null, 1, 4, weepinbell, 5, 0);
        allPokemon.add(bellsprout);
        pokemon tentacruel = new pokemon("agua", "Tentacruel", bubble, clamp, withdraw, watergun, 3, 10, null, 10, 0);
        allPokemon.add(tentacruel);
        pokemon tentacool = new pokemon("agua", "Tentacool", bubble, clamp, null, null, 1, 4, tentacruel, 5, 0);
        allPokemon.add(tentacool);
        pokemon golem = new pokemon("tierra", "Golem", fissure, earthquake, dig, boneclub, 3, 10, null, 10, 0);
        allPokemon.add(golem);
        pokemon graveler = new pokemon("tierra", "Graveler", fissure, earthquake, dig, null, 2, 7, golem, 7, 0);
        allPokemon.add(graveler);
        pokemon geodude = new pokemon("tierra", "Geodude", fissure, earthquake, null, null, 1, 4, graveler, 5, 0);
        allPokemon.add(geodude);
        pokemon rapidash = new pokemon("fuego", "Rapidash", fireblast, firespin, flamethrower, ember, 3, 10, null, 10, 0);
        allPokemon.add(rapidash);
        pokemon ponyta = new pokemon("fuego", "Ponyta", fireblast, firespin, null, null, 1, 4, rapidash, 5, 0);
        allPokemon.add(ponyta);
        pokemon slowbro = new pokemon("agua", "slowbro", clamp, crabhammer, watergun, surf, 3, 10, null, 10, 0);
        allPokemon.add(slowbro);
        pokemon slowpoke = new pokemon("agua", "Slowpoke", clamp, crabhammer, null, null, 1, 4, slowbro, 5, 0);
        allPokemon.add(slowpoke);
        pokemon magnetom = new pokemon("electrico", "Magneton", thunder, thunderpunch, thunderwave, thunderbolt, 3, 10, null, 10, 0);
        allPokemon.add(magnetom);
        pokemon magnemite = new pokemon("electrico", "Magnemite", thunder, thunderpunch, null, null, 1, 4, magnetom, 5, 0);
        allPokemon.add(magnemite);
        pokemon dodrio = new pokemon("normal", "Dodrio", barrage, conversion, cometpunch, transform, 3, 10, null, 10, 0);
        allPokemon.add(dodrio);
        pokemon doduo = new pokemon("normal", "Doduo", barrage, conversion, cometpunch, null, 2, 7, dodrio, 7, 0);
        allPokemon.add(doduo);
        pokemon farfetch = new pokemon("normal", "Farfetch", barrage, conversion, null, null, 1, 4, doduo, 5, 0);
        allPokemon.add(farfetch);
        pokemon dewgong = new pokemon("agua", "Dewgong", bubble, withdraw, surf, watergun, 3, 10, null, 10, 0);
        allPokemon.add(dewgong);
        pokemon seel = new pokemon("agua", "Seel", bubble, withdraw, null, null, 1, 4, dewgong, 5, 0);
        allPokemon.add(seel);
        pokemon muk = new pokemon("veneno", "Muk", acid, toxic, sludge, smog, 3, 10, null, 10, 0);
        allPokemon.add(muk);
        pokemon grimer = new pokemon("veneno", "Grimer", acid, toxic, null, null, 1, 4, muk, 5, 0);
        allPokemon.add(grimer);
        pokemon cloyster = new pokemon("agua", "Cloyster", bubble, withdraw, clamp, bodyslam, 3, 10, null, 10, 0);
        allPokemon.add(cloyster);
        pokemon shellder = new pokemon("agua", "Shellder", bubble, withdraw, null, null, 1, 4, cloyster, 5, 0);
        allPokemon.add(shellder);
        pokemon gengar = new pokemon("veneno", "Gengar", smog, sludge, poisongas, toxic, 3, 10, null, 10, 0);
        allPokemon.add(gengar);
        pokemon haunter = new pokemon("veneno", "Haunter", smog, sludge, poisongas, null, 2, 7, gengar, 7, 0);
        allPokemon.add(haunter);
        pokemon gastly = new pokemon("veneno", "Gastly", smog, sludge, null, null, 1, 4, haunter, 5, 0);
        allPokemon.add(gastly);
        pokemon onix = new pokemon("tierra", "Onix", earthquake, sandattack, null, null, 1, 4, null, 5, 0);
        allPokemon.add(onix);
        pokemon hypno = new pokemon("psychic", "Hypno", amnesia, confusion, dreameater, reflect, 3, 10, null, 10, 0);
        allPokemon.add(hypno);
        pokemon drowzee = new pokemon("psychic", "Drowzee", amnesia, confusion, null, null, 1, 4, hypno, 5, 0);
        allPokemon.add(drowzee);
        pokemon kingler = new pokemon("agua", "Kingler", clamp, crabhammer, surf, watergun, 3, 10, null, 10, 0);
        allPokemon.add(kingler);
        pokemon krabby = new pokemon("agua", "Krabby", clamp, crabhammer, null, null, 1, 4, kingler, 5, 0);
        allPokemon.add(krabby);
        pokemon electrode = new pokemon("electrico", "Electrode", thunder, thunderbolt, thunderwave, thunderpunch, 3, 10, null, 10, 0);
        allPokemon.add(electrode);
        pokemon voltorb = new pokemon("electrico", "Voltorb", thunder, thunderbolt, null, null, 1, 4, electrode, 5, 0);
        allPokemon.add(voltorb);
        pokemon exeggutor = new pokemon("planta", "Exeggutor", leechseed, solarbeam, razorleaf, spore, 3, 10, null, 10, 0);
        allPokemon.add(exeggutor);
        pokemon exeggcute = new pokemon("planta", "Exeggcute", leechseed, solarbeam, null, null, 1, 4, exeggutor, 5, 0);
        allPokemon.add(exeggcute);
        pokemon marowak = new pokemon("tierra", "Marowak", boneclub, fissure, sandattack, dig, 3, 10, null, 10, 0);
        allPokemon.add(marowak);
        pokemon cubone = new pokemon("tierra", "Cubone", boneclub, fissure, null, null, 1, 4, marowak, 5, 0);
        allPokemon.add(cubone);
        pokemon hitmonchan = new pokemon("lucha", "Hitmonchan", doublekick, lowkick, submission, counter, 3, 10, null, 10, 0);
        allPokemon.add(hitmonchan);
        pokemon hitmonlee = new pokemon("lucha", "Hitmonlee", doublekick, lowkick, null, null, 1, 4, hitmonchan, 5, 0);
        allPokemon.add(hitmonlee);
        pokemon lickitung = new pokemon("normal", "Lickitung", bide, bodyslam, null, null, 1, 4, null, 5, 0);
        allPokemon.add(lickitung);
        pokemon weezing = new pokemon("veneno", "Weezing", acid, toxic, poisongas, sludge, 3, 10, null, 10, 0);
        allPokemon.add(weezing);
        pokemon koffing = new pokemon("veneno", "Koffing", acid, toxic, null, null, 1, 4, weezing, 5, 0);
        allPokemon.add(koffing);
        pokemon rhydon = new pokemon("tierra", "Rhydon", boomerang, earthquake, fissure, furyattack, 3, 10, null, 10, 0);
        allPokemon.add(rhydon);
        pokemon rhyhorn = new pokemon("tierra", "Rhyhorn", boomerang, earthquake, null, null, 1, 4, rhydon, 5, 0);
        allPokemon.add(rhyhorn);
        pokemon chansey = new pokemon("normal", "Chansey", bide, bind, null, null, 1, 4, null, 5, 0);
        allPokemon.add(chansey);
        pokemon tangela = new pokemon("planta", "Tangela", leechseed, solarbeam, null, null, 1, 4, null, 5, 0);
        allPokemon.add(tangela);
        pokemon kangaskhan = new pokemon("normal", "Kangaskhan", constrict, furyattack, bodyslam, null, 1, 4, null, 5, 0);
        allPokemon.add(kangaskhan);
        pokemon seadra = new pokemon("agua", "Seadra", bubble, clamp, surf, watergun, 3, 10, null, 10, 0);
        allPokemon.add(seadra);
        pokemon horsea = new pokemon("agua", "Horsea", bubble, clamp, null, null, 1, 4, seadra, 5, 0);
        allPokemon.add(horsea);
        pokemon seaking = new pokemon("agua", "Seaking", clamp, bubble, waterfall, watergun, 3, 10, null, 10, 0);
        allPokemon.add(seaking);
        pokemon goldeen = new pokemon("agua", "Goldeen", clamp, bubble, null, null, 1, 4, seaking, 5, 0);
        allPokemon.add(goldeen);
        pokemon starmie = new pokemon("agua", "Starmie", crabhammer, waterfall, bubble, watergun, 3, 10, null, 10, 0);
        allPokemon.add(starmie);
        pokemon staryu = new pokemon("agua", "Staryu", crabhammer, waterfall, null, null, 1, 4, starmie, 5, 0);
        allPokemon.add(staryu);
        pokemon mrmime = new pokemon("psychic", "Mr Mime", agility, rest, reflect, null, 1, 4, null, 5, 0);
        allPokemon.add(mrmime);
        pokemon scyther = new pokemon("bicho", "Scyther", twineedle, leechlife, null, null, 1, 4, null, 5, 0);
        allPokemon.add(scyther);
        pokemon jynx = new pokemon("hielo", "Jynx", aurora, blizzard, barrage, bodyslam, 3, 10, null, 10, 0);
        allPokemon.add(jynx);
        pokemon electabuzz = new pokemon("electrrico", "Electabuzz", thunder, thunderbolt, null, null, 1, 4, null, 5, 0);
        allPokemon.add(electabuzz);
        pokemon magmar = new pokemon("fuego", "Magmar", ember, fireblast, firespin, null, 1, 4, null, 5, 0);
        allPokemon.add(magmar);
        pokemon pinsir = new pokemon("bicho", "Pinsir", leechlife, solarbeam, null, null, 1, 4, null, 5, 0);
        allPokemon.add(pinsir);
        pokemon tauros = new pokemon("normal", "Tauros", bodyslam, furyattack, null, null, 1, 4, null, 5, 0);
        allPokemon.add(tauros);
        pokemon gyarados = new pokemon("agua", "Gyarados", bubble, waterfall, clamp, null, 1, 4, null, 5, 0);
        allPokemon.add(gyarados);
        pokemon magikarp = new pokemon("agua", "Magikarp", bubble, waterfall, null, null, 1, 4, gyarados, 5, 0);
        allPokemon.add(magikarp);
        pokemon lapras = new pokemon("agua", "Lapras", watergun, waterfall, bubble, null, 1, 4, null, 5, 0);
        allPokemon.add(lapras);
        pokemon ditto = new pokemon("normal", "Ditto", bide, bind, null, null, 1, 4, null, 5, 0);
        allPokemon.add(ditto);
        pokemon flareon = new pokemon("fuego", "Flareon", bide, fireblast, firepunch, null, 3, 10, null, 10, 0);
        allPokemon.add(flareon);
        pokemon jolteon = new pokemon("electrico", "Jolteon", bide, thunder, thundershock, null, 3, 10, flareon, 10, 0);
        allPokemon.add(jolteon);
        pokemon vaporeon = new pokemon("agua", "Vaporeon", bide, waterfall, clamp, null, 2, 7, jolteon, 7, 0);
        allPokemon.add(vaporeon);
        pokemon eevee = new pokemon("normal", "Eevee", bide, bind, null, null, 1, 4, vaporeon, 5, 0);
        allPokemon.add(eevee);
        pokemon porygon = new pokemon("normal", "Porygon", bodyslam, conversion, null, null, 1, 4, null, 5, 0);
        allPokemon.add(porygon);
        pokemon omastar = new pokemon("agua", "Omastar", waterfall, clamp, bubble, null, 3, 10, null, 10, 0);
        allPokemon.add(omastar);
        pokemon omanyte = new pokemon("agua", "Omanyte", waterfall, clamp, null, null, 1, 4, omastar, 5, 0);
        allPokemon.add(omanyte);
        pokemon kabutops = new pokemon("agua", "Kabutops", crabhammer, clamp, waterfall, watergun, 3, 10, null, 10, 0);
        allPokemon.add(kabutops);
        pokemon kabuto = new pokemon("agua", "Kabuto", crabhammer, clamp, null, null, 1, 4, kabutops, 5, 0);
        allPokemon.add(kabuto);
        pokemon aerodactyl = new pokemon("aire", "Aerodactyl", wingattack, gust, null, null, 1, 4, null, 5, 0);
        allPokemon.add(aerodactyl);
        pokemon snorlax = new pokemon("normal", "Snorlax", bodyslam, constrict, null, null, 1, 4, null, 5, 0);
        allPokemon.add(snorlax);
        pokemon articuno = new pokemon("hielo", "Articuno", wingattack, gust, aurora, blizzard, 3, 13, null, 15, 0);
        allPokemon.add(articuno);
        pokemon zapdos = new pokemon("electrico", "Zapdos", wingattack, gust, thunder, thunderbolt, 3, 13, null, 15, 0);
        allPokemon.add(zapdos);
        pokemon moltres = new pokemon("fuego", "Moltres", wingattack, fireblast, firespin, gust, 3, 13, null, 15, 0);
        allPokemon.add(moltres);
        pokemon dragonite = new pokemon("fuego", "Dragonite", furyattack, fireblast, wingattack, firespin, 3, 10, null, 10, 0);
        allPokemon.add(dragonite);
        pokemon dragonair = new pokemon("fuego", "Dragonair", furyattack, fireblast, wingattack, null, 2, 7, dragonite, 7, 0);
        allPokemon.add(dragonair);
        pokemon dratini = new pokemon("fuego", "Dratini", furyattack, fireblast, null, null, 1, 4, dragonair, 5, 0);
        allPokemon.add(dratini);
        pokemon mewtwo = new pokemon("psychic", "Mewtwo", amnesia, agility, rest, dreameater, 3, 13, null, 15, 0);
        allPokemon.add(mewtwo);
        pokemon mew = new pokemon("psychic", "Mew", barrage, agility, amnesia, rest, 2, 13, null, 15, 0);
        allPokemon.add(mew);
    }
}