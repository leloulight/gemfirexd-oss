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
package com.gemstone.gemfire.internal.cache.tier.sockets;

import com.gemstone.gemfire.cache.*;

/**
 * subclass of InterestListEndpointDUnitTest to exercise partitioned regions
 *
 * @author Bruce Schuchardt
 */
public class InterestListEndpointPRDUnitTest extends InterestListEndpointDUnitTest {

  public InterestListEndpointPRDUnitTest(String name) {
    super(name);
  }
  public static void createImpl() {
    impl = new InterestListEndpointPRDUnitTest("temp");
  }
  
  protected RegionAttributes createServerCacheAttributes()
  {
    AttributesFactory factory = new AttributesFactory();
    factory.setDataPolicy(DataPolicy.PARTITION);
    factory.setPartitionAttributes((new PartitionAttributesFactory()).create());
    return factory.create();
  }
}
