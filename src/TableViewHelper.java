import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class TableViewHelper {

    static ArrayList<Program> programArrayList = new ArrayList<>();

    public static void addToProgramList(Program prgm){
        programArrayList.add(prgm);
    }

    // Returns an observable list of Programs
    public static ObservableList<Program> getProgramList() {
        getRunning.runGetRunning();
        return FXCollections.<Program>observableArrayList(programArrayList);
    }

    // Returns Program Id TableColumn
    public static TableColumn<Program, Integer> getNameColumn() {
        TableColumn<Program, Integer> idCol = new TableColumn<>("Program Name");
        PropertyValueFactory<Program, Integer> nameFactory = new PropertyValueFactory<>("name");
        idCol.setCellValueFactory(nameFactory);
        return idCol;
    }

    // Returns First Name TableColumn
    public static TableColumn<Program, String> getCpuColumn() {
        TableColumn<Program, String> firstNameCol = new TableColumn<>("CPU (%)");
        PropertyValueFactory<Program, String> cpuFactory = new PropertyValueFactory<>("cpuUsage");
        firstNameCol.setCellValueFactory(cpuFactory);
        return firstNameCol;
    }

    // Returns Last Name TableColumn
    public static TableColumn<Program, String> getPpidColumn() {
        TableColumn<Program, String> lastNameCol = new TableColumn<>("PPID");
        PropertyValueFactory<Program, String> ppidFactory = new PropertyValueFactory<>("ppid");
        lastNameCol.setCellValueFactory(ppidFactory);
        return lastNameCol;
    }

    // Returns Last Name TableColumn
    public static TableColumn<Program, String> getRamColumn() {
        TableColumn<Program, String> lastNameCol = new TableColumn<>("RAM (%)");
        PropertyValueFactory<Program, String> ramFactory = new PropertyValueFactory<>("ramUsage");
        lastNameCol.setCellValueFactory(ramFactory);
        return lastNameCol;
    }

    public static TableColumn<Program, String> getButtonColumn() {
        TableColumn<Program, String> lastNameCol = new TableColumn<>("Kill Process");
        PropertyValueFactory<Program, String> btnFactory = new PropertyValueFactory<>("btn");
        lastNameCol.setCellValueFactory(btnFactory);
        return lastNameCol;
    }
}