package views;

import controllers.MainContentController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.system.nodeSyst.DecisionNode;
import model.system.nodeSyst.Node;
import model.system.nodeSyst.TerminalNode;
import views.View.NodeView;

public class BookIndexView extends StackPane {
    private MainContentController controller;
    private MainGameView book;

    private ImageView current;



    private Image default_img = new Image("file:src/res/D.png");
    private Button btnPlay = new Button("Play - Version Test");

    private Button btnInfiniMode = new Button("Infinity Mode - Pas dispo");
    private Button btnOptions = new Button("Options -  Pas dispo");
    private Button btnQuit = new Button("Close - Pas dispo ");




    public BookIndexView(MainContentController controller, MainGameView view){
        this.controller = controller;
        this.book = view;
    }


    public void LoadMenuBook(){
        StackPane page = new StackPane();
        VBox menu = new VBox(15);
        btnPlay.setOnAction(e -> { LoadNodeVisualisation(TestStory());});
        menu.getChildren().addAll(btnPlay, btnInfiniMode, btnOptions, btnQuit);
        page.getChildren().add(menu);
        menu.setAlignment(Pos.CENTER);
        StackPane.setAlignment(menu, Pos.CENTER);
        //book.disppearContentPage();
        book.loadContentRPage(page);
        book.setCurrentPage("MENU");
    }

    public void LoadNodeVisualisation(Node root) {
        book.setCurrentPage("PLAY");
        NodeView nodeView = new NodeView(root,book);
    }


    public Node TestStory(){
            // Niveau 0
            DecisionNode root = new DecisionNode("La Quête Commence", "Dans un royaume lointain, un jeune aventurier du nom de Elan se tenait devant trois portes mystérieuses, chacune menant à un destin différent. C'était le début de sa quête pour retrouver la Pierre de Lune disparue, un artefact d'une immense puissance.", 0);
            root.setImg("file:src/res/TestStory/0.png");

            // Niveau 1
            DecisionNode node1a = new DecisionNode("Le Chemin de la Forêt Enchantée", "Le jeune Elan choisit la première porte et se retrouve dans une forêt enchantée, où les arbres murmurent des secrets anciens.", 1);
            node1a.setImg("file:src/res/TestStory/1a.png");
            DecisionNode node1b = new DecisionNode("Les Cavernes Mystérieuses","Le jeune Elan choisit la première porte et se retrouve dans une forêt enchantée, où les arbres murmurent des secrets anciens.", 2);
            node1b.setImg("file:src/res/TestStory/1b.png");
            DecisionNode node1c = new DecisionNode("La Cité Perdue dans le Ciel","La troisième porte conduit Elan à une cité flottante dans le ciel, un lieu de merveilles et de dangers inconnus.", 3);
            node1c.setImg("file:src/res/TestStory/1c.png");

            root.fillNextNode(node1a);
            root.fillNextNode(node1b);
            root.fillNextNode(node1c);

            // Niveau 2
            DecisionNode node2a = new DecisionNode("Le Secret de la Forêt","Poursuivant son aventure dans la forêt enchantée, Elan trouve une clairière secrète. Ici, il doit choisir entre utiliser un ancien sortilège pour révéler le chemin vers la Pierre de Lune ou poursuivre sa quête sans aide magique.", 4);
            node2a.setImg("file:src/res/TestStory/2a.png");
            DecisionNode node2b = new DecisionNode("La Découverte Souterraine","Dans les profondeurs des cavernes, Elan découvre une salle cachée contenant une carte qui pointe vers le lieu de la Pierre de Lune. Il doit décider de faire confiance à cette carte ou de chercher d'autres indices.", 5);
            node2b.setImg("file:src/res/TestStory/2b.png");
            DecisionNode node2c = new DecisionNode("Le Dilemme Céleste","Dans la cité flottante, Elan est confronté à un sage qui lui propose un marché : la Pierre de Lune en échange d'une promesse de protéger la cité contre un danger imminent. Elan doit choisir entre accepter l'accord ou continuer sa quête seul.", 6);
            node2c.setImg("file:src/res/TestStory/2c.png");

            node1a.fillNextNode(node2a);
            node1b.fillNextNode(node2b);
            node1c.fillNextNode(node2c);




        TerminalNode node3a = new TerminalNode("La Lumière de la Lune", "Si Elan utilise le sortilège dans la forêt, il est guidé vers la Pierre de Lune. Il la récupère, apportant paix et prospérité au royaume, mais la magie de la forêt disparaît à jamais.", 7);
        node3a.setImg("file:src/res/TestStory/3a.png");
        TerminalNode node3b = new TerminalNode("La Carte du Destin", "Faisant confiance à la carte trouvée dans les cavernes, Elan découvre la Pierre de Lune dans un sanctuaire oublié. Il devient un héros légendaire, mais la carte disparaît, emportant avec elle d'autres secrets anciens.", 8);
        node3b.setImg("file:src/res/TestStory/3b.png");
        TerminalNode node3c = new TerminalNode("Le Pacte Céleste", "En acceptant l'accord avec le sage de la cité céleste, Elan obtient la Pierre de Lune et sauve la cité d'un désastre imminent. Cependant, il est lié à vie à la cité, ne pouvant plus jamais quitter les cieux.", 9);
        node3c.setImg("file:src/res/TestStory/3c.png");

            node2a.fillNextNode(node3a);
            node2b.fillNextNode(node3b);
            node2c.fillNextNode(node3c);
            Node  current = root;
            return current;

        }
        
}







