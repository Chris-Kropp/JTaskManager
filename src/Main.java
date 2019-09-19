import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        TextField search = new TextField();
        TableView table = new TableView();
        table.getItems().addAll(TableViewHelper.getProgramList());

        TableColumn ppidcol = TableViewHelper.getPpidColumn();
        ppidcol.prefWidthProperty().bind(pane.widthProperty().divide(10));

        TableColumn namecol = TableViewHelper.getNameColumn();
        namecol.prefWidthProperty().bind(pane.widthProperty().divide(5).multiply(1.5));
//        namecol.prefWidthProperty().bind(pane.widthProperty().subtract(pane.widthProperty().divide(10).add(pane.widthProperty().divide(5)).add(pane.widthProperty().divide(5))));

        TableColumn cpucol = TableViewHelper.getCpuColumn();
        cpucol.prefWidthProperty().bind(pane.widthProperty().divide(5).subtract(10));

        TableColumn ramcol = TableViewHelper.getRamColumn();
        ramcol.prefWidthProperty().bind(pane.widthProperty().divide(5).subtract(10));

        TableColumn btncol = TableViewHelper.getButtonColumn();
        btncol.prefWidthProperty().bind(pane.widthProperty().divide(5).subtract(10));



        table.getColumns().addAll(ppidcol, namecol, cpucol, ramcol, btncol);

        TableColumn actionCol = new TableColumn("Action");
        actionCol.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
        btncol.setCellFactory(ActionButtonTableCell.<Program>forTableColumn("Kill", (Program pgm) -> {
            table.getItems().remove(pgm);
            String cmd = "kill " + pgm.getPpid();
            try {
                Process p = Runtime.getRuntime().exec(cmd);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("btnpress");

            return pgm;
        }));


//        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setPlaceholder(new Label("No visible columns and/or data exist."));
        table.prefHeightProperty().bind(pane.heightProperty());
        table.prefWidthProperty().bind(pane.widthProperty());
//        table.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        ObservableList cols = table.getColumns();
//        cols.

        pane.getChildren().add(table);


        Scene scene = new Scene(pane, 400,500);
        stage.setScene(scene);
        stage.setTitle("A simple TableView Example");
        stage.show();
    }
}