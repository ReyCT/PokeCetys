package ViewControllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Map {

    private Motor motor;
    @FXML
    private ImageView plainsLock, beachLock, townLock, cavesLock, mountainsLock, lockedAreasPopUp;
    @FXML
    private Label plains, beach, town, caves, mountains;
    private ArrayList<Label> areas = new ArrayList<Label>();

    public void initialize(){
        areas.add(plains);
        areas.add(beach);
        areas.add(town);
        areas.add(caves);
        areas.add(mountains);
        plains.setDisable(true);
        beach.setDisable(true);
        town.setDisable(true);
        caves.setDisable(true);
        mountains.setDisable(true);
    }

    public void receiveMotorInstance(Motor m){
        this.motor = m;

        /**
         * checks for unlocked areas
         */
        for (int i=0; i<motor.getMedalsList().size(); i++){
            if (i==0){
                plains.setDisable(false);
                plainsLock.setVisible(false);
            }
            else if (i==1){
                beach.setDisable(false);
                beachLock.setVisible(false);
            }
            else if (i==2){
                town.setDisable(false);
                townLock.setVisible(false);
            }
            else if (i==3){
                caves.setDisable(false);
                cavesLock.setVisible(false);
            }
            else if (i==4){
                mountains.setDisable(false);
                mountainsLock.setVisible(false);
            }
        }
    }

    public void cavesMap(MouseEvent mouseEvent) {
        motor.showCaves(mouseEvent);
    }

    public void forestMap(MouseEvent mouseEvent) {
        motor.showPantallaBosque(mouseEvent);
    }

    public void plainsMap(MouseEvent mouseEvent) {
        motor.showPlainsScene(mouseEvent);
    }

    public void beachMap(MouseEvent mouseEvent) {
        motor.showBeachScene(mouseEvent);
    }

    public void mountainsMap(MouseEvent mouseEvent) {
        motor.showMountains(mouseEvent);
    }

    public void townMap(MouseEvent mouseEvent) {
        motor.showTownScene(mouseEvent);
    }

    public void showLockedAreasMessage(MouseEvent mouseEvent) {
        lockedAreasPopUp.setVisible(true);
        Timer timer = new Timer();
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                lockedAreasPopUp.setVisible(false);
            }
        };
        timer.schedule(tarea, 3000);

    }
}
