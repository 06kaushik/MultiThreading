package com.Multithreading;

import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;


public class PayrollServices {
	
	public static void main(String[] args) {
		
	    PayrollData[] payrolldata = {
			new PayrollData("India","HR","M",60000),
			new PayrollData("California","Sales","M",40000),
			new PayrollData("Delhi","Marketing","M",60000),
			new PayrollData("Canada","IT","F",80000),
			new PayrollData("New York","HR","F",55000),
			new PayrollData("Tokyo","Finance","M",67000)
	    };
	    
		PayrollRepo repo = new PayrollRepo();	
		Instant start = Instant.now();
		
		Arrays.stream(payrolldata).forEach(value -> {
			Runnable task = () ->{
				try {
					repo.insertMultipleRecord(value);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			};
		});
		
		Instant end = Instant.now();
		System.out.println("Duration without thread:" +Duration.between(start, end));
	}
}


