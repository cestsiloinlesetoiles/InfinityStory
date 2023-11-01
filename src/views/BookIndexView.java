package views;

import controllers.ContentController;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class BookIndexView extends StackPane {
    ContentController controller;
    MainView book;
    public BookIndexView(ContentController controller, MainView view){
        this.controller = controller;
        this.book = view;
    }


    public void LoadMenuBook(){
        VBox menu = new VBox(15);
        Button btnPlay = new Button("Play");
        Button btnInfiniMode = new Button("InfinityMode");
        Button btnOptions = new Button("Options");
        Button btnQuit = new Button("Quitter");
        menu.getChildren().addAll(btnPlay, btnInfiniMode, btnOptions, btnQuit);
        book.loadContentRPage(menu);

    }




}
