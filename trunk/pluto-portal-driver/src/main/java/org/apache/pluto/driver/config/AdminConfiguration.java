/*
 * Copyright 2004 The Apache Software Foundation.
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
package org.apache.pluto.driver.config;

import org.apache.pluto.driver.services.portal.admin.DeployWarAdminService;
import org.apache.pluto.driver.services.portal.admin.PortletRegistryAdminService;
import org.apache.pluto.driver.services.portal.admin.ReassembleWarAdminService;
import org.apache.pluto.driver.services.portal.admin.RenderConfigAdminService;
import org.apache.pluto.driver.services.portal.admin.WarUploadAdminService;

import javax.servlet.ServletContext;

/**
 * Interface defining a means for obtaining administrative
 * services for portal configuration.  An implementation
 * of this interface will be bound to the portal's
 * ServletContext IF administrative functions are
 * supported by the current implementation.
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>:
 * @version 1.0
 * @since Nov 30, 2005
 */
public interface AdminConfiguration {

    /**
     * Lifecyle method used to initialize the configuration
     * @param context
     */
    void init(ServletContext context) throws DriverConfigurationException;

    /**
     * Lifecylce method used to remove the configuration
     * from service.
     */
    void destroy() throws DriverConfigurationException;

    /**
     * Retrieve the administrative service for managing the
     * portlet registry.
     *
     * @return the service if one has been provided
     */
    PortletRegistryAdminService getPortletRegistryAdminService();

    /**
     * Retrieve the administrative service for managing the
     * render configuration.
     * @return the service if one has been provided
     */
    RenderConfigAdminService getRenderConfigAdminService();

    public WarUploadAdminService getWarUploadAdminService();
    
    public ReassembleWarAdminService getReassembleWarAdminService();
    
    public DeployWarAdminService getDeployWarAdminService();

}
