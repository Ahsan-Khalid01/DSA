package dsa.studio;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The very first window shown when the app starts. Gives the project
 * a proper introduction before dropping the user into the lab menu.
 */
public class IntroFrame extends JFrame implements ActionListener {

    private JPanel headerPanel;
    private JLabel headerTitle, headerSubtitle;
    private JTextArea descriptionArea;
    private JButton enterBtn;

    public IntroFrame() {
        setTitle("DSA Studio");
        setSize(520, 480);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Theme.BG_MAIN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponents();
    }

    private void addComponents() {
        headerPanel = new JPanel();
        headerPanel.setLayout(null);
        headerPanel.setBounds(0, 0, 520, 150);
        headerPanel.setBackground(Theme.ACCENT);
        this.add(headerPanel);

        headerTitle = new JLabel("DSA Studio");
        headerTitle.setFont(new Font("Segoe UI", Font.BOLD, 32));
        headerTitle.setForeground(java.awt.Color.BLACK);
        headerTitle.setBounds(30, 40, 400, 45);
        headerPanel.add(headerTitle);

        headerSubtitle = new JLabel("Data Structures & Algorithms Laboratory");
        headerSubtitle.setFont(Theme.FONT_BODY);
        headerSubtitle.setForeground(java.awt.Color.BLACK);
        headerSubtitle.setBounds(30, 90, 460, 25);
        headerPanel.add(headerSubtitle);

        descriptionArea = new JTextArea();
        descriptionArea.setText(
            "This application is a hands-on lab for studying core Data Structures " +
            "and Algorithms taught in the Data Structures course.\n\n" +
            "Every operation you run -- inserting a value, searching, sorting, " +
            "finding a maximum, and more -- is animated step by step, so you can " +
            "see exactly how the underlying algorithm works instead of just " +
            "reading about it.\n\n" +
            "Click Enter Studio below to open the lab menu.");
        descriptionArea.setBounds(30, 175, 460, 190);
        descriptionArea.setFont(Theme.FONT_BODY);
        descriptionArea.setForeground(Theme.TEXT_PRIMARY);
        descriptionArea.setBackground(Theme.BG_MAIN);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        descriptionArea.setFocusable(false);
        this.add(descriptionArea);

        enterBtn = new JButton("Enter Studio");
        enterBtn.setBounds(30, 375, 180, 40);
        enterBtn.setFont(Theme.FONT_BODY);
        enterBtn.setBackground(Theme.ACCENT);
        enterBtn.setForeground(java.awt.Color.BLACK);
        enterBtn.setFocusPainted(false);
        enterBtn.addActionListener(this);
        this.add(enterBtn);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals("Enter Studio")) {
            MainMenu menu = new MainMenu();
            menu.setVisible(true);
            this.dispose();
        }
    }
}