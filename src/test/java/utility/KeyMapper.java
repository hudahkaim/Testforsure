package utility;

public class KeyMapper {

	public static KeyCoordinate getKeyCoordinate(String key) {
		
		System.out.println("key:" + key);
		
		
		// first row of calculator
		if(key == "MC") {
			return new KeyCoordinate(35,155);
		}else if( key == "MR") {
			return new KeyCoordinate(140,155);
		}else if( key == "M+") {
			return new KeyCoordinate( 230,155);
		}else if( key == "M") {
			return new KeyCoordinate(311,155);
		}else if( key == "CE") {
			return new KeyCoordinate(390,155);
		}else if( key == "+") {
			return new KeyCoordinate(311,515);
		}else if( key == "=") {
			return new KeyCoordinate(390,515);
		}else if( key.equals("/")) {
			return new KeyCoordinate(311,255);
		}else if( key == "^") {
			return new KeyCoordinate(390,255);
		}else if( key == "*") {
			return new KeyCoordinate(311,345);
		}else if( key == "%") {
			return new KeyCoordinate(390,345);
		}else if( key.equals("-")) {
			return new KeyCoordinate(311,430);
		}else if( key == "1/x") {
			return new KeyCoordinate(390,430);
		}else if( key == ".") {
			return new KeyCoordinate(140,515);
		}
		
		
		else if( Integer.parseInt(key) == 7) {
			return new KeyCoordinate(35,255);
		}else if( Integer.parseInt(key) == 8) {
			return new KeyCoordinate(140,255);
		}else if( Integer.parseInt(key) == 9) {
			return new KeyCoordinate(230,255);
		}
		
		else if( Integer.parseInt(key) == 4) {
			return new KeyCoordinate(35,345);
		}else if( Integer.parseInt(key) == 5) {
			return new KeyCoordinate(140,345);
		}else if( Integer.parseInt(key) == 6) {
			return new KeyCoordinate(230,345);
		}
		
		else if( Integer.parseInt(key) == 1) {
			return new KeyCoordinate(35,430);
		}else if( Integer.parseInt(key) == 2) {
			return new KeyCoordinate(140,430);
		}else if( Integer.parseInt(key) == 3) {
			return new KeyCoordinate(230,430);
		}
		
		
		else if( Integer.parseInt(key) == 0) {
			return new KeyCoordinate(35,515);
		}else {
			return new KeyCoordinate(0,0);
		}
	}
}
