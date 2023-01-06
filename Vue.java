import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Vue extends JFrame {
    // attributs
    Modele modele;
    Controleur controleur;
    JPanel window;
    JPanel vuePlateau;
    JPanel panneauChoix;
    JPanel tuilePiochee;
    ArrayList<ArrayList<JButton>> boutonPlateau;
    int nbPivot;

    // constructeur
    public Vue(Controleur controleur, Modele modele, Jeu jeu) throws IOException {
        // initialisation de tous les attributs
        this.modele = modele;
        this.controleur = controleur;
        this.window = new JPanel();
        this.vuePlateau = new JPanel();
        this.panneauChoix = new JPanel();
        this.boutonPlateau = new ArrayList<>();
        this.nbPivot = 0;
        BufferedImage path;
        if(jeu.getParametres().getTypeDeJeu().equals("c")) {
            File file = ((TuileCarcassonne) jeu.getJoueurQuiJoue().getTuileEnMain()).getChemin();
            path = ImageIO.read(file);
            this.tuilePiochee = new ImagePane(path);
        }
        else {
            this.tuilePiochee = new JPanel();
            this.tuilePiochee.add(new JLabel(jeu.getJoueurQuiJoue().getTuileEnMain().getHaut()[0].toString() + "     " + jeu.getJoueurQuiJoue().getTuileEnMain().getHaut()[1].toString() + "     " + jeu.getJoueurQuiJoue().getTuileEnMain().getHaut()[2].toString()));
            this.tuilePiochee.add(new JLabel(jeu.getJoueurQuiJoue().getTuileEnMain().getGauche()[2].toString() + "                       " + jeu.getJoueurQuiJoue().getTuileEnMain().getDroite()[0].toString()));
            this.tuilePiochee.add(new JLabel(jeu.getJoueurQuiJoue().getTuileEnMain().getGauche()[1].toString() + "                       " + jeu.getJoueurQuiJoue().getTuileEnMain().getDroite()[1].toString()));
            this.tuilePiochee.add(new JLabel(jeu.getJoueurQuiJoue().getTuileEnMain().getGauche()[0].toString() + "                       " + jeu.getJoueurQuiJoue().getTuileEnMain().getDroite()[2].toString()));
            this.tuilePiochee.add(new JLabel(jeu.getJoueurQuiJoue().getTuileEnMain().getBas()[2].toString() + "     " + jeu.getJoueurQuiJoue().getTuileEnMain().getBas()[1].toString() + "     " + jeu.getJoueurQuiJoue().getTuileEnMain().getBas()[0].toString()));
        }
        this.modele.setTuilePiochee(this.tuilePiochee);

        // paramètres de la fenêtre
        if(jeu.getParametres().getTypeDeJeu().equals("c")) {
            this.setTitle("Carcassonne");
        }
        else {
            this.setTitle("Domino");
        }
        this.setSize(1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // création de la vue qui symbolisera le plateau
        this.vuePlateau.setLayout(new GridLayout(jeu.getP().getPlateau().size(), jeu.getP().getPlateau().get(0).size()));
        // ce plateau est une matrice de bouton
        for(int i = 0; i < jeu.getP().getPlateau().size(); i++){
            this.boutonPlateau.add(new ArrayList<>());
            for(int j = 0; j < jeu.getP().getPlateau().get(0).size(); j++){
                // création du bouton dont la taille est adaptée au nombre de boutons nécessaires
                JButton btn = new JButton();
                btn.setSize(new Dimension(Math.min(800/jeu.getP().getPlateau().get(0).size(), 800/jeu.getP().getPlateau().size()), Math.min(800/jeu.getP().getPlateau().get(0).size(),800/jeu.getP().getPlateau().size())));

                // s'il y a une tuile présente sur cette case du plateau
                if(!jeu.getP().getPlateau().get(i).get(j).estVide()) {

                    if (jeu.getParametres().getTypeDeJeu().equals("c")) {
                        // on affiche l'image
                        ImageIcon imageIcon = new ImageIcon(((TuileCarcassonne) jeu.getP().getPlateau().get(i).get(j).getTuile()).getChemin().getAbsolutePath());
                        Image image = imageIcon.getImage();
                        Image newimg = image.getScaledInstance(btn.getWidth(), btn.getHeight(), java.awt.Image.SCALE_SMOOTH);
                        imageIcon = new ImageIcon(newimg);

                        // l'orientation de la tuile est adaptée
                        RotatedIcon r1 = new RotatedIcon(imageIcon);
                        for (int n = -1; n < ((TuileCarcassonne) jeu.getP().getPlateau().get(i).get(j).getTuile()).getNbPivot(); n++) {
                            r1 = new RotatedIcon(r1, RotatedIcon.Rotate.DOWN);
                        }
                        btn = new JButton(r1);
                        btn.setSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));

                    }
                    else {
                        JPanel tuile = new JPanel();
                        tuile.add(new JLabel(jeu.getJoueurQuiJoue().getTuileEnMain().getHaut()[0].toString() + "     " + jeu.getJoueurQuiJoue().getTuileEnMain().getHaut()[1].toString() + "     " + jeu.getJoueurQuiJoue().getTuileEnMain().getHaut()[2].toString()));
                        tuile.add(new JLabel(jeu.getJoueurQuiJoue().getTuileEnMain().getGauche()[2].toString() + "                       " + jeu.getJoueurQuiJoue().getTuileEnMain().getDroite()[0].toString()));
                        tuile.add(new JLabel(jeu.getJoueurQuiJoue().getTuileEnMain().getGauche()[1].toString() + "                       " + jeu.getJoueurQuiJoue().getTuileEnMain().getDroite()[1].toString()));
                        tuile.add(new JLabel(jeu.getJoueurQuiJoue().getTuileEnMain().getGauche()[0].toString() + "                       " + jeu.getJoueurQuiJoue().getTuileEnMain().getDroite()[2].toString()));
                        tuile.add(new JLabel(jeu.getJoueurQuiJoue().getTuileEnMain().getBas()[2].toString() + "     " + jeu.getJoueurQuiJoue().getTuileEnMain().getBas()[1].toString() + "     " + jeu.getJoueurQuiJoue().getTuileEnMain().getBas()[0].toString()));

                        tuile.setPreferredSize(new Dimension(110,110));

                        final BufferedImage bi;
                        bi = createImage(tuile);

                        tuile = new JPanel() {

                            @Override
                            public Dimension getPreferredSize() {
                                return new Dimension(110, 110);
                            }

                            @Override
                            public void paintComponent(Graphics g) {
                                super.paintComponent(g);
                                Graphics2D g2 = (Graphics2D) g;
                                g2.drawImage(bi, 0, 0, null);
                            }
                        };

                        BufferedImage bi2 = createImage(tuile);

                        Icon icon = new ImageIcon(bi2);

                        btn = new JButton(icon);
                        btn.setSize(new Dimension(110,110));
                    }
                }
                // les boutons sont cliquables uniquement si la tuile piochée peut être jouée
                else {
                    btn.setEnabled(jeu.getP().getMatriceAdjacence().get(i).get(j) != 0);
                }
                this.boutonPlateau.get(i).add(btn);
                this.vuePlateau.add(btn);
            }
        }

        // création du panneau de choix pour le joueur
        this.panneauChoix.setBackground(new Color(50, 200,255));
        this.panneauChoix.setPreferredSize(new Dimension(500, 800));

        JLabel l = new JLabel("Il y a " + jeu.getSac().getLength() + " tuiles restantes dans le sac.");
        l.setPreferredSize(new Dimension(this.getWidth() / 3, 50));
        l.setHorizontalAlignment(JLabel.CENTER);
        this.panneauChoix.add(l);
        if(jeu.getParametres().getTypeDeJeu().equals("c")) {
            // pour chaque joueur autour de la table
            for (Joueur j : jeu.getParametres().getTable().getJoueurs()) {
                String nomJ = "<span style='color:"+ ((JoueurCarcassonne)j).getCouleur() +"'>" + j.getNom() + "</span>";
                // on affiche son nombre de partisans
                JLabel label = new JLabel("<html>" + nomJ + " a " + ((JoueurCarcassonne) j).getNbPartisans() + " partisans en main.\n</html>");
                label.setPreferredSize(new Dimension(this.getWidth() / 3, 50));
                label.setHorizontalAlignment(JLabel.CENTER);
                this.panneauChoix.add(label);
            }
        }

        // affichage du joueur qui doit jouer
        String annonce = "C'est à "+ jeu.getJoueurQuiJoue().getNom() +" de jouer. Voici la tuile piochée :";
        JLabel ligne1 = new JLabel(annonce);
        ligne1.setPreferredSize(new Dimension(this.getWidth()/3, 50));
        ligne1.setHorizontalAlignment(JLabel.CENTER);
        this.panneauChoix.add(ligne1);
        // affichage du bouton pour tourner la tuile
        JButton tournerButton = new JButton("Tourner la tuile ");
        this.panneauChoix.add(tournerButton);
        // affichage du bouton pour défausser la tuile
        JButton defausserButton = new JButton("Défausser la tuile");
        this.panneauChoix.add(defausserButton);
        // affichage du bouton pour abandonner la partie
        JButton abandonnerButton = new JButton("Abandonne la partie");
        this.panneauChoix.add(abandonnerButton);
        
        // affichage de la tuile piochée
        this.tuilePiochee.setPreferredSize(new Dimension(110,110));
        this.panneauChoix.add(this.tuilePiochee);
        
        // ajout de tous les composants à la fenêtre
        this.window.setLayout(new BoxLayout(this.window, BoxLayout.LINE_AXIS));
        this.window.add(panneauChoix);
        this.window.add(vuePlateau);
        this.window.add(Box.createHorizontalGlue());
        this.getContentPane().add(window);

        controleur.setVue(this);

        pack();
        setVisible(true);

        // tous les addActionListener pour tous les boutons
        // bouton abandonner
        abandonnerButton.addActionListener(event -> {
            try {
                this.miseAJourPanneauChoixAbandon(jeu.getJoueurQuiJoue(), jeu);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        // bouton défausser
        defausserButton.addActionListener(event -> {
            try {
                this.miseAJourPlateau(jeu);
                pack();
                setVisible(true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        // bouton tourner la tuile
        tournerButton.addActionListener(event -> {
            this.panneauChoix.remove(this.tuilePiochee);
            final BufferedImage bi;
            bi = createImage(this.tuilePiochee);

            this.tuilePiochee = new JPanel() {

                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(bi.getWidth(), bi.getHeight());
                }

                @Override
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2 = (Graphics2D) g;
                    g2.rotate(Math.PI/2, (float)bi.getWidth() / 2, (float)bi.getHeight() / 2);
                    g2.drawImage(bi, 0, 0, null);
                }
            };
            jeu.getJoueurQuiJoue().getTuileEnMain().tourner();
            this.panneauChoix.add(this.tuilePiochee);
            controleur.tuileTournee(this.tuilePiochee);
        });
        

        // pour chaque tuile du plateau
        for (int i = 0 ; i < this.boutonPlateau.size() ; i++) {
            for (int j = 0 ; j < this.boutonPlateau.get(0).size() ; j++) {
                final int xi = i;
                final int xj = j;
                // si ce bouton est pressé
                this.boutonPlateau.get(xi).get(xj).addActionListener(event -> {
                    // on vérifie si l'emplacement est valide pour la tuile piochée
                    boolean emplacementPossible = false;
                    if(jeu.getP().getPlateau().get(xi).get(xj).estVide()) {
                        if ((xi+1) < jeu.getP().getPlateau().size()) {
                            if (!jeu.getP().getPlateau().get(xi + 1).get(xj).estVide()) {
                                emplacementPossible = jeu.getJoueurQuiJoue().getTuileEnMain().cotesEgaux(jeu.getP().getPlateau().get(xi + 1).get(xj).getTuile()).contains("h");
                            }
                        }
                        if ((xi-1) >= 0) {
                            if (!jeu.getP().getPlateau().get(xi - 1).get(xj).estVide()) {
                                emplacementPossible = jeu.getJoueurQuiJoue().getTuileEnMain().cotesEgaux(jeu.getP().getPlateau().get(xi - 1).get(xj).getTuile()).contains("b");
                            }
                        }
                        if ((xj+1) < jeu.getP().getPlateau().get(0).size()) {
                            if (!jeu.getP().getPlateau().get(xi).get(xj + 1).estVide()) {
                                emplacementPossible = jeu.getJoueurQuiJoue().getTuileEnMain().cotesEgaux(jeu.getP().getPlateau().get(xi).get(xj + 1).getTuile()).contains("g");
                            }
                        }
                        if ((xj-1) >= 0) {
                            if (!jeu.getP().getPlateau().get(xi).get(xj - 1).estVide()) {
                                emplacementPossible = jeu.getJoueurQuiJoue().getTuileEnMain().cotesEgaux(jeu.getP().getPlateau().get(xi).get(xj - 1).getTuile()).contains("d");
                            }
                        }
                        // si l'emplacement est valide
                        if (emplacementPossible) {
                            try {
                                // on pose la tuile
                                this.panneauChoix.remove(this.tuilePiochee);
                                if (jeu.getParametres().getTypeDeJeu().equals("c")) {
                                    ((TuileCarcassonne) (jeu.getJoueurQuiJoue().getTuileEnMain())).setNbPivot(this.nbPivot);
                                    controleur.tuilePosee(xi, xj, (TuileCarcassonne) jeu.getJoueurQuiJoue().getTuileEnMain(), jeu);
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                });
            }
        }

        // si le joueur qui doit jouer est un ordinateur
        if (jeu.getJoueurQuiJoue().getType().equals("o")){
            for (Emplacement emplacementLibre : jeu.getP().emplacementsLibres()) {
                // si on peut jouer sur cet emplacement, on le stocke
                if (jeu.emplacementOuJouer(emplacementLibre, false)) {
                    jeu.emplacementOuJouer(emplacementLibre, true);
                    break;
                }
            }
            this.miseAJourPlateau(jeu);
            pack();
            setVisible(true);
        }
    }
    // méthode pour récupérer une Image à partir d'un JPanel
    private BufferedImage createImage(JPanel panel) {
        int w = panel.getWidth();
        int h = panel.getHeight();
        if (w == 0){
            w = 110;
        }
        if (h == 0){
            h = 110;
        }
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        panel.paint(g);
        return bi;
    }

    // méthode pour mettre à jour la tuile qui a été piochée (notamment après l'avoir tournée)
    public void miseAJourTuilePiochee() {
        this.tuilePiochee = this.modele.tuilePiochee;
        this.nbPivot += 1;
        pack();
        setVisible(true);
    }

    // méthode pour mettre à jour le plateau (notamment après avoir posé une tuile)
    public void miseAJourPlateau(Jeu jeu) throws IOException {
        // si le sac est vide
        if (jeu.getSac().estVide()) {
            // le jeu est terminé
            this.miseAJourPanneauChoixSacVide(jeu);
            afficherPlateau(jeu);
        }
        // on refait à peu près la même chose que lors de l'initialisation de la vue
        else {
            this.miseAJourPanneauChoixPartisan(jeu);
            this.window.remove(vuePlateau);
            this.vuePlateau = new JPanel();
            this.boutonPlateau = new ArrayList<>();
            this.vuePlateau.setLayout(new GridLayout(jeu.getP().getPlateau().size(), jeu.getP().getPlateau().get(0).size()));
            for (int i = 0; i < jeu.getP().getPlateau().size(); i++) {
                this.boutonPlateau.add(new ArrayList<>());
                for (int j = 0; j < jeu.getP().getPlateau().get(0).size(); j++) {

                    JButton btn = createPlateauButton(jeu);
                    if (!jeu.getP().getPlateau().get(i).get(j).estVide()) {
                        btn = affichageEmplacement(jeu, btn, i, j);
                    } else {
                        btn.setEnabled(jeu.getP().getMatriceAdjacence().get(i).get(j) != 0);
                    }
                    this.boutonPlateau.get(i).add(btn);
                    this.vuePlateau.add(btn);
                }
            }
            for (int i = 0; i < this.boutonPlateau.size(); i++) {
                for (int j = 0; j < this.boutonPlateau.get(0).size(); j++) {
                    final int xi = i;
                    final int xj = j;
                    this.boutonPlateau.get(xi).get(xj).addActionListener(event -> {
                        String emplacementPossible = "";
                        if (jeu.getP().getPlateau().get(xi).get(xj).estVide()) {
                            if ((xi + 1) < jeu.getP().getPlateau().size()) {
                                if (!jeu.getP().getPlateau().get(xi + 1).get(xj).estVide()) {
                                    if (jeu.getJoueurQuiJoue().getTuileEnMain().cotesEgaux(jeu.getP().getPlateau().get(xi + 1).get(xj).getTuile()).contains("h")) {
                                        emplacementPossible = "o";
                                    } else {
                                        emplacementPossible = "n";
                                    }
                                }
                            }
                            if ((xi - 1) >= 0 && !emplacementPossible.equals("n")) {
                                if (!jeu.getP().getPlateau().get(xi - 1).get(xj).estVide()) {
                                    if (jeu.getJoueurQuiJoue().getTuileEnMain().cotesEgaux(jeu.getP().getPlateau().get(xi - 1).get(xj).getTuile()).contains("b")) {
                                        emplacementPossible = "o";
                                    } else {
                                        emplacementPossible = "n";
                                    }
                                }
                            }
                            if ((xj + 1) < jeu.getP().getPlateau().get(0).size() && !emplacementPossible.equals("n")) {
                                if (!jeu.getP().getPlateau().get(xi).get(xj + 1).estVide()) {
                                    if (jeu.getJoueurQuiJoue().getTuileEnMain().cotesEgaux(jeu.getP().getPlateau().get(xi).get(xj + 1).getTuile()).contains("g")) {
                                        emplacementPossible = "o";
                                    } else {
                                        emplacementPossible = "n";
                                    }
                                }
                            }
                            if ((xj - 1) >= 0 && !emplacementPossible.equals("n")) {
                                if (!jeu.getP().getPlateau().get(xi).get(xj - 1).estVide()) {
                                    if (jeu.getJoueurQuiJoue().getTuileEnMain().cotesEgaux(jeu.getP().getPlateau().get(xi).get(xj - 1).getTuile()).contains("d")) {
                                        emplacementPossible = "o";
                                    } else {
                                        emplacementPossible = "n";
                                    }
                                }
                            }
                            if (emplacementPossible.equals("o")) {
                                try {
                                    if(jeu.getParametres().getTypeDeJeu().equals("c")) {
                                        this.panneauChoix.remove(this.tuilePiochee);
                                        ((TuileCarcassonne) (jeu.getJoueurQuiJoue().getTuileEnMain())).setNbPivot(this.nbPivot);
                                        controleur.tuilePosee(xi, xj, (TuileCarcassonne) jeu.getJoueurQuiJoue().getTuileEnMain(), jeu);
                                    }
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                    });
                }
            }
        }
        this.nbPivot = 0;
        this.window.add(vuePlateau);
        pack();
        setVisible(true);
    }

    private JButton createPlateauButton(Jeu jeu) {
        JButton btn = new JButton();
        btn.setSize(new Dimension(Math.min(800 / jeu.getP().getPlateau().get(0).size(), 800 / jeu.getP().getPlateau().size()), Math.min(800 / jeu.getP().getPlateau().get(0).size(), 800 / jeu.getP().getPlateau().size())));
        return btn;
    }

    // méthode pour mettre à jour le panneau choix pour jouer un partisan
    public void miseAJourPanneauChoixPartisan(Jeu jeu) throws IOException {
        this.window.remove(panneauChoix);
        this.panneauChoix.removeAll();
        this.panneauChoix.setBackground(new Color(50, 200, 255));
        this.panneauChoix.setPreferredSize(new Dimension(500, 800));

        afficheTable(jeu);

        // affichage bouttons partisans
        JLabel ajouterPartisan = new JLabel("Voulez-vous ajouter un partisan à la tuile posée?");
        ajouterPartisan.setPreferredSize(new Dimension(this.getWidth() / 3, 50));
        ajouterPartisan.setHorizontalAlignment(JLabel.CENTER);
        this.panneauChoix.add(ajouterPartisan);
        // boutons partisans
        JButton btnPartisanHaut = new JButton("Placer un partisan en haut");
        btnPartisanHaut.setPreferredSize(new Dimension(this.getWidth() / 3, 50));
        this.panneauChoix.add(btnPartisanHaut);
        JButton btnPartisanDroite = new JButton("Placer un partisan à droite");
        btnPartisanDroite.setPreferredSize(new Dimension(this.getWidth() / 3, 50));
        this.panneauChoix.add(btnPartisanDroite);
        JButton btnPartisanGauche = new JButton("Placer un partisan à gauche");
        btnPartisanGauche.setPreferredSize(new Dimension(this.getWidth() / 3, 50));
        this.panneauChoix.add(btnPartisanGauche);
        JButton btnPartisanBas = new JButton("Placer un partisan en bas");
        btnPartisanBas.setPreferredSize(new Dimension(this.getWidth() / 3, 50));
        this.panneauChoix.add(btnPartisanBas);
        JButton btnNonPartisan = new JButton("Ne pas placer de partisan");
        btnNonPartisan.setPreferredSize(new Dimension(this.getWidth() / 3, 50));
        this.panneauChoix.add(btnNonPartisan);
        this.window.add(panneauChoix);

        // boutons partisans
        btnPartisanHaut.addActionListener(event -> {
            try {
                // récupérer joueur qui joue
                JoueurCarcassonne j = (JoueurCarcassonne)jeu.getJoueurQuiJoue();
                // ajouter lieu à la liste des partisans du joueur
                Lieu lieuHaut = (Lieu) jeu.getJoueurQuiJoue().getTuileEnMain().getHaut()[1];
                lieuHaut.setPosition("H");
                // place le partisan
                j.placePartisan((TuileCarcassonne) jeu.getJoueurQuiJoue().getTuileEnMain(), lieuHaut);
                this.miseAJourPlateau(jeu);
                controleur.tourSuivant(jeu);
                pack();
                setVisible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        btnPartisanBas.addActionListener(event -> {
            try {
                // récupérer joueur qui joue
                JoueurCarcassonne j = (JoueurCarcassonne)jeu.getJoueurQuiJoue();
                // ajouter lieu à la liste des partisans du joueur
                Lieu lieuBas = (Lieu)jeu.getJoueurQuiJoue().getTuileEnMain().getBas()[1];
                lieuBas.setPosition("B");
                // place le partisan
                j.placePartisan((TuileCarcassonne) jeu.getJoueurQuiJoue().getTuileEnMain(), lieuBas);
                this.miseAJourPlateau(jeu);
                controleur.tourSuivant(jeu);
                pack();
                setVisible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        btnPartisanDroite.addActionListener(event -> {
            try {
                // récupérer joueur qui joue
                JoueurCarcassonne j = (JoueurCarcassonne)jeu.getJoueurQuiJoue();
                // ajouter lieu à la liste des partisans du joueur
                Lieu lieuDroite = (Lieu)jeu.getJoueurQuiJoue().getTuileEnMain().getDroite()[1];
                lieuDroite.setPosition("D");
                // place le partisan
                j.placePartisan((TuileCarcassonne) jeu.getJoueurQuiJoue().getTuileEnMain(), lieuDroite);
                this.miseAJourPlateau(jeu);
                controleur.tourSuivant(jeu);
                pack();
                setVisible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        btnPartisanGauche.addActionListener(event -> {
            try {
                // récupérer joueur qui joue
                JoueurCarcassonne j = (JoueurCarcassonne)jeu.getJoueurQuiJoue();
                // ajouter lieu à la liste des partisans du joueur
                Lieu lieuGauche = (Lieu) jeu.getJoueurQuiJoue().getTuileEnMain().getGauche()[1];
                lieuGauche.setPosition("G");
                // place le partisan
                j.placePartisan((TuileCarcassonne) jeu.getJoueurQuiJoue().getTuileEnMain(), lieuGauche);
                this.miseAJourPlateau(jeu);
                controleur.tourSuivant(jeu);
                pack();
                setVisible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        btnNonPartisan.addActionListener(event -> {
                    try {
                        controleur.tourSuivant(jeu);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        // si le joueur qui doit jouer est un ordinateur
        if (jeu.getJoueurQuiJoue().getType().equals("o")) {
            controleur.tourSuivant(jeu);
            pack();
            setVisible(true);
        }
    }

    private void afficheTable(Jeu jeu) {
        JLabel l = new JLabel("Il y a " + jeu.getSac().getLength() + " tuiles restantes dans le sac.");
        l.setPreferredSize(new Dimension(this.getWidth() / 3, 50));
        l.setHorizontalAlignment(JLabel.CENTER);
        this.panneauChoix.add(l);
        for (Joueur j : jeu.getParametres().getTable().getJoueurs()) {
            String nomJ = "<span style='color:"+ ((JoueurCarcassonne)j).getCouleur() +"'>" + j.getNom() + "</span>";
            // on affiche son nombre de partisans
            JLabel label = new JLabel("<html>" + nomJ + " a " + ((JoueurCarcassonne) j).getNbPartisans() + " partisans en main.\n</html>");
            label.setPreferredSize(new Dimension(this.getWidth() / 3, 50));
            label.setHorizontalAlignment(JLabel.CENTER);
            this.panneauChoix.add(label);
        }
        String annonce = "C'est à " + jeu.getJoueurQuiJoue().getNom() + " de jouer.";
        JLabel ligne1 = new JLabel(annonce);
        ligne1.setPreferredSize(new Dimension(this.getWidth() / 3, 50));
        ligne1.setHorizontalAlignment(JLabel.CENTER);
        this.panneauChoix.add(ligne1);
    }

    // méthode pour mettre à jour le panneau choix (notamment lorsque c'est à un autre joueur de jouer)
    public void miseAJourPanneauChoix(Jeu jeu) throws IOException {
        this.window.removeAll();
        this.panneauChoix.removeAll();
        this.panneauChoix.setBackground(new Color(50, 200, 255));
        this.panneauChoix.setPreferredSize(new Dimension(500, 800));

        afficheTable(jeu);

        JPanel tuilePiochee = new JPanel();
        if (jeu.getParametres().getTypeDeJeu().equals("c")) {
            File file = ((TuileCarcassonne) jeu.getJoueurQuiJoue().getTuileEnMain()).getChemin();
            BufferedImage path = ImageIO.read(file);
            tuilePiochee = new ImagePane(path);
        }
        // boutons actions
        tuilePiochee.setPreferredSize(new Dimension(110, 110));
        this.tuilePiochee = tuilePiochee;
        JButton tournerButton = new JButton("Tourner la tuile");
        this.panneauChoix.add(tournerButton);
        JButton defausserButton = new JButton("Défausser la tuile");
        this.panneauChoix.add(defausserButton);
        JButton abandonnerButton = new JButton("Abandonne la partie");
        this.panneauChoix.add(abandonnerButton);

        // le bouton pour abandonner est cliqué
        abandonnerButton.addActionListener(event -> {
            try {
                this.miseAJourPanneauChoixAbandon(jeu.getJoueurQuiJoue(), jeu);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        // le bouton pour défausser la tuile est cliquée
        defausserButton.addActionListener(event -> {
            try {
                this.miseAJourPlateau(jeu);
                pack();
                setVisible(true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        // le bouton pour tourner la tuile est cliqué
        tournerButton.addActionListener(event -> {
            this.panneauChoix.remove(this.tuilePiochee);
            final BufferedImage bi;
            bi = createImage(this.tuilePiochee);
            this.tuilePiochee = new JPanel() {

                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(bi.getWidth(), bi.getHeight());
                }

                @Override
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2 = (Graphics2D) g;
                    g2.rotate(Math.PI / 2, (float)bi.getWidth() / 2, (float)bi.getHeight() / 2);
                    g2.drawImage(bi, 0, 0, null);
                }
            };
                
            jeu.getJoueurQuiJoue().getTuileEnMain().tourner();
            this.panneauChoix.add(this.tuilePiochee);
            controleur.tuileTournee(this.tuilePiochee);
        });

        // si le joueur qui doit jouer est un ordinateur
        if (jeu.getJoueurQuiJoue().getType().equals("o")) {
            for (Emplacement emplacementLibre : jeu.getP().emplacementsLibres()) {
                // si on peut jouer sur cet emplacement, on y joue
                if (jeu.emplacementOuJouer(emplacementLibre, false)) {
                    jeu.emplacementOuJouer(emplacementLibre, true);
                    break;
                }
            }
            this.miseAJourPlateau(jeu);
            pack();
            setVisible(true);
        }

        this.panneauChoix.add(this.tuilePiochee);
        this.window.add(this.panneauChoix);
        this.window.add(this.vuePlateau);
        pack();
        setVisible(true);
    }

    // méthode pour mettre à jour le panneau de choix dans le cas où le sac est vide
    private void miseAJourPanneauChoixSacVide(Jeu jeu){
        this.window.remove(panneauChoix);
        this.tuilePiochee = null;
        this.panneauChoix.removeAll();
        this.panneauChoix.setBackground(new Color(50, 200, 255));
        this.panneauChoix.setPreferredSize(new Dimension(500, 800));
        String annonce = "Le jeu est terminé, le sac est vide.";
        annoncePoints(jeu, annonce);

        pack();
        setVisible(true);
    }

    // méthode pour mettre à jour le panneau de choix dans le cas d'un abandon
    private void miseAJourPanneauChoixAbandon(Joueur joueur, Jeu jeu) throws IOException {
        this.window.remove(panneauChoix);
        this.tuilePiochee = null;
        this.panneauChoix.removeAll();
        this.panneauChoix.setBackground(new Color(50, 200, 255));
        this.panneauChoix.setPreferredSize(new Dimension(500, 800));
        String annonce = "Le jeu est terminé, " + joueur.getNom() + " a abandonné.";
        annoncePoints(jeu, annonce);

        pack();
        setVisible(true);

        afficherPlateau(jeu);
        this.window.add(vuePlateau);

        pack();
        setVisible(true);
    }

    // méthode pour afficher une tuile sur un bouton
    private JButton afficherTuile(Jeu jeu, JButton btn, int i, int j){
        // chargement de l'image
        ImageIcon imageIcon = new ImageIcon(((TuileCarcassonne) jeu.getP().getPlateau().get(i).get(j).getTuile()).getChemin().getAbsolutePath());
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(btn.getWidth(), btn.getHeight(), java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);

        // pivoter l'image selon l'orientation dans laquelle elle a été posée
        RotatedIcon r1 = new RotatedIcon(imageIcon);
        for (int n = -1; n < ((TuileCarcassonne) jeu.getP().getPlateau().get(i).get(j).getTuile()).getNbPivot(); n++) {
            r1 = new RotatedIcon(r1, RotatedIcon.Rotate.DOWN);
        }
        btn = new JButton(r1);

        btn.setSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));

        // sauvegarde tuile posée
        ((JoueurCarcassonne)jeu.getJoueurQuiJoue()).setTuile(jeu.getP().getPlateau().get(i).get(j).getTuile());

        return btn;
    }

    // méthode pour annoncer les points à la fin de la partie
    private void annoncePoints(Jeu jeu, String annonce){
        // on annonce la raison de la fin de la partie (sac vide, abandon...)
        JLabel ligne1 = new JLabel(annonce);
        ligne1.setPreferredSize(new Dimension(this.getWidth() / 3, 50));
        ligne1.setHorizontalAlignment(JLabel.CENTER);
        this.panneauChoix.add(ligne1);

        // pour chaque joueur
        for (Joueur j : jeu.getParametres().getTable().getJoueurs()){
            // on annonce son nombre de points
            JLabel ligne = new JLabel(j.getNom() + " a " + j.getNbPoints() + " points.");
            this.panneauChoix.add(ligne);
        }
        this.window.add(panneauChoix);
    }

    // méthode pour afficher tous les boutons du plateau
    private void afficherPlateau(Jeu jeu){
        this.window.remove(vuePlateau);
        this.vuePlateau = new JPanel();
        this.boutonPlateau = new ArrayList<>();
        this.vuePlateau.setLayout(new GridLayout(jeu.getP().getPlateau().size(), jeu.getP().getPlateau().get(0).size()));
        // pour chaque bouton
        for (int i = 0; i < jeu.getP().getPlateau().size(); i++) {
            this.boutonPlateau.add(new ArrayList<>());
            for (int j = 0; j < jeu.getP().getPlateau().get(0).size(); j++) {
                JButton btn = createPlateauButton(jeu);

                // s'il y a une tuile sur cet emplacement
                if (!jeu.getP().getPlateau().get(i).get(j).estVide()) {
                    // on l'affiche
                    btn = affichageEmplacement(jeu, btn, i, j);
                } else {
                    // sinon on rend le bouton non cliquable
                    btn.setEnabled(false);
                }
                this.boutonPlateau.get(i).add(btn);
                this.vuePlateau.add(btn);
            }
        }
    }

    // méthode pour afficher correctement un emplacement, avec le bouton, la tuile, le partisan, qui sont potentiellement posés
    private JButton affichageEmplacement(Jeu jeu, JButton btn, int i, int j){
        if(jeu.getParametres().getTypeDeJeu().equals("c")) {
            btn = afficherTuile(jeu, btn, i, j);

            // Affichage des partisans avec la couleur du joueur
            JLabel partisan = new JLabel();
            partisan.setSize(new Dimension(btn.getWidth(), btn.getHeight()));
            String h = "";
            String g = "";
            String d = "";
            String b = "";

            // récupérer liste des lieux de la tuile
            ArrayList<Lieu> listPartisans = ((TuileCarcassonne) jeu.getP().getPlateau().get(i).get(j).getTuile()).getPartisansPoses();
            int k = 0;
            for (Lieu l : listPartisans){
                JoueurCarcassonne possesseursPartisans = (JoueurCarcassonne)((TuileCarcassonne) jeu.getP().getPlateau().get(i).get(j).getTuile()).getPossesseursPartisans().get(k);
                // récupérer nom lieu et changer couleurs en fonction du nom du joueur et nom du lieu
                if (l.getPosition().equals("H")){
                    h = "<p style='color:"+ possesseursPartisans.getCouleur() +"'>H</p>";
                }
                else if (l.getPosition().equals("D")){
                    d = "<p style='color:"+ possesseursPartisans.getCouleur() +"'>D</p>";
                }
                else if (l.getPosition().equals("B")){
                    b = "<p style='color:"+ possesseursPartisans.getCouleur() +"'>B</p>";
                }
                else if (l.getPosition().equals("G")){
                    g = "<p style='color:"+ possesseursPartisans.getCouleur() +"'>G</p>";
                }

                k ++;
            }
            partisan.setText("<html>" + h + g + d + b + "</html>");
            btn.setText("<html>" + h + g + d + b + "</html>");

        }
        return btn;
    }
}
