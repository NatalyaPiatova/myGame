
package piatova11;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;


public class Piatova11 extends Application {
private static final int SIZE = 4;
	private static final int FIELD_SIZE_PIXELS = 50;

	private final StringProperty counter = new SimpleStringProperty("0");
	private final Text youWinText = TextBuilder.create().text("Y o u   w i n!        ").visible(false).styleClass("text-big-puzzle").build();

    @Override
    public void start(Stage theStage) {
      
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent ActionEvent) {
//                   Label secondLabel = new Label("sorry,but your game not found");
//              
//                StackPane secondaryLayout = new StackPane();
//                Canvas screen = new Canvas (1920,1080);
//            secondaryLayout.getChildren().add(screen);
// 
//                Scene secondScene = new Scene(secondaryLayout, 230, 100);
//                GraphicsContext gc1 = screen.getGraphicsContext2D();
//                //Image pic = new Image ("fon.jpg");
//                //gc1.drawImage (pic,0,0);
//                //secondaryLayout.getChildren().add(secondLabel);
// 
//                // New window (Stage)
//                Stage newWindow = new Stage();
//                newWindow.setTitle("Second Stage");
//                newWindow.setScene(secondScene);
// 
//                // Set position of second window, related to primary window.
//                newWindow.setX(theStage.getX() + 200);
//                newWindow.setY(theStage.getY() + 100);
//                secondLabel.getStylesheets().add("css/label.css");
//                newWindow.show();
        	final Label counterLabel = LabelBuilder.create().text(String.valueOf(counter.get())).styleClass("text-puzzle").layoutX(120).layoutY(20).build();
		counterLabel.textProperty().bind(counter);
		
		BorderPane borderPane = new BorderPane();

		Pane headerPane = new Pane();
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);
		hbox.getChildren().add(TextBuilder.create().text("Counter:").styleClass("text-puzzle").x(50).y(20).build());
		hbox.getChildren().add(counterLabel);
		headerPane.getChildren().add(hbox);

		VBox vBoxLeft = new VBox();
		vBoxLeft.setPadding(new Insets(15, 20, 15, 20));
		vBoxLeft.setSpacing(10);
		VBox vBoxRight = new VBox();
		vBoxRight.setPadding(new Insets(15, 20, 15, 20));
		vBoxRight.setSpacing(10);

		final Pane gamePane = new Pane();
		init(gamePane, new PuzzleModel(SIZE));

		AnchorPane anchorpane = new AnchorPane();
	    Button buttonReset = ButtonBuilder.create()
	    		.text("Reset")
	    	.styleClass("css/puzzle.css")
	    		.onAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						gamePane.getChildren().clear();
						counter.set("0");
						init(gamePane, new PuzzleModel(SIZE));
						youWinText.setVisible(false);
					}
				})
	    		.build();
	
	    HBox buttonBox = new HBox();
	    buttonBox.setPadding(new Insets(0, 10, 10, 10));
	    buttonBox.setSpacing(10);
	    buttonBox.getChildren().add(youWinText);
	    buttonBox.getChildren().add(buttonReset);
	    
	    AnchorPane.setBottomAnchor(buttonBox, 8.0);
	    AnchorPane.setRightAnchor(buttonBox, 5.0);
		anchorpane.getChildren().add(buttonBox);	    
		
		borderPane.setTop(headerPane);
		borderPane.setCenter(gamePane);
		borderPane.setLeft(vBoxLeft);
		borderPane.setRight(vBoxRight);
		borderPane.setBottom(anchorpane);
                 StackPane secondaryLayout = new StackPane();
              	Scene scene = new Scene(borderPane, 400*1.4, 260*1.4);
				 Stage newWindow = new Stage();
		newWindow.setTitle("Second Stage");
                newWindow.setScene(scene);
 
                // Set position of second window, related to primary window.
                newWindow.setX(theStage.getX() + 200);
                newWindow.setY(theStage.getY() + 100);
               
                newWindow.show();
            
            }
            
        });
      
        theStage.setTitle("Понивиль");
        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(1000, 900);
        root.getChildren().add(canvas);

        
        btn.setText("В ПУТЬ!");
       
        btn.relocate(600, 350);
          Button Help = new Button();
        Help.setText("Справка");
        
        Help.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
             Label secondLabel = new Label("Всем привет на данный момент моя игра работает не корректно\n"
             +"как только мы разберемся с файлом css игра будет предоставлена я нормальном виде"
             );
              
                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(secondLabel);
 
                Scene secondScene = new Scene(secondaryLayout, 800, 130);
 
                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Second Stage");
                newWindow.setScene(secondScene);
 
                // Set position of second window, related to primary window.
                newWindow.setX(theStage.getX() + 200);
                newWindow.setY(theStage.getY() + 100);
                secondLabel.getStylesheets().add("css/ButtonStyle2.css");
            
                newWindow.show();
            }
        });
       root.getChildren().add(Help);
       Help.relocate(750, 350);
        Button exit = new Button();
        exit.setText("Выход");
        exit.setOnAction(new EventHandler<ActionEvent>() {
         
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) exit.getScene().getWindow();
                stage.close();
            }
        });
        root.getChildren().add(exit);
        exit.relocate(900, 350);
        // btn.setBackground(Background.EMPTY);
        root.getChildren().add(btn);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.PINK);
        gc.setStroke(Color.PURPLE);
        gc.setLineWidth(2);
        Font theFont = Font.font("French Script MT", FontWeight.BOLD , 48);
        gc.setFont(theFont);
        Image pic2 = new Image("fon.jpg");
        gc.drawImage(pic2, 0, 0);
        gc.fillText("Понивиль", 300, 100);
        gc.strokeText("Понивиль", 300, 100);
        Image pic1 = new Image("pony4.png");
        Image pic4 = new Image("pony5.png");
        Image pic3 = new Image("pony6.png");

        gc.drawImage(pic1, 30, 370);
        gc.drawImage(pic4, 400, 250);
        gc.drawImage(pic3, 550, 550);
        gc.setFill(Color.GREY);
        gc.setLineWidth(2);
        root.getStylesheets().add("css/buttonStyles.css");
        Font in = Font.font("Times New Roman", FontWeight.BOLD, 18);
        gc.setFont(in);
        gc.fillText("©ПЯТОВА НАТАЛЬЯ ФМФИ-б18ПИо", 550, 870);
        theStage.show();
    }
public void init(Pane pane, final PuzzleModel model) {
		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				PuzzleFieldStyle expectedColor = model.getExpectedColorAt(x, y);
				if (expectedColor != null) {
					final Rectangle recExpected = RectangleBuilder.create().x(FIELD_SIZE_PIXELS * x + 280).y(FIELD_SIZE_PIXELS * y).width(FIELD_SIZE_PIXELS).height(FIELD_SIZE_PIXELS).styleClass(expectedColor.getStyle()).build();
					pane.getChildren().add(recExpected);
				}

				PuzzleFieldStyle color = model.getColorAt(x, y);
				if (color != null) {
					final Rectangle rec = RectangleBuilder.create().x(FIELD_SIZE_PIXELS * x).y(FIELD_SIZE_PIXELS * y).width(FIELD_SIZE_PIXELS).height(FIELD_SIZE_PIXELS).styleClass(color.getStyle()).build();
					pane.getChildren().add(rec);

					rec.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							Point moveFromPoint = new Point((int) rec.getX() / FIELD_SIZE_PIXELS, (int) rec.getY() / FIELD_SIZE_PIXELS);
							Point moveToPoint = model.moveToEmptyField(moveFromPoint);
							if (moveToPoint != null) {
								// Increase the counter
								counter.set(String.valueOf(Integer.parseInt(counter.get())+1));
								moveRectangle(moveToPoint, rec);
								model.printBoards();
								if (model.areBoardsEqual()) {
									youWinText.setVisible(true);
								}
							}
						}
					});
				}
			}

		}
		
	}
	
	private void moveRectangle(final Point moveToPoint, final Rectangle rec) {
		rec.setX(moveToPoint.getX() * FIELD_SIZE_PIXELS);
		rec.setY(moveToPoint.getY() * FIELD_SIZE_PIXELS);
	}

	public static void main(String[] args) {
		launch(args);
	}
	

}
