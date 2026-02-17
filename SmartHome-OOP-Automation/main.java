import java.util.ArrayList;

public class SmartHomeManager {

	public static void main(String[] args) {
		ArrayList<Controllable> controllable = new ArrayList<Controllable>();

		controllable.add(new SmartLight("Living Room Light",true));
		controllable.add(new SmartSpeaker("Kitchen Speaker",true,50));
		for (Controllable controllable2 : controllable) {
			controllable2.turnOn();
			if (controllable2 instanceof Schedulable) {
				((Schedulable) controllable2).schedule("18.00");
			}
			((SmartDevice) controllable2).showStatus();
		}

	}

}

interface Controllable {
	void turnOn();

	void turnOff();

	boolean isOn();
}

interface Schedulable extends Controllable {
	void schedule(String time);
}

abstract class SmartDevice implements Controllable {
	String deviceName;
	boolean status;

	

	public SmartDevice(String deviceName, boolean status) {
		super();
		this.deviceName = deviceName;
		this.status = status;
	}

	@Override
	public void turnOn() {
		System.out.println(deviceName + " turned on");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isOn() {
		// TODO Auto-generated method stub
		return true;
	}

	abstract void showStatus();
}

class SmartLight extends SmartDevice implements Schedulable {

	

	public SmartLight(String deviceName, boolean status) {
		super(deviceName, status);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void schedule(String time) {

		System.out.println("SmartLight scheduled to turn on at " + time);

	}

	@Override
	void showStatus() {
		if (status == true)
			System.out.println("SmartLight "+ deviceName +" is ON");

		if (status == false)
			System.out.println("SmartLight " + deviceName + " is OFF");

	}

}

class SmartSpeaker extends SmartDevice {
	int volume;

	

	public SmartSpeaker(String deviceName, boolean status, int volume) {
		super(deviceName, status);
		this.volume = volume;
	}

	void playMusic(String trackName) {
		System.out.println("Playing " + trackName + " on " + deviceName);
	}

	@Override
	void showStatus() {
		if (status == true)
			System.out.println("SmartSpeaker "+deviceName + " is ON with volume " + volume);

		if (status == false)
			System.out.println("SmartSpeaker " + deviceName + " is OFF with volume " + volume);

	}
}
