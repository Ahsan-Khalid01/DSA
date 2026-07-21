/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package studentgradetracker;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Ahsan Khalid
 */
public class GradeTrackerGUI extends JFrame{
 private GradeManager manager;
 
    private JTextField nameField;
    private JTextField gradesField;
    private JTable studentTable;
    private DefaultTableModel tableModel;
    private JLabel classAverageLabel;
    private JLabel topStudentLabel;
    private JLabel lowestStudentLabel;
 
    public GradeTrackerGUI() 
    {
        manager = new GradeManager();
        buildUI();
    }
 
    private void buildUI() 
    {
        setTitle("Student Grade Tracker");
        setSize(750, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(245, 247, 250));
 
        // ---- Top Panel: Input ----
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(new Color(255, 255, 255));
        inputPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(100, 149, 237), 1),
            "Add Student", 0, 0,
            new Font("SansSerif", Font.BOLD, 13), new Color(100, 149, 237)
        ));
 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 10, 6, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
 
        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("Student Name:"), gbc);
        gbc.gridx = 1;
        nameField = new JTextField(14);
        inputPanel.add(nameField, gbc);
 
        gbc.gridx = 10;
        inputPanel.add(new JLabel("Grades (comma separated):"), gbc);
        gbc.gridx = 3;
        gradesField = new JTextField(13);
        inputPanel.add(gradesField, gbc);
 
        gbc.gridx = 4;
        JButton addButton = makeButton("Add Student", new Color(100, 149, 237));
        addButton.addActionListener(e -> addStudent());
        inputPanel.add(addButton, gbc);
 
        gbc.gridx = 5;
        JButton removeButton = makeButton("Remove", new Color(220, 80, 80));
        removeButton.addActionListener(e -> removeSelectedStudent());
        inputPanel.add(removeButton, gbc);
 
        add(inputPanel, BorderLayout.NORTH);
 
        // ---- Center: Table ----
        String[] columns = {"Name", "Average", "Highest", "Lowest", "Grade"};
        tableModel = new DefaultTableModel(columns, 0) {
            public boolean isCellEditable(int row, int col) { return false; }
        };
        studentTable = new JTable(tableModel);
        studentTable.setRowHeight(26);
        studentTable.setFont(new Font("SansSerif", Font.PLAIN, 13));
        studentTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        studentTable.getTableHeader().setBackground(new Color(100, 149, 237));
        studentTable.getTableHeader().setForeground(Color.WHITE);
        studentTable.setSelectionBackground(new Color(210, 225, 255));
 
        JScrollPane scrollPane = new JScrollPane(studentTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        add(scrollPane, BorderLayout.CENTER);
 
        // ---- Bottom: Summary ----
        JPanel summaryPanel = new JPanel(new GridLayout(1, 3, 10, 5));
        summaryPanel.setBackground(new Color(245, 247, 250));
        summaryPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
 
        classAverageLabel = makeSummaryLabel("Class Average: —");
        topStudentLabel   = makeSummaryLabel("Top Student: —");
        lowestStudentLabel = makeSummaryLabel("Needs Improvement: —");
 
        summaryPanel.add(classAverageLabel);
        summaryPanel.add(topStudentLabel);
        summaryPanel.add(lowestStudentLabel);
 
        add(summaryPanel, BorderLayout.SOUTH);
 
        setVisible(true);
    }
 
    private void addStudent() {
        String name = nameField.getText().trim();
        String gradesText = gradesField.getText().trim();
 
        if (name.isEmpty() || gradesText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in both name and grades.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
 
        if (manager.findStudent(name) != null) {
            JOptionPane.showMessageDialog(this, "Student '" + name + "' already exists.", "Duplicate", JOptionPane.WARNING_MESSAGE);
            return;
        }
 
        String[] parts = gradesText.split(",");
        double[] grades = new double[parts.length];
        try {
            for (int i = 0; i < parts.length; i++) {
                grades[i] = Double.parseDouble(parts[i].trim());
                if (grades[i] < 0 || grades[i] > 100) throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Grades must be numbers between 0 and 100.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
 
        Student student = new Student(name, grades);
        manager.addStudent(student);
 
        tableModel.addRow(new Object[]{
            student.getName(),
            String.format("%.2f", student.getAverage()),
            String.format("%.2f", student.getHighest()),
            String.format("%.2f", student.getLowest()),
            student.getLetterGrade()
        });
 
        nameField.setText("");
        gradesField.setText("");
        updateSummary();
    }
 
    private void removeSelectedStudent() {
        int selectedRow = studentTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a student to remove.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = (String) tableModel.getValueAt(selectedRow, 0);
        manager.removeStudent(name);
        tableModel.removeRow(selectedRow);
        updateSummary();
    }
 
    private void updateSummary() {
        if (manager.isEmpty()) {
            classAverageLabel.setText("Class Average: —");
            topStudentLabel.setText("Top Student: —");
            lowestStudentLabel.setText("Needs Improvement: —");
            return;
        }
        classAverageLabel.setText(String.format("Class Average: %.2f", manager.getClassAverage()));
        topStudentLabel.setText("Top Student: " + manager.getTopStudent().getName());
        lowestStudentLabel.setText("Needs Improvement: " + manager.getLowestStudent().getName());
    }
 
    private JButton makeButton(String text, Color color) {
        JButton btn = new JButton(text);
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("SansSerif", Font.BOLD, 12));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setBorder(BorderFactory.createEmptyBorder(6, 12, 6, 12));
        return btn;
    }
 
    private JLabel makeSummaryLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 13));
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        label.setBorder(BorderFactory.createLineBorder(new Color(200, 210, 230)));
        label.setForeground(new Color(50, 60, 90));
        return label;
    }
}
