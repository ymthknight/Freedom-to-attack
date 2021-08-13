package gundam;

import java.awt.*;

public class BgObj extends GameObj{
    public BgObj() {
        super();
    }

    public BgObj(Image image, int x, int y, double speed) {
        super(image, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics graphics) {
        super.paintSelf(graphics);
        y+=speed;
        if(y>=350){
            y=-350;
        }
    }
}
