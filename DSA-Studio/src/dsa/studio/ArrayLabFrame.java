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
 * The Array Lab window. Every button reads the input fields, asks DSArray
 * for a list of animation steps, then plays those steps back one at a time
 * using a Timer. This same class handles both button clicks and timer
 * ticks -- they are told apart using e.getSource().
 */
public class ArrayLabFrame extends JFrame implements ActionListener 
{

    private DSArray dsArray;
    private ArrayBoxPanel boxPanel;

    private JLabel titleLabel, statusLabel, infoLabel;
    private JLabel valueLabel, indexLabel;
    private JTextField valueField, indexField;

    private JButton insertBtn, deleteBtn, searchBtn, updateBtn, resizeBtn;
    private JButton reverseBtn, rotateLeftBtn, rotateRightBtn, sortBtn, randomBtn;
    private JButton maxBtn, minBtn, avgBtn, backBtn;

    private Timer timer;
    private List<AnimationStep> frameQueue;
    private int animationDelay = 500;

    public ArrayLabFrame() 
    {
        dsArray = new DSArray(8);
        frameQueue = new LinkedList<AnimationStep>();

        setTitle("DSA Studio - Array Lab");
        setSize(820, 545);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Theme.BG_MAIN);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addComponents();

        boxPanel.displayStep(AnimationStep.idle(dsArray.getSnapshot(), "Ready. Choose an operation below."));
        updateInfoLabel();
    }

    private void addComponents() 
    {
        titleLabel = new JLabel("Array Lab");
        titleLabel.setFont(Theme.FONT_TITLE);
        titleLabel.setForeground(Theme.TEXT_PRIMARY);
        titleLabel.setBounds(20, 15, 300, 35);
        this.add(titleLabel);

        statusLabel = new JLabel("Ready.");
        statusLabel.setFont(Theme.FONT_BODY);
        statusLabel.setForeground(Theme.TEXT_PRIMARY);
        statusLabel.setBounds(20, 55, 760, 25);
        this.add(statusLabel);

        boxPanel = new ArrayBoxPanel(16);
        boxPanel.setBounds(20, 90, 780, 90);
        boxPanel.setBackground(Theme.BG_PANEL);
        this.add(boxPanel);

        infoLabel = new JLabel("Capacity: 8   Size: 0");
        infoLabel.setFont(Theme.FONT_SMALL);
        infoLabel.setForeground(Theme.TEXT_SECONDARY);
        infoLabel.setBounds(20, 190, 300, 20);
        this.add(infoLabel);

        addLegend();

        valueLabel = new JLabel("Value:");
        valueLabel.setForeground(Theme.TEXT_SECONDARY);
        valueLabel.setBounds(20, 250, 60, 25);
        this.add(valueLabel);

        valueField = new JTextField();
        valueField.setBounds(80, 250, 70, 25);
        this.add(valueField);

        indexLabel = new JLabel("Index:");
        indexLabel.setForeground(Theme.TEXT_SECONDARY);
        indexLabel.setBounds(170, 250, 60, 25);
        this.add(indexLabel);

        indexField = new JTextField();
        indexField.setBounds(230, 250, 70, 25);
        this.add(indexField);

        int y1 = 290;
        insertBtn = makeButton("Insert", 20, y1);
        deleteBtn = makeButton("Delete", 130, y1);
        searchBtn = makeButton("Search", 240, y1);
        updateBtn = makeButton("Update", 350, y1);
        resizeBtn = makeButton("Resize", 460, y1);

        int y2 = 335;
        reverseBtn = makeButton("Reverse", 20, y2);
        rotateLeftBtn = makeButton("Rotate Left", 130, y2);
        rotateRightBtn = makeButton("Rotate Right", 250, y2);
        sortBtn = makeButton("Sort (Bubble)", 380, y2);
        randomBtn = makeButton("Random Fill", 500, y2);

        int y3 = 380;
        maxBtn = makeButton("Find Maximum", 20, y3);
        minBtn = makeButton("Find Minimum", 150, y3);
        avgBtn = makeButton("Calculate Average", 280, y3);

        backBtn = makeButton("< Back", 20, 430);
    }

    private void addLegend() 
    {
        JPanel legendPanel = new JPanel();
        legendPanel.setLayout(null);
        legendPanel.setBounds(340, 190, 440, 25);
        legendPanel.setBackground(Theme.BG_MAIN);
        this.add(legendPanel);

        addLegendItem(legendPanel, 0, Theme.HIGHLIGHT, "Comparing / Shifting");
        addLegendItem(legendPanel, 190, Theme.SUCCESS, "Found / Result");
        addLegendItem(legendPanel, 340, Theme.BG_CARD, "Normal");
    }

    private void addLegendItem(JPanel parent, int x, java.awt.Color color, String label) 
    {
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

    private JButton makeButton(String text, int x, int y)
    {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 120, 35);
        btn.setFont(Theme.FONT_BODY);
        btn.setBackground(Theme.BG_CARD);
        btn.setForeground(Theme.TEXT_PRIMARY);
        btn.setFocusPainted(false);
        btn.addActionListener(this);
        this.add(btn);
        return btn;
    }

    private void updateInfoLabel()
    {
        infoLabel.setText("Capacity: " + dsArray.getCapacity() + "   Size: " + dsArray.getSize());
    }

    private int readValue()
    {
        try {
            return Integer.parseInt(valueField.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number in the Value field.");
            return 0;
        }
    }

    private int readIndex() 
    {
        try {
            return Integer.parseInt(indexField.getText().trim());
        } catch (NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(this, "Please enter a valid number in the Index field.");
            return 0;
        }
    }

    private void playSteps(List<AnimationStep> steps) 
    {
        if (timer != null && timer.isRunning()) 
        {
            timer.stop();
        }
        frameQueue = steps;
        timer = new Timer(animationDelay, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) 
    {

        if (e.getSource() == timer) 
        {
            if (frameQueue.isEmpty())
            {
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

        if (cmd.equals("Insert")) 
        
        {
            playSteps(dsArray.insert(readValue(), readIndex()));
        } else if (cmd.equals("Delete"))
        {
            playSteps(dsArray.delete(readIndex()));
        } else if (cmd.equals("Search")) 
        {
            playSteps(dsArray.search(readValue()));
        } else if (cmd.equals("Update"))
        {
            playSteps(dsArray.update(readIndex(), readValue()));
        } else if (cmd.equals("Resize")) 
        {
            playSteps(dsArray.resizeManually());
        } else if (cmd.equals("Reverse")) 
        {
            playSteps(dsArray.reverse());
        } else if (cmd.equals("Rotate Left"))
        {
            int k = readIndex();
            if (k < 1) k = 1;
            playSteps(dsArray.rotateLeft(k));
        } else if (cmd.equals("Rotate Right"))
        {
            int k = readIndex();
            if (k < 1) k = 1;
            playSteps(dsArray.rotateRight(k));
        } else if (cmd.equals("Sort (Bubble)")) 
        {
            playSteps(dsArray.bubbleSort());
        } else if (cmd.equals("Random Fill")) 
        {
            playSteps(dsArray.clearAndFillRandom(8, 99));
        } else if (cmd.equals("Find Maximum"))
        {
            playSteps(dsArray.findMax());
        } else if (cmd.equals("Find Minimum"))
        {
            playSteps(dsArray.findMin());
        } else if (cmd.equals("Calculate Average"))
        {
            playSteps(dsArray.calculateAverage());
        } else if (cmd.equals("< Back"))
        {
            this.dispose();
        }
    }
}