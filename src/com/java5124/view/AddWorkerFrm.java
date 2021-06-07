package com.java5124.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.java5124.dao.TypeDao;
import com.java5124.dao.WorkerDao;
import com.java5124.model.Type;
import com.java5124.model.Worker;
import com.java5124.util.StringUtil;

public class AddWorkerFrm extends JInternalFrame {
	private JTextField workerNameTextField;
	private JPasswordField workertPasswordField;
	private JComboBox workerComboBox;
	private ButtonGroup sexButtonGroup;
	private JRadioButton workerSexManRadioButton;
	private JRadioButton studentSexFemalRadioButton;
	private JTextField addressField;
	private JPasswordField phoneField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddWorkerFrm frame = new AddWorkerFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddWorkerFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u81EA\u7531\u804C\u4E1A\u8005\u6DFB\u52A0");
		setBounds(100, 100, 551, 471);
		
		JLabel label = new JLabel("\u81EA\u7531\u804C\u4E1A\u8005\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(AddWorkerFrm.class.getResource("/images/\u5458\u5DE5\u59D3\u540D.png")));
		label.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		workerNameTextField = new JTextField();
		workerNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6240\u5C5E\u7C7B\u522B\uFF1A");
		label_1.setIcon(new ImageIcon(AddWorkerFrm.class.getResource("/images/\u7C7B\u522B(1).png")));
		label_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		workerComboBox = new JComboBox();
		workerComboBox.setModel(new DefaultComboBoxModel(new String[] {}));
		
		JLabel label_2 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_2.setIcon(new ImageIcon(AddWorkerFrm.class.getResource("/images/\u5BC6\u7801\uFF082).png")));
		label_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		workertPasswordField = new JPasswordField();
		
		JLabel label_3 = new JLabel("\u6027\u522B\uFF1A");
		label_3.setIcon(new ImageIcon(AddWorkerFrm.class.getResource("/images/\u6027\u522B.png")));
		label_3.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		workerSexManRadioButton = new JRadioButton("\u7537");
		workerSexManRadioButton.setSelected(true);
		
		studentSexFemalRadioButton = new JRadioButton("\u5973");
		
		sexButtonGroup = new ButtonGroup();
		sexButtonGroup.add(workerSexManRadioButton);
		sexButtonGroup.add(studentSexFemalRadioButton);
		
		JButton submitButton = new JButton("\u786E\u8BA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				studentAddAct(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(AddWorkerFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(AddWorkerFrm.class.getResource("/images/\u91CD\u7F6E(1).png")));
		resetButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		JLabel label_4 = new JLabel("\u5730\u5740\uFF1A");
		label_4.setIcon(new ImageIcon(AddWorkerFrm.class.getResource("/images/\u5730\u5740(1).png")));
		label_4.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		addressField = new JTextField();
		addressField.setColumns(10);
		
		JLabel label_2_1 = new JLabel("\u7535\u8BDD\uFF1A");
		label_2_1.setIcon(new ImageIcon(AddWorkerFrm.class.getResource("/images/\u7535 \u8BDD.png")));
		label_2_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		phoneField = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(91)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(workerComboBox, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(workerNameTextField, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_2)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(workertPasswordField, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
									.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(9)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(resetButton)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(label_2_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_3))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(workerSexManRadioButton)
													.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(studentSexFemalRadioButton)
													.addGap(20))
												.addComponent(phoneField, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
												.addComponent(addressField, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(submitButton)
							.addGap(163)))
					.addGap(92))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(workerNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(workerComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(workertPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(addressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(phoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(workerSexManRadioButton)
						.addComponent(studentSexFemalRadioButton))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetButton)
						.addComponent(submitButton))
					.addGap(69))
		);
		getContentPane().setLayout(groupLayout);
		setTypeInfo();
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		workerNameTextField.setText("");
		workertPasswordField.setText("");
		addressField.setText("");
		phoneField.setText("");
		workerComboBox.setSelectedIndex(0);
		sexButtonGroup.clearSelection();
		workerSexManRadioButton.setSelected(true);
	}

	protected void studentAddAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String workerName = workerNameTextField.getText().toString();
		String address = addressField.getText().toString();
		String phone = phoneField.getText().toString();
		String workerPassword = workertPasswordField.getText().toString();
		if(StringUtil.isEmpty(workerName)){
			JOptionPane.showMessageDialog(this, "«ÎÃÓ–¥◊‘”…÷∞“µ’ﬂ–’√˚!");
			return;
		}
		if(StringUtil.isEmpty(workerPassword)){
			JOptionPane.showMessageDialog(this, "«ÎÃÓ–¥√‹¬Î!");
			return;
		}
		Type type = (Type)workerComboBox.getSelectedItem();
		String sex = (String) (workerSexManRadioButton.isSelected() ? workerSexManRadioButton.getText():studentSexFemalRadioButton.getText());
		Worker worker = new Worker();
		worker.setWname(workerName);
		worker.setType(type.getType());
		worker.setPassword(workerPassword);
		worker.setSex(sex);
		worker.setAddress(address);
		worker.setPhone(phone);
		WorkerDao workerDao = new WorkerDao();
		if(workerDao.addStudent(worker)){
			JOptionPane.showMessageDialog(this, "ÃÌº”≥…π¶!");
		}else{
			JOptionPane.showMessageDialog(this, "ÃÌº” ß∞‹!");
		}
		resetValue(ae);
	}
	
	private void setTypeInfo(){
		TypeDao typeDao = new TypeDao();
		List<Type> typeList = typeDao.getTypeList(new Type());
		for (Type sc : typeList) {
			workerComboBox.addItem(sc);
		}
		typeDao.closeDao();
	}
}
