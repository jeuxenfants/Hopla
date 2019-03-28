/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Christophe
 */
public class ChoicePanel extends JPanel {

    public ChoicePanel() {

        this.setLayout(new BorderLayout());

        JPanel choicePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

//        this.setLayout(new FlowLayout());
        ButtonGroup choiceGroup = new ButtonGroup();
        String[] choices = {"Verifier", "Solution", "Question suivante"}; // Les labels des boutons radio
        for (String choice : choices) {
            JRadioButton buttonchoice = new JRadioButton(choice);
            choiceGroup.add(buttonchoice); // Ajout au groupe
            choicePanel.add(buttonchoice);
            if (choice.equals("Verifier")) { // On préselectionne Vérifier.
                buttonchoice.setSelected(true);
            }
        }

        this.add(choicePanel);

    }
}
