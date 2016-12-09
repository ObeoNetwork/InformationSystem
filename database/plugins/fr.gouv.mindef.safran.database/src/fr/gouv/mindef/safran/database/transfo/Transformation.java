package fr.gouv.mindef.safran.database.transfo;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo;
import fr.gouv.mindef.safran.database.scaffold.ScaffoldType;

public interface Transformation {
	
	public boolean transform(URI scaffoldInfoURI, ScaffoldType scaffoldType);
	public boolean transform(ScaffoldInfo scaffoldInfo, ScaffoldType scaffoldType);
	public boolean doTransformationFirstStep(ScaffoldInfo scaffoldInfo, ScaffoldType scaffoldType);
	public void doTransformationFinalStep();
	public Resource getResult();
	public void setSaveFinalResource(boolean saveFinalResource);
}
