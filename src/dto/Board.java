package dto;

import java.sql.Connection;
import java.util.Date;

import lombok.Data;

@Data
public class Board {
	private int bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private Date bdate;
	private String bfileName;
	private String bsavedName;
	private String bfileType;
	private int bhitCount;
	
	
}
