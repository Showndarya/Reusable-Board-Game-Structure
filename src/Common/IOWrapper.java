package Common;
import java.util.*;

public class IOWrapper {	
	static Scanner sc;
	public IOWrapper() {
		sc = new Scanner(System.in);
	}
	
	public int GetUserInputTypeInt(String display) {
		System.out.print(display);
		return sc.nextInt();
	}
	
	public String GetUserInputTypeString(String display) {
		System.out.print(display);
		return sc.next();	
	}
	
	public String GetUserInputTypeLine(String display) {
		System.out.print(display);
		return sc.nextLine();	
	}
	
	public static void SysOutNL(String display) {
		System.out.println(display);
	}

	public static void SysOut(String display) {
		System.out.print(display);
	}
}
