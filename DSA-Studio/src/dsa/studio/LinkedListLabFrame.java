package dsa.studio;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

/**
 * The Linked List Lab window. Same animation pattern as ArrayLabFrame:
 * every button asks DSLinkedList for a list of AnimationStep frames,
 * then a Timer plays them back one at a time.
 */
public class LinkedListLabFrame extends JFrame implements ActionListener {

    private DSLinkedList dsList;
    private ListBoxPanel boxPanel;

    private JLabel titleLabel, statusLabel, infoLabel;
    private JLabel valueLabel, positionLabel;
    private JTextField valueField, positionField;

    private JButton insertHeadBtn, insertTailBtn, insertPosBtn;
    private JButton deleteBtn, searchBtn, reverseBtn, backBtn;

    private Timer timer;
    private List<AnimationStep> frameQueue;
    private int animationDelay = 500;

    public LinkedListLabFrame() {
        dsList = new DSLinkedList();
        frameQueue = new LinkedList<AnimationStep>();

        setTitle("DSA Studio - Linked List Lab");
        setSize(820, 480);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Theme.BG_MAIN);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addComponents();

        boxPanel.displayStep(AnimationStep.idle(new int[0], "Ready. List is empty. Choose an operation below."));
        updateInfoLabel();
    }

    private void addComponents() {
        titleLabel = new JLabel("Linked List Lab (Singly Linked)");
        titleLabel.setFont(Theme.FONT_TITLE);
        titleLabel.setForeground(Theme.TEXT_PRIMARY);
        titleLabel.setBounds(20, 15, 500, 35);
        this.add(titleLabel);

        statusLabel = new JLabel("Ready.");
        statusLabel.setFont(Theme.FONT_BODY);
        statusLabel.setForeground(Theme.TEXT_PRIMARY);
        statusLabel.setBounds(20, 55, 760, 25);
        this.add(statusLabel);

        boxPanel = new ListBoxPanel(10);
        boxPanel.setBounds(20, 90, 780, 90);
        boxPanel.setBackground(Theme.BG_PANEL);
        this.add(boxPanel);

        infoLabel = new JLabel("Size: 0");
        infoLabel.setFont(Theme.FONT_SMALL);
        infoLabel.setForeground(Theme.TEXT_SECONDARY);
        infoLabel.setBounds(20, 190, 300, 20);
        this.add(infoLabel);

        addLegend();

        valueLabel = new JLabel("Value:");
        valueLabel.setForeground(Theme.TEXT_SECONDARY);
        valueLabel.setBounds(20, 225, 60, 25);
        this.add(valueLabel);

        valueField = new JTextField();
        valueField.setBounds(80, 225, 70, 25);
        this.add(valueField);

        positionLabel = new JLabel("Position:");
        positionLabel.setForeground(Theme.TEXT_SECONDARY);
        positionLabel.setBounds(170, 225, 70, 25);
        this.add(positionLabel);

        positionField = new JTextField();
        positionField.setBounds(240, 225, 70, 25);
        this.add(positionField);

        int y1 = 265;
        insertHeadBtn = makeButton("Insert at Head", 20, y1);
        insertTailBtn = makeButton("Insert at Tail", 160, y1);
        insertPosBtn = makeButton("Insert at Position", 300, y1);

        int y2 = 310;
        deleteBtn = makeButton("Delete at Position", 20, y2);
        searchBtn = makeButton("Search", 180, y2);
        reverseBtn = makeButton("Reverse", 300, y2);

        backBtn = makeButton("< Back", 20, 360);
    }

    private void addLegend() {
        JPanel legendPanel = new JPanel();
        legendPanel.setLayout(null);
        legendPanel.setBounds(340, 190, 440, 25);
        legendPanel.setBackground(Theme.BG_MAIN);
        this.add(legendPanel);

        addLegendItem(legendPanel, 0, Theme.HIGHLIGHT, "Traversing / Comparing");
        addLegendItem(legendPanel, 190, Theme.SUCCESS, "Found / Result");
        addLegendItem(legendPanel, 340, Theme.BG_CARD, "Normal");
    }

    private void addLegendItem(JPanel parent, int x, java.awt.Color color, String label) {
        JPanel swatch = new JPanel();
        swatch.setBounds(x, 4, 16, 16);
        swatch.setBackground(color);
        swatch.setBorder(new LineBorder(Theme.TEXT_SECONDARY, 1));
        parent.add(swatch);

        JLabel text = new JLabel(label);
        text.setBounds(x + 22, 2, 160, 20);
        text.setFont(Theme.FONT_SMALL);
        text.setForeground(Theme.TEXT_SECONDARY);
        parent.add(text);
    }

    private JButton makeButton(String text, int x, int y) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 130, 35);
        btn.setFont(Theme.FONT_BODY);
        btn.setBackground(Theme.BG_CARD);
        btn.setForeground(Theme.TEXT_PRIMARY);
        btn.setFocusPainted(false);
        btn.addActionListener(this);
        this.add(btn);
        return btn;
    }

    private void updateInfoLabel() {
        infoLabel.setText("Size: " + dsList.getSize());
    }

    private int readValue() {
        try {
            return Integer.parseInt(valueField.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number in the Value field.");
            return 0;
        }
    }

    private int readPosition() {
        try {
            return Integer.parseInt(positionField.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number in the Position field.");
            return 0;
        }
    }

    private void playSteps(List<AnimationStep> steps) {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        frameQueue = steps;
        timer = new Timer(animationDelay, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == timer) {
            if (frameQueue.isEmpty()) {
                timer.stop();
                updateInfoLabel();
                return;
            }
            AnimationStep frame = frameQueue.remove(0);
            boxPanel.displayStep(frame);
            statusLabel.setText(frame.message);
            return;
        }

        String cmd = e.getActionCommand();

        if (cmd.equals("Insert at Head")) {
            playSteps(dsList.insertAtHead(readValue()));
        } else if (cmd.equals("Insert at Tail")) {
            playSteps(dsList.insertAtTail(readValue()));
        } else if (cmd.equals("Insert at Position")) {
            playSteps(dsList.insertAtPosition(readValue(), readPosition()));
        } else if (cmd.equals("Delete at Position")) {
            playSteps(dsList.deleteAtPosition(readPosition()));
        } else if (cmd.equals("Search")) {
            playSteps(dsList.search(readValue()));
        } else if (cmd.equals("Reverse")) {
            playSteps(dsList.reverse());
        } else if (cmd.equals("< Back")) {
            this.dispose();
        }
    }
}