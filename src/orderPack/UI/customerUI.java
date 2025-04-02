package orderPack.UI;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import orderPack.Backend.customerBackend;

public class customerUI extends JFrame {
    private JTable customerTable;
    private DefaultTableModel tableModel;
    private final customerBackend backend;

    private JTextField customerIDField, customerNameField, emailField, phoneField, birthdayField;
    private JButton addButton, updateButton, deleteButton, saveButton;

    public customerUI() {
        backend = new customerBackend();
        setTitle("Quản lý Khách hàng");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        createTable();
        createInputPanel();
        lockInputFields();

        loadCustomerData();

        addButton.addActionListener(e -> startAddMode());
        updateButton.addActionListener(e -> startEditMode());
        deleteButton.addActionListener(e -> deleteCustomer());
        saveButton.addActionListener(e -> saveCustomer());
    }

    private void createTable() {
        tableModel = new DefaultTableModel(new String[]{"ID", "Customer ID", "Customer Name", "Email", "Phone", "Birthday"}, 0);
        customerTable = new JTable(tableModel);
        add(new JScrollPane(customerTable), BorderLayout.CENTER);
    }

    private void createInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));

        customerIDField = new JTextField();
        customerNameField = new JTextField();
        emailField = new JTextField();
        phoneField = new JTextField();
        birthdayField = new JTextField();

        addButton = new JButton("Thêm");
        updateButton = new JButton("Sửa");
        deleteButton = new JButton("Xóa");
        saveButton = new JButton("Lưu");

        inputPanel.add(new JLabel("Customer ID"));
        inputPanel.add(customerIDField);
        inputPanel.add(new JLabel("Customer Name"));
        inputPanel.add(customerNameField);
        inputPanel.add(new JLabel("Email"));
        inputPanel.add(emailField);
        inputPanel.add(new JLabel("Phone"));
        inputPanel.add(phoneField);
        inputPanel.add(new JLabel("Birthday"));
        inputPanel.add(birthdayField);
        inputPanel.add(saveButton);
        inputPanel.add(addButton);
        inputPanel.add(updateButton);
        inputPanel.add(deleteButton);

        add(inputPanel, BorderLayout.SOUTH);
    }

    private void loadCustomerData() {
        tableModel.setRowCount(0);
        for (String[] row : backend.getAllCustomers()) {
            tableModel.addRow(row);
        }
    }

    private void lockInputFields() {
        customerIDField.setEnabled(false);
        customerNameField.setEnabled(false);
        emailField.setEnabled(false);
        phoneField.setEnabled(false);
        birthdayField.setEnabled(false);
    }

    private void unlockInputFields() {
        customerIDField.setEnabled(true);
        customerNameField.setEnabled(true);
        emailField.setEnabled(true);
        phoneField.setEnabled(true);
        birthdayField.setEnabled(true);
    }

    private void startAddMode() {
        unlockInputFields();
    }

    private void startEditMode() {
        unlockInputFields();
    }

    private void saveCustomer() {
        String customerID = customerIDField.getText();
        String customerName = customerNameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String birthday = birthdayField.getText();

        if (customerID.isEmpty() || customerName.isEmpty() || email.isEmpty() || phone.isEmpty() || birthday.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.");
            return;
        }

        backend.addCustomer(customerID, customerName, email, phone, birthday);
        loadCustomerData();
        lockInputFields();
    }

    private void deleteCustomer() {
        int selectedRow = customerTable.getSelectedRow();
        if (selectedRow != -1) {
            int id = Integer.parseInt((String) tableModel.getValueAt(selectedRow, 0));
            backend.deleteCustomer(id);
            loadCustomerData();
        } else {
            JOptionPane.showMessageDialog(this, "Chọn một khách hàng để xóa.");
        }
    }
}