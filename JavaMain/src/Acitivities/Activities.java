/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acitivities;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import MenuPrincipal.MenuPrincipal;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Expression Cedric is undefined on line 12, column 14 in
 * Templates/Classes/Class.java.
 */
public class Activities extends JFrame {

    private final JPanel content;//Création d'un Panel qui aura le contenu de la fenetre 
    private final JButton draw, math, culture, retour;//Création des bouttons pour chaque activités de l'application 
    private final JLabel affichage;
    private final String name = "Activities";//Nom donné au groupe qui contient les jeux de l'application
    String image = "backactivities.jpg";
    
    public Activities() {//contructor pour l'interface du menu activité
        this.setSize(600, 600);
        this.setTitle(name);// Titre de la fenetre 
        affichage = new JLabel();
        content = new JPanel()
                {
            @Override
            protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
                ImageIcon m = new ImageIcon(image);
                Image monImage = m.getImage();
                g.drawImage(monImage, 0, 0,this);
               
            }
        };
        JPanel boutons = new JPanel();
        boutons.setOpaque(false);
        JPanel affichagePanel = new JPanel();
        affichagePanel.setOpaque(false);
        content.setLayout(new BorderLayout());

        draw = new JButton("draw");//Création du bouton qui donne accès au jeu de dessin
        draw.addActionListener(new MonListener());//ajout d'un ecouteur sur le bouton de dessin
        math = new JButton("math");//création du bouton qui ddonne accès au jeu de calcul
        math.addActionListener(new MonListener());//ajout d'un ecouteur sur le bouton vers le jeu de calcul
        culture = new JButton("culture");//Création du bouton qui donne accès au jeu de question de culture 
        culture.addActionListener(new MonListener());//ajout d'un ecouteur sur le bouton vers le jeu de question 
        retour = new JButton("retour");//Création d'un bouton de retour qui permet de revenir au menu Principal
        retour.addActionListener(new MonListener());//ajout d'un ecouteur sur le bouton de retour 

        boutons.add(draw, BorderLayout.NORTH);//Placement des boutons dans le panel bouton pour les placer 
        boutons.add(math, BorderLayout.CENTER);
        boutons.add(culture, BorderLayout.NORTH);
        boutons.add(retour, BorderLayout.PAGE_END);

        affichagePanel.add(affichage);//ajout d'un panel dans le label affichage 

        content.add(boutons);//ajout des boutons placés dans le contenu de la fenetre 
        content.add(affichagePanel, BorderLayout.SOUTH);

        this.setContentPane(content);
        setDefaultCloseOperation(EXIT_ON_CLOSE);//fermeture du programme en cliquant su la croix
        setLocationRelativeTo(null);
        this.setResizable(false); // Fenêtre non-redimensionnable
        setVisible(true);//rendre la fenetre visible après la définition des emplacements des élements 
    }

    private class MonListener implements ActionListener {
        //Personnalisation des écouteurs sur les bouttons
        @Override
        public void actionPerformed(ActionEvent e) {

            String s = ((JButton) e.getSource()).getText();//Récuperation du texte sur le boutton sur lequel on clique
            if ("draw".equals(s)) {//Comparaison du texte suivant avec le texte du bouton pour déclencher une action si c'est le même texte
                JOptionPane.showMessageDialog(null, "Let's go for some " + s);//Pop up pour le choix de l'activité
                setVisible(false);//Rendre la fentre invisible 

            }
            if ("math".equals(s)) {//Comparaison du texte suivant avec le texte du bouton pour déclencher une action si c'est le même texte
                JOptionPane.showMessageDialog(null, "Let's go for some " + s);//Pop up pour le choix de l'activité
                setVisible(false);//Rendre la fentre invisible 

            }
            if ("culture".equals(s)) {//Comparaison du texte suivant avec le texte du bouton pour déclencher une action si c'est le même texte
                JOptionPane.showMessageDialog(null, "Let's go for some questions about " + s);//Pop up pour le choix de l'activité
                setVisible(false);//Rendre la fentre invisible 

            }
            if ("retour".equals(s)) {//Comparaison du texte suivant avec le texte du bouton pour déclencher une action si c'est le même texte
                setVisible(false);//Rendre la fentre invisible 
                MenuPrincipal menu = new MenuPrincipal();//retour vers le menu Principal 
            }
        }
    }
}
