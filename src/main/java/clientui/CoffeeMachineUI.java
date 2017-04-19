package clientui;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import client.CoffeeMachineClient;

public class CoffeeMachineUI extends ClientUI {

    private static final long serialVersionUID = 1L;
    private JButton boil;
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
        String[] coffee = {"Americano", "Latte"};
        box = new JComboBox(coffee);
        boil = new JButton("Boil");
        scroll.setBounds(5, 40, UIConstants.COMPONENTWIDTH, 300);
        add(new JComboBox[]{box});
        add(new JButton[]{boil});
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String type = box.getSelectedItem().toString();
        if (type.equals("Latte")) {
            parent.cook();
        }
    }
}

