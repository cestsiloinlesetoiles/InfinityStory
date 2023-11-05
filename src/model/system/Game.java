package model.system;

import model.system.nodeSyst.DecisionNode;
import model.system.nodeSyst.TerminalNode;

public class Game {
    String Name;
    Story story;
    Inventory inventory;
    Character character;

    public Game(){
        this.story = new Story();
        story.getRoot().chooseNext().display();
    }



}
