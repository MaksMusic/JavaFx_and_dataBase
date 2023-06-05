package com.example.javafxanddatabase;

import com.example.javafxanddatabase.dataBase.AccountService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    private AccountService accountService = new AccountService();
    @FXML
    private Label welcomeText;

    @FXML
    private TextField passTextField;

    @FXML
    private TextField loginTextField;

    @FXML
    private Button btnContinue;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnListAcc;


    @FXML
    private void initialize(){

    }

    @FXML
    protected void addAccBtn(){

    String login = loginTextField.getText();
        String pass = passTextField.getText();
        int rowsAffected = accountService.addAcc(login,pass);

        welcomeText.setFont(new Font(25));
        welcomeText.setStyle("-fx-text-fill:green");
        welcomeText.setText("account added to database (" + rowsAffected +" row(s) affected");

        loginTextField.setVisible(false);
        passTextField.setVisible(false);
        btnContinue.setVisible(true);
        btnAdd.setVisible(false);
    }



    @FXML
    protected void continueAccBtn() {
        welcomeText.setFont(new Font(25));
        welcomeText.setStyle("-fx-text-fill:black");

        welcomeText.setText("Registration");
        loginTextField.setText("");
        passTextField.setText("");

        loginTextField.setVisible(true);
        passTextField.setVisible(true);

        btnAdd.setVisible(true);
        btnContinue.setVisible(false);
    }


    @FXML
    private void listAccBtn(ActionEvent event) throws IOException {
        // загружаем новую сцену из FXML-файла
        FXMLLoader loader = new FXMLLoader(getClass().getResource("account-stage.fxml"));
        Parent root = loader.load();

        // создаем новую сцену
        Stage newStage = new Stage();
        Scene scene = new Scene(root,620, 440);
        newStage.setScene(scene);



        // получаем stage из текущего события
        Stage previousStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // передаем предыдущий Stage в новый контроллер
        AccountController accountController = loader.getController();
        accountController.setPreviousStage(previousStage);

        // устанавливаем новую сцену на стейдж и показываем ее
        previousStage.hide();
        newStage.show();

    }


}