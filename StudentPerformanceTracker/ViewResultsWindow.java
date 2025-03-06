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
import java.util.List;

public class ViewResultsWindow {

    public ViewResultsWindow(List<StudentRecord> records) {
        JFrame frame = new JFrame("View Results");
        frame.setSize(500, 300);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Subject", "Total Marks", "Grade", "GPA"});
        JTable table = new JTable(model);

        for (StudentRecord record : records) {
            int totalMarks = record.getTotalMarks();
            String grade = calculateGrade(totalMarks);
            double gpa = calculateGPA(totalMarks);
            model.addRow(new Object[]{record.subject, totalMarks, grade, gpa});
        }

        frame.add(new JScrollPane(table));
        frame.setVisible(true);
    }

    private String calculateGrade(int marks) {
        if (marks >= 80) {
            return "A+";
        }
        if (marks >= 75) {
            return "A";
        }
        if (marks >= 70) {
            return "A-";
        }
        if (marks >= 65) {
            return "B+";
        }
        if (marks >= 60) {
            return "B";
        }
        if (marks >= 55) {
            return "B-";
        }
        if (marks >= 50) {
            return "C+";
        }
        if (marks >= 45) {
            return "C";
        }
        if (marks >= 40) {
            return "D";
        }
        return "F";
    }

    private double calculateGPA(int marks) {
        if (marks >= 80) {
            return 4.0;
        }
        if (marks >= 75) {
            return 3.75;
        }
        if (marks >= 70) {
            return 3.5;
        }
        if (marks >= 65) {
            return 3.25;
        }
        if (marks >= 60) {
            return 3.0;
        }
        if (marks >= 55) {
            return 2.75;
        }
        if (marks >= 50) {
            return 2.5;
        }
        if (marks >= 45) {
            return 2.25;
        }
        if (marks >= 40) {
            return 2.0;
        }
        return 0.0;
    }
}
