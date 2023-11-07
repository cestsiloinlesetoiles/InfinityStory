import com.sun.jdi.connect.Connector;
import model.system.nodeSyst.ChanceNode;
import model.system.nodeSyst.DecisionNode;
import model.system.nodeSyst.Node;
import model.system.nodeSyst.TerminalNode;

public class mainTest {
    public static boolean run = true;
    public static void main(String[] args) {
        // Niveau 0
        DecisionNode root = new DecisionNode("Niveau 0 - Racine", 0);

        // Niveau 1
        DecisionNode node1a = new DecisionNode("Niveau 1 - Branche a", 1);
        DecisionNode node1b = new DecisionNode("Niveau 1 - Branche b", 2);
        DecisionNode node1c = new DecisionNode("Niveau 1 - Branche c", 3);


        root.fillNextNode(node1a);
        root.fillNextNode(node1b);
        root.fillNextNode(node1c);

        // Niveau 2
        DecisionNode node2a = new DecisionNode("Niveau 2 - Branche a", 4);
        DecisionNode node2b = new DecisionNode("Niveau 2 - Branche b", 5);
        DecisionNode node2c = new DecisionNode("Niveau 2 - Branche c", 6);


        node1a.fillNextNode(node2a);
        node1b.fillNextNode(node2b);
        node1c.fillNextNode(node2c);


        // Niveau 3 => Terminal
        TerminalNode node3a = new TerminalNode("Niveau 3 - Branche a", 13);
        TerminalNode node3b = new TerminalNode("Niveau 3 - Branche b", 14);
        TerminalNode node3c = new TerminalNode("Niveau 3 - Branche c", 15);


        node2a.fillNextNode(node3a);
        node2b.fillNextNode(node3b);
        node2c.fillNextNode(node3c);



        Node current = root;
        while (!(current instanceof TerminalNode)){
            System.out.println("[ Current  ] " + current.toString() + " \n");
            current = current.chooseNext();
        }
} }

