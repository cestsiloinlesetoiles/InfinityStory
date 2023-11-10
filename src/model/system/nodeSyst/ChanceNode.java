package model.system.nodeSyst;

import java.util.ArrayList;
import java.util.Random;

public class ChanceNode extends InnerNode{

    // choosenext : random entre O et tab.length
    public ChanceNode(String d, int i){
        super(d,i);
    }

    public Node chooseNext(){
        ArrayList<Node> n = this.getNextNodes();
        Random rand = new Random();
        int i = rand.nextInt(n.size());

        return n.get(i);
    }

    public boolean equals(Object o) {
        if(!(o instanceof ChanceNode)) return false;
        return super.equals(o);
    }


    public String toString() {
        return "{ Type : ChanceNode \n"+super.toString()+" }" ;
    }
}
