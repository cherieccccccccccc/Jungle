package view;

import model.Constant;
import model.PlayerColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.net.URL;

/**
 * This is the equivalent of the Cell class,
 * but this class only cares how to draw Cells on ChessboardComponent
 */

public class CellComponent extends JPanel {
    public ImageIcon picture;
    public String filename;
    public Color background;
    public boolean isvalidmove;
    public int size;


    public boolean isMouseEnter() {
        return mouseEnter;
    }

    public void setMouseEnter(boolean mouseEnter) {
        this.mouseEnter = mouseEnter;
    }

    public boolean mouseEnter;
    public boolean mouseprank;
public  Image image;
    public CellComponent(Color background, Point location, int size) {

        setLayout(new GridLayout(1, 1));
        setLocation(location);
        setSize(size, size);
        this.size = size;
        this.background = background;
        //this.addMouseListener(new ChessboardComponent.SquareMouseListener(this));



    }
  /*public CellComponent(Point location,int size,Image image){
        setLayout(new GridLayout(1,1));
        setLocation(location);
        setSize(size,size);
      //super.paintComponent(graphics);
        this.size=size;
        this.image=image;
      protected void paintComponent(Graphics g) {
          super.paintComponent(g);
          // 在面板上绘制图像
          g.drawImage(image, 0, 0, null);
      }
  }*/

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.setColor(background);
        Color color=background;
        g.fillRect(1, 1, this.getWidth() - 1, this.getHeight() - 1);


        for (int i = 0; i < Constant.CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < Constant.CHESSBOARD_COL_SIZE.getNum(); j++) {

                if (isvalidmove) {
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setColor(new Color(255, 207, 87, 150));
                    RoundRectangle2D roundedRectangle = new RoundRectangle2D.Double(1, 1,
                            this.getWidth() - 1, this.getHeight() - 1, size / 4, size / 4);
                    g2d.fill(roundedRectangle);
                }
                if (mouseEnter) {
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setColor(new Color(155, 255, 157, 120));
                    RoundRectangle2D roundedRectangle = new RoundRectangle2D.Double(1, 1,
                            this.getWidth() - 1, this.getHeight() - 1, size / 4, size / 4);
                    g2d.fill(roundedRectangle);

                }

            }
        }
    }
}
