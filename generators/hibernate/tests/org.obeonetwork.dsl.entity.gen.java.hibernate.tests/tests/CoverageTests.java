import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.obeonetwork.dsl.entity.gen.java.hibernate.launch.HibernateArchitecturePackageGenerationLauncher;

//Test Launcher
public class CoverageTests{
	
	public static void main(String[] args) throws Exception {
		HibernateArchitecturePackageGenerationLauncher launcher = new HibernateArchitecturePackageGenerationLauncher();
		URI modelURI = URI.createFileURI("model/coverage/associations/associations.entity");
		File folder = new File("src");
		//TODO set properties from /model/coverage/associations/package_architecture/associations-package.properties
		launcher.instanciateLauncher(modelURI, folder);
		
	}

}
