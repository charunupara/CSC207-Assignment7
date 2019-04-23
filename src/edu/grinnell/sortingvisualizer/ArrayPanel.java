package edu.grinnell.sortingvisualizer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Arrays;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ArrayPanel extends JPanel {

  private NoteIndices notes;
  
  int width;
  int height;

  /**
   * Constructs a new ArrayPanel that renders the given note indices to the screen.
   * 
   * @param notes the indices to render
   * @param width the width of the panel
   * @param height the height of the panel
   */
  public ArrayPanel(NoteIndices notes, int width, int height) {
    this.notes = notes;
    this.width = width;
    this.height = height;
    this.setPreferredSize(new Dimension(width, height));
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Integer[] current = this.notes.getNotes();
    // System.err.println(Arrays.toString(current));

    
    for (int i = 0; i < current.length; i++) {
      int index = current[i];

      if (this.notes.isHighlighted(index)) {
        g.setColor(Color.green);
      } else {
        g.setColor(new Color(0, 128, (255*current[i])/current.length));
      }
      int ht = (current[i]*height)/current.length;
      g.fillRect((i * width)/current.length, 0, width/current.length, ht);
    }
    notes.clearAllHighlighted();
  }
}
