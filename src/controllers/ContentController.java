package controllers;

import views.BookIndexView;
import views.ImageAnimated;
import views.MainGameView;

public class ContentController {
    private MainGameView view;
    private BookIndexView index;


    public void openBtnBook(ImageAnimated img){
        img.play();
        view.OpenBook();
        System.out.println("[ Ref view " + System.identityHashCode(view)+ " ]");
    }



    public void setView(MainGameView view) {
        this.view = view;
        System.out.println("----> View set<-----");
    }



}
