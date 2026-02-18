package org.obeonetwork.dsl.database.liquibasegen.ui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Wizard to select changelogs to merge
 */
public class GlobalChangelogSelectionWizard extends Wizard {

	private SelectionTreeWizardPage selectionPage;
	/**
	 * Keep track of selection in the wizard
	 */
	private final List<String> cachedSelection = new ArrayList<>();
	/**
	 * All the available name of files that can be selected
	 */
	private List<String> nodes;
	private String rootSelectionDir;

	public GlobalChangelogSelectionWizard(List<String> nodes, String rootSelectionDir) {
	        setWindowTitle("Selection of changelogs to merge");
	        this.nodes = nodes;
	        this.rootSelectionDir = rootSelectionDir;
	    }

	@Override
	public void addPages() {
		selectionPage = new SelectionTreeWizardPage("Selection page of changelogs", nodes, cachedSelection);
		addPage(selectionPage);
	}

	@Override
	public boolean performFinish() {
		cachedSelection.clear();
		cachedSelection.addAll(selectionPage.getSelectedItems());
		return selectionPage.doMergingChangelog(rootSelectionDir);
	}
}

/**
 * Page with CheckboxTreeViewer
 */
class SelectionTreeWizardPage extends WizardPage {	
	
	private final static String GLOBAL_CHANGELOG_FILE_NAME = "global_run.changelog.xml"; //$NON-NLS-1$

	private CheckboxTreeViewer treeViewer;
	private final List<String> cache;

	/**
	 * All the available nodes that can be selected
	 */
	private final Node[] roots;

	protected SelectionTreeWizardPage(String pageName, List<String> nodes, List<String> cache) {
		super(pageName);
		setTitle("Merge liquibase changelogs");
		setDescription("Choose which changelog to include in the merging process.");
		roots = nodes.stream().map(Node::new).toArray(Node[]::new);
		this.cache = cache;
	}
	
	public boolean doMergingChangelog(String rootSelectionDir) {
		try {
			final DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			final Document mergedDoc = dBuilder.newDocument();

			Element rootElement = null;

			for (String xmlFile : getSelectedItems().stream().filter(fileName -> fileName.endsWith(".changelog.xml"))
					.toList()) {
				if (rootElement == null) {
					// we initialize root using an existing document to use all the attributes including xmlns
					rootElement = (Element) mergedDoc.importNode(
							dBuilder.parse(rootSelectionDir + File.separator + xmlFile).getDocumentElement(), true);
				} else {
					// we add children in the other xml root
					final NodeList nodes = dBuilder.parse(new File(rootSelectionDir + File.separator + xmlFile))
							.getDocumentElement().getChildNodes();
					for (int i = 0; i < nodes.getLength(); i++) {
						org.w3c.dom.Node importedNode = mergedDoc.importNode(nodes.item(i), true);
						rootElement.appendChild(importedNode);
					}
				}
			}

			mergedDoc.appendChild(rootElement);
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(mergedDoc);
			StreamResult result = new StreamResult(
					new File(rootSelectionDir + File.separator + GLOBAL_CHANGELOG_FILE_NAME));
			transformer.transform(source, result);
			return true;
		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			setErrorMessage("An error occur while loading the contents of changelogs files. Check the state of the files before retrying.");
			return false;
		}
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(1, false));

		treeViewer = new CheckboxTreeViewer(container, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		treeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		treeViewer.setContentProvider(new ITreeContentProvider() {
			@Override
			public Object[] getElements(Object input) {
				return roots;
			}

			@Override
			public Object[] getChildren(Object parent) {
				return ((Node) parent).children;
			}

			@Override
			public Object getParent(Object element) {
				return ((Node) element).parent;
			}

			@Override
			public boolean hasChildren(Object element) {
				return ((Node) element).children.length > 0;
			}
		});

		treeViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((Node) element).name;
			}
		});

		treeViewer.setInput(roots);

		restoreFromCache();

		treeViewer.addCheckStateListener(new ICheckStateListener() {
			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				updateCache();
				checkContinuity();
				setPageComplete(!cache.isEmpty());
			}
		});

		setControl(container);
		setPageComplete(!cache.isEmpty());
	}

	/**
	 * Check if the selection 
	 */
	protected void checkContinuity() {
		setMessage(null);
		if (!cache.isEmpty()) {
			final List<String> rootsNames = Arrays.asList(roots).stream().map(Node::getName).toList();
			int startIndex = rootsNames.indexOf(cache.get(0));
			for (int i = 0; i < cache.size(); i++) {
				if (!cache.get(i).equals(rootsNames.get(startIndex+i))) {
					setMessage("Some changelogs are not selected between others. This may result in an inconsistent global changelog.",
							IMessageProvider.WARNING);
				}
			}
		}
		
	}

	private void updateCache() {
		cache.clear();
		Object[] checked = treeViewer.getCheckedElements();
		for (Object o : checked) {
			Node n = (Node) o;
			if (n.children.length == 0) { // we keep only leaves
				cache.add(n.name);
			}
		}
	}

	private void restoreFromCache() {
		List<Node> toCheck = new ArrayList<>();
		for (Node root : roots) {
			for (Node child : root.children) {
				if (cache.contains(child.name)) {
					toCheck.add(child);
				}
			}
		}
		treeViewer.setCheckedElements(toCheck.toArray());
	}

	/**
	 * @return selected items in the tree viewer
	 */
	public List<String> getSelectedItems() {
		return Stream.of(treeViewer.getCheckedElements()).filter(Node.class::isInstance).map(Node.class::cast)
				.map(Node::getName).toList();
	}
}

/**
 * Small tree object
 */
class Node {
	final String name;
	final Node[] children;
	Node parent;

	Node(String name, Node... children) {
		this.name = name;
		this.children = children;
		for (Node c : children) {
			c.parent = this;
		}
	}
	
	String getName() {
		return name;
	}
}
