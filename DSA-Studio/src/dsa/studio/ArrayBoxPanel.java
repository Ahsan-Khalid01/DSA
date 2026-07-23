/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dsa.studio;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;

/**
 * Shows the array as a row of boxes. Each box is just a plain JLabel with
 * a border and a background color -- no custom drawing involved.
 * displayStep() updates the text and color of each label to match
 * whatever AnimationStep is currently being shown.
 */
public class ArrayBoxPanel extends JPanel {

    private JLabel[] boxes;
    private JLabel[] indexLabels;

    private static final int BOX_SIZE = 55;
    private static final int GAP = 10;
    private static final int START_X = 10;
    private static final int START_Y = 10;

    public ArrayBoxPanel(int maxBoxes) 
    {
        setLayout(null);
        setBackground(Theme.BG_PANEL);

        boxes = new JLabel[maxBoxes];
        indexLabels = new JLabel[maxBoxes];

        for (int i = 0; i < maxBoxes; i++) 
        {
            int x = START_X + i * (BOX_SIZE + GAP);

            JLabel box = new JLabel("", SwingConstants.CENTER);
            box.setBounds(x, START_Y, BOX_SIZE, BOX_SIZE);
            box.setOpaque(true);
            box.setBackground(Theme.BG_CARD);
            box.setForeground(Theme.TEXT_PRIMARY);
            box.setFont(Theme.FONT_MONO);
            box.setBorder(new LineBorder(Theme.TEXT_SECONDARY, 1));
            box.setVisible(false);
            this.add(box);
            boxes[i] = box;

            JLabel idx = new JLabel(String.valueOf(i), SwingConstants.CENTER);
            idx.setBounds(x, START_Y + BOX_SIZE + 4, BOX_SIZE, 18);
            idx.setForeground(Theme.TEXT_SECONDARY);
            idx.setFont(Theme.FONT_SMALL);
            this.add(idx);
            indexLabels[i] = idx;
        }
    }

    private boolean contains(int[] arr, int value) 
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == value) 
            {
                return true;
            }
        }
        return false;
    }

    // Updates every box to match one animation frame
    public void displayStep(AnimationStep step)
    {
        for (int i = 0; i < boxes.length; i++) 
        {

            if (step != null && i < step.values.length)
            {
                boxes[i].setVisible(true);
                boxes[i].setText(String.valueOf(step.values[i]));

                if (contains(step.marked, i))
                {
                    boxes[i].setBackground(Theme.SUCCESS);
                    boxes[i].setForeground(Color.BLACK);
                } else if (contains(step.highlighted, i)) 
                {
                    boxes[i].setBackground(Theme.HIGHLIGHT);
                    boxes[i].setForeground(Color.BLACK);
                } else {
                    boxes[i].setBackground(Theme.BG_CARD);
                    boxes[i].setForeground(Theme.TEXT_PRIMARY);
                }

            } else {
                boxes[i].setVisible(false);
            }
        }
    }
}
