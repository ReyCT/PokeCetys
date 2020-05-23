package ViewControllers;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

public class mainScreen {
    private Motor motor;
    private String area;
    @FXML
    private ImageView noFileFound;

    public mainScreen(){

    }
    public void receiveMotorInstance(Motor m){
        this.motor = m;
    }
    public void loadGameButton(MouseEvent mouseEvent) {
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("C:\\Users\\reyna\\Documents\\Tareas CETYS\\metodos de programacion\\Code\\PokemonProject\\saved_file.csv"));

            String row;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                if (data[0].equals("PlayerInfo")) {
                    motor.setUserName(data[1]);
                    motor.setGender(data[2]);
                    motor.setLosses(Integer.parseInt(data[3]));
                    motor.setCoins(Integer.parseInt(data[4]));
                    motor.setUsrPokeballs(Integer.parseInt(data[5]));
                    motor.setUsrHeals(Integer.parseInt(data[6]));
                    area = (data[7]);
                } else if (data[0].equals("PokemonInfo")) {
                    int h = 0;

                    for (int i = 0; i < (data.length - 1) / 11; i++) {

                        pokemon poke = new pokemon();
                        motor.getBeltPokemon().add(poke);
                        motor.getBeltPokemon().set(i, motor.getPokemonByName(data[1 + h]));
                        motor.getBeltPokemon().get(i).setNivel(Integer.parseInt(data[8 + h]));
                        motor.getBeltPokemon().get(i).setExp(Double.parseDouble(data[11]));
                        h = h + 11;
                    }
                } else if (data[0].equals("Medals")) {
                    for (int m = 1; m < data.length; m++) {
                        motor.getMedalsList().add(data[m]);
                    }
                }
            }
            if (area.equals("1")) {
                motor.showPantallaBosque(mouseEvent);
            } else if (area.equals("2")) {
                motor.showPlainsScene(mouseEvent);
            } else if (area.equals("3")) {
                motor.showBeachScene(mouseEvent);
            } else if (area.equals("4")) {
                motor.showTownScene(mouseEvent);
            } else if (area.equals("5")) {
                motor.showCaves(mouseEvent);
            } else if (area.equals("6")) {
                motor.showMountains(mouseEvent);
            }
            csvReader.close();
        } catch (IOException e){
            noFileFound.setVisible(true);
            System.out.println("No file found "+e);

            Timer timer = new Timer();
            TimerTask tarea = new TimerTask() {
                @Override
                public void run() {
                    noFileFound.setVisible(false);
                }
            };
            timer.schedule(tarea, 1500);
        }
    }
    public void newGameButton(MouseEvent mouseEvent) {
        motor.showPantallaInicial(mouseEvent);
    }
}
