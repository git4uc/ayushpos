package net.codejava.spring.util;

public enum ErrorCode{
	//Usage - throw new PosException(ErrorCodes.INVALID_ID);
	  INVALID_ID(101, "The id is invalid"),
	  INVALID_USER(102, "user is missing");

	  private final int id;
	  private final String msg;

	  ErrorCode(int id, String msg) {
	    this.id = id;
	    this.msg = msg;
	  }

	  public int getId() {
	    return this.id;
	  }

	  public String getMsg() {
	    return this.msg;
	  }
	}