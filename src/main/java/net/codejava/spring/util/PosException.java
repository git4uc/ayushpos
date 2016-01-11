package net.codejava.spring.util;

@SuppressWarnings("serial")
public class PosException  extends Exception {

		  private int errorCode;
		  private String errorMsg;

		  public PosException(ErrorCode code) {
		   super(code.getMsg());
		  }


		}

