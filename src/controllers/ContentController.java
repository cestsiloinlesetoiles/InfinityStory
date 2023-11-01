package controllers;

import views.ImageAnimated;
import views.MainView;

public class ContentController {
    private MainView view;



    public void openBtnBook(ImageAnimated img){
        img.play();
        view.OpenBook();
        System.out.println("[ Ref view " + System.identityHashCode(view)+ " ]");
    }



    public void setView(MainView view) {
        this.view = view;
        System.out.println("----> View set<-----");
    }




}
