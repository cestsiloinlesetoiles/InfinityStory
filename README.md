Pour vous aider à installer et configurer JavaFX pour le développement du jeu "Où Vous Êtes Le Héros" en Java, voici les étapes à suivre pour les environnements de développement IntelliJ IDEA et Eclipse. Ces étapes incluent l'installation de JavaFX, sa configuration dans l'IDE, et l'ajout des options de machine virtuelle (VM) nécessaires.

### Pour IntelliJ IDEA

1. **Téléchargez JavaFX SDK** :
   - Visitez le [site officiel de JavaFX](https://gluonhq.com/products/javafx/) et téléchargez le SDK correspondant à votre système d'exploitation.

2. **Configuration du Projet dans IntelliJ** :
   - Ouvrez votre projet dans IntelliJ IDEA.
   - Allez dans `File` > `Project Structure`.
   - Dans `Project Settings` > `Libraries`, cliquez sur le signe '+' et sélectionnez `Java`.
   - Naviguez vers le dossier où vous avez extrait le SDK JavaFX et ajoutez-le à votre projet.

3. **Configuration des Arguments VM** :
   - Allez dans `Run` > `Edit Configurations`.
   - Dans votre configuration de l'application, ajoutez ces arguments VM (en remplaçant le chemin par celui où vous avez le SDK JavaFX) :
     ```
     --module-path /chemin/vers/javafx-sdk-XX/lib --add-modules javafx.controls,javafx.fxml
     ```
   - Assurez-vous que le chemin d'accès au SDK JavaFX est correct.

4. **Exécution** :
   - Exécutez le projet normalement via IntelliJ.

### Pour Eclipse

1. **Installation de JavaFX** :
   - Suivez les mêmes étapes pour télécharger le SDK JavaFX.

2. **Configuration du Projet dans Eclipse** :
   - Ouvrez Eclipse et votre projet.
   - Cliquez avec le bouton droit sur votre projet, allez dans `Build Path` > `Configure Build Path`.
   - Sous l'onglet `Libraries`, cliquez sur `Add Library` > `JavaFX User Library`.
   - Ajoutez le SDK JavaFX téléchargé.

3. **Configuration des Arguments VM** :
   - Dans `Run` > `Run Configurations`, trouvez votre application.
   - Sous l'onglet `Arguments`, dans la section `VM arguments`, ajoutez les mêmes arguments VM que pour IntelliJ, en adaptant le chemin vers le SDK JavaFX.

4. **Exécution** :
   - Exécutez le projet comme d'habitude dans Eclipse.
