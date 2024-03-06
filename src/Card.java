import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Card extends JLabel {
    private String color;
    private String rank;
    private Boolean isSpecial; // if this is not a number cards

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

        // set this.path ...
        String path = "../resources/cards/";
        if (color != null) {
            path += color + "-";
        }
        path += rank + ".png";

        this.setIcon(new ImageIcon(path));
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
}
