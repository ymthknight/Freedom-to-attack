package gundam;

import utils.GameUtils;

import java.awt.*;

public class BossObj extends GameObj{

    public BossObj() {
        super();
    }

    public BossObj(Image image, int x, int y, int width, int height, double speed, GameWin frame) {
        super(image, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics graphics) {
        super.paintSelf(graphics);
        if ((int)(Math.random()*10)%2==0){
            x+=speed;
            if (x>600){
                x-=300;
            }
        }else{
            x-=speed;
            if(x<-75){
                x+=300;
            }
        }
        if (this.rectangle().intersects(this.frame.planeObj.rectangle())){
            GameWin.state=3;
        }
        for (ShellObj shellObj : GameUtils.shellObjs){
            if (this.rectangle().intersects(shellObj.rectangle())){
                shellObj.setX(1000);
                shellObj.setY(1000);
                GameUtils.removeList.add(shellObj);
                GameWin.score+=5;
            }
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
