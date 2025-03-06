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
import java.util.List;

public class PerformanceAnalysisWindow {

    public PerformanceAnalysisWindow(List<StudentRecord> records) {
        JFrame frame = new JFrame("Performance Analysis");
        frame.setSize(600, 400);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        int totalStudents = records.size();
        int passed = 0, failed = 0;
        double totalGPA = 0;
        StringBuilder tips = new StringBuilder();

        // Variables to find highest and lowest marks
        int highestMarks = Integer.MIN_VALUE;
        int lowestMarks = Integer.MAX_VALUE;
        String highestSubject = "", lowestSubject = "";

        for (StudentRecord record : records) {
            double gpa = calculateGPA(record.getTotalMarks());
            totalGPA += gpa;

            // Update highest and lowest marks
            int totalMarks = record.getTotalMarks();
            if (totalMarks > highestMarks) {
                highestMarks = totalMarks;
                highestSubject = record.subject;
            }
            if (totalMarks < lowestMarks) {
                lowestMarks = totalMarks;
                lowestSubject = record.subject;
            }

            if (gpa >= 2.0) {
                passed++;
            } else {
                failed++;
            }

            // Tips for improvement based on marks
            if (totalMarks < 60) {
                tips.append("Focus more on the subject: ").append(record.subject).append("\n");
            }
        }

        double averageGPA = totalGPA / totalStudents;
        textArea.setText("Total Students: " + totalStudents
                + "\nPassed: " + passed
                + "\nFailed: " + failed
                + "\nAverage GPA: " + averageGPA
                + "\n\nHighest Marks: " + highestMarks + " in " + highestSubject
                + "\nLowest Marks: " + lowestMarks + " in " + lowestSubject
                + "\n\nImprovement Tips:\n" + tips.toString());

        frame.add(new JScrollPane(textArea));
        frame.setVisible(true);
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
