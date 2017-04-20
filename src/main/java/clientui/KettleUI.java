package clientui;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import client.KettleClient;

public class KettleUI extends ClientUI {
    

    private static final long serialVersionUID = 1L;
    
    // Two Buttons Used. 
    private JButton boil;
    private JButton power;
            
    private final KettleClient parent;

    public KettleUI(KettleClient kettleClient) {
        super(kettleClient);
        parent = kettleClient;
        init();
    }

    @Override
    public void init() {
        super.init();
        boil = new JButton("Boil");
        power = new JButton("Power");
        scroll.setBounds(5, 40, UIConstants.COMPONENTWIDTH, 300);
        add(new JButton[]{boil});
        add(new JButton[]{power});
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boil) {
            parent.boil();
        }
        
        else if (e.getSource() == power){
            parent.power();
        }            
    }
}
