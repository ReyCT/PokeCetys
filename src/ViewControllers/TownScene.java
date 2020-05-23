package ViewControllers;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TownScene {

    private Motor motor;
    @FXML
    private ImageView noPokemonsWarning;
    @FXML
    private Group saveGroup;

    public void receiveMotorInstance(Motor m){
        this.motor = m;
    }

    public void enterGymButton(MouseEvent event) {
        motor.showGymFight(event);
    }

    public void enterPokemartButton(MouseEvent event) {
        motor.showPokemart(event);
    }

    public void startWildFight(MouseEvent event) {
        Random random = new Random();

        int probability = random.nextInt(2);
        if (probability!=1) {
            motor.showWildFight(event);
            System.out.println(probability);
        } else {
            noPokemonsWarning.setVisible(true);
            Timer timer = new Timer();
            TimerTask tarea = new TimerTask() {
                @Override
                public void run() {
                    noPokemonsWarning.setVisible(false);
                    timer.cancel();
                }
            };
            timer.schedule(tarea,3000);
        }
    }

    public void openMapButton(MouseEvent event) {
        motor.showMap(event);
    }

    public void showPokedex(MouseEvent mouseEvent) {
        motor.showPokedex(mouseEvent);
    }

    public void saveFile(MouseEvent mouseEvent) {
        saveGroup.setVisible(true);
    }

    public void saveProgress(MouseEvent mouseEvent) {
        try {
            FileWriter csvWriter = new FileWriter("saved_file.csv");

            csvWriter.append("PlayerInfo");
            csvWriter.append(",");
            csvWriter.append(motor.getUserName());
            csvWriter.append(",");
            csvWriter.append(motor.getGender());
            csvWriter.append(",");
            csvWriter.append(motor.getLosses() + "");
            csvWriter.append(",");
            csvWriter.append(motor.getCoins() + "");
            csvWriter.append(",");
            csvWriter.append(motor.getUsrPokeballs() + "");
            csvWriter.append(",");
            csvWriter.append(motor.getUsrHeals() + "");
            csvWriter.append(",");
            csvWriter.append(motor.getArea() + "");
            csvWriter.append(",");
            csvWriter.append("\n");
            csvWriter.append("PokemonInfo");
            csvWriter.append(",");
            for (int i = 0; i < motor.getBeltPokemon().size(); i++) {
                csvWriter.append(motor.getBeltPokemon().get(i).getNombre());
                csvWriter.append(",");
                csvWriter.append(motor.getBeltPokemon().get(i).getTipo());
                csvWriter.append(",");
                if (motor.getBeltPokemon().get(i).getHabilidad1() != null) {
                    csvWriter.append(motor.getBeltPokemon().get(i).getHabilidad1().getNombre());
                    csvWriter.append(",");
                }
                if (motor.getBeltPokemon().get(i).getHabilidad2() != null) {
                    csvWriter.append(motor.getBeltPokemon().get(i).getHabilidad2().getNombre());
                    csvWriter.append(",");
                }
                if (motor.getBeltPokemon().get(i).getHabilidad3() != null) {
                    csvWriter.append(motor.getBeltPokemon().get(i).getHabilidad3().getNombre());
                    csvWriter.append(",");
                } else {
                    csvWriter.append(null);
                    csvWriter.append(",");
                }
                if (motor.getBeltPokemon().get(i).getHabilidad4() != null) {
                    csvWriter.append(motor.getBeltPokemon().get(i).getHabilidad4().getNombre());
                    csvWriter.append(",");
                } else {
                    csvWriter.append(null);
                    csvWriter.append(",");
                }
                csvWriter.append(motor.getBeltPokemon().get(i).getTamaño() + "");
                csvWriter.append(",");
                csvWriter.append(motor.getBeltPokemon().get(i).getNivel() + "");
                csvWriter.append(",");
                csvWriter.append(motor.getBeltPokemon().get(i).getEvolucion() + "");
                csvWriter.append(",");
                csvWriter.append(motor.getBeltPokemon().get(i).getVida() + "");
                csvWriter.append(",");
                csvWriter.append(motor.getBeltPokemon().get(i).getExp() + "");
                csvWriter.append(",");
            }
            csvWriter.append("\n");
            csvWriter.append("Medals");
            csvWriter.append(",");
            for (int j = 0; j < motor.getMedalsList().size(); j++) {
                csvWriter.append(motor.getMedalsList().get(j));
                csvWriter.append(",");
            }
            System.out.println("Saved succesfully");
            csvWriter.flush();
            csvWriter.close();
        } catch(IOException e){
            System.out.println("Save file Error "+e);
        }
        saveGroup.setVisible(false);
    }

    public void closeSaveWarning(MouseEvent mouseEvent) {
        saveGroup.setVisible(false);
    }
}
