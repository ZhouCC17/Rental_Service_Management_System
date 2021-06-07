package com.java5124.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.java5124.dao.ProjectDao;
import com.java5124.dao.Project_WorkerDao;
import com.java5124.dao.WorkerDao;
import com.java5124.model.Project;
import com.java5124.model.Project_Worker;
import com.java5124.model.Worker;

import javax.swing.border.EtchedBorder;
import java.awt.Color;


public class Project_WorkerFrm extends JInternalFrame {
	private JTable project_WorkerListTable;
	private JComboBox searchCourseComboBox;
	private JComboBox searchStudentComboBox;
	private JComboBox editSelectedStudentComboBox;
	private JComboBox editSelectedCourseComboBox;
	private List<Worker> workerlist = new ArrayList<Worker>();
	private List<Project> projectList = new ArrayList<Project>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project_WorkerFrm frame = new Project_WorkerFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Project_WorkerFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u5206\u53D1\u7BA1\u7406");
		setBounds(100, 100, 669, 562);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(Project_WorkerFrm.class.getResource("/images/\u5F53\u524D\u7528\u6237.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchStudentComboBox = new JComboBox();
		searchStudentComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				studentChangeAct(ie);
			}
		});
		
		JLabel label_1 = new JLabel("\u9879\u76EE\u540D\u79F0\uFF1A");
		label_1.setIcon(new ImageIcon(Project_WorkerFrm.class.getResource("/images/\u9879\u76EE\u4FEE\u6539.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchCourseComboBox = new JComboBox();
		
		JButton confirmSelectedButton = new JButton("\u786E\u8BA4\u63A5\u53D7");
		confirmSelectedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				confirmSelectedProject(ae);
			}
		});
		confirmSelectedButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		confirmSelectedButton.setIcon(new ImageIcon(Project_WorkerFrm.class.getResource("/images/\u786E\u8BA4.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u4FEE\u6539\u9879\u76EE\u5206\u53D1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(label)
							.addGap(2)
							.addComponent(searchStudentComboBox, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(label_1)
							.addGap(12)
							.addComponent(searchCourseComboBox, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(confirmSelectedButton)))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addComponent(searchStudentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addComponent(label_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(searchCourseComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addComponent(confirmSelectedButton)))
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(55, Short.MAX_VALUE))
		);
		
		project_WorkerListTable = new JTable();
		project_WorkerListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectedProject(me);
			}
		});
		project_WorkerListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u9879\u76EE\u53F7", "\u63A5\u6536\u8005\u5DE5\u53F7", "\u9879\u76EE\u540D\u79F0", "\u63A5\u6536\u8005\u540D\u79F0"
			}
		));
		scrollPane.setViewportView(project_WorkerListTable);
		
		JLabel label_2 = new JLabel("\u63A5\u6536\u8005\u59D3\u540D\uFF1A");
		label_2.setIcon(new ImageIcon(Project_WorkerFrm.class.getResource("/images/\u5F53\u524D\u7528\u6237.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editSelectedStudentComboBox = new JComboBox();
		
		JLabel label_3 = new JLabel("\u9879\u76EE\u540D\u79F0\uFF1A");
		label_3.setIcon(new ImageIcon(Project_WorkerFrm.class.getResource("/images/\u9879\u76EE\u4FEE\u6539.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editSelectedCourseComboBox = new JComboBox();
		
		JButton confirmEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		confirmEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editSelectProjectAct(ae);
			}
		});
		confirmEditButton.setIcon(new ImageIcon(Project_WorkerFrm.class.getResource("/images/\u786E\u8BA4.png")));
		confirmEditButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton deleteCourseButton = new JButton("\u9000\u9009\u9879\u76EE");
		deleteCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteP_W(ae);
			}
		});
		deleteCourseButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		deleteCourseButton.setIcon(new ImageIcon(Project_WorkerFrm.class.getResource("/images/\u91CD\u7F6E(1).png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_2)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(editSelectedStudentComboBox, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addComponent(label_3))
						.addComponent(deleteCourseButton))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(editSelectedCourseComboBox, 0, 204, Short.MAX_VALUE)
						.addComponent(confirmEditButton))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(editSelectedStudentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(editSelectedCourseComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(deleteCourseButton)
						.addComponent(confirmEditButton))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		setWorkerCombox();
		setProjectCombox();
		initTable();
		setAuthority();
	}
	protected void deleteP_W(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = project_WorkerListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选择要修改的数据！");
			return;
		}
		int pid = Integer.parseInt(project_WorkerListTable.getValueAt(row, 0).toString());
		int wid = Integer.parseInt(project_WorkerListTable.getValueAt(row, 1).toString());
		Project_Worker pw = new Project_Worker();
		pw.setPid(pid);
		pw.setWid(wid);
		Project_WorkerDao pwDao = new Project_WorkerDao();
		if(pwDao.delete(pid,wid)){
			JOptionPane.showMessageDialog(this, "取消成功！");
		}else{
			JOptionPane.showMessageDialog(this, "取消失败！");
		}
		pwDao.closeDao();
		initTable();
	}

	protected void editSelectProjectAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = project_WorkerListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选择要修改的数据！");
			return;
		}
		int pid = Integer.parseInt(project_WorkerListTable.getValueAt(row, 0).toString());
		int wid = Integer.parseInt(project_WorkerListTable.getValueAt(row, 1).toString());
		String pName = project_WorkerListTable.getValueAt(row, 2).toString();
		String wName = project_WorkerListTable.getValueAt(row, 3).toString();
		Worker worker = (Worker) editSelectedStudentComboBox.getSelectedItem();
		Project project = (Project) editSelectedCourseComboBox.getSelectedItem();
		if(pName.equals(worker.getWname())&&wName.equals(project.getPcontent())){
			JOptionPane.showMessageDialog(this, "项目数据未修改！");
			return;
		}
		
		Project_Worker sc = new Project_Worker();
//		sc.setPid(pid);
//		sc.setWid(wid);
		sc.setWnameString(worker.getWname());
		sc.setPname(project.getPcontent());
		Project_WorkerDao pwDao = new Project_WorkerDao();
		if(pwDao.isSelected(sc)){
			JOptionPane.showMessageDialog(this, "已经接收了此项目，不能再选!");
			return;
		}
		Project_Worker s = new Project_Worker();
		s.setWnameString(worker.getWname());
		s.setPname(project.getPcontent());
		s.setWid(worker.getWid());
		s.setPid(project.getPid());
		if(pwDao.updatePw(s,pid,wid)){
					JOptionPane.showMessageDialog(this, "修改成功！!");
			}else{
				JOptionPane.showMessageDialog(this, "项目信息更新失败!");
			}
	    pwDao.closeDao();
		initTable();
	}

	protected void selectedProject(MouseEvent me) {
		// TODO Auto-generated method stub
		int row = project_WorkerListTable.getSelectedRow();
		String workerName = project_WorkerListTable.getValueAt(row, 2).toString();
		String projectName = project_WorkerListTable.getValueAt(row, 3).toString();
		for (int i = 0; i < editSelectedStudentComboBox.getItemCount();i++) {
			Worker worker = (Worker) editSelectedStudentComboBox.getItemAt(i);
			if(workerName.equals(worker.getWname())){
				editSelectedStudentComboBox.setSelectedIndex(i);
				break;
			}
		}
		for (int i = 0; i < editSelectedCourseComboBox.getItemCount();i++) {
			Project project = (Project) editSelectedCourseComboBox.getItemAt(i);
			if(projectName.equals(project.getPcontent())){
				editSelectedCourseComboBox.setSelectedIndex(i);
				break;
			}
		}
	}

	protected void studentChangeAct(ItemEvent ie) {
		// TODO Auto-generated method stub
		if(ie.getStateChange() == ItemEvent.SELECTED){
			initTable();
		}
	}

	protected void confirmSelectedProject(ActionEvent ae) {
		// TODO Auto-generated method stub
		Worker worker = (Worker) searchStudentComboBox.getSelectedItem();
		Project project = (Project) searchCourseComboBox.getSelectedItem();
		Project_Worker sc = new Project_Worker();
		sc.setWid(worker.getWid());
		sc.setPid(project.getPid());
		sc.setPname(searchCourseComboBox.getSelectedItem().toString());
		sc.setWnameString(searchStudentComboBox.getSelectedItem().toString());
		Project_WorkerDao scDao = new Project_WorkerDao();
		if(scDao.isSelected(sc)){
			JOptionPane.showMessageDialog(this, "已经接收了此项目，不能再选!");
			return;
		}
		if(scDao.addSelectedProject(sc)){
		    JOptionPane.showMessageDialog(this, "接收成功！!");
		}else{
			JOptionPane.showMessageDialog(this, "接收失败!");
		}
		scDao.closeDao();
		initTable();
	}

	private void setWorkerCombox(){
		WorkerDao workerDao = new WorkerDao();
		workerlist = workerDao.getWorkerList(new Worker());
		workerDao.closeDao();
		for (Worker worker : workerlist) {
			searchStudentComboBox.addItem(worker);
			editSelectedStudentComboBox.addItem(worker);
		}
		if("自由职业者".equals(MainFrm.userType.getName())){
			Worker user = (Worker) MainFrm.userObject;
			for(int i = 0; i < searchStudentComboBox.getItemCount();i++){
				Worker workers = (Worker) searchStudentComboBox.getItemAt(i);
				if(workers.getWid() == user.getWid()){
					searchStudentComboBox.setSelectedIndex(i);
					editSelectedStudentComboBox.setSelectedIndex(i);
					break;
				}
			}
		}
	}
	private void setProjectCombox(){
		ProjectDao projectDao = new ProjectDao();
		projectList = projectDao.getProjectList(new Project());
		projectDao.closeDao();
		for (Project project : projectList) {
			searchCourseComboBox.addItem(project);
			editSelectedCourseComboBox.addItem(project);
		}
	}
	private void getSelectedProject(Project_Worker pw){
		Project_WorkerDao selectedProjectDao = new Project_WorkerDao();
		List<Project_Worker> selectedCourseList = selectedProjectDao.getSelectedProjectList(pw);
		DefaultTableModel dft = (DefaultTableModel) project_WorkerListTable.getModel();
		dft.setRowCount(0);
		for (Project_Worker sc : selectedCourseList) {
			Vector v = new Vector();
			v.add(sc.getPid());
			v.add(sc.getWid());
			v.add(sc.getPname());
			v.add(sc.getWnameString());
			dft.addRow(v);
		}
		selectedProjectDao.closeDao();
	}
	private void initTable(){
		Worker worker = (Worker) searchStudentComboBox.getSelectedItem();
		Project_Worker sc = new Project_Worker();
		sc.setWid(worker.getWid());
		getSelectedProject(sc);
	}

	private void setAuthority(){
		if("自由职业者".equals(MainFrm.userType.getName())){
//			searchStudentComboBox.setEnabled(false);
//			editSelectedStudentComboBox.setEnabled(false);
		}
	}
}
