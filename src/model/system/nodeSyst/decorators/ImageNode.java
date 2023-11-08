package model.system.nodeSyst.decorators;

import model.system.nodeSyst.decorators.DecoratorEvent;
import model.system.nodeSyst.decorators.Event;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageNode extends DecoratorEvent {

    private String image;

    public ImageNode(Event e,String path){
        super(e);
        image = path;
    }


    public void display() throws IOException {
        //affiche(image);
        super.display();
        File file = new File(this.image);
        BufferedImage bufferedImage = ImageIO.read(file);

        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        JFrame jFrame = new JFrame();

        jFrame.setLayout(new FlowLayout());

        jFrame.setSize(500, 500);
        JLabel jLabel = new JLabel();

        jLabel.setIcon(imageIcon);
        jFrame.add(jLabel);
        jFrame.setVisible(true);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println(image);

    }

    @Override
    public Event chooseNext() {
        return super.chooseNext();
    }
}
