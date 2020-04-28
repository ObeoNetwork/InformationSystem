package org.obeonetwork.dsl.soa.gen.swagger.preview.webserver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.obeonetwork.dsl.soa.gen.swagger.preview.Activator;
import org.osgi.framework.Bundle;

import com.google.common.io.ByteStreams;

public class SwaggerPreviewHttpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        Bundle bundle = Activator.getDefault().getBundle();
        URL url = bundle.getEntry("/dist" + req.getPathInfo());
        try {
        	// Mime types handling
        	if(req.getPathInfo().endsWith(".html")) {
				resp.setContentType("text/html");
			} else if(req.getPathInfo().endsWith(".css")) {
				resp.setContentType("text/css");
			} else if(req.getPathInfo().endsWith(".js")) {
				resp.setContentType("application/javascript");
			} else if(req.getPathInfo().endsWith(".js.map")) {
				resp.setContentType("application/octet-stream");
			} else if(req.getPathInfo().endsWith(".yaml")) {
				resp.setContentType("application/yaml");
			} else if(req.getPathInfo().endsWith(".json")) {
				resp.setContentType("application/json");
			}
			
			if (url != null) {
				InputStream inputStream = url.openStream();
				ServletOutputStream outputStream = resp.getOutputStream();
				ByteStreams.copy(inputStream, outputStream);
			} else {
				String swaggerFileName = URLDecoder.decode(req.getPathInfo().substring(1), "UTF-8");
				File swaggerFile = SwaggerPreviewJettyServer.instance().getSwaggerFile(swaggerFileName);
				if(swaggerFile != null) {
					Files.copy(swaggerFile.toPath(), resp.getOutputStream());
				} else {
					resp.getWriter().write("404 not found");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
