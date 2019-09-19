import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

class AddPersonCell extends TableCell<Program, Boolean> {
    // a button for adding a new person.
    final Button addButton = new Button("Add");
    // pads and centers the add button in the cell.
    final StackPane paddedButton = new StackPane();
    // records the y pos of the last button press so that the add person dialog can be shown next to the cell.
    final DoubleProperty buttonY = new SimpleDoubleProperty();

    /**
     * AddPersonCell constructor
     *
     * @param stage the stage in which the table is placed.
     * @param table the table to which a new person can be added.
     */
    AddPersonCell(final Stage stage, final TableView table) {
        paddedButton.setPadding(new Insets(3));
        paddedButton.getChildren().add(addButton);
        addButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                buttonY.set(mouseEvent.getScreenY());
            }
        });
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("test1");
                table.getSelectionModel().select(getTableRow().getIndex());
            }
        });
    }
}