package edu.grinnell.sortingvisualizer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
    Integer[] current = this.notes.getNotes();

    for (int i = 0; i < current.length; i++) {
      int index = current[i];

      if (this.notes.isHighlighted(index)) {
        g.setColor(Color.green);
      } else {
        g.setColor(Color.blue);
      }
      
      g.fillRect(i * width, current.length * height, width, height);
    }
  }
}
