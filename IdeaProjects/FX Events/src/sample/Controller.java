package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class Controller {
    @FXML
    private TextField nameField;
    @FXML
    private Button helloButton;
    @FXML
    private Button byeButton;
    @FXML
    private CheckBox ourCheckBox;
    @FXML
    private Label ourLabel;

    @FXML
    public void initialize(){
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    public void onButtonCLicked(ActionEvent e){
        if(e.getSource().equals(helloButton)){
            System.out.println("Hello " + nameField.getText());
        }else if(e.getSource().equals(byeButton)){
            System.out.println("Bye " + nameField.getText());
        }

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try{
                    String s= Platform.isFxApplicationThread()? "Ui Thread" : "Background Thread";
                    System.out.println("I'm going to sleep " + s);
                    Thread.sleep(10000);
                    Platform.runLater(new Runnable() {
                        @Override//Para hacer algo mientras el programa corre sin molestarlo
                        public void run() {
                            String s= Platform.isFxApplicationThread()? "Ui Thread" : "Background Thread";
                            System.out.println("I'm going to sleep " + s);
                            ourLabel.setText("We did something!");
                        }
                    });
                }catch (InterruptedException event){
                    //we don't care about this now
                }
            }
        };
//        try{
//            Thread.sleep(10000);
//        }catch (InterruptedException event){
//            //we don't care about this now
//        }
        new Thread(task).start();

        if(ourCheckBox.isSelected()){
            nameField.clear();
            helloButton.setDisable(true);
            byeButton.setDisable(true);
        }
        System.out.println("Following button was pressed " + e.getSource());
    }

    @FXML
    public void handleKeyReleased(){
        String text=nameField.getText();
        boolean disableButtons= text.isEmpty() || text.trim().isEmpty();// So it disables when adding just spaces
        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }

    @FXML
    public void handleChange(){
        System.out.println("the checkbox is " + (ourCheckBox.isSelected()? "checked" : "not checked"));
    }

}
