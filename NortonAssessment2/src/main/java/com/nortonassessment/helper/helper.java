package com.nortonassessment.helper;

public class helper {
	public   long longValue(Object value) {
	    return (value instanceof Number ? ((Number)value).longValue() : -1);
	  }

	  public  double doubleValue(Object value) {
	    return (value instanceof Number ? ((Number)value).doubleValue() : -1.0);
	  }
}
