package hellofx;


import java.io.InputStream;
import java.util.ArrayList;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CollisionRectanglesColor extends Application {

	
	private static final double W = 400, H = 400;
    private static final double S = 50;
    
    private ArrayList<Button> nodes;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("L E T' S   L E A R N !");
        
        Class<?> clazz = this.getClass();
        
        //let's create a border pane for the window
        BorderPane root = new BorderPane();        
        root.getStyleClass().add("root"); // external css for decoration of the window
        
        
        //let's add a flow plane inside the border pane 
        FlowPane flow = new FlowPane();//create the flow pane
        flow.setAlignment(Pos.CENTER); //align pane to center
        flow.setOrientation(Orientation.VERTICAL); // items aligned vertical
        flow.setPadding(new Insets(5, 0, 5, 0)); //padding between items
        flow.setColumnHalignment(HPos.CENTER); //pust individual items aligned center


        Text scenetitle = new Text("LET'S  LEARN !");//creates our big text
        scenetitle.setId("welcome-text"); //css ID for style the text
        
        //let's add the button
        Button btn = new Button();
        btn.setId("button2");
        Text message = new Text();   
        btn.setText("EMPEZAR");        
        btn.setPrefSize(200, 60);     
        
        
        //let's put the text and button inside our flow pane
        flow.getChildren().add(scenetitle);
        flow.getChildren().add(btn); 
        
        //let's put or flow pane in the center of the window
        root.setCenter(flow);
        
                
        //let's create our game base window
        Scene scene = new Scene(root, 900, 600);
        scene.getStylesheets().add("MyStyles.css");//location of our css for styling
    
   
        primaryStage.setScene(scene);    
        primaryStage.show();
        
        
        //-----------------------------------------------------------second window-------------------------------------------
        
        //after teh button is presseed it take us to the second window
        btn.setOnAction(e ->{ 
        	primaryStage.close();//to close the first window
        	
        	
        	//let's create our second window	
        
        	BorderPane root2 = new BorderPane();
        	root2.setId("anchorP"); //css
            
        	
        	
        	
        	//let's add our top panel
        	HBox hbox = new HBox(); 
//        	hbox.setId("topP"); //css
        	hbox.setPadding(new Insets(15, 15, 15, 15));
            hbox.setSpacing(10);
            hbox.setStyle("-fx-background-color: #336699;");
            
            //let's add our menu items to the top panel            
            Label label = new Label("NIVEL: 1          ");
            Label label2 = new Label("PUNTOS:  50/500          ");
            Label label3 = new Label("PALABRAS RESTANTES: 50          ");
            Label label4 = new Label("VELOCIDAD:  2X          ");            
        		
            hbox.getChildren().addAll(label,label2, label3, label4);	
            
            
            
            
            
            
            //let's create our right panel            
            VBox vbox = new VBox();
            vbox.setId("anchorP"); //css
            vbox.setPadding(new Insets(0));
            vbox.setSpacing(50); //space betwee buttons
            vbox.setAlignment(Pos.BASELINE_CENTER);
            //logo
            InputStream logoR = clazz.getResourceAsStream("/images/Logo_lets_learn.png");                     
            Image imageLr = new Image(logoR, 150, 150, false, false);
            ImageView logoRView = new ImageView(imageLr);
            
            //buttos            
            Button buttonPista = new Button("PISTA");
            buttonPista.setPrefSize(100, 30);

            Button buttonPausa = new Button("PAUSA");
            buttonPausa.setPrefSize(100, 30);
            
            Button buttonTerminar = new Button("TERMINAR");
            buttonTerminar.setPrefSize(100, 30);            
             //arrows           
            InputStream leftArrow = clazz.getResourceAsStream("/images/left-arrow.png");                     
            Image imageLeftArrow = new Image(leftArrow, 30, 30, false, false);
            ImageView leftArrowView = new ImageView(imageLeftArrow);
            
            InputStream rightArrow = clazz.getResourceAsStream("/images/right-arrow.png");                     
            Image imageRightArrow = new Image(rightArrow, 30, 30, false, false);
            ImageView rightArrowView = new ImageView(imageRightArrow);
            
            Button bleftArrow = new Button("",leftArrowView);
            Button brightArrow = new Button("", rightArrowView);
            //logo box
            HBox logobox =new HBox();
            logobox.setPadding(new Insets(0, 0, 0, 0));
            logobox.setSpacing(0);//space between images
            logobox.setStyle("-fx-background-color: #fadced;");
            logobox.setAlignment(Pos.BASELINE_CENTER);
            logobox.getChildren().add(logoRView);
            //small box for arrows
            HBox smallbox =new HBox();
            smallbox.setPadding(new Insets(0, 0, 0, 0));
            smallbox.setSpacing(40);//space between images
            smallbox.setAlignment(Pos.BASELINE_CENTER);
            smallbox.getChildren().addAll(bleftArrow, brightArrow);
            
            
            vbox.getChildren().addAll(logoRView, buttonPista, buttonPausa, buttonTerminar, smallbox);
            
            
            
                       
          
            
            //let's create our center panel for the game
            AnchorPane anchor = new AnchorPane(); 
            nodes = new ArrayList<Button>();
            //images
            InputStream ipais = clazz.getResourceAsStream("/images/country.png");                     
            Image imagePais = new Image(ipais, 70, 70, false, false);
            ImageView paisView = new ImageView(imagePais);
            
            InputStream iplan = clazz.getResourceAsStream("/images/planet.png");
            Image imagePlan = new Image(iplan, 70, 70, false, false);
            ImageView planView = new ImageView(imagePlan);
                        
            InputStream iciud = clazz.getResourceAsStream("/images/city.png");
            Image imageCiud = new Image(iciud, 70, 70, false, false);
            ImageView ciudView = new ImageView(imageCiud);
                        
             InputStream icont = clazz.getResourceAsStream("/images/continent.png");
            Image imageCont = new Image(icont, 70, 70, false, false);
            ImageView contView = new ImageView(imageCont);
            
 
            nodes.add(new Button("PAIS", paisView));
            nodes.add(new Button("PLANETA", planView));
            nodes.add(new Button("CIUDAD", ciudView));
            nodes.add(new Button("CONTINENTE", contView));
            for (Button block : nodes) {
                setDragListeners(block);
              }
            
      
                
            //creating rectangle with its dimensions
            Text text = new Text();
            text.setText("TIMBUKTU");
            Rectangle rectangle = new Rectangle(W / 2 - S / 2,H / 2 - S / 2,S,S);
    
            //transition event handler lamba format       
            TranslateTransition transition = new TranslateTransition(Duration.millis(500), rectangle);
            transition.setOnFinished(t -> {
                rectangle.setX(rectangle.getTranslateX() + rectangle.getX());
                rectangle.setY(rectangle.getTranslateY() + rectangle.getY());
                rectangle.setTranslateX(0);
                rectangle.setTranslateY(0);
            });

             //even handle after the click.
            anchor.setOnMousePressed(new EventHandler<MouseEvent>() {
               @Override
            	public void handle(MouseEvent e) {
                transition.stop();
                transition.setToX(e.getX() - S / 2 - rectangle.getX());
                transition.setToY(e.getY() - S / 2 - rectangle.getY());
                transition.playFromStart();
                
               }
            });
                      
            
                         
            //contains the node elements
            anchor.getChildren().addAll(nodes);   
            checkShapeIntersection(nodes.get(nodes.size() - 1));

           
            //contains everything                                      		
            root2.setTop(hbox);
            root2.setRight(vbox);
            root2.setCenter(anchor);
  
                               
               
            Scene secondScene = new Scene(root2, 900,600);                
            secondScene.getStylesheets().add("MyStyles.css");//location of our css for styling               
            Stage secondStage = new Stage();
                
            secondStage.setScene(secondScene); // set the second scene                
            secondStage.setTitle("L E T' S  L E A R N !");
                
            secondStage.show();
            primaryStage.close(); // close the first stage (Window)
                

        });
    }
    //metodo para hacer los items se puedan arrastar con el mouse
    //event handler for mouse drag.
    public void setDragListeners(final Button block) {
        final Delta dragDelta = new Delta();
        
        block.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
              // record a delta distance for the drag and drop operation.
              dragDelta.x = block.getLayoutX() - mouseEvent.getSceneX();
              dragDelta.y = block.getLayoutY() - mouseEvent.getSceneY();
              block.setCursor(Cursor.NONE);
            }
          });
          block.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
              block.setCursor(Cursor.HAND);
            }
          });
          block.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
              block.setLayoutX(mouseEvent.getSceneX() + dragDelta.x);
              block.setLayoutY(mouseEvent.getSceneY() + dragDelta.y);
              checkShapeIntersection(block);
            }
          });
        }

    
    
    //Metodo para detectar colision entre los elementos
    private void checkShapeIntersection(Button block) {
    	boolean collisionDetected = false;
    	  for (Button static_bloc : nodes) {
    	    if (static_bloc != block) {
    	      static_bloc.setTextFill(Color.GREEN);

    	      if (block.getBoundsInParent().intersects(static_bloc.getBoundsInParent())) {
    	        collisionDetected = true;
    	      }
    	    }
    	  }

        if (collisionDetected) {
          block.setTextFill(Color.BLUE);
        } else {
          block.setTextFill(Color.GREEN);
        }
      }

      class Delta { double x, y; }
    


	public static void main(String[] args) {
        launch(args);
    }
       
}
   