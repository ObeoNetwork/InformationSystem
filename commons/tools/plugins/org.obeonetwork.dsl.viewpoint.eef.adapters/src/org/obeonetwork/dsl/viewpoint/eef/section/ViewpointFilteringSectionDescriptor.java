package org.obeonetwork.dsl.viewpoint.eef.section;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.ui.views.properties.tabbed.AbstractSectionDescriptor;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.eclipse.ui.views.properties.tabbed.ISectionDescriptor;
import org.eclipse.ui.views.properties.tabbed.ISectionDescriptorProvider;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.obeonetwork.dsl.viewpoint.eef.adapters.Activator;

/**
 * A section descriptor provider which is invoked by the
 * {@link org.eclipse.ui.internal.views.properties.tabbed.view.TabbedPropertyRegistry} when parameterized in a
 * <code>sectionDescriptorProvider</code> attribute of a
 * <code>propertyContributor</code> entry.
 * 
 * <p>
 * This class is intended to be used with the <code></code> extension which
 * allows to list several section identifiers that have to be hidden from the
 * tabbed property sheet view.
 * </p>
 * 
 * @author jbrazeau
 */
@SuppressWarnings("restriction")
public class ViewpointFilteringSectionDescriptor implements
		ISectionDescriptorProvider, IExecutableExtension {

	/** The property contributor ID */
	private String propertyContributorId;

	/** The section descriptors */
	private ISectionDescriptor[] sectionDescriptors;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.ISectionDescriptorProvider#getSectionDescriptors()
	 */
	public ISectionDescriptor[] getSectionDescriptors() {
		return sectionDescriptors;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.IExecutableExtension#setInitializationData(org.eclipse.core.runtime.IConfigurationElement,
	 *      java.lang.String, java.lang.Object)
	 */
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		propertyContributorId = config.getAttribute("contributorId");
		if (propertyContributorId == null) {
			Activator
					.getDefault()
					.getLog()
					.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
							"The section filter must be associated to a property contributor id"));
		} else {
			// Filters loading
			IExtensionPoint point = Platform
					.getExtensionRegistry()
					.getExtensionPoint(
							"org.obeonetwork.dsl.viewpoint.eef.adapters.sectionFilters");
			List<String> sectionsToFilter = new ArrayList<String>();
			for (IConfigurationElement cfgElement : point
					.getConfigurationElements()) {
				if (propertyContributorId.equals(cfgElement
						.getAttribute("contributorId"))) {
					for (IConfigurationElement sectionFilterCfgElement : cfgElement
							.getChildren("sectionFilter")) {
						sectionsToFilter.add(sectionFilterCfgElement
								.getAttribute("id"));
					}
				}
			}

			// Property section configuration loading
			point = Platform.getExtensionRegistry().getExtensionPoint(
					"org.eclipse.ui.views.properties.tabbed.propertySections");
			List<ISectionDescriptor> result = new ArrayList<ISectionDescriptor>();
			for (IConfigurationElement cfgElement : point
					.getConfigurationElements()) {
				if (propertyContributorId.equals(cfgElement
						.getAttribute("contributorId"))) {
					for (IConfigurationElement propertySectionCfgElement : cfgElement
							.getChildren("propertySection")) {
						SectionDescriptor sectionDescritor = new SectionDescriptor(
								propertySectionCfgElement);
						// Section filtering
						if (!sectionsToFilter
								.contains(sectionDescritor.getId())) {
							result.add(sectionDescritor);
						}
					}
				}
			}
			sectionDescriptors = result.toArray(new ISectionDescriptor[result
					.size()]);
		}
	}

}

/**
 * A section descriptor.
 * 
 * @author jbrazeau
 */
class SectionDescriptor extends AbstractSectionDescriptor {

	/** The target tab */
	private String targetTab;

	/** The section */
	private ISection section;

	/** The input types */
	private List<String> inputTypes = new ArrayList<String>();

	/** The id */
	private String id;

	/** The filter */
	private IFilter filter;

	/** "Enables for" attribute */
	private int enablesFor = ISectionDescriptor.ENABLES_FOR_ANY;

	/** The section after which to put the current section */
	private String afterSection;

	/**
	 * Default constructor.
	 * 
	 * @param cfgElement
	 *            the configuration element.
	 */
	protected SectionDescriptor(IConfigurationElement cfgElement) {
		super();
		id = cfgElement.getAttribute("id");
		targetTab = cfgElement.getAttribute("tab");
		afterSection = cfgElement.getAttribute(afterSection);
		if (afterSection == null) {
			afterSection = ITabDescriptor.TOP;
		}
		if (cfgElement.getAttribute("enablesFor") != null) {
			try {
				enablesFor = Integer.parseInt(cfgElement
						.getAttribute("enablesFor"));
				if (enablesFor < 0)
					enablesFor = ISectionDescriptor.ENABLES_FOR_ANY;
			} catch (NumberFormatException e) {
				enablesFor = ISectionDescriptor.ENABLES_FOR_ANY;
			}
		}
		try {
			if (cfgElement.getAttribute("filter") != null) {
				filter = (IFilter) cfgElement
						.createExecutableExtension("filter");
			}
			if (cfgElement.getAttribute("class") != null) {
				section = (ISection) cfgElement
						.createExecutableExtension("class");
			}
			IConfigurationElement[] elements = cfgElement.getChildren("input");
			for (int i = 0; i < elements.length; i++) {
				IConfigurationElement element = elements[i];
				inputTypes.add(element.getAttribute("type"));
			}
		} catch (CoreException e) {
			Activator.getDefault().getLog().log(e.getStatus());
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.ISectionDescriptor#getId()
	 */
	public String getId() {
		return id;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.ISectionDescriptor#getFilter()
	 */
	@Override
	public IFilter getFilter() {
		return filter;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.ISectionDescriptor#getInputTypes()
	 */
	@Override
	public List<String> getInputTypes() {
		return inputTypes;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.ISectionDescriptor#getSectionClass()
	 */
	public ISection getSectionClass() {
		return section;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.ISectionDescriptor#getTargetTab()
	 */
	public String getTargetTab() {
		return targetTab;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.ISectionDescriptor#getEnablesFor()
	 */
	@Override
	public int getEnablesFor() {
		return enablesFor;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.ISectionDescriptor#getAfterSection()
	 */
	@Override
	public String getAfterSection() {
		return afterSection;
	}

}