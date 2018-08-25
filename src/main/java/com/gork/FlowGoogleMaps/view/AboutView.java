package com.gork.FlowGoogleMaps.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@SuppressWarnings("serial")
@PageTitle("°°°About Google Maps Experiments°°°")
@Route(value="", layout=MainView.class)
public class AboutView extends Composite<Div> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AboutView.class);

	public AboutView() {
		LOGGER.info("Constructor ...");

        H1 title = new H1("About this page");

        Paragraph content = new Paragraph();
        content.add(new H3("Welcome to this small Vaadin Flow application."));
        content.add(new Span("See how simple it is to include (well documented) WebComponents into your Vaadin Application."));
        content.add(new Span("See how simple it is to include (well documented) WebComponents into your Vaadin Application."));
/*
        		+ "In this example the 'google-map', see https://www.webcomponents.org/element/GoogleWebComponents/google-map"
        		+ "is used."
        		+ "");
*/
        String route = UI.getCurrent().getRouter().getUrl(XGoogleMapView.class);
        Anchor link = new Anchor(route, "Navigate to the Map");

        Paragraph copyright = new Paragraph();
		copyright.setText("(c) Gork 2018");
		copyright.addClassName("copyright");

        getContent().add(title, content, link, copyright);
    }

}
