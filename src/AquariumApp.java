import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class AquariumApp extends JFrame {

    private final AquariumBackground aquariumBackground;
    private JComboBox<String> fishComboBox;
    private JButton addFishButton;

    private HashMap<String, Class<? extends Fish>> fishTypeMap;

    private final FishCollection fishCollection;
    public static int appWidth = 800;
    public static int appHeight = 600;


    public AquariumApp() {
        aquariumBackground = new AquariumBackground();
        fishCollection = new FishCollection(100);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(appWidth, appHeight);
        setTitle("Aquarium");

        createFishMap();
        setupUI();
//        addComponentListener(new ComponentAdapter() {
//            @Override
//            public void componentResized(ComponentEvent e) {
//                super.componentResized(e);
//                handleResize();
//            }
//        });
//
//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                System.out.println("x: " + e.getX() + " y: " + e.getY());
//                fishCollection.changeDirections(e.getX(), e.getY());
//            }
//        });
//
//        Timer timer = new Timer(10, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                fishCollection.moveAll();
//                repaint();
//            }
//        });
//        timer.start();

        setVisible(true);
    }


    private void createFishMap() {
        fishTypeMap = new HashMap<>();
        fishTypeMap.put("Grey", GreyFish.class);
        fishTypeMap.put("Orange", OrangeFish.class);
    }

    private void addFish() {
        String selectedFishType = (String) fishComboBox.getSelectedItem();
        Class<? extends Fish> fishClass = fishTypeMap.get(selectedFishType);

        if (fishClass != null) {
            try {
                Fish newFish = fishClass.getDeclaredConstructor().newInstance();
                fishCollection.add(newFish);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void setupUI() {
        String[] fishTypes = fishTypeMap.keySet().toArray(new String[0]);
        fishComboBox = new JComboBox<>(fishTypes);
        addFishButton = new JButton("Add Fish");

        addFishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFish();
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(Color.RED);
        controlPanel.add(fishComboBox);
        controlPanel.add(addFishButton);

        // Add controlPanel to the frame
        getContentPane().add(controlPanel, BorderLayout.NORTH);
    }


    private void handleResize() {
        appWidth = getWidth();
        appHeight = getHeight();
    }

    @Override
    public void paint(Graphics g) {
        Image offScreenImage = createImage(getWidth(), getHeight());
        Graphics offScreenGraphics = offScreenImage.getGraphics();
        super.paint(offScreenGraphics);

        aquariumBackground.setGraphics(offScreenGraphics);
        aquariumBackground.showBackground();

        fishCollection.drawAll(offScreenGraphics);

        g.drawImage(offScreenImage, 0, 0, this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AquariumApp());
    }
}
