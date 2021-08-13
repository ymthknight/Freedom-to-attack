package gundam;

import java.awt.*;

public class GameObj {
    Image image;
    int x;
    int y;
    int width;
    int height;
    double speed;
    GameWin frame;

    public GameObj(){

    }

    public GameObj(Image image, int x, int y ){
        this.image = image;
        this.x = x;
        this.y = y;
    }

    public GameObj(Image image, int x, int y,  double speed) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public GameObj(Image image, int x, int y, int width, int height, double speed, GameWin frame) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.frame = frame;
    }

    public void paintSelf(Graphics graphics){
        graphics.drawImage(image,x,y,null);
    }

    public Rectangle rectangle(){
        return new Rectangle(x,y,width,height);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public GameWin getFrame() {
        return frame;
    }

    public void setFrame(GameWin frame) {
        this.frame = frame;
    }
}
