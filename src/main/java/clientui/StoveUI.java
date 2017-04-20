package clientui;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import client.StoveClient;


public class StoveUI extends ClientUI {

    private static final long serialVersionUID = 1L;
    private JButton Hob1;
    private JButton Hob2;
    private JButton Hob3;
    private JButton Hob4;


    private final StoveClient parent;

    public StoveUI(StoveClient stoveClient) {
        super(stoveClient);
        parent = stoveClient;
        init();
    }

    @Override
    public void init() {
        super.init();
        
        Hob1 = new JButton("Hob 1");
        Hob2 = new JButton("Hob 2");  
        Hob3 = new JButton("Hob 3");
        Hob4 = new JButton("Hob 4");
        
        scroll.setBounds(5, 40, UIConstants.COMPONENTWIDTH, 300);
        add(new JButton[]{Hob1});  
        add(new JButton[]{Hob2});
        add(new JButton[]{Hob3});  
        add(new JButton[]{Hob4});
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Hob1)
        {
            parent.Hob1();
        }
        
        else if (e.getSource() == Hob2)
        {
            parent.Hob2();
        }
        
        else if (e.getSource() == Hob3)
        {
            parent.Hob3();
        }
        
        else if (e.getSource() == Hob4)
        {
            parent.Hob4();
        }
                
        
    }
    
    
    
}




