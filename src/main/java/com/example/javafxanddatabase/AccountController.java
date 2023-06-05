package com.example.javafxanddatabase;

import com.example.javafxanddatabase.dataBase.AccountDAO;
import com.example.javafxanddatabase.dataBase.AccountService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class AccountController {
    private AccountService accountService = new AccountService();
    private Stage previousStage;

    @FXML
    private Button closeBtn;

    @FXML
    private ListView<String> accountsList;
    private ObservableList<String> accountNames = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        accountsList.setItems(accountNames);
        //accountNames.add("Wfwefwefw");
        for (AccountDAO accountDAO : accountService.getListAcc()) {
            accountNames.add(
                    "ID:" + accountDAO.getId() + " Login: " + accountDAO.getLogin() + " password:" + accountDAO.getPassword());
        }


    }

    public void setPreviousStage(Stage previousStage) {
        this.previousStage = previousStage;
    }

    @FXML
    private void closeClick(ActionEvent event) {
        // закрываем текущий Stage
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();

        // отображаем предыдущий Stage
        if (previousStage != null) {
            previousStage.show();
        }
    }



}
