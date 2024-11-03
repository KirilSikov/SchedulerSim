/**
 *
 */
package application;

import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author Kiril and Enrik
 *  The following defines and controls the logic
 *  for the FXML file titled "MainPage".
 */
public class MainPageController {
    @FXML
    public Button FCFS;
    @FXML
    public Button SJF;
    @FXML
    public Button Priority;
    @FXML
    public Button RR;

    //to pass data to next screen
    Singleton data = Singleton.getInstance();
    /**
     * fcfsSelect handles the logic when a user presses
     * the FCFS button. The function runs the simulation
     * and then sends the result to be displayed in the
     * next scene.
     * @param event: button being pressed.
     * @throws IOException
     */
    public void fcfsSelect(ActionEvent event) throws IOException {
        Settings usrRules = new Settings(5, 10);

        List <Process> ls = Simulator.createProcList(usrRules);
        Simulator.FCFS(ls);
        data.setList(ls);
        results(event);
    }

    /**
     * sjfSelect handles the logic when a user presses
     * the SJF button. The function runs the simulation
     * and then sends the result to be displayed in the
     * next scene.
     * @param event: button being pressed.
     * @throws IOException
     */
    public void sjfSelect(ActionEvent event) throws IOException {
        Settings usrRules = new Settings(5, 10);

        List <Process> ls = Simulator.createProcList(usrRules);
        Simulator.SJF(ls);
        data.setList(ls);
        results(event);
    }

    /**
     * PrioritySelect handles the logic when a user presses
     * the Priority button. The function runs the simulation
     * and then sends the result to be displayed in the
     * next scene.
     * @param event: button being pressed.
     * @throws IOException
     */
    public void PrioritySelect(ActionEvent event) throws IOException {
        Settings usrRules = new Settings(5, 10);

        List <Process> ls = Simulator.createProcList(usrRules);
        Simulator.Priority(ls);
        data.setList(ls);
        results(event);
    }

    /**
     * RobinSelect handles the logic when a user presses
     * the Round Robin button. The function runs the simulation
     * and then sends the result to be displayed in the
     * next scene.
     * @param event: button being pressed.
     * @throws IOException
     */
    public void RobinSelect(ActionEvent event) throws IOException {
        Settings usrRules = new Settings(5, 10);

        List <Process> ls = Simulator.createProcList(usrRules);
        Simulator.RR(ls);
        data.setList(ls);
        results(event);
    }

    /**
     * results sends the UI to the next FXML file, which is
     * the results screen.
     * @param event: passed in button press
     * @throws IOException
     */
    public void results(ActionEvent event) throws IOException {
        Parent logScreen = FXMLLoader.load(getClass().getResource("Results.fxml"));
        Scene chgScreen = new Scene(logScreen);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(chgScreen);
        window.show();
        return;
    }
}
