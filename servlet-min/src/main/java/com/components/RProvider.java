package com.components;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import com.integration.GlobalInterface;
import com.integration.RInterface;

@SessionScoped
public class RProvider implements RInterface, Serializable {

	@Inject
	private GlobalInterface globalProvider;

	RProvider() {
		System.out.println("RProvider: " + this);
	}

	@Override
	public String getInfo() {
		return globalProvider.getInfo() + "      " + this;
	}

}
