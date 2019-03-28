/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_jérémie;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jérémie Estival
 */
public class Calcul extends JFrame {

    private final JPanel container = new JPanel();

    public final boolean niveau = false;
    public int resultat;

    private final JLabel label1 = new JLabel("Saisies la bonne réponse ! ");

    private final JTextField reponse = new JTextField();
    String reponseSaisie;

    private final JLabel label3 = new JLabel("Réponse");

    private final JButton b1 = new JButton("Valider");
    private final JButton b2 = new JButton("Solution");
    private final JButton b3 = new JButton("Autre calcul");
    private final JButton b4 = new JButton("Retour");
    private final JPanel Global = new JPanel();
    
    public Calcul() {

        reponse.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                System.out.println("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                reponseSaisie = reponse.getText();

            }
        });

        this.setTitle("Calcul");

        this.setSize(600, 600);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLocationRelativeTo(null);

        container.setBackground(Color.white);

        container.setLayout(new BorderLayout());

        

        JPanel P1 = new JPanel();

        P1.add(label1);
        P1.setBackground(Color.WHITE);
        P1.setLayout(new FlowLayout(FlowLayout.LEFT));
        P1.setPreferredSize(new Dimension(10, 10));
        this.setContentPane(container);

        this.setVisible(true);
        this.getContentPane().add(b4, BorderLayout.WEST);
        Font police1 = new Font("Tahoma", Font.BOLD, 12);
        b4.setFont(police1);

        b4.setPreferredSize(new Dimension(100, 1));
        b4.addActionListener(new MonListener());

        if (niveau) {
            CreationCalculNiveau1();
        } else {
            CreationCalculNiveau2();
        }

        JPanel P3 = new JPanel();

        Font police3 = new Font("Tahoma", Font.BOLD, 14);
        Font police2 = new Font("Arial", Font.BOLD, 20);
        label3.setFont(police3);

        reponse.setFont(police2);

        reponse.setPreferredSize(new Dimension(150, 30));

        reponse.setForeground(Color.BLACK);

        P3.add(label3);

        P3.add(reponse);

        container.add(P3, BorderLayout.SOUTH);

        Global.add(P1, BorderLayout.NORTH);
        
        Global.add(P3, BorderLayout.SOUTH);

        this.setContentPane(Global);

        this.setResizable(false);

        this.setVisible(true);

        P3.add(b1, BorderLayout.WEST);
        b1.addActionListener(new MonListener());
        P3.add(b2, BorderLayout.CENTER);
        b2.addActionListener(new MonListener());
        P3.add(b3, BorderLayout.EAST);
        b3.addActionListener(new MonListener());
        this.setLayout(new BorderLayout());

    }

    private void CreationCalculNiveau1() {

        int nombre1 = (int) (Math.random() * (0 - -9));
        int nombre2 = (int) (Math.random() * (0 - -9));
        resultat = nombre1 + nombre2;
        JLabel label2 = new JLabel(nombre1 + " + " + nombre2);
        JPanel P2 = new JPanel();
        this.Global.add(P2, BorderLayout.CENTER);

        P2.add(label2);
        Font police2 = new Font("Arial", Font.BOLD, 20);
        label2.setFont(police2);

        container.add(P2, BorderLayout.CENTER);

        this.setContentPane(container);

        this.setVisible(true);
    }

    private void CreationCalculNiveau2() {

        int nombre1 = (int) (Math.random() * (10 - -100));
        int nombre2 = (int) (Math.random() * (10 - -100));
        resultat = nombre1 + nombre2;
        JLabel label2 = new JLabel(nombre1 + " + " + nombre2);
        JPanel P2 = new JPanel();
        Global.add(P2, BorderLayout.CENTER);

        P2.add(label2);
        Font police2 = new Font("Arial", Font.BOLD, 20);
        label2.setFont(police2);

        container.add(P2, BorderLayout.CENTER);

        this.setContentPane(container);

        this.setVisible(true);
    }

    private class MonListener implements ActionListener {

        @Override

        public void actionPerformed(ActionEvent e) {
            String s = ((JButton) e.getSource()).getText();

            if ("Autre calcul".equals(s)) {
                setVisible(false);
                Calcul calc = new Calcul();
            }

            if ("Solution".equals(s)) {
                JOptionPane.showMessageDialog(null, "Solution: " + resultat);
            }

            int reponseInt = Integer.parseInt(reponse.getText());

            if ("Valider".equals(s)) {
                if (reponseInt == resultat) {
                    JOptionPane.showMessageDialog(null, "T'es solide");
                } else {
                    JOptionPane.showMessageDialog(null, "T'es nul");
                }

            }

        }

    }

}
