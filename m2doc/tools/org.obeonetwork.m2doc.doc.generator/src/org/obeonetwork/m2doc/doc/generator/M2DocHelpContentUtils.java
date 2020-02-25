/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.m2doc.doc.generator;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.eclipse.acceleo.annotations.api.documentation.Documentation;
import org.eclipse.acceleo.annotations.api.documentation.Example;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.DiagramImportDescription;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.sirius.table.metamodel.table.description.TableDescription;
import org.eclipse.sirius.tree.description.TreeDescription;
import org.eclipse.sirius.viewpoint.description.Group;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.RepresentationImportDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.obeonetwork.m2doc.doc.generator.reflection.OEcoreUtil;

/**
 * Utility class used to compute the html of the documentation.
 * 
 * @author <a href="mailto:vincent.richard@obeo.fr">Vincent Richard</a>
 */
// CHECKSTYLE:OFF
public final class M2DocHelpContentUtils {

	/**
	 * Line separator.
	 */
	private static final String LS = System.getProperty("line.separator");

	/**
	 * The constructor.
	 */
	private M2DocHelpContentUtils() {
		// Prevent instantiation
	}

	/**
	 * Produces the HTML page.
	 * 
	 * @param head The content of the head
	 * @param body The content of the body
	 * @return The HTML content
	 */
	public static StringBuffer html(StringBuffer head, StringBuffer body) {
		// @formatter:off
		StringBuffer buffer = new StringBuffer();
		buffer.append("<!DOCTYPE html>").append(LS);
		buffer.append("<html lang=\"en\">").append(LS);
		buffer.append("<!--").append(LS);
		buffer.append("/********************************************************************************").append(LS);
		buffer.append("** Copyright (c) 2016, 2017, 2018, 2019, 2020 Obeo.").append(LS);
		buffer.append("** All rights reserved. This program and the accompanying materials").append(LS);
		buffer.append("** are made available under the terms of the Eclipse Public License v1.0").append(LS);
		buffer.append("** which accompanies this distribution, and is available at").append(LS);
		buffer.append("** http://www.eclipse.org/legal/epl-v10.html").append(LS);
		buffer.append("**").append(LS);
		buffer.append("** Contributors:").append(LS);
		buffer.append("**    Obeo - initial API and implementation").append(LS);
		buffer.append("*********************************************************************************/").append(LS);
		buffer.append("-->").append(LS);

		buffer.append(head).append(LS);
		buffer.append(body).append(LS);

		buffer.append("</html>").append(LS);
		// @formatter:on
		return buffer;
	}

	/**
	 * Produces the head element.
	 * 
	 * @return The content of the head element
	 */
	public static StringBuffer head(boolean isMainPage, String subject, String pluginName) {

		// @formatter:off
		StringBuffer headBuffer = new StringBuffer();
		headBuffer.append("  <head>").append(LS);
		headBuffer.append("    <meta charset=\"utf-8\"/>").append(LS);
		headBuffer.append("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\"/>").append(LS);
		headBuffer.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>").append(LS);
		headBuffer.append("    <meta name=\"description\" content=\"\"/>").append(LS);
		headBuffer.append("    <meta name=\"author\" content=\"Obeo\"/>").append(LS);

		headBuffer.append("    <!-- IE6-8 support of HTML elements -->").append(LS);
		headBuffer.append("    <!--if lt IE 9>").append(LS);
		headBuffer.append("      <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>")
				.append(LS);
		headBuffer.append("    <!endif-->").append(LS);

		headBuffer.append("    <link href=\"../assets/css/bootstrap.css\" rel=\"stylesheet\"/>").append(LS);
		headBuffer.append("    <link href=\"../assets/css/docs.css\" rel=\"stylesheet\"/>").append(LS);
		headBuffer.append("    <title>M2Doc Services and attributes for " + subject + "</title>").append(LS);

		if (!isMainPage) {
		} else {
			headBuffer.append(
					"    <script src=\"../../../../advanced/synchWithToc.js\" type=\"text/javascript\" xml:space=\"preserve\"><!-- --></script>")
					.append(LS);
			headBuffer.append(
					"    <link charset=\"ISO-8859-1\" href=\"../../../../content/org.eclipse.help.webapp/advanced/breadcrumbs.css\" rel=\"stylesheet\" type=\"text/css\"/>")
					.append(LS);
			headBuffer.append(
					"    <script src=\"../../../../content/org.eclipse.help/livehelp.js\" type=\"text/javascript\" xml:space=\"preserve\"> </script>")
					.append(LS);
			headBuffer.append("    <script type=\"text/javascript\">").append(LS);
			headBuffer.append("    if( self == top ){").append(LS);
			headBuffer.append(
					"    var  anchorParam = location.hash.length > 0 ? '\\u0026anchor=' + location.hash.substr(1) : '';")
					.append(LS);
			headBuffer.append("    window.location.replace( \"../../../../index.jsp?topic=%2F" + pluginName
					+ "%2Fdoc%2Fpages%2FTask_services.html\" + anchorParam);").append(LS);
			headBuffer.append("    }").append(LS);
			headBuffer.append("    </script>").append(LS);

		}

		headBuffer.append("  </head>").append(LS);

		// @formatter:on
		return headBuffer;
	}

	private static StringBuffer header() {
		StringBuffer buffer = new StringBuffer();
		// @formatter:off
		buffer.append("   <header class=\"jumbotron subhead\" id=\"overview\">").append(LS);
		buffer.append("  </header>").append(LS);
		// @formatter:on
		return buffer;
	}

	/**
	 * Computes the content of the toc.xml file.
	 * 
	 * @param metaClasses The list of Java classes providing services to M2Doc.
	 * @return The content of the toc.xml
	 */
	public static StringBuffer computeToc(String metamodelName, Collection<Class<?>> metaClasses) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append(LS);
		buffer.append("<?NLS TYPE=\"org.eclipse.help.toc\"?>").append(LS);
		buffer.append("<toc label=\"M2Doc : " + metamodelName + " services\" topic=\"doc/pages/index.html\">")
				.append(LS);
		for (Class<?> metaClass : metaClasses) {
			buffer.append("<topic href=\"doc/pages/" + computeHtmlFileName(metaClass)
					+ "\" label=\"M2Doc Services and Attributes for " + computeMetaClassName(metaClass) + "\"></topic>")
					.append(LS);
		}
		buffer.append("</toc>").append(LS);
		return buffer;
	}

	private static String prettySimpleName(Class<?> argType) {
		String typeName = argType.getCanonicalName();
		if ("org.eclipse.acceleo.query.runtime.impl.LambdaValue".equals(typeName)) {
			typeName = " x | ... ";
		}
		if (typeName.startsWith("java.lang") || typeName.startsWith("java.util")
				|| EObject.class.isAssignableFrom(argType)) {
			typeName = argType.getSimpleName();
		}
		if (typeName.startsWith("org.eclipse.emf")) {
			typeName = argType.getSimpleName();
		}
		if ("List".equals(typeName)) {
			typeName = "List";
		}
		if ("Set".equals(typeName)) {
			typeName = "Set";
		}
		return typeName;
	}

	private static String getPrettyGenericTypename(Type type, Class<?> argType) {
		String typename = prettySimpleName(argType);
		if (type instanceof Class<?>) {
			typename = prettySimpleName((Class<?>) type);
		} else if (type instanceof ParameterizedType) {
			String canonical = ((Class<?>) argType).getCanonicalName();
			Type t = ((ParameterizedType) type).getActualTypeArguments()[0];
			if (t instanceof Class<?>) {
				if ("java.util.Set".equals(canonical)) {
					typename = "Set of " + prettySimpleName((Class<?>) t);
				} else if ("java.util.List".equals(canonical) || "java.util.Collection".equals(canonical)) {
					typename = "List of " + prettySimpleName((Class<?>) t);
				} else {
					typename = "{" + prettySimpleName((Class<?>) t) + "}";
				}

			}
		}
		return typename;

	}

	private static StringBuffer computeAttributeM2DocSyntax(EClass eClass, EStructuralFeature feature) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("{m:");
		buffer.append(StringUtils.uncapitalize(eClass.getName()));
		buffer.append(".");
		buffer.append(feature.getName());
		buffer.append("}");

		return buffer;
	}

	private static String computeAttributeDescription(EStructuralFeature feature) {
		String doc = EcoreUtil.getDocumentation(feature);
		if (doc == null)
			doc = "";

		return doc;
	}

	private static StringBuffer computeAttributeExample(EClass eClass, EStructuralFeature feature) {
		StringBuffer buffer = new StringBuffer();

		if (feature.isMany()) {
//    		{m:for table | db.tables()} table {m:table.name}, {m:endfor}
			buffer.append("{m:for ");
			buffer.append(StringUtils.uncapitalize(feature.getEType().getName()));
			buffer.append(" | ");
			buffer.append(StringUtils.uncapitalize(eClass.getName()));
			buffer.append(".");
			buffer.append(feature.getName());
			buffer.append("} ");
			buffer.append(StringUtils.uncapitalize(feature.getEType().getName()));
			buffer.append(" {m:");
			buffer.append(StringUtils.uncapitalize(feature.getEType().getName()));
			buffer.append(".name}, {m:endfor}");
		} else {
			buffer.append(computeAttributeM2DocSyntax(eClass, feature));
		}

		return buffer;
	}

	private static StringBuffer computeAttributeTableRow(EClass eClass, EStructuralFeature feature) {
		StringBuffer tableRowBuffer = new StringBuffer();
		tableRowBuffer.append("    <tr>").append(LS);
		tableRowBuffer.append("      <td colspan=\"1\" rowspan=\"1\"><strong>" + feature.getName() + "</strong></td>")
				.append(LS); // Name
		tableRowBuffer.append("      <td colspan=\"1\" rowspan=\"1\">" + prettyReturnType(feature) + "</td>")
				.append(LS); // Returned type
		tableRowBuffer.append(
				"      <td colspan=\"1\" rowspan=\"1\">" + computeAttributeM2DocSyntax(eClass, feature) + "</td>")
				.append(LS); // M2Doc Syntax
		tableRowBuffer.append("      <td colspan=\"1\" rowspan=\"1\">" + computeAttributeDescription(feature) + "</td>")
				.append(LS); // Description
		tableRowBuffer
				.append("      <td colspan=\"1\" rowspan=\"1\">" + computeAttributeExample(eClass, feature) + "</td>")
				.append(LS); // Example
		tableRowBuffer.append("    </tr>").append(LS);

		return tableRowBuffer;
	}

	private static StringBuffer prettyReturnType(EStructuralFeature feature) {
		StringBuffer buffer = new StringBuffer();
		if (feature.isMany()) {
			if (feature.isUnique()) {
				buffer.append("List of ");
			} else {
				buffer.append("Set of ");
			}
			buffer.append(feature.getEType().getName());
		} else {
			buffer.append(feature.getEType().getName());
		}
		return buffer;
	}

	private static StringBuffer computeServiceTableRow(Method service) {
		StringBuffer tableRowBuffer = new StringBuffer();

		String comment = "";
		String value = "";
		if (service.getAnnotation(Documentation.class) != null) {
			Documentation documentation = service.getAnnotation(Documentation.class);
			comment = documentation.comment();
			value = documentation.value();
		}

		tableRowBuffer.append("    <tr>").append(LS);
		tableRowBuffer.append("      <td colspan=\"1\" rowspan=\"1\"><strong>" + service.getName() + "</strong></td>")
				.append(LS); // Name
		tableRowBuffer
				.append("      <td colspan=\"1\" rowspan=\"1\">"
						+ getPrettyGenericTypename(service.getGenericReturnType(), service.getReturnType()) + "</td>")
				.append(LS); // Returned type
		tableRowBuffer.append("      <td colspan=\"1\" rowspan=\"1\">" + comment + "</td>").append(LS); // M2Doc Syntax
		tableRowBuffer.append("      <td colspan=\"1\" rowspan=\"1\">" + value + "</td>").append(LS); // Description
		tableRowBuffer.append("      <td colspan=\"1\" rowspan=\"1\">" + computeExample(service) + "</td>").append(LS); // Example
		tableRowBuffer.append("    </tr>").append(LS);

		return tableRowBuffer;
	}

	private static StringBuffer computeAttributeTableRows(Class<?> metaClass) {
		StringBuffer tableRowBuffer = new StringBuffer();

		EClass eClass = OEcoreUtil.getEClass(metaClass);

		for (EStructuralFeature feature : eClass.getEAllStructuralFeatures().stream()
				.sorted((f1, f2) -> f1.getName().compareTo(f2.getName())).collect(Collectors.toList())) {
			tableRowBuffer.append(computeAttributeTableRow(eClass, feature));
		}

//		for(Method method : Arrays.asList(metaClass.getMethods()).stream().sorted((m1, m2) -> m1.getName().compareTo(m2.getName())).collect(Collectors.toList())) {
//			tableRowBuffer.append(computeAttributeTableRow(metaClass, method));
//		}
		return tableRowBuffer;
	}

	private static StringBuffer computeServiceTableRows(Class<?> metaClass, List<Method> services) {
		StringBuffer tableRowBuffer = new StringBuffer();

		for (Method service : getCompatibleServices(metaClass, services)) {
			tableRowBuffer.append(computeServiceTableRow(service));
		}
		return tableRowBuffer;
	}

	private static StringBuffer computeTable(Class<?> metaClass, String sectionName,
			Function<Class<?>, StringBuffer> computeTableRows) {
		StringBuffer servicesSection = new StringBuffer();
		servicesSection.append("    <div class=\"page-header\">").append(LS);
		servicesSection.append("      <h2 id=\"" + sectionName + "\">" + sectionName + "</h2>").append(LS);
		servicesSection.append("    </div>").append(LS);
		servicesSection.append("    <table class=\"table table-striped\">").append(LS);
		servicesSection.append("    <thead>").append(LS);
		servicesSection.append("      <tr>").append(LS);
		servicesSection.append("        <th colspan=\"1\" rowspan=\"1\">Name</th>").append(LS);
		servicesSection.append("        <th colspan=\"1\" rowspan=\"1\">Returned type</th>").append(LS);
		servicesSection.append("        <th colspan=\"1\" rowspan=\"1\">M2Doc Syntax</th>").append(LS);
		servicesSection.append("        <th colspan=\"1\" rowspan=\"1\">Description</th>").append(LS);
		servicesSection.append("        <th colspan=\"1\" rowspan=\"1\">Example</th>").append(LS);
		servicesSection.append("      </tr>").append(LS);
		servicesSection.append("    </thead>").append(LS);
		servicesSection.append("  <tbody>").append(LS);

		servicesSection.append(computeTableRows.apply(metaClass));

		servicesSection.append("    </tbody>").append(LS);
		servicesSection.append("    </table>").append(LS);

		return servicesSection;
	}

	public static StringBuffer computeIndexBody(String metamodelName, Collection<Class<?>> metaClasses,
			List<Viewpoint> viewPoints) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("  <body>").append(LS);
		buffer.append("  <div class=\"container\">").append(LS);

		buffer.append(header()).append(LS);

		buffer.append("  <div class=\"jumbotron masthead\">").append(LS);
		buffer.append("    <h1>" + metamodelName + " package</h1>").append(LS);
		buffer.append("  </div>").append(LS);

		buffer.append("  <div class=\"marketing\">").append(LS);
		buffer.append("    <h1></h1>").append(LS);
		buffer.append("  </div>").append(LS);

		buffer.append("  <section id=\"overview\">").append(LS);
		buffer.append("    <div class=\"page-header\">").append(LS);
		buffer.append("      <h1>Overview</h1>").append(LS);
		buffer.append("    </div>").append(LS);
		buffer.append("    <p>").append(LS);
		buffer.append("      <p>This documentation describes services and attributes available on the " + metamodelName
				+ " concepts available in M2Doc generation templates.</p>").append(LS);
		buffer.append(
				"      <p>Each concept is described in a page of it's own. Services and attributes are described using</p>")
				.append(LS);
		buffer.append("      <ul>").append(LS);
		buffer.append("        <li>a name,</li>").append(LS);
		buffer.append("        <li>the syntax to be used in M2Doc generation templates,</li>").append(LS);
		buffer.append("        <li>a description.</li>").append(LS);
		buffer.append("      </ul>").append(LS);
		buffer.append("      <p>For some attributes and services, a usage example is provided.</p>").append(LS);
		buffer.append("    </p>").append(LS);
		buffer.append("  </section>").append(LS);

		buffer.append("  <h1>Documentation of M2Doc Services for the " + metamodelName + " package</h1>").append(LS);
		buffer.append("  <p>Each concept of " + metamodelName + " is documented in it's own page :</p>").append(LS);

		buffer.append("  <ul>").append(LS);
		for (Class<?> metaClass : metaClasses) {
			buffer.append("    <li>M2Doc Services and Attributes for <a href=\"./" + computeHtmlFileName(metaClass)
					+ "\">" + computeMetaClassName(metaClass) + "</a></li>").append(LS);

		}
		buffer.append("  </ul>").append(LS);

		if (!viewPoints.isEmpty()) {
			buffer.append("  <section id=\"viewpoint\">").append(LS);
			buffer.append("    <div class=\"page-header\">").append(LS);
			buffer.append("      <h1>Viewpoints</h1>").append(LS);
			buffer.append("    </div>").append(LS);
			for (Viewpoint vp : viewPoints) {
				final boolean isSafranIS = "safran-is".equals(((Group) vp.eContainer()).getName());
				if (hasRelatedRepresentations(metamodelName, vp, isSafranIS)) {
					if (vp.getLabel() != null) {
						buffer.append("      <h2>" + vp.getLabel() + "</h2>").append(LS);
					} else {
						buffer.append("      <h2>" + vp.getName() + "</h2>").append(LS);
					}
					buffer.append("    <p>").append(LS);
					buffer.append(vp.getEndUserDocumentation());
					buffer.append("    </p>").append(LS);
					for (RepresentationDescription representation : vp.getOwnedRepresentations()) {
						if (isSafranIS && !isRelated(metamodelName, representation)) {
							continue;
						}
						if (representation instanceof DiagramImportDescription) {
							representation = ((DiagramImportDescription) representation).getImportedDiagram();
						}
						if (representation instanceof DiagramDescription) {
							if (representation.getLabel() != null) {
								buffer.append("            <h3>Diagram " + representation.getLabel() + "</h3>")
										.append(LS);
							} else {
								buffer.append("            <h3>Diagram " + representation.getName() + "</h3>")
										.append(LS);
							}
							buffer.append("    <p>ID: ").append(LS);
							buffer.append(representation.getName());
							buffer.append("    </p>").append(LS);
							buffer.append("    <p>Layers:<ul>").append(LS);
							for (Layer layer : ((DiagramDescription) representation).getAllLayers()) {
								if (layer.getLabel() != null) {
									buffer.append(
											"        <li>" + layer.getLabel() + " (ID: " + layer.getName() + ")</lil>")
											.append(LS);
								} else {
									buffer.append(
											"        <li>" + layer.getName() + " (ID: " + layer.getName() + ")</lil>")
											.append(LS);
								}
							}
							buffer.append("    </ul></p>").append(LS);
						} else if (representation instanceof TableDescription) {
							if (representation.getLabel() != null) {
								buffer.append("            <h3>Table " + representation.getLabel() + "</h3>")
										.append(LS);
							} else {
								buffer.append("            <h3>Table " + representation.getName() + "</h3>").append(LS);
							}
							buffer.append("    <p>ID: ").append(LS);
							buffer.append(representation.getName());
							buffer.append("    </p>").append(LS);
						}
					}
				}
			}

			buffer.append("  </section>").append(LS);
		}

		buffer.append("  </div>").append(LS);
		buffer.append("  </body>").append(LS);

		return buffer;
	}

	private static boolean isRelated(String metamodelName, RepresentationDescription representation) {
		return getDomainClass(representation).startsWith(metamodelName.toLowerCase() + ".");
	}

	private static boolean hasRelatedRepresentations(String metamodelName, Viewpoint vp, boolean isSafranIS) {
		final boolean res;
		
		if (isSafranIS) {
			boolean foundRelated = false;
			for (RepresentationDescription representation : vp.getOwnedRepresentations()) {
				if (isRelated(metamodelName, representation)) {
					foundRelated = true;
					break;
				}
			}
			res = foundRelated;
		} else {
			res = true;	
		}
		
		return res;
	}

	private static String getDomainClass(RepresentationDescription representation) {
		final String res;

		if (representation instanceof DiagramDescription) {
			res = ((DiagramDescription) representation).getDomainClass();
		} else if (representation instanceof TableDescription) {
			res = ((TableDescription) representation).getDomainClass();
		} else if (representation instanceof TreeDescription) {
			res = ((TreeDescription) representation).getDomainClass();
		} else {
			res = "";
		}

		return res;
	}

	public static StringBuffer computeMetaClassBody(String metamodelName, String pluginName, Class<?> metaClass,
			List<Method> services, boolean isExternal) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("  <body>").append(LS);
		buffer.append(header()).append(LS);
		buffer.append("    <h1 id=\"" + computeMetaClassName(metaClass) + "\">Services and attributes for the "
				+ computeMetaClassName(metaClass) + " concept</h1>").append(LS);

		EClass eClass = OEcoreUtil.getEClass(metaClass);
		if (EcoreUtil.getDocumentation(eClass) != null) {
			buffer.append("    <p>" + EcoreUtil.getDocumentation(eClass) + "</p>").append(LS);
		}

		if (!isExternal) {
			buffer.append(computeTable(metaClass, "Attributes", c -> computeAttributeTableRows(c)));
		}

		buffer.append(computeTable(metaClass, "Services", c -> computeServiceTableRows(c, services)));

		buffer.append("  </body>").append(LS);

		return buffer;
	}

	private static StringBuffer computeExample(Method service) {
		StringBuffer exampleBuffer = new StringBuffer();
		Documentation documentation = service.getAnnotation(Documentation.class);
		if (documentation != null) {
			for (int i = 0; i < documentation.examples().length; i++) {
				Example example = documentation.examples()[i];
				exampleBuffer.append(example.expression());
				if (example.result() != null && example.result().length() > 0) {
					exampleBuffer.append(" returns: ");
					exampleBuffer.append(example.result());
				}
				if (i < documentation.examples().length - 1) {
					exampleBuffer.append(";<br>");
				}
			}
		}

		return exampleBuffer;
	}

	private static List<Method> getCompatibleServices(Class<?> metaClass, List<Method> services) {
		List<Method> compatibleServices = new ArrayList<>();
		for (Method service : services) {
			if (service.getParameterCount() > 0 && service.getParameters()[0].getType().isAssignableFrom(metaClass)) {
				compatibleServices.add(service);
			}
		}
		return compatibleServices;
	}

	public static String computeMetaClassName(Class<?> metaClass) {
		return metaClass.getSimpleName();
	}

	/**
	 * Prefix used to create internal links.
	 */
	public static String computeHtmlFileName(Class<?> metaClass) {
		return "m2doc_services_" + computeMetaClassName(metaClass).toLowerCase() + ".html";
	}

}
// CHECKSTYLE:ON
