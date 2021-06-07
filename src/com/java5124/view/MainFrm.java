package com.java5124.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java5124.model.UserType;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class MainFrm extends JFrame {
	
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	public static UserType userType;
	public static Object userObject;
	private JMenuItem addStudentMenuItem ;
	private JMenu manageTeacherMenu;
	private JMenu courseMenu;
	private JMenuItem addScoreMenuItem;
	private JMenuItem manageScoreMenuItem;

	public MainFrm(UserType userType,Object userObject) {
		setAutoRequestFocus(false);
		setAlwaysOnTop(true);
		this.userType = userType;
		this.userObject = userObject;
		setTitle("\u51FA\u79DF\u670D\u52A1\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 774);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu_1 = new JMenu("\u81EA\u7531\u804C\u4E1A\u8005\u7BA1\u7406");
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5458\u5DE5\u7BA1\u7406.png")));
		menuBar.add(menu_1);
		
		addStudentMenuItem = new JMenuItem("\u81EA\u7531\u804C\u4E1A\u8005\u6DFB\u52A0");
		addStudentMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddWorkerFrm addWorkerFrm = new AddWorkerFrm();
				addWorkerFrm.setVisible(true);
				desktopPane.add(addWorkerFrm);
			}
		});
		addStudentMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		menu_1.add(addStudentMenuItem);
		
		JMenuItem menuItem_3 = new JMenuItem("\u81EA\u7531\u804C\u4E1A\u8005\u5217\u8868");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkerManageFrm workerManageFrm = new WorkerManageFrm();
				workerManageFrm.setVisible(true);
				desktopPane.add(workerManageFrm);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5B66\u751F.png")));
		menu_1.add(menuItem_3);
		
		manageTeacherMenu = new JMenu("\u5BA2\u6237\u4FE1\u606F");
		manageTeacherMenu.setSelectedIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6559\u5E08\u4FE1\u606F.png")));
		manageTeacherMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5BA2\u6237.png")));
		menuBar.add(manageTeacherMenu);
		
		JMenuItem menuItem_8 = new JMenuItem("\u5BA2\u6237\u5217\u8868");
		menuItem_8.setSelectedIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6559\u5E08\u5217\u8868.png")));
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerManageFrm customerManageFrm = new CustomerManageFrm();
				customerManageFrm.setVisible(true);
				desktopPane.add(customerManageFrm);
			}
		});
		menuItem_8.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6559\u5E08\u5217\u8868.png")));
		manageTeacherMenu.add(menuItem_8);
		
		JMenu manageTeacherMenu_1 = new JMenu("\u9879\u76EE\u5206\u53D1\u4FE1\u606F");
		manageTeacherMenu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u9879\u76EE\u4FE1\u606F.png")));
		menuBar.add(manageTeacherMenu_1);
		
		JMenuItem menuItem_8_1 = new JMenuItem("\u5206\u53D1\u7BA1\u7406");
		menuItem_8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Project_WorkerFrm project_WorkerFrm=new Project_WorkerFrm();
				project_WorkerFrm.setVisible(true);
				desktopPane.add(project_WorkerFrm);
			}
		});
		menuItem_8_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5206\u914D.png")));
		manageTeacherMenu_1.add(menuItem_8_1);
		
		courseMenu = new JMenu("\u65F6\u95F4\u8868\u7BA1\u7406");
		courseMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u65F6\u95F4\u8868(1).png")));
		menuBar.add(courseMenu);
		
		JMenuItem addCourseMenuItem = new JMenuItem("\u6DFB\u52A0\u65F6\u95F4\u8868");
		addCourseMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddScheduleFrm addScheduleFrm = new AddScheduleFrm();
				addScheduleFrm.setVisible(true);
				desktopPane.add(addScheduleFrm);
			}
		});
		addCourseMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		courseMenu.add(addCourseMenuItem);
		
		JMenuItem courseListMenuItem = new JMenuItem("\u65F6\u95F4\u5217\u8868");
		courseListMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ScheduleManageFrm scheduleManageFrm = new ScheduleManageFrm();
				scheduleManageFrm.setVisible(true);
				desktopPane.add(scheduleManageFrm);
			}
		});
		courseListMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u8BFE\u7A0B\u8868.png")));
		courseMenu.add(courseListMenuItem);
		
		JMenu menu_5 = new JMenu("\u9879\u76EE\u7BA1\u7406");
		menu_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u9879\u76EE\u7BA1\u7406(1).png")));
		menuBar.add(menu_5);
		
		manageScoreMenuItem = new JMenuItem("\u9879\u76EE\u4FEE\u6539");
		manageScoreMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProjectManageFrm projectManageFrm = new ProjectManageFrm();
				projectManageFrm.setVisible(true);
				desktopPane.add(projectManageFrm);
			}
		});
		
		addScoreMenuItem = new JMenuItem("\u65B0\u589E\u9879\u76EE");
		addScoreMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddProjectFrm addProjectFrm = new AddProjectFrm();
				addProjectFrm.setVisible(true);
				desktopPane.add(addProjectFrm);
			}
		});
		addScoreMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u9879\u76EE.png")));
		menu_5.add(addScoreMenuItem);
		manageScoreMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u9879\u76EE\u4FEE\u6539.png")));
		menu_5.add(manageScoreMenuItem);
		
		JMenu menu = new JMenu("\u7528\u6237\u4FE1\u606F");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u7528\u6237\u4FE1\u606F.png")));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editPassword(ae);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		menu.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane);
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 912, Short.MAX_VALUE)
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 667, Short.MAX_VALUE)
		);
		desktopPane.setLayout(gl_desktopPane);
		setLocationRelativeTo(null);
		setAuthority();
	}

	protected void editPassword(ActionEvent ae) {
		// TODO Auto-generated method stub
		EditPasswordFrm editPasswordFrm = new EditPasswordFrm();
		editPasswordFrm.setVisible(true);
		desktopPane.add(editPasswordFrm);
	}
	private void setAuthority(){
		if("自由职业者".equals(userType.getName())){
			addStudentMenuItem.setEnabled(false);
//			manageClassMenu.setEnabled(false);
//			manageTeacherMenu.setEnabled(false);
//			courseMenu.setEnabled(false);
//			addScoreMenuItem.setEnabled(false);
//			viewScoreMenuItem.setEnabled(true);
//			manageScoreMenuItem.setEnabled(false);
		}
		if("客户".equals(userType.getName())){
			addStudentMenuItem.setEnabled(false);
//			manageClassMenu.setEnabled(false);
//			manageTeacherMenu.setEnabled(false);
//			courseMenu.setEnabled(false);
//			addScoreMenuItem.setEnabled(false);
//			viewScoreMenuItem.setEnabled(true);
//			manageScoreMenuItem.setEnabled(false);
		}
	}
}
