package views.view;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import views.Book;



public class BookPage {
    private Pane leftPage;
    private Pane rightPage;


    public BookPage(String s){
        leftPage = new Pane();
         rightPage = new Pane();
        Label label = new Label(s);
        getLeftPage().getChildren().add(label);

    }


    public Pane getLeftPage() {
        return leftPage;
    }

    public Pane getRightPage(){
        return  rightPage;
    }
}
