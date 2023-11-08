package views;

import controllers.ContentController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class BookIndexView extends StackPane {
    ContentController controller;
    MainGameView book;

    Button btnPlay = new Button("Play");
    Button btnInfiniMode = new Button("Infinity Mode");
    Button btnOptions = new Button("Options");
    Button btnQuit = new Button("Close");



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








}
