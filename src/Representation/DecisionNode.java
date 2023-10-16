package Representation;

import java.util.ArrayList;
import java.util.Scanner;

public class DecisionNode extends InnerNode{

    //dans choosenextnode : 1)demande utilisateur choix scanner 2) avec int du choix

    public DecisionNode(String d, int i){
        super(d,i);
    }

    public Node chooseNext(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choisissez une des options suivantes:");
        ArrayList<Node> n = this.getNextNodes();
        for(int i = 0; i<n.size(); i++){
           System.out.print(i + " –> ");
           n.get(i).display();
        }
        int nbnode = sc.nextInt();

        return n.get(nbnode);
    }

    public Node chooseNext(int i){
        return this.getNextNodes().get(i);
    }


}

