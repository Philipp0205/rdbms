package com.databases2.rdbms.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public abstract class AbstractFxmlConfiguration {
	protected static final String SUFFIX_FXML = ".fxml";
	protected static final String SUFFIX_PRESENTER = "Presenter";

	protected <C extends AbstractController<T>, T extends Parent> C loadController(Class<C> clazz) throws IOException {

		String derivedXmlName = deriveXMLName(clazz);
		System.out.println(derivedXmlName);

		try (InputStream fxmlStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(derivedXmlName)) {
			FXMLLoader loader = new FXMLLoader();

			loader.load(fxmlStream);
			return loader.getController();

		}

	}

	protected String deriveXMLName(Class<?> clazz) {
		return clazz.getSimpleName().replaceAll(SUFFIX_PRESENTER + "$", "") + SUFFIX_FXML;
	}

	protected String deriveBundleName(Class<?> clazz) {
		return clazz.getSimpleName().replaceAll(SUFFIX_PRESENTER + "$", "");
	}

}
