/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dsa.studio;

/**
 *
 * @author Ahsan Khalid
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The home screen. Shows the app title and one button per lab.
 * Clicking a button opens that lab as its own window -- same pattern
 * as how the bank project opens Frame2 / SignupPage / LoanFrame.
 */
public class MainMenu extends JFrame implements ActionListener {

    private JLabel titleLabel, subtitleLabel;
    private JButton arrayLabBtn, linkedListLabBtn, stackLabBtn, queueLabBtn;
    private JButton treeLabBtn, graphLabBtn, sortingLabBtn, searchingLabBtn;

    public MainMenu() {
        setTitle("DSA Studio");
        setSize(420, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Theme.BG_MAIN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponents();
    }

    private void addComponents() {
        titleLabel = new JLabel("DSA Studio");
        titleLabel.setFont(Theme.FONT_TITLE);
        titleLabel.setForeground(Theme.TEXT_PRIMARY);
        titleLabel.setBounds(20, 20, 300, 35);
        this.add(titleLabel);

        subtitleLabel = new JLabel("Data Structures & Algorithms Lab");
        subtitleLabel.setFont(Theme.FONT_SMALL);
        subtitleLabel.setForeground(Theme.TEXT_SECONDARY);
        subtitleLabel.setBounds(20, 55, 300, 20);
        this.add(subtitleLabel);

        int y = 100;
        int gap = 55;

        arrayLabBtn = makeButton("Array Lab", y);
        y = y + gap;
        linkedListLabBtn = makeButton("Linked List Lab (coming soon)", y);
        y = y + gap;
        stackLabBtn = makeButton("Stack Lab (coming soon)", y);
        y = y + gap;
        queueLabBtn = makeButton("Queue Lab (coming soon)", y);
        y = y + gap;
        treeLabBtn = makeButton("Tree Lab (coming soon)", y);
        y = y + gap;
        graphLabBtn = makeButton("Graph Lab (coming soon)", y);
        y = y + gap;
        sortingLabBtn = makeButton("Sorting Lab (coming soon)", y);
        y = y + gap;
        searchingLabBtn = makeButton("Searching Lab (coming soon)", y);
    }

    private JButton makeButton(String text, int y) {
        JButton btn = new JButton(text);
        btn.setBounds(20, y, 360, 40);
        btn.setFont(Theme.FONT_BODY);
        btn.setBackground(Theme.BG_CARD);
        btn.setForeground(Theme.TEXT_PRIMARY);
        btn.setFocusPainted(false);
        btn.addActionListener(this);
        this.add(btn);
        return btn;
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

      if (cmd.equals("Array Lab"))
      {
            ArrayLabFrame arrayLab = new ArrayLabFrame();
            arrayLab.setVisible(true);
        } else if (cmd.equals("Linked List Lab (coming soon)")) 
        {
            LinkedListLabFrame listLab = new LinkedListLabFrame();
            listLab.setVisible(true);
        } else if (cmd.equals("Stack Lab (coming soon)")) {
            JOptionPane.showMessageDialog(this, "Stack Lab is not built yet -- coming in the next phase.");
        } 
        else {}
}
}