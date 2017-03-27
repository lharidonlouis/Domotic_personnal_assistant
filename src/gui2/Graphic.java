package gui2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import counters.CyclicCounter;
import map.MapInit;
import objects.Chat;
import objects.Clock;
import objects.DbSetter;
import objects.Obj;
import objects.User;


public class Graphic extends MapInit implements DbSetter , ActionListener, Runnable{
	User usr = User.getInstance();;
	public Map map;
	private Clock clock;

	JFrame window = new JFrame() ;
	JPanel chat = new Chat() ; 
	JPanel action = new JPanel() ;
	JPanel home = new JPanel() ;
	JPanel clk = new JPanel();
	JPanel addremove = new JPanel() ;
	JPanel dashboard = new JPanel() ;
	JPanel panGrid= new JPanel( new GridLayout(50,50)) ;


	private static final int CHRONO_SPEED = 10;

	private static final long serialVersionUID = 1L;


	private JButton startButton = new JButton(" Start ");
	private JButton clearButton = new JButton(" Clear ");

	private JLabel weekLabel = new JLabel("week:");
	private JLabel dayLabel = new JLabel("Day:");
	private JLabel hourLabel = new JLabel("Hour:");
	private JLabel minuteLabel = new JLabel("Minute:");
	private boolean stop = true;
	private Graphic instance = this;


	private JLabel weekValue = new JLabel("");
	private JLabel dayValue = new JLabel("");
	private JLabel hourValue = new JLabel("");
	private JLabel minuteValue = new JLabel("");

	private JPanel control = new JPanel();
	private JPanel controlButton = new JPanel();
	
	JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	JTabbedPane tabs = new JTabbedPane(SwingConstants.TOP);
	
	String[] of = {" "};
	JComboBox state = new JComboBox();
	JComboBox  piece = new JComboBox();
	JButton validate = new JButton(" Validate ");

	public  void window(){
		 		
		
		split.setDividerLocation(800);
		
		window.setTitle("Hello, My Name is Home") ;
		window.setSize(1200,780);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// panels size
		
		panGrid.setSize(800, 760);
		dashboard.setSize(400, 760);
		
		// background color

		panGrid.setBackground(Color.decode("#4B77BE"));
		dashboard.setBackground(Color.decode("#4B77BE"));
		clk.setBackground(Color.decode("#4B77BE"));
		action.setBackground(Color.decode("#4B77BE"));
		addremove.setBackground(Color.decode("#4B77BE"));
		home.setBackground(Color.decode("#4B77BE"));
		
		
		JPanel tabPanel[][] = new JPanel[50][50] ; 
		
		// Create grid display

		initMap() ;
		for (int index1=0 ; index1<50; index1++ ){
			for (int index2=0 ; index2<50; index2++ ){
				if (tab[index1][index2] == 1) {
					JPanel wall = new JPanel() ;
					wall.setBackground(Color.white);
					panGrid.add(wall);
				}
				else if (tab[index1][index2] == 2) {
					JPanel wall = new JPanel() ;
					wall.setBackground(Color.red);
					panGrid.add(wall);
				}
				else {
					JPanel j = new JPanel() ;
					j.setBorder(BorderFactory.createLineBorder(Color.white));
					j.setBackground(Color.decode("#4B77BE"));
					panGrid.add(j) ;
				}
				
			}
		}
		
		for (int index1=0 ; index1<50; index1++ ){
			for (int index2=0 ; index2<50; index2++ ){
					//System.out.println(tab[index1][index2]);
			}
		}
		
		String test12 =  map.get("fridge").toString();
		JLabel test23 = new JLabel(test12);
		
		piece = new JComboBox(map.keySet().toArray(new String[map.keySet().size()]));
		state = new JComboBox(of);

		piece.addActionListener(new ItemAction()) ;
		validate.addActionListener(new ItemAction2());
		
		action.add(state);
		action.add(piece);
		action.add(validate);
		
		// create tabs
		 
		tabs.addTab("Home.", home);
		tabs.addTab("Add/Remove",addremove);  
		tabs.addTab("Actions", action);
		tabs.addTab("Clock", clk);

		tabs.setOpaque(false);
		   
		dashboard.add(tabs);
		home.add(chat);
		chat.setBackground(Color.decode("#4B77BE"));
		
		
		clk.add(init());
		
		//window add
		window.getContentPane().add(dashboard);    
		
		split.add(panGrid) ;
		split.add(dashboard);
		
		window.add(split) ;
		window.setVisible(true);
	}
		
	class ItemAction implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	      //System.out.println("State : " + state.getSelectedItem() + piece.getSelectedItem());
	    	HashMap<String, String> acts = ((Obj) map.get(piece.getSelectedItem())).getActMap();
	    	of =  acts.keySet().toArray(new String[acts.keySet().size()]);
	    	state.removeAllItems();
	    	state.addItem(" ");
	    	for (String item : of) {
	    		state.addItem(item);
	    	}
	    	state.setSelectedItem(" ");
	    }               
	  }
	
	class ItemAction2 implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	usr.act(state.getSelectedItem().toString(), piece.getSelectedItem().toString());
	    }               
	  }
	
	private Container init() {
		updateValues();

		Container contentPane = new Container();
		contentPane.setLayout(new BorderLayout());
		control.setLayout(new FlowLayout());
		controlButton.setLayout(new FlowLayout());
		
		control.setBackground(Color.decode("#4B77BE"));
		controlButton.setBackground(Color.decode("#4B77BE"));
		
		weekLabel.setForeground(Color.white);
		weekValue.setForeground(Color.white);
		control.add(weekLabel);
		control.add((weekValue));
		
		dayLabel.setForeground(Color.white);
		dayValue.setForeground(Color.white);
		control.add(dayLabel);
		control.add(dayValue);
		
		
		hourLabel.setForeground(Color.white);
		hourValue.setForeground(Color.white);
		control.add(hourLabel);
		control.add(hourValue);

		minuteLabel.setForeground(Color.white);
		minuteValue.setForeground(Color.white);
		control.add(minuteLabel);
		control.add(minuteValue) ;

		startButton.addActionListener(new StartStopAction());
		controlButton.add(startButton);

		clearButton.addActionListener(new ClearAction());
		controlButton.add(clearButton);
		control.setForeground(Color.white);

		contentPane.add(BorderLayout.NORTH, control);
		contentPane.add(controlButton);
		
		return contentPane;
	}
	
	private void updateValues() {
		// This part is for textual time printing.
		CyclicCounter week = clock.getWeek();
		weekValue.setText(week.toString() + " ");

		CyclicCounter day = clock.getDay();
		dayValue.setText(day.toString() + " ");
		
		CyclicCounter hour = clock.getHour();
		hourValue.setText(hour.toString() + " ");

		CyclicCounter minute = clock.getMinute();
		minuteValue.setText(minute.toString() + " ");


	}
	
	
	public void run() {
		while (!stop) {
			try {
				Thread.sleep(CHRONO_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			clock.increment();
			updateValues();
		}
	}

	private class StartStopAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!stop) {
				stop = true;
				startButton.setText(" Start ");
			} else {
				stop = false;
				startButton.setText(" Pause ");
				Thread chronoThread = new Thread(instance);
				chronoThread.start();
			}
		}
	}

	private class ClearAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stop = true;
			startButton.setText(" Start ");
			clock.init();
			updateValues();
		}

	}

	
	@Override
	public void setMap(Map map) {
		this.map = map;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void setClock(Clock clock) {
		this.clock = clock;
	}	
}