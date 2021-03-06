/*

   Derby - Class com.pivotal.gemfirexd.internal.impl.jdbc.authentication.SpecificAuthenticationServiceImpl

   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to you under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */

/*
 * Changes for GemFireXD distributed data platform (some marked by "GemStone changes")
 *
 * Portions Copyright (c) 2010-2015 Pivotal Software, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you
 * may not use this file except in compliance with the License. You
 * may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License. See accompanying
 * LICENSE file.
 */

package com.pivotal.gemfirexd.internal.impl.jdbc.authentication;



import com.gemstone.gemfire.internal.ClassPathLoader;
import com.pivotal.gemfirexd.auth.callback.UserAuthenticator;
import com.pivotal.gemfirexd.internal.iapi.error.StandardException;
import com.pivotal.gemfirexd.internal.iapi.jdbc.AuthenticationService;
import com.pivotal.gemfirexd.internal.iapi.reference.ClassName;
import com.pivotal.gemfirexd.internal.iapi.reference.SQLState;
import com.pivotal.gemfirexd.internal.iapi.services.property.PropertyUtil;
import com.pivotal.gemfirexd.internal.iapi.util.StringUtil;

import java.util.Properties;

/**
 * This authentication service is a specific/user defined User authentication
 * level support.
 * <p>
 * It calls the specific User authentication scheme defined by the user/
 * administrator.
 *
 */
public class SpecificAuthenticationServiceImpl
	extends AuthenticationServiceBase {

	private String specificAuthenticationScheme;

	//
	// ModuleControl implementation (overriden)
	//

	/**
	 *  Check if we should activate this authentication service.
	 */
	public boolean canSupport(String identifier, Properties properties) {

		//
		// we check 2 things:
		// - if gemfirexd.authentication.required system
		//   property is set to true.
		// - if gemfirexd.authentication.provider is set and is not equal
		//	 to LDAP or BUILTIN.
		//
		// and in that case we are the authentication service that should
		// be run.
		//
//		if (!requireAuthentication(properties))
//			return false;

		specificAuthenticationScheme = PropertyUtil.getPropertyFromSet(
					properties,
					com.pivotal.gemfirexd.internal.iapi.reference.Property.GFXD_AUTH_PROVIDER);
		if (
			 ((specificAuthenticationScheme != null) &&
			  (specificAuthenticationScheme.length() != 0) &&

			  (!((StringUtil.SQLEqualsIgnoreCase(specificAuthenticationScheme,
					  com.pivotal.gemfirexd.Constants.AUTHENTICATION_PROVIDER_BUILTIN)) ||
			  (specificAuthenticationScheme.equalsIgnoreCase(
					  com.pivotal.gemfirexd.Constants.AUTHENTICATION_PROVIDER_LDAP))  ))))
		  //GemStone changes BEGIN
		{
		   //call only to inherit peer authentication if at all.
		   checkAndSetSchemeSupported(identifier, properties, specificAuthenticationScheme);
		   return true;
		   /* original code
			return true;
	           */
		}
                //GemStone changes END
		else
			return false;
	}

	/**
	 * @see com.pivotal.gemfirexd.internal.iapi.services.monitor.ModuleControl#boot
	 * @exception StandardException upon failure to load/boot the expected
	 * authentication service.
	 */
	public void boot(boolean create, Properties properties)
	  throws StandardException {

		// We need authentication
		// setAuthentication(true);

		// we call the super in case there is anything to get initialized.
		super.boot(create, properties);

		// We must retrieve and load the authentication scheme that we were
		// told to. The class loader will report an exception if it could not
		// find the class in the classpath.
		//
		// We must then make sure that the ImplementationScheme loaded,
		// implements the published UserAuthenticator interface we
		// provide.
		//

		Throwable t;
		try {

// GemStone changes BEGIN
			Class sasClass = ClassPathLoader.getLatest().forName(
			    specificAuthenticationScheme);
			/* (original code)
			Class sasClass = Class.forName(specificAuthenticationScheme);
			*/
// GemStone changes END
			if (!UserAuthenticator.class.isAssignableFrom(sasClass)) {
				throw StandardException.newException(SQLState.AUTHENTICATION_NOT_IMPLEMENTED,
					specificAuthenticationScheme, "com.pivotal.gemfirexd.internal.authentication.UserAuthenticator");
			}

			UserAuthenticator aScheme = (UserAuthenticator) sasClass.newInstance();

			// Set ourselves as being ready and loading the proper
			// authentication scheme for this service
			//
			this.setAuthenticationService(aScheme);

			return;

		} catch (ClassNotFoundException cnfe) {
			t = cnfe;
		} catch (InstantiationException ie) {
			t = ie;
		} catch (IllegalAccessException iae) {
			t = iae;
		}
		throw StandardException.newException(SQLState.AUTHENTICATION_SCHEME_ERROR, t,
					specificAuthenticationScheme);
	}
}
