package main.testOfRedBlackAnd234Tree;

//ImageCreator.java

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageCreator {
    private static final int CenterX = 250;

    public static void main(String[] args) {



        int width = 500;
        int height = 500;

        //create a BufferedImage for mentioned image types.
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //create a graphics2d object which can be used to draw into the buffered image
        Graphics2D g2d = buffImg.createGraphics();

        //fill the rectangle with grey color
        g2d.setColor(Color.GRAY);
        g2d.fillRect(0, 0, width, height);

        //draw a string
        g2d.setColor(Color.RED);
        g2d.drawOval(CenterX-25,50,50,50);
        g2d.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g2d.setColor(Color.BLACK);
        g2d.drawString("100", CenterX-25 + 10, 50 + 25);

        //disposes of this graphics context and releases any system resources that it is using
        g2d.dispose();

        //write the image file
        File f = new File("icon.jpg");
        try {
            ImageIO.write(buffImg, "jpg", f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(f.getAbsolutePath()+" created successfully!");
    }

}
