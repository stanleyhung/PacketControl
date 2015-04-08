package packetControl;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

//Class that enables communication between Control and Robot Control
public class Message {
	private String myMessage;
	private int[] key;
	private boolean isMouseEvent;
	
	final static String PLAY = "Play";
	final static String NEXT = "Next";
	final static String PREVIOUS = "Previous";
	final static String QUIT = "Quit";
	final static String MAGIC = "Turn On VLC";
	final static String RANDOM = "Toggle Random";
	final static String VOLUME_UP = "Volume Up";
	final static String VOLUME_DOWN = "Volume Down";
	
	private static final Map<String, int[]> validCommands;
	static {
		validCommands = new HashMap<String, int[]>();
		validCommands.put(PLAY, new int[] {KeyEvent.VK_SPACE});
		validCommands.put(NEXT, new int[] {KeyEvent.VK_N});
		validCommands.put(PREVIOUS, new int[] {KeyEvent.VK_P});
		validCommands.put(QUIT, new int[] {KeyEvent.VK_CONTROL, KeyEvent.VK_Q});
		validCommands.put(RANDOM, new int[] {KeyEvent.VK_R});
		validCommands.put(VOLUME_UP, new int[] {-1});
		validCommands.put(VOLUME_DOWN, new int[] {1});
	}
	
	public Message(String message) {
		if(!validCommands.containsKey(message)) {
			throw new IllegalArgumentException();
		}
		myMessage = message;
		key = validCommands.get(message);
		
		if (message.equals(VOLUME_DOWN) || message.equals(VOLUME_UP)) {
			isMouseEvent = true;
		} else {
			isMouseEvent = false;
		}
	}
	
	public int[] getKeys() {
		return key;
	}
	
	public String getMessage() {
		return myMessage;
	}
	
	public static boolean isValidCommand(String command) {
		return validCommands.containsKey(command);
	}
	
	public boolean isMouseEvent() {
		return isMouseEvent;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
