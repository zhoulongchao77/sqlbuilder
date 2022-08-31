package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import sample.util.KnexSql;
import sample.util.State;
import sample.util.TalkUtil;
import sample.util.TypeValue;

public class Controller {

    @FXML
    private ComboBox<String> selectType;

    @FXML
    private TextArea inputArea;

    @FXML
    private TextArea outputArea;

    @FXML
    private Button generateSQLId;

    KnexSql knexSql = new KnexSql();

    @FXML
    private void initialize() {
        ObservableList<String> observableList = FXCollections.observableArrayList(TypeValue.NODE_KNEX);
        selectType.setItems(observableList);
    }

    @FXML
    void generateSQL(ActionEvent event) {
        String input = inputArea.getText();
        String output = "";
        if (State.nowState == null) {
            TalkUtil.talk("请在下拉列表中选择SQL日志来源", "提示");
            return;
        }
        if (State.nowState == TypeValue.NODE_KNEX) {
            output = knexSql.builder(input);
        }
        outputArea.setText(output);
    }

    @FXML
    void getSelectType(ActionEvent event) {
        State.nowState = selectType.getValue();
    }
}
