package com.components;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;

import com.integration.GlobalInterface;

@SessionScoped
public class GlobalProvider implements GlobalInterface, Serializable {

	private String info;

	public GlobalProvider() {
		System.out.println("INIT GlobalProvider " + this);
	}

	@Override
	public String getInfo() {
		System.out.println("GlobalProvider getInfo" + this);
		return info;
	}

	@Override
	public void setIntfo(String info) {
		System.out.println("GlobalProvider setIntfo" + this);
		this.info = info;
	}
}
