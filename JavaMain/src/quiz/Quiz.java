/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.awt.BorderLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Christophe
 */
public class Quiz extends JFrame {

    Box content; // Le panneau global
    JPanel questionP; // Le panneau de la civilité
    JPanel answerP; // Le panneau de l'adresse
    JPanel choiceP; // Le panneau des langages utilisés

    public Quiz() {

        // Construction de la fenetre
        JFrame fQuiz = new JFrame();
//        fQuiz.setSize(500, 500);

        // Initialisation des variables d'instance
        this.content = new Box(BoxLayout.PAGE_AXIS);
        this.questionP = new QuestionPanel();
        this.answerP = new AnswerPanel();
        this.choiceP = new ChoicePanel();

        // initialisation du contenu
        this.initGUI();

        // Initialisation de la fenêtre
        this.setContentPane(content);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermeture
        this.setResizable(false); // Fenêtre non-redimensionnable
        this.pack(); // Ajustement de la taille au contenu
        // On positionne la fenêtre au milieu de l'écran
        this.setLocationRelativeTo(null);
        this.setVisible(true); // Affichage de la fenêtre
    }

    private void initGUI() {
        // Ajout des differents panneaux dans le contenu
        this.content.add(questionP, BorderLayout.NORTH);
        this.content.add(answerP, BorderLayout.CENTER);
        this.content.add(choiceP, BorderLayout.SOUTH);
    }
}
