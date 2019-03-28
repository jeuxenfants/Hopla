/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MenuPrincipal;

import MenuPrincipal.MenuPrincipal;
import Level.LevelAdmin;
import Acitivities.ActivitiesAdmin;
import Administration.Admin;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Expression Cedric is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class MenuPrincipalAdmin extends MenuPrincipal{

    private final JPanel content;//Panel du contenu de la frame
    
    private final JButton Activities, Level, Administration,OutAdmin;//Bouttons pour les differents menus accessible du menu principal Admin
    private final JLabel affichage;
    private final String name = "Menu Principal Administrateur";//Nom de la fenetre 
    String image = "fond.jpg";

    public MenuPrincipalAdmin() {
        this.setSize(600,600); 
        this.setTitle(name);//Donner le nom à la fenetre active 
        affichage = new JLabel();
        content = new JPanel()//création d'un panel pour le contenu de la frame
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
        JPanel boutons = new JPanel();//Création d'un panel pour les bouttons 
        boutons.setOpaque(false);
        JPanel affichagePanel = new JPanel();
        affichagePanel.setOpaque(false);
        content.setLayout(new BorderLayout());

        Activities = new JButton("Activities");//Création du boutton pour les activités
        Activities.addActionListener(new MonListener());//Ajout d'un ecouteur sur ce bouton 
        Level = new JButton("Level");//Création du boutton pour les niveaux de difficultés
        Level.addActionListener(new MonListener());//Ajout d'un ecouteur sur ce bouton 
        Administration = new JButton("Administration");//Création du boutton pour les options d'adminitrations
        Administration.addActionListener(new MonListener());//Ajout d'un ecouteur sur ce bouton 
        OutAdmin = new JButton ("Normal");//Création du boutton pour sortir du mode Admin
        OutAdmin.addActionListener(new MonListener());//Ajout d'un ecouteur sur ce bouton 

        boutons.add(Activities, BorderLayout.LINE_START);//Ajout des bouttons dans le panel bouttons avec placement des bouttons dans celui ci 
        boutons.add(Level, BorderLayout.CENTER);
        boutons.add(OutAdmin,BorderLayout.LINE_END);
        boutons.add(Administration, BorderLayout.LINE_END);

        affichagePanel.add(affichage);
        
       
      
        content.add(boutons);//ajout du panel bouttons au panel content
        content.add(affichagePanel, BorderLayout.NORTH);//placement des differents panel dans la fenetre 

        this.setContentPane(content);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false); // Fenêtre non-redimensionnable
        setVisible(true);//rend la fenetre visible 
    }

    private class MonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String s = ((JButton) e.getSource()).getText();//Récuperation du texte sur le boutton sur lequel on clique
            if ("Level".equals(s)) {//Comparaison du texte suivant avec le texte du bouton pour déclencher une action si c'est le même texte
                setVisible(false);//rend la fenetre active invisible 
                LevelAdmin test = new LevelAdmin();
            }
            if ("Activities".equals(s)) {//Comparaison du texte suivant avec le texte du bouton pour déclencher une action si c'est le même texte
                setVisible(false);//rend la fenetre active invisible 
                ActivitiesAdmin test = new ActivitiesAdmin();
            }
          if("Administration".equals(s)){
                setVisible(false);
                Admin test = new Admin();
            if("Normal".equals(s))//Comparaison du texte suivant avec le texte du bouton pour déclencher une action si c'est le même texte
            {
                setVisible(false);//rend la fenetre active invisible 
                MenuPrincipal test1 = new MenuPrincipal();
//retour a la création d'un menu principal normal 
            }

        }
    }
}
}
