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


package org.apache.pluto.services;

import org.apache.pluto.PlutoEnvironment;

/** ServiceFactory which provides optional services which a
 *  Portal may provide to the PlutoContainer.  If these
 *  services are not provided, Pluto will use it's default
 *  implementations.
 *
 * @author <A href="mailto:david.dewolf@vivare.com">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 25, 2004 at 7:05:29 PM
 */
public interface OptionalServiceFactory extends ServiceFactory {

    /** Returns the PortletInvokerService which the container
     *  should use to invoke portlets. */
    PortletInvokerService getPortletInvokerService();

    /** Returns the RequestFactoryService which will be used
     *  by the container to create PortletRequests.
     * @return
     */
    PortletRequestFactoryService  getRequestFactoryService();

    /** Returns the ResponseFactoryService which will be used
     *  by the container to create PortletResponses.
     * @return
     */
    PortletResponseFactoryService getResponseFactoryService();

    /** Return ths PortletConfigFactoryService which should be
     *  used to create PortletConfigs.
     * @return
     */
    PortletConfigFactoryService   getPortletConfigFactoryService();
    
}