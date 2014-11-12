
// Abdullah AL-Sinaidi
package combo_box;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class combo_box {

		
	HashMap<Integer, String> MONTHS = new HashMap();
	
	/*public static  String[] MONTHS = {"January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November",
        "December"};
        */
	public static  String[] DAYS = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", 
  "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	public static  int[] YEARS = {2009,2010,2011,2012,2013,2014,2015, 2016, 2017, 2018, 2019};
	
	
	
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					combo_box window = new combo_box();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public combo_box() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Scanner int_ints= new Scanner(System.in);
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		MONTHS.put(1, "January");
		MONTHS.put(2, "February");
		MONTHS.put(3, "March");
		MONTHS.put(4, "April");
		MONTHS.put(5, "May");
		MONTHS.put(6, "June");
		MONTHS.put(7, "July");
		MONTHS.put(8, "August");
		MONTHS.put(9, "September");
		MONTHS.put(10, "October");
		MONTHS.put(11, "November");
		MONTHS.put(12, "December");

		Calendar now= Calendar.getInstance();
		int month= now.get(Calendar.MONTH)+1;
		int day= now.get(Calendar.DATE);
		final int year= now.get(Calendar.YEAR);
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		
		
		for(int i=1; i<MONTHS.size()+1; i++){
		System.out.println(MONTHS.get(i));
		}
		
		final JComboBox comboBox = new JComboBox();
		
	
		
		comboBox.setBounds(167, 54, 120, 20);
		frame.getContentPane().add(comboBox);
		for(int i=1; i<MONTHS.size()+1; i++){
			comboBox.addItem(MONTHS.get(i));
		//comboBox.addItem(MONTHS[0]);
		}

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(167, 106, 60, 20);
		frame.getContentPane().add(comboBox_1);
		for (int i=0; i<DAYS.length; i++){
			comboBox_1.addItem(DAYS[i]);
		}
		
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(167, 158, 90, 20);
		frame.getContentPane().add(comboBox_2);
		for (int i=0; i<YEARS.length; i++){
			comboBox_2.addItem(YEARS[i]);
		}
		
	for (int i=1; i<MONTHS.size()+1;i++){
		if (month== i){
			comboBox.setSelectedItem(MONTHS.get(i));
		}
	}
	
	for (int i=0; i<DAYS.length;i++){
		if (day== i){
			comboBox_1.setSelectedItem(DAYS[i-1]);
		}
	}

	
	for (int i=0; i<YEARS.length;i++){
		if (year== YEARS[i]  ){
			comboBox_2.setSelectedItem(YEARS[i]);
		}
	}
	
	
	
	
		
		comboBox.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            Object choosen = comboBox.getSelectedItem();
            
            if (choosen.toString()=="November" || choosen.toString()=="September" || choosen.toString()=="June"
                    || choosen.toString()=="April"){
                    comboBox_1.removeAllItems();
                    for (int x=0; x<DAYS.length -1;x++){
                    	comboBox_1.addItem(DAYS[x]);
                    }
                    }
                  
                            
                    else if (choosen.toString()=="January" || choosen.toString()=="March" || choosen.toString()=="May"
                    || choosen.toString()=="July"  || choosen.toString()=="August"  || choosen.toString()=="October"
                    || choosen.toString()=="December"){
                                   comboBox_1.removeAllItems();
                                    for (int x=0; x<DAYS.length;x++){
                                    	comboBox_1.addItem(DAYS[x]);
                                    }}  
         // checking the leap year
             else if((year % 4 == 0) && year % 100 != 0){
        		if(choosen.toString()=="February" ){
                    comboBox_1.removeAllItems();
                    for (int x=0; x<DAYS.length -2;x++){
                    	comboBox_1.addItem(DAYS[x]);
            }}}
            else if ((year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0))
            {
            	if(choosen.toString()=="February" ){
                    comboBox_1.removeAllItems();
                    for (int x=0; x<DAYS.length -2;x++){
                    	comboBox_1.addItem(DAYS[x]);	
        
            }}}
            else 
            {

                      comboBox_1.removeAllItems();
                      for (int x=0; x<DAYS.length -3;x++){
                      	comboBox_1.addItem(DAYS[x]);
                      }}
            
            } });      		
		
		
		
		// just labels
		JLabel lblmonth = new JLabel("Month");
		lblmonth.setBounds(111, 57, 46, 14);
		frame.getContentPane().add(lblmonth);
		
		JLabel lblyear = new JLabel("Year");
		lblyear.setBounds(111, 161, 46, 14);
		frame.getContentPane().add(lblyear);
		
		JLabel lblday = new JLabel("Day");
		lblday.setBounds(111, 109, 46, 14);
		frame.getContentPane().add(lblday);
	}
             }
