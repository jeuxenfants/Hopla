/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import MenuPrincipal.MenuPrincipal;
import MenuPrincipal.MenuPrincipalAdmin;
import beans.Question;
import dao.DAOQuestion;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import tools.JCoolButton;
import tools.LabelAndField;

/**
 *
 * @author Christophe
 */
public class Quiz extends JFrame {

    
    JFrame principal;



    JPanel Box1;
    JPanel Box2;
    JPanel Box3;
    JPanel Box4;

    Question QuestionPose;
    DAOQuestion daoq;



    JLabel Question;
  

//champs de reponse 
    LabelAndField Reponse;
 
//3 boutons necessaires à l'interface 
    JButton Valider;
    JButton Rep;
    JButton QuestionSuivante;
    JButton Retour;
    HashSet<Question> set ;
    
    public Quiz(){
        set = new HashSet<>();
//        genererQuestion();
        this.principal = new JFrame();
        Dimension taille = new Dimension ( 600, 600);
        principal.setSize(taille);
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setLayout(new BorderLayout());
        
        Font font = new Font("Arial",Font.BOLD,25);
        //1ere boite panel général
        Box1 = new JPanel();
        Box1.setLayout(new BoxLayout(Box1, BoxLayout.PAGE_AXIS));
        
        //2eme boite qui contient le label de la question
        Box2 = new JPanel();
        Box2.setLayout(new FlowLayout());
        Question = new JLabel("Question test");
        Question.setFont(font);
        Box2.add(Question);
        //3eme boite qui contient le Label and field de la reponse 
        Box3 = new JPanel();
        Box3.setLayout(new FlowLayout());
        Reponse = new LabelAndField("Reponse",40);
        Reponse.setPreferredSize(new Dimension(500,40));
        Reponse.setFont(font);
        Box3.add(Reponse);
        //4eme boite qui contient les boutons Valider, reponse et question suivante
        Box4 = new JPanel();
        Box4.setLayout(new FlowLayout());
        Valider = new JCoolButton("Valider");
        Valider.addActionListener(new MonListener2());
        Valider.setPreferredSize(new Dimension(150, 150));
        Rep = new JCoolButton("Réponse");
        Rep.addActionListener(new MonListener2());
        Rep.setPreferredSize(new Dimension(150, 150));
        QuestionSuivante = new JCoolButton("Question suivante");
        QuestionSuivante.addActionListener(new MonListener2());
        QuestionSuivante.setPreferredSize(new Dimension(150, 150));
        Box4.add(Valider);
        Box4.add(Rep);
        Box4.add(QuestionSuivante);
        
        
        Retour = new JCoolButton("Retour");
        
        //Ajout des panels dans le panel 1 puis le panel principal 
        Box1.add(Box2);
        Box1.add(Box3);
        Box1.add(Box4);
        
        principal.add(Box1);

        
        
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
    }
       private void genererQuestion(){ //fonction pour récuperer un question random dans la base de donnée et stocker les questions dans une hashset
           int valeur ;
       
        daoq = new DAOQuestion();
        Random r = new Random();
        valeur = 0 + r.nextInt(1 - 20);
        QuestionPose = daoq.find(valeur);
        while(set.contains(QuestionPose))
        {
        valeur = 0 + r.nextInt(1 - 20);
        QuestionPose = daoq.find(valeur);
        }
        set.add(QuestionPose);
        Question.setText(QuestionPose.getQuestion());
       }
         
       private class MonListener2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String s = ((JButton) e.getSource()).getText();//Récuperation du texte sur le boutton sur lequel on clique

            if ("Retour".equals(s)) {//Comparaison du texte suivant avec le texte du bouton pour déclencher une action si c'est le même texte
                principal.setVisible(false);
                MenuPrincipal menu = new MenuPrincipal();//retour au menu pricipal en mode admin
                menu.setVisible(true);

            }
            if ("Valider".equals(s)) {
                
                String reponsePropose = Reponse.getTextField().getText();
                String reponseReel = QuestionPose.getAnswer();
                
                if(reponsePropose == reponseReel){
                    JOptionPane.showMessageDialog(null,"Bonne réponse!!");
                }
                else
                     JOptionPane.showMessageDialog(null,"Mauvaise réponse!");

               
     

            }
            if ("Reponse".equals(s)) {
                    
                   JOptionPane.showMessageDialog(null,"La réponse était : "+QuestionPose.getAnswer());

            }
            if("Question suivante".equals(s))
            {
                genererQuestion();
                
            }
    }
    
}
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    Box content; // Le panneau global
//    JPanel questionP; // Le panneau de la civilité
//    JPanel answerP; // Le panneau de l'adresse
//    JPanel choiceP; // Le panneau des langages utilisés
//
//    public Quiz() {
//
//        // Construction de la fenetre
//        JFrame fQuiz = new JFrame();
////        fQuiz.setSize(500, 500);
//
//        // Initialisation des variables d'instance
//        this.content = new Box(BoxLayout.PAGE_AXIS);
//        this.questionP = new QuestionPanel();
//        this.answerP = new AnswerPanel();
//        this.choiceP = new ChoicePanel();
//
//        // initialisation du contenu
//        this.initGUI();
//
//        // Initialisation de la fenêtre
//        this.setContentPane(content);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermeture
//        this.setResizable(false); // Fenêtre non-redimensionnable
//        this.pack(); // Ajustement de la taille au contenu
//        // On positionne la fenêtre au milieu de l'écran
//        this.setLocationRelativeTo(null);
//        this.setVisible(true); // Affichage de la fenêtre
//    }
//
//    private void initGUI() {
//        // Ajout des differents panneaux dans le contenu
//        this.content.add(questionP, BorderLayout.NORTH);
//        this.content.add(answerP, BorderLayout.CENTER);
//        this.content.add(choiceP, BorderLayout.SOUTH);
//    }
//}
