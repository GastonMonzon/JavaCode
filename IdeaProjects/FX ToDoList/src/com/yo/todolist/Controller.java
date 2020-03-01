package com.yo.todolist;

import com.yo.todolist.datamodel.ToDoData;
import com.yo.todolist.datamodel.ToDoItem;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Controller {
    private List<ToDoItem> todoItems;
    @FXML
    private ListView toDoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadLineLabel;
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private ContextMenu listContextMenu;
    @FXML
    private ToggleButton filterToggleButton;

    private FilteredList<ToDoItem> filteredList;

    private Predicate<ToDoItem> wantAllItems;
    private Predicate<ToDoItem> wantTodaysItems;

    @FXML
    public void initialize() {
//        ToDoItem item1 = new ToDoItem("Mail", "Get something", LocalDate.of(2020, Month.AUGUST, 25));
//        ToDoItem item2 = new ToDoItem("Buy Hack", "Buy That", LocalDate.of(2020, Month.FEBRUARY, 14));
//        ToDoItem item3 = new ToDoItem("Web", "Surf", LocalDate.of(2020, Month.APRIL, 3));
//        ToDoItem item4 = new ToDoItem("Wifi", "Contract", LocalDate.of(2020, Month.NOVEMBER, 1));
//        ToDoItem item5 = new ToDoItem("Something", "Buy something", LocalDate.of(2020, Month.JANUARY, 28));
//
//        todoItems = new ArrayList<>();
//        todoItems.add(item1);
//        todoItems.add(item2);
//        todoItems.add(item3);
//        todoItems.add(item4);
//        todoItems.add(item5);
//
//        ToDoData.getInstance().setToDoItems(todoItems);

        listContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem();
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ToDoItem item = (ToDoItem) toDoListView.getSelectionModel().getSelectedItem();
                deleteItem(item);
            }
        });

        listContextMenu.getItems().addAll(deleteMenuItem);
        toDoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ToDoItem>() {
            @Override
            public void changed(ObservableValue<? extends ToDoItem> observableValue, ToDoItem oldValue, ToDoItem newValue) {
                if (newValue != null) {
                    ToDoItem item = (ToDoItem) toDoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d MMMM, yyyy");
                    deadLineLabel.setText(dateTimeFormatter.format(item.getDeadline()));
                }
            }
        });
        wantAllItems = new Predicate<ToDoItem>() {
            @Override
            public boolean test(ToDoItem toDoItem) {
                return true;
            }
        };

        wantTodaysItems = new Predicate<ToDoItem>() {
            @Override
            public boolean test(ToDoItem toDoItem) {
                return toDoItem.getDeadline().equals(LocalDate.now());
            }
        };

        filteredList = new FilteredList<ToDoItem>(ToDoData.getInstance().getToDoItems(), wantAllItems);
//                new Predicate<ToDoItem>() {
//                    @Override
//                    public boolean test(ToDoItem toDoItem) {
//                        return true;
//                    }
//                });
                SortedList < ToDoItem > sortedList = new SortedList<ToDoItem>(filteredList,//ToDoData.getInstance().getToDoItems(),
                        new Comparator<ToDoItem>() {
                            @Override
                            public int compare(ToDoItem o1, ToDoItem o2) {
                                return o1.getDeadline().compareTo(o2.getDeadline());
                            }
                        });

//        toDoListView.setItems(ToDoData.getInstance().getToDoItems());
        toDoListView.setItems(sortedList);
        toDoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        toDoListView.getSelectionModel().selectFirst();

        toDoListView.setCellFactory(new Callback<ListView<ToDoItem>, ListCell<ToDoItem>>() {
            @Override
            public ListCell<ToDoItem> call(ListView<ToDoItem> param) {
                ListCell<ToDoItem> cell = new ListCell<>() {
                    @Override
                    protected void updateItem(ToDoItem item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setText(null);
                        } else {
                            setText(item.getShortDescription());
                            if (item.getDeadline().isBefore(LocalDate.now().plusDays(1))) {
                                setTextFill(Color.RED);
                            } else if (item.getDeadline().equals(LocalDate.now().plusDays(1))) {
                                setTextFill(Color.ORANGE);
                            }
                        }
                    }
                };
                cell.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
                    if (isNowEmpty) {
                        cell.setContextMenu(null);
                    } else {
                        cell.setContextMenu(listContextMenu);
                    }
                });
                return cell;
            }
        });
    }

    @FXML
    public void showNewItemDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New ToDo Item");
        dialog.setHeaderText("Use this title to create a new todo item");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoitemDialog.fxml"));
        try {
//            Parent root = FXMLLoader.load(getClass().getResource("todoitemDialog.fxml"));
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            DialogController controller = fxmlLoader.getController();
            ToDoItem newItem = controller.procesResults();
//            toDoListView.getItems().setAll(ToDoData.getInstance().getToDoItems());
            toDoListView.getSelectionModel().select(newItem);
            System.out.println("OK pressed");
        }
//        else{
//            System.out.println("Cancel pressed");
//        }

    }

    @FXML
    public void handleKeyPressed(KeyEvent keyEvent) {
        ToDoItem selectedItem = (ToDoItem) toDoListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            if (keyEvent.getCode().equals(KeyCode.DELETE)) {
                deleteItem(selectedItem);
            }
        }
    }

    @FXML
    public void handleClickListView() {
        ToDoItem item = ((ToDoItem) toDoListView.getSelectionModel().getSelectedItem());
        itemDetailsTextArea.setText(item.getDetails());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d MMMM, yyyy");
        deadLineLabel.setText(dateTimeFormatter.format(item.getDeadline()));

//        System.out.println("The selected item is " + item);
//        StringBuilder stringBuilder = new StringBuilder(item.getDetails());
//        stringBuilder.append("\n\n\n\n\n");
//        stringBuilder.append("Due ");
//        stringBuilder.append(item.getDeadline().toString());
//        itemDetailsTextArea.setText(stringBuilder.toString());
//        itemDetailsTextArea.setText(item.getDetails());
    }

    @FXML
    public void deleteItem(ToDoItem item) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete ToDo Item");
        alert.setHeaderText("Delete Item: " + item.getShortDescription());
        alert.setContentText("Are you sure? Press OK to Confirm or cancel to Back out.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            ToDoData.getInstance().deleteToDoItem(item);
        }
    }

    @FXML
    public void handleFilterButton(){
        ToDoItem selectedItem = (ToDoItem) toDoListView.getSelectionModel().getSelectedItem();

        if(filterToggleButton.isSelected()){
            filteredList.setPredicate(wantTodaysItems);//new Predicate<ToDoItem>() {
            if(filteredList.isEmpty()){
                itemDetailsTextArea.clear();
                deadLineLabel.setText("");
            }else if(filteredList.contains(selectedItem)){
                toDoListView.getSelectionModel().select(selectedItem);
            }else{
                filteredList.setPredicate(wantAllItems);
                toDoListView.getSelectionModel().selectFirst();
            }
//                @Override
//                public boolean test(ToDoItem toDoItem) {
//                    return toDoItem.getDeadline().equals(LocalDate.now());
//                }
//            });
        }else{
            filteredList.setPredicate(wantTodaysItems);//new Predicate<ToDoItem>() {
            toDoListView.getSelectionModel().select(selectedItem);
//                @Override
//                public boolean test(ToDoItem toDoItem) {
//                    return true;
//                }
//            });
        }
    }
    @FXML
    public void handleExit(){
        Platform.exit();
    }
}
