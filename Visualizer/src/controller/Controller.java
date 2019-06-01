package controller;

import Item.ItemArray;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) { }

    @FXML
    private Button quickBtn;
    @FXML
    private Button radixBtn;

    @FXML
    private Button bubbleBtn;

    @FXML
    private Button heapBtn;


    // Quick Sort
    @FXML
    public void initQuickSort(ActionEvent event) {
        Stage stage = (Stage) quickBtn.getScene().getWindow();
        stage.hide();

        Stage primaryStage = new Stage();
        SortPane SortPane = new SortPane();
        SortPane.setPadding(new Insets(5, 5, 5, 5));
        primaryStage.setHeight(355);
        primaryStage.setWidth(665);


        Button resetBtn = new Button("Reset");
        Button menuBtn = new Button("Menu");

        HBox myBox = new HBox(5);
        myBox.getChildren().addAll(resetBtn, menuBtn);
        myBox.setAlignment(Pos.CENTER);

        BorderPane mainPane = new BorderPane();
        mainPane.setPadding(new Insets(5, 5, 5, 5));
        mainPane.setCenter(SortPane);
        mainPane.setBottom(myBox);
        mainPane.setStyle("-fx-background-color: #C382AE");

        Label status = new Label();
        mainPane.setTop(status);
        BorderPane.setAlignment(status, Pos.CENTER);
        Scene myScene = new Scene(mainPane, 400, 250);
        primaryStage.setTitle("Quick Sort");
        primaryStage.setScene(myScene);
        primaryStage.show();


        // init array
        ItemArray array = new ItemArray(20);

        mainPane.getChildren().addAll(array.getAll());

        sort(array, 0, array.length() - 1);


        array.getAnimation().play();

        resetBtn.setOnAction(event1 -> {
            primaryStage.hide();
            initQuickSort(event1);
        });
        menuBtn.setOnAction(event1 -> {
            primaryStage.hide();
            stage.show();
        });

    }

    int partition (ItemArray arr,int low, int high){
        int pivot = arr.getItemAt(high).getIndex();
        int i = (low - 1);
        for (int j = low; j < high; j++) {

            if (arr.compare(j, pivot) <= 0) {
                i++;

                arr.swap(i, j);
            }
        }

        arr.swap(i + 1, high);

        return i + 1;
    }


    public void sort(ItemArray arr,int low, int high){
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }


    // Bubble Sort
    @FXML
    public void initBubbleSort(ActionEvent event) {
        // close menu stage and open sort stage
        Stage stage = (Stage) bubbleBtn.getScene().getWindow();
        stage.hide();

        Stage primaryStage = new Stage();
        SortPane SortPane = new SortPane();
        SortPane.setPadding(new Insets(5, 5, 5, 5));
        primaryStage.setHeight(355);
        primaryStage.setWidth(665);


        Button resetBtn = new Button("Reset");
        Button menuBtn = new Button("Menu");

        HBox myBox = new HBox(5);
        myBox.getChildren().addAll(resetBtn, menuBtn);
        myBox.setAlignment(Pos.CENTER);

        BorderPane mainPane = new BorderPane();
        mainPane.setPadding(new Insets(5, 5, 5, 5));
        mainPane.setCenter(SortPane);
        mainPane.setBottom(myBox);
        mainPane.setStyle("-fx-background-color: #C382AE");

        Label status = new Label();
        mainPane.setTop(status);
        BorderPane.setAlignment(status, Pos.CENTER);
        Scene myScene = new Scene(mainPane, 400, 250);
        primaryStage.setTitle("Bubble Sort");
        primaryStage.setScene(myScene);
        primaryStage.show();


        // init array
        ItemArray array = new ItemArray(20);

        mainPane.getChildren().addAll(array.getAll());

        // Bubble sorting
        for (int i = array.length(); i >= 1; i--) {
            for (int j = 0; j < i - 1; j++)
                array.compareAndSwap(j, j + 1);
        }

        array.getAnimation().play();

        resetBtn.setOnAction(event1 -> {
            primaryStage.hide();
            initBubbleSort(event1);
        });
        menuBtn.setOnAction(event1 -> {
            primaryStage.hide();
            stage.show();
        });
    }

    public  final static int MAX_ARRAY_SIZE = 20;

    private final int[] myList = new int[MAX_ARRAY_SIZE];

    // init heap
    Label [] labels = new Label[myList.length];
    int i = myList.length / 2 - 1;
    int j = myList.length -1;

    @FXML
    public void initHeapSort(ActionEvent event) {
        // close menu stage and open sort stage
        Stage stage = (Stage) heapBtn.getScene().getWindow();
        stage.hide();

        Stage primaryStage = new Stage();
        HeapPane myHeapPane = new HeapPane();
        myHeapPane.setPadding(new Insets(5, 5, 5, 5));
        primaryStage.setHeight(355);
        primaryStage.setWidth(665);

        Button Step_btn = new Button("Step");
        Button resetBtn = new Button("Reset");
        Button menuBtn = new Button("Menu");

        HBox myBox = new HBox(5);
        myBox.getChildren().addAll(Step_btn ,resetBtn, menuBtn);
        myBox.setAlignment(Pos.CENTER);

        BorderPane mainPane = new BorderPane();
        mainPane.setPadding(new Insets(5, 5, 5, 5));
        mainPane.setCenter(myHeapPane);
        mainPane.setBottom(myBox);
        mainPane.setStyle("-fx-background-color: #C382AE");

        Label status = new Label();
        mainPane.setTop(status);
        BorderPane.setAlignment(status, Pos.CENTER);
        Scene myScene = new Scene(mainPane, 400, 250);
        primaryStage.setTitle("Heap Sort");
        primaryStage.setScene(myScene);
        primaryStage.show();

        resetBtn.setOnAction(event1 -> {
            primaryStage.hide();
            initHeapSort(event1);
        });
        menuBtn.setOnAction(event1 -> {
            primaryStage.hide();
            stage.show();
        });
        initHeapArray();

        myHeapPane.draw();

        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (i >= 0)
                {
                    heapify(labels, myList.length, i);
                    i--;
                }

                if (i < 0){
                    if (j >= 0)
                    {
                        swap(0,j);
                        heapify(labels, j, 0);
                        j--;
                    }
                }

                myHeapPane.draw();
            }
        };
        Step_btn.setOnAction(handler);
    }
    private void initHeapArray()
    {
        for (int i = 0; i < myList.length; i++)
        {
            myList[i] = 0 + (int)(Math.random() * ((999 - 0) + 1));
        }
    }

    public class HeapPane extends Pane {
        private final int originX;
        private final int originY;
        private final int Width_Arr;
        private final int Height_Arr;

        HeapPane()
        {
            this.Height_Arr = 20;
            this.originX = 20;
            this.originY = 30;
            this.Width_Arr = 30;
        }

        public void draw()
        {
            this.getChildren().clear();
            int x = 10 + originX;
            int y = 10 + originY;

            // draw array
            Text[] myLabel = new Text[myList.length];
            Rectangle[] myRect = new Rectangle[myList.length];
            for (int i = 0; i < myList.length; i++)
            {
                myRect[i] = new Rectangle(x, y, Width_Arr, Height_Arr);
                myRect[i].setFill(Color.valueOf("#822B66"));
                myRect[i].setStroke(Color.WHITE);

                myLabel[i] = new Text(x + 5, y + 15, myList[i] + "");

                myLabel[i].setFill(Color.WHITE);

                this.getChildren().add(myRect[i]);

                this.getChildren().add(myLabel[i]);

                x += Width_Arr;
            }


            // draw init heap
            int heap_level = 1;
            int dummy1 = myList.length;
            while(dummy1/2 != 0)
            {
                heap_level ++;
                dummy1/=2;
            }

            System.out.println("heap_level: " + heap_level);

            // distance: distance between 2 node
            // init: distance in lv1 of the heap
            int distance = heap_level * 30 ;

            x = 700/2;
            y += 40;

            System.out.println("length: " + myList.length);
            for (int i = 0; i < myList.length; i++)
            {
                labels[i] = new Label(myList[i] + "");
                labels[i].setPrefHeight(25);
                labels[i].setPrefWidth(25);
                labels[i].setAlignment(Pos.CENTER);

                labels[i].setStyle
                        ("-fx-background-radius: 200; -fx-text-fill: #FFFFFF; -fx-background-color: #FF0000;");

            }

            // draw initial heap
            labels[0].setLayoutX(x);
            labels[0].setLayoutY(y);

            for (int i = 0; i < heap_level; i++)
            {
                for(int j = 0; j < expo(2, i); j++)
                {
                    if ( (expo(2,i) - 1 + j) < myList.length ) {
                        if ((2 * (expo(2,i) - 1 + j) + 2) < myList.length)
                            labels[2 * (expo(2, i) - 1 + j) + 2].setLayoutX(labels[expo(2, i) - 1 + j].getLayoutX() + distance);

                        if ((2 * (expo(2,i) - 1 + j) + 1) < myList.length)
                            labels[2 * (expo(2, i) - 1 + j) + 1].setLayoutX(labels[expo(2, i) - 1 + j].getLayoutX() - distance);


                        labels[expo(2,i) - 1 + j].setLayoutY(y);
                    }
                }

                y += 20;
                distance/=2;
            }

            for (int i = 0; i < myList.length; i++)
            {
                System.out.println(" node " + i + " - coord x:" + labels[i].getLayoutX() + " - y: "+ labels[i].getLayoutY());
            }

            this.getChildren().addAll(labels);

        }


        private int expo(int i, int j)
        {
            if (j == 0) return 1;
            int dummy1 = i;
            for (int dummy2 = 0; dummy2 < j - 1; dummy2++) dummy1 *= i;
            return dummy1;
        }

    }

    void heapify(Label[] labels, int size, int i)
    {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left < size )
        {
            if (Integer.parseInt(labels[left].getText() ) > Integer.parseInt(labels[largest].getText() ) )
                largest = left;
        }

        if (right < size )
        {
            if (Integer.parseInt(labels[right].getText() ) > Integer.parseInt(labels[largest].getText() ))
                largest = right;
        }

        if (largest != i)
        {
            swap(i, largest);
            heapify(labels, size, largest);
        }
    }

    public void swap(int i, int j)
    {
        double x_i = labels[i].getLayoutX();
        double y_i = labels[i].getLayoutY();
        double x_j = labels[j].getLayoutX();
        double y_j = labels[j].getLayoutY();

        Label tmp = labels[i];
        labels[i] = labels[j];
        labels[j] = tmp;


        labels[i].setLayoutX(x_i);
        labels[i].setLayoutY(y_i);

        labels[j].setLayoutX(x_j);
        labels[j].setLayoutY(y_j);

        int tmp2 = myList[i];
        myList[i] = myList[j];
        myList[j] = tmp2;

    }

    ArrayList[] myBucket = new ArrayList[10];
    private int digit_pos = 0;
    private int index = 0;
    private int bucketIndex = 0;

    @FXML
    public void initRadixSort(ActionEvent event) {
        Stage stage = (Stage) radixBtn.getScene().getWindow();
        stage.hide();

        Stage primaryStage = new Stage();
        SortPane SortPane = new SortPane();
        SortPane.setPadding(new Insets(5, 5, 5, 5));
        primaryStage.setHeight(355);
        primaryStage.setWidth(665);

        Button stepBtn = new Button("Step");
        Button resetBtn = new Button("Reset");
        Button menuBtn = new Button("Menu");

        HBox myBox = new HBox(5);
        myBox.getChildren().addAll(stepBtn, resetBtn, menuBtn);
        myBox.setAlignment(Pos.CENTER);

        BorderPane mainPane = new BorderPane();
        mainPane.setPadding(new Insets(5, 5, 5, 5));
        mainPane.setCenter(SortPane);
        mainPane.setBottom(myBox);
        mainPane.setStyle("-fx-background-color: #C382AE");

        Label status = new Label();
        mainPane.setTop(status);
        BorderPane.setAlignment(status, Pos.CENTER);
        Scene myScene = new Scene(mainPane, 400, 250);
        primaryStage.setTitle("Radix Sort");
        primaryStage.setScene(myScene);
        primaryStage.show();

        initArray();

        createBuckets();

        SortPane.redraw();

        stepBtn.setOnAction(new StepHandler(SortPane, status));
        resetBtn.setOnAction(new ResetHandler(status, SortPane));
        menuBtn.setOnAction(event1 -> {
            primaryStage.hide();
            stage.show();
        });
    }

    private void createBuckets() {
        for (int i = 0; i < myBucket.length; i++) {
            myBucket[i] = new ArrayList<>();
        }
    }

    private void initArray() {
        for (int i = 0; i < myList.length; i++) {
            myList[i] = 1 + (int) (Math.random() * 1000);
        }
    }

    // each step of radix sort done when the button is pressed
    private boolean eachStep() {
        if (index < myList.length) {
            bucketIndex = returnKey(myList[index], digit_pos);
            myBucket[bucketIndex].add(myList[index]);
            index++;
            return false;
        } else if (digit_pos < 2) {
            bucketToList();
            cleanBucket();
            index = 0;
            digit_pos++;
            return false;
        }

        bucketToList();
        cleanBucket();
        return true;
    }

    // return the key for storing element
    private int returnKey(int number, int digit_pos) {
        int result = 1;
        for (int i = 0; i < digit_pos; i++) result *= 10;
        return (number / result) % 10;
    }

    // delete all values in all buckets
    private void cleanBucket() {
        for (ArrayList<Integer> bucket1 : myBucket) {
            bucket1.clear();
        }
    }

    // convert and store values from bucket to list
    private void bucketToList() {
        int indx = 0;
        for (ArrayList<Integer> bucket1 : myBucket) {
            for (int loop_j = 0; loop_j < bucket1.size(); loop_j++) {
                myList[indx++] = bucket1.get(loop_j);
            }
        }
    }

    // reset buckets and reinitialize array
    private void ResetAll() {
        cleanBucket();
        index = 0;
        digit_pos = 0;
        initArray();
    }

    public class ResetHandler implements EventHandler<ActionEvent> {
        private final SortPane SortPane;
        private final Label status;

        public ResetHandler
                (Label status, SortPane SortPane) {
            this.SortPane = SortPane;
            this.status = status;
        }

        @Override
        public void handle(ActionEvent e) {
            ResetAll();
            status.setText("");
            SortPane.redraw();
        }
    }


    public class StepHandler implements EventHandler<ActionEvent> {
        private final SortPane SortPane;
        private final Label status;

        public StepHandler
                (SortPane SortPane, Label status) {
            this.SortPane = SortPane;
            this.status = status;
        }

        public void handle(ActionEvent e) {
            if (eachStep()) {
                SortPane.redraw();
                status.setText("SORTED !!!!");
                status.setFont(new Font("Arial", 30));
            } else {
                SortPane.redraw();
            }
        }
    }

    public class SortPane extends Pane {
        private final int originX;
        private final int originY;
        private final int Width_Arr;
        private final int Height_Arr;

        SortPane() {
            this.Height_Arr = 20;
            this.originX = 20;
            this.originY = 30;
            this.Width_Arr = 30;
        }

        // takes values from buckets and arrays and redraws
        // the GUI whenever the button is pressed
        public void redraw() {
            this.getChildren().clear();
            int x = 10 + originX;
            int y = 10 + originY;

            for (int i = 0; i < myList.length; i++) {
                Rectangle myRect = new Rectangle(x, y, Width_Arr, Height_Arr);
                myRect.setFill(Color.valueOf("#822B66"));
                myRect.setStroke(Color.WHITE);
                this.getChildren().add(myRect);
                Text newLabel = new Text(x + 5, y + 15, myList[i] + "");

                this.getChildren().add(newLabel);

                if (i == index - 1) {
                    newLabel.setFill(Color.RED);
                } else {
                    newLabel.setFill(Color.WHITE);
                }
                x += Width_Arr;
            }

            x = 10 + originX;
            y += 40;
            int bucket_width = 40;
            int bucket_height = 130;
            int bucket_distance = 60;

            for (int i = 0; i < myBucket.length; i++) {
                Rectangle myRect = new Rectangle(x + 10, y, bucket_width, bucket_height);
                myRect.setFill(Color.WHITE);
                myRect.setStroke(Color.BLACK);
                this.getChildren().add(myRect);

                for (int j = 0; j < myBucket[i].size(); j++) {
                    this.getChildren().add(new Text
                            (x + 10 + 5, y + (j + 1) * 20, myBucket[i].get(j) + ""));
                }

                if (i == bucketIndex && myBucket[i].size() > 0) {
                    Text newLabel_2 = new Text
                            (x + 10 + 5, y + myBucket[i].size() * 20,
                                    myBucket[i].get(myBucket[i].size() - 1) + "");
                    newLabel_2.setFill(Color.RED);
                    this.getChildren().add(newLabel_2);
                }

                Text newLabel_3 = new Text
                        (x + 5, y + bucket_height + 25, "Bucket" + " " + i);
                getChildren().add(newLabel_3);
                x += bucket_distance;
            }
        }
    }

}
