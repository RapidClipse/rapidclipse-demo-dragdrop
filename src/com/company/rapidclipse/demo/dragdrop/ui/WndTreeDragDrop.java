
package com.company.rapidclipse.demo.dragdrop.ui;

import com.company.rapidclipse.demo.dragdrop.dal.CategoryDAO;
import com.company.rapidclipse.demo.dragdrop.dal.ProductDAO;
import com.company.rapidclipse.demo.dragdrop.entities.Category;
import com.company.rapidclipse.demo.dragdrop.entities.Product;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.event.Transferable;
import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptAll;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.dd.VerticalDropLocation;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Tree.TreeDragMode;
import com.vaadin.ui.Tree.TreeTargetDetails;
import com.xdev.dal.DAOs;
import com.xdev.ui.XdevHorizontalSplitPanel;
import com.xdev.ui.XdevPanel;
import com.xdev.ui.XdevTree;
import com.xdev.ui.XdevVerticalLayout;
import com.xdev.ui.XdevView;
import com.xdev.ui.hierarchical.TreeDataProvider;

public class WndTreeDragDrop extends XdevView {

	/**
	 * 
	 */
	public WndTreeDragDrop() {
		super();
		this.initUI();

		this.initDragDropAction();
	}

	private void initDragDropAction() {
		this.tree.setDragMode(TreeDragMode.NODE);

		this.tree.setDropHandler(new DropHandler() {

			@Override
			public AcceptCriterion getAcceptCriterion() {
				return AcceptAll.get();
			}

			@Override
			public void drop(final DragAndDropEvent event) {

				final Transferable t = event.getTransferable();
				final TreeTargetDetails target = (TreeTargetDetails) event.getTargetDetails();

				final Object sourceItemId = t.getData("itemId");
				final Object targetItemId = target.getItemIdOver();

				final HierarchicalContainer container = (HierarchicalContainer) WndTreeDragDrop.this.tree
						.getContainerDataSource();

				final VerticalDropLocation location = target.getDropLocation();

				if (location == VerticalDropLocation.MIDDLE) {
					if (targetItemId instanceof Product) {
						setCategory((Product) sourceItemId, ((Product) targetItemId).getCategory());
					} else {
						setCategory((Product) sourceItemId, (Category) targetItemId);
					}
					WndTreeDragDrop.this.tree.setParent(sourceItemId, targetItemId);
				} else if (location == VerticalDropLocation.TOP) {
					final Object parentId = container.getParent(targetItemId);
					container.setParent(sourceItemId, parentId);
					container.moveAfterSibling(sourceItemId, targetItemId);
					container.moveAfterSibling(targetItemId, sourceItemId);
					setCategory((Product) sourceItemId, ((Product) targetItemId).getCategory());
				} else if (location == VerticalDropLocation.BOTTOM) {
					final Object parentId = container.getParent(targetItemId);
					container.setParent(sourceItemId, parentId);
					container.moveAfterSibling(sourceItemId, targetItemId);
					setCategory((Product) sourceItemId, ((Product) targetItemId).getCategory());
				}
			}
		});
	}

	@Override
	public void enter(final ViewChangeListener.ViewChangeEvent event) {
		super.enter(event);

	}

	private void setCategory(final Product p, final Category targetCategory) {
		p.setCategory(targetCategory);
		if (!targetCategory.getProducts().contains(targetCategory)) {
			targetCategory.getProducts().add(p);
		}
		new ProductDAO().save(p);
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
		this.tree = new XdevTree();

		this.horizontalSplitPanel.setStyleName("large");
		this.horizontalSplitPanel.setSplitPosition(40.0F, Unit.PERCENTAGE);
		this.tree.setContainerDataSource(TreeDataProvider.New(DAOs.get(CategoryDAO.class).findAll())
				.addLevel(Category::getProducts), true);

		this.tree.setSizeFull();
		this.verticalLayout.addComponent(this.tree);
		this.verticalLayout.setComponentAlignment(this.tree, Alignment.MIDDLE_LEFT);
		this.verticalLayout.setExpandRatio(this.tree, 10.0F);
		this.verticalLayout.setSizeFull();
		this.panel2.setContent(this.verticalLayout);
		this.panel2.setSizeFull();
		this.horizontalSplitPanel.setFirstComponent(this.panel2);
		this.horizontalSplitPanel.setSizeFull();
		this.panel.setContent(this.horizontalSplitPanel);
		this.panel.setSizeFull();
		this.setContent(this.panel);
		this.setSizeFull();
	} // </generated-code>

	// <generated-code name="variables">
	private XdevPanel panel, panel2;
	private XdevTree tree;
	private XdevVerticalLayout verticalLayout;
	private XdevHorizontalSplitPanel horizontalSplitPanel;
	// </generated-code>

}
