import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
// import java.awt.event.MouseAdapter;
// import java.awt.event.MouseEvent;
public class Card extends JLabel {
    static final int WIDTH = 80;
    static final int HEIGHT = 120;

    private String color;
    private String rank;
    private Boolean isSpecial; // if this is not a number cards
 
    private int y; // where y-dimension of card should be appeard

    Card(String color, String rank) {
        super();
        this.color = color;
        this.rank = rank;
        this.y = 20;

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

    public int getY() {
        return y;
    }

    public void setY() { // select card UI
        if (this.y == 20)
            this.y = 0;
        else
            this.y = 20;
    }

    public void suggestedEffect(){
        // suggestion effect
        Border border = new LineBorder(Color.YELLOW, 5);
        setBorder(border);
    }
}
