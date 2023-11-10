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
    private Button btnPlay = new Button("Play - Version Test Uniquement Buger pas regler probleme d'animation");

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
        btnPlay.setOnAction(e -> { LoadNodeVisualisation(TestStory());});
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

        StackPane imgPane = new StackPane();
        imgPane.getChildren().add(imgView);

        if (n instanceof DecisionNode) {
            DecisionNode current = (DecisionNode) n;
            VBox choice = new VBox(15);
            Label descriptionLabel = new Label(current.getDescription());
            choice.getChildren().add(descriptionLabel);
            for (Node nodeN : current.getNextNodes()) {
                Button nodeButton = new Button(nodeN.getDescription());
                nodeButton.setOnAction(e -> {
                    LoadNodeVisualisation(nodeN);
                });
                choice.getChildren().add(nodeButton);
            }
            book.turnPageL(imgPane, choice);
        } else if (n instanceof ChanceNode) {
            // Programmation Avenir
        } else {
            ;
            TerminalNode terminalNode = (TerminalNode) n;
            Label terminalLabel = new Label(terminalNode.getDescription());
            book.turnPageL(imgPane, new VBox(terminalLabel));
        }
    }


    public Node TestStory(){
            // Niveau 0
            DecisionNode root = new DecisionNode("Niveau 0 - Racine", 0);

            // Niveau 1
            DecisionNode node1a = new DecisionNode("Niveau 1 - Branche a", 1);
            DecisionNode node1b = new DecisionNode("Niveau 1 - Branche b", 2);
            DecisionNode node1c = new DecisionNode("Niveau 1 - Branche c", 3);


            root.fillNextNode(node1a);
            root.fillNextNode(node1b);
            root.fillNextNode(node1c);

            // Niveau 2
            DecisionNode node2a = new DecisionNode("Niveau 2 - Branche a", 4);
            DecisionNode node2b = new DecisionNode("Niveau 2 - Branche b", 5);
            DecisionNode node2c = new DecisionNode("Niveau 2 - Branche c", 6);


            node1a.fillNextNode(node2a);
            node1b.fillNextNode(node2b);
            node1c.fillNextNode(node2c);


            // Niveau 3 => Terminal
            TerminalNode node3a = new TerminalNode("Niveau 3 - Branche a", 13);
            TerminalNode node3b = new TerminalNode("Niveau 3 - Branche b", 14);
            TerminalNode node3c = new TerminalNode("Niveau 3 - Branche c", 15);


            node2a.fillNextNode(node3a);
            node2b.fillNextNode(node3b);
            node2c.fillNextNode(node3c);
            Node  current = root;
            return current;

        }

    }







