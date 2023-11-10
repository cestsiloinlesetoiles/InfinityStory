package model.system;

import model.system.nodeSyst.DecisionNode;
import model.system.nodeSyst.Node;
import model.system.nodeSyst.TerminalNode;

public class Story {
    private Node root;

    public Story(){
        DecisionNode d1 = new DecisionNode("Choix du Companion de départ",0);
        TerminalNode t = new TerminalNode("Elekchu",2);
        TerminalNode t1 = new TerminalNode("Firecat",3);
        TerminalNode t2 = new TerminalNode("Icywolf",4);
        d1.fillNextNode(t);d1.fillNextNode(t1);d1.fillNextNode(t2);
        this.root = d1;
    }

    public Node getRoot(){
        return this.root;
    }
}
