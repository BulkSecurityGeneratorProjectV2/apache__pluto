/*
 * Copyright 2004 The Apache Software Foundation
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
package org.apache.pluto.descriptors.servlet;

import java.util.Set;

/**
 * FilterMapping configuration as contained within the
 * web.xml Deployment Descriptor.
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Feb 28, 2005
 */
public class FilterMappingDD {

    private String filterName;
    private String servletName;
    private Set urlPattern;
    private Set dispatchers;

    public FilterMappingDD() {

    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public Set getUrlPatterns() {
        return urlPattern;
    }

    public void setUrlPatterns(Set urlPattern) {
        this.urlPattern = urlPattern;
    }

    public String getServletName() {
        return servletName;
    }

    public void setServletName(String servletName) {
        this.servletName = servletName;
    }

    public Set getDispatchers() {
        return dispatchers;
    }

    public void setDispatchers(Set dispatchers) {
        this.dispatchers = dispatchers;
    }

}
