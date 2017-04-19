package clientui;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import client.MicrowaveClient;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MicrowaveUI extends ClientUI {

    private static final long serialVersionUID = 1L;
    private JButton cook;
    private JTextField time;
    private JLabel label;
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
        JLabel jl = new JLabel("Seconds");
        cook = new JButton("Cook");
        scroll.setBounds(5, 40, UIConstants.COMPONENTWIDTH, 300);
        add(new JTextField[]{jt});
        add(new JLabel[]{jl});
        add(new JButton[]{cook});  
        
        String strseconds = jt.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        parent.cook();

    }
}

