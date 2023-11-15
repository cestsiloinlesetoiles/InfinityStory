    package views;

    import controllers.MainContentController;
    import javafx.application.Application;
    import javafx.geometry.Insets;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.image.ImageView;
    import javafx.scene.layout.*;
    import javafx.scene.paint.Color;

    import javafx.stage.Stage;
    import views.Animations.ImageAnimated;
    import views.Animations.Typingtext;
    import views.Media.BookContent;


    public class MainGameView extends Application {
        private Stage primaryStage;
        private Scene main;
        private StackPane root;
        private StackPane deskContainer;
        private ImageAnimated bookCloseAnimated;
        private ImageView current;
        private Button openBtn;
        private MainContentController controller;
        private Typingtext openLabel;

        private boolean wireFrame = false;

        private BookIndexView index;
        private StackPane leftPage;
        private StackPane rightPage;

        private StackPane doublePage;

        private String currentPage;


        @Override
        public void start(Stage stage) {
            this.primaryStage = stage;

            configurePrimaryStage();
            initBook();
            if(wireFrame) {
                viewWireFrame();
            }
            if(controller == null) {
                MainContentController controller = new MainContentController();
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
            ImageView desk = BookContent.getDesk();
            System.out.println("controller dans l'instance = " + controller);



            deskContainer = new StackPane();
            deskContainer.getChildren().add(desk);
            root.getChildren().add(deskContainer);


            bookCloseAnimated = BookContent.getCloseBook();

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

            openLabel = new Typingtext();
            StackPane.setAlignment(openLabel, Pos.BOTTOM_CENTER);

            openLabel.setFont(BookContent.getFontForUi());
            openLabel.setStyle(" -fx-text-fill: white;");

            deskContainer.getChildren().addAll(openBtn,openLabel);
           openLabel.typeText("Cliquez sur le livre pour commencer votre aventure !",80);
        }

        public void display() {
            launch();
        }




        public void initController(MainContentController controller) {
            this.controller = controller;
            controller.setView(this);
            System.out.println("----> Controller set <-----");
            System.out.println("[ Ref : " + System.identityHashCode(this) +" ]");
        }




        public void OpenBook(){
            deskContainer.getChildren().removeAll(openBtn,openLabel);
            bookCloseAnimated.setEndAction(()-> {;
            leftPage = new StackPane();
            rightPage = new StackPane();
            doublePage = new StackPane();
            deskContainer.getChildren().addAll(leftPage,rightPage);


            InitPageContainer();

            if(wireFrame) {
                leftPage.setStyle("-fx-border-color: #ff1414; -fx-border-width: 2;");
                rightPage.setStyle("-fx-border-color: #234fff; -fx-border-width: 2;");
                doublePage.setStyle("-fx-border-color: #e5ff00; -fx-border-width: 2;");

            }

                BookIndexView index = new BookIndexView(controller,this);
                index.LoadMenuBook();

            });
            System.out.println(" --- [ Book Statut : Close => Open ] ---");


        }

        private void viewWireFrame() {
            openBtn.setStyle("-fx-background-color: transparent; -fx-border-color: red; -fx-border-width: 2; -fx-text-fill: white;");
            openBtn.setText("Open Book");
            deskContainer.setStyle("-fx-border-color: #1aff25; -fx-border-width: 2;");

        }


        private void InitPageContainer(){
            StackPane.setAlignment(leftPage, Pos.CENTER_LEFT);
            StackPane.setAlignment(rightPage, Pos.CENTER_RIGHT);
            StackPane.setAlignment(doublePage,Pos.CENTER);
            StackPane.setMargin(leftPage, new Insets(-54, 0, 0, 245));
            StackPane.setMargin(rightPage, new Insets(-54, 252, 0, 0));
            StackPane.setMargin(doublePage,new Insets(-145, -31, 0, 0));
            leftPage.setMaxSize(298, 400);
            rightPage.setMaxSize(298, 400);
            doublePage.setMaxSize(750,450);
        }

        public void loadContentLPage(Pane content){
            leftPage.getChildren().clear();
            leftPage.getChildren().add(content);
        }

        public void loadContentRPage(Pane content){
            rightPage.getChildren().clear();
            rightPage.getChildren().add(content);
        }


        public void appearContentPage(){
            if(!deskContainer.getChildren().contains(doublePage)){
                deskContainer.getChildren().add(doublePage);
            }
            ImageAnimated appearAnim = BookContent.getAppearContent();
            ImageView appearImg =  appearAnim.getImgView();
            doublePage.getChildren().add(appearImg);
            appearAnim.play();
            appearAnim.setEndAction(()->  {deskContainer.getChildren().remove(doublePage);});

        }

        public void disppearContentPage(){
            if(!deskContainer.getChildren().contains(doublePage)){
                deskContainer.getChildren().add(doublePage);
            }
            ImageAnimated disAppearAnim = BookContent.getDisappearContent();
            ImageView disAppearImg =  disAppearAnim.getImgView();
            doublePage.getChildren().add(disAppearImg);

            disAppearAnim.play();
            disAppearAnim.setEndAction(()->  {deskContainer.getChildren().remove(doublePage);});
        }

        public StackPane getLeftPage() {
            return leftPage;
        }

        public StackPane getRightPage(){
            return rightPage;
        }


        public String getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(String currentPage) {
            this.currentPage = currentPage;
        }

        public ImageView getCurrent() {
            return current;
        }

        public void setCurrent(ImageView current) {
            this.current = current;
        }

        public StackPane getDeskContainer() {
            return deskContainer;
        }

        public StackPane getRoot(){
            return root;
        }

        public void unload(){
            deskContainer.getChildren().removeAll(leftPage,rightPage);
        }
        public void load(){
            deskContainer.getChildren().addAll(leftPage,rightPage);
        }
    }
