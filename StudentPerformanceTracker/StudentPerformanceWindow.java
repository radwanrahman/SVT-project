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

public class StudentPerformanceWindow {

    public StudentPerformanceWindow(List<StudentRecord> records) {
        JFrame frame = new JFrame("Student Performance");
        frame.setSize(600, 400);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        StringBuilder performanceSummary = new StringBuilder();
        for (StudentRecord record : records) {
            double cgpa = record.getCGPA();
            String performanceFeedback = getPerformanceFeedback(cgpa);
            performanceSummary.append("Subject: ").append(record.subject)
                    .append("\nTotal Marks: ").append(record.getTotalMarks())
                    .append("\nCGPA: ").append(cgpa)
                    .append("\nPerformance: ").append(performanceFeedback)
                    .append("\n\n");
        }

        textArea.setText(performanceSummary.toString());
        frame.add(new JScrollPane(textArea));
        frame.setVisible(true);
    }

    private String getPerformanceFeedback(double cgpa) {
        if (cgpa > 3.0) {
            return "Good";
        } else if (cgpa >= 2.0) {
            return "Needs Improvement";
        } else {
            return "Poor";
        }
    }
}
