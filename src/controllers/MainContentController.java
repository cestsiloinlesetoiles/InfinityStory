package controllers;

import views.BookIndexView;
import views.Animations.ImageAnimated;
import views.MainGameView;

public class MainContentController {
    private MainGameView view;
    private BookIndexView index;

    private NodeViewController nodeViewController;


    public MainContentController(){
        nodeViewController = new NodeViewController();
    }
    public void openBtnBook(ImageAnimated img){
        img.play();
        view.OpenBook();
        System.out.println("[ Ref view " + System.identityHashCode(view)+ " ]");
    }



    public void setView(MainGameView view) {
        this.view = view;
        System.out.println("----> View set<-----");
    }


    public NodeViewController getNodeViewController() {
        return nodeViewController;
    }
}
