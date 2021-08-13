package utils;

import gundam.BulletOgj;
import gundam.EnemyObj;
import gundam.GameObj;
import gundam.ShellObj;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameUtils {
    //背景图片
    public static Image gamebg = Toolkit.getDefaultToolkit().getImage("img/1.jpg");
    //爆炸图片
    public static Image gamebm = Toolkit.getDefaultToolkit().getImage("img/2.png");
    //boss图片
    public static Image gameboss = Toolkit.getDefaultToolkit().getImage("img/3.png");
    //玩家图片
    public static Image gameplane = Toolkit.getDefaultToolkit().getImage("img/sf.png");
    //子弹图片
    public static Image gameshell = Toolkit.getDefaultToolkit().getImage("img/sdun.png");
    public static Image gamebullet = Toolkit.getDefaultToolkit().getImage("img/ntd1.png");
    //敌方战斗机图片
    public static Image enemy = Toolkit.getDefaultToolkit().getImage("img/0.png");

    public static List<GameObj> gameObjList=new ArrayList<>();
    public static List<GameObj> removeList=new ArrayList<>();
    public static List<ShellObj> shellObjs=new ArrayList<>();
    public static List<BulletOgj> bulletOgjs =new ArrayList<>();
    public static List<EnemyObj> enemyObjs=new ArrayList<>();

    public static void drawWord(Graphics graphics ,String str,Color color,int size,int x,int y){
        graphics.setColor(color);
        graphics.setFont((new Font(null ,Font.BOLD,size)));
        graphics.drawString(str,x,y);
    }
}
