package gundam;

import utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameWin extends JFrame {

    public static int state = 0;
    int b=0;
    Image offScreenImage = null;
    int width = 600;
    int height = 800;
    int count = 1;
    public static int score = 0;
    BgObj bgObj=new BgObj(GameUtils.gamebg,0,-350,10);
    public PlaneObj planeObj = new PlaneObj(GameUtils.gameplane,260,700,50,50,0,this);
    public BossObj bossObj=new BossObj(GameUtils.gameboss,240,100,150,150,10,this);

    public void window(){
        //窗口是否可见
        this.setVisible(true);
        //窗口大小
        this.setSize(width,height);
        //窗口位置
        this.setLocationRelativeTo(null);
        //窗口标题
        this.setTitle("攻击自由");

        GameUtils.gameObjList.add(bgObj);
        GameUtils.gameObjList.add(planeObj);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton()==1 && state==0){
                    state=1;
                    repaint();
                }
            }
        });

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==32){
                    if (state==1){
                        state=2;
                    }else {
                        state=1;
                    }
                }
            }
        }
        );

        while (true){
            if (state==1){
                createObj();
                repaint();
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (score>100&&b==0){
                GameUtils.gameObjList.add(bossObj);
                b++;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        if (offScreenImage == null){
            offScreenImage = createImage(width,height);
        }
        Graphics graphics=offScreenImage.getGraphics();
        graphics.fillRect(0,0,width,height);
        if(state==0){
            graphics.drawImage(GameUtils.gamebg,0,0,null);
            graphics.drawImage(GameUtils.gamebm,270,600,null);
            graphics.drawImage(GameUtils.gameboss,240,100,null);
            GameUtils.drawWord(graphics,"开始游戏",Color.red,40,230,400);
            GameUtils.drawWord(graphics,"鼠标移动",Color.red,40,230,500);
            GameUtils.drawWord(graphics,"空格暂停",Color.red,40,230,600);
        }
        if(state==1){
            for (int i=0;i<GameUtils.gameObjList.size();i++){
                GameUtils.gameObjList.get(i).paintSelf(graphics);
            }
            GameUtils.gameObjList.removeAll(GameUtils.removeList);
        }
        if(state==3){
            graphics.drawImage(GameUtils.gamebm,planeObj.getX(),planeObj.getY(),null);
            GameUtils.drawWord(graphics,"游戏结束",Color.red,40,230,400);
        }
        GameUtils.drawWord(graphics,"得分："+score,Color.red,20,20,50);
        g.drawImage(offScreenImage,0,0,null);
        count++;
        System.out.println(GameUtils.gameObjList.size());
    }

    void createObj(){
        if(count%30==0){
            GameUtils.shellObjs.add(new ShellObj(GameUtils.gameshell,planeObj.getX()+20,planeObj.getY()-50,100,1,5,this));
            GameUtils.gameObjList.add(GameUtils.shellObjs.get(GameUtils.shellObjs.size()-1));
        }
        if(count%80==0){
            GameUtils.enemyObjs.add(new EnemyObj(GameUtils.enemy,(int)(Math.random()*500),0,30,30,1,this));
            GameUtils.gameObjList.add(GameUtils.enemyObjs.get(GameUtils.enemyObjs.size()-1));
        }
        if(count%80==0&&score>100){
            GameUtils.bulletOgjs.add(new BulletOgj(GameUtils.gamebullet,bossObj.getX()+50,bossObj.getY()+100,30,30,1,this));
            GameUtils.gameObjList.add(GameUtils.bulletOgjs.get(GameUtils.bulletOgjs.size()-1));
        }
    }

    public static void main(String[] args) {
        GameWin gameWin=new GameWin();
        gameWin.window();
    }
}
