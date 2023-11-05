package model.system.nodeSyst;

import java.util.ArrayList;

public abstract class InnerNode extends Node{

    /* node dans un tableau*/

    private ArrayList<Node> nextNodes;


    //desc, i , nombre de choix
    public InnerNode(String desc, int i) {

        super(desc,i);
        this.nextNodes = new ArrayList<>();

    }

    public ArrayList<Node> getNextNodes() {
        return nextNodes;
    }

    //faire methode pour fill le tableau
   public void fillNextNode(Node n){nextNodes.add(n);}



}
