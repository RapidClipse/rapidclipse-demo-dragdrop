package com.company.rapidclipse.demo.dragdrop.ui;

import java.util.Collection;

import com.company.rapidclipse.demo.dragdrop.dal.ProductDAO;
import com.company.rapidclipse.demo.dragdrop.entities.Product;
import com.company.rapidclipse.demo.dragdrop.entities.Product_;
import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptAll;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.DragAndDropWrapper.DragStartMode;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.TableTransferable;
import com.xdev.ui.XdevHorizontalSplitPanel;
import com.xdev.ui.XdevPanel;
import com.xdev.ui.XdevVerticalLayout;
import com.xdev.ui.XdevView;
import com.xdev.ui.entitycomponent.listselect.XdevListSelect;
import com.xdev.ui.entitycomponent.table.XdevTable;

public class WndTableListSelectDragDrop extends XdevView {

	/**
	 * 
	 */
	public WndTableListSelectDragDrop() {
		super();
		this.initUI();

		this.verticalLayout2.removeAllComponents();

		final DragAndDropWrapper wrapper = new DragAndDropWrapper(this.beveragesList);
		wrapper.setDragStartMode(DragStartMode.COMPONENT);

		wrapper.setDropHandler(new DropHandler() {

			@Override
			public AcceptCriterion getAcceptCriterion() {
				// TODO Auto-generated method stub
				return AcceptAll.get();
			}

			@SuppressWarnings("unchecked")
			@Override
			public void drop(final DragAndDropEvent event) {

				final Collection<String> dataFlavors = ((TableTransferable) event.getTransferable()).getDataFlavors();
				
				final Object itemId = ((TableTransferable) event.getTransferable()).getData("itemId");
				WndTableListSelectDragDrop.this.beveragesList.getBeanContainerDataSource().addBean(new ProductDAO().find((Integer)itemId));
			}
		});

		this.verticalLayout2.addComponent(wrapper);
		wrapper.setSizeFull();

	}

	@Override
	public void enter(final ViewChangeListener.ViewChangeEvent event) {
		super.enter(event);

	}

	/*
	 * WARNING: Do NOT edit!<br>The content of this method is always regenerated
	 * by the UI designer.
	 */
	// <generated-code name="initUI">
	private void initUI() {
		this.panel = new XdevPanel();
		this.horizontalSplitPanel = new XdevHorizontalSplitPanel();
		this.panel2 = new XdevPanel();
		this.verticalLayout = new XdevVerticalLayout();
		this.table = new XdevTable<>();
		this.panel3 = new XdevPanel();
		this.verticalLayout2 = new XdevVerticalLayout();
		this.beveragesList = new XdevListSelect<>();

		this.horizontalSplitPanel.setStyleName("large");
		this.horizontalSplitPanel.setSplitPosition(50.0F, Unit.PERCENTAGE);
		this.table.setDragMode(Table.TableDragMode.ROW);
		this.table.setContainerDataSource(Product.class);
		this.table.setVisibleColumns(Product_.productid.getName(), Product_.productname.getName(),
				Product_.unitprice.getName());
		this.beveragesList.setRows(4);
		this.beveragesList.setContainerDataSource(Product.class, false);
		this.beveragesList.setItemCaptionPropertyId(Product_.productname.getName());

		this.table.setSizeFull();
		this.verticalLayout.addComponent(this.table);
		this.verticalLayout.setComponentAlignment(this.table, Alignment.MIDDLE_CENTER);
		this.verticalLayout.setExpandRatio(this.table, 100.0F);
		this.verticalLayout.setSizeFull();
		this.panel2.setContent(this.verticalLayout);
		this.beveragesList.setSizeFull();
		this.verticalLayout2.addComponent(this.beveragesList);
		this.verticalLayout2.setComponentAlignment(this.beveragesList, Alignment.MIDDLE_CENTER);
		this.verticalLayout2.setExpandRatio(this.beveragesList, 10.0F);
		this.verticalLayout2.setSizeFull();
		this.panel3.setContent(this.verticalLayout2);
		this.panel2.setSizeFull();
		this.horizontalSplitPanel.setFirstComponent(this.panel2);
		this.panel3.setSizeFull();
		this.horizontalSplitPanel.setSecondComponent(this.panel3);
		this.horizontalSplitPanel.setSizeFull();
		this.panel.setContent(this.horizontalSplitPanel);
		this.panel.setSizeFull();
		this.setContent(this.panel);
		this.setSizeFull();
	} // </generated-code>

	// <generated-code name="variables">
	private XdevTable<Product> table;
	private XdevPanel panel, panel2, panel3;
	private XdevVerticalLayout verticalLayout, verticalLayout2;
	private XdevHorizontalSplitPanel horizontalSplitPanel;
	private XdevListSelect<Product> beveragesList;
	// </generated-code>

}
