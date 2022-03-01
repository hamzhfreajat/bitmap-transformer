package com.bitmap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bitmap {


    private String transform_type;
    private int height;
    private int width;
    private BufferedImage img = null;



    public String getTransform_type() {
        return transform_type;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }


    public void readImage(String input_path ) {

        File imageFile = new File(input_path);
        System.out.println(imageFile);

        try {
             img = ImageIO.read(imageFile);
             height = img.getHeight();
             width = img.getWidth();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


    public void write(String output_path){
        try {
            ImageIO.write(img , "bmp" , new File(output_path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void convertToBlackWhite(){
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = new Color(img.getRGB(x,y));
                int red = (int)(color.getRed() * 0.299);
                int green = (int)(color.getGreen() * 0.587);
                int blue = (int)(color.getBlue() *0.114);
                Color newColor = new Color(red+green+blue,
                        red+green+blue,red+green+blue);
                img.setRGB(x,y,newColor.getRGB());
            }
        }
    }
    public void border(){
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < width; x++) {
                Color newColor = new Color(0, 0,0);
                img.setRGB(x,y,newColor.getRGB());
            }
        }
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < 2; x++) {
                Color newColor = new Color(0, 0,0);
                img.setRGB(x,y,newColor.getRGB());
            }
        }
        for (int y = 0; y < height; y++) {
            for (int x = width-1; width-2 <= x; x--) {
                Color newColor = new Color(0, 0,0);
                img.setRGB(x,y,newColor.getRGB());
            }
        }

        for (int y = height-1; height-2 <= y; y--) {
            for (int x = 0; x<width; x++) {
                Color newColor = new Color(0, 0, 0);
                img.setRGB(x, y, newColor.getRGB());
            }
        }

    }
    public void darken(){
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = new Color(img.getRGB(x,y));
                Color color1 = color.darker().darker().darker().darker().darker();
                img.setRGB(x,y,color1.getRGB());
            }
        }
    }
    @Override
    public String toString() {
        return "Bitmap{" +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
