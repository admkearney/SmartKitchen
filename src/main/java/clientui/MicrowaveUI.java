package clientui;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import client.MicrowaveClient;
import javax.swing.JTextField;

public class MicrowaveUI extends ClientUI {

    private static final long serialVersionUID = 1L;
    private JButton cook;
    private JTextField time;
    private final MicrowaveClient parent;

    public MicrowaveUI(MicrowaveClient microwaveClient) {
        super(microwaveClient);
        parent = microwaveClient;
        init();
    }

    @Override
    public void init() {
        super.init();
        
        JTextField jt = new JTextField(6);
        cook = new JButton("Cook");
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

