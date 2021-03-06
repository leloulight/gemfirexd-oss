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
package com.gemstone.gemfire.internal.cache.partitioned;

import com.gemstone.gemfire.cache.AttributesFactory;
import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.DataPolicy;
import com.gemstone.gemfire.cache.PartitionAttributesFactory;
import com.gemstone.gemfire.cache.RegionAttributes;

/**
 * @author dsmith
 *
 */
public class PersistentPartitionedRegionOldConfigDUnitTest extends
    PersistentPartitionedRegionDUnitTest {

  public PersistentPartitionedRegionOldConfigDUnitTest(String name) {
    super(name);
  }
  
  @Override
  protected RegionAttributes getPersistentPRAttributes(
      final int redundancy, final int recoveryDelay, Cache cache, int numBuckets,
      boolean synchronous) {
    AttributesFactory af = new AttributesFactory();
    PartitionAttributesFactory paf = new PartitionAttributesFactory();
    paf.setRedundantCopies(redundancy);
    paf.setRecoveryDelay(recoveryDelay);
    paf.setTotalNumBuckets(numBuckets);
    af.setPartitionAttributes(paf.create());
    af.setDataPolicy(DataPolicy.PERSISTENT_PARTITION);
    af.setDiskDirs(getDiskDirs());
    RegionAttributes attr = af.create();
    return attr;
  }
}
