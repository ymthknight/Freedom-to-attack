package gundam;

import utils.GameUtils;

import java.awt.*;

public class BulletOgj extends GameObj{
    public BulletOgj() {
        super();
    }

    public BulletOgj(Image image, int x, int y, int width, int height, double speed, GameWin frame) {
        super(image, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics graphics) {
        super.paintSelf(graphics);
        y+=speed;
        if (this.rectangle().intersects(this.frame.planeObj.rectangle())){
            GameWin.state=3;
        }
        if (this.getY()>1000){
            GameUtils.removeList.add(this);
        }
    }

    @Override
    public Rectangle rectangle() {
        return super.rectangle();
    }

    @Override
    public Image getImage() {
        return super.getImage();
    }
}
