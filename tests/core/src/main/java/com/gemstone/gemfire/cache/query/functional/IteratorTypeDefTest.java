/*
 * Copyright (c) 2010-2015 Pivotal Software, Inc. All rights reserved.
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
/*
 * IteratorTypeDefTest.java
 *
 * Created on April 7, 2005, 12:40 PM
 */
/*
 * 
 * @author vikramj
 */
package com.gemstone.gemfire.cache.query.functional;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.query.CacheUtils;
import com.gemstone.gemfire.cache.query.Query;
import com.gemstone.gemfire.cache.query.*;
import com.gemstone.gemfire.cache.query.data.Portfolio;
import junit.framework.*;

public class IteratorTypeDefTest extends TestCase {

  public IteratorTypeDefTest(String testName) {
    super(testName);
  }

  protected void setUp() throws java.lang.Exception {
    CacheUtils.startCache();
    Region region = CacheUtils.createRegion("portfolios", Portfolio.class);
    for (int i = 0; i < 4; i++) {
      region.put("" + i, new Portfolio(i));
    }
    System.out.println(region);
  }

  protected void tearDown() throws java.lang.Exception {
    CacheUtils.closeCache();
  }

  public void testIteratorDefSyntax() throws Exception {
    String queries[] = {
        "IMPORT com.gemstone.gemfire.cache.\"query\".data.Position;"
            + "SELECT DISTINCT secId FROM /portfolios,  positions.values pos TYPE Position WHERE iD > 0",
        "IMPORT com.gemstone.gemfire.cache.\"query\".data.Position;"
            + "SELECT DISTINCT secId FROM /portfolios, positions.values AS pos TYPE Position WHERE iD > 0",
        "IMPORT com.gemstone.gemfire.cache.\"query\".data.Position;"
            + "SELECT DISTINCT pos.secId FROM /portfolios, pos IN positions.values TYPE Position WHERE iD > 0",
        "SELECT DISTINCT pos.secId FROM /portfolios,  positions.values AS pos  WHERE iD > 0",
        "SELECT DISTINCT pos.secId FROM /portfolios, pos IN positions.values  WHERE iD > 0",};
    for (int i = 0; i < queries.length; i++) {
      Query q = null;
      try {
        q = CacheUtils.getQueryService().newQuery(queries[i]);
        Object r = q.execute();
        System.out.println(Utils.printResult(r));
      }
      catch (Exception e) {
        e.printStackTrace();
        fail(q.getQueryString());
      }
    }
    System.out.println("TestCase:testIteratorDefSyntax PASS");
  }
  
 public void testIteratorDefSyntaxForObtainingResultBag() throws Exception {
    String queries[] = {
     "IMPORT com.gemstone.gemfire.cache.\"query\".data.Position;"+ 
"SELECT DISTINCT secId FROM /portfolios, (set<Position>)positions.values WHERE iD > 0",
    };
    for (int i = 0; i < queries.length; i++) {
      Query q = null;
      try {
        q = CacheUtils.getQueryService().newQuery(queries[i]);
        Object r = q.execute();
        System.out.println(Utils.printResult(r));
        if (!(r instanceof SelectResults))
            fail("testIteratorDefSyntaxForObtainingResultBag: Test failed as obtained Result Data not an instance of SelectResults. Query= "+ q.getQueryString());
        if (((SelectResults)r).getCollectionType().allowsDuplicates()) 
            fail("testIteratorDefSyntaxForObtainingResultBag: results of query should not allow duplicates, but says it does");
      }
      catch (Exception e) {
        e.printStackTrace();
        fail(q.getQueryString());
      }
    }
    System.out.println("TestCase:testIteratorDefSyntaxForObtainingResultSet PASS");
  }
  
  
  public void testNOValueconstraintInCreatRegion() throws Exception {
      CacheUtils.createRegion("pos", null);  
      String queries[] = {
        "IMPORT com.gemstone.gemfire.cache.\"query\".data.Portfolio;"+ 
"SELECT DISTINCT * FROM (set<Portfolio>)/pos where iD > 0"
    };
    for (int i = 0; i < queries.length; i++) {
      Query q = null;
      try {
        q = CacheUtils.getQueryService().newQuery(queries[i]);
        Object r = q.execute();
        System.out.println(Utils.printResult(r));
     }
      catch (Exception e) {
        e.printStackTrace();
        fail(q.getQueryString());
      }
    }
    System.out.println("TestCase: testNOValueconstraintInCreatRegion PASS");
  } 
  
  public void testNOConstraintOnRegion() throws Exception {
      Region region = CacheUtils.createRegion("portfl",null); 
      for (int i = 0; i < 4; i++) {
      region.put("" + i, new Portfolio(i));
    }
    System.out.println(region);
      String queries[] = {
"IMPORT com.gemstone.gemfire.cache.\"query\".data.Position;"+ 
"IMPORT com.gemstone.gemfire.cache.\"query\".data.Portfolio;"+
"SELECT DISTINCT secId FROM (set<Portfolio>)/portfl, (set<Position>)positions.values WHERE iD > 0",
    };
    for (int i = 0; i < queries.length; i++) {
      Query q = null;
      try {
        q = CacheUtils.getQueryService().newQuery(queries[i]);
        Object r = q.execute();
        System.out.println(Utils.printResult(r));
     }
      catch (Exception e) {
        e.printStackTrace();
        fail(q.getQueryString());
      }
    }
    System.out.println("TestCase: testNOConstraintOnRegion PASS");
  } 
  
}
 
