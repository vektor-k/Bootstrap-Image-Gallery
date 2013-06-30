package net.x6.pornvolt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PV_7 implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final Label errorLabel = new Label();

		RootPanel rootPanel = RootPanel.get("errorLabelContainer");
		rootPanel.add(errorLabel);
		
		Grid grid = new Grid(5, 1);
		rootPanel.add(grid, 0, 0);
		grid.setSize("130px", "768px");
		
		Image image_2 = new Image((String) null);
		grid.setWidget(0, 0, image_2);
		
		Image image_3 = new Image((String) null);
		grid.setWidget(1, 0, image_3);
		
		Image image_1 = new Image((String) null);
		grid.setWidget(2, 0, image_1);
		
		Image image_4 = new Image((String) null);
		grid.setWidget(3, 0, image_4);
		
		Image image = new Image((String) null);
		grid.setWidget(4, 0, image);
		
		Grid grid_1 = new Grid(3, 1);
		rootPanel.add(grid_1, 1245, 126);
		grid_1.setSize("111px", "492px");
		
		Grid grid_2 = new Grid(4, 8);
		rootPanel.add(grid_2, 213, 126);
		grid_2.setSize("953px", "492px");
		
		Label lblNewLabel = new Label("PORN VOLT");

		rootPanel.add(lblNewLabel, 213, 43);
		lblNewLabel.setSize("140px", "40px");

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

				// Then, we send the input to the server.
				serverResponseLabel.setText("");
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								dialogBox
										.setText("Remote Procedure Call - Failure");
								serverResponseLabel
										.addStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(SERVER_ERROR);
								dialogBox.center();
								closeButton.setFocus(true);
							}

							public void onSuccess(String result) {
								dialogBox.setText("Remote Procedure Call");
								serverResponseLabel
										.removeStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(result);
								dialogBox.center();
								closeButton.setFocus(true);
							}
						};
			}
	}
