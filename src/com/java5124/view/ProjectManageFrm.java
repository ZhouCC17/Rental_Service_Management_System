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

import com.java5124.dao.ProjectDao;
import com.java5124.model.Customer;
import com.java5124.model.Project;
import com.java5124.model.Type;
import com.java5124.model.Worker;
import com.java5124.util.StringUtil;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JComboBox;

public class ProjectManageFrm extends JInternalFrame {
	private JTable ProjectListTable;
	private JTextField searchTeacherNameTextField;
	private JTextField editTeacherNameTextField;
	private JTextField editTeacherTitleTextField;
	private JTextField editTeacherAgeTextField;
    private JButton editTeacherSubmitButton;
    private JTextField textField;
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

	public ProjectManageFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u9879\u76EE\u7BA1\u7406");
		setBounds(100, 100, 805, 691);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u9879\u76EE\u7F16\u53F7\uFF1A");
		label.setIcon(new ImageIcon(ProjectManageFrm.class.getResource("/images/\u9879\u76EE.png")));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		searchTeacherNameTextField = new JTextField();
		searchTeacherNameTextField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u9879\u76EE\u4FE1\u606F\u4FEE\u6539", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
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
					.addContainerGap(88, Short.MAX_VALUE))
		);
		
		JLabel label_1 = new JLabel("\u9879\u76EE\u7F16\u53F7\uFF1A");
		label_1.setIcon(new ImageIcon(ProjectManageFrm.class.getResource("/images/\u9879\u76EE.png")));
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editTeacherNameTextField = new JTextField();
		editTeacherNameTextField.setColumns(10);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		JLabel label_3 = new JLabel("\u9879\u76EE\u65F6\u95F4\uFF1A");
		label_3.setIcon(new ImageIcon(ProjectManageFrm.class.getResource("/images/\u65F6\u95F4\u8868(1).png")));
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editTeacherTitleTextField = new JTextField();
		editTeacherTitleTextField.setColumns(10);
		
		JLabel label_4 = new JLabel("\u5BA2\u6237\u53F7\uFF1A");
		label_4.setIcon(new ImageIcon(ProjectManageFrm.class.getResource("/images/\u5BA2\u6237.png")));
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editTeacherAgeTextField = new JTextField();
		editTeacherAgeTextField.setColumns(10);
		
		JLabel label_5 = new JLabel("\u7C7B\u522B\uFF1A");
		label_5.setIcon(new ImageIcon(ProjectManageFrm.class.getResource("/images/\u7C7B\u522B(2).png")));
		label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editTeacherSubmitButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		editTeacherSubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
//				editCustomerAct(ae);
			}
		});
		editTeacherSubmitButton.setIcon(new ImageIcon(CustomerManageFrm.class.getResource("/images/\u786E\u8BA4.png")));
		editTeacherSubmitButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_1_1 = new JLabel("\u9879\u76EE\u5185\u5BB9\uFF1A");
		label_1_1.setIcon(new ImageIcon(ProjectManageFrm.class.getResource("/images/\u9879\u76EE\u4FE1\u606F.png")));
		label_1_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JComboBox searchStudentComboBox = new JComboBox();
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
								.addComponent(editTeacherTitleTextField)
								.addComponent(searchStudentComboBox, 0, 145, Short.MAX_VALUE))))
					.addGap(12)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_4)
						.addComponent(label_1_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addComponent(editTeacherAgeTextField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(editTeacherSubmitButton))
					.addGap(123))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(editTeacherNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(editTeacherTitleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(editTeacherAgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(editTeacherSubmitButton)
						.addComponent(searchStudentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19))
		);
		panel.setLayout(gl_panel);
		
		ProjectListTable = new JTable();
		ProjectListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedTableRow(arg0);
			}
		});
		ProjectListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u9879\u76EE\u7F16\u53F7", "\u9879\u76EE\u5185\u5BB9", "\u9879\u76EE\u65F6\u95F4", "\u5BA2\u6237\u53F7", "\u7C7B\u522B"
			}
		));
		scrollPane.setViewportView(ProjectListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new Project());
//		setAuthority();
	}
	protected void searchCustomer(ActionEvent ae) {
		// TODO Auto-generated method stub
		Project project = new Project();
		if(searchTeacherNameTextField.getText()!=null) {
			project.setPid(Integer.parseInt(searchTeacherNameTextField.getText().toString()));
		}else {
			project.setPid(0);
		}
		setTable(project);
	}
	
//	protected void editCustomerAct(ActionEvent ae) {
//		// TODO Auto-generated method stub
//		int row = ProjectListTable.getSelectedRow();
//		if(row == -1){
//			JOptionPane.showMessageDialog(this, "ÇëÑ¡ÔñÒªÐÞ¸ÄµÄÊý¾Ý£¡");
//			return;
//		}
//		String customerName = editTeacherNameTextField.getText().toString();
//		String customerSex = editTeacherSexManRadioButton.isSelected() ? editTeacherSexManRadioButton.getText().toString() : editTeacherSexFemalRadioButton.getText().toString();
//		String customerPhone = editTeacherTitleTextField.getText().toString();
//		String customerAddress=editTeacherAgeTextField.getText().toString();
//		String customerPassword = editTeacherPasswordField.getText().toString();
//		if(StringUtil.isEmpty(customerName)){
//			JOptionPane.showMessageDialog(this, "¿Í»§ÐÕÃû±ØÐëÌîÐ´£¡");
//			return;
//		}
//		if(StringUtil.isEmpty(customerPhone)){
//			JOptionPane.showMessageDialog(this, "¿Í»§µç»°±ØÐëÌîÐ´£¡");
//			return;
//		}
//		if(StringUtil.isEmpty(customerAddress)){
//			JOptionPane.showMessageDialog(this, "¿Í»§µØÖ·±ØÐëÌîÐ´£¡");
//			return;
//		}
//		if(StringUtil.isEmpty(customerPassword)){
//			JOptionPane.showMessageDialog(this, "¿Í»§µÇÂ¼ÃÜÂë±ØÐëÌîÐ´£¡");
//			return;
//		}
//		Customer customer = new Customer();
//		customer.setCid(Integer.parseInt(ProjectListTable.getValueAt(row, 0).toString()));
//		customer.setCname(customerName);
//		customer.setSex(customerSex);
//		customer.setPhone(customerPhone);
//		customer.setAddress(customerAddress);
//		customer.setPassword(customerPassword);
//		ProjectDao customerDao = new ProjectDao();
//		if(customerDao.update(customer)){
//			JOptionPane.showMessageDialog(this, "ÐÞ¸Ä³É¹¦£¡");
//		}else{
//			JOptionPane.showMessageDialog(this, "ÐÞ¸ÄÊ§°Ü£¡");
//		}
//		customerDao.closeDao();
//		setTable(new Customer());
//	}

	private void setTable(Project project){
		DefaultTableModel dft = (DefaultTableModel) ProjectListTable.getModel();
		dft.setRowCount(0);
		ProjectDao projectDao = new ProjectDao();
		List<Project> projectList = projectDao.getProjectList(project);
		for (Project t : projectList) {
			Vector v = new Vector();
			v.add(t.getPid());
			v.add(t.getPcontent());
			v.add(t.getPtime());
			v.add(t.getCid());
			v.add(t.getType());
			dft.addRow(v);
		}
		projectDao.closeDao();
	}
	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) ProjectListTable.getModel();
		editTeacherNameTextField.setText(dft.getValueAt(ProjectListTable.getSelectedRow(), 1).toString());
		editTeacherTitleTextField.setText(dft.getValueAt(ProjectListTable.getSelectedRow(), 3).toString());
		editTeacherAgeTextField.setText(dft.getValueAt(ProjectListTable.getSelectedRow(), 4).toString());
	}
//	private void setAuthority(){
//		if("¿Í»§".equals(MainFrm.userType.getName())){
//			searchTeacherNameTextField.setEditable(false);
//		}
//		if("×ÔÓÉÖ°ÒµÕß".equals(MainFrm.userType.getName())){
//			editTeacherSubmitButton.setEnabled(false);
//		}
//	}
}
