/*

   Derby - Class com.pivotal.gemfirexd.internal.iapi.sql.Statement

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

package com.pivotal.gemfirexd.internal.iapi.sql;

import com.pivotal.gemfirexd.internal.engine.distributed.metadata.QueryInfo;
import com.pivotal.gemfirexd.internal.iapi.error.StandardException;
import com.pivotal.gemfirexd.internal.iapi.sql.compile.CompilerContext;
import com.pivotal.gemfirexd.internal.iapi.sql.conn.LanguageConnectionContext;
import com.pivotal.gemfirexd.internal.iapi.sql.dictionary.SchemaDescriptor;
import com.pivotal.gemfirexd.internal.iapi.types.DataTypeDescriptor;
import com.pivotal.gemfirexd.internal.impl.sql.StatementStats;
import com.pivotal.gemfirexd.internal.impl.sql.compile.CursorNode;

/**
 * The Statement interface provides a way of giving a statement to the
 * language module, preparing the statement, and executing it. It also
 * provides some support for stored statements. Simple, non-stored,
 * non-parameterized statements can be executed with the execute() method.
 * Parameterized statements must use prepare(). To get the stored query
 * plan for a statement, use get().
 * <p>
 * This interface will have different implementations for the execution-only
 * and compile-and-execute versions of the product. In the execution-only
 * version, some of the methods will do nothing but raise exceptions to
 * indicate that they are not implemented.
 * <p>
 * There is a Statement factory in the Connection interface in the Database
 * module, which uses the one provided in LanguageFactory.
 *
 */
public interface Statement
{

	/**
	 * Generates an execution plan without executing it.
	 *
	 * @return A PreparedStatement that allows execution of the execution
	 *	   plan.
	 * @exception StandardException	Thrown if this is an
	 *	   execution-only version of the module (the prepare() method
	 *	   relies on compilation).
	 */
	PreparedStatement	prepare(LanguageConnectionContext lcc
                            ) throws StandardException;
	/**
	 * Generates an execution plan without executing it.
	 *
	 * @param 	lcc			the language connection context
	 * @param 	allowInternalSyntax	If this statement is for a metadata call then 
	 *	   we will allow internal sql syntax on such statement. This internal
	 *	   sql syntax is not available to a user sql statement.
	 * 
	 * @return A PreparedStatement that allows execution of the execution
	 *	   plan.
	 * @exception StandardException	Thrown if this is an
	 *	   execution-only version of the module (the prepare() method
	 *	   relies on compilation).
	 */
	PreparedStatement	prepare(LanguageConnectionContext lcc, boolean allowInternalSyntax   ) throws StandardException;
	
	/**
	 * Generates an execution plan given a set of named parameters.
	 * For generating a storable prepared statement (which
	 * has some extensions over a standard prepared statement).
	 *
	 * @param 	lcc					Compiler state variable.
	 * @param 	ps					Prepared statement
	 * @param	paramDefaults		Default parameter values to use for
	 *								optimization
	 * @param	spsSchema schema of the stored prepared statement
	 *
	 * @return A Storable PreparedStatement that allows execution of the execution
	 *	   plan.
	 * @exception StandardException	Thrown if this is an
	 *	   execution-only version of the module (the prepare() method
	 *	   relies on compilation).
	 */
	public	PreparedStatement	prepareStorable
	( 
		LanguageConnectionContext lcc,
		PreparedStatement ps, 
		Object[]			paramDefaults,
		SchemaDescriptor	spsSchema,
		boolean	internalSQL
	)
		throws StandardException;

	/**
	 *	Return the SQL string that this statement is for.
	 *
	 *	@return the SQL string this statement is for.
	 */
	String getSource();
	
// GemStone changes BEGIN

	public PreparedStatement prepareStatement(LanguageConnectionContext lcc,
	    QueryInfo qinfo, DataTypeDescriptor[] params, CursorNode cn, CompilerContext cc)
	  throws StandardException;
	
	public boolean createQueryInfo();
	
	public String getQueryStringForParse(LanguageConnectionContext lcc) ;
        
// GemStone changes END
}
