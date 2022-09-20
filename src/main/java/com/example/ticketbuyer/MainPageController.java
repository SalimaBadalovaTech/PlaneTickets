package com.example.ticketbuyer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MainPageController implements Initializable {
    private String username;


    private ArrayList<Flight> routes = new ArrayList<>();
    private ArrayList<Flight> availableRoutes = new ArrayList<>();
    private ArrayList<Flight> myTickets = new ArrayList<>();
    private ArrayList<Flight> ticketsToSave = new ArrayList<>();


    public static Flight name;
    @FXML
    private Label label_username;

    @FXML
    private Button button_logout;
    @FXML
    private Button search;
    @FXML
    private Button button_back;
    @FXML
    private Button button_go_to_my_tickets;
    @FXML
    private Button button_add_to_my_tickets;
    @FXML
    private Button button_delete_to_my_tickets;
    @FXML
    private ListView<Flight> listView1;
    @FXML
    private TextField destination;
    @FXML
    private TextField passengerCount;
    @FXML
    private Button save;

    public MainPageController() throws FileNotFoundException {
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            readText();
            readUserFlights();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(routes.size());
        mainPageView();
        listView1.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, flight, t1) -> name = listView1.getSelectionModel().getSelectedItem());

    }

    public String displayName(String username) {
        label_username.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        label_username.setText("Welcome, " + username + "!");
        this.username = username;
        return username;
    }

    public void readText() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("src/main/resources/com/example/ticketbuyer/routes.txt"));
        while (scan.hasNextLine()) {
            String[] values = scan.nextLine().split(",");
            Flight flight = new Flight(values[0], values[1], values[2], Integer.parseInt(values[3]));
            routes.add(flight);
        }
        System.out.println(routes.get(1));

    }

    public ArrayList<Flight> readUserFlights() throws FileNotFoundException {

        Scanner scan = new Scanner(new File("src/main/resources/com/example/ticketbuyer/myTickets.txt"));
        ArrayList<Flight> newArray = new ArrayList<>();
        while (scan.hasNextLine()) {
            String[] values = scan.nextLine().split(",");
            if (values[0].equals("admin")) {
                Flight flight = new Flight(values[1], values[2], values[3], Integer.parseInt(values[4]));
                myTickets.add(flight);
                newArray.add(flight);
            }

        }
        return newArray;
    }

    public void addToMyTickets(ActionEvent event) {
        if (myTickets.contains(name)) {
            System.out.println("You have already added this ticket");
        } else {
            ticketsToSave.add(name);
            myTickets.add(name);
        }
    }

    public void showMyTickets(ActionEvent event) {
        addButtonBack();
        listView1.getItems().clear();
        listView1.getItems().addAll(myTickets);
    }

    public void formatButton(Button button, String buttonName) {
        button.setVisible(true);
        button.setText(buttonName);
        button.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
        button.setBackground(Background.fill(Color.web("#ffd700")));
    }

    public void addButtonBack() {
        formatButton(button_back, "Go back");
        formatButton(button_delete_to_my_tickets, "Delete from My Tickets");
        formatButton(save, "Save");
    }

    public void mainPageView() {
        button_back.setVisible(false);
        button_delete_to_my_tickets.setVisible(false);
        save.setVisible(false);
        listView1.getItems().clear();
        listView1.getItems().addAll(routes);
    }

    public void deleteFromMyTickets(ActionEvent event) {
        System.out.println(name);
        myTickets.remove(name);
        showMyTickets(event);
    }

    public void searchForFlights(ActionEvent event) {
        availableRoutes = new ArrayList<>();
        if (destination.getText() != null && passengerCount.getText() != null) {
            for (Flight flight : routes) {
                if (flight.getDestination().equals(destination.getText()) &&
                        flight.getPeople() >= Integer.parseInt(passengerCount.getText())) {
                    availableRoutes.add(flight);
                }
            }
        }
        listView1.getItems().clear();
        listView1.getItems().addAll(availableRoutes);
    }

    public void logout(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void writeFile(ActionEvent event) throws IOException {
        FileWriter fw = new FileWriter("src/main/resources/com/example/ticketbuyer/myTickets.txt", true);
        for (Flight flight : myTickets) {
            fw.write(username + "," + flight.toString() + "\n");
        }

        fw.close();
    }

}
