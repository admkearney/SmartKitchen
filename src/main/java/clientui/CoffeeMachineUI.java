package clientui;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import client.CoffeeMachineClient;

public class CoffeeMachineUI extends ClientUI {

    private static final long serialVersionUID = 1L;
    private JButton brew;
    private JComboBox box;
    private final CoffeeMachineClient parent;

    public CoffeeMachineUI(CoffeeMachineClient coffeeMachineClient) {
        super(coffeeMachineClient);
        parent = coffeeMachineClient;
        init();
    }

    @Override
    public void init() {
        super.init();
        String[] coffee = {"Americano", "Latte", "Cappuccino"};   
        box = new JComboBox(coffee);
        brew = new JButton("Brew");
        scroll.setBounds(5, 40, UIConstants.COMPONENTWIDTH, 300);
        add(new JComboBox[]{box});
        add(new JButton[]{brew});
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //get the option from the combobox
        String type = box.getSelectedItem().toString();
        
        if (type.equals("Americano")) {
            parent.americano();
        }
            
        if (type.equals("Latte")) {
            parent.latte();
        }
        
        if (type.equals("Cappuccino")) {
            parent.cappuccino();
        }
        
    }
}

