/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.cinematic.view.provider;


import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.obeonetwork.dsl.cinematic.provider.CinematicEditPlugin;
import org.obeonetwork.dsl.cinematic.provider.NamedElementItemProvider;
import org.obeonetwork.dsl.cinematic.toolkits.Widget;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewFactory;
import org.obeonetwork.dsl.cinematic.view.ViewPackage;
import org.osgi.framework.Bundle;

/**
 * This is the item provider adapter for a {@link org.obeonetwork.dsl.cinematic.view.AbstractViewElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractViewElementItemProvider
	extends NamedElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractViewElementItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addWidgetPropertyDescriptor(object);
			addLabelPropertyDescriptor(object);
			addViewStylePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Widget feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addWidgetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractViewElement_widget_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractViewElement_widget_feature", "_UI_AbstractViewElement_type"),
				 ViewPackage.Literals.ABSTRACT_VIEW_ELEMENT__WIDGET,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null) {
			@Override
			public Collection<?> getChoiceOfValues(Object object) {
				@SuppressWarnings("unchecked")
				Collection<Widget> normallySuggestedWidgets = (Collection<Widget>)super.getChoiceOfValues(object);
				Collection<Widget> suggestedWidgets = new ArrayList<Widget>();
				if (object instanceof ViewElement) {
					// We suggest only widgets which are not containers
					for (Widget widget : normallySuggestedWidgets) {
						if (widget == null) {
							suggestedWidgets.add(widget);
						} else if (widget.isIsContainer() == false) {
							suggestedWidgets.add(widget);
						}
					}
				} else {
					// We suggest only widgets which are containers
					for (Widget widget : normallySuggestedWidgets) {
						if (widget == null) {
							suggestedWidgets.add(widget);
						} else if (widget.isIsContainer() == true) {
							suggestedWidgets.add(widget);
						}
					}
				}
				return suggestedWidgets;
			}
		});
	}

	/**
	 * This adds a property descriptor for the Label feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLabelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractViewElement_label_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractViewElement_label_feature", "_UI_AbstractViewElement_type"),
				 ViewPackage.Literals.ABSTRACT_VIEW_ELEMENT__LABEL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the View Style feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addViewStylePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractViewElement_viewStyle_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractViewElement_viewStyle_feature", "_UI_AbstractViewElement_type"),
				 ViewPackage.Literals.ABSTRACT_VIEW_ELEMENT__VIEW_STYLE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ViewPackage.Literals.ABSTRACT_VIEW_ELEMENT__ACTIONS);
			childrenFeatures.add(ViewPackage.Literals.ABSTRACT_VIEW_ELEMENT__EVENTS);
			childrenFeatures.add(ViewPackage.Literals.ABSTRACT_VIEW_ELEMENT__VIEW_STYLE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((AbstractViewElement)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_AbstractViewElement_type") :
			getString("_UI_AbstractViewElement_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(AbstractViewElement.class)) {
			case ViewPackage.ABSTRACT_VIEW_ELEMENT__LABEL:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ViewPackage.ABSTRACT_VIEW_ELEMENT__ACTIONS:
			case ViewPackage.ABSTRACT_VIEW_ELEMENT__EVENTS:
			case ViewPackage.ABSTRACT_VIEW_ELEMENT__VIEW_STYLE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ViewPackage.Literals.ABSTRACT_VIEW_ELEMENT__ACTIONS,
				 ViewFactory.eINSTANCE.createViewAction()));

		newChildDescriptors.add
			(createChildParameter
				(ViewPackage.Literals.ABSTRACT_VIEW_ELEMENT__EVENTS,
				 ViewFactory.eINSTANCE.createViewEvent()));

		newChildDescriptors.add
			(createChildParameter
				(ViewPackage.Literals.ABSTRACT_VIEW_ELEMENT__VIEW_STYLE,
				 ViewFactory.eINSTANCE.createViewStyle()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return CinematicEditPlugin.INSTANCE;
	}

	/**
	 * @generated NOT
	 */
	public Object getReferencedWidgetImage(Object object) {
		AbstractViewElement abstractViewElement = (AbstractViewElement)object;
		
		Widget widget = abstractViewElement.getWidget();
		if(widget == null) {
			return null;
		}
		
		String iconStringPath = widget.getIcon();
	    if (iconStringPath == null || iconStringPath.trim().isEmpty()) {
	        return null;
	    }
	
	    ImageDescriptor imageDescriptor = getImageDescriptor(iconStringPath);
		if (imageDescriptor != null) {
			return getOrCreateImage(imageDescriptor);
		}

		return null;
	}

	private Map<ImageDescriptor, Image> imagesCache = new HashMap<ImageDescriptor, Image>();
	
	private Image getOrCreateImage(ImageDescriptor imageDescriptor) {
		Image image = imagesCache.get(imageDescriptor);
		if(image == null) {
			image = imageDescriptor.createImage();
			imagesCache.put(imageDescriptor, image);
		}
		return image;
	}

	@Override
	public void dispose() {
		imagesCache.entrySet().stream()
		.map(entry -> entry.getValue())
		.filter(image -> !image.isDisposed())
		.forEach(image -> image.dispose());
		
		super.dispose();
	}

	private ImageDescriptor getImageDescriptor(String iconStringPath) {
		ImageDescriptor imgageDescriptor = null;
		
		IResource iconResource = ResourcesPlugin.getWorkspace().getRoot().findMember(iconStringPath);
		if (iconResource == null) {
			// Search in plugins
			IPath iconPath = new Path(iconStringPath);
			String bundleId = iconPath.segment(0);
			Bundle bundle = Platform.getBundle(bundleId);
			if (bundle != null) {
				IPath iconRelativePath = iconPath.removeFirstSegments(1);
				Map<String, String> emptyMap = Collections.emptyMap();
				URL imageURL = FileLocator.find(bundle, iconRelativePath, emptyMap);
				if (imageURL != null) {
					imgageDescriptor = ImageDescriptor.createFromURL(imageURL);
				}
			}
		}
		
		if(imgageDescriptor == null) {
			imgageDescriptor = ImageDescriptor.createFromImageDataProvider(zoom -> new ImageData(iconResource.getLocation().toString()));
		}
		
		return imgageDescriptor;
	}
		
}
