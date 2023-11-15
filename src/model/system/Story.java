package model.system;

import model.system.nodeSyst.DecisionNode;
import model.system.nodeSyst.Node;
import model.system.nodeSyst.TerminalNode;

public class Story {
    private Node root;

    public Story(){

    }

    public Node getRoot(){
        return this.root;
    }
}
