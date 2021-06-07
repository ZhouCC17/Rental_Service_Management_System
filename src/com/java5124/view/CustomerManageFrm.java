package com.java5124.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.java5124.dao.CustomerDao;
import com.java5124.model.Customer;
import com.java5124.model.Type;
import com.java5124.model.Worker;
import com.java5124.util.StringUtil;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class CustomerManageFrm extends JInternalFrame {
	private JTable customerListTable;
	private JTextField searchTeacherNameTextField;
	private JTextField editTeacherNameTextField;
	private JTextField editTeacherTitleTextField;
	private JTextField editTeacherAgeTextField;
	private JPasswordField editTeacherPasswordField;
	private JRadioButton editTeacherSexManRadioButton;
	private JRadioButton editTeacherSexFemalRadioButton;
    private JButton editTeacherSubmitButton;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerManageFrm frame = new CustomerManageFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CustomerManageFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u5BA2\u6237\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 805, 691);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(CustomerManageFrm.class.getResource("/images/\u6559\u5E08\u4FE1\u606F.png")));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		searchTeacherNameTextField = new JTextField();
		searchTeacherNameTextField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u5BA2\u6237\u4FE1\u606F\u4FEE\u6539", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JButton editTeacherSubmitButton_1 = new JButton("\u641C\u7D22");
		editTeacherSubmitButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				searchCustomer(ae);
			}
		});
		editTeacherSubmitButton_1.setIcon(new ImageIcon(CustomerManageFrm.class.getResource("/images/\u67E5\u8BE2.png")));
		editTeacherSubmitButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(82)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchTeacherNameTextField, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
							.addGap(43)
							.addComponent(editTeacherSubmitButton_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 636, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE))))
					.addGap(67))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(searchTeacherNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(editTeacherSubmitButton_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(93, Short.MAX_VALUE))
		);
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setIcon(new ImageIcon(CustomerManageFrm.class.getResource("/images/\u6559\u5E08\u4FE1\u606F.png")));
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editTeacherNameTextField = new JTextField();
		editTeacherNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6027\u522B\uFF1A");
		label_2.setIcon(new ImageIcon(CustomerManageFrm.class.getResource("/images/\u6027\u522B.png")));
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		ButtonGroup buttonGroup = new ButtonGroup();
		editTeacherSexManRadioButton = new JRadioButton("\u7537");
		editTeacherSexManRadioButton.setSelected(true);
		
		editTeacherSexFemalRadioButton = new JRadioButton("\u5973");
		buttonGroup.add(editTeacherSexManRadioButton);
		buttonGroup.add(editTeacherSexFemalRadioButton);
		
		JLabel label_3 = new JLabel("\u7535\u8BDD\uFF1A");
		label_3.setIcon(new ImageIcon(CustomerManageFrm.class.getResource("/images/\u7535 \u8BDD.png")));
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editTeacherTitleTextField = new JTextField();
		editTeacherTitleTextField.setColumns(10);
		
		JLabel label_4 = new JLabel("\u5730\u5740\uFF1A");
		label_4.setIcon(new ImageIcon(CustomerManageFrm.class.getResource("/images/\u5730\u5740(1).png")));
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editTeacherAgeTextField = new JTextField();
		editTeacherAgeTextField.setColumns(10);
		
		JLabel label_5 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_5.setIcon(new ImageIcon(CustomerManageFrm.class.getResource("/images/\u5BC6\u7801\uFF082).png")));
		label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editTeacherPasswordField = new JPasswordField();
		
		editTeacherSubmitButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		editTeacherSubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editCustomerAct(ae);
			}
		});
		editTeacherSubmitButton.setIcon(new ImageIcon(CustomerManageFrm.class.getResource("/images/\u786E\u8BA4.png")));
		editTeacherSubmitButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(editTeacherNameTextField))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_5)
								.addComponent(label_3))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(editTeacherPasswordField)
								.addComponent(editTeacherTitleTextField, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))))
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editTeacherSexManRadioButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editTeacherSexFemalRadioButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(editTeacherSubmitButton)
								.addComponent(editTeacherAgeTextField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))))
					.addGap(168))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(editTeacherSexManRadioButton)
						.addComponent(editTeacherSexFemalRadioButton)
						.addComponent(editTeacherNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(editTeacherTitleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(editTeacherAgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(editTeacherPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(editTeacherSubmitButton))
					.addGap(19))
		);
		panel.setLayout(gl_panel);
		
		customerListTable = new JTable();
		customerListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedTableRow(arg0);
			}
		});
		customerListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5BA2\u6237\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u7535\u8BDD", "\u5730\u5740", "\u7C7B\u522B", "\u767B\u5F55\u5BC6\u7801"
			}
		));
		scrollPane.setViewportView(customerListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new Customer());
		setAuthority();
	}
	protected void searchCustomer(ActionEvent ae) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setCname(searchTeacherNameTextField.getText().toString());
		setTable(customer);
	}
	
	protected void editCustomerAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = customerListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "ÇëÑ¡ÔñÒªÐÞ¸ÄµÄÊý¾Ý£¡");
			return;
		}
		String customerName = editTeacherNameTextField.getText().toString();
		String customerSex = editTeacherSexManRadioButton.isSelected() ? editTeacherSexManRadioButton.getText().toString() : editTeacherSexFemalRadioButton.getText().toString();
		String customerPhone = editTeacherTitleTextField.getText().toString();
		String customerAddress=editTeacherAgeTextField.getText().toString();
		String customerPassword = editTeacherPasswordField.getText().toString();
		if(StringUtil.isEmpty(customerName)){
			JOptionPane.showMessageDialog(this, "¿Í»§ÐÕÃû±ØÐëÌîÐ´£¡");
			return;
		}
		if(StringUtil.isEmpty(customerPhone)){
			JOptionPane.showMessageDialog(this, "¿Í»§µç»°±ØÐëÌîÐ´£¡");
			return;
		}
		if(StringUtil.isEmpty(customerAddress)){
			JOptionPane.showMessageDialog(this, "¿Í»§µØÖ·±ØÐëÌîÐ´£¡");
			return;
		}
		if(StringUtil.isEmpty(customerPassword)){
			JOptionPane.showMessageDialog(this, "¿Í»§µÇÂ¼ÃÜÂë±ØÐëÌîÐ´£¡");
			return;
		}
		Customer customer = new Customer();
		customer.setCid(Integer.parseInt(customerListTable.getValueAt(row, 0).toString()));
		customer.setCname(customerName);
		customer.setSex(customerSex);
		customer.setPhone(customerPhone);
		customer.setAddress(customerAddress);
		customer.setPassword(customerPassword);
		CustomerDao customerDao = new CustomerDao();
		if(customerDao.update(customer)){
			JOptionPane.showMessageDialog(this, "ÐÞ¸Ä³É¹¦£¡");
		}else{
			JOptionPane.showMessageDialog(this, "ÐÞ¸ÄÊ§°Ü£¡");
		}
		customerDao.closeDao();
		setTable(new Customer());
	}

	private void setTable(Customer customer){
		if("¿Í»§".equals(MainFrm.userType.getName())){
			Customer tLogined = (Customer) MainFrm.userObject;
			customer.setCname(tLogined.getCname());
			searchTeacherNameTextField.setText(customer.getCname());
		}
		DefaultTableModel dft = (DefaultTableModel) customerListTable.getModel();
		dft.setRowCount(0);
		CustomerDao customerDao = new CustomerDao();
		List<Customer> customerList = customerDao.getCustonerList(customer);
		for (Customer t : customerList) {
			Vector v = new Vector();
			v.add(t.getCid());
			v.add(t.getCname());
			v.add(t.getSex());
			v.add(t.getPhone());
			v.add(t.getAddress());
			v.add(t.getType());
			v.add(t.getPassword());
			dft.addRow(v);
		}
		customerDao.closeDao();
	}
	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) customerListTable.getModel();
		editTeacherNameTextField.setText(dft.getValueAt(customerListTable.getSelectedRow(), 1).toString());
		editTeacherTitleTextField.setText(dft.getValueAt(customerListTable.getSelectedRow(), 3).toString());
		editTeacherAgeTextField.setText(dft.getValueAt(customerListTable.getSelectedRow(), 4).toString());
		editTeacherPasswordField.setText(dft.getValueAt(customerListTable.getSelectedRow(), 6).toString());
		String sex = dft.getValueAt(customerListTable.getSelectedRow(), 2).toString();
		if(sex.equals(editTeacherSexManRadioButton.getText()))editTeacherSexManRadioButton.setSelected(true);
		if(sex.equals(editTeacherSexFemalRadioButton.getText()))editTeacherSexFemalRadioButton.setSelected(true);
	}
	private void setAuthority(){
		if("¿Í»§".equals(MainFrm.userType.getName())){
			searchTeacherNameTextField.setEditable(false);
		}
		if("×ÔÓÉÖ°ÒµÕß".equals(MainFrm.userType.getName())){
			editTeacherSubmitButton.setEnabled(false);
		}
	}
}
