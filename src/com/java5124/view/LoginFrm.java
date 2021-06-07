package com.java5124.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.java5124.dao.ManagerDao;
import com.java5124.dao.WorkerDao;
import com.java5124.dao.CustomerDao;
import com.java5124.model.Customer;
import com.java5124.model.UserType;
import com.java5124.model.Worker;
import com.java5124.model.Manager;
import com.java5124.util.StringUtil;

public class LoginFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTextField;
	private JPasswordField passwordTextField;
	private JComboBox userTypeComboBox;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginFrm() {
		setTitle("\u767B\u9646\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		JLabel label = new JLabel("\u51FA\u79DF\u670D\u52A1\u7BA1\u7406\u7CFB\u7EDF");
		label.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u6F5C\u5BA2\u7BA1\u7406\u7CFB\u7EDF.png")));
		label.setFont(new Font("微软雅黑", Font.BOLD, 24));
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		label_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u7528\u6237.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		userNameTextField = new JTextField();
		userNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BC6   \u7801\uFF1A");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_2.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u5BC6\u7801.png")));
		
		passwordTextField = new JPasswordField();
		passwordTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
		label_3.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u8D26\u53F7\u7C7B\u578B.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		userTypeComboBox = new JComboBox();
		userTypeComboBox.setModel(new DefaultComboBoxModel(new UserType[] {UserType.WORKER, UserType.CUSTOMER,UserType.MANAGER}));
		userTypeComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.setSelectedIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u767B\u5F55.png")));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				loginAct(ae);
			}
		});
		loginButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u767B\u5F55.png")));
		loginButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				restValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(134)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(label_1)
										.addComponent(label_2))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(passwordTextField, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
										.addComponent(userNameTextField, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(resetButton)
										.addComponent(label_3))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(userTypeComboBox, 0, 170, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(95)
											.addComponent(loginButton)))))))
					.addGap(116))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginButton)
						.addComponent(resetButton))
					.addGap(22))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void loginAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String userName = userNameTextField.getText().toString();
		String password = passwordTextField.getText().toString();
		UserType selectedItem = (UserType)userTypeComboBox.getSelectedItem();
		if(StringUtil.isEmpty(userName)){
			JOptionPane.showMessageDialog(this, "用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(password)){
			JOptionPane.showMessageDialog(this, "密码不能为空！");
			return;
		}
		if("客户".equals(selectedItem.getName())){
			//客户登录
			Customer customer = null;
			CustomerDao customerDao = new CustomerDao();
			Customer customerTmp = new Customer();
			customerTmp.setCname(userName);
			customerTmp.setPassword(password);
			customer = customerDao.login(customerTmp);
			customerDao.closeDao();
			if(customer == null){
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getName()+"】："+customer.getCname()+"登录本系统！");
			this.dispose();
			new MainFrm(selectedItem, customer).setVisible(true);
		}else if("自由职业者".equals(selectedItem.getName())){
			//自由职业者登录
			Worker worker = null; 
			WorkerDao workerDao = new WorkerDao();
			Worker workerTmp = new Worker();
			workerTmp.setWname(userName);
			workerTmp.setPassword(password);
			worker = workerDao.login(workerTmp);
			workerDao.closeDao();
			if(worker == null){
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getName()+"】："+worker.getWname()+"登录本系统！");
			this.dispose();
			new MainFrm(selectedItem, worker).setVisible(true);
		}
		else {
			//其他人登录
			Manager manager = null; 
			ManagerDao managerDao = new ManagerDao();
			Manager managerTmp = new Manager();
			managerTmp.setMname(userName);
			managerTmp.setPassword(password);
			manager = managerDao.login(managerTmp);
			managerDao.closeDao();
			if(manager == null){
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getName()+"】："+manager.getMname()+"登录本系统！");
			this.dispose();
			new MainFrm(selectedItem, manager).setVisible(true);
		}
	}

	protected void restValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		userNameTextField.setText("");
		passwordTextField.setText("");
		userTypeComboBox.setSelectedIndex(0);
	}
}
