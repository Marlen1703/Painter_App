package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class PainterController {
    private enum PenSize{
        SMALL(2),
        MEDIUM(4),
        LARGE(6);
        final int radius;


        PenSize(int radius) {
            this.radius = radius;
        }
        public  int getRadius(){
            return radius;
        }
    }
    @FXML
    private RadioButton BlackColor;
    @FXML
    private ToggleGroup colorToggleGroup;
    @FXML
    private RadioButton RedColor;
    @FXML
    private RadioButton GreenColor;
    @FXML
    private RadioButton BlueColor;
    @FXML
    private RadioButton Small_size;
    @FXML
    private ToggleGroup sizeToggleGroup;
    @FXML
    private RadioButton Medium_size;
    @FXML
    private RadioButton Large_size;
    @FXML
    private Button undo;
    @FXML
    private Button clear;
    @FXML
    private Pane drawingAreaPane;
    private PenSize radius=PenSize.MEDIUM;
    private Paint brushColor=Color.BLACK;
    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void colorRadioButtonSelected(ActionEvent event) {
        brushColor=(Color)colorToggleGroup.getSelectedToggle().getUserData();

    }



    @FXML
    void sizeRadioButtonSelected(ActionEvent event) {
        radius=(PenSize) sizeToggleGroup.getSelectedToggle().getUserData();

    }

    @FXML
    void undoButtonPressed(ActionEvent event) {
        int count=drawingAreaPane.getChildren().size();
        if(count>0){
            drawingAreaPane.getChildren().remove(count-1);
        }

    }
    public void initialize(){
        BlackColor.setUserData(Color.BLACK);
         RedColor.setUserData(Color.RED);
         GreenColor.setUserData(Color.GREEN);
         BlueColor.setUserData(Color.BLUE);
         Small_size.setUserData(PenSize.SMALL);
         Medium_size.setUserData(PenSize.MEDIUM);
         Large_size.setUserData(PenSize.LARGE);



    }
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle circle=new Circle(event.getX(),event.getY(),radius.getRadius(),brushColor);
        drawingAreaPane.getChildren().add(circle);
    }

}
