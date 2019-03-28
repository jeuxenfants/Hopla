/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Sandra
 */
public class Administration{
    JFrame principal;
    JPanel first; 
    JPanel level;
    JPanel create;
    JPanel changed;
    JPanel button;
    JButton create_question;
    JButton changed_question;
    ButtonGroup groupe_level = new ButtonGroup();
    JRadioButton level1;
    JRadioButton level2;
    JButton back;

    /**
     * Construction de la fenetre 
     */
    
    public Administration() {
        //Icon backButton = new Icon();
        this.principal=new JFrame("Administration");
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setLayout(new BorderLayout());
        //Le panel first contient l'ensemble des panel de la frame, il est definit de façon a afficher
        //les élèments de haut en bas : 
        this.first = new JPanel();
        first.setLayout(new BoxLayout(first, BoxLayout.PAGE_AXIS));
        //Le panel level contient les boutons de niveau qui les afficheras au milieu et 
        //de droite a gauche
        this.level = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //Les radiobuttons
        this.level1 = new JRadioButton("1");
        this.level2 = new JRadioButton("2");
        //le groupe_level est l'objet de la classe qui permet de ne selectionner que l'un des deux niveaux
        groupe_level.add(level1);
        groupe_level.add(level2);
        //Panel de creation de la question
        this.create = new JPanel();
        this.changed = new JPanel();
        this.create_question = new JButton("Créer question");
        this.changed_question =new JButton("Modifier question");
        create.add(create_question);
        changed.add(changed_question);
        //Panel boutons qui sera en bas
        this.button = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.back = new JButton();
        
        //Ajout dans les differents panel     
        level.add(level1);
        level.add(level2);
        first.add(level);
        button.add(back);
        principal.add(first, BorderLayout.NORTH);
        principal.add(create, BorderLayout.CENTER);
        principal.add(changed);
        principal.add(button, BorderLayout.SOUTH);
        principal.setLocationRelativeTo(null);
        principal.pack();
        principal.setVisible(true);
    }
    
    
    
}
