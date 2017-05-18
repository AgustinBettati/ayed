package struct.impl.tree234Jorge;
/**
 * Created by IntelliJ IDEA.
 * User: Jorge
 * Date: Jun 6, 2006
 * Time: 12:35:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class TreeApp implements Runnable{
    View view;

    public TreeApp(View view) {
        this.view = view;
    }

    public void run() {
        while(true){
            try{
                view.update();
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Tree234 tree = new Tree234(4);
        View view = new View(tree);
        TreeApp treeApp = new TreeApp(view);
        Thread thread = new Thread(treeApp);
        thread.start();
        tree.print();
    }
}
