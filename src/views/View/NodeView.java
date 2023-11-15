package views.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.system.Game;
import model.system.Save;
import model.system.nodeSyst.ChanceNode;
import model.system.nodeSyst.DecisionNode;
import model.system.nodeSyst.Node;
import model.system.nodeSyst.TerminalNode;
import views.Animations.ImageAnimated;
import views.MainGameView;
import views.Media.BookContent;

import java.util.ArrayList;
import java.util.List;

public class NodeView {
    StackPane rightPage;
    StackPane leftPage;


    Image default_img;
    MainGameView book;

    Button btnB;
    Button btnF;

    int currentInnerIndex = -1;
    int saveIndex = -1;

    Save<Node> history;

    ImageView current;


    public NodeView(Node root, MainGameView book){

        default_img = new Image("file:src/res/D.png");

        rightPage = book.getRightPage();
        leftPage = book.getLeftPage();


        StackPane.setMargin(leftPage, new Insets(-54, 0, 0, 240));



        this.book = book;
        btnB = new Button("<-");
        btnB.setOnAction(e->Back());
        btnF = new Button("->");
        btnF.setOnAction(e->Forword());
        history = new Save();

        LoadNodeVisualisation(root,true);
    }



    public void LoadNodeVisualisation(Node current,boolean saveNode){
        book.unload();
        book.getDeskContainer().getChildren().remove(book.getCurrent());
        ImageView currentImgV = book.getCurrent();
        ImageAnimated  animL = BookContent.getTurnL();

        animL.setLog(false);

        currentImgV = animL.getImgView();
        currentImgV.setTranslateX(15);
        currentImgV.setTranslateY(-70);
        book.getDeskContainer().getChildren().add(1, currentImgV);
        animL.play();

        animL.setEndAction(()-> {
            book.load();
            leftPage.getChildren().clear();
            rightPage.getChildren().clear();
            ImageView currentImg = new ImageView(default_img);
            VBox rightContent = new VBox(20);

            if (current.getImg() != null) {
                currentImg.setImage(current.getImg());
            }
            Label title = new Label(current.getTitle());
            title.setTextFill(Color.WHITE);

            Label description = new Label(current.getDescription());
            description.setWrapText(true);

            leftPage.getChildren().addAll(currentImg, title);


            if (saveNode) {
                history.AddSavePoint(current);
            }


            if (!(current instanceof TerminalNode)) {

                VBox buttonBox = new VBox(10);

                if (current instanceof DecisionNode) {
                    DecisionNode dCurrent = (DecisionNode) current;
                    for (Node node : dCurrent.getNextNodes()) {
                        Button btn = new Button(node.getTitle());
                        btn.setOnAction(e -> {
                                    ;
                                    LoadNodeVisualisation(node, true);
                                }
                        );

                        buttonBox.getChildren().add(btn);
                    }

                }

                if (current instanceof ChanceNode) {
                    ChanceNode chCurrent = (ChanceNode) current;
                    Button btnNext = new Button("Next");
                    btnNext.setOnAction(e -> LoadNodeVisualisation(chCurrent.chooseNext(), true));
                    buttonBox.getChildren().add(btnNext);

                }
                rightContent.getChildren().add(description);
                buttonBox.setAlignment(Pos.CENTER);
                rightContent.getChildren().add(buttonBox);
            } else {
                rightContent.getChildren().add(description);

            }

            StackPane.setAlignment(title, Pos.BOTTOM_CENTER);
            rightPage.getChildren().add(rightContent);

            if (currentInnerIndex >= 0) {
                StackPane.setAlignment(btnB, Pos.CENTER_LEFT);
                leftPage.getChildren().add(btnB);
            }
            if (saveNode) {
                currentInnerIndex++;
                saveIndex = currentInnerIndex;
            }
            System.err.println("---");
            System.err.println("Save :" + saveIndex);
            System.err.println("Current :" + currentInnerIndex);
        });

    }


    public void Forword(){
        book.unload();
        book.getDeskContainer().getChildren().remove(book.getCurrent());
        ImageView current = book.getCurrent();
        ImageAnimated  animL = BookContent.getTurnL();

        animL.setLog(false);

        current = animL.getImgView();
        current.setTranslateX(15);
        current.setTranslateY(-70);
        book.getDeskContainer().getChildren().add(1, current);
        animL.play();

        saveIndex++;
        if(currentInnerIndex==saveIndex) {

            Node n = history.getSavePoint(saveIndex);

            LoadNodeVisualisation(n,false);

            System.err.println("--- Recent  ---");
            System.err.println("Save :" + saveIndex);
            System.err.println("Current :" + currentInnerIndex);
            System.err.println("------------");
        }
        else{
            animL.setEndAction(()->{
                book.load();
            System.err.println("--- Forward  Old Vers---");
            System.err.println("Save :" + saveIndex);
            System.err.println("Current :" + currentInnerIndex);
            System.err.println("------------");
            Node n = history.getSavePoint(saveIndex);
            LoadFROMHistory(n);
        });
        };

    }




    public void Back(){
        book.unload();
        book.getDeskContainer().getChildren().remove(book.getCurrent());
        current = book.getCurrent();
        ImageAnimated  animR = BookContent.getTurnR();
        animR.setLog(false);
        current = animR.getImgView();
        current.setTranslateX(15);
        current.setTranslateY(-70);
        book.getDeskContainer().getChildren().add(1, current);
        animR.play();

        animR.setEndAction( ()->{
            saveIndex--;
        book.load();
        Node n = history.getSavePoint(saveIndex);
            System.err.println("Save :" + saveIndex);
            System.err.println("Current :" + currentInnerIndex);
        LoadFROMHistory(n);

        });
    }



    public void LoadFROMHistory(Node oldNode){
        leftPage.getChildren().clear();
        rightPage.getChildren().clear();
        ImageView currentImg = new ImageView(default_img);
        ColorAdjust grayscale = new ColorAdjust();
        grayscale.setSaturation(-1);
        currentImg.setEffect(grayscale);


        VBox rightContent = new VBox(20);

        if(oldNode.getImg()!=null){
            currentImg.setImage(oldNode.getImg());
        }
        Label title = new Label(oldNode.getTitle());
        title.setTextFill(Color.WHITE);

        Label description = new Label(oldNode.getDescription());
        description.setWrapText(true);

        leftPage.getChildren().addAll(currentImg,title);

        if(!(oldNode instanceof TerminalNode)){

            VBox buttonBox = new VBox(10);

            if(oldNode instanceof DecisionNode){
                DecisionNode dCurrent = (DecisionNode) oldNode;
                for(Node node : dCurrent.getNextNodes()){
                    Button btn = new Button(node.getTitle());
                    buttonBox.getChildren().add(btn);
                }

            }

            if(oldNode instanceof ChanceNode){
                ChanceNode chCurrent = (ChanceNode) oldNode;
                Button btnNext = new Button("Next");
                buttonBox.getChildren().add(btnNext);
            }

            rightContent.getChildren().add(description);
            buttonBox.setAlignment(Pos.CENTER);
            rightContent.getChildren().add(buttonBox);

        } else {
            rightContent.getChildren().add(description);
        }

        StackPane.setAlignment(title, Pos.BOTTOM_CENTER);
        rightPage.getChildren().add(rightContent);

        StackPane.setAlignment(btnF, Pos.CENTER_RIGHT);
        StackPane.setAlignment(btnB, Pos.CENTER_LEFT);

        if(saveIndex!=0) {
            StackPane.setAlignment(btnB, Pos.CENTER_LEFT);
            leftPage.getChildren().add(btnB);
        }
        rightPage.getChildren().add(btnF);

    }
    public StackPane getLeftPage() {return leftPage;}
    public  StackPane getRightPage(){return rightPage;}


}
