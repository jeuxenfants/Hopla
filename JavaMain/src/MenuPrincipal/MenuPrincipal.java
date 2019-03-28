/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuPrincipal;

import Level.Level;
import Acitivities.Activities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Expression Cedric is undefined on line 12, column 14 in
 * Templates/Classes/Class.java.
 */
public class MenuPrincipal extends JFrame {

    private final JPanel content;//Panel du contenu de la frame
    private final JButton Activities, Level, Valider;//Bouttons pour les differents menus accessible du menu principal 
    private final JLabel affichage;
    private final String name = "Menu Principal";//Nom de la fenetre 
    private final JTextField saisieMDP;//Zone de texte pour rentrer un mot de passe (pour le mode admin)
    String nom_fichier_image = "fond.jpg";

    public MenuPrincipal() {
        this.setSize(new Dimension(600,600));
        JLabel motDePasse = new JLabel("Mot de passe ");//Nom de la zone de texte pour rentrer le mot de passe 
        this.saisieMDP = new JTextField(10);//Création de la zone de texte limité a 10 caratères
        this.setTitle(name);//Donner le nom à la fenetre active 
        affichage = new JLabel();
        
        //this.setLayout(new BorderLayout());
        ///this.add(affichage, BorderLayout.CENTER);
        
        content = new JPanel()//création d'un panel pour le contenu de la frame
                {
            @Override
            protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
                ImageIcon m = new ImageIcon(nom_fichier_image);
                Image monImage = m.getImage();
                g.drawImage(monImage, 0, 0,this);
               
            }
        };
        
        //content.setBackground(Color.red);
        JPanel boutons = new JPanel();//Création d'un panel pour les bouttons 
        boutons.setOpaque(false);

        JPanel affichagePanel = new JPanel();
        affichagePanel.setOpaque(false);
        content.setLayout(new BorderLayout());

        Activities = new JButton("Activities");//Création du boutton pour les activités
        Activities.addActionListener(new MonListener());//Ajout d'un ecouteur sur ce bouton 
        Level = new JButton("Level");//Création du boutton pour les niveaux
        Level.addActionListener(new MonListener());
        Valider = new JButton("Valider");//Création du boutton pour la validation du mot de passe
        Valider.addActionListener(new MonListener());

        boutons.add(Activities, BorderLayout.LINE_START);//Placement des bouttons dans le panel boutons pour les placer 
        boutons.add(Level, BorderLayout.LINE_END);

        affichagePanel.add(affichage);
        affichagePanel.add(motDePasse, FlowLayout.LEFT);//Ajout du label mdp, zone de text mdp et du bouton valider dans le panel d'affichage
        affichagePanel.add(Valider, FlowLayout.RIGHT);
        affichagePanel.add(saisieMDP, FlowLayout.RIGHT);

        content.add(boutons);//ajout du panel de bouttons dans le panel content et placement
        content.add(affichagePanel, BorderLayout.NORTH);

        //this.setContentPane(content);
        getContentPane().add(content);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false); // Fenêtre non-redimensionnable
        setVisible(true);//rend la fenetre visible 

    }

    private class MonListener implements ActionListener {

        @Override

        public void actionPerformed(ActionEvent e) {
            String mdp = "hopla";//définition d'un mot de passe pour test 

            String s = ((JButton) e.getSource()).getText();//Récuperation du texte sur le boutton sur lequel on clique
            if ("Level".equals(s)) {//Comparaison du texte suivant avec le texte du bouton pour déclencher une action si c'est le même texte
                setVisible(false);//rend la fenetre active invisible 
                Level test = new Level();//création d'une fenetre du menu de niveau
            }
            if ("Activities".equals(s)) {//Comparaison du texte suivant avec le texte du bouton pour déclencher une action si c'est le même texte
                setVisible(false);//rend la fenetre active invisible 
                Activities test = new Activities();//création d'une fenetre d'activité 
            }
            if ("Valider".equals(s) && saisieMDP.getText().equals(mdp)) {//Comparaison du texte suivant avec le texte du bouton pour déclencher une action si c'est le même texte avec comparaison du mot de passe rentrer aussi

                setVisible(false);//rend la fenetre active invisible 

                MenuPrincipalAdmin menu = new MenuPrincipalAdmin();//passage au mode admin 

                
            }
        }
    }
}
