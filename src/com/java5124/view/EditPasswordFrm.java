package com.java5124.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.java5124.dao.CustomerDao;
import com.java5124.dao.ManagerDao;

import com.java5124.dao.WorkerDao;
import com.java5124.model.Customer;
import com.java5124.model.Manager;

import com.java5124.model.Worker;
import com.java5124.util.StringUtil;

public class EditPasswordFrm extends JInternalFrame {

	private JPanel contentPane;
	private JPasswordField oldPasswordTextField;
	private JPasswordField newPasswordTextField;
	private JPasswordField confirmPasswordTextField;
	private JLabel currentUserLabel;

	public EditPasswordFrm() {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setClosable(true);
		setIconifiable(true);
		JLabel label = new JLabel("\u539F\u5BC6\u7801\uFF1A");
		label.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u5BC6\u7801\uFF082).png")));
		label.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		oldPasswordTextField = new JPasswordField();
		oldPasswordTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		label_1.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		label_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		newPasswordTextField = new JPasswordField();
		newPasswordTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_2.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		label_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		confirmPasswordTextField = new JPasswordField();
		confirmPasswordTextField.setColumns(10);
		
		JButton submitButton = new JButton("\u786E\u8BA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitEdit(e);
			}
		});
		submitButton.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u91CD\u7F6E(1).png")));
		resetButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		currentUserLabel = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(86)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(108)
									.addComponent(currentUserLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(label_2))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(label)
											.addComponent(label_1)))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(newPasswordTextField, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
										.addComponent(oldPasswordTextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
										.addComponent(confirmPasswordTextField, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(resetButton)
							.addGap(106)
							.addComponent(submitButton)))
					.addContainerGap(68, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(currentUserLabel)
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(oldPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(newPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(confirmPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetButton))
					.addGap(19))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void submitEdit(ActionEvent e) {
		// TODO Auto-generated method stub
		String oldPassword = oldPasswordTextField.getText().toString();
		String newPassword = newPasswordTextField.getText().toString();
		String conformPassword = confirmPasswordTextField.getText().toString();
		if(StringUtil.isEmpty(oldPassword)){
			JOptionPane.showMessageDialog(this, "«ÎÃÓ–¥æ…√‹¬Î£°");
			return;
		}
		if(StringUtil.isEmpty(newPassword)){
			JOptionPane.showMessageDialog(this, "«ÎÃÓ–¥–¬√‹¬Î£°");
			return;
		}
		if(StringUtil.isEmpty(conformPassword)){
			JOptionPane.showMessageDialog(this, "«Î»∑»œ–¬√‹¬Î£°");
			return;
		}
		if(!newPassword.equals(conformPassword)){
			JOptionPane.showMessageDialog(this, "¡Ω¥Œ√‹¬Î ‰»Î≤ª“ª÷¬£°");
			return;
		}
		if("◊‘”…÷∞“µ’ﬂ".equals(MainFrm.userType.getName())){
			WorkerDao workerDao = new WorkerDao();
			Worker workerTmp = new Worker();
			Worker worker = (Worker)MainFrm.userObject;
			workerTmp.setWname(worker.getWname());
			workerTmp.setPassword(oldPassword);
			workerTmp.setWid(worker.getWid());
			JOptionPane.showMessageDialog(this, workerDao.editPassword(workerTmp, newPassword));
			workerDao.closeDao();
			return;
		}
		if("øÕªß".equals(MainFrm.userType.getName())){
			CustomerDao customer = new CustomerDao();
			Customer customerTmp = new Customer();
			Customer custome = (Customer)MainFrm.userObject;
			customerTmp.setCname(custome.getCname());
			customerTmp.setPassword(oldPassword);
			customerTmp.setCid(custome.getCid());
			JOptionPane.showMessageDialog(this, customer.editPassword(customerTmp, newPassword));
			customer.closeDao();
			return;
		}
		if("π‹¿Ì‘±".equals(MainFrm.userType.getName())){
			ManagerDao manager = new ManagerDao();
			Manager managerTmp = new Manager();
			Manager Manage = (Manager)MainFrm.userObject;
			managerTmp.setMname(Manage.getMname());
			managerTmp.setPassword(oldPassword);
			managerTmp.setMid(Manage.getMid());
			JOptionPane.showMessageDialog(this, manager.editPassword(managerTmp, newPassword));
			manager.closeDao();
			return;
		}
		
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		oldPasswordTextField.setText("");
		newPasswordTextField.setText("");
		confirmPasswordTextField.setText("");
	}
}
