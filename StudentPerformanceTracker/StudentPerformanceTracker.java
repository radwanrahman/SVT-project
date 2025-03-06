/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentPerformanceTracker;

/**
 *
 * @author rayhan
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StudentPerformanceTracker {
    private JFrame mainFrame;
    private JTable table;
    private DefaultTableModel model;
    private JTextField subjectField, midField, classTestField, assignmentField, finalField, attendanceField;
    private List<StudentRecord> records = new ArrayList<>();

    public StudentPerformanceTracker() {
        mainFrame = new JFrame("Student Performance Tracker");
        mainFrame.setSize(800, 500);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel inputPanel = new JPanel(new GridLayout(2, 6, 5, 5));
        subjectField = new JTextField();
        midField = new JTextField();
        classTestField = new JTextField();
        assignmentField = new JTextField();
        finalField = new JTextField();
        attendanceField = new JTextField();

        inputPanel.add(new JLabel("Subject"));
        inputPanel.add(new JLabel("Mid"));
        inputPanel.add(new JLabel("Class Test"));
        inputPanel.add(new JLabel("Assignment"));
        inputPanel.add(new JLabel("Final"));
        inputPanel.add(new JLabel("Attendance"));

        inputPanel.add(subjectField);
        inputPanel.add(midField);
        inputPanel.add(classTestField);
        inputPanel.add(assignmentField);
        inputPanel.add(finalField);
        inputPanel.add(attendanceField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> addStudentRecord());

        JButton viewResultsButton = new JButton("View Results");
        viewResultsButton.addActionListener(e -> new ViewResultsWindow(records));

        JButton studentPerformanceButton = new JButton("Student Performance");
        studentPerformanceButton.addActionListener(e -> new StudentPerformanceWindow(records));

        JButton performanceAnalysisButton = new JButton("Performance Analysis");
        performanceAnalysisButton.addActionListener(e -> new PerformanceAnalysisWindow(records));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        buttonPanel.add(viewResultsButton);
        buttonPanel.add(studentPerformanceButton);
        buttonPanel.add(performanceAnalysisButton);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Subject", "Mid", "Class Test", "Assignment", "Final", "Attendance"});
        table = new JTable(model);

        mainFrame.add(inputPanel, BorderLayout.NORTH);
        mainFrame.add(new JScrollPane(table), BorderLayout.CENTER);
        mainFrame.add(buttonPanel, BorderLayout.SOUTH);

        mainFrame.setVisible(true);
    }

    private void addStudentRecord() {
        try {
            String subject = subjectField.getText();
            int mid = Integer.parseInt(midField.getText());
            int classTest = Integer.parseInt(classTestField.getText());
            int assignment = Integer.parseInt(assignmentField.getText());
            int finalExam = Integer.parseInt(finalField.getText());
            int attendance = Integer.parseInt(attendanceField.getText());

            StudentRecord record = new StudentRecord(subject, mid, classTest, assignment, finalExam, attendance);
            records.add(record);
            model.addRow(new Object[]{subject, mid, classTest, assignment, finalExam, attendance});

            subjectField.setText("");
            midField.setText("");
            classTestField.setText("");
            assignmentField.setText("");
            finalField.setText("");
            attendanceField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(mainFrame, "Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        new StudentPerformanceTracker();
    }
}
//