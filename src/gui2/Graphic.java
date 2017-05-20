package gui2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.opencsv.CSVReader;

import counters.Clock;
import counters.CyclicCounter;
import map.MapInit;
import objects.DbSetter;
import objects.Home;
import objects.Obj;
import objects.User;

public class Graphic extends MapInit implements DbSetter, ActionListener, Runnable {
	User usr = User.getInstance();
	Home hme = Home.getInstance();

	public Map map;
	private Clock clock;

	JFrame window = new JFrame();
	JPanel action = new JPanel();
	JPanel home = new JPanel();
	JPanel clk = new JPanel();
	JPanel chat = new Chat();
	JPanel addremove = new JPanel();
	JPanel dashboard = new JPanel();
	JPanel panGrid = new JPanel(new GridLayout(50, 50));

	private static final int CHRONO_SPEED = 500;

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

	String[] of = { " " };
	JComboBox state = new JComboBox();
	JComboBox piece = new JComboBox();
	JButton validate = new JButton(" Validate ");

	private Color border;

	public void window() {

		split.setDividerLocation(800);

		window.setTitle("Hello, My Name is Home");
		window.setSize(1200, 780);
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

		border = Color.decode("#4B77BE");

		// Create grid display
		initMap();

		piece = new JComboBox(map.keySet().toArray(new String[map.keySet().size()]));
		HashMap<String, String> acts = ((Obj) map.get(piece.getSelectedItem())).getActMap();
		state = new JComboBox(acts.keySet().toArray(new String[acts.keySet().size()]));

		piece.addActionListener(new ItemAction());
		validate.addActionListener(new ItemAction2());

		action.add(state);
		action.add(piece);
		action.add(validate);

		// create tabs

		tabs.addTab("Home.", home);
		tabs.addTab("Add/Remove", addremove);
		tabs.addTab("Actions", action);
		tabs.addTab("Clock", clk);
		tabs.addChangeListener(new ChangePanListener());

		tabs.setOpaque(false);

		dashboard.add(tabs);

		// chat = new Chat();
		home.add(chat);
		chat.setBackground(Color.decode("#4B77BE"));

		clk.add(init());

		// window add
		window.getContentPane().add(dashboard);

		split.add(panGrid);
		split.add(dashboard);

		window.add(split);
		window.setVisible(true);
	}

	class ChangePanListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			if (tabs.getSelectedIndex() == 1) {
				border = Color.white;
				updateMap();
			} else {
				border = Color.decode("#4B77BE");
				updateMap();
			}
		}
	}

	public void initMap() {
		panGrid.removeAll();
		initMap(map);
		initQt(map);
		dispMap();
	}

	public void updateMap() {
		panGrid.removeAll();
		updateMapVal(map);
		dispMap();
		SwingUtilities.updateComponentTreeUI(window);
	}

	public void dispMap() {
		Font tempfont = new Font("Helvetica", Font.PLAIN, 10);
		for (int index1 = 0; index1 < 50; index1++) {
			for (int index2 = 0; index2 < 50; index2++) {
				if (tab[index1][index2] == 1) {
					JPanel wall = new JPanel();
					wall.setBackground(Color.white);
					panGrid.add(wall);
				} else if (tab[index1][index2] == 2) {
					JPanel wall = new JPanel();
					wall.setBackground(Color.green);
					JLabel temp = new JLabel(tab2[index1][index2]);
					temp.setFont(tempfont);
					wall.add(temp);
					panGrid.add(wall);
				} else if (tab[index1][index2] == 3) {
					JPanel wall = new JPanel();
					wall.setBackground(Color.red);
					JLabel temp = new JLabel(tab2[index1][index2]);
					temp.setFont(tempfont);
					wall.add(temp);
					panGrid.add(wall);
				} else if (tab[index1][index2] == 4) {
					JPanel wall = new JPanel();
					wall.setBackground(Color.MAGENTA);
					JLabel temp = new JLabel(tab2[index1][index2]);
					temp.setFont(tempfont);
					wall.add(temp);
					panGrid.add(wall);
				} else if (tab[index1][index2] == 5) {
					JPanel wall = new JPanel();
					wall.setBackground(Color.orange);
					JLabel temp = new JLabel(tab2[index1][index2]);
					temp.setFont(tempfont);
					wall.add(temp);
					panGrid.add(wall);
				} else {
					JPanel j = new JPanel();
					j.setBorder(BorderFactory.createLineBorder(border));
					j.setBackground(Color.decode("#4B77BE"));
					panGrid.add(j);
				}
			}
		}
	}

	class ItemAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// System.out.println("State : " + state.getSelectedItem() +
			// piece.getSelectedItem());
			HashMap<String, String> acts = ((Obj) map.get(piece.getSelectedItem())).getActMap();
			of = acts.keySet().toArray(new String[acts.keySet().size()]);
			state.removeAllItems();
			for (String item : of) {
				state.addItem(item);
			}
		}
	}

	class ItemAction2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			usr.act(state.getSelectedItem().toString(), piece.getSelectedItem().toString());
			updateMap();
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
		control.add(minuteValue);

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
			checkAuto();
			checkCalen();
			if ((clock.getHour().getValue() == 7) && (clock.getMinute().getValue() == 00)) {
				briefCalen();
			}
			if ((clock.getDay().getValue() == 7) && (clock.getHour().getValue() == 23)
					&& (clock.getMinute().getValue() == 50)) {
				// hme.iniAutomate();
			}
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

	public void checkAuto() {
		CSVReader reader1 = null;
		String dir = System.getProperty("user.dir");
		String csv = dir + "/automation.csv";
		try {
			reader1 = new CSVReader(new FileReader(csv));
			String[] readLine1;
			while ((readLine1 = reader1.readNext()) != null) {
				if ((clock.getMinute().getValue() == Integer.parseInt(readLine1[2]))
						&& (clock.getHour().getValue() == Integer.parseInt(readLine1[3]))) {
					((Chat) chat).addText("\nHome : \t" + "J'ai lancé automatiquement l'opération " + readLine1[1]
							+ " sur l'objet " + readLine1[0] + " à " + clock.getHour().getValue() + "h"
							+ clock.getMinute().getValue());
					((Chat) chat).addText("\n-------------------------");
					((Chat) chat).addText("\n");
					hme.act(readLine1[1], readLine1[0]);
					updateMap();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void checkCalen() {
		CSVReader reader1 = null;
		String dir = System.getProperty("user.dir");
		String csv = dir + "/calendar.csv";
		try {
			reader1 = new CSVReader(new FileReader(csv));
			String[] readLine1;
			while ((readLine1 = reader1.readNext()) != null) {
				if ((clock.getMinute().getValue() == (Integer.parseInt(readLine1[1])))
						&& (clock.getHour().getValue() == Integer.parseInt(readLine1[2]))
						&& (Integer.parseInt(readLine1[3]) == (-1)) && (Integer.parseInt(readLine1[4]) == (-1))) {
					((Chat) chat).addText("\nHome : \t" + "Attention votre évenement quotidien " + readLine1[0]
							+ " commence dans 10 minutes");
					((Chat) chat).addText("\n-------------------------");
					((Chat) chat).addText("\n");
				} else if ((clock.getMinute().getValue() == (Integer.parseInt(readLine1[1])))
						&& (clock.getHour().getValue() == Integer.parseInt(readLine1[2]))
						&& (clock.getDay().getValue() == Integer.parseInt(readLine1[3]))
						&& (Integer.parseInt(readLine1[4]) == (-1))) {
					((Chat) chat).addText("\nHome : \t" + "Attention votre évenement hebdomadaire " + readLine1[0]
							+ " commence dans 10 minutes");
					((Chat) chat).addText("\n-------------------------");
					((Chat) chat).addText("\n");
				} else if ((clock.getMinute().getValue() == (Integer.parseInt(readLine1[1])))
						&& (clock.getHour().getValue() == Integer.parseInt(readLine1[2]))
						&& (clock.getDay().getValue() == Integer.parseInt(readLine1[3]))
						&& (clock.getWeek().getValue() == Integer.parseInt(readLine1[4]))) {
					((Chat) chat).addText(
							"\nHome : \t" + "Attention vous avez un évenement dans 10 minutes : " + readLine1[0]);
					((Chat) chat).addText("\n-------------------------");
					((Chat) chat).addText("\n");

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void briefCalen() {
		CSVReader reader1 = null;
		String dir = System.getProperty("user.dir");
		String csv = dir + "/calendar.csv";
		String info = "";
		int num = 0;
		try {
			reader1 = new CSVReader(new FileReader(csv));
			String[] readLine1;
			while ((readLine1 = reader1.readNext()) != null) {
				if (clock.getDay().getValue() == Integer.parseInt(readLine1[3])) {
					num++;
					info += readLine1[0] + " \n";
				} else if ((Integer.parseInt(readLine1[3]) == (-1)) && ((Integer.parseInt(readLine1[4]) == (-1)))) {
					num++;
					info += readLine1[0] + " \n";
				}
			}
			((Chat) chat).addText("\nHome : \t" + " Bonjour, il est 7h00. Vous avez " + num
					+ " évenements aujourd'hui. Les voici : " + info);
			((Chat) chat).addText("\n-------------------------");
			((Chat) chat).addText("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}