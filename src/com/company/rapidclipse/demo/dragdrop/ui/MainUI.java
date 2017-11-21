
package com.company.rapidclipse.demo.dragdrop.ui;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.communication.PushMode;
import com.vaadin.shared.ui.ui.Transport;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.xdev.ui.XdevButton;
import com.xdev.ui.XdevHorizontalSplitPanel;
import com.xdev.ui.XdevPanel;
import com.xdev.ui.XdevUI;
import com.xdev.ui.XdevVerticalLayout;
import com.xdev.ui.navigation.Navigation;
import com.xdev.ui.navigation.XdevNavigator;

@Push(value = PushMode.MANUAL, transport = Transport.LONG_POLLING)
@Theme("rapidclipse_demo_dragdrop")
public class MainUI extends XdevUI {
	public MainUI() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(final VaadinRequest request) {
		this.initUI();
	}

	/**
	 * Event handler delegate method for the {@link XdevButton}
	 * {@link #btnTreeDragDrop}.
	 *
	 * @see Button.ClickListener#buttonClick(Button.ClickEvent)
	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
	 */
	private void btnTreeDragDrop_buttonClick(final Button.ClickEvent event) {
		Navigation.to("").navigate();
	}

	/**
	 * Event handler delegate method for the {@link XdevButton}
	 * {@link #btnTableDragDrop}.
	 *
	 * @see Button.ClickListener#buttonClick(Button.ClickEvent)
	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
	 */
	private void btnTableDragDrop_buttonClick(final Button.ClickEvent event) {
		Navigation.to("wndtablelistselectdragdrop").navigate();
	}

	/**
	 * Event handler delegate method for the {@link XdevButton}
	 * {@link #btnComponentDragDrop}.
	 *
	 * @see Button.ClickListener#buttonClick(Button.ClickEvent)
	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
	 */
	private void btnComponentDragDrop_buttonClick(final Button.ClickEvent event) {
		Navigation.to("wnduicomponentdragdrop").navigate();
	}

	/**
	 * Event handler delegate method for the {@link XdevButton}
	 * {@link #btnExternalFileDragDrop}.
	 *
	 * @see Button.ClickListener#buttonClick(Button.ClickEvent)
	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
	 */
	private void btnExternalFileDragDrop_buttonClick(final Button.ClickEvent event) {
		Navigation.to("wndexternalfiledragdrop").navigate();
	}

	/*
	 * WARNING: Do NOT edit!<br>The content of this method is always regenerated by
	 * the UI designer.
	 */
	// <generated-code name="initUI">
	private void initUI() {
		this.panel = new XdevPanel();
		this.horizontalSplitPanel = new XdevHorizontalSplitPanel();
		this.panel2 = new XdevPanel();
		this.verticalLayout = new XdevVerticalLayout();
		this.btnTreeDragDrop = new XdevButton();
		this.btnTableDragDrop = new XdevButton();
		this.btnComponentDragDrop = new XdevButton();
		this.btnExternalFileDragDrop = new XdevButton();
		this.navigationTargetContainer = new XdevPanel();
		this.navigator = new XdevNavigator(this, this.navigationTargetContainer);
	
		this.horizontalSplitPanel.setStyleName("large");
		this.horizontalSplitPanel.setSplitPosition(25.0F, Unit.PERCENTAGE);
		this.btnTreeDragDrop.setCaption("Tree Drag&Drop");
		this.btnTableDragDrop.setCaption("TableListSelectDragDrop");
		this.btnComponentDragDrop.setCaption("UIComponentDragDrop");
		this.btnExternalFileDragDrop.setCaption("ExternalFileDragDrop");
		this.navigator.addView("", WndTreeDragDrop.class);
		this.navigator.addView("wndtablelistselectdragdrop", WndTableListSelectDragDrop.class);
		this.navigator.addView("wnduicomponentdragdrop", WndUIComponentDragDrop.class);
		this.navigator.addView("wndexternalfiledragdrop", WndExternalFileDragDrop.class);
	
		this.btnTreeDragDrop.setWidth(100, Unit.PERCENTAGE);
		this.btnTreeDragDrop.setHeight(-1, Unit.PIXELS);
		this.verticalLayout.addComponent(this.btnTreeDragDrop);
		this.verticalLayout.setComponentAlignment(this.btnTreeDragDrop, Alignment.MIDDLE_CENTER);
		this.btnTableDragDrop.setWidth(100, Unit.PERCENTAGE);
		this.btnTableDragDrop.setHeight(-1, Unit.PIXELS);
		this.verticalLayout.addComponent(this.btnTableDragDrop);
		this.verticalLayout.setComponentAlignment(this.btnTableDragDrop, Alignment.MIDDLE_CENTER);
		this.btnComponentDragDrop.setWidth(100, Unit.PERCENTAGE);
		this.btnComponentDragDrop.setHeight(-1, Unit.PIXELS);
		this.verticalLayout.addComponent(this.btnComponentDragDrop);
		this.verticalLayout.setComponentAlignment(this.btnComponentDragDrop, Alignment.MIDDLE_CENTER);
		this.btnExternalFileDragDrop.setWidth(100, Unit.PERCENTAGE);
		this.btnExternalFileDragDrop.setHeight(-1, Unit.PIXELS);
		this.verticalLayout.addComponent(this.btnExternalFileDragDrop);
		this.verticalLayout.setComponentAlignment(this.btnExternalFileDragDrop,
				Alignment.MIDDLE_CENTER);
		final CustomComponent verticalLayout_spacer = new CustomComponent();
		verticalLayout_spacer.setSizeFull();
		this.verticalLayout.addComponent(verticalLayout_spacer);
		this.verticalLayout.setExpandRatio(verticalLayout_spacer, 1.0F);
		this.verticalLayout.setSizeFull();
		this.panel2.setContent(this.verticalLayout);
		this.panel2.setSizeFull();
		this.horizontalSplitPanel.setFirstComponent(this.panel2);
		this.navigationTargetContainer.setSizeFull();
		this.horizontalSplitPanel.setSecondComponent(this.navigationTargetContainer);
		this.horizontalSplitPanel.setSizeFull();
		this.panel.setContent(this.horizontalSplitPanel);
		this.panel.setSizeFull();
		this.setContent(this.panel);
		this.setSizeFull();
	
		this.btnTreeDragDrop.addClickListener(event -> this.btnTreeDragDrop_buttonClick(event));
		this.btnTableDragDrop.addClickListener(event -> this.btnTableDragDrop_buttonClick(event));
		this.btnComponentDragDrop
				.addClickListener(event -> this.btnComponentDragDrop_buttonClick(event));
		this.btnExternalFileDragDrop
				.addClickListener(event -> this.btnExternalFileDragDrop_buttonClick(event));
	} // </generated-code>

	// <generated-code name="variables">
	private XdevButton btnTreeDragDrop, btnTableDragDrop, btnComponentDragDrop, btnExternalFileDragDrop;
	private XdevNavigator navigator;
	private XdevPanel panel, panel2, navigationTargetContainer;
	private XdevVerticalLayout verticalLayout;
	private XdevHorizontalSplitPanel horizontalSplitPanel;
	// </generated-code>
}