/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import tools.LabelAndField;

/**
 *
 * @author Christophe
 */
public class AnswerPanel extends JPanel {

    public AnswerPanel() {

        // Création du conteneur réponse
//        this.setLayout(new BorderLayout());
        JPanel answerPanel = new LabelAndField("Réponse : ", 20);
        this.setLayout(new BorderLayout());

        this.add(answerPanel);

    }

}
