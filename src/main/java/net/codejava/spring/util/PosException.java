package net.codejava.spring.util;

public class PosException  extends Exception {

		  private int errorCode;
		  private String errorMsg;

		  public PosException(ErrorCode code) {
		    this.errorMsg = code.getMsg();
		    this.errorCode = code.getId();
		  }

		  public int getErrorCode() {
		    return errorCode;
		  }

		  public String getErrorMsg() {
		    return errorMsg;
		  }
		}

