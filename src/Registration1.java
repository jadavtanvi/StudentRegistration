import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Registration1 {

	private JFrame frame;
	private JTextField id;
	private JTextField name;
	private JTextField contact;
	private JTextField course;
	DefaultTableModel model;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration1 window = new Registration1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 819, 538);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(30, 117, 91, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(30, 160, 91, 33);
		frame.getContentPane().add(lblName);
		
		JLabel lblContact = new JLabel("Contact: ");
		lblContact.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContact.setBounds(30, 203, 91, 33);
		frame.getContentPane().add(lblContact);
		
		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCourse.setBounds(30, 246, 91, 33);
		frame.getContentPane().add(lblCourse);
		
		id = new JTextField();
		id.setFont(new Font("Tahoma", Font.PLAIN, 13));
		id.setColumns(10);
		id.setBounds(141, 117, 173, 27);
		frame.getContentPane().add(id);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 13));
		name.setColumns(10);
		name.setBounds(141, 164, 173, 27);
		frame.getContentPane().add(name);
		
		contact = new JTextField();
		contact.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contact.setColumns(10);
		contact.setBounds(141, 209, 173, 27);
		frame.getContentPane().add(contact);
		
		course = new JTextField();
		course.setFont(new Font("Tahoma", Font.PLAIN, 13));
		course.setColumns(10);
		course.setBounds(141, 250, 173, 27);
		frame.getContentPane().add(course);
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(id.getText().equals("") || name.getText().equals("") || contact.getText().equals("") || course.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Fill Complete Information!!!");
				}
				else
				{
					Object[] row = new Object[4];
					row[0] = id.getText();
					row[1] = name.getText();
					row[2] = contact.getText();
					row[3] = course.getText();
					model.addRow(row);
				
					id.setText("");
					name.setText("");
					contact.setText("");
					course.setText("");
					JOptionPane.showMessageDialog(null, "Saved Successfully!!!");
				}
			}
		});
		add.setForeground(Color.BLACK);
		add.setFont(new Font("Tahoma", Font.BOLD, 17));
		add.setBackground(Color.LIGHT_GRAY);
		add.setBounds(57, 312, 103, 46);
		frame.getContentPane().add(add);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				model.setValueAt(id.getText(), i, 0);
				model.setValueAt(name.getText(), i, 1);
				model.setValueAt(contact.getText(), i, 2);
				model.setValueAt(course.getText(), i, 3);
			}
		});
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnUpdate.setBackground(Color.LIGHT_GRAY);
		btnUpdate.setBounds(199, 312, 103, 46);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setText("");
				name.setText("");
				contact.setText("");
				course.setText("");

			}
		});
		btnClear.setForeground(Color.BLACK);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnClear.setBackground(Color.LIGHT_GRAY);
		btnClear.setBounds(199, 385, 103, 46);
		frame.getContentPane().add(btnClear);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if(i>=0)
				{
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Deleted Successfully!!!");	
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please Select a Row First!!");
				}
				
			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDelete.setBackground(Color.LIGHT_GRAY);
		btnDelete.setBounds(57, 385, 103, 46);
		frame.getContentPane().add(btnDelete);
		
		JLabel lblNewLabel_1 = new JLabel("Student Registration");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_1.setBounds(210, 23, 395, 75);
		frame.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(348, 110, 395, 381);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				if(i>=0)
				{
					id.setText(model.getValueAt(i, 0).toString());
					name.setText(model.getValueAt(i, 1).toString());
					contact.setText(model.getValueAt(i, 2).toString());
					course.setText(model.getValueAt(i, 3).toString());
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please Select a Row First!!");
				}
			}
		});
		scrollPane.setViewportView(table);
		model= new DefaultTableModel();
		Object[] column= {"ID","Name","Contact","Course"};
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
	}
}
