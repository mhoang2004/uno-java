import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class choseColor  implements ActionListener{
    choseColorFrame view;
    choseColor(choseColorFrame view)
    {
        this.view = view ;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        System.out.println("CLICKINGGGGGGG");
        view.src = e.getActionCommand();
        view.src =view.src.charAt(0) +"";
        view.user.setColorPrevCard(view.src, view.thisCard);
        System.out.println("test: " + Game.prevCard.toString());
        Player.choosingColor = true;
        view.user.getNextUser().setTurn(true);
        view.user.setTurn(false);
        view.user.hitCard(view.thisCard);
        if(Game.reverse == true)
        {
            Game.computerPlayed();
        }else{
            Game.computer2Played();
        }
        
        view.setVisible(false);
        

    }
}
    
