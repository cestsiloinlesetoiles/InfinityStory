package model.system;

import model.system.nodeSyst.*;


public class Game {
    private int CurrentNode = 0;


    public Game(){



    }

    public void setIdCurrentNode(int currentNode) {
        CurrentNode = currentNode;
    }

    public int getCurrentNode() {
        return CurrentNode;
    }
}
