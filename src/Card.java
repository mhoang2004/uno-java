import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Card extends JLabel implements MouseListener {
    static final int WIDTH = 80;
    static final int HEIGHT = 120;

    private String color;
    private String rank;

    private User user; // ai gui la bai nay
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

    public Boolean isSpecial() {
        if (rank.length() > 1)
            return true;
        return false;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        this.rank = null;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) 
    {
        this.rank = rank;
    }
    public void suggestedEffect() {
        Border border = new LineBorder(Color.YELLOW, 5);
        setBorder(border);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!user.checkValid(this)) {
            return;
        }
        if(user.checkCard()== false)
        {
            user.getNextUser().setTurn(true);
            user.setTurn(false);
            // choseColorFrame notiFrame = new choseColorFrame("VUI LÒNG RÚT BÀI");
        }
        // if success
        // if (Game.turn == 0) {
        // user.hitCard(this);
        // Game.turn = (Game.turn+1)%4;
        // }
        
        if ((user.getTurn() == true)) {
            
            if (this.getColor() == null)
            {
               // user.chooseColor();
            }
            if (Game.checkWild()) {
                user.wild();
            }
            System.out.println("--------Player card-------");
            // if (user.checkDrawTwo()) {
            //     if (this.getRank() != "DRAWTWO") {
            //         user.checkDrawTwo();
            //         return;
            //     }
            // }
            // if (user.checkDrawFour()) {
            //     if (this.getRank() != "DRAWFOUR") {
            //         user.checkDrawTwo();
            //         return;
            //     }
            // }
            user.hitCard(this);
            if (Game.prevCard.getColor() == "B") {
                Game.frame.setBackground(new Color(0, 0, 255));
            } else if (Game.prevCard.getColor() == "R") {
                Game.frame.setBackground(new Color(255, 0, 0));
            } else if (Game.prevCard.getColor() == "Y") {
                Game.frame.setBackground(new Color(255, 0, 0));
            } else {

            }
        }
        // REVERSE
        if (Game.prevCard.getRank() == "REVERSE") {
            Game.reverse();
        }
        if (!Game.checkSkip()) {
            user.getNextUser().setTurn(true);
            user.setTurn(false);
        }
        // SKIP
        if (Game.checkSkip()) {
            user.skip();
            Timer timer = new Timer(2000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Game.computer1Played();
                    ((Timer) e.getSource()).stop();
                }
            });
            timer.start();
            return;
        }
        if (Game.reverse == true) {
            Timer timer = new Timer(2000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Game.computerPlayed();
                    ((Timer) e.getSource()).stop();
                }
            });
            timer.start();
        } else if (Game.reverse == false) {
            Timer timer = new Timer(2000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Game.computer2Played();
                    ((Timer) e.getSource()).stop();
                }
            });
            timer.start();
        }
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
