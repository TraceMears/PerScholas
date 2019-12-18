package zzbonus;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TimeFormatter {
	
	public static Timestamp convertLDT2TS(LocalDateTime ldt) {
		Timestamp ts = Timestamp.valueOf(ldt);
		return ts;
	}
	
	public static LocalDateTime convertTS2LDT(Timestamp ts) {
		LocalDateTime ldt = ts.toLocalDateTime();
		return ldt;
	}
	
	
	
	public static void main(String[] args) {
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(TimeFormatter.convertLDT2TS(ldt));
		
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		System.out.println(TimeFormatter.convertTS2LDT(ts));
		
		
		
	}

}
