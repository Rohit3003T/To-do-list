import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ToDoListApp {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static DefaultListModel<String> listModel = new DefaultListModel<>();
    private static JList<String> taskList = new JList<>(listModel);

    public static void main(String[] args) {
        JFrame frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null); // Center the window

        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);

        JTextField taskField = new JTextField();
        JButton addButton = new JButton("Add Task");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText().trim();
                if (!task.isEmpty()) {
                    tasks.add(task);
                    listModel.addElement(task);
                    taskField.setText("");
                }
            }
        });

        panel.add(taskField, BorderLayout.NORTH);
        panel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
