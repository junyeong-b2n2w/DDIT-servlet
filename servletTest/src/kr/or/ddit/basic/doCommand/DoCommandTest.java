package kr.or.ddit.basic.doCommand;

public class DoCommandTest {

	public static void main(String[] args) {
		//램프켜기
		Lamp lamp = new Lamp();
		ICommand lampCommand = new LampCommandImpl(lamp);
		
		DoCommand test = new DoCommand();
		test.setCommand(lampCommand);
		test.run();
		
		Heater heater = new Heater();
		ICommand heaterCommand = new HeaterCommandImpl(heater);
		
		DoCommand test2 = new DoCommand();
		test2.setCommand(heaterCommand);
		test2.run();
		
		
	}

}
