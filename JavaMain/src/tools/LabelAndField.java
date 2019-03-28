/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.awt.BorderLayout;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Christophe
 */
public class LabelAndField extends JPanel {

    JLabel label = new JLabel();
    String reponseSaisie;
    private JTextField answerField = new JTextField();

    public LabelAndField(String label, int size) {
        this.label = new JLabel(label);
        this.answerField = new JTextField(size);
        this.setLayout(new BorderLayout());
        this.add(this.label, BorderLayout.WEST);
        this.add(this.answerField, BorderLayout.EAST);
        answerField.addFocusListener(new FocusListener(){
        @Override
        public void focusGained(FocusEvent e){
            System.out.println("");
        }
        @Override
        public void focusLost(FocusEvent e){
            reponseSaisie= answerField.getText();
            System.out.println(reponseSaisie);
            
        }
    });
    }

    public JTextField getTextField() {
        return answerField;
    }

}
