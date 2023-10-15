package views;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.io.FileFilter;
import java.util.ArrayList;
import java.io.File;
import java.util.Arrays;


public class ImageAnimated {
    private ArrayList<String> framesPath = new ArrayList<>();
    private int currentFrame = 0;
    private ImageView imgView;
    private Timeline animation;
    private double ratio;
    private int time;
    private MediaPlayer mediaPlayer;

    public ImageAnimated(String dirPath, int time_key, boolean pixel, double ratio) {
        this.ratio = ratio;
        this.time = time_key;
        File dir = new File(dirPath);
        FileFilter filter = pathname -> {
            String[] imgExt = {".png", ".jpeg", ".jpg"};
            for(String ext : imgExt){
                if(pathname.toPath().toString().endsWith(ext)) return true;
            }
            return false;
        };

        if(dir.isDirectory()){
            File[] files = dir.listFiles(filter);
            Arrays.sort(files, (file1, file2) -> {
                int num1 = Integer.parseInt(file1.getName().replaceAll("[^0-9]", ""));
                int num2 = Integer.parseInt(file2.getName().replaceAll("[^0-9]", ""));
                return Integer.compare(num1, num2);
            });

            for(File file : files){
                framesPath.add("file:"+file.getPath());
                System.out.println("Loaded : "+ file.getPath());
            }
        }





        Image initialImage = new Image(framesPath.get(0));
        imgView = new ImageView(initialImage);
        imgView.setPreserveRatio(true);
        adjustSize(initialImage);

        if(pixel) {
            imgView.setSmooth(false);
            imgView.setCache(true);
        }

        animation = new Timeline(new KeyFrame(Duration.millis(time), e -> updateFrame()));
        animation.setCycleCount(framesPath.size());
        System.out.println("Frame Img number : "+framesPath.size());


    }


    public ImageAnimated(String dirPath, int time_key, boolean pixel, double ratio, String audioFilePath){
        this(dirPath, time_key, pixel, ratio);
        Media media = new Media(new File(audioFilePath).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
    }
    public void play() {
        animation.play();
        if(mediaPlayer!=null){
            mediaPlayer.play();
        }
    }

    public void updateFrame() {

        System.out.print("Display Frame n° : " + (currentFrame + 1));


        Image currentImage = new Image(framesPath.get(currentFrame));
        imgView.setImage(currentImage);
        adjustSize(currentImage);


        if (currentFrame == framesPath.size() - 1) {
            currentFrame = 0;
        } else {
            currentFrame++;
        }
        System.out.println(" Speed Frame : " + time);

        System.out.println(" Next Frame n° : " + (currentFrame + 1));
    }

    private void adjustSize(Image image) {
        double newWidth = image.getWidth() * ratio;
        imgView.setFitWidth(newWidth);
    }

    public void reset() {
        imgView.setImage(new Image(framesPath.get(0)));
    }

    public ImageView getImgView() {
        return imgView;
    }

    public Timeline getAnimation(){
        return animation;
    }



    public void speedAnimation(int KeyTime) {
        this.time = KeyTime;
    }

}
