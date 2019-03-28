/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration;

import MenuPrincipal.MenuPrincipalAdmin;
import beans.Question;
import dao.DAOQuestion;
//import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import tools.JCoolButton;
import tools.LabelAndField;

/**
 *
 * @author Dizer
 */
public class Admin {

    JFrame principal;

    JPanel choix;
    JPanel level;

    JPanel Box1;
    JPanel Box2;
    JPanel Box3;
    JPanel Box4;
    JPanel Box5;
    JPanel Box6;

    Question NewQuestion;

    JPanel Ligne4;

    JLabel Niveau;
    JLabel Choix;

    LabelAndField Creation;
    LabelAndField Reponse;
    LabelAndField Modification;

    JButton Retour;
    JButton Sauvegarder;
    JButton Modifier;

    JRadioButton level1;
    JRadioButton level2;
    ButtonGroup groupe_level = new ButtonGroup();
    Object[] Option = new Object[]{"Creation", "Modification"};
    Integer[] NumeroQuestion = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    JComboBox<Integer> ListeQuestions;
    JComboBox ListeDeroulante;

    public Admin() {
        //Création de la frame principal de l'administration
        this.principal = new JFrame("Administration");
        Dimension taille = new Dimension(600, 600);
        principal.setSize(taille);
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setLayout(new BorderLayout());
        //1ere boite panel général
        Box1 = new JPanel();
        Box1.setLayout(new BoxLayout(Box1, BoxLayout.PAGE_AXIS));
        //2eme boite qui contient Actions possibles et menu déroulant
        Box2 = new JPanel();
        //3eme boite
        Box3 = new JPanel();
        Creation = new LabelAndField("Nouvelle question ", 40);
        Modification = new LabelAndField("Changer question ", 40);
        Reponse = new LabelAndField("Reponse ", 46);
        //4eme boite
        Box4 = new JPanel();
        //5 eme boite pour le menu déroulant du nombre de question 
        Box5 = new JPanel();
        //6eme boite 
        Box6 = new JPanel();
        //Ligne
        Ligne4 = new JPanel();
        Ligne4.setLayout(new FlowLayout());
        //Création des boutons
        Retour = new JButton("Retour");
        Retour.addActionListener(new MonListener2());
        Sauvegarder = new JCoolButton("Sauvegarder");
        Sauvegarder.setPreferredSize(new Dimension(200, 100));
        Sauvegarder.setFont(new Font("sansserif", Font.BOLD, 22));
        Sauvegarder.addActionListener(new MonListener2());
        Modifier = new JCoolButton("Modifier");
        Modifier.setPreferredSize(new Dimension(200, 100));
        Modifier.setFont(new Font("sansserif", Font.BOLD, 22));
        Modifier.addActionListener(new MonListener2());
        //Gestion des boutons de choix du niveau 
        Niveau = new JLabel("Niveau de la question");
        this.level = new JPanel(new FlowLayout(FlowLayout.CENTER));
        level1 = new JRadioButton("1");
        level1.addActionListener(new MonListener3());
        level2 = new JRadioButton("2");
        level2.addActionListener(new MonListener3());

        groupe_level.add(level1);
        groupe_level.add(level2);

        Choix = new JLabel("Action à réaliser");
        //gestion d'evenement sur la combobox
        ListeDeroulante = new JComboBox(Option);
        ListeDeroulante.addActionListener(new MonListener());
        //Gestion de la combobox pour la liste de question 
        ListeQuestions = new JComboBox(NumeroQuestion);
        ListeQuestions.addActionListener(new MonListener());

        level.add(Niveau);
        level.add(level1);
        level.add(level2);

        Ligne4.add(Sauvegarder);
        Ligne4.add(Modifier);

        Box2.add(Choix);
        Box2.add(ListeDeroulante);

        Box3.add(Creation);

        Box4.add(Modification);
        Box5.add(Reponse);

        Box6.add(ListeQuestions);

        Box1.add(level);
        Box1.add(Box2);
        Box1.add(Box3);
        Box1.add(Box4);
        Box1.add(Box5);
        Box1.add(Box6);
        Box1.add(Ligne4);

        principal.add(Box1, BorderLayout.NORTH);
        principal.add(Retour, BorderLayout.PAGE_END);

        NewQuestion = new Question();
        Sauvegarder.setVisible(false);
        Creation.setVisible(false);
        Modifier.setVisible(false);
        Reponse.setVisible(false);
        ListeQuestions.setVisible(false);
        Modification.setVisible(false);
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);

    }

    private class MonListener implements ActionListener {
        //Personnalisation des écouteurs sur les bouttons

        @Override
        public void actionPerformed(ActionEvent e) {

            //Gestion de la comboBox du menu déroulant pour les actions Création et Modification 
            JComboBox comboBox = (JComboBox) e.getSource();
            Object selected = comboBox.getSelectedItem();

            if (selected.toString().equals("Creation")) {
                //elements visibles
                Sauvegarder.setVisible(true);
                Creation.setVisible(true);
                Reponse.setVisible(true);
                //elements invisibles
                Modifier.setVisible(false);
                ListeQuestions.setVisible(false);
                Modification.setVisible(false);

            } else if (selected.toString().equals("Modification")) {
                //elements visibles
                Modifier.setVisible(true);
                Modification.setVisible(true);
                Reponse.setVisible(true);
                ListeQuestions.setVisible(true);

                //elements invisibles 
                Sauvegarder.setVisible(false);
                Creation.setVisible(false);

            }

        }
    }

    private class MonListener2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String s = ((JButton) e.getSource()).getText();//Récuperation du texte sur le boutton sur lequel on clique

            if ("Retour".equals(s)) {//Comparaison du texte suivant avec le texte du bouton pour déclencher une action si c'est le même texte
                principal.setVisible(false);
                MenuPrincipalAdmin menu = new MenuPrincipalAdmin();//retour au menu pricipal en mode admin
                menu.setVisible(true);

            }
            if ("Sauvegarder".equals(s)) {

                NewQuestion.setQuestion(Creation.getTextField().getText());
                NewQuestion.setAnswer(Reponse.getTextField().getText());

                DAOQuestion daoq = new DAOQuestion();
                daoq.create(NewQuestion);

            }
            if ("Modifier".equals(s)) {

                NewQuestion.setId_question((int) ListeQuestions.getSelectedItem());
                NewQuestion.setQuestion(Modification.getTextField().getText());
                NewQuestion.setAnswer(Reponse.getTextField().getText());

                DAOQuestion daoq = new DAOQuestion();
                daoq.update(NewQuestion);

            }

        }
    }

    private class MonListener3 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String r = ((JRadioButton) e.getSource()).getText();
            if ("1".equals(r)) {
                NewQuestion.setLevel(1);
            }
            if ("2".equals(r)) {
                NewQuestion.setLevel(2);
            }
        }
    }
}
