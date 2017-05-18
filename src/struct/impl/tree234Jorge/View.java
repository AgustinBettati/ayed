package struct.impl.tree234Jorge;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Created by IntelliJ IDEA.
 * User: Jorge
 * Date: Jun 4, 2006
 * Time: 6:19:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class View {
    JFrame frame;
    JPanel panel;
    JPanel drawPanel;
    JTextField textField;
    JButton insert;
    Tree234 tree;
    Image im;
    BufferStrategy strategy;
    Graphics g;
    boolean changedContents = true;

    public View(Tree234 tree) {
        this.tree = tree;
        frame = new JFrame("Tree 234");
        frame.setPreferredSize(new Dimension(800,600));
        createButtons();
        frame.setContentPane(panel);
        frame.setVisible(true);
        frame.pack();
    }
    private void createButtons() {
        insert = new JButton("Insert");
        insert.addActionListener(new ButtonListener());
        insert.setActionCommand("INSERT");
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(45,27));
        JPanel southPanel = new JPanel();
        southPanel.add(textField);
        southPanel.add(insert);
        panel = new JPanel(new BorderLayout());
        panel.add(southPanel,BorderLayout.SOUTH);
        drawPanel = new JPanel();
        panel.add(drawPanel,BorderLayout.CENTER);
        //drawPanel.setPreferredSize(new Dimension(800,550));
    }
    private void drawTree(Graphics g) {
        NodeView.draw(tree.getRoot(),g,drawPanel.getWidth()/2);
    }

    private class ButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("INSERT")){
                try{
                    int data = Integer.parseInt(textField.getText());
                    tree.insert(data);
                    changedContents = true;
                    //System.out.println(tree.getRoot().getData()[1].toString());
                }catch(NumberFormatException ex){
                    textField.setText("");
                }
            }
        }
    }

    public void update() {

        if(changedContents) {
            gameRender();
        }
        paintScreen();
        changedContents = false;;
    }
    private void gameRender()
    {
        if (im == null){
            im = drawPanel.createImage(drawPanel.getWidth(), drawPanel.getHeight());
            if (im == null) {
                System.out.println("dbImage is null");
                return;
            }
            else{
                g = im.getGraphics();
            }

        }
        g.setColor(Color.BLACK);
        g.fillRect (0, 0, drawPanel.getWidth(), drawPanel.getHeight());
        g.setColor(Color.BLUE);
        g.setFont(new Font("Arial",Font.BOLD,14));
        drawTree(g);

    }
    private void paintScreen()
// use active rendering to put the buffered image on-screen
    {
        Graphics g;
        try {
            g = drawPanel.getGraphics();
            if ((g != null) && (im != null))
                g.drawImage(im, 0, 0, null);
                g.dispose();
        }
        catch (Exception e)
        { System.out.println("Graphics context error: " + e); }
    } // end of paintScreen()
}
