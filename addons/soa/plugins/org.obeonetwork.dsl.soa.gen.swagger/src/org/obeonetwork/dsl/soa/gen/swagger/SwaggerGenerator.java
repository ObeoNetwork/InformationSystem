package org.obeonetwork.dsl.soa.gen.swagger;

import java.io.File;
import java.io.IOException;

import org.obeonetwork.dsl.soa.System;

public class SwaggerGenerator {
	
    public enum MapperType {
        YAML, JSON;
    }

	public static void generateInDir(System system, MapperType mapperType, File outputDir) throws IOException {
		String systemName = (system.getName() == null || system.getName().isEmpty())? "UnnamedSystem" : system.getName();
		
//		java.lang.System.out.println(system);
//		java.lang.System.out.println(mapperType);
//		java.lang.System.out.println(outputDir);
		
        File outputFile = new File(outputDir, systemName + "." + mapperType.toString().toLowerCase());
        generateInFile(system, mapperType, outputFile);
		
	}

	private static void generateInFile(System system, MapperType mapperType, File outputFile) {
		SwaggerBuilder swaggerBuilder = new SwaggerBuilder(system);
		
        OpenAPI swagger = swaggerBuilder.build();
        
        ObjectMapper mapper = null;
        switch (mapperType) {
        case JSON:
            mapper = Json.mapper();
            break;
        case YAML:
            mapper = Yaml.mapper();
            break;
        }
        mapper.setSerializationInclusion(Include.NON_NULL);
        mapper.setSerializationInclusion(Include.NON_EMPTY);
        mapper.enable(MapperFeature.USE_ANNOTATIONS);

        mapper.writerWithDefaultPrettyPrinter().writeValue(outputFile, swagger);
	}

}
