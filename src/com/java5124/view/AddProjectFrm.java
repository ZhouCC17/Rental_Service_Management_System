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

import com.java5124.dao.ProjectDao;
import com.java5124.dao.TypeDao;
import com.java5124.dao.WorkerDao;
import com.java5124.model.Project;
import com.java5124.model.Type;
import com.java5124.model.Worker;
import com.java5124.util.StringUtil;

public class AddProjectFrm extends JInternalFrame {
	private JTextField proNoTextField;
	private JPasswordField proNameField;
	private JComboBox typeComboBox;
	private ButtonGroup sexButtonGroup;
	private JTextField timeField;
	private JPasswordField customerNoField;
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
	public AddProjectFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u65B0\u589E\u9879\u76EE");
		setBounds(100, 100, 551, 471);
		
		JLabel label = new JLabel("\u9879\u76EE\u7F16\u53F7\uFF1A");
		label.setIcon(new ImageIcon(AddWorkerFrm.class.getResource("/images/\u5458\u5DE5\u59D3\u540D.png")));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		proNoTextField = new JTextField();
		proNoTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6240\u5C5E\u7C7B\u522B\uFF1A");
		label_1.setIcon(new ImageIcon(AddWorkerFrm.class.getResource("/images/\u7C7B\u522B(1).png")));
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		typeComboBox = new JComboBox();
		typeComboBox.setModel(new DefaultComboBoxModel(new String[] {}));
		
		JLabel label_2 = new JLabel("\u9879\u76EE\u5185\u5BB9\uFF1A");
		label_2.setIcon(new ImageIcon(AddProjectFrm.class.getResource("/images/\u9879\u76EE\u4FE1\u606F.png")));
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		proNameField = new JPasswordField();
		
		sexButtonGroup = new ButtonGroup();
		
		JButton submitButton = new JButton("\u786E\u8BA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				studentAddAct(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(AddWorkerFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(AddWorkerFrm.class.getResource("/images/\u91CD\u7F6E(1).png")));
		resetButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JLabel label_4 = new JLabel("\u9879\u76EE\u65F6\u95F4\uFF1A");
		label_4.setIcon(new ImageIcon(AddProjectFrm.class.getResource("/images/\u9879\u76EE.png")));
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		timeField = new JTextField();
		timeField.setColumns(10);
		
		JLabel label_2_1 = new JLabel("\u5BA2\u6237\u7F16\u53F7\uFF1A");
		label_2_1.setIcon(new ImageIcon(AddProjectFrm.class.getResource("/images/\u5BA2\u6237.png")));
		label_2_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		customerNoField = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(91)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_2)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(proNameField))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(proNoTextField))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_1)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(typeComboBox, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(3)
										.addComponent(label_2_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(customerNoField, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
											.addComponent(timeField, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))))))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(resetButton)
							.addGap(85)
							.addComponent(submitButton)))
					.addGap(152))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(proNoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(typeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(proNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(timeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(customerNoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
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
		proNoTextField.setText("");
		proNameField.setText("");
		timeField.setText("");
		customerNoField.setText("");
		typeComboBox.setSelectedIndex(0);
		sexButtonGroup.clearSelection();
	}

	protected void studentAddAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		int proNo = Integer.parseInt(proNoTextField.getText().toString());
		int cNo = Integer.parseInt(customerNoField.getText().toString());
		String time= timeField.getText().toString();
		String proName = proNameField.getText().toString();
		Type type = (Type)typeComboBox.getSelectedItem();
		Project project = new Project();
		project.setPid(proNo);
		project.setType(type.getType());
		project.setPcontent(proName);
		project.setPtime(time);
		project.setCid(cNo);
		ProjectDao projecrDao = new ProjectDao();
		if(projecrDao.addProject(project)){
			JOptionPane.showMessageDialog(this, "Ìí¼Ó³É¹¦!");
		}else{
			JOptionPane.showMessageDialog(this, "Ìí¼ÓÊ§°Ü!");
		}
		resetValue(ae);
	}
	
	private void setTypeInfo(){
		TypeDao typeDao = new TypeDao();
		List<Type> typeList = typeDao.getTypeList(new Type());
		for (Type sc : typeList) {
			typeComboBox.addItem(sc);
		}
		typeDao.closeDao();
	}
}
