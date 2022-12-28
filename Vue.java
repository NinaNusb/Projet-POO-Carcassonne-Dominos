import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Vue extends JFrame {
    Modele modele;
    Controleur controleur;
    JPanel window;
    JPanel vuePlateau;
    JPanel panneauChoix;
    JPanel tuilePiochee;
    ArrayList<ArrayList<JButton>> boutonPlateau;
    int nbPivot;
    public Vue(Controleur controleur, Modele modele, Jeu jeu) throws IOException {
        this.modele = modele;
        this.controleur = controleur;
        this.window = new JPanel();
        this.vuePlateau = new JPanel();
        this.panneauChoix = new JPanel();
        this.boutonPlateau = new ArrayList<>();
        this.nbPivot = 0;
        File file = ((TuileCarcassonne)jeu.getJoueurQuiJoue().getTuileEnMain()).getChemin();
        BufferedImage path = ImageIO.read(file);
        this.tuilePiochee = new ImagePane(path);
        this.modele.setTuilePiochee(this.tuilePiochee);

        this.setTitle("Carcassonne");
        this.setSize(1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.vuePlateau.setLayout(new GridLayout(jeu.getP().getPlateau().size(), jeu.getP().getPlateau().get(0).size()));
        //this.vuePlateau.setPreferredSize(new Dimension(800, 800));
        for(int i = 0; i < jeu.getP().getPlateau().size(); i++){
            this.boutonPlateau.add(new ArrayList<>());
            for(int j = 0; j < jeu.getP().getPlateau().get(0).size(); j++){
                JButton btn = new JButton();
                btn.setSize(new Dimension(Math.min(800/jeu.getP().getPlateau().get(0).size(), 800/jeu.getP().getPlateau().size()), Math.min(800/jeu.getP().getPlateau().get(0).size(),800/jeu.getP().getPlateau().size())));

                if(!jeu.getP().getPlateau().get(i).get(j).estVide()){
                    ImageIcon imageIcon = new ImageIcon(((TuileCarcassonne)jeu.getP().getPlateau().get(i).get(j).getTuile()).getChemin().getAbsolutePath());
                    Image image = imageIcon.getImage();
                    Image newimg = image.getScaledInstance(btn.getWidth(), btn.getHeight(), java.awt.Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(newimg);

                    RotatedIcon r1 = new RotatedIcon(imageIcon);
                    System.out.println(((TuileCarcassonne)(TuileCarcassonne)jeu.getP().getPlateau().get(i).get(j).getTuile()).getNbPivot()); // TODO
                    for (int n = -1 ; n < ((TuileCarcassonne)(TuileCarcassonne)jeu.getP().getPlateau().get(i).get(j).getTuile()).getNbPivot() ; n++) {
                        r1 = new RotatedIcon(r1, RotatedIcon.Rotate.DOWN);
                    }
                    btn = new JButton(r1);
                    btn.setSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));
                }
                else {
                    btn.setEnabled(jeu.getP().getMatriceAdjacence().get(i).get(j) != 0);
                }
                this.boutonPlateau.get(i).add(btn);
                this.vuePlateau.add(btn);
            }
        }

        this.panneauChoix.setBackground(new Color(255, 0,0)); // TODO
        this.panneauChoix.setPreferredSize(new Dimension(500, 800));
        String annonce = "C'est à "+ jeu.getJoueurQuiJoue().getNom() +" de jouer. Voici la tuile piochée :";
        JLabel ligne1 = new JLabel(annonce);
        ligne1.setPreferredSize(new Dimension(this.getWidth()/3, 50));
        ligne1.setHorizontalAlignment(JLabel.CENTER);
        this.panneauChoix.add(ligne1);
        JPanel tuilePiochee = new ImagePane(path);
        tuilePiochee.setPreferredSize(new Dimension(110,110));
        JButton tournerButton = new JButton("Tourner la tuile");
        this.panneauChoix.add(tournerButton);
        this.tuilePiochee.setPreferredSize(new Dimension(110,110));
        this.panneauChoix.add(this.tuilePiochee);

        this.window.setLayout(new BoxLayout(this.window, BoxLayout.LINE_AXIS));
        this.window.add(panneauChoix);
        this.window.add(vuePlateau);
        this.window.add(Box.createHorizontalGlue());
        this.getContentPane().add(window);

        pack();
        setVisible(true);

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

        for (int i = 0 ; i < this.boutonPlateau.size() ; i++) {
            for (int j = 0 ; j < this.boutonPlateau.get(0).size() ; j++) {
                final int xi = i;
                final int xj = j;
                this.boutonPlateau.get(xi).get(xj).addActionListener(event -> {
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
                        if (emplacementPossible) {
                            try {
                                this.panneauChoix.remove(this.tuilePiochee);
                                ((TuileCarcassonne)(jeu.getJoueurQuiJoue().getTuileEnMain())).setNbPivot(this.nbPivot);
                                controleur.tuilePosee(xi, xj, (TuileCarcassonne)jeu.getJoueurQuiJoue().getTuileEnMain(), jeu);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                });
            }
        }
    }
    private BufferedImage createImage(JPanel panel) {
        int w = panel.getWidth();
        int h = panel.getHeight();
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        panel.paint(g);
        return bi;
    }
    public void miseAJourTuilePiochee() {
        this.tuilePiochee = this.modele.tuilePiochee;
        this.nbPivot += 1;
        pack();
        setVisible(true);
    }

    public void miseAJourPlateau(Jeu jeu) throws IOException {
        controleur.pioche(jeu);
        this.window.remove(vuePlateau);
        this.vuePlateau = new JPanel();
        this.boutonPlateau = new ArrayList<>();
        this.vuePlateau.setLayout(new GridLayout(jeu.getP().getPlateau().size(), jeu.getP().getPlateau().get(0).size()));
        for(int i = 0; i < jeu.getP().getPlateau().size(); i++){
            this.boutonPlateau.add(new ArrayList<>());
            for(int j = 0; j < jeu.getP().getPlateau().get(0).size(); j++){
                JButton btn = new JButton();
                btn.setSize(new Dimension(Math.min(800/jeu.getP().getPlateau().get(0).size(), 800/jeu.getP().getPlateau().size()), Math.min(800/jeu.getP().getPlateau().get(0).size(),800/jeu.getP().getPlateau().size())));

                if(!jeu.getP().getPlateau().get(i).get(j).estVide()){
                    ImageIcon imageIcon = new ImageIcon(((TuileCarcassonne)jeu.getP().getPlateau().get(i).get(j).getTuile()).getChemin().getAbsolutePath());
                    Image image = imageIcon.getImage();
                    Image newimg = image.getScaledInstance(btn.getWidth(), btn.getHeight(), java.awt.Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(newimg);

                    RotatedIcon r1 = new RotatedIcon(imageIcon);
                    for (int n = -1 ; n < ((TuileCarcassonne)(TuileCarcassonne)jeu.getP().getPlateau().get(i).get(j).getTuile()).getNbPivot() ; n++) {
                        r1 = new RotatedIcon(r1, RotatedIcon.Rotate.DOWN);
                    }
                    btn = new JButton(r1);
                    btn.setSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));
                }
                else {
                    btn.setEnabled(jeu.getP().getMatriceAdjacence().get(i).get(j) != 0);
                }
                this.boutonPlateau.get(i).add(btn);
                this.vuePlateau.add(btn);
            }
        }
        for (int i = 0 ; i < this.boutonPlateau.size() ; i++) {
            for (int j = 0 ; j < this.boutonPlateau.get(0).size() ; j++) {
                final int xi = i;
                final int xj = j;
                this.boutonPlateau.get(xi).get(xj).addActionListener(event -> {
                    String emplacementPossible = "";
                    if(jeu.getP().getPlateau().get(xi).get(xj).estVide()) {
                        if ((xi+1) < jeu.getP().getPlateau().size()) {
                            if (!jeu.getP().getPlateau().get(xi + 1).get(xj).estVide()) {
                                if (jeu.getJoueurQuiJoue().getTuileEnMain().cotesEgaux(jeu.getP().getPlateau().get(xi + 1).get(xj).getTuile()).contains("h")) {
                                    emplacementPossible = "o";
                                }
                                else {
                                    emplacementPossible = "n";
                                }
                            }
                        }
                        if ((xi-1) >= 0 && !emplacementPossible.equals("n")) {
                            if (!jeu.getP().getPlateau().get(xi - 1).get(xj).estVide()) {
                                if (jeu.getJoueurQuiJoue().getTuileEnMain().cotesEgaux(jeu.getP().getPlateau().get(xi - 1).get(xj).getTuile()).contains("b")) {
                                    emplacementPossible = "o";
                                }
                                else {
                                    emplacementPossible = "n";
                                }
                            }
                        }
                        if ((xj+1) < jeu.getP().getPlateau().get(0).size() && !emplacementPossible.equals("n")) {
                            if (!jeu.getP().getPlateau().get(xi).get(xj + 1).estVide()) {
                                if (jeu.getJoueurQuiJoue().getTuileEnMain().cotesEgaux(jeu.getP().getPlateau().get(xi).get(xj + 1).getTuile()).contains("g")) {
                                    emplacementPossible = "o";
                                }
                                else {
                                    emplacementPossible = "n";
                                }
                            }
                        }
                        if ((xj-1) >= 0 && !emplacementPossible.equals("n")) {
                            if (!jeu.getP().getPlateau().get(xi).get(xj - 1).estVide()) {
                                if (jeu.getJoueurQuiJoue().getTuileEnMain().cotesEgaux(jeu.getP().getPlateau().get(xi).get(xj - 1).getTuile()).contains("d")) {
                                    emplacementPossible = "o";
                                }
                                else {
                                    emplacementPossible = "n";
                                }
                            }
                        }
                        if (emplacementPossible.equals("o")) {
                            try {
                                this.panneauChoix.remove(this.tuilePiochee);
                                ((TuileCarcassonne)(jeu.getJoueurQuiJoue().getTuileEnMain())).setNbPivot(this.nbPivot);
                                controleur.tuilePosee(xi, xj, (TuileCarcassonne)jeu.getJoueurQuiJoue().getTuileEnMain(), jeu);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                });
            }
        }
        this.nbPivot = 0;
        this.window.add(vuePlateau);
        pack();
        setVisible(true);
    }

    public void miseAJourPanneauChoix(Jeu jeu) throws IOException {
        this.window.remove(panneauChoix);
        this.panneauChoix.removeAll();
        this.panneauChoix.setBackground(new Color(255, 0,0)); // TODO
        this.panneauChoix.setPreferredSize(new Dimension(500, 800));
        String annonce = "C'est à "+ jeu.getJoueurQuiJoue().getNom() +" de jouer. Voici la tuile piochée :";
        JLabel ligne1 = new JLabel(annonce);
        ligne1.setPreferredSize(new Dimension(this.getWidth()/3, 50));
        ligne1.setHorizontalAlignment(JLabel.CENTER);
        this.panneauChoix.add(ligne1);
        jeu.getJoueurQuiJoue().pioche(jeu.getSac());
        File file = ((TuileCarcassonne)jeu.getJoueurQuiJoue().getTuileEnMain()).getChemin();
        BufferedImage path = ImageIO.read(file);
        JPanel tuilePiochee = new ImagePane(path);
        tuilePiochee.setPreferredSize(new Dimension(110,110));
        this.tuilePiochee = tuilePiochee;
        JButton tournerButton = new JButton("Tourner la tuile");
        this.panneauChoix.add(tournerButton);
        this.tuilePiochee.setPreferredSize(new Dimension(110,110));
        this.panneauChoix.add(this.tuilePiochee);
        this.window.add(panneauChoix);

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
    }
}
