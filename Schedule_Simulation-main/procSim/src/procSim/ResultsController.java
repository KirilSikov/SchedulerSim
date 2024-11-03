package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
/**
 * @author Kiril and Enrik
 *  The following defines and controls the logic
 *  for the FXML file titled "Results".
 */
public class ResultsController implements Initializable{
    @FXML
    public Button back;

    //Table defining
    @FXML
    private TableView<Process> procList;

    //Table column definitions
    @FXML
    private TableColumn<Process, Integer> procID;
    @FXML
    private TableColumn<Process, Integer> burst;
    @FXML
    private TableColumn<Process, Integer> waiting;
    @FXML
    private TableColumn<Process, Integer> turnaround;

    //persistent data from MainPageController
    Singleton data = Singleton.getInstance();

    /**
     * BackMain handles the button being pressed to send
     * the program back to the main landing page.
     * @param event: button being pressed.
     * @throws IOException
     */
    public void backMain(ActionEvent event) throws IOException {
        returnMain(event);
        return;
    }

    /**
     * returnMain returns the stage to the main landing page.
     * @param event: passed in button press. Necessary for
     * Stage initialization.
     * @throws IOException
     */
    public void returnMain(ActionEvent event) throws IOException {
        Parent logScreen = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene chgScreen = new Scene(logScreen);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(chgScreen);
        window.show();
        return;
    }

    /**
     * initialize creates and initializes the table present within
     * the results FXML file, with each table column corresponding
     * to a field within the Process object. These values get filled
     * when the ovarall table (procList) obtains the process list
     * from getLs()
     */
    @Override
    public void initialize(URL arg0, ResourceBundle rb) {
        procID.setCellValueFactory(new PropertyValueFactory<Process,Integer>("pid"));
        burst.setCellValueFactory(new PropertyValueFactory<Process,Integer>("burstTime"));
        waiting.setCellValueFactory(new PropertyValueFactory<Process,Integer>("waitingTime"));
        turnaround.setCellValueFactory(new PropertyValueFactory<Process,Integer>("turnaroundTime"));

        procList.setItems(getls());
    }

    /**
     * getLs obtains the list passed in from MainPageController
     * and converts it to be used in a JavaFX table through
     * the conversion to an ObservableList.
     */
    private ObservableList<Process> getls() {
        ObservableList<Process> lst = FXCollections.observableArrayList(data.getList());
        return lst;
    }
}
