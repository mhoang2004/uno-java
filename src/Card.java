import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Card extends JLabel implements MouseListener {
    static final int WIDTH = 80;
    static final int HEIGHT = 120;

    private String color;
    private String path;
    private String rank;
    private Boolean isSpecial; // if this is not a number cards

    // BACK CARD
    Card() {
        super();

        this.color = null;
        this.rank = "BACK";
        isSpecial = false;

        this.setIcon(new ImageIcon("../resources/cards/BACK.png"));
        this.setHorizontalAlignment(JLabel.CENTER); // Center the image horizontally
        this.setVerticalAlignment(JLabel.CENTER); // Center the image vertically
    }

    Card(String color, String rank) {
        super();
        this.color = color;
        this.rank = rank;
        setIsSpecial();

        // get image
        this.path = "../resources/cards/";
        if (color != null) {
            path += color + "-";
        }
        path += rank + ".png";
        this.setIcon(new ImageIcon(path));
        this.setHorizontalAlignment(JLabel.CENTER); // Center the image horizontally
        this.setVerticalAlignment(JLabel.CENTER); // Center the image vertically
    }

    public String toString() {
        return color + "-" + rank;
    }

    public void hitCard(Card card) {
        this.color = card.getColor();
        this.rank = card.getRank();
        this.path = card.getPath();
        setIsSpecial();

        this.setIcon(new ImageIcon(path));
    }

    private void setIsSpecial() {
        if (rank.length() > 1) {
            isSpecial = true;
        } else {
            isSpecial = false;
        }
    }

    public String getPath() {
        return path;
    }

    public Boolean getIsSpecial() {
        return isSpecial;
    }

    public String getColor() {
        return color;
    }

    public String getRank() {
        return rank;
    }

    public void suggestedEffect() {
        // suggestion effect
        Border border = new LineBorder(Color.YELLOW, 5);
        setBorder(border);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // check valid card

        // if success
        Game.prevCard.hitCard(this);

        // player.cards.remove(this);
        // player.getLastestPanel();
        // layeredPane.remove(button);
        // layeredPane.revalidate();
        // layeredPane.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setLocation(this.getX(), 20);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setLocation(this.getX(), 50);
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (rank == null) {
            if (other.rank != null)
                return false;
        } else if (!rank.equals(other.rank))
            return false;
        return true;
    }
}
