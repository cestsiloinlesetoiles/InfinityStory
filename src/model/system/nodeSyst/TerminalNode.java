package model.system.nodeSyst;

public class TerminalNode extends Node{

    public TerminalNode(String t,String d,int i){

        super(t,d,i);

    }

    public Node chooseNext() {

        return this;

    }


    public boolean equals(Object o) {
        if(!(o instanceof TerminalNode)) return false;
        return super.equals(o);
    }

    @Override
    public String toString() {
        return "{ Type : TerminalNode \n"+super.toString()+" }" ;
    }
}
