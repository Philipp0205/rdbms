package com.databases2.rdbms.controller;

import javafx.fxml.FXML;
import javafx.scene.Parent;

public abstract class AbstractController<T extends Parent> {
	@FXML
	private T root; 
	
	public T getRoot() {
		return root;
	}
}
