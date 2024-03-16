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
        String src = e.getActionCommand();
        System.out.println(src +"- " +src.substring(0, 0));
        // view.setColor(src.substring(0, 0));
        view.setVisible(false);
    }
}
    
