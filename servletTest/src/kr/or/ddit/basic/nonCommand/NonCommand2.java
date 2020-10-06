package kr.or.ddit.basic.nonCommand;

//호출자 역할의 클래스
public class NonCommand2 {
	// 2가지 기능을 모두 처리하기
	private Lamp lamp;
	private Heater heater;
	private String mode;
	
	public NonCommand2(Lamp lamp, Heater heater) {
		this.lamp = lamp;
		this.heater = heater;
			
	}
	
	
	public void setMode(String mode){
		this.mode = mode;
	}
	
	public void run(){
		switch (mode) {
		case "HEATER":
			heater.powerOn();
			break;
		case "LAMP":
			lamp.turnOn();
			break;
		}
	}
	
	
}
