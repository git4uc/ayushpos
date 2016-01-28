package net.codejava.spring.util;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.client.AbstractClientHttpResponse;

public class ErrorResponse   {

	//Usage - throw new PosException(ErrorCodes.INVALID_ID);

	  private int id;
	  private String msg;
	  private String desc;

	  public ErrorResponse(ErrorCode errcd) {
		    this.id = errcd.getId();
		    this.msg = errcd.getMsg();
		  }
	  
	  public ErrorResponse(ErrorCode errcd,String desc) {
		    this.id = errcd.getId();
		    this.msg = errcd.getMsg();
		    this.desc = desc;
		  }
	  
	  ErrorResponse(int id, String msg) {
	    this.id = id;
	    this.msg = msg;
	  }

	  public int getId() {
	    return this.id;
	  }

	  public String getMsg() {
	    return this.msg;
	  }

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	}

