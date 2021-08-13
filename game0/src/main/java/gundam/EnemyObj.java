package gundam;

import utils.GameUtils;

import java.awt.*;

public class EnemyObj extends GameObj{
    public EnemyObj() {
        super();
    }

    public EnemyObj(Image image, int x, int y, int width, int height, double speed, GameWin frame) {
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
        for (ShellObj shellObj : GameUtils.shellObjs){
            if (this.rectangle().intersects(shellObj.rectangle())){
                graphics.drawImage(GameUtils.gamebm,this.x,this.y,null);
                shellObj.setX(+1000);
                shellObj.setY(+1000);
                this.setX(+1000);
                this.setY(+1000);
                GameUtils.removeList.add(shellObj);
                GameUtils.removeList.add(this);
                GameWin.score++;
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
