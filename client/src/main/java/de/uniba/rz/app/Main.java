package de.uniba.rz.app;


import de.uniba.rz.ui.swing.MainFrame;
import de.uniba.rz.ui.swing.SwingMainController;
import de.uniba.rz.ui.swing.SwingMainModel;

/**
 * Main class to start the TicketManagement5000 client application Currently
 * only a local backend implementation is registered.<br>
 * 
 * To add additional implementations modify the method
 * <code>evaluateArgs(String[] args)</code>
 *
 * @see #evaluateArgs(String[])
 */
public class Main {

	/**
	 * Starts the TicketManagement5000 application based on the given arguments
	 * 
	 * <p>
	 * <b>TODO No changes needed here - but documentation of allowed args should be
	 * updated</b>
	 * </p>
	 * 
	 * @param args
	 */
	
	/**
	 * 
	 * Changes!!
	 * 
	 * We changed the SwingMainController, SwingMainModel and MainFrame variables
	 * from locally to static so we could access them from different classes.
	 * 
	 * 
	 */
	

	
	public static void main(String[] args) {
					
		TicketManagementBackend backendToUse = evaluateArgs(args);

		SwingMainController control = new SwingMainController(backendToUse);
		SwingMainModel model = new SwingMainModel(backendToUse);
		MainFrame mf = new MainFrame(control, model);

		control.setMainFrame(mf);
		control.setSwingMainModel(model);

		control.start();
	}

	/**
	 * Determines which {@link TicketManagementBackend} should be used by evaluating
	 * the given {@code args}.
	 * 
	 * If <code>null</code>, an empty array or an unknown argument String is passed,
	 * the default {@code LocalTicketManagementBackend} is used.
	 * 
	 * <p>
	 * <b>This method must be modified in order to register new implementations of
	 * {@code TicketManagementBackend}.</b>
	 * </p>
	 * 
	 * @param args a String array to be evaluated
	 * @return the selected {@link TicketManagementBackend} implementation
	 * 
	 * @see TicketManagementBackend
	 */
	private static TicketManagementBackend evaluateArgs(String[] args) {
		
		if (args == null || args.length == 0) {
			System.out.println("No arguments passed. Using local backend implemenation.");
			return new LocalTicketManagementBackend();
		} else {
			switch (args[0]) {
			case "local":
				return new LocalTicketManagementBackend();
			// TODO Register new backend implementations here as additional
			// cases. E.g.:
			case "udp":
				String host = args[1];
				int port = Integer.parseInt(args[2]);
				return new UdpTicketManagementBackend(host, 9000);
				
			case "jms":
				return new JmsTicketManagementBackend();

//			case "grpc":
//				host = args[1];
//				port = Integer.valueOf(args[2]);
//				return new GRPCTicketMangementBackend(host, port);
				
			case "wsdl":
				return new WSDLticketManagement();
				
			// Default case for unknown implentations
			default:
				System.out.println("Unknown backend type. Using local backend implementation.");
				return new LocalTicketManagementBackend();
			}

		}
	}
}
