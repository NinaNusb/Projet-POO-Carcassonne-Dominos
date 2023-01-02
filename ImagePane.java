import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class ImagePane extends JPanel {

    // attributs

    private static final long serialVersionUID = 1L;
    protected Image buffer;

    // constructeur
    public ImagePane(Image buffer){
        this.buffer = buffer;
    }

    public void paintComponent(Graphics g) {
        g.drawImage(buffer,0,0,null);
    }
}