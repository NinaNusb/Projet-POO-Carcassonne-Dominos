import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Vue extends JFrame {
    Modele modele;
    Controleur controleur;
    JPanel window;
    JPanel vuePlateau;
    JPanel panneauChoix;
    JPanel tuilePiochee;
    public Vue(Controleur controleur, Modele modele, Plateau p) throws IOException {
        this.modele = modele;
        this.controleur = controleur;
        this.window = new JPanel();
        this.vuePlateau = new JPanel();
        this.panneauChoix = new JPanel();
        File file = new File("C:/Users/carol/IdeaProjects/Carcassonne V2/src/Image tuile/Base_Game_C2_Tile_A1.jpg");
        BufferedImage path = ImageIO.read(file);
        this.tuilePiochee = new ImagePane(path);

        this.setTitle("Carcassonne");
        this.setSize(1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.vuePlateau.setLayout(new GridLayout(p.getPlateau().size(), p.getPlateau().get(0).size()));
        //this.vuePlateau.setPreferredSize(new Dimension(800, 800));
        for(int i = 0; i < p.getPlateau().size(); i++){
            for(int j = 0; j < p.getPlateau().get(0).size(); j++){
                JButton btn = new JButton();
                btn.setSize(new Dimension(Math.min(700/p.getPlateau().get(0).size(), 700/p.getPlateau().size()), Math.min(800/p.getPlateau().get(0).size(),800/p.getPlateau().size())));

                System.out.println(Math.min(800/p.getPlateau().get(0).size(), 800/p.getPlateau().size())); // TODO
                System.out.println(btn.getWidth() + " " + btn.getHeight()); // TODO

                if(!p.getPlateau().get(i).get(j).estVide()){
                    ImageIcon imageIcon = new ImageIcon(((TuileCarcassonne)p.getPlateau().get(i).get(j).getTuile()).getChemin().getAbsolutePath());
                    Image image = imageIcon.getImage();
                    Image newimg = image.getScaledInstance(btn.getWidth(), btn.getHeight(),  java.awt.Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(newimg);
                    btn = new JButton(imageIcon);
                    System.out.println("IMAGE"); // TODO
                    System.out.println(btn.getWidth() + " " + btn.getHeight()); // TODO
                    System.out.println(imageIcon.getIconWidth() + " " + imageIcon.getIconHeight()); // TODO
                    btn.setSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));
                    System.out.println("btn " + btn.getWidth() + " " + btn.getHeight()); // TODO

                }
                this.vuePlateau.add(btn);
            }
        }

        this.panneauChoix.setBackground(new Color(255, 0,0)); // TODO
        this.panneauChoix.setPreferredSize(new Dimension(500, 800));
        JLabel ligne1 = new JLabel("C'est à ... de jouer. Voici la tuile piochée :");
        ligne1.setPreferredSize(new Dimension(this.getWidth()/3, 50));
        ligne1.setHorizontalAlignment(JLabel.CENTER);
        //ligne1.setAlignmentY(Component.TOP_ALIGNMENT);
        this.panneauChoix.add(ligne1);
        //File file = new File("C:/Users/carol/IdeaProjects/Carcassonne V2/src/Image tuile/Base_Game_C2_Tile_A1.jpg");
        //BufferedImage path = ImageIO.read(file);
        JPanel tuilePiochee = new ImagePane(path);
        tuilePiochee.setPreferredSize(new Dimension(110,110));
        //tuilePiochee.setAlignmentX(Component.CENTER_ALIGNMENT);
        //this.tuilePiochee.setIcon(new ImageIcon("C:/Users/carol/IdeaProjects/Carcassonne V2/src/Image tuile/Base_Game_C2_Tile_A1.jpg"));
        this.panneauChoix.add(tuilePiochee);
        //JLabel ligne2 = new JLabel("test");
        //ligne2.setPreferredSize(new Dimension(this.getWidth()/3, 50));
        //ligne2.setHorizontalAlignment(JLabel.CENTER);
        JButton tournerButton = new JButton("Tourner la tuile");
        this.panneauChoix.add(tournerButton);
        this.tuilePiochee.setPreferredSize(new Dimension(110,110));
        this.panneauChoix.add(this.tuilePiochee);
        //this.panneauChoix.add(Box.createVerticalGlue());

        this.window.setLayout(new BoxLayout(this.window, BoxLayout.LINE_AXIS));
        this.window.add(panneauChoix);
        this.window.add(vuePlateau);
        this.window.add(Box.createHorizontalGlue());
        this.getContentPane().add(window);

        tournerButton.addActionListener(event -> {
            final BufferedImage bi;
            try {
                bi = ImageIO.read(new File("C:/Users/carol/Desktop/M1/POO/projet Carcassonne/images des tuiles/Base_Game_C2_Tile_A1.jpg"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("ici"); // TODO
            this.panneauChoix.add(new JPanel() {

                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(bi.getWidth(), bi.getHeight());
                }

                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2 = (Graphics2D) g;
                    g2.rotate(Math.PI/2, bi.getWidth() / 2, bi.getHeight() / 2);
                    g2.drawImage(bi, 0, 0, null);
                }
            });
            //this.tuilePiochee.paintComponents();
            System.out.println(this.tuilePiochee.getClass()); // TODO
        });


        pack();
        setVisible(true);
    }

    // méthode qui met à jour l'image de la tuile piochée à chaque tour
}
