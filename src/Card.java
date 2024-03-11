import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

// import java.awt.event.MouseAdapter;
// import java.awt.event.MouseEvent;
public class Card extends JLabel implements MouseListener {
    static final int WIDTH = 80;
    static final int HEIGHT = 120;

    public int index; //
    private String color;
    private String rank;
    private Boolean isSpecial; // if this is not a number cards
    private CardClickListener clickListener;

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

        // set isSpecial ...
        if (rank.length() > 1) {
            isSpecial = true;
        } else {
            isSpecial = false;
        }

        // get image
        String path = "../resources/cards/";
        if (color != null) {
            path += color + "-";
        }
        path += rank + ".png";
        this.setIcon(new ImageIcon(path));
        this.setHorizontalAlignment(JLabel.CENTER); // Center the image horizontally
        this.setVerticalAlignment(JLabel.CENTER); // Center the image vertically

    }

    public void setClickListener(CardClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public String toString() {
        return color + "-" + rank;
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

    public void hitCard(Card currentCard) {
        currentCard = this;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("You clicked the mouse" + "-" + index);

        // check valid card
        clickListener.onCardClick(this);

        // if success
        // hitTheCard();
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
}
