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
    private String rank;

    private User user;

    // BACK CARD
    Card() {
        super();
        color = null;
        rank = "BACK";
        setCard();
    }

    Card(Card x) {
        super();
        this.color = x.color;
        this.rank = x.rank;
        this.setCard();
    }

    Card(String color, String rank) {
        super();
        this.color = color;
        this.rank = rank;
        setCard();
    }

    public void setCard() {
        String path = "../resources/cards/";
        if (color != null) {
            path += color + "-";
        }
        path += rank + ".png";
        this.setIcon(new ImageIcon(path));
        this.setHorizontalAlignment(JLabel.CENTER); // Center the image horizontally
        this.setVerticalAlignment(JLabel.CENTER); // Center the image vertically
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String toString() {
        return color + "-" + rank;
    }

    public void assignCard(Card card) {
        this.color = card.getColor();
        this.rank = card.getRank();
        this.setIcon(card.getIcon());
    }

    private Boolean isSpecial() {
        if (rank.length() > 1)
            return true;
        return false;
    }

    public String getColor() {
        return color;
    }

    public String getRank() {
        return rank;
    }

    public void suggestedEffect() {
        Border border = new LineBorder(Color.YELLOW, 5);
        setBorder(border);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO check valid card

        // if success
        user.hitCard(this);
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
