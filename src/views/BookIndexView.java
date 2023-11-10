package views;

import controllers.ContentController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.system.nodeSyst.ChanceNode;
import model.system.nodeSyst.DecisionNode;
import model.system.nodeSyst.Node;
import model.system.nodeSyst.TerminalNode;

public class BookIndexView extends StackPane {
    private ContentController controller;
    private MainGameView book;

    private Image default_img = new Image("file:src/res/D.png");
    private Button btnPlay = new Button("Play - Version Test Uniquement");
    private Button btnInfiniMode = new Button("Infinity Mode - Pas dispo");
    private Button btnOptions = new Button("Options -  Pas dispo");
    private Button btnQuit = new Button("Close - Pas dispo ");




    public BookIndexView(ContentController controller, MainGameView view){
        this.controller = controller;
        this.book = view;
    }


    public void LoadMenuBook(){
        StackPane page = new StackPane();
        VBox menu = new VBox(15);
        menu.getChildren().addAll(btnPlay, btnInfiniMode, btnOptions, btnQuit);
        page.getChildren().add(menu);
        menu.setAlignment(Pos.CENTER);
        StackPane.setAlignment(menu, Pos.CENTER);
        book.disppearContentPage();
        book.loadContentRPage(page);

    }

    public void LoadNodeVisualisation(Node n) {

            ImageView imgView = new ImageView(default_img);

            if (n.getImg() != null) {
                imgView = new ImageView(n.getImg());
            }

            StackPane ImgPane = new StackPane();
            ImgPane.getChildren().add(imgView);

            if (n instanceof DecisionNode) {
                DecisionNode current = (DecisionNode) n;
                VBox choice = new VBox(15);
                Label descriptionLabel = new Label(current.getDescription());
                choice.getChildren().add(descriptionLabel);
                for(Node nodeN : current.getNextNodes()){
                    Button nodeButton = new Button(nodeN.getDescription());
                    nodeButton.setOnAction(e->{ LoadNodeVisualisation(nodeN); });
                    choice.getChildren().add(nodeButton);
                }
                book.turnPageR(ImgPane,choice);
            } else if (n instanceof ChanceNode) {
                
            }


    }






}
