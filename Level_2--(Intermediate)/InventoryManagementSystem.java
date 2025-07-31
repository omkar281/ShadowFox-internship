import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InventoryManagementSystem extends Application {

    private TableView<Item> table = new TableView<>();
    private TextField nameInput = new TextField();
    private TextField quantityInput = new TextField();
    private Button addButton = new Button("Add");
    private Button deleteButton = new Button("Delete");

    private ObservableList<Item> items = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Inventory Management System");

        table.setEditable(true);

        TableColumn<Item, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        TableColumn<Item, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());

        table.getColumns().addAll(nameColumn, quantityColumn);

        addButton.setOnAction(e -> addItem());
        deleteButton.setOnAction(e -> deleteItem());

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        GridPane.setConstraints(nameInput, 0, 0);
        GridPane.setConstraints(quantityInput, 1, 0);
        GridPane.setConstraints(addButton, 2, 0);
        GridPane.setConstraints(deleteButton, 0, 1);

        grid.getChildren().addAll(nameInput, quantityInput, addButton, deleteButton);

        Scene scene = new Scene(new javafx.scene.layout.VBox(), 400, 300);
        ((javafx.scene.layout.VBox) scene.getRoot()).getChildren().addAll(table, grid);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addItem() {
        String name = nameInput.getText();
        int quantity = Integer.parseInt(quantityInput.getText());
        Item newItem = new Item(name, quantity);
        items.add(newItem);
        nameInput.clear();
        quantityInput.clear();
    }

    private void deleteItem() {
        Item selectedItem = table.getSelectionModel().getSelectedItem();
        items.remove(selectedItem);
    }

    public static class Item {
        private final String name;
        private final Integer quantity;

        public Item(String name, Integer quantity) {
            this.name = name;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public javafx.beans.property.StringProperty nameProperty() {
            return new javafx.beans.property.SimpleStringProperty(name);
        }

        public javafx.beans.property.IntegerProperty quantityProperty() {
            return new javafx.beans.property.SimpleIntegerProperty(quantity);
        }
    }
}
