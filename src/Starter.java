import entity.DataObject;
import utils.FileUtils;
import utils.LocalStorage;
import view.MainPage;

import javax.swing.*;

public class Starter {
    public static void main(String[] args) {
        init();
        SwingUtilities.invokeLater(() -> {
            new MainPage().setVisible(true);
        });
    }

    private static void init() {
        DataObject dataObject = FileUtils.readData();
        LocalStorage.save(LocalStorage.DATA, dataObject);

    }
}
