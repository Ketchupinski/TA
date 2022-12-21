package com.university.ta;

import com.university.ta.sorting.HeapSort;
import com.university.ta.sorting.MergeSort;
import com.university.ta.sorting.ShellSort;
import com.university.ta.student.Student;
import com.university.ta.student.StudentManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Comparator;

public class MainController {
    @FXML
    public RadioButton programmingRadio;
    @FXML
    public RadioButton compGraphRadio;
    @FXML
    public RadioButton dataBasesRadio;
    @FXML
    public RadioButton operSysRadio;
    @FXML
    public TextField bestStudCountField;
    @FXML
    public TextField avgMarkField;
    @FXML
    public RadioButton allRadio;
    @FXML
    public RadioButton webRadio;
    @FXML
    public TextField iterField;
    @FXML
    public TextField timeField;
    @FXML
    public TableView<Student> studentsTable;
    @FXML
    public TableColumn<Student, String> surnameCol;
    @FXML
    public TableColumn<Student, Integer> progCol;
    @FXML
    public TableColumn<Student, Integer> graphCol;
    @FXML
    public TableColumn<Student, Integer> dbCol;
    @FXML
    public TableColumn<Student, Integer> operSysCol;
    @FXML
    public TableColumn<Student, Integer> webCol;
    @FXML
    public BarChart<String, Double> studentsBarChart;
    @FXML
    public CategoryAxis surnameChart;
    @FXML
    public NumberAxis markChart;

    @FXML
    XYChart.Series<String, Double> series;

    private Student[] students;

    @FXML
    public void initialize() {
        ToggleGroup group = new ToggleGroup();
        programmingRadio.setToggleGroup(group);
        compGraphRadio.setToggleGroup(group);
        dataBasesRadio.setToggleGroup(group);
        operSysRadio.setToggleGroup(group);
        allRadio.setToggleGroup(group);
        webRadio.setToggleGroup(group);

        programmingRadio.setSelected(true);

        bestStudCountField.setEditable(false);
        avgMarkField.setEditable(false);
        iterField.setEditable(false);
        timeField.setEditable(false);

        iterField.setText("0");
        timeField.setText("0");
        bestStudCountField.setText("0");
        avgMarkField.setText("0");

        surnameCol.setCellValueFactory(new PropertyValueFactory<>("surname"));
        progCol.setCellValueFactory(new PropertyValueFactory<>("markPrograming"));
        graphCol.setCellValueFactory(new PropertyValueFactory<>("markComputerGraphics"));
        dbCol.setCellValueFactory(new PropertyValueFactory<>("markDataBases"));
        operSysCol.setCellValueFactory(new PropertyValueFactory<>("markOperatingSystems"));
        webCol.setCellValueFactory(new PropertyValueFactory<>("markWeb"));

        TableView.TableViewSelectionModel<Student> selectionModel = studentsTable.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        studentsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        students = StudentManager.createStudents();
        studentsTable.getItems().addAll(students);

        Student[] sortedStudents = students.clone();
        HeapSort.sort(sortedStudents, Comparator.comparing(Student::getAverageMark).thenComparing(Student::getSurname));
        series = new XYChart.Series<>();
        for (Student student : sortedStudents) {
            series.getData().add(new XYChart.Data<>(student.getSurname(), student.getAverageMark()));
        }
        studentsBarChart.getData().add(series);
    }

    @FXML
    public void onHeapSortButton(ActionEvent actionEvent) {
        long startTime = System.nanoTime();
        HeapSort.sort(students, getStudentComparator());
        long time = System.nanoTime() - startTime;
        timeField.setText(String.valueOf(time));
        iterField.setText(String.valueOf(HeapSort.getIterations()));
        studentsTable.getItems().clear();
        studentsTable.getItems().addAll(students);
        getAllStudentsAverageMark();
        getCountOfBestStudents();
    }

    @FXML
    public void onMergeSortButton(ActionEvent actionEvent) {
        MergeSort.resetIterations();
        long startTime = System.nanoTime();
        MergeSort.sortStudents(students, getStudentComparator());
        long time = System.nanoTime() - startTime;
        timeField.setText(String.valueOf(time));
        iterField.setText(String.valueOf(MergeSort.getIterations()));
        studentsTable.getItems().clear();
        studentsTable.getItems().addAll(students);
        getAllStudentsAverageMark();
        getCountOfBestStudents();
    }

    @FXML
    public void onShellSortButton(ActionEvent actionEvent) {
        long startTime = System.nanoTime();
        ShellSort.sortStudents(students, getStudentComparator());
        long time = System.nanoTime() - startTime;
        timeField.setText(String.valueOf(time));
        iterField.setText(String.valueOf(ShellSort.getIterations()));
        studentsTable.getItems().clear();
        studentsTable.getItems().addAll(students);
        getAllStudentsAverageMark();
        getCountOfBestStudents();
    }

    @FXML
    public void onResetButton(ActionEvent actionEvent) {
        students = StudentManager.createStudents();
        studentsTable.getItems().clear();
        studentsTable.getItems().addAll(students);
        iterField.setText("0");
        timeField.setText("0");
        bestStudCountField.setText("0");
        avgMarkField.setText("0");
    }

    private Comparator<Student> getStudentComparator() {
        if (programmingRadio.isSelected()) {
            return Comparator.comparingInt(Student::getMarkPrograming).thenComparing(Student::getSurname);
        } else if (compGraphRadio.isSelected()) {
            return Comparator.comparingInt(Student::getMarkComputerGraphics).thenComparing(Student::getSurname);
        } else if (dataBasesRadio.isSelected()) {
            return Comparator.comparingInt(Student::getMarkDataBases).thenComparing(Student::getSurname);
        } else if (operSysRadio.isSelected()) {
            return Comparator.comparingInt(Student::getMarkOperatingSystems).thenComparing(Student::getSurname);
        } else if (webRadio.isSelected()) {
            return Comparator.comparingInt(Student::getMarkWeb).thenComparing(Student::getSurname);
        } else {
            return Comparator.comparingDouble(Student::getAverageMark).thenComparing(Student::getSurname);
        }
    }

    @FXML
    public void onAnimatedTableSortingClick(ActionEvent actionEvent) {
        Comparator<Student> comparator = Comparator.comparingDouble(Student::getAverageMark).thenComparing(Student::getSurname);
        new Thread(() -> {
            int step = students.length / 2;
            while (step > 0) {
                for (int i = 0; i < (students.length - step); i++) {
                    int j = i;
                    while (j >= 0 && comparator.compare(students[j], students[j + step]) > 0) {
                        Student temp = students[j];
                        students[j] = students[j + step];
                        students[j + step] = temp;
                        j--;
                        int finalJ = j; // for lambda
                        Platform.runLater(() -> {
                            studentsTable.getItems().clear();
                            studentsTable.getItems().addAll(students);
                            studentsTable.getSelectionModel().select(finalJ + 1);
                        });
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                step = step / 2;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                studentsTable.getItems().clear();
                studentsTable.getItems().addAll(students);
            }
        }).start();
    }

    private void getCountOfBestStudents() {
        int count = 0;
        for (Student student : students) {
            if (programmingRadio.isSelected()){
                if (student.getMarkPrograming() == 5) {
                    count++;
                }
            } else if (compGraphRadio.isSelected()){
                if (student.getMarkComputerGraphics() == 5) {
                    count++;
                }
            } else if (dataBasesRadio.isSelected()){
                if (student.getMarkDataBases() == 5) {
                    count++;
                }
            } else if (operSysRadio.isSelected()){
                if (student.getMarkOperatingSystems() == 5) {
                    count++;
                }
            } else if (webRadio.isSelected()){
                if (student.getMarkWeb() == 5) {
                    count++;
                }
            } else {
                if (student.getAverageMark() == 5) {
                    count++;
                }
            }
        }
        bestStudCountField.setText(String.valueOf(count));
    }

    private void getAllStudentsAverageMark() {
        double sum = 0;
        for (Student student : students) {
            if (programmingRadio.isSelected()){
                sum += student.getMarkPrograming();
            } else if (compGraphRadio.isSelected()){
                sum += student.getMarkComputerGraphics();
            } else if (dataBasesRadio.isSelected()){
                sum += student.getMarkDataBases();
            } else if (operSysRadio.isSelected()){
                sum += student.getMarkOperatingSystems();
            } else if (webRadio.isSelected()){
                sum += student.getMarkWeb();
            } else {
                sum += student.getAverageMark();
            }
        }
        avgMarkField.setText(String.valueOf((int) sum / students.length));
    }
}