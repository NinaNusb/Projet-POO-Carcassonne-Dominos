import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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
        File file = new File("C:/Users/carol/IdeaProjects/Carcassonne V2/src/Image tuile/Base_Game_C2_Tile_A1.jpg"); // TODO mettre une IOException
        BufferedImage path = ImageIO.read(file);
        this.tuilePiochee = new ImagePane(path);
        this.modele.setTuilePiochee(this.tuilePiochee);

        this.setTitle("Carcassonne");
        this.setSize(1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.vuePlateau.setLayout(new GridLayout(p.getPlateau().size(), p.getPlateau().get(0).size()));
        //this.vuePlateau.setPreferredSize(new Dimension(800, 800));
        for(int i = 0; i < p.getPlateau().size(); i++){
            for(int j = 0; j < p.getPlateau().get(0).size(); j++){
                JButton btn = new JButton();
                btn.setSize(new Dimension(Math.min(800/p.getPlateau().get(0).size(), 800/p.getPlateau().size()), Math.min(800/p.getPlateau().get(0).size(),800/p.getPlateau().size())));

                if(!p.getPlateau().get(i).get(j).estVide()){
                    ImageIcon imageIcon = new ImageIcon(((TuileCarcassonne)p.getPlateau().get(i).get(j).getTuile()).getChemin().getAbsolutePath());
                    Image image = imageIcon.getImage();
                    Image newimg = image.getScaledInstance(btn.getWidth(), btn.getHeight(),  java.awt.Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(newimg);
                    btn = new JButton(imageIcon);
                    btn.setSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));

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
        //this.panneauChoix.add(tuilePiochee);
        //JLabel ligne2 = new JLabel("test");
        //ligne2.setPreferredSize(new Dimension(this.getWidth()/3, 50));
        //ligne2.setHorizontalAlignment(JLabel.CENTER);
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
            this.panneauChoix.add(this.tuilePiochee);
            controleur.tuileTournee(this.tuilePiochee);
        });

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
        pack();
        setVisible(true);
    }

}
