package org.obeonetwork.acceleo.utils;

import org.eclipse.acceleo.internal.parser.compiler.IAcceleoParserURIHandler;
import org.eclipse.emf.common.util.URI;

public class AcceleoParserURIHandler implements IAcceleoParserURIHandler {

	public static void main(String[] args) {
		URI uri = URI.createURI("jar:file:/home/glefur/Pro/repositories/InformationSystem/generators/java/plugins/org.obeonetwork.dsl.environment.gen.java.common/target/org.obeonetwork.dsl.environment.gen.java.common-2.4.0-SNAPSHOT.jar!/org/obeonetwork/dsl/environment/gen/java/common/datatype.emtl");
		AcceleoParserURIHandler handler = new AcceleoParserURIHandler();
		URI transform = handler.transform(uri);
	}
	
	public URI transform(URI uri) {
		URI newURI = uri;
		if (newURI.toString().startsWith("jar:file:")) {
            int indexOf = newURI.toString().indexOf(".jar!/");
            if (indexOf != -1) {
                    String name = newURI.toString();
                    name = name.substring(0, indexOf);
                    name = name.substring("jar:file:".length() + 1);
                    if (name.endsWith("-SNAPSHOT")) {
                            name = name.substring(0, name.length() - "-SNAPSHOT".length());
                    }

                    name = name.substring(0, name.lastIndexOf("-"));
                    if (name.contains("/")) {
                            name = name.substring(name.lastIndexOf("/"));
                            name = name + "/";
                    }
                    name = "platform:/plugin" + name + newURI.toString().substring(indexOf + ".jar!/".length());
                    newURI = URI.createURI(name);
            }
    }
        return newURI;
	}

}
