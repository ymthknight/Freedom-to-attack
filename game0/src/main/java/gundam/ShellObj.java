package gundam;

import utils.GameUtils;

import java.awt.*;

public class ShellObj extends GameObj{
    public ShellObj() {
        super();
    }

    public ShellObj(Image image, int x, int y, int width, int height, double speed, GameWin frame) {
        super(image, x, y, width, height, speed, frame);
    }

    @Override
    public Rectangle rectangle() {
        return super.rectangle();
    }

    @Override
    public void paintSelf(Graphics graphics) {
        super.paintSelf(graphics);
        y-=speed;
        if (this.getY()<-100){
            GameUtils.removeList.add(this);
        }
    }

    @Override
    public Image getImage() {
        return super.getImage();
    }
}
