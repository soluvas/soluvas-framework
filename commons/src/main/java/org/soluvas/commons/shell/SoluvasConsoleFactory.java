/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.soluvas.commons.shell;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import jline.Terminal;

import org.apache.felix.service.command.CommandProcessor;
import org.apache.felix.service.command.CommandSession;
import org.apache.felix.service.command.Function;
import org.apache.karaf.shell.console.jline.Console;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.ResourceUtils;

import blast.shell.CommandRegistry;
import blast.shell.jline.BlastConsole;
import blast.shell.jline.ConsoleFactory;

import com.google.common.base.Supplier;

/**
 * This is NOT a copy of Karaf's ConsoleFactory... it's a more traditional Factory.  It just returns a
 * Console implementation of our choice.
 */
public class SoluvasConsoleFactory implements ConsoleFactory {
    private static final Logger log = LoggerFactory.getLogger(SoluvasConsoleFactory.class);

    private CommandRegistry commandRegistry;
    private CommandProcessor commandProcessor;
    private Supplier<String> hotelIdSupplier;
    private Supplier<String> tenantIdSupplier;
    private Supplier<String> tenantEnvSupplier;

    String application = System.getProperty("karaf.name", "root");
    String welcomeMessage = null;
    String welcomeMessageFile = null;

    @Override
    public Console createConsole(InputStream in, PrintStream out, PrintStream err, final Terminal terminal, Runnable closeCallback) throws Exception {
        BlastConsole console = new BlastConsole(commandProcessor,
                in,
                out,
                err,
                terminal,
                closeCallback);
        // "Branding" properties are things like the welcome message, the prompt, and other places where it might say
        // the application name.
        console.setBrandingProperties(loadBrandingProperties());

        final CommandSession session = console.getSession();
        session.put("APPLICATION", getApplication());
        session.put("LINES", Integer.toString(terminal.getHeight()));
        session.put("COLUMNS", Integer.toString(terminal.getWidth()));
        session.put(".jline.terminal", terminal);
        session.put("#LINES", new Function() {
            @Override
			public Object execute(CommandSession session, List<Object> arguments) throws Exception {
                return Integer.toString(terminal.getHeight());
            }
        });
        session.put("#COLUMNS", new Function() {
            @Override
			public Object execute(CommandSession session, List<Object> arguments) throws Exception {
                return Integer.toString(terminal.getWidth());
            }
        });
        
        session.put("hotelId", hotelIdSupplier.get());
        session.put("tenantId", tenantIdSupplier.get());
        session.put("tenantEnv", tenantEnvSupplier.get());
        
        addSystemProperties(session);
        commandRegistry.registerCommandsInSession(session);
        return console;
    }

    @Required
    public void setCommandRegistry(CommandRegistry commandRegistry) {
        this.commandRegistry = commandRegistry;
    }

    @Required
    public void setCommandProcessor(CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
    }

    /**
	 * @return the application
	 */
	public String getApplication() {
		return application;
	}

	/**
	 * @param application the application to set
	 */
	public void setApplication(String application) {
		this.application = application;
	}

	/**
     * This takes precedence over welcomeMessageFile.
     *
     * @param welcomeMessage
     */
    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }
    
    /**
     * If welcomeMessage is set directly, we'll use that instead.  Otherwise, we'll load this file, which we'll expect
     * contains a property named "welcome":
     * <p/>
     * welcome=<some welcome message>.
     * <p/>
     * Any other properties will be ignored.
     *
     * @param welcomeMessageFile
     */
    public void setWelcomeMessageFile(String welcomeMessageFile) {
        this.welcomeMessageFile = welcomeMessageFile;
    }

    /**
     * Tries to load from welcomeMessage and then welcomeMessageFile, in that order... failing that, it will return
     * an empty Properties object.
     *
     * @return
     */
    protected Properties loadBrandingProperties() {
    	final Properties props = new Properties();
        if (welcomeMessage != null) {
            props.put("welcome", welcomeMessage);
        } else if (welcomeMessageFile != null) {
            try {
                final File brandingFile = ResourceUtils.getFile(welcomeMessageFile);
                props.load(new FileReader(brandingFile));
            } catch (IOException e) {
                log.error("Could not load file " + welcomeMessageFile + ": " + e, e);
            }
        }
        log.trace("Branding props: {}", props);
        return props;
    }

    private void addSystemProperties(CommandSession session) {
        Properties sysProps = System.getProperties();
        for (Map.Entry<Object, Object> entry : sysProps.entrySet()) {
            session.put((String) entry.getKey(), entry.getValue());
        }
    }
    
	/**
	 * @return the hotelIdSupplier
	 */
	public Supplier<String> getHotelIdSupplier() {
		return hotelIdSupplier;
	}

	/**
	 * @param hotelIdSupplier the hotelIdSupplier to set
	 */
	public void setHotelIdSupplier(Supplier<String> hotelIdSupplier) {
		this.hotelIdSupplier = hotelIdSupplier;
	}

	/**
	 * @return the tenantIdSupplier
	 */
	public Supplier<String> getTenantIdSupplier() {
		return tenantIdSupplier;
	}

	/**
	 * @param tenantIdSupplier the tenantIdSupplier to set
	 */
	public void setTenantIdSupplier(Supplier<String> tenantIdSupplier) {
		this.tenantIdSupplier = tenantIdSupplier;
	}

	/**
	 * @return the tenantEnvSupplier
	 */
	public Supplier<String> getTenantEnvSupplier() {
		return tenantEnvSupplier;
	}

	/**
	 * @param tenantEnvSupplier the tenantEnvSupplier to set
	 */
	public void setTenantEnvSupplier(Supplier<String> tenantEnvSupplier) {
		this.tenantEnvSupplier = tenantEnvSupplier;
	}

}

