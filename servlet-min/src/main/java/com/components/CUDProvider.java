package com.components;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import com.integration.CUDInterface;
import com.integration.GlobalInterface;

@SessionScoped
public class CUDProvider implements CUDInterface, Serializable {

	@Inject
	private GlobalInterface globalProvider;

	public CUDProvider() {
		System.out.println("CUDProvider: " + this);
	}

	@Override
	public String createInfo(String create) {
		System.out.println("createInfo: " + this);
		globalProvider.setIntfo(create);
		return create;
	}

	@Override
	public String updateInfo(String update) {
		System.out.println("updateInfo: " + this);
		globalProvider.setIntfo(update);
		return update;
	}

	@Override
	public void deleteInfo() {		
		System.out.println("delete info" + this);
		globalProvider.setIntfo("");
	}

}
