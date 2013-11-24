package org.obeonetwork.dsl.soa.gen.contracts.services;
         
import org.eclipse.emf.common.util.EList;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.MetaData;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
/**
 * A service that helps retrieving constraints posted on ObeoDSMObject.
 * @author Laurent Broudoux
 */
public class ConstraintsServices {

	/** The constructor. */
	public ConstraintsServices(){
        // prevent instantiation.
    }
	
	public static int getStringConstraintMinLength(ObeoDSMObject dsmObject){
		if (dsmObject.getMetadatas() != null){
			return getStringConstraintMinLength(dsmObject.getMetadatas().getMetadatas());
		}
		return -1;
	}
	
    private static int getStringConstraintMinLength(EList<MetaData> metadatas){
    	for (MetaData metadata : metadatas){
			// Find string constraint.
			Annotation constraint = null;
			if (metadata instanceof Annotation){
				constraint = (Annotation)metadata;
			}
            if (constraint != null && constraint.getTitle().indexOf("@Size") != -1){
                String value = null;
                int minPos = constraint.getBody().indexOf("min=");
                if (minPos != -1){
                    int comPos = constraint.getBody().indexOf(',');
                    // min=2, max=60
                    if (minPos < comPos){
                        value = constraint.getBody().substring(minPos + 4, comPos);
                    }
                    // max=60, min=2 or min=2
                    else if (minPos > comPos){
                        value = constraint.getBody().substring(minPos + 4, constraint.getBody().length());
                    }
                }
                if (value != null){
                    value = value.trim();
                    try{
                        return Integer.parseInt(value);
                    } catch (NumberFormatException nfe){
                        // Nothing to do here, default value (-1) will be returned.
                    }
                }
            };
        }
		return -1;
	}

	public static int getStringConstraintMaxLength(ObeoDSMObject dsmObject){
    	if (dsmObject.getMetadatas() != null){
    		return getStringConstraintMaxLength(dsmObject.getMetadatas().getMetadatas());
    	}
    	return -1;
	}
	
	private static int getStringConstraintMaxLength(EList<MetaData> metadatas) {
    	for (MetaData metadata : metadatas){
            // Find string constraint.
    		Annotation constraint = null;
			if (metadata instanceof Annotation){
				constraint = (Annotation)metadata;
			}
            if (constraint != null && constraint.getTitle().indexOf("@Size") != -1){
                String value = null;
                int maxPos = constraint.getBody().indexOf("max=");
                if (maxPos != -1){
                    int comPos = constraint.getBody().indexOf(',');
                    // max=60, min=2
                    if (comPos > maxPos){
                        value = constraint.getBody().substring(maxPos + 4, comPos);
                    }
                    // min=2, max=60 or max=60
                    else if (maxPos > comPos){
                        value = constraint.getBody().substring(maxPos + 4, constraint.getBody().length());
                    }
                }
                if (value != null){
                    value = value.trim();
                    try{
                        return Integer.parseInt(value);
                    } catch (NumberFormatException nfe){
                        // Nothing to do here, default value (-1) will be returned.
                    }
                }
            }
        }
        return -1;
    }
   
    public static int getIntegerConstraintMinValue(ObeoDSMObject dsmObject){
    	if (dsmObject.getMetadatas() != null){
    		return getIntegerConstraintMinValue(dsmObject.getMetadatas().getMetadatas());
    	}
    	return 55;
    }
    
    private static int getIntegerConstraintMinValue(EList<MetaData> metadatas){
        for (MetaData metadata : metadatas){
            // Find integer constraint.
        	Annotation constraint = null;
			if (metadata instanceof Annotation){
				constraint = (Annotation)metadata;
			}
            if (constraint != null && constraint.getTitle().indexOf("@Value") != -1){
                String value = null;
                int minPos = constraint.getBody().indexOf("min=");
                if (minPos != -1){
                    int comPos = constraint.getBody().indexOf(',');
                    // min=2, max=60
                    if (minPos < comPos){
                        value = constraint.getBody().substring(minPos + 4, comPos);
                    }
                    // max=60, min=2 or min=2
                    else if (comPos < minPos){
                        value = constraint.getBody().substring(minPos + 4, constraint.getBody().length());
                    }
                }
                if (value != null){
                    value = value.trim();
                    try{
                        return Integer.parseInt(value);
                    } catch (NumberFormatException nfe){
                        // Nothing to do here, default value (-1) will be returned.
                    }
                }
            }
        }
        return -1;
    }
   
    public static int getIntegerConstraintMaxValue(ObeoDSMObject dsmObject){
    	if (dsmObject.getMetadatas() != null){
    		return getIntegerConstraintMaxValue(dsmObject.getMetadatas().getMetadatas());
    	}
    	return -1;
    }
    
    private static int getIntegerConstraintMaxValue(EList<MetaData> metadatas){
        for (MetaData metadata : metadatas){
            // Find integer constraint.
        	Annotation constraint = null;
			if (metadata instanceof Annotation){
				constraint = (Annotation)metadata;
			}
            if (constraint != null && constraint.getTitle().indexOf("@Value") != -1){
                String value = null;
                int maxPos = constraint.getBody().indexOf("max=");
                if (maxPos != -1){
                    int comPos = constraint.getBody().indexOf(',');
                    // max=60, min=2
                    if (maxPos < comPos){
                        value = constraint.getBody().substring(maxPos + 4, comPos);
                    }
                    // min=2, max=60 or max=60
                    else if (maxPos > comPos){
                        value = constraint.getBody().substring(maxPos + 4, constraint.getBody().length());
                    }
                }
                if (value != null){
                    value = value.trim();
                    try{
                        return Integer.parseInt(value);
                    } catch (NumberFormatException nfe){
                        // Nothing to do here, default value (-1) will be returned.
                    }
                }
            }
        }
        return -1;
    }
}
