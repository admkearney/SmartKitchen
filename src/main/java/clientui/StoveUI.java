package clientui;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import client.StoveClient;
import javax.swing.JTextField;

public class StoveUI extends ClientUI {

    private static final long serialVersionUID = 1L;
    private JButton cook;
    private JTextField time;
    private final StoveClient parent;

    public StoveUI(StoveClient stoveClient) {
        super(stoveClient);
        parent = stoveClient;
        init();
    }

    @Override
    public void init() {
        super.init();
        
        JTextField jt = new JTextField(6);
        cook = new JButton("Hob 1");
        scroll.setBounds(5, 40, UIConstants.COMPONENTWIDTH, 300);
        add(new JTextField[]{jt});
        add(new JButton[]{cook});  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cook) {
            parent.cook();
        }
    }
}


