    package views;

    import controllers.ContentController;
    import javafx.application.Application;
    import javafx.geometry.Insets;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.image.ImageView;
    import javafx.scene.layout.*;
    import javafx.scene.paint.Color;
   ;
    import javafx.stage.Stage;




    public class MainView extends Application {
        private Stage primaryStage;
        private Scene main;
        private StackPane root;
        private StackPane deskContainer;
        private ImageAnimated bookCloseAnimated;
        private ImageView current;


        private Button openBtn;
        private   ContentController controller;
        private Enteredtext openLabel;
        BookIndexView index;
        private StackPane leftPage;
        private StackPane rightPage;
        private boolean wireFrame = true;





        @Override
        public void start(Stage stage) {
            this.primaryStage = stage;

            configurePrimaryStage();
            initBook();
            if(wireFrame) {
                viewWireFrame();
            }
            if(controller == null) {
                ContentController controller = new ContentController();
                initController(controller);
            }


        }



        private void configurePrimaryStage() {
            primaryStage.setTitle("MainView");

            root = new StackPane();
            BackgroundFill backgroundFill = new BackgroundFill(Color.web("#0e1529"), null, null);
            Background background = new Background(backgroundFill);
            root.setBackground(background);

            main = new Scene(root, 1200, 900);


            primaryStage.setResizable(false);
            primaryStage.setScene(main);
            primaryStage.show();
        }

        private void initBook() {
            ImageView desk = Book.getDesk();
            System.out.println("controller dans l'instance = " + controller);



            deskContainer = new StackPane();
            deskContainer.getChildren().add(desk);
            root.getChildren().add(deskContainer);


            bookCloseAnimated = Book.getCloseBook();

            current = bookCloseAnimated.getImgView();
            current.setTranslateX(15);
            current.setTranslateY(-70);
            deskContainer.getChildren().add(current);

            openBtn = new Button("");
            openBtn.setStyle("-fx-background-color: transparent;");
            openBtn.setOnAction(e-> controller.openBtnBook(bookCloseAnimated));
            openBtn.setPrefWidth(405);
            openBtn.setPrefHeight(455);
            openBtn.setTranslateX(195);
            openBtn.setTranslateY(-40);

            openLabel = new Enteredtext();
            StackPane.setAlignment(openLabel, Pos.BOTTOM_CENTER);

            openLabel.setFont(Book.getFontForUi());
            openLabel.setStyle(" -fx-text-fill: white;");

            deskContainer.getChildren().addAll(openBtn,openLabel);
           openLabel.typeText("Cliquez sur le livre pour commencer votre aventure !",80);
        }

        public void display() {
            launch();
        }




        public void initController(ContentController controller) {
            this.controller = controller;
            controller.setView(this);
            System.out.println("----> Controller set <-----");
            System.out.println("[ Ref : " + System.identityHashCode(this) +" ]");
        }




        public void OpenBook(){
            deskContainer.getChildren().removeAll(openBtn,openLabel);
            bookCloseAnimated.getAnimation().setOnFinished(e-> {;
            leftPage = new StackPane();
            rightPage = new StackPane();
            deskContainer.getChildren().addAll(leftPage,rightPage);


            InitPageContainer();

            if(wireFrame) {
                leftPage.setStyle("-fx-border-color: #ff1414; -fx-border-width: 2;");
                rightPage.setStyle("-fx-border-color: #234fff; -fx-border-width: 2;");
            }

                BookIndexView index = new BookIndexView(controller,this);

                index.LoadMenuBook();

            });
            System.out.println(" --- [ Book Statut : Close => Open ] ---");


        }

        public void viewWireFrame() {
            openBtn.setStyle("-fx-background-color: transparent; -fx-border-color: red; -fx-border-width: 2; -fx-text-fill: white;");
            openBtn.setText("Open Book");
            deskContainer.setStyle("-fx-border-color: #1aff25; -fx-border-width: 2;");


        }


        public void InitPageContainer(){
            StackPane.setAlignment(leftPage, Pos.CENTER_LEFT);
            StackPane.setAlignment(rightPage, Pos.CENTER_RIGHT);
            StackPane.setMargin(leftPage, new Insets(-50, 0, 0, 240));
            StackPane.setMargin(rightPage, new Insets(-50, 245, 0, 0));
            leftPage.setMaxSize(315, 415);
            rightPage.setMaxSize(315, 415);

        }

        public void loadContentLPage(Pane content){
            leftPage.getChildren().clear();
            leftPage.getChildren().add(content);
        }

        public void loadContentRPage(Pane content){
            rightPage.getChildren().clear();
            rightPage.getChildren().add(content);
        }

    }
