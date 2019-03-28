/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author Christophe
 */
public class QuestionPanel extends JPanel {

    public QuestionPanel() {

//        String[] questions = {"Questions ", "Question 2"};
//        String question = "Question 1";
        JPanel questionPanel = new JPanel();

        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder("Questions"));

        this.add(questionPanel);
    }

}
