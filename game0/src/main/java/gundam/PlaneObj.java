package gundam;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlaneObj extends GameObj{
    public PlaneObj() {
        super();
    }

    public PlaneObj(Image image, int x, int y, int width, int height, double speed, GameWin frame) {
        super(image, x, y, width, height, speed, frame);
        this.frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                PlaneObj.super.x=e.getX()-50;
                PlaneObj.super.y=e.getY()-25;
            }
        });
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
