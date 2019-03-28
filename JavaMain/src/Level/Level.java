/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Level;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import MenuPrincipal.MenuPrincipal;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Level extends JFrame {

    private final JPanel content;//Création d'un Panel qui aura le contenu de la fenetre 
    private final JButton L1, L2, retour;//Création des bouttons de choix du niveau 
    private final JLabel affichage;
    private final String name = "Level";//Nom de la fenetre en mode normal
    String image= "backlevel.jpg";
    java.applet.AudioClip son=null;

    public Level() {
        java.net.URL url = Level.class.getResource("magic.wav");
        son = java.applet.Applet.newAudioClip(url);
        this.setSize(600,600);
        this.setTitle(name);//Afficher le nom de la fenetre 
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
        boutons.setLayout(new BoxLayout(boutons, BoxLayout.PAGE_AXIS));
        
        boutons.setPreferredSize(new Dimension(250,600)); //Pour placer le panel a droite de la fenetre
        
        JPanel affichagePanel = new JPanel();
        affichagePanel.setOpaque(false);
        content.setLayout(new BorderLayout(100,100));

        L1 = new JButton("LEVEL 1");//Creation du boutton pour le niveau 1
        L1.addActionListener(new MonListener());//Ajout d'un ecouteur le boutton de niveau 1
        L1.setFont(new Font("sansserif", Font.BOLD, 35)); //Changement de la police et de la taille     
        L2 = new JButton("LEVEL 2");//Creation du boutton pour le niveau 2
        L2.addActionListener(new MonListener());//Ajout d'un ecouteur le boutton de niveau 2
        L2.setFont(new Font("sansserif", Font.BOLD, 35));
        retour = new JButton("retour");//Création d'un bouton de retour qui permet de revenir au menu Principal
        retour.addActionListener(new MonListener());//Ajout d'un ecouteur le boutton de retour
        retour.setFont(new Font("sansserif", Font.BOLD, 35));

        boutons.add(L1, BorderLayout.NORTH);//Ajout des bouttons dans le Panel de boutton avec organisation de leurs emplacements 
        boutons.add(Box.createVerticalStrut(50));
        boutons.add(L2, BorderLayout.CENTER);
        boutons.add(Box.createVerticalStrut(50));
        boutons.add(retour, BorderLayout.SOUTH);
        affichagePanel.add(affichage);//ajout d'un panel dans le label affichage

        content.add(boutons, BorderLayout.EAST);//ajout des boutons placés dans le contenu de la fenetre 
        content.add(affichagePanel, BorderLayout.NORTH);

        this.setContentPane(content);
        setDefaultCloseOperation(EXIT_ON_CLOSE);//fermeture du programme en cliquant su la croix
        setLocationRelativeTo(null);
        this.setResizable(false); // Fenêtre non-redimensionnable
        setVisible(true);//rendre la fenetre visible après la définition des emplacements des élements 
    }

    private class MonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String s = ((JButton) e.getSource()).getText();//Récuperation du texte sur le boutton sur lequel on clique
            if ("LEVEL 1".equals(s)) {//Comparaison du texte suivant avec le texte du bouton pour déclencher une action si c'est le même texte
                son.play();
                JOptionPane.showMessageDialog(null, "Vous avez choix le " + s);//Pop up por spécifier le choix du niveau 
                setVisible(false);
                MenuPrincipal menu = new MenuPrincipal();

            }
            if ("LEVEL 2".equals(s)) {//Comparaison du texte suivant avec le texte du bouton pour déclencher une action si c'est le même texte
                JOptionPane.showMessageDialog(null, "Vous avez choix le " + s);//Pop up por spécifier le choix du niveau 
                setVisible(false);
                MenuPrincipal menu = new MenuPrincipal();
                
            }
            if ("retour".equals(s)) {//Comparaison du texte suivant avec le texte du bouton pour déclencher une action si c'est le même texte
                MenuPrincipal menu = new MenuPrincipal();//création d'un menu principal
              
               
                {
                    //pack();
                }
            }
        }
    }
}
