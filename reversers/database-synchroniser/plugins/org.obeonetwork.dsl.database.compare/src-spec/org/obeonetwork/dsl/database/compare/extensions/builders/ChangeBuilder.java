package org.obeonetwork.dsl.database.compare.extensions.builders;

import org.eclipse.emf.compare.AttributeChange;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.compare.Activator;
import org.obeonetwork.dsl.database.dbevolution.DBDiff;

public abstract class ChangeBuilder {
	
	protected EClass semanticType;
	
	public ChangeBuilder(EClass semanticType) {
		this.semanticType = semanticType;
	}
	
	protected void log(String msg) {
		Activator.getDefault().logWarning(msg);
	}
	
	protected Diff handleAddChange(ReferenceChange change) {
		if (change.getKind() == DifferenceKind.ADD) {
			Activator.getDefault().logWarning("[DatabaseComparison] handleAddChange : should be implemented for '" + change + "' in " + this.getClass().getSimpleName());
		}		
		return null;
	}

	protected Diff handleRemoveChange(ReferenceChange change) {
		if (change.getKind() == DifferenceKind.DELETE) {
			Activator.getDefault().logWarning("[DatabaseComparison] handleRemoveChange : should be implemented for '" + change + "' in " + this.getClass().getSimpleName());
		}
		return null;
	}

	protected Diff handleAlterChange(Match match) {
		Activator.getDefault().logWarning("[DatabaseComparison] handleAlterChange : should be implemented for '" + match + "' in " + this.getClass().getSimpleName());
		return null;
	}
	
	protected Diff handleAlterChange(AttributeChange change) {
		Activator.getDefault().logWarning("[DatabaseComparison] handleAlterChange : should be implemented for '" + change + "' in " + this.getClass().getSimpleName());
		return null;
	}
	
	protected Diff handleAlterChange(ReferenceChange change) {
		Activator.getDefault().logWarning("[DatabaseComparison] handleAlterChange : should be implemented for '" + change + "' in " + this.getClass().getSimpleName());
		return null;
	}
	
	protected boolean isAdd(Diff diff) {
		return diff instanceof ReferenceChange && diff.getKind() == DifferenceKind.ADD;
	}
	
	protected boolean isDelete(Diff diff) {
		return diff instanceof ReferenceChange && diff.getKind() == DifferenceKind.DELETE;
	}
	
	public boolean canHandle(EObject obj) {
		if (obj instanceof Diff) {
			Diff diff = (Diff) obj;
			if (isAdd(diff)) {	
				return semanticType.isInstance(((ReferenceChange) diff).getValue());				
			} else if (isDelete(diff)) {				
				return semanticType.isInstance(((ReferenceChange) diff).getValue());				
			} else if (diff.getKind() == DifferenceKind.CHANGE) {
				if (diff instanceof AttributeChange) {
					return semanticType.isInstance(((AttributeChange) diff).getMatch().getRight());
				}
				if (diff instanceof ReferenceChange) {
					return semanticType.isInstance(((ReferenceChange) diff).getMatch().getRight());
				}
			}
			return false;
		} else if (obj instanceof Match
				&& ((Match)obj).getRight() != null 
				&& ((Match)obj).getLeft() != null) {
			return semanticType.isInstance(((Match)obj).getRight());
		}
		return false;
	}
	
	public Diff handle(EObject obj) {
		Diff newElement = null;
		
		if (obj instanceof Diff) {
			Diff diff = (Diff)obj;
			
			if (isAdd(diff)) {				
				newElement = handleAddChange((ReferenceChange) diff);				
			} else if (isDelete(diff)) {
				newElement = handleRemoveChange((ReferenceChange) diff);
			} else if (diff.getKind() == DifferenceKind.CHANGE) {
				if (diff instanceof AttributeChange) {
					// Do not take care of tech Id
					AttributeChange attributeChange = (AttributeChange)diff;
					if (DatabasePackage.eINSTANCE.getDatabaseElement_TechID() != attributeChange.getAttribute()) {
						newElement = handleAlterChange(attributeChange);						
					}
				}
				if (diff instanceof ReferenceChange) {
					newElement = handleAlterChange((ReferenceChange)diff);
				}
			}
			
			// Attach newly created element to its parent
			if (newElement != null) {
				newElement.getRefinedBy().add(diff);
				diff.getMatch().getDifferences().add(newElement);
			}	
			
		} else if (obj instanceof Match) {
			
			if (((Match)obj).getAllDifferences().iterator().hasNext()) {
				newElement = handleAlterChange((Match)obj);
			}
			
			if (newElement != null) {	
				
				Match parent = null;
				EObject container = ((Match) obj).eContainer();
				if (container instanceof Match) {
					parent = (Match) container;
				} else {
					parent = ((Match) obj);
				}
				
				parent.getDifferences().add(newElement);			
			}	
			
		}
		
		return newElement;
	}
	
	protected void fillDBDiff(DBDiff newChange, ReferenceChange change) {
		newChange.setTarget(change.getValue());
		newChange.setSource(change.getSource()); // FIXME needed ?
	}
	
	protected void fillDBDiff(DBDiff newChange, Match match) {
		newChange.setTarget(match.getRight());
	}

	protected static EObject getValue(Match match) {
		EObject result = match.getRight();
		if (result == null) {
			result = match.getLeft();
		}
		return result;
	}
	
	protected static boolean isAddedOnLeft(EObject obj, Comparison comparison) {
		Match match = comparison.getMatch(obj);
		return match.getLeft() == obj && match.getRight() == null && match.getOrigin() == null;
	}
	
}
