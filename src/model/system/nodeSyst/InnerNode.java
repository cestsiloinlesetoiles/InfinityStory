package model.system.nodeSyst;

import java.util.ArrayList;

public abstract class InnerNode extends Node{

    /* node dans une list*/
 InnerNode n = new InnerNode()
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


   public String toString(){
        StringBuilder  t = new StringBuilder();
        t.append("InnerNodeContent : {\n");
        t.append(super.toString()+"\n");
        t.append("ChildNode : ");
        for(Node n : nextNodes){
            t.append(n.getId()+", ");
        }
       t.append(" }");

      return t.toString();
   }

    @Override
    public boolean equals(Object o) {
        if(!super.equals(o)) return false;
        if(o instanceof InnerNode){
                InnerNode n = (InnerNode) o;
                if(nextNodes.equals(n.getNextNodes())){
                    return  true;
                }
            }

        return false;
    }
}
