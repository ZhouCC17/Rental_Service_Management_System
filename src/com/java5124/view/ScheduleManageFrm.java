package com.java5124.view;

import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.java5124.dao.ScheduleDao;
import com.java5124.dao.TypeDao;
import com.java5124.dao.WorkerDao;
import com.java5124.model.Project;
import com.java5124.model.Schedule;
import com.java5124.model.Type;
import com.java5124.model.Worker;
import com.java5124.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ScheduleManageFrm extends JInternalFrame {
	private JTextField timeCoreTextField;
	private JTable timeListTable;
	private JTextField workCoreField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheduleManageFrm frame = new ScheduleManageFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ScheduleManageFrm() {
		setTitle("\u65F6\u95F4\u8868\u7BA1\u7406");
		setBounds(100, 100, 819, 704);
		setClosable(true);
		setIconifiable(true);
		JLabel label = new JLabel("\u65F6\u95F4\u8868\u7F16\u53F7\uFF1A");
		label.setIcon(new ImageIcon(ScheduleManageFrm.class.getResource("/images/\u65F6\u95F4\u8868(1).png")));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		timeCoreTextField = new JTextField();
		timeCoreTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5DE5\u53F7\uFF1A");
		label_1.setIcon(new ImageIcon(ScheduleManageFrm.class.getResource("/images/\u6559\u5E08\u4FE1\u606F.png")));
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				searchSchedule(ae);
			}
		});
		searchButton.setIcon(new ImageIcon(ScheduleManageFrm.class.getResource("/images/\u67E5\u8BE2.png")));
		searchButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		workCoreField = new JTextField();
		workCoreField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(73)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(timeCoreTextField, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(43)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(workCoreField, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(63)
							.addComponent(searchButton)
							.addGap(93))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
							.addGap(58))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(71)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(timeCoreTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(searchButton)
						.addComponent(workCoreField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(318, Short.MAX_VALUE))
		);
		
		timeListTable = new JTable();
		timeListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
			}
		});
		timeListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u65F6\u95F4\u8868\u7F16\u53F7", "\u5DE5\u53F7", "\u65F6\u95F4\u8868\u5185\u5BB9"
			}
		));
		scrollPane.setViewportView(timeListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new Schedule());
	}

//	protected void selectedCourse(MouseEvent me) {
//		// TODO Auto-generated method stub
//		int row = timeListTable.getSelectedRow();
//		String couseName = timeListTable.getValueAt(row, 1).toString();
//		int teacher_id = getTeacherIdByName(timeListTable.getValueAt(row, 2).toString());
//		int max_student_num = Integer.parseInt(timeListTable.getValueAt(row, 3).toString());
//		String couseInfo = timeListTable.getValueAt(row, 5).toString();
//		editCourseTextField.setText(couseName);
//		editCourseStudentNumTextField.setText(max_student_num+"");
//		editCourseInfoTextArea.setText(couseInfo);
//		for(int i=0;i<editCourseTeachComboBox.getItemCount();i++){
//			Teacher t = (Teacher) editCourseTeachComboBox.getItemAt(i);
//			if(t.getTno() == teacher_id){
//				editCourseTeachComboBox.setSelectedIndex(i);
//				break;
//			}
//		}
//	}
//
//	protected void searchSchedule(ActionEvent ae) {
//		// TODO Auto-generated method stub
//		StringUtil st=new StringUtil();
//		if(timeCoreTextField==null) {
//			JOptionPane.showMessageDialog(this, "ÇëÊäÈëÊ±¼ä±í±àºÅ£¡");
//		}
//		else if(searchTeacherComboBox.getSelectedItem()!=null&&timeCoreTextField==null) { 
//			Teacher teacher = (Teacher) searchTeacherComboBox.getSelectedItem();
//			course.setTno(teacher.getTno());
//		}
//			else if(searchTeacherComboBox.getSelectedItem()==null&&timeCoreTextField!=null) {
//				String searchCourseName = timeCoreTextField.getText().toString();
//				course.setCname(searchCourseName);
//			}
//			else { 
//		Teacher teacher = (Teacher) searchTeacherComboBox.getSelectedItem();
//		String searchCourseName = timeCoreTextField.getText().toString();
//		course.setCname(searchCourseName);
//		course.setTno(teacher.getTno());
//			}
//		setCourseListTable(course);
//	}
//
//	private void setCourseListTable(Viewtc vtc){
//		ViewtcDao vtcDao = new ViewtcDao();
//		List<Viewtc> courseList = vtcDao.getCourseList(vtc);
//		DefaultTableModel dft = (DefaultTableModel) timeListTable.getModel();
//		dft.setRowCount(0);
//		for (Viewtc c : courseList) {
//			Vector v = new Vector();
//			v.add(c.getCno());
//			v.add(c.getCname());
//			v.add(getTeacherNameById(c.getTno()));
//			v.add(c.getMax_student_num());
//			v.add(c.getSelected_num());
//			v.add(c.getC_info());
//			dft.addRow(v);
//		}
//		vtcDao.closeDao();
//	}
	protected void searchSchedule(ActionEvent ae) {
		// TODO Auto-generated method stub
		Schedule schedule = new Schedule();
		if(timeCoreTextField.getText()!=null&&workCoreField.getText()!=null) {
			schedule.setSid(Integer.parseInt(timeCoreTextField.getText().toString()));
			schedule.setWid(Integer.parseInt(workCoreField.getText().toString()));
		}else {
			schedule.setSid(0);
			schedule.setWid(0);
		}
		setTable(schedule);
	}
	private void setTable(Schedule schedule){
		DefaultTableModel dft = (DefaultTableModel) timeListTable.getModel();
		ScheduleDao scheduleDao = new ScheduleDao();
		List<Schedule> scheduleList = scheduleDao.getScheduleList(schedule);
		for (Schedule s : scheduleList) {
			Vector v = new Vector();
			v.add(s.getSid());
			v.add(s.getWid());
			v.add(s.getScontent());
			dft.addRow(v);
		}
		scheduleDao.closeDao();
	}


}
