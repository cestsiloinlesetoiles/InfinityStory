    package views;

    import javafx.scene.image.Image;
    import javafx.scene.image.ImageView;
    import javafx.scene.text.Font;

    public class Book {
        private static double ratioD = 1.2;
        private static Font fontUi = Font.loadFont("file:src/res/book/font/Silver.ttf", 35);
        private static Font fontText = Font.loadFont("file:src/res/book/font/Silver.ttf", 20);
        private static Font fontChapter = Font.loadFont("file:src/res/book/font/DungeonFont.ttf", 35);
        private static Font fontBookText = Font.loadFont("file:src/res/book/font/Fool.ttf", 25);




        public static ImageView getDesk() {
            Image desk = new Image("file:src/res/book/desk/1.png");
            ImageView deskView = new ImageView(desk);
            adjustSize(desk,ratioD,deskView);
            deskView.setSmooth(false);
            deskView.setPreserveRatio(true);
            return deskView;
        };


        public static  ImageAnimated getCloseBook(){
            ImageAnimated closeBook = new ImageAnimated("src/res/book/close", 150, true, ratioD );
            return  closeBook;
        }


        public static void adjustSize(Image img, double ratio, ImageView imgView) {
            double newWidth = img.getWidth() * ratio;
            double newHeight = img.getHeight() * ratio;
            imgView.setFitWidth(newWidth);
            imgView.setFitHeight(newHeight);
        }

        public static Font getFontForUi() {
            return fontUi;
        }

        public static Font getFontForChapter() {
            return fontChapter;
        }

        public static Font getFontForText() {
            return fontText;
        }

        public static Font getFontBookText(){
            return  fontBookText;
        }
    }
