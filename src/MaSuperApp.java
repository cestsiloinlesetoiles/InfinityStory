
import controllers.ContentController;
import javafx.application.Application;
import model.system.Game;
import model.system.nodeSyst.DecisionNode;
import model.system.nodeSyst.Node;
import model.system.nodeSyst.decorators.Event;
import model.system.nodeSyst.decorators.ImageNode;
import views.MainView;

import java.io.IOException;

public class MaSuperApp  {



    public static void main(String[] args) throws IOException {
        /*MainView view = new MainView();
        view.display();*/
        //Event e1 = new ImageNode(new DecisionNode("BIENVENU AU JEU DE AMRO",1), "/Users/amrobenramdane/IdeaProjects/InfinityStory/src/model/image11.jpeg");

        /*CompanionTrainer companionTrainer = new CompanionTrainer("Amro");
        StartNode s = new StartNode("choix companion",1, companionTrainer);
        s.display();*/

        Game g = new Game("Amro");


    }


}
