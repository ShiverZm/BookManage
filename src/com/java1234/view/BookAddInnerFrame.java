package com.java1234.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.java1234.dao.BookDao;
import com.java1234.dao.BookTypeDao;
import com.java1234.model.Book;
import com.java1234.model.BookType;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class BookAddInnerFrame extends JInternalFrame {
	private JTextField bookNameTxt;
	private JTextField authorTxt;
	private JTextField priceTxt;
	private JTextArea bookDescTxt;
	private JRadioButton womanRb;
	private JRadioButton manRb;
	private JComboBox bookTypeJcb;
	
	private DbUtil dbUtil=new DbUtil();
    private BookDao bookDao=new BookDao();
    private BookTypeDao bookTypeDao=new BookTypeDao();
    private final ButtonGroup buttonGroup = new ButtonGroup();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInnerFrame frame = new BookAddInnerFrame();
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
	public BookAddInnerFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u6DFB\u52A0");
		setBounds(100, 100, 655, 536);
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0:");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005:");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u4F5C\u8005\u6027\u522B:");
		
		 manRb = new JRadioButton("\u7537");
		 buttonGroup.add(manRb);
		
		 womanRb = new JRadioButton("\u5973");
		 buttonGroup.add(womanRb);
		
		JLabel label_3 = new JLabel("\u56FE\u4E66\u4EF7\u683C:");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u56FE\u4E66\u7C7B\u522B:");
		
		bookTypeJcb = new JComboBox();
		
		JLabel label_5 = new JLabel("\u56FE\u4E66\u63CF\u8FF0:");
		
		bookDescTxt = new JTextArea();
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookAddActionPerformed(arg0);
			}
		});
		button.setIcon(new ImageIcon(BookAddInnerFrame.class.getResource("/images/add.png")));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		
		button_1.setIcon(new ImageIcon(BookAddInnerFrame.class.getResource("/images/reset.png")));
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(68)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_1))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label_5)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(bookDescTxt))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label_4)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_2)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(manRb)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(womanRb)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_3)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(priceTxt))))))
					.addContainerGap(121, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(manRb)
						.addComponent(womanRb)
						.addComponent(label_3)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(60))
		);
		getContentPane().setLayout(groupLayout);
		this.bookDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
		this.fillBookType();
	}
	
	/**
	 * 图书添加事件处理
	 * @param evt
	 */
	private void bookAddActionPerformed(ActionEvent evt) {
		String bookName=bookNameTxt.getText();
		String author=authorTxt.getText();
		String price=priceTxt.getText();
		String bookDesc=this.bookDescTxt.getText();
		
		if(StringUtil.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "图书名称不能为空");
		}if(StringUtil.isEmpty(author)) {
			JOptionPane.showMessageDialog(null, "作者不能为空");
		}if(StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "价格不能为空");
		}
		String sex="";
		if(manRb.isSelected()) {
			sex="男";
		}else if(womanRb.isSelected()) {
			sex="女";
		}
		BookType bookType=(BookType)bookTypeJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		Book b=new Book(bookName, author, sex, Float.parseFloat(price), bookDesc, bookTypeId);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int add=bookDao.add(con, b);
			if(add==1) {
				JOptionPane.showMessageDialog(null, "图书添加成功");
				resetValue();
			}else {
				System.out.println(b);
				JOptionPane.showMessageDialog(null, "图书添加失败");
			}
			
		} catch (Exception e) {
			System.out.println(b);
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书添加失败");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 重置表单
	 */
	public void resetValue() {
		 bookNameTxt.setText("");;
		authorTxt.setText("");;
		 priceTxt.setText("");;
		bookDescTxt.setText("");;
		 womanRb.setText("");;
		 manRb.setText("");;
		if(this.bookTypeJcb.getItemCount()>0) {
			this.bookTypeJcb.setSelectedIndex(0);
		}
	}
	
	/**
	 * 初始化图书类别下拉框
	 */
	private void fillBookType() {
		BookType bookType=null;
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=bookTypeDao.list(con,new BookType());
			while(rs.next()) {
				BookType bt=new BookType();
				bt.setId(rs.getInt("id"));
				bt.setBookTypeName(rs.getString("BookTypeName"));
				this.bookTypeJcb.addItem(bt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
