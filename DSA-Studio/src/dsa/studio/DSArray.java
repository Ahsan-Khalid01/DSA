
package dsa.studio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A dynamic array built from a plain int[] -- this is the actual data
 * structure being studied. Every operation below does two things:
 *   1. Performs the real operation on the array (data, size, capacity)
 *   2. Builds a List of AnimationStep "photos" describing how it happened,
 *      so the screen can play it back step by step.
 */
public class DSArray {

    private int[] data;
    private int size;       // how many elements are actually in use
    private int capacity;   // how many slots are currently allocated

    public DSArray(int initialCapacity) 
    {
        if (initialCapacity < 1) 
        {
            initialCapacity = 1;
        }
        capacity = initialCapacity;
        data = new int[capacity];
        size = 0;
    }

    public int getSize()
    {
        return size;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public int[] getSnapshot()
    {
        int[] copy = new int[size];
        for (int i = 0; i < size; i++)
        {
            copy[i] = data[i];
        }
        return copy;
    }

    private int[] snapshotOfLength(int len) 
    {
        int[] copy = new int[len];
        for (int i = 0; i < len && i < data.length; i++)
        {
            copy[i] = data[i];
        }
        return copy;
    }

    private List<AnimationStep> grow()
    {
        List<AnimationStep> steps = new ArrayList<AnimationStep>();
        capacity = capacity * 2;
        int[] newData = new int[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
        steps.add(AnimationStep.idle(getSnapshot(), "Array full -> capacity doubled to " + capacity));
        return steps;
    }

    public List<AnimationStep> insert(int value, int index)
    {
        List<AnimationStep> steps = new ArrayList<AnimationStep>();

        if (index < 0 || index > size) 
        {
            steps.add(AnimationStep.idle(getSnapshot(), "Invalid index " + index));
            return steps;
        }
        if (size == capacity) 
        {
            steps.addAll(grow());
        }

        for (int i = size; i > index; i--) 
        {
            data[i] = data[i - 1];
            int[] highlightBoxes = new int[2];
            highlightBoxes[0] = i - 1;
            highlightBoxes[1] = i;
            steps.add(AnimationStep.highlight(snapshotOfLength(size + 1), highlightBoxes,
                    "Shifting value " + data[i] + " right, from index " + (i - 1) + " to " + i));
        }

        data[index] = value;
        size++;
        steps.add(AnimationStep.success(getSnapshot(), index, "Inserted " + value + " at index " + index));
        return steps;
    }

    public List<AnimationStep> delete(int index) 
    {
        List<AnimationStep> steps = new ArrayList<AnimationStep>();

        if (index < 0 || index >= size) {
            steps.add(AnimationStep.idle(getSnapshot(), "Invalid index " + index));
            return steps;
        }

        int[] removeBox = new int[1];
        removeBox[0] = index;
        steps.add(AnimationStep.highlight(getSnapshot(), removeBox, "Removing value " + data[index]));

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
            int[] highlightBoxes = new int[2];
            highlightBoxes[0] = i;
            highlightBoxes[1] = i + 1;
            steps.add(AnimationStep.highlight(snapshotOfLength(size), highlightBoxes,
                    "Shifting value " + data[i] + " left, from index " + (i + 1) + " to " + i));
        }

        size--;
        steps.add(AnimationStep.idle(getSnapshot(), "Delete complete, size is now " + size));
        return steps;
    }

    public List<AnimationStep> search(int value) 
    {
        List<AnimationStep> steps = new ArrayList<AnimationStep>();

        for (int i = 0; i < size; i++)
        {
            int[] compareBox = new int[1];
            compareBox[0] = i;
            steps.add(AnimationStep.highlight(getSnapshot(), compareBox,
                    "Comparing index " + i + " (" + data[i] + ") with " + value));

            if (data[i] == value) 
            {
                steps.add(AnimationStep.success(getSnapshot(), i, "Found " + value + " at index " + i));
                return steps;
            }
        }

        steps.add(AnimationStep.idle(getSnapshot(), value + " not found in the array"));
        return steps;
    }

    public List<AnimationStep> update(int index, int value)
    {
        List<AnimationStep> steps = new ArrayList<AnimationStep>();

        if (index < 0 || index >= size)
        {
            steps.add(AnimationStep.idle(getSnapshot(), "Invalid index " + index));
            return steps;
        }

        int oldValue = data[index];
        int[] box = new int[1];
        box[0] = index;
        steps.add(AnimationStep.highlight(getSnapshot(), box, "Old value at index " + index + " is " + oldValue));

        data[index] = value;
        steps.add(AnimationStep.success(getSnapshot(), index, "Updated index " + index + " to " + value));
        return steps;
    }

    public List<AnimationStep> resizeManually()
    {
        return grow();
    }

    public List<AnimationStep> reverse()
    {
        List<AnimationStep> steps = new ArrayList<AnimationStep>();
        int left = 0;
        int right = size - 1;

        while (left < right)
        {
            int temp = data[left];
            data[left] = data[right];
            data[right] = temp;

            int[] swapBoxes = new int[2];
            swapBoxes[0] = left;
            swapBoxes[1] = right;
            steps.add(AnimationStep.highlight(getSnapshot(), swapBoxes, "Swapping index " + left + " and " + right));

            left++;
            right--;
        }

        steps.add(AnimationStep.idle(getSnapshot(), "Reverse complete"));
        return steps;
    }

    public List<AnimationStep> rotateLeft(int k) 
    {
        List<AnimationStep> steps = new ArrayList<AnimationStep>();

        if (size == 0) {
            steps.add(AnimationStep.idle(getSnapshot(), "Array is empty"));
            return steps;
        }

        k = ((k % size) + size) % size;
        int[] rotated = new int[size];

        for (int i = 0; i < size; i++)
        {
            int newPosition = (i - k + size) % size;
            rotated[newPosition] = data[i];

            int[] preview = snapshotOfLength(size);
            preview[newPosition] = data[i];

            int[] movingBox = new int[1];
            movingBox[0] = i;
            steps.add(AnimationStep.highlight(preview, movingBox,
                    "Moving value " + data[i] + " from index " + i + " to " + newPosition));
        }

        for (int i = 0; i < size; i++)
        {
            data[i] = rotated[i];
        }

        steps.add(AnimationStep.idle(getSnapshot(), "Rotated left by " + k));
        return steps;
    }

    public List<AnimationStep> rotateRight(int k) 
    {
        if (size == 0) {
            return rotateLeft(0);
        }
        k = ((k % size) + size) % size;
        return rotateLeft(size - k);
    }

    public List<AnimationStep> bubbleSort()
    {
        List<AnimationStep> steps = new ArrayList<AnimationStep>();

        for (int i = 0; i < size - 1; i++) 
        {
            for (int j = 0; j < size - 1 - i; j++) 
            {

                int[] compareBoxes = new int[2];
                compareBoxes[0] = j;
                compareBoxes[1] = j + 1;
                steps.add(AnimationStep.highlight(getSnapshot(), compareBoxes,
                        "Comparing index " + j + " (" + data[j] + ") and " + (j + 1) + " (" + data[j + 1] + ")"));

                if (data[j] > data[j + 1])
                {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    steps.add(AnimationStep.highlight(getSnapshot(), compareBoxes, "Swapped -> out of order"));
                }
            }
        }

        steps.add(AnimationStep.idle(getSnapshot(), "Sort complete"));
        return steps;
    }

    public List<AnimationStep> clearAndFillRandom(int count, int maxValue)
    {
        List<AnimationStep> steps = new ArrayList<AnimationStep>();

        size = 0;
        capacity = count;
        if (capacity < 4) 
        {
            capacity = 4;
        }
        data = new int[capacity];

        Random rnd = new Random();
        for (int i = 0; i < count; i++)
        {
            data[i] = rnd.nextInt(maxValue) + 1;
            size++;
            steps.add(AnimationStep.success(getSnapshot(), i, "Placed " + data[i] + " at index " + i));
        }
        return steps;
    }

    // ---------- Real-world style analysis operations ----------

    public List<AnimationStep> findMax() 
    {
        List<AnimationStep> steps = new ArrayList<AnimationStep>();

        if (size == 0)
        {
            steps.add(AnimationStep.idle(getSnapshot(), "Array is empty"));
            return steps;
        }

        int maxIndex = 0;
        int[] firstBox = new int[1];
        firstBox[0] = 0;
        steps.add(AnimationStep.highlight(getSnapshot(), firstBox, "Starting with index 0 (" + data[0] + ") as the current maximum"));

        for (int i = 1; i < size; i++)
        {
            int[] compareBoxes = new int[2];
            compareBoxes[0] = maxIndex;
            compareBoxes[1] = i;
            steps.add(AnimationStep.highlight(getSnapshot(), compareBoxes,
                    "Comparing current max (" + data[maxIndex] + ") with index " + i + " (" + data[i] + ")"));

            if (data[i] > data[maxIndex]) 
            {
                maxIndex = i;
                int[] newMaxBox = new int[1];
                newMaxBox[0] = maxIndex;
                steps.add(AnimationStep.highlight(getSnapshot(), newMaxBox, "New maximum found: " + data[maxIndex] + " at index " + maxIndex));
            }
        }

        steps.add(AnimationStep.success(getSnapshot(), maxIndex, "Maximum value is " + data[maxIndex] + " at index " + maxIndex));
        return steps;
    }

    public List<AnimationStep> findMin() 
    {
        List<AnimationStep> steps = new ArrayList<AnimationStep>();

        if (size == 0) {
            steps.add(AnimationStep.idle(getSnapshot(), "Array is empty"));
            return steps;
        }

        int minIndex = 0;
        int[] firstBox = new int[1];
        firstBox[0] = 0;
        steps.add(AnimationStep.highlight(getSnapshot(), firstBox, "Starting with index 0 (" + data[0] + ") as the current minimum"));

        for (int i = 1; i < size; i++)
        {
            int[] compareBoxes = new int[2];
            compareBoxes[0] = minIndex;
            compareBoxes[1] = i;
            steps.add(AnimationStep.highlight(getSnapshot(), compareBoxes,
                    "Comparing current min (" + data[minIndex] + ") with index " + i + " (" + data[i] + ")"));

            if (data[i] < data[minIndex]) 
            {
                minIndex = i;
                int[] newMinBox = new int[1];
                newMinBox[0] = minIndex;
                steps.add(AnimationStep.highlight(getSnapshot(), newMinBox, "New minimum found: " + data[minIndex] + " at index " + minIndex));
            }
        }

        steps.add(AnimationStep.success(getSnapshot(), minIndex, "Minimum value is " + data[minIndex] + " at index " + minIndex));
        return steps;
    }

    public List<AnimationStep> calculateAverage()
    {
        List<AnimationStep> steps = new ArrayList<AnimationStep>();

        if (size == 0)
        {
            steps.add(AnimationStep.idle(getSnapshot(), "Array is empty"));
            return steps;
        }

        int runningTotal = 0;
        for (int i = 0; i < size; i++)
        {
            runningTotal = runningTotal + data[i];
            int[] box = new int[1];
            box[0] = i;
            steps.add(AnimationStep.highlight(getSnapshot(), box,
                    "Adding index " + i + " (" + data[i] + ") to running total -> total = " + runningTotal));
        }

        double average = (double) runningTotal / size;
        steps.add(AnimationStep.idle(getSnapshot(), "Sum = " + runningTotal + ", Count = " + size + ", Average = " + average));
        return steps;
    }
}