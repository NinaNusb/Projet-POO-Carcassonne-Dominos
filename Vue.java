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
        BufferedImage path = new BufferedImage(1,1,1);
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
        // debug tuile en trop à l'initialisation du plateau
        boolean trouver = false;
        // ce plateau est une matrice de boutons
        for(int i = 0; i < jeu.getP().getPlateau().size(); i++){
            this.boutonPlateau.add(new ArrayList<>());
            for(int j = 0; j < jeu.getP().getPlateau().get(0).size(); j++){
                // création du bouton dont la taille est adaptée au nombre de boutons nécessaires
                JButton btn = new JButton();
                btn.setSize(new Dimension(Math.min(800/jeu.getP().getPlateau().get(0).size(), 800/jeu.getP().getPlateau().size()), Math.min(800/jeu.getP().getPlateau().get(0).size(),800/jeu.getP().getPlateau().size())));
                // éviter affichage et supprimer la tuile en trop
                if (!jeu.getP().getPlateau().get(i).get(j).estVide() && trouver){
                    jeu.getP().getPlateau().get(i).get(j).setTuile(null);
                }
                // s'il y a une tuile présente sur cette case du plateau
                if(!jeu.getP().getPlateau().get(i).get(j).estVide() && !trouver) {

                    if (jeu.getParametres().getTypeDeJeu().equals("c")) {
                        // on affiche l'image
                        ImageIcon imageIcon = new ImageIcon(((TuileCarcassonne) jeu.getP().getPlateau().get(i).get(j).getTuile()).getChemin().getAbsolutePath());
                        Image image = imageIcon.getImage();
                        Image newimg = image.getScaledInstance(btn.getWidth(), btn.getHeight(), java.awt.Image.SCALE_SMOOTH);
                        imageIcon = new ImageIcon(newimg);

                        // l'orientation de la tuile est adaptée
                        RotatedIcon r1 = new RotatedIcon(imageIcon);
                        for (int n = -1; n < ((TuileCarcassonne) (TuileCarcassonne) jeu.getP().getPlateau().get(i).get(j).getTuile()).getNbPivot(); n++) {
                            r1 = new RotatedIcon(r1, RotatedIcon.Rotate.DOWN);
                        }
                        btn = new JButton(r1);
                        btn.setSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));

                    }
                    else {
                        TuileDomino t = (TuileDomino) jeu.getP().getPlateau().get(i).get(j).getTuile();

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
                        trouver = true;
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

        if(jeu.getParametres().getTypeDeJeu().equals("c")) {
            // pour chaque joueur autour de la table
            for (Joueur j : jeu.getParametres().getTable().getJoueurs()) {
                // on affiche son nombre de partisans
                JLabel label = new JLabel(j.getNom() + " a " + ((JoueurCarcassonne) j).getNbPartisans() + " partisans en main.\n");
                label.setPreferredSize(new Dimension(this.getWidth() / 3, 50));
                label.setHorizontalAlignment(JLabel.CENTER);
                this.panneauChoix.add(label);
            }
        }

        // affichage du joueur qui doit jouer
        this.panneauChoix.add(Box.createHorizontalStrut(330));
        String annonce = "C'est à "+ jeu.getJoueurQuiJoue().getNom() +" de jouer. Voici la tuile piochée :";
        JLabel ligne1 = new JLabel(annonce);
        // ligne1.setPreferredSize(new Dimension(this.getWidth()/3, 50));
        // ligne1.setHorizontalAlignment(JLabel.CENTER);
        this.panneauChoix.add(ligne1);
        
        // affichage de la tuile piochée
        this.tuilePiochee.setPreferredSize(new Dimension(110,110));
        JPanel tuilePiochee = new ImagePane(path); // TODO ligne utile ?
        tuilePiochee.setPreferredSize(new Dimension(110,110)); // TODO ligne utile ?
        this.panneauChoix.add(this.tuilePiochee);

        // affichage du bouton pour tourner la tuile
        JButton tournerButton = new JButton("Tourner la tuile ");
        this.panneauChoix.add(tournerButton);
        // affichage du bouton pour défausser la tuile
        JButton defausserButton = new JButton("Défausser la tuile");
        this.panneauChoix.add(defausserButton);
        // affichage du bouton pour abandonner la partie
        JButton abandonnerButton = new JButton("Abandonne la partie");
        this.panneauChoix.add(abandonnerButton);
                
        // affichage bouttons partisans
        String demandeAction = "Voulez-vous ajouter un partisan à la tuile posée?";
        JLabel ajouterPartisan = new JLabel(demandeAction);
        ajouterPartisan.setPreferredSize(new Dimension(this.getWidth() / 1, 50));
        // ajouterPartisan.setHorizontalAlignment(JLabel.CENTER);
        // this.panneauChoix.add(Box.createHorizontalStrut(330));
        this.panneauChoix.add(ajouterPartisan);
        
        JButton btnPartisanHaut = new JButton("Placer un partisan en haut");
        // btnPartisanHaut.setPreferredSize(new Dimension(this.getWidth() / 2, 50));
        this.panneauChoix.add(btnPartisanHaut);
        JButton btnPartisanBas = new JButton("Placer un partisan en bas");
        // btnPartisanBas.setPreferredSize(new Dimension(this.getWidth() / 2, 50));
        this.panneauChoix.add(btnPartisanBas);
        JButton btnPartisanDroite = new JButton("Placer un partisan à droite");
        // btnPartisanDroite.setPreferredSize(new Dimension(this.getWidth() / 2, 50));
        this.panneauChoix.add(btnPartisanDroite);
        JButton btnPartisanGauche = new JButton("Placer un partisan à gauche");
        // btnPartisanGauche.setPreferredSize(new Dimension(this.getWidth() / 2, 50));
        this.panneauChoix.add(btnPartisanGauche);
        
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
                    g2.rotate(Math.PI/2, bi.getWidth() / 2, bi.getHeight() / 2);
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
                                else {
                                    // TODO
                                }
                            } catch (Exception e) {
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
            this.miseAJourPanneauChoixSacVide();
            this.window.remove(vuePlateau);
            this.vuePlateau = new JPanel();
            this.boutonPlateau = new ArrayList<>();
            this.vuePlateau.setLayout(new GridLayout(jeu.getP().getPlateau().size(), jeu.getP().getPlateau().get(0).size()));
            // pour chaque bouton
            for (int i = 0; i < jeu.getP().getPlateau().size(); i++) {
                this.boutonPlateau.add(new ArrayList<>());
                for (int j = 0; j < jeu.getP().getPlateau().get(0).size(); j++) {
                    // on met à jour le plateau mais tous les boutons sont disabled
                    JButton btn = new JButton();
                    btn.setSize(new Dimension(Math.min(800 / jeu.getP().getPlateau().get(0).size(), 800 / jeu.getP().getPlateau().size()), Math.min(800 / jeu.getP().getPlateau().get(0).size(), 800 / jeu.getP().getPlateau().size())));

                    if (!jeu.getP().getPlateau().get(i).get(j).estVide()) {
                        if(jeu.getParametres().getTypeDeJeu().equals("c")) {
                            ImageIcon imageIcon = new ImageIcon(((TuileCarcassonne) jeu.getP().getPlateau().get(i).get(j).getTuile()).getChemin().getAbsolutePath()); // change image
                            Image image = imageIcon.getImage();
                            Image newimg = image.getScaledInstance(btn.getWidth(), btn.getHeight(), java.awt.Image.SCALE_SMOOTH);
                            imageIcon = new ImageIcon(newimg);

                            RotatedIcon r1 = new RotatedIcon(imageIcon);
                            for (int n = -1; n < ((TuileCarcassonne) (TuileCarcassonne) jeu.getP().getPlateau().get(i).get(j).getTuile()).getNbPivot(); n++) {
                                r1 = new RotatedIcon(r1, RotatedIcon.Rotate.DOWN);
                            }
                            btn = new JButton(r1);
                            
                            btn.setSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));

                              // Changer couleur de chaque lettre en fonction du joueur qui a posé le partisan
                            // sauvegarde tuile posée
                            ((JoueurCarcassonne)jeu.getJoueurQuiJoue()).setTuile(((TuileCarcassonne) jeu.getP().getPlateau().get(i).get(j).getTuile()));

                            // Affichage partisans avec la couleur du joueur
                            JLabel partisan = new JLabel(); 
                            String h = "<p>H</p><br><br>";
                            String g = "<p>G</p>";
                            String d = "<p>D</p><br><br>";
                            String b = "<p>B</p>";
                            
                            // récupérer liste des lieux de la tuile
                            ArrayList<Lieu> listPartisans = ((TuileCarcassonne) jeu.getP().getPlateau().get(i).get(j).getTuile()).getPartisansPoses(); //tuile pas
                            // System.out.println("****" +listPartisans.size());
                            int k = 0;
                            for (Lieu l : listPartisans){
                                //System.out.println("####" + l.getPosition());
                                JoueurCarcassonne possesseursPartisans = (JoueurCarcassonne)((TuileCarcassonne) jeu.getP().getPlateau().get(i).get(j).getTuile()).getPossesseursPartisans().get(k);
                                // récupérer nom lieu et changer couleurs en fonction du nom du joueur et nom du lieu
                                if (l.getPosition().equals("H")){
                                    h = "<p style='color:"+ possesseursPartisans.getCouleur() +"'>H</p><br><br>";
                                }
                                else if (l.getPosition().equals("D")){
                                    d = "&nbsp;&nbsp;&nbsp;&nbsp;<p style='color:"+ possesseursPartisans.getCouleur() +"'>D</p><br><br>";
                                }
                                else if (l.getPosition().equals("B")){
                                    b = "&nbsp;&nbsp;<p style='color:"+ possesseursPartisans.getCouleur() +"'>B</p>";
                                }
                                else if (l.getPosition().equals("G")){
                                    g = "<p style='color:"+ possesseursPartisans.getCouleur() +"'>G</p>";
                                }
                                
                                k ++;
                            }
                            partisan.setText("<html>" + h + g + d + b + "</html>");
                            // if (btn.getIcon() != null){ // TODO: icone vide?
                                btn.add(partisan);

                            // }
        
                        }
                        else {
                            // TODO
                        }
                    } else {
                        btn.setEnabled(false);
                    }
                    this.boutonPlateau.get(i).add(btn);
                    this.vuePlateau.add(btn);
                }
            }
        }
        // on refait à peu près la même chose que lors de l'initialisation de la vue
        else {
            controleur.pioche(jeu);
            this.window.remove(vuePlateau);
            this.vuePlateau = new JPanel();
            this.boutonPlateau = new ArrayList<>();
            this.vuePlateau.setLayout(new GridLayout(jeu.getP().getPlateau().size(), jeu.getP().getPlateau().get(0).size()));
            for (int i = 0; i < jeu.getP().getPlateau().size(); i++) {
                this.boutonPlateau.add(new ArrayList<>());
                for (int j = 0; j < jeu.getP().getPlateau().get(0).size(); j++) {
                    JButton btn = new JButton();
                    btn.setSize(new Dimension(Math.min(800 / jeu.getP().getPlateau().get(0).size(), 800 / jeu.getP().getPlateau().size()), Math.min(800 / jeu.getP().getPlateau().get(0).size(), 800 / jeu.getP().getPlateau().size())));

                    if (!jeu.getP().getPlateau().get(i).get(j).estVide()) {
                        // System.out.println("#####" + i + "," + j);
                        if(jeu.getParametres().getTypeDeJeu().equals("c")) {
                            ImageIcon imageIcon = new ImageIcon(((TuileCarcassonne) jeu.getP().getPlateau().get(i).get(j).getTuile()).getChemin().getAbsolutePath());
                            Image image = imageIcon.getImage();
                            Image newimg = image.getScaledInstance(btn.getWidth(), btn.getHeight(), java.awt.Image.SCALE_SMOOTH);
                            imageIcon = new ImageIcon(newimg);

                            RotatedIcon r1 = new RotatedIcon(imageIcon);
                            for (int n = -1; n < ((TuileCarcassonne) (TuileCarcassonne) jeu.getP().getPlateau().get(i).get(j).getTuile()).getNbPivot(); n++) {
                                r1 = new RotatedIcon(r1, RotatedIcon.Rotate.DOWN);
                            }
                            btn = new JButton(r1); 
                            btn.setSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));

                            // Changer couleur de chaque lettre en fonction du joueur qui a posé le partisan
                            // sauvegarde tuile posée
                            ((JoueurCarcassonne)jeu.getJoueurQuiJoue()).setTuile(((TuileCarcassonne) jeu.getP().getPlateau().get(i).get(j).getTuile()));

                            // Affichage partisans avec la couleur du joueur
                            JLabel partisan = new JLabel(); 
                            String h = "<p>H</p><br><br>";
                            String g = "<p>G</p>";
                            String d = "<p>D</p><br><br>";
                            String b = "<p>B</p>";
                            
                            // récupérer liste des lieux de la tuile
                            ArrayList<Lieu> listPartisans = ((TuileCarcassonne) jeu.getP().getPlateau().get(i).get(j).getTuile()).getPartisansPoses(); //tuile pas
                            // System.out.println("****" +listPartisans.size());
                            int k = 0;
                            for (Lieu l : listPartisans){
                                //System.out.println("####" + l.getPosition());
                                JoueurCarcassonne possesseursPartisans = (JoueurCarcassonne)((TuileCarcassonne) jeu.getP().getPlateau().get(i).get(j).getTuile()).getPossesseursPartisans().get(k);
                                // récupérer nom lieu et changer couleurs en fonction du nom du joueur et nom du lieu
                                if (l.getPosition().equals("H")){
                                    h = "<p style='color:"+ possesseursPartisans.getCouleur() +"'>H</p><br><br>";
                                }
                                else if (l.getPosition().equals("D")){
                                    d = "&nbsp;&nbsp;&nbsp;&nbsp;<p style='color:"+ possesseursPartisans.getCouleur() +"'>D</p><br><br>";
                                }
                                else if (l.getPosition().equals("B")){
                                    b = "&nbsp;&nbsp;<p style='color:"+ possesseursPartisans.getCouleur() +"'>B</p>";
                                }
                                else if (l.getPosition().equals("G")){
                                    g = "<p style='color:"+ possesseursPartisans.getCouleur() +"'>G</p>";
                                }
                                
                                k ++;
                            }
                            partisan.setText("<html>" + h + g + d + b + "</html>");
                            // if (btn.getIcon() != null){ // TODO: icone vide?
                                btn.add(partisan);

                            // }
                                
                        }
                        else {
                            // TODO
                        }

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
                                    else {
                                        // TODO
                                    }
                                } catch (Exception e) {
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

    // méthode pour mettre à jour le panneau choix (notamment lorsque c'est à un autre joueur de jouer)
    public void miseAJourPanneauChoix(Jeu jeu) throws IOException {
            this.window.remove(panneauChoix);
            this.panneauChoix.removeAll();
            this.panneauChoix.setBackground(new Color(50, 200, 255));
            this.panneauChoix.setPreferredSize(new Dimension(500, 800));
            
            String annonce = "C'est à " + jeu.getJoueurQuiJoue().getNom() + " de jouer. Voici la tuile piochée :";
            JLabel ligne1 = new JLabel(annonce);
            ligne1.setPreferredSize(new Dimension(this.getWidth() / 1, 50));
            ligne1.setHorizontalAlignment(JLabel.CENTER);
            this.panneauChoix.add(ligne1);

            // tuile piochée
            // tuilePiochee.setPreferredSize(new Dimension(110, 110));
            // this.tuilePiochee = tuilePiochee;
            this.tuilePiochee.setPreferredSize(new Dimension(110, 110));
            this.panneauChoix.add(this.tuilePiochee);

            // bouttons actions
            JButton tournerButton = new JButton("Tourner la tuile");
            tournerButton.setPreferredSize(new Dimension(this.getWidth() / 3, 50));
            this.panneauChoix.add(tournerButton);
            JButton defausserButton = new JButton("Défausser la tuile");
            defausserButton.setPreferredSize(new Dimension(this.getWidth() / 3, 50));
            this.panneauChoix.add(defausserButton);
            JButton abandonnerButton = new JButton("Abandonne la partie");
            abandonnerButton.setPreferredSize(new Dimension(this.getWidth() / 3, 50));
            this.panneauChoix.add(abandonnerButton);
            
            for(Joueur j : jeu.getParametres().getTable().getJoueurs()){
                JLabel label = new JLabel(j.getNom() + " a " + ((JoueurCarcassonne)j).getNbPartisans() + " partisans en main.\n");
                label.setPreferredSize(new Dimension(this.getWidth()/2, 50));
                label.setHorizontalAlignment(JLabel.CENTER);
                this.panneauChoix.add(label);
            }
            String demandeAction = "Voulez-vous ajouter un partisan à la tuile posée?";
            JLabel ajouterPartisan = new JLabel(demandeAction);
            ajouterPartisan.setPreferredSize(new Dimension(this.getWidth() / 1, 50));
            ajouterPartisan.setHorizontalAlignment(JLabel.CENTER);
            this.panneauChoix.add(ajouterPartisan);
        if(jeu.getParametres().getTypeDeJeu().equals("c")) {
            File file = ((TuileCarcassonne) jeu.getJoueurQuiJoue().getTuileEnMain()).getChemin();
            BufferedImage path = ImageIO.read(file);
            JPanel tuilePiochee = new ImagePane(path);
        }
                    
            // bouttons partisans
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
            this.window.add(panneauChoix);

        // si le joueur qui doit jouer est un ordinateur
        if (jeu.getJoueurQuiJoue().getType().equals("o")){
            for (Emplacement emplacementLibre : jeu.getP().emplacementsLibres()) {
                // si on peut jouer sur cet emplacement, on le stocke
                if (jeu.emplacementOuJouer(emplacementLibre, false)) {
                    //nbPointsParEmplacement.put(emplacementLibre, this.pointsPotentiels(emplacementLibre));
                    jeu.emplacementOuJouer(emplacementLibre, true);
                    //controleur.pioche(jeu);
                    break;
                }
            }
            this.miseAJourPlateau(jeu);
            pack();
            setVisible(true);
        }

            abandonnerButton.addActionListener(event -> {
                try {
                    this.miseAJourPanneauChoixAbandon(jeu.getJoueurQuiJoue(), jeu);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            defausserButton.addActionListener(event -> {
                try {
                    this.miseAJourPlateau(jeu);
                    pack();
                    setVisible(true);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

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
                        g2.rotate(Math.PI / 2, bi.getWidth() / 2, bi.getHeight() / 2);
                        g2.drawImage(bi, 0, 0, null);
                    }
                };
                
                jeu.getJoueurQuiJoue().getTuileEnMain().tourner();
                this.panneauChoix.add(this.tuilePiochee);
                controleur.tuileTournee(this.tuilePiochee);
            });
            // bouttons partisans
            btnPartisanHaut.addActionListener(event -> {
                try {
                    // récupérer joueur qui joue
                    JoueurCarcassonne j = (JoueurCarcassonne)jeu.getJoueurQuiJoue();
                    // récupérer dernière tuile posée du joueur
                    TuileCarcassonne t = (TuileCarcassonne)j.getTuile();
                    // ajouter lieu à la liste des partisans du joueurs
                    Lieu lieuHaut = (Lieu)t.getHaut()[0];
                    lieuHaut.setPosition("H");
                    // place partisan
                    j.placePartisan(t, lieuHaut);
                    this.miseAJourPlateau(jeu);
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
                    // récupérer dernière tuile posée du joueur
                    TuileCarcassonne t = (TuileCarcassonne)j.getTuile();
                    // ajouter lieu à la liste des partisans du joueurs
                    Lieu lieuBas = (Lieu)t.getBas()[0];
                    lieuBas.setPosition("B");
                    // place partisan
                    j.placePartisan(t, lieuBas);
                    this.miseAJourPlateau(jeu);
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
                    // récupérer dernière tuile posée du joueur
                    TuileCarcassonne t = (TuileCarcassonne)j.getTuile();
                    // ajouter lieu à la liste des partisans du joueurs
                    Lieu lieuDroite = (Lieu)t.getDroite()[0];
                    lieuDroite.setPosition("D");
                    // place partisan
                    j.placePartisan(t, lieuDroite);
                    this.miseAJourPlateau(jeu);
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
                    // récupérer dernière tuile posée du joueur
                    TuileCarcassonne t = (TuileCarcassonne)j.getTuile();
                    // ajouter lieu à la liste des partisans du joueurs
                    Lieu lieuGauche = (Lieu)t.getGauche()[0];
                    lieuGauche.setPosition("G");
                    // place partisan
                    j.placePartisan(t, lieuGauche);
                    this.miseAJourPlateau(jeu);
                    pack();
                    setVisible(true);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
    }

    // méthode pour mettre à jour le panneau de choix dans le cas où le sac est vide
    public void miseAJourPanneauChoixSacVide(){
        this.window.remove(panneauChoix);
        this.panneauChoix.removeAll();
        this.panneauChoix.setBackground(new Color(50, 200, 255));
        this.panneauChoix.setPreferredSize(new Dimension(500, 800));
        String annonce = "Le jeu est terminé, le sac est vide.";
        JLabel ligne1 = new JLabel(annonce);
        ligne1.setPreferredSize(new Dimension(this.getWidth() / 3, 50));
        ligne1.setHorizontalAlignment(JLabel.CENTER);
        this.panneauChoix.add(ligne1);
        this.window.add(panneauChoix);

        // compte les points TODO
    }
    // méthode pour mettre à jour le panneau de choix dans le cas d'un abandon
    public void miseAJourPanneauChoixAbandon(Joueur joueur, Jeu jeu) throws IOException {
        this.window.remove(panneauChoix);
        this.panneauChoix.removeAll();
        this.panneauChoix.setBackground(new Color(50, 200, 255));
        this.panneauChoix.setPreferredSize(new Dimension(500, 800));
        String annonce = "Le jeu est terminé, " + joueur.getNom() + " a abandonné.";
        JLabel ligne1 = new JLabel(annonce);
        ligne1.setPreferredSize(new Dimension(this.getWidth() / 3, 50));
        ligne1.setHorizontalAlignment(JLabel.CENTER);
        this.panneauChoix.add(ligne1);
        this.window.add(panneauChoix);

        pack();
        setVisible(true);

        this.window.remove(vuePlateau);
        this.vuePlateau = new JPanel();
        this.boutonPlateau = new ArrayList<>();
        this.vuePlateau.setLayout(new GridLayout(jeu.getP().getPlateau().size(), jeu.getP().getPlateau().get(0).size()));
        for (int i = 0; i < jeu.getP().getPlateau().size(); i++) {
            this.boutonPlateau.add(new ArrayList<>());
            for (int j = 0; j < jeu.getP().getPlateau().get(0).size(); j++) {
                JButton btn = new JButton();
                btn.setSize(new Dimension(Math.min(800 / jeu.getP().getPlateau().get(0).size(), 800 / jeu.getP().getPlateau().size()), Math.min(800 / jeu.getP().getPlateau().get(0).size(), 800 / jeu.getP().getPlateau().size())));

                if (!jeu.getP().getPlateau().get(i).get(j).estVide()) {
                    if(jeu.getParametres().getTypeDeJeu().equals("c")) {
                        ImageIcon imageIcon = new ImageIcon(((TuileCarcassonne) jeu.getP().getPlateau().get(i).get(j).getTuile()).getChemin().getAbsolutePath());
                        Image image = imageIcon.getImage();
                        Image newimg = image.getScaledInstance(btn.getWidth(), btn.getHeight(), java.awt.Image.SCALE_SMOOTH);
                        imageIcon = new ImageIcon(newimg);

                        RotatedIcon r1 = new RotatedIcon(imageIcon);
                        for (int n = -1; n < ((TuileCarcassonne) (TuileCarcassonne) jeu.getP().getPlateau().get(i).get(j).getTuile()).getNbPivot(); n++) {
                            r1 = new RotatedIcon(r1, RotatedIcon.Rotate.DOWN);
                        }
                        btn = new JButton(r1);
                        btn.setSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));
                    }
                    else {
                        // TODO
                    }
                } else {
                    btn.setEnabled(false);
                }
                this.boutonPlateau.get(i).add(btn);
                this.vuePlateau.add(btn);
            }
        }
        this.window.add(vuePlateau);

        pack();
        setVisible(true);
    }
}
