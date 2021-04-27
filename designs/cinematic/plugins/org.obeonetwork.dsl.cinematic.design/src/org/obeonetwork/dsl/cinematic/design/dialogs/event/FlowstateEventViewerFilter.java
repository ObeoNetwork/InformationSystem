package org.obeonetwork.dsl.cinematic.design.dialogs.event;

import java.util.AbstractMap.SimpleEntry;

import org.eclipse.core.internal.propertytester.StringMatcher;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.cinematic.NamedElement;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.utils.common.StringUtils;

/**
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a>
 *
 */
@SuppressWarnings("restriction")
public class FlowstateEventViewerFilter extends ViewerFilter implements KeyListener {
	private StringMatcher matcher;
	private CheckboxTreeViewer checkboxTreeViewer;
	private String query;
	
	public FlowstateEventViewerFilter(CheckboxTreeViewer checkboxTreeViewer) {
		this.checkboxTreeViewer = checkboxTreeViewer;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (StringUtils.isNullOrWhite(query)) { // We display the full tree when no query is entered
			return true;
		} else {			
			if (element instanceof NamedElement) {				
				boolean isNameMatch = matcher.match(((NamedElement) element).getName());
				
				if (element instanceof AbstractViewElement) {
					// we check if the abstractviewelement contain any widgetEventType that match
					boolean isWidgetMatch = ((AbstractViewElement) element)
							.getWidget()
							.getPossibleEvents()
							.stream()
							.anyMatch(type -> matcher.match(type.getName()));
					
					return isNameMatch || isWidgetMatch;
				} else if (element instanceof Flow) {
					return ((Flow) element).getEvents().stream().anyMatch(event -> matcher.match(event.getName()));					
				} else {
					return isNameMatch;
				}								
			} else if (element instanceof SimpleEntry) {
				return matcher.match(((WidgetEventType) ((SimpleEntry<?,?>) element).getValue()).getName());
			} else {
				return true;
			}
		}	
	}
	
	@Override
	public void keyPressed(KeyEvent e) {				
	}

	@Override
	public void keyReleased(KeyEvent e) { 
		// We update the query when text is typed, and immediately refresh the model.
		// If this filter gets slow on massive trees, performances could be improved here.
		query = ((Text) e.widget).getText().trim();
		matcher = new StringMatcher (query);
		checkboxTreeViewer.refresh();		
	}	

}
