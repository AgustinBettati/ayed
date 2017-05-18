package struct.impl.tree234Jorge;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by IntelliJ IDEA.
 * User: Jorge
 * Date: Jun 5, 2006
 * Time: 6:03:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class NodeView {
    private static final int NODE_CENTER_X = 30;
    private static final int NODE2_CENTER = 26;
    private static final int NODE3_CENTER = 19;
    private static final int NODE4_CENTER = 12;
    private static final int BOTTOM_Y = 22;
    private static final int BOTTOM = 35;
    private static final int MINIMUM_SPACE = 8;
    private static int s;
    private static BufferedImage bi = BufferedImageLoader.BufferedImageLoad("node.png");
    private static final int NODE_WIDTH = 60;

    public static void paint(Node node, Graphics g){
        if(node!=null){
            if(!node.isLeaf()){
                switch(node.type){
                    case 2:{
                        g.drawImage(bi,node.x,node.y,null);
                        g.drawString(node.getData()[0].toString(),node.x+NODE2_CENTER,node.y+BOTTOM_Y);

                        g.drawLine(node.x+NODE_CENTER_X,node.y+BOTTOM,((Node2)node).getLeft().x+NODE_CENTER_X,((Node2)node).getLeft().y);
                        g.drawLine(node.x+NODE_CENTER_X,node.y+BOTTOM,((Node2)node).getRight().x+NODE_CENTER_X,((Node2)node).getRight().y);
                        paint(((Node2)node).getLeft(),g);
                        paint(((Node2)node).getRight(),g);
                    }break;
                    case 3:{
                        g.drawImage(bi,node.x,node.y,null);
                        g.drawString(node.getData()[0].toString(),node.x+NODE3_CENTER,node.y+BOTTOM_Y);
                        g.drawString(node.getData()[1].toString(),node.x+NODE3_CENTER+15,node.y+BOTTOM_Y);

                        g.drawLine(node.x+NODE_CENTER_X,node.y+BOTTOM,((Node3)node).getLeft().x+NODE_CENTER_X,((Node3)node).getLeft().y);
                        g.drawLine(node.x+NODE_CENTER_X,node.y+BOTTOM,((Node3)node).getCenter1().x+NODE_CENTER_X,((Node3)node).getCenter1().y);
                        g.drawLine(node.x+NODE_CENTER_X,node.y+BOTTOM,((Node3)node).getRight().x+NODE_CENTER_X,((Node3)node).getRight().y);
                        paint(((Node3)node).getLeft(),g);
                        paint(((Node3)node).getCenter1(),g);
                        paint(((Node3)node).getRight(),g);
                    }break;
                    case 4:{
                        g.drawImage(bi,node.x,node.y,null);
                        g.drawString(node.getData()[0].toString(),node.x+NODE4_CENTER,node.y+BOTTOM_Y);
                        g.drawString(node.getData()[1].toString(),node.x+NODE4_CENTER,node.y+BOTTOM_Y);
                        g.drawString(node.getData()[2].toString(),node.x+NODE4_CENTER,node.y+BOTTOM_Y);

                        g.drawLine(node.x+NODE_CENTER_X,node.y+BOTTOM,((Node4)node).getLeft().x+NODE_CENTER_X,((Node4)node).getLeft().y);
                        g.drawLine(node.x+NODE_CENTER_X,node.y+BOTTOM,((Node4)node).getCenter1().x+NODE_CENTER_X,((Node4)node).getCenter1().y);
                        g.drawLine(node.x+NODE_CENTER_X,node.y+BOTTOM,((Node4)node).getCenter2().x+NODE_CENTER_X,((Node4)node).getCenter2().y);
                        g.drawLine(node.x+NODE_CENTER_X,node.y+BOTTOM,((Node4)node).getRight().x+NODE_CENTER_X,((Node4)node).getRight().y);
                        paint(((Node4)node).getLeft(),g);
                        paint(((Node4)node).getCenter1(),g);
                        paint(((Node4)node).getCenter2(),g);
                        paint(((Node4)node).getRight(),g);
                    }break;
                }
            }else{
                switch(node.type){
                    case 2:{
                        g.drawImage(bi,node.x,node.y,null);
                        g.drawString(node.getData()[0].toString(),node.x+NODE2_CENTER,node.y+BOTTOM_Y);
                    }break;
                    case 3:{
                        System.out.println("entre a node3");
                        g.drawImage(bi,node.x,node.y,null);
                        g.drawString(node.getData()[0].toString(),node.x+NODE3_CENTER,node.y+BOTTOM_Y);
                        g.drawString(node.getData()[1].toString(),node.x+NODE3_CENTER+15,node.y+BOTTOM_Y);
                    }break;
                    case 4:{
                        g.drawImage(bi,node.x,node.y,null);
                        g.drawString(node.getData()[0].toString(),node.x+NODE4_CENTER,node.y+BOTTOM_Y);
                        g.drawString(node.getData()[1].toString(),node.x+NODE4_CENTER+15,node.y+BOTTOM_Y);
                        g.drawString(node.getData()[2].toString(),node.x+NODE4_CENTER+30,node.y+BOTTOM_Y);
                    }break;
                }
            }
        }
    }

    public static void draw(Node node, Graphics g,int center){
        int n = countLeafs(node);
        s = center-n*(MINIMUM_SPACE + 20);
        setCoordinates(node,0);
        paint(node,g);
    }

    private static void setCoordinates(Node node, int level) {
        if(node!=null){
            if(node.isLeaf()){
                node.x = s;
                node.y = level*50;
                s+=MINIMUM_SPACE + NODE_WIDTH;
            }else{
                switch(node.type){
                    case 2:{
                        setCoordinates(((Node2)node).getLeft(),level+1);
                        setCoordinates(((Node2)node).getRight(),level+1);
                        node.x = ((Node2)node).getLeft().x+((((Node2)node).getRight().x-((Node2)node).getLeft().x)/2);
                        node.y = level*50;
                    }break;
                    case 3:{
                        setCoordinates(((Node3)node).getLeft(),level+1);
                        setCoordinates(((Node3)node).getCenter1(),level+1);
                        setCoordinates(((Node3)node).getRight(),level+1);
                        node.x = ((Node2)node).getLeft().x+((((Node2)node).getRight().x-((Node2)node).getLeft().x)/2);
                        node.y = level*50;
                    }break;
                    case 4:{
                        setCoordinates(((Node4)node).getLeft(),level+1);
                        setCoordinates(((Node4)node).getCenter1(),level+1);
                        setCoordinates(((Node4)node).getCenter2(),level+1);
                        setCoordinates(((Node4)node).getRight(),level+1);
                        node.x = ((Node2)node).getLeft().x+((((Node2)node).getRight().x-((Node2)node).getLeft().x)/2);
                        node.y = level*50;
                    }break;
                }
            }
        }
    }

    public static int countLeafs(Node node){
        if(node!=null){
            if(!node.isLeaf()){
                switch(node.type){
                    case 2:{
                        return countLeafs(((Node2)node).getRight()) + countLeafs(((Node2)node).getLeft());
                    }
                    case 3:{
                        return countLeafs(((Node3)node).getRight())+countLeafs(((Node3)node).getCenter1())+ countLeafs(((Node3)node).getLeft());
                    }
                    case 4:{
                        return countLeafs(((Node4)node).getRight())+countLeafs(((Node4)node).getCenter2())+countLeafs(((Node4)node).getCenter1())+countLeafs(((Node4)node).getLeft());
                    }
                    default:
                        return 0;
                }
            }else{
                return 1;
            }
        }else{
            return 0;
        }
    }
}