package clientui;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import client.KettleClient;

public class KettleUI extends ClientUI {

    private static final long serialVersionUID = 1L;
    private JButton boil;
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
        scroll.setBounds(5, 40, UIConstants.COMPONENTWIDTH, 300);
        add(new JButton[]{boil});
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boil) {
            parent.boil();
        }
    }
}
