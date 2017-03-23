package gui2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import counters.CyclicCounter;
import objects.Clock;

public class ClockGUI extends JFrame implements Runnable {

	private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);

	private static final int CHRONO_SPEED = 100;

	private static final long serialVersionUID = 1L;

	private Clock chronometer = new Clock();

	private JButton startButton = new JButton(" Start ");
	private JButton clearButton = new JButton(" Clear ");

	private JLabel weekLabel = new JLabel("week:");
	private JLabel dayLabel = new JLabel("Day:");
	private JLabel hourLabel = new JLabel("Hour:");
	private JLabel minuteLabel = new JLabel("Minute:");

	private JLabel weekValue = new JLabel("");
	private JLabel dayValue = new JLabel("");
	private JLabel hourValue = new JLabel("");
	private JLabel minuteValue = new JLabel("");

	private JPanel control = new JPanel();


	/**
	 * This instance is used in the inner classes for different action listeners.
	 */
	private ClockGUI instance = this;

	/**
	 * Initial status of for the start button.
	 */
	private boolean stop = true;

	public ClockGUI(String title) {
		super(title);
		init();
	}

	private void init() {
		updateValues();

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		control.setLayout(new FlowLayout(FlowLayout.CENTER));
		weekLabel.setFont(font);
		control.add(weekLabel);
		weekValue.setFont(font);
		control.add(weekValue);
		
		dayLabel.setFont(font);
		control.add(dayLabel);
		dayValue.setFont(font);
		control.add(dayValue);
		
		hourLabel.setFont(font);
		control.add(hourLabel);
		hourValue.setFont(font);
		control.add(hourValue);

		minuteLabel.setFont(font);
		control.add(minuteLabel);
		minuteValue.setFont(font);
		control.add(minuteValue);

		startButton.setFont(font);
		startButton.addActionListener(new StartStopAction());
		control.add(startButton);

		clearButton.setFont(font);
		clearButton.addActionListener(new ClearAction());
		control.add(clearButton);

		contentPane.add(BorderLayout.NORTH, control);
		

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setResizable(true);
	}

	private void updateValues() {
		// This part is for textual time printing.
		CyclicCounter week = chronometer.getWeek();
		weekValue.setText(week.toString() + " ");
		
		CyclicCounter day = chronometer.getDay();
		dayValue.setText(day.toString() + " ");
		
		CyclicCounter hour = chronometer.getHour();
		hourValue.setText(hour.toString() + " ");

		CyclicCounter minute = chronometer.getMinute();
		minuteValue.setText(minute.toString() + " ");


	}

	/**
	 * Defines what to do for each time unit (by default 1 second) : it increments the chronometer
	 */
	@Override
	public void run() {
		while (!stop) {
			try {
				Thread.sleep(CHRONO_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			chronometer.increment();
			updateValues();
		}
	}

	private class StartStopAction implements ActionListener {
		@Override
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

		@Override
		public void actionPerformed(ActionEvent e) {
			stop = true;
			startButton.setText(" Start ");
			chronometer.init();
			updateValues();
		}

	}

	public static void main(String[] args) {
		new ClockGUI("Clock");
	}

}