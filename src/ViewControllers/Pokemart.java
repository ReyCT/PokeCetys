package ViewControllers;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Pokemart {
    private Motor motor;
    @FXML
    private Label userMoneyLabel;
    @FXML
    private Label itemDescription;
    @FXML
    private ImageView pokemartItemImg;
    @FXML
    private ImageView pokebolaArrowImg;
    @FXML
    private ImageView healsArrowImg;
    @FXML
    private Group ticketGroup;
    @FXML
    private Label ticketText;

    private String selectedItem=" ";
    private int coins;

    public void receiveMotorInstance(Motor m){
        this.motor = m;
        userMoneyLabel.setText("$"+motor.getCoins());
        coins = motor.getCoins();
    }

    public void selectPokeball(MouseEvent mouseEvent) {
        /**
         * method for every pokeball selection related action
         */
        selectedItem = "pokeball";
        healsArrowImg.setVisible(false);
        pokebolaArrowImg.setVisible(true);
        Image pokeballImg = new Image("/Images/pokemartItems/pokeball.png");
        pokemartItemImg.setImage(pokeballImg);
        itemDescription.setText("lets you catch more pokemons!");
    }

    public void selectHeals(MouseEvent mouseEvent) {
        /**
         * method for every poison selection related action
         */
        selectedItem = "heals";
        healsArrowImg.setVisible(true);
        pokebolaArrowImg.setVisible(false);
        Image posionImg = new Image("/Images/pokemartItems/heals.png");
        pokemartItemImg.setImage(posionImg);
        itemDescription.setText("heals pokemon 1x while fighting");
    }

    public void buyPokemartItem(MouseEvent mouseEvent) {
        /**
         * buy objects method, validates if player has enough coins and refreshes user coins data
         */

        System.out.println(selectedItem);
        if (selectedItem.equals(" ")){
            itemDescription.setText("choose an item to buy!");
        }
        else if (selectedItem.equals("pokeball") && coins>=5){
            coins = coins-5;
            motor.setCoins(coins);
            motor.setUsrPokeballs(motor.getUsrPokeballs()+1);
            userMoneyLabel.setText("$"+coins);
            ticketGroup.setVisible(true);
            ticketText.setText("You bought 1 "+selectedItem);
        }
        else if (selectedItem.equals("heals") && coins>=10){
            coins = coins-10;
            motor.setCoins(coins);
            motor.setUsrHeals(motor.getUsrHeals()+1);
            userMoneyLabel.setText("$"+coins);
            ticketGroup.setVisible(true);
            ticketText.setText("You bought 1 healing pot.");
        }
        else{
            itemDescription.setText(" you dont have enough money!");
        }

    }

    public void closeTicket(MouseEvent mouseEvent) {
        ticketGroup.setVisible(false);
    }
}
