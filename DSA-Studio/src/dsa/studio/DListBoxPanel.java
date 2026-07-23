package dsa.studio;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;

/**
 * Shows a doubly linked list as boxes connected by two-way arrows,
 * representing that each link is really a pair of pointers: next AND prev.
 */
public class DListBoxPanel extends JPanel
{

    private JLabel[] boxes;
    private JLabel[] arrows;
    private JLabel[] indexLabels;

    private static final int BOX_SIZE = 55;
    private static final int ARROW_WIDTH = 34;
    private static final int START_X = 10;
    private static final int START_Y = 10;

    public DListBoxPanel(int maxNodes)
    {
        setLayout(null);
        setBackground(Theme.BG_PANEL);

        boxes = new JLabel[maxNodes];
        arrows = new JLabel[maxNodes];
        indexLabels = new JLabel[maxNodes];

        for (int i = 0; i < maxNodes; i++) {
            int x = START_X + i * (BOX_SIZE + ARROW_WIDTH);

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

            if (i < maxNodes - 1) {
                JLabel arrow = new JLabel("<-->", SwingConstants.CENTER);
                arrow.setBounds(x + BOX_SIZE, START_Y, ARROW_WIDTH, BOX_SIZE);
                arrow.setForeground(Theme.ACCENT);
                arrow.setFont(Theme.FONT_MONO);
                arrow.setVisible(false);
                this.add(arrow);
                arrows[i] = arrow;
            }
        }
    }

    private boolean contains(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    public void displayStep(AnimationStep step) {
        for (int i = 0; i < boxes.length; i++) {

            boolean used = step != null && i < step.values.length;

            if (used) {
                boxes[i].setVisible(true);
                boxes[i].setText(String.valueOf(step.values[i]));

                if (contains(step.marked, i)) {
                    boxes[i].setBackground(Theme.SUCCESS);
                    boxes[i].setForeground(Color.BLACK);
                } else if (contains(step.highlighted, i)) {
                    boxes[i].setBackground(Theme.HIGHLIGHT);
                    boxes[i].setForeground(Color.BLACK);
                } else {
                    boxes[i].setBackground(Theme.BG_CARD);
                    boxes[i].setForeground(Theme.TEXT_PRIMARY);
                }
            } else {
                boxes[i].setVisible(false);
            }

            if (i < arrows.length) {
                boolean showArrow = used && (i + 1) < step.values.length;
                arrows[i].setVisible(showArrow);
            }
        }
    }
}