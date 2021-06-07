package com.java5124.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.java5124.dao.TypeDao;
import com.java5124.dao.WorkerDao;
import com.java5124.model.Customer;
import com.java5124.model.Type;
import com.java5124.model.Worker;
import com.java5124.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ScrollPaneConstants;

public class WorkerManageFrm extends JInternalFrame {
	private JTextField serachStudentNameTextField;
	private JTable WorkerListTable;
	private JTextField editStudentNameTextField;
	private JPasswordField editStudentPasswordPasswordField;
	private JComboBox searchStudentComboBox;
	private List<Type> typeList ;
	private JComboBox editStudentClassComboBox;
	private ButtonGroup editSexButtonGroup;
	private JRadioButton editStudentSexManRadioButton;
	private JRadioButton editStudentSexFemalRadioButton;
	private JButton deleteStudentButton;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JButton submitEditButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkerManageFrm frame = new WorkerManageFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public WorkerManageFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u81EA\u7531\u804C\u4E1A\u8005\u7BA1\u7406");
		setBounds(100, 100, 842, 561);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(WorkerManageFrm.class.getResource("/images/\u5B66\u751F.png")));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		serachStudentNameTextField = new JTextField();
		serachStudentNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6240\u5C5E\u7C7B\u522B\uFF1A");
		label_1.setIcon(new ImageIcon(WorkerManageFrm.class.getResource("/images/\u7C7B\u522B(2).png")));
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		searchStudentComboBox = new JComboBox();
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				searchWorker(ae);
			}
		});
		searchButton.setIcon(new ImageIcon(WorkerManageFrm.class.getResource("/images/\u67E5\u8BE2.png")));
		searchButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_2 = new JLabel("\u59D3\u540D\uFF1A");
		label_2.setIcon(new ImageIcon(WorkerManageFrm.class.getResource("/images/\u5B66\u751F.png")));
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editStudentNameTextField = new JTextField();
		editStudentNameTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u6240\u5C5E\u7C7B\u522B\uFF1A");
		label_3.setIcon(new ImageIcon(WorkerManageFrm.class.getResource("/images/\u73ED\u7EA7\u4FE1\u606F.png")));
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editStudentClassComboBox = new JComboBox();
		
		JLabel label_4 = new JLabel("\u6027\u522B\uFF1A");
		label_4.setIcon(new ImageIcon(WorkerManageFrm.class.getResource("/images/\u6027\u522B.png")));
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editSexButtonGroup = new ButtonGroup();
		editStudentSexManRadioButton = new JRadioButton("\u7537");
		editStudentSexManRadioButton.setSelected(true);
		
		editStudentSexFemalRadioButton = new JRadioButton("\u5973");
		editSexButtonGroup.add(editStudentSexManRadioButton);
		editSexButtonGroup.add(editStudentSexFemalRadioButton);
		
		JLabel label_5 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_5.setIcon(new ImageIcon(WorkerManageFrm.class.getResource("/images/\u5BC6\u7801\uFF082).png")));
		label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editStudentPasswordPasswordField = new JPasswordField();
		
		submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitEditAct(ae);
			}
		});
		submitEditButton.setIcon(new ImageIcon(WorkerManageFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitEditButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		deleteStudentButton = new JButton("\u5220\u9664\u5B66\u751F");
		deleteStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteStudent(ae);
			}
		});
		deleteStudentButton.setIcon(new ImageIcon(WorkerManageFrm.class.getResource("/images/\u91CD\u7F6E(1).png")));
		deleteStudentButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_2_1 = new JLabel("\u7535\u8BDD\uFF1A");
		label_2_1.setIcon(new ImageIcon(WorkerManageFrm.class.getResource("/images/\u7535 \u8BDD.png")));
		label_2_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		passwordField = new JPasswordField();
		
		JLabel label_2_1_1 = new JLabel("\u5730\u5740\uFF1A");
		label_2_1_1.setIcon(new ImageIcon(WorkerManageFrm.class.getResource("/images/\u5730\u5740(1).png")));
		label_2_1_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		passwordField_1 = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(68)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label_2_1_1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_3)
										.addComponent(label_2))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(passwordField_1)
										.addComponent(editStudentNameTextField)
										.addComponent(editStudentClassComboBox, 0, 128, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(119)
											.addComponent(editStudentSexManRadioButton)
											.addGap(18)
											.addComponent(editStudentSexFemalRadioButton))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(18)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
													.addComponent(label_4)
													.addComponent(label_2_1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
												.addComponent(label_5))
											.addGap(11)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(editStudentPasswordPasswordField, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
												.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGap(62)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(submitEditButton)
										.addComponent(deleteStudentButton))
									.addGap(78))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(serachStudentNameTextField, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(searchStudentComboBox, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
									.addComponent(searchButton)
									.addGap(90))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 703, GroupLayout.PREFERRED_SIZE)
							.addGap(53))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(serachStudentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(searchStudentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
											.addComponent(editStudentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(label_2)
											.addComponent(label_4))
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
											.addComponent(editStudentSexFemalRadioButton)
											.addComponent(editStudentSexManRadioButton)))
									.addGap(18)
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(submitEditButton)
									.addGap(18))))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(editStudentClassComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(deleteStudentButton)
								.addComponent(label_5)
								.addComponent(editStudentPasswordPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(23))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addGap(22))))
		);
		
		WorkerListTable = new JTable();
		WorkerListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedTableRow(arg0);
			}
		});
		WorkerListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5DE5\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u7C7B\u578B", "\u7535\u8BDD", "\u5730\u5740", "\u767B\u5F55\u5BC6\u7801"
			}
		));
		scrollPane.setViewportView(WorkerListTable);
		getContentPane().setLayout(groupLayout);
		setType();
		setTable(new Worker());
		setAuthority();
	}
	protected void submitEditAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = WorkerListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "ÇëÑ¡ÖÐÒªÐÞ¸ÄµÄÊý¾Ý£¡");
			return;
		}
		String workerName = editStudentNameTextField.getText().toString();
		String phone = passwordField.getText().toString();
		String address = passwordField_1.getText().toString();
		String workerPassword = editStudentPasswordPasswordField.getText().toString();
		if(StringUtil.isEmpty(workerName)){
			JOptionPane.showMessageDialog(this, "ÇëÌîÐ´Ñ§ÉúÐÕÃû£¡");
			return;
		}
		if(StringUtil.isEmpty(workerPassword)){
			JOptionPane.showMessageDialog(this, "ÇëÌîÐ´ÃÜÂë£¡");
			return;
		}
		
		Worker worker = new Worker();
		worker.setWname(workerName);
		worker.setPassword(workerPassword);
		worker.setPhone(phone);
		worker.setAddress(address);
		Type sc = (Type)editStudentClassComboBox.getSelectedItem();
		worker.setType(sc.getType());
		worker.setWid(Integer.parseInt(WorkerListTable.getValueAt(row, 0).toString()));
		if(editStudentSexManRadioButton.isSelected())worker.setSex(editStudentSexManRadioButton.getText().toString());
		if(editStudentSexFemalRadioButton.isSelected())worker.setSex(editStudentSexFemalRadioButton.getText().toString());
		WorkerDao workerDao = new WorkerDao();
		if(workerDao.update(worker)){
			JOptionPane.showMessageDialog(this, "¸üÐÂ³É¹¦£¡");
		}else{
			JOptionPane.showMessageDialog(this, "¸üÐÂÊ§°Ü£¡");
		}
		workerDao.closeDao();
		setTable(new Worker());
	}

	protected void deleteStudent(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		int row = WorkerListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "ÇëÑ¡ÖÐÒªÉ¾³ýµÄÊý¾Ý£¡");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "ÄúÈ·¶¨É¾³ýÃ´£¿") != JOptionPane.OK_OPTION){
			return;
		}
		WorkerDao WorkerDao = new WorkerDao();
		if(WorkerDao.delete(Integer.parseInt(WorkerListTable.getValueAt(row, 0).toString()))){
			JOptionPane.showMessageDialog(this, "É¾³ý³É¹¦£¡");
		}else{
			JOptionPane.showMessageDialog(this, "É¾³ýÊ§°Ü£¡");
		}
		WorkerDao.closeDao();
		setTable(new Worker());
	}
	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) WorkerListTable.getModel();
		editStudentNameTextField.setText(dft.getValueAt(WorkerListTable.getSelectedRow(), 1).toString());
		passwordField.setText(dft.getValueAt(WorkerListTable.getSelectedRow(), 4).toString());
		passwordField_1.setText(dft.getValueAt(WorkerListTable.getSelectedRow(), 5).toString());
		editStudentPasswordPasswordField.setText(dft.getValueAt(WorkerListTable.getSelectedRow(), 6).toString());
		String typeName = dft.getValueAt(WorkerListTable.getSelectedRow(), 3).toString();
		for(int i=0;i<editStudentClassComboBox.getItemCount();i++){
			Type sc = (Type)editStudentClassComboBox.getItemAt(i);
			if(typeName.equals(sc.getType())){
				editStudentClassComboBox.setSelectedIndex(i);
			}
		}
		String sex = dft.getValueAt(WorkerListTable.getSelectedRow(), 2).toString();
		editSexButtonGroup.clearSelection();
		if(sex.equals(editStudentSexManRadioButton.getText()))editStudentSexManRadioButton.setSelected(true);
		if(sex.equals(editStudentSexFemalRadioButton.getText()))editStudentSexFemalRadioButton.setSelected(true);
	}
	protected void searchWorker(ActionEvent ae) {
		// TODO Auto-generated method stub
		Worker worker = new Worker();
		worker.setWname(serachStudentNameTextField.getText().toString());
		Type sc = (Type)searchStudentComboBox.getSelectedItem();
		worker.setType(sc.getType());
		setTable(worker);
	}

	private void setTable(Worker worker){
		if("×ÔÓÉÖ°ÒµÕß".equals(MainFrm.userType.getName())){
			Worker s = (Worker)MainFrm.userObject;
			worker.setWname(s.getWname());
		}
		DefaultTableModel dft = (DefaultTableModel) WorkerListTable.getModel();
		dft.setRowCount(0);
		WorkerDao workerDao = new WorkerDao();
		List<Worker> workerList = workerDao.getWorkerList(worker);
		for (Worker s : workerList) {
			Vector v = new Vector();
			v.add(s.getWid());
			v.add(s.getWname());
			v.add(s.getSex());
			v.add(s.getType());
			v.add(s.getPhone());
			v.add(s.getAddress());
			v.add(s.getPassword());
			dft.addRow(v);
		}
		workerDao.closeDao();
	}
	private void setType(){
		TypeDao typeDo = new TypeDao();
		typeList = typeDo.getTypeList(new Type());
		for (Type sc : typeList) {
			searchStudentComboBox.addItem(sc);
			editStudentClassComboBox.addItem(sc);
		}
		typeDo.closeDao();
	}
//	private String getClassNameById(int id){
//		for (StudentClass sc : typeList) {
//			if(sc.getClno() == id)return sc.getClname();
//		}
//		return "";
//	}
	private void setAuthority(){
		if("×ÔÓÉÖ°ÒµÕß".equals(MainFrm.userType.getName())){
			Worker s = (Worker)MainFrm.userObject;
			serachStudentNameTextField.setText(s.getWname());
			serachStudentNameTextField.setEnabled(false);
			deleteStudentButton.setEnabled(false);
			for(int i=0;i<searchStudentComboBox.getItemCount();i++){
				Type sc = (Type) searchStudentComboBox.getItemAt(i);
				if(sc.getType() == s.getType()){
					searchStudentComboBox.setSelectedIndex(i);
					break;
				}
			}
			searchStudentComboBox.setEnabled(false);
			for(int i=0;i<editStudentClassComboBox.getItemCount();i++){
				Type sc = (Type) editStudentClassComboBox.getItemAt(i);
				if(sc.getType() == s.getType()){
					editStudentClassComboBox.setSelectedIndex(i);
					break;
				}
			}
			editStudentClassComboBox.setEnabled(false);
		}
		if("¿Í»§".equals(MainFrm.userType.getName())){
			submitEditButton.setEnabled(false);
			deleteStudentButton.setEnabled(false);
			editStudentClassComboBox.setEnabled(false);
		}
		
	}
}
