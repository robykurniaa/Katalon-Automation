package tpr

import java.time.*

public class TPRConstants {
	public static final int MAX_SWIPE = 8

	// Enum untuk tipe pencarian
	public static enum SearchType {
		PACKAGE_NAME, 
		PRICE,      
		BOTH,         
		ANY          
	}

	// Zone ID
	public static final ZoneId JAKARTA_ZONE = ZoneId.of("Asia/Jakarta")
}