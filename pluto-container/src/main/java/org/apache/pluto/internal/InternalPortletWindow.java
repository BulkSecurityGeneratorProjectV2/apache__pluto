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

package org.apache.pluto.internal;

import javax.servlet.ServletContext;

import org.apache.pluto.PortletWindow;


/**
 * The internal portlet window represents a single window of a portlet instance
 * as it can be shown only once on a single page. There is a one-to-one relation
 * between portlet windows and portlet entities. Adding the same portlet e.g.
 * twice on a page results in two different windows.
 * 
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 */
public interface InternalPortletWindow extends PortletWindow {

    /**
     * The Context from which this window can be serviced.
     * @return the associated servlet context.
     */
    public ServletContext getServletContext();

    /**
     * Returns the portlet entity. The return value cannot be NULL.
     * @return the portlet entity
     */
    public PortletEntity getPortletEntity();
    
}