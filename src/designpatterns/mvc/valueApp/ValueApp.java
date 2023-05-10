package designpatterns.mvc.valueApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValueApp {
    private JFrame frame;
    private final ValueModel model;

    private JLabel valueLabel;
    private JTextField newValueField;
    private DefaultListModel<Integer> historyListModel;
    private JList<Integer> historyList;

    ValueApp(ValueModel model) {
        this.model = model;
        start();
    }

    private void start() {
        frame = new JFrame("Value");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenuItem exitMenu = new JMenuItem("Exit");
        fileMenu.add(exitMenu);
        frame.setJMenuBar(menuBar);

        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        container.add(topPanel, BorderLayout.NORTH);
        topPanel.setBorder(BorderFactory.createEtchedBorder());
        JButton incrButton = new JButton("Incr");
        topPanel.add(incrButton);
        JButton decrButton = new JButton("Decr");
        topPanel.add(decrButton);
        JButton resetButton = new JButton("Reset");
        topPanel.add(resetButton);

        JPanel bottomPanel = new JPanel();
        container.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setBorder(BorderFactory.createTitledBorder("Value"));
        bottomPanel.setLayout(new GridLayout(2 ,2, 5, 5));
        bottomPanel.add(new JLabel("Value: "));
        valueLabel = new JLabel("-");
        valueLabel.setBorder(BorderFactory.createEtchedBorder());
        bottomPanel.add(valueLabel);
        bottomPanel.add(new JLabel("New value: "));
        newValueField = new JTextField(10);
        bottomPanel.add(newValueField);

        JPanel historyPanel = new JPanel();
        container.add(historyPanel, BorderLayout.CENTER);
        historyPanel.setBorder(BorderFactory.createTitledBorder("History"));
        historyPanel.setLayout(new BorderLayout());
        historyListModel = new DefaultListModel<>();
        historyList = new JList<>(historyListModel);
        historyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        historyPanel.add(new JScrollPane(historyList), BorderLayout.NORTH);

        GraphView graphView = new GraphView(model);
        container.add(graphView, BorderLayout.WEST);

        // MVC
        model.addValueChangeListener(modelChangedHandler);
        model.reset();

        exitMenu.addActionListener(exitHandler);
        // exitMenu.addActionListener(e -> frame.dispose());

        incrButton.addActionListener(e -> model.incr());
        decrButton.addActionListener(e -> model.decr());
        resetButton.addActionListener(e -> {
            historyListModel.clear();
            model.reset();
        });

        newValueField.addActionListener(newValueHandler);
        historyList.getSelectionModel().addListSelectionListener(e -> {
            int i = historyList.getSelectedIndex();
            if (i >= 0 && i < historyListModel.size() - 1) {
                int value = historyListModel.get(i);
                historyListModel.removeRange(i, historyListModel.size() - 1);
                model.setValue(value);
            }
        });

        frame.setLocation(100, 100);
        frame.pack();
        frame.setVisible(true);
    }

    private final ValueChangeListener modelChangedHandler = new ValueChangeListener() {

        @Override
        public void valueChanged(ValueChangeEvent evt) {
            valueLabel.setText(Integer.toString(evt.getValue()));
            historyListModel.addElement(evt.getValue());
            historyList.setSelectedIndex(historyListModel.size() - 1);
            historyList.ensureIndexIsVisible(historyListModel.size() - 1);
        }
    };

    private final ActionListener exitHandler = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    };

    private final ActionListener newValueHandler = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int val = Integer.parseInt(newValueField.getText());
                model.setValue(val);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Wrong format for new value!", frame.getTitle(), JOptionPane.ERROR_MESSAGE);
            }
        }
    };

    public static void main(String[] args) {
        new ValueApp(new ValueModel());
    }
}
