/*
 * Copyright 2003,2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/* 

 */

package org.apache.pluto.core;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.pluto.PortletWindow;
import org.apache.pluto.binding.PortletAppDD;
import org.apache.pluto.binding.PortletDD;
import org.apache.pluto.binding.ServletDD;
import org.apache.pluto.binding.XMLBindingFactory;

/**
 * The PortletEntity encapsulates all data pertaining to a single portlet
 * instance.  This instance may appear zero or more times per user. The
 * PortletEntity consists of two primary peices of information, the Portlet
 * Definition as defined by the {@link PortletDD} and the Wrapping Servlet
 * information as defined by the{@link ServletDD}
 */
public class PortletEntity {
    private static final String PREFIX = "/PlutoInvoker/";

    private ServletContext ctx;
    private PortletWindow window;

    //  Looked up and Cached
    private PortletDD dd;

    PortletEntity(ServletContext ctx, PortletWindow window) {
        this.ctx = ctx;
        this.window = window;
    }

    /**
     * Returns all preferences of this portlet The return value cannot be NULL.
     * @return the preference set
     */
    public PortletPreference[] getDefaultPreferences() {
        return null;
    }

    /**
     * Returns the portlet description The return value cannot be NULL.
     * @return the portlet description
     */
    public PortletDD getPortletDefinition() {
        if (dd == null) {
            load();
        }
        return dd;

    }

    private void load() {
        ServletContext ctx = this.ctx.getContext(window.getContextPath());
        InputStream in = ctx.getResourceAsStream(PortletAppDD.PORTLET_XML);
        try {
            PortletAppDD appDD = XMLBindingFactory.createXMLBinding().getPortletAppDD(in);
            PortletDD[] dds = appDD.getPortlets();
            for (int i = 0; i < dds.length && dd == null; i++) {
                if (dds[i].getPortletName().equals(window.getPortletName())) {
                    dd = dds[i];
                }
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public String getControllerServletUri() {
        return PREFIX + window.getPortletName();
    }

}