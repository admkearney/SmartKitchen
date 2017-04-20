package clientui;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import client.StoveClient;
import javax.swing.JTextField;

public class StoveUI extends ClientUI {

    private static final long serialVersionUID = 1L;
    private JButton Hob1;
    private JButton Hob2;
    private JButton Hob3;
    private JButton Hob4;
    
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
        

        Hob1 = new JButton("Hob 1");  //HOB 1
        scroll.setBounds(5, 40, UIConstants.COMPONENTWIDTH, 300);

        add(new JButton[]{Hob1});  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Hob1) {
            parent.Hob1();
        }
    }
}


