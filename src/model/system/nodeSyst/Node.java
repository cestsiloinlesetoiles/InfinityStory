package model.system.nodeSyst;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Node {
    private String title;
    private String description;
    private int id;
    private Image img;

    public Node(String t, String d, int i) {
        this.title = t;
        this.description = d;
        this.id = i;
    }




    public String getDescription() {
        return description;
    }



    public int getId() {
        return id;
    }

    //end getters

    public void display(){

        System.out.println(this.description);

    }

    public abstract Node chooseNext();

    public void setImg(String path){
        img = new Image(path);
    }

    public Image getImg() {
        return img;
    }

    public String getTitle(){
        return title;
    }
}

