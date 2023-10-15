package views;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.geometry.Insets;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import views.view.BookPage;

public class Book extends StackPane {

    BookPage[] pages = {
            new BookPage("Test 1"),
            new BookPage( "Test 2"),
            new BookPage( "Test 3"),
            new BookPage( "Test 4"),
            new BookPage( "Test 5"),
            new BookPage( "Test 6")
    };
    private BookPage p6 = new BookPage("Test 6");

    private ImageAnimated closeImg = new ImageAnimated("src/res/book/animations/close", 150, true,1.4);
    private ImageAnimated openImg = new ImageAnimated("src/res/book/animations/open", 130, true,1.4);
    private ImageAnimated turnR = new ImageAnimated("src/res/book/animations/turn/flipR", 80, true,1.4);

    private ImageAnimated turnL = new ImageAnimated("src/res/book/animations/turn/flipL", 80, true,1.4);


    private  ImageAnimated sideBarAppear = new ImageAnimated("src/res/book/animations/sidetab/appear", 100, true,1.4);
    private  ImageAnimated sideBarDisappear = new ImageAnimated("src/res/book/animations/sidetab/disappear", 100, true,1.4);

    private ImageView current = openImg.getImgView();
    private Button openbtn = new Button("open");
    private Button closebtn = new Button("close");

    private Button turbtnL = new Button("TurnL");
    private Button turbtnR = new Button("TurnR");
    private Pane leftPage = new Pane();
    private Pane rightPage = new Pane();

    private VBox buttonBox;
    private Insets it = new Insets(-220, 0, 0, 30);



    VBox sideBar = new VBox();
    Button button1 = new Button("");

    Button button2 = new Button("");

    Button button3 = new Button("" );

    Button button4 = new Button("" );

    Button button5 = new Button("");

    Button button6 = new Button("" );




    public Book() {

        buttonBox = new VBox(15);
        buttonBox.getChildren().addAll(openbtn, closebtn,turbtnR,turbtnL);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(current, buttonBox);
        openbtn.setOnAction(e -> openBookAnim());
        closebtn.setOnAction(e -> closeBookAnim());
        turbtnL.setOnAction(e -> flipLAnim());
        turbtnR.setOnAction(e -> flipRAmim());
        StackPane.setMargin(current, it);
        InitPageContainer();


        // Parti Vbox

        StackPane.setMargin(sideBar,new Insets(180, 0, 0, 150));;
        InitSideBar();
        loadPageLeftPage(pages[0].getLeftPage());





    }

    public void openBookAnim() {

        // Visual Update
        this.getChildren().remove(current);
        openImg.reset();
        current = openImg.getImgView();
        StackPane.setMargin(current, it);


        // Partie Page
        this.getChildren().add(0, current);
        openImg.play();


        // Assure la bonne apparition de l'image à la fin de l'animation


        openImg.getAnimation().setOnFinished(e-> {

            this.getChildren().addAll(rightPage,leftPage,sideBar);
            System.out.println("Open");
            appearAnim();
        });

    }



    public void closeBookAnim() {
        disAppearAnim();
        // Visual Update
        sideBarDisappear.getAnimation().setOnFinished((e-> {

            this.getChildren().removeAll(rightPage, leftPage);
            this.getChildren().remove(sideBar);
            this.getChildren().remove(current);
            closeImg.reset();
            current = closeImg.getImgView();
            StackPane.setMargin(current, it);
            this.getChildren().add(0, current);
            closeImg.play();
            System.out.println("Book Close");
        }));
    }


    public Pane getRightContent() {
        return rightPage;
    }

    public Pane getLeftContent() {
        return leftPage;
    }

    public void LoadPage(Pane leftContent,Pane righContent){
        rightPage.getChildren().setAll(righContent);
        leftPage.getChildren().setAll(righContent);
    }

    public void loadPageLeftPage(Pane righContent){
        leftPage.getChildren().setAll(righContent);
    }


    public void loadPageRightPage(Pane leftContent){
        rightPage.getChildren().setAll(leftContent);
    }

    public void unload(){
        rightPage.getChildren().clear();
        leftPage.getChildren().clear();
    }


    public void appearAnim(){
        sideBarAppear.reset();
        this.getChildren().remove(current);
        current=sideBarAppear.getImgView();
        this.getChildren().add(0, current);
        StackPane.setMargin(current, it);
        sideBarAppear.play();
        System.out.println("Appear");

    }

    public void disAppearAnim(){
        this.getChildren().remove(current);
        sideBarDisappear.reset();

        current=sideBarDisappear.getImgView();

        this.getChildren().add(0, current);
        StackPane.setMargin(current, it);
        sideBarDisappear.play();
        System.out.println("DisAppear");
    }

    public void flipLAnim(){
        sideBarDisappear.speedAnimation(20);
        disAppearAnim();

        sideBarDisappear.getAnimation().setOnFinished((e-> {
            sideBarDisappear.speedAnimation(150);
            this.getChildren().remove(current);
            turnL.reset();
            current = turnL.getImgView();
            StackPane.setMargin(current, it);
            this.getChildren().add(0, current);
            turnL.play();
            System.out.println("Left");
            turnL.getAnimation().setOnFinished((e2-> {
                sideBarAppear.speedAnimation(50);
                appearAnim();

            }));
            sideBarAppear.speedAnimation(140);
        }));
    }


    public void flipRAmim(){
        this.getChildren().removeAll(rightPage,leftPage,sideBar);
        sideBarDisappear.speedAnimation(50);
        disAppearAnim();
        sideBarDisappear.getAnimation().setOnFinished((e-> {
            sideBarDisappear.speedAnimation(140);
            this.getChildren().remove(current);
            turnR.reset();
            current = turnR.getImgView();
            StackPane.setMargin(current, it);
            this.getChildren().add(0, current);
            turnR.play();
            sideBarAppear.speedAnimation(140);
        }));
    }


    public void InitPageContainer(){
        StackPane.setAlignment(leftPage, Pos.CENTER_LEFT);
        StackPane.setAlignment(rightPage, Pos.CENTER_RIGHT);
        // Rouge
        StackPane.setMargin(leftPage, new Insets(-120, 0, 0, 210));
        // Blue
        StackPane.setMargin(rightPage, new Insets(-120, 230, 0, 0));
        leftPage.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
        rightPage.setStyle("-fx-border-color: blue; -fx-border-width: 2px;");

        leftPage.setMaxSize(380, 480);
        rightPage.setMaxSize(380, 480);
    }

    public void InitSideBar() {
        button1.setOnAction(e -> handlerSidBarClick(1));
        button2.setOnAction(e -> handlerSidBarClick(2));
        button3.setOnAction(e -> handlerSidBarClick(3));
        button4.setOnAction(e -> handlerSidBarClick(4));
        button5.setOnAction(e -> handlerSidBarClick(5));
        button6.setOnAction(e -> handlerSidBarClick(6));

        for (Button btn : new Button[]{button1, button2, button3, button4, button5, button6}) {
            btn.setStyle("-fx-background-color: transparent; -fx-border-color: green; -fx-border-width: 2px;");
            sideBar.getChildren().add(btn);
            btn.setPrefWidth(35);
            btn.setPrefHeight(35);
        }
        VBox.setMargin(button1, new Insets(-3, 0, 0, 0));;
        VBox.setMargin(button2, new Insets(32, 0, 0, 0));;
        VBox.setMargin(button3, new Insets(32, 0, 0, 0));;
        VBox.setMargin(button4, new Insets(32, 0, 0, 0));;
        VBox.setMargin(button5, new Insets(32, 0, 0, 0));;
        VBox.setMargin(button6, new Insets(32, 0, 0, 0));;

    }


    public void handlerSidBarClick(int id){
        unload();
        String[] ImagePath = {
                "src/res/book/sideBar/1.png",
                "src/res/book/sideBar/2.png",
                "src/res/book/sideBar/3.png",
                "src/res/book/sideBar/4.png",
                "src/res/book/sideBar/5.png",
                "src/res/book/sideBar/6.png",
                "src/res/book/sideBar/7.png",
        };

        // 0 reservé AU RESET
        loadPageLeftPage(pages[id-1].getLeftPage());

        flipRAmim();
        turnR.getAnimation().setOnFinished( e-> {
            this.getChildren().addAll(rightPage,leftPage);
            appearAnim();
        sideBarAppear.getAnimation().setOnFinished(e2->{
            Image img = new Image("file:"+ImagePath[id]);
            this.getChildren().add(sideBar);
            current.setImage(img);
            System.out.println("gg");


        });});

        System.out.println("handlerSidBarClick called with ID: " + id);






    }


}