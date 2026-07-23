/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dsa.studio;

/**
 *
 * @author Ahsan Khalid
 */
public class AnimationStep
{
    public int[] values;
    public int[] highlighted;
    public int[] marked;
    public String message;

    public AnimationStep(int[] values, int[] highlighted, int[] marked, String message) {
        this.values = values;
        this.highlighted = highlighted;
        this.marked = marked;
        this.message = message;
    }

    // A resting frame -- nothing highlighted, nothing marked
    public static AnimationStep idle(int[] values, String message)
    {
        return new AnimationStep(values, new int[0], new int[0], message);
    }

    // A frame highlighting one or two indices (comparison/shifting)
    public static AnimationStep highlight(int[] values, int[] highlighted, String message) {
        return new AnimationStep(values, highlighted, new int[0], message);
 }

    // A frame marking one index green (found/inserted/updated)
    public static AnimationStep success(int[] values, int index, String message) {
        return new AnimationStep(values, new int[0], new int[]{index}, message);
    }

}
