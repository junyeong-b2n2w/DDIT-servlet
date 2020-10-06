package kr.or.ddit.basic.nonCommand;

public class NonCommandTest {

	public static void main(String[] args) {
		//래ㅑㅁ프 켜기 기능 수행하기
//		Lamp lamp = new Lamp();
//		
//		NonCommand test = new NonCommand(lamp);
//		
//		test.run();
		
		Heater heater = new Heater();
		NonCommand test = new NonCommand(heater);
		test.run();
		
		
		
	}

}
