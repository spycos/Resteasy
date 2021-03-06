/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2011-2012 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package javax.ws.rs.ext;

import java.io.IOException;
import java.io.OutputStream;
import javax.ws.rs.core.MultivaluedMap;

/**
 * Context class used by {@link javax.ws.rs.ext.WriterInterceptor}
 * to intercept calls to (@link javax.ws.rs.ext.MessageBodyWriter#writeTo}.
 * The getters and setters in this context class correspond to the
 * parameters of the intercepted method.
 *
 * @param <T> Java type supported by corresponding message body writer
 *
 * @author Santiago Pericas-Geertsen
 * @author Bill Burke
 * @since 2.0
 * @see WriterInterceptor
 * @see MessageBodyWriter
 */
public interface WriterInterceptorContext<T> extends InterceptorContext<T> {

    /**
     * Proceed to the next interceptor in the chain. Interceptors MUST explicitly
     * call this method to continue the execution chain; the call to this
     * method in the last interceptor of the chain will invoke
     * {@link javax.ws.rs.ext.MessageBodyWriter#writeTo} method.
     *
     * @throws IOException if an IO exception arises
     */
    void proceed() throws IOException;

    /**
     * Get object to be written as HTTP entity
     *
     * @return object to be written as HTTP entity
     */
    T getEntity();

    /**
     * Update object to be written as HTTP entity
     *
     * @param entity new object to be written
     */
    void setEntity(T entity);

    /**
     * Get the output stream for the object to be written
     *
     * @return output stream for the object to be written
     */
    OutputStream getOutputStream();

    /**
     * Update the output stream for the object to be written
     *
     * @param os new output stream for the object to be written
     */
    public void setOutputStream(OutputStream os);

    /**
     * Get mutable map of HTTP headers.
     *
     * @return map of HTTP headers
     */
    MultivaluedMap<String, Object> getHeaders();
}
