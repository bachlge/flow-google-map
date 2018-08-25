package com.gork.FlowGoogleMaps.view;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.RouteData;
import com.vaadin.flow.router.Router;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.InitialPageSettings;
import com.vaadin.flow.server.PageConfigurator;

@SuppressWarnings("serial")
@StyleSheet("frontend://styles.css")
public class MainView extends Composite<Div> implements RouterLayout, PageConfigurator {

	private static final Logger LOGGER = LoggerFactory.getLogger(MainView.class);

	public MainView() {
		Router router = UI.getCurrent().getRouter();
		List<RouteData> routes = router.getRoutes();

		ComboBox<RouteData> menu = new ComboBox<RouteData>("Navigate");
		menu.setWidth("40%");
		menu.setItemLabelGenerator(RouteData::getUrl);
		menu.setItems(routes);
		menu.addValueChangeListener(event -> {
			LOGGER.info("selected: " + menu.getValue().getUrl());
			getUI().ifPresent(ui -> ui.navigate(menu.getValue().getUrl()));
		});

//		getContent().add(menu);
	}

	@Override
    public void configurePage(InitialPageSettings settings) {
		settings.addLink("shortcut icon", "frontend/favicon.ico");
	}

}