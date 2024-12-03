import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class DisasterManagementSystem extends Frame implements ActionListener {

    private Label lblDisasterType, lblLocation, lblDescription;
    private TextField txtDisasterType, txtLocation, txtDescription;
    private Button btnSubmit, btnViewReports;
    private TextArea txtReports;

    private ArrayList<Disaster> disasters = new ArrayList<>();

    public DisasterManagementSystem() {
        super("Disaster Management System");

        setLayout(new BorderLayout());

        Panel panel = new Panel();
        panel.setLayout(new GridLayout(3, 2));

        lblDisasterType = new Label("Disaster Type:");
        txtDisasterType = new TextField();
        panel.add(lblDisasterType);
        panel.add(txtDisasterType);

        lblLocation = new Label("Location:");
        txtLocation = new TextField();
        panel.add(lblLocation);
        panel.add(txtLocation);

        lblDescription = new Label("Description:");
        txtDescription = new TextField();
        panel.add(lblDescription);
        panel.add(txtDescription);

        add(panel, BorderLayout.NORTH);

        Panel buttonPanel = new Panel();
        btnSubmit = new Button("Submit Report");
        btnSubmit.addActionListener(this);
        buttonPanel.add(btnSubmit);

        btnViewReports = new Button("View Reports");
        btnViewReports.addActionListener(this);
        buttonPanel.add(btnViewReports);

        add(buttonPanel, BorderLayout.CENTER);

        txtReports = new TextArea(10, 20);
        add(txtReports, BorderLayout.SOUTH);

        setSize(400, 400);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            String disasterType = txtDisasterType.getText();
            String location = txtLocation.getText();
            String description = txtDescription.getText();

            Disaster disaster = new Disaster(disasterType, location, description);
            disasters.add(disaster);

            txtDisasterType.setText("");
            txtLocation.setText("");
            txtDescription.setText("");

            JOptionPane.showMessageDialog(this, "Report submitted successfully!");
        } else if (e.getSource() == btnViewReports) {
            StringBuilder reports = new StringBuilder();
            for (Disaster disaster : disasters) {
                reports.append("Disaster Type: ").append(disaster.getDisasterType()).append("\n");
                reports.append("Location: ").append(disaster.getLocation()).append("\n");
                reports.append("Description: ").append(disaster.getDescription()).append("\n\n");
            }
            txtReports.setText(reports.toString());
        }
    }

    public static void main(String[] args) {
        new DisasterManagementSystem();
    }
}

class Disaster {
    private String disasterType;
    private String location;
    private String description;

    public Disaster(String disasterType, String location, String description) {
        this.disasterType = disasterType;
        this.location = location;
        this.description = description;
    }

    public String getDisasterType() {
        return disasterType;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }
}
