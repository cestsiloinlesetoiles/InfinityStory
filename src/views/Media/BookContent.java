    package views.Media;

    import javafx.scene.image.Image;
    import javafx.scene.image.ImageView;
    import javafx.scene.text.Font;
    import views.Animations.ImageAnimated;

    public class BookContent {
        private static final double ratioD = 1.2;
        private static final Font fontUi = Font.loadFont("file:src/res/book/font/Silver.ttf", 35);
        private static final Font fontText = Font.loadFont("file:src/res/book/font/Silver.ttf", 20);
        private static final Font fontChapter = Font.loadFont("file:src/res/book/font/DungeonFont.ttf", 35);
        private static final Font fontBookText = Font.loadFont("file:src/res/book/font/Fool.ttf", 25);




        public static final  ImageView getDesk() {
            Image desk = new Image("file:src/res/book/desk/1.png");
            ImageView deskView = new ImageView(desk);
            adjustSize(desk,ratioD,deskView);
            deskView.setSmooth(false);
            deskView.setPreserveRatio(true);
            return deskView;
        };


        public static final ImageAnimated getCloseBook(){
            ImageAnimated closeBook = new ImageAnimated("src/res/book/open", 150, true, ratioD );
            return  closeBook;
        }


        public static void adjustSize(Image img, double ratio, ImageView imgView) {
            double newWidth = img.getWidth() * ratio;
            double newHeight = img.getHeight() * ratio;
            imgView.setFitWidth(newWidth);
            imgView.setFitHeight(newHeight);
        }

        public static final Font getFontForUi() {
            return fontUi;
        }

        public static final Font getFontForChapter() {
            return fontChapter;
        }

        public static final Font getFontForText() {
            return fontText;
        }

        public static final  Font getFontBookText(){
            return  fontBookText;
        }

        public static final  ImageAnimated getAppearContent(){
            ImageAnimated contentAppear = new ImageAnimated("src/res/book/appear", 150, true, ratioD );
            return  contentAppear;
        }

        public static final ImageAnimated getDisappearContent(){
            ImageAnimated contentDisAppear = new ImageAnimated("src/res/book/disappear", 150, true, ratioD );
            return contentDisAppear;
        }

        public static final  ImageAnimated getTurnR(){
            ImageAnimated turnR = new ImageAnimated("src/res/book/turnR", 70, true, ratioD );
            return  turnR;
        }

        public static final  ImageAnimated getTurnL(){
            ImageAnimated turnL = new ImageAnimated("src/res/book/turnL", 70, true, ratioD );
            return  turnL;
        }

        public static double getRatioD() {
            return ratioD;
        }
    }
