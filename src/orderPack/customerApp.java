package orderPack;

import javax.swing.*;
import orderPack.UI.customerUI;

public class customerApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new customerUI().setVisible(true);
        });
    }
}
