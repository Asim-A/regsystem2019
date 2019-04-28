package org.AHJ.controllers.FXMLControllers;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.cells.editors.TextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class JFOENIXTABLEVIEWTEST {
    /*implements Initializable {

    @FXML
    private JFXTreeTableColumn<User, String> forNavnEditableColumn;

    @FXML
    private JFXTreeTableColumn lastNameEditableColumn;

    @FXML
    private TreeTableView<User> editableTreeTableView;

    public void exitApplication(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle){
        System.out.println("controller");
        forNavnEditableColumn.setPrefWidth(150);
        forNavnEditableColumn.settCellValueFactory((TreeTableColumn.CellDataFeatures<User, String> param) ->{
            if(forNavnEditableColumn.validateValue(param)) return param.getValue().getValue().userName;
            else return forNavnEditableColumn.getComputedValue(param);
        });

        forNavnEditableColumn.setCellFactory((TreeTableColumn<User, String> param) -> new GenericEditableTreeTableCell,
                String>(new TextFieldEditorBuilder()));
        forNavnEditableColumn.setOnEditCommit((TreeTableColumn.CellEditEvent<User, String> t)->{
            ((User) t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue())
                    .userName.set(t.getNewValue());
        });

        ObservableList<User> users = FXCollections.observableArrayList();
        users.add(new User("frank"));

        final TreeItem<User> root = new RecursiveTreeItem<User>(users, RecursiveTreeObject::getChildren);

        editableTreeTableView.setShowRoot(false);
        editableTreeTableView.setEditable(true);
        editableTreeTableView.getColumns().setAll(forNavnEditableColumn);
    }

    class User extends RecursiveTreeObject<User>{
        StringProperty userName;

        public User(String userName) {
            this.userName = new SimpleStringProperty(userName);
        }
    }




        firstNameEditableColumn.settCellValueFactory((JFXTreeTableColumn.CellDataFeatures<Kunde, String> param) ->{

                return param.getValue();
            });

            }
}

class Kunde extends RecursiveTreeObject<Kunde> {
    StringProperty Fornavn;
    public Kunde( String fornavn) {
        this.Fornavn = new SimpleStringProperty(fornavn);
    }*/
}
