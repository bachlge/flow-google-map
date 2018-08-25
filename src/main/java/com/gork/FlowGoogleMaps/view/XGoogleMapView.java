package com.gork.FlowGoogleMaps.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gork.FlowGoogleMaps.components.googlemaps.GoogleMap;
import com.gork.FlowGoogleMaps.components.googlemaps.GoogleMapMarker;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@SuppressWarnings("serial")
@PageTitle("°°°Google Maps Experiments°°°")
@Route(value="X-Google-Map", layout=MainView.class)
public class XGoogleMapView extends Composite<Div> {

	private static final Logger LOGGER = LoggerFactory.getLogger(XGoogleMapView.class);

	private static final String API_KEY = "=== here goes your API Key ===";

	public XGoogleMapView() {
		LOGGER.info("Constructor ...");

        H1 title = new H1("Google Mapz");

        GoogleMapMarker marker = new GoogleMapMarker();
        marker.setLatitude(62);
        marker.setLongitude(24);
        marker.setDraggable(true);

        GoogleMap map = new GoogleMap(API_KEY);
        map.setLatitude(62);
        map.setLongitude(24);

        map.addMarker(marker);

        Paragraph copyright = new Paragraph();
		copyright.setText("(c) Gork 2018");
		copyright.addClassName("copyright");

        getContent().add(title, map, copyright);
    }

}
