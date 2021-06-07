package com.java5124.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;

import com.java5124.dao.ScheduleDao;
import com.java5124.model.Schedule;
import com.java5124.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class AddScheduleFrm extends JInternalFrame {
	private JTextField timeCoreTextField;
	private JTextField workNoTextField;
	private JTextArea timeInfoTextArea;
	private JButton addCourseButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddScheduleFrm frame = new AddScheduleFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddScheduleFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u6DFB\u52A0\u65F6\u95F4\u8868");
		setBounds(100, 100, 457, 475);
		
		JLabel label = new JLabel("\u65F6\u95F4\u8868\u7F16\u53F7\uFF1A");
		label.setIcon(new ImageIcon(AddScheduleFrm.class.getResource("/images/\u65F6\u95F4\u8868(1).png")));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		timeCoreTextField = new JTextField();
		timeCoreTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5DE5\u53F7\uFF1A");
		label_2.setIcon(new ImageIcon(AddScheduleFrm.class.getResource("/images/\u5DE5\u53F7.png")));
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		workNoTextField = new JTextField();
		workNoTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u65F6\u95F4\u8868\u5185\u5BB9\uFF1A");
		label_3.setIcon(new ImageIcon(AddScheduleFrm.class.getResource("/images/\u8BFE\u7A0B\u4ECB\u7ECD.png")));
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		timeInfoTextArea = new JTextArea();
		
		addCourseButton = new JButton("\u786E\u8BA4");
		addCourseButton.setSelectedIcon(new ImageIcon(AddScheduleFrm.class.getResource("/images/\u786E\u8BA4.png")));
		addCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addCourseAct(ae);
			}
		});
		addCourseButton.setIcon(new ImageIcon(AddScheduleFrm.class.getResource("/images/\u786E\u8BA4.png")));
		addCourseButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.setSelectedIcon(new ImageIcon(AddScheduleFrm.class.getResource("/images/\u91CD\u7F6E(1).png")));
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(AddScheduleFrm.class.getResource("/images/\u91CD\u7F6E(1).png")));
		resetButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(88)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(timeCoreTextField, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_2)
							.addGap(46)
							.addComponent(workNoTextField, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_3)
								.addComponent(resetButton))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(124)
									.addComponent(addCourseButton))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(timeInfoTextArea, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)))))
					.addGap(44))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(61)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(timeCoreTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(workNoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(timeInfoTextArea, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
					.addGap(68)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(addCourseButton)
						.addComponent(resetButton))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		setAuthority();
	}

	private void setAuthority() {
		// TODO Auto-generated method stub
		if("¿Í»§".equals(MainFrm.userType.getName())){
			addCourseButton.setEnabled(false);
	}
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		timeCoreTextField.setText("");
		timeInfoTextArea.setText("");
		workNoTextField.setText("");
	}

	protected void addCourseAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		int timeCore = Integer.parseInt(timeCoreTextField.getText().toString());
		int wNoTextField =Integer.parseInt(workNoTextField.getText().toString());
		String timeInfo = timeInfoTextArea.getText().toString();
		Schedule schedule = new Schedule();
		schedule.setSid(timeCore);
		schedule.setWid(wNoTextField);
		schedule.setScontent(timeInfo);
		ScheduleDao scheduleDao = new ScheduleDao();
		if(scheduleDao.addSchedule(schedule)) {
			JOptionPane.showMessageDialog(this, "Ê±¼ä±íÌí¼Ó³É¹¦!");
		}else{
			JOptionPane.showMessageDialog(this, "Ê±¼ä±íÌí¼ÓÊ§°Ü!");
		}
		scheduleDao.closeDao();
		resetValue(ae);	
	}
}
