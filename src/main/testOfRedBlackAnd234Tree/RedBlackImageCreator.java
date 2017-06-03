package main.testOfRedBlackAnd234Tree;

//RedBlackImageCreator.java

import struct.impl.RedBlackTree;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RedBlackImageCreator {
    private static final int CenterX = 375;

    public void drawTree(RedBlackTree rbTree) {

        int width = 750;
        int height = 500;

        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = buffImg.createGraphics();

        //fill the rectangle with grey color
        g2d.setColor(Color.GRAY);
        g2d.fillRect(0, 0, width, height);

        RedBlackTree.RedBlackNode node = rbTree.getNode();
        paintTree(g2d,CenterX, 50,1,rbTree.getNode());

        g2d.dispose();

        File f = new File("redBlackTree.jpg");
        try {
            ImageIO.write(buffImg, "jpg", f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(f.getAbsolutePath()+" created successfully!");
    }

    private static void paintTree(Graphics2D g2d,int x, int y,int height, RedBlackTree.RedBlackNode node){
        if(node != null){
            paintNode(g2d, x, y, node);
            int distance = 300 / (2 * height);
            paintLine(g2d, x, y + 35, x -distance, y + 70);
            paintLine(g2d, x, y + 35,x + distance, y + 70);
            paintTree(g2d, x - distance, y + 70, height+1, node.left);
            paintTree(g2d, x + distance, y + 70, height+1, node.right);
        }
    }

    private static void paintNode(Graphics2D g2d,int x, int y, RedBlackTree.RedBlackNode node){
        if(node.color == RedBlackTree.RedBlackNode.RED){
            g2d.setColor(Color.RED);
        } else {
            g2d.setColor(Color.BLACK);
        }
        g2d.drawOval(x -40,y,80,35);
        g2d.setFont(new Font("TimesRoman", Font.BOLD, 15));
        g2d.setColor(Color.BLACK);
        g2d.drawString(node.data.toString(), x-30, y + 22);
    }

    private static void paintLine(Graphics2D g2d, int x1, int y1, int x2, int y2){
        g2d.setColor(Color.BLACK);
        g2d.drawLine(x1, y1, x2, y2);
    }


}
