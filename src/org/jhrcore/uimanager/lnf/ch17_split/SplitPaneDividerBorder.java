/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhrcore.uimanager.lnf.ch17_split;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JSplitPane;
import javax.swing.border.Border;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;
/**
 *
 * @author mxliteboss
 */
public class SplitPaneDividerBorder implements Border, UIResource
{
  public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
  {
  }

  public Insets getBorderInsets(Component c)
  {
    Insets insets = new Insets(0, 0, 0, 0);
    if ((c instanceof BasicSplitPaneDivider))
    {
      BasicSplitPaneUI bspui = ((BasicSplitPaneDivider)c)
        .getBasicSplitPaneUI();

      if (bspui != null)
      {
        JSplitPane splitPane = bspui.getSplitPane();

        if (splitPane != null)
        {
          if (splitPane.getOrientation() == 1)
          {
            insets.top = (insets.bottom = 0);
            insets.left = (insets.right = 1);
            return insets;
          }

          insets.top = (insets.bottom = 1);
          insets.left = (insets.right = 0);
          return insets;
        }
      }
    }
    insets.top = (insets.bottom = insets.left = insets.right = 1);
    return insets;
  }

  public boolean isBorderOpaque()
  {
    return true;
  }
}