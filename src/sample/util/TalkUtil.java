package sample.util;

import javafx.scene.control.Alert;

public class TalkUtil {
    public static void talk(String msg, String type) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.titleProperty().set(type);
        alert.headerTextProperty().set(msg);
        alert.showAndWait();
    }
}
