/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package iar.busqueda.gui.util;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.TreeCellRenderer;

/**
 *
 * @author Ani Rufinetto
 */
public class MyRender extends JPanel implements TreeCellRenderer {
   private JButton botonIcono = new JButton();
   private JButton botonTexto = new JButton();
   private ImageIcon iconoHoja = new ImageIcon("meta.jpg");
   private ImageIcon iconoAbierto = new ImageIcon("luz3.png");


    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
       // throw new UnsupportedOperationException("Not supported yet.");
           // Se pone el icono adecuado
 //  if (leaf)

       // tree.setOpenIcon(iconoHoja);
   {
      botonIcono.setIcon(iconoHoja);
   }
   /*else if (expanded)
   {
      botonIcono.setIcon(iconoAbierto);
   }*/


   // Y el texto.
   //botonTexto.setText(((DefaultMutableTreeNode) value).getUserObject().toString());

   return this;
    }

    public MyRender(){
      add(botonIcono);
      add(botonTexto);
      //setOpaque(false);
    }


}
