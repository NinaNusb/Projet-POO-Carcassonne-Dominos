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
    public Vue(Controleur controleur, Modele modele, Plateau p) throws IOException {
        this.modele = modele;
        this.controleur = controleur;
        this.window = new JPanel();
        this.vuePlateau = new JPanel();
        this.panneauChoix = new JPanel();

        this.setTitle("Carcassonne");
        this.setSize(1700, 1200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.vuePlateau.setLayout(new GridLayout(p.getPlateau().size(), p.getPlateau().get(0).size()));
        this.vuePlateau.setPreferredSize(new Dimension(this.getWidth()*2/3, this.getHeight()));
        for(int i = 0; i < p.getPlateau().size(); i++){
            for(int j = 0; j < p.getPlateau().get(0).size(); j++){
                JButton btn = new JButton();
                if(!p.getPlateau().get(i).get(j).estVide()){
                    btn = new JButton(((TuileCarcassonne)p.getPlateau().get(i).get(j).getTuile()).getChemin().getName());
                }
                //btn.setPreferredSize(new Dimension(110,110));
                this.vuePlateau.add(btn);
            }
        }
        this.window.setLayout(new BoxLayout(this.window, BoxLayout.LINE_AXIS));

        this.panneauChoix.setBackground(new Color(255, 0,0)); // TODO
        this.panneauChoix.setPreferredSize(new Dimension(this.getWidth()/3, this.getHeight()));
        JLabel ligne1 = new JLabel("C'est à ... de jouer. Voici la tuile piochée :");
        ligne1.setPreferredSize(new Dimension(this.getWidth()/3, 50));
        ligne1.setHorizontalAlignment(JLabel.CENTER);
        //ligne1.setAlignmentY(Component.TOP_ALIGNMENT);
        this.panneauChoix.add(ligne1);
        File file = new File("C:/Users/carol/IdeaProjects/Carcassonne V2/src/Image tuile/Base_Game_C2_Tile_A1.jpg");
        BufferedImage path = ImageIO.read(file);
        JPanel tuilePiochee = new ImagePane(path);
        tuilePiochee.setPreferredSize(new Dimension(110,110));
        tuilePiochee.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.panneauChoix.add(tuilePiochee);
        JLabel ligne2 = new JLabel("test");
        ligne2.setPreferredSize(new Dimension(this.getWidth()/3, 50));
        ligne2.setHorizontalAlignment(JLabel.CENTER);
        this.panneauChoix.add(ligne2);
        this.panneauChoix.add(Box.createVerticalGlue());

        this.window.add(panneauChoix);
        this.window.add(vuePlateau);
        this.window.add(Box.createHorizontalGlue());
        this.getContentPane().add(window);
    }
}
