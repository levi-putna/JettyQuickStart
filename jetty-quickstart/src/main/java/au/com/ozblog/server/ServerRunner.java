package au.com.ozblog.server;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ServerRunner extends JFrame {
	private static final long serialVersionUID = 8261022096695034L;

	private JButton btnStartStop;
	private JTextField textPortNumber;

	public ServerRunner(final JettyServer jettyServer) {
		super("Start/Stop Server");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		getContentPane().setLayout(new MigLayout("", "[-19.00px,right][grow,fill]", "[][278px]"));
		
		btnStartStop = new JButton("Start");
		btnStartStop.addActionListener(new ServerStartStopActionListner(
				jettyServer));
		
		JLabel lblPortNumber = new JLabel("Port");
		getContentPane().add(lblPortNumber, "cell 0 0");
		
		textPortNumber = new JTextField();
		textPortNumber.setText("8080");
		getContentPane().add(textPortNumber, "cell 1 0,growx");
		textPortNumber.setColumns(10);
		getContentPane().add(btnStartStop, "cell 0 1 2 1,grow");
		setSize(300, 300);
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
		
			public void run() {
				if (jettyServer.isStarted()) {
					try {
						jettyServer.stop();
					} catch (Exception exception) {
						exception.printStackTrace();
					}
				}
			}
		}, "Stop Jetty Hook"));
		setVisible(true);
	}
}