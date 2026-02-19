/**
 * 
 */
package org.obeonetwork.dsl.database.liquibasegen.handlers;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.internal.resources.Container;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.obeonetwork.dsl.database.liquibasegen.ui.GlobalChangelogSelectionWizard;
import org.obeonetwork.utils.common.ui.handlers.EventHelper;

/**
 * Merge changelog into a global changelog file
 *
 */
@SuppressWarnings("restriction")
public class GlobalChangelogHandler extends AbstractHandler {


	private Shell shell;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		shell = HandlerUtil.getActiveShell(event);
		
		Container projectDBDir = EventHelper.uwrapSingleSelection(event, Container.class);
		
		if(projectDBDir == null) {
			return null;
		}
		
		try {
			openChangelogSelectionWizard(projectDBDir);
		}catch (IOException e) {
			throw new ExecutionException(e.getMessage(), e);
		}
		
		return null;
	}

	private boolean openChangelogSelectionWizard(Container projectDBDir) throws IOException {
		// get list of files
		SearchFileByWildcard sfbw = new SearchFileByWildcard();
		List<String> changelogs = sfbw.searchWithWc(Paths.get(projectDBDir.getLocation().toOSString()),
				"\\run.changelog.xml");
		WizardDialog dialog = new WizardDialog(shell, new GlobalChangelogSelectionWizard(changelogs, projectDBDir.getLocation().toOSString()));
		dialog.create();
		dialog.open();

		return false;
	}

}

class SearchFileByWildcard {
    static List<String> matchesList = new ArrayList<String>();
    List<String> searchWithWc(Path rootDir, String pattern) throws IOException {
        matchesList.clear();
        FileVisitor<Path> matcherVisitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attribs) throws IOException {
                final String fileNameAndDir = rootDir.relativize(file).toString();
				if (fileNameAndDir.endsWith(pattern)) {
                    matchesList.add(fileNameAndDir);
                }
	        return FileVisitResult.CONTINUE;
            }
        };
        Files.walkFileTree(rootDir, matcherVisitor);
        return matchesList;
    }
}
