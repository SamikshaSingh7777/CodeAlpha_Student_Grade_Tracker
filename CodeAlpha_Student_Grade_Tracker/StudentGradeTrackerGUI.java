import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class StudentGradeTrackerGUI {

    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<Integer> marks = new ArrayList<>();

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Grade Tracker");
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nameLabel = new JLabel("Student Name:");
        JTextField nameField = new JTextField(15);

        JLabel marksLabel = new JLabel("Marks:");
        JTextField marksField = new JTextField(5);

        JButton addButton = new JButton("Add Student");
        JButton reportButton = new JButton("Show Report");

        JTextArea resultArea = new JTextArea(12, 30);
        resultArea.setEditable(false);

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(marksLabel);
        frame.add(marksField);
        frame.add(addButton);
        frame.add(reportButton);
        frame.add(new JScrollPane(resultArea));

        // Add Student Button
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            int mark = Integer.parseInt(marksField.getText());

            names.add(name);
            marks.add(mark);

            nameField.setText("");
            marksField.setText("");

            JOptionPane.showMessageDialog(frame, "Student Added!");
        });

        // Show Report Button
        reportButton.addActionListener(e -> {
            int total = 0;
            int highest = Integer.MIN_VALUE;
            int lowest = Integer.MAX_VALUE;

            resultArea.setText("---- Student Report ----\n");

            for (int i = 0; i < marks.size(); i++) {
                resultArea.append(names.get(i) + " : " + marks.get(i) + "\n");

                total += marks.get(i);
                highest = Math.max(highest, marks.get(i));
                lowest = Math.min(lowest, marks.get(i));
            }

            double average = marks.size() > 0 ? (double) total / marks.size() : 0;

            resultArea.append("\nAverage: " + average);
            resultArea.append("\nHighest: " + highest);
            resultArea.append("\nLowest: " + lowest);
        });

        frame.setVisible(true);
    }
}