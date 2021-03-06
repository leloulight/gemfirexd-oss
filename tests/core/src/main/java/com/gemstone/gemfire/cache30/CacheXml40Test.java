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
package com.gemstone.gemfire.cache30;

import com.gemstone.gemfire.cache.*;
import com.gemstone.gemfire.cache.util.BridgeServer;
import com.gemstone.gemfire.internal.AvailablePortHelper;
import com.gemstone.gemfire.internal.cache.xmlcache.*;

/**
 * Tests the declarative caching functionality introduced in GemFire
 * 4.0. 
 *
 * @author David Whitlock
 * @since 4.0
 */
public class CacheXml40Test extends CacheXml30Test {

  ////////  Constructors

  public CacheXml40Test(String name) {
    super(name);
  }

  ////////  Helper methods

  protected String getGemFireVersion() {
    return CacheXml.VERSION_4_0;
  }

  ////////  Test methods

  /**
   * Tests the cache server attribute
   *
   * @since 4.0
   */
  public void testServer() {
    CacheCreation cache = new CacheCreation();
    cache.setIsServer(true);
    assertTrue(cache.isServer());

    testXml(cache);
  }

  /**
   * Tests declarative bridge servers
   *
   * @since 4.0
   */
  public void testBridgeServers() {
    CacheCreation cache = new CacheCreation();

    BridgeServer bridge1 = cache.addBridgeServer();
    setBridgeAttributes(bridge1);
    BridgeServer bridge2 = cache.addBridgeServer();
    bridge2.setPort(AvailablePortHelper.getRandomAvailableTCPPort());

    testXml(cache);
  }

  /**
   * Used by testBridgeServers to set version specific attributes
   * @param bridge1 the bridge server to set attributes upon
   */
  public void setBridgeAttributes(BridgeServer bridge1)
  {
    bridge1.setPort(AvailablePortHelper.getRandomAvailableTCPPort());
  }

  /**
   * Tests the is-lock-grantor attribute in xml.
   */
  public void testIsLockGrantorAttribute() throws CacheException {

    CacheCreation cache = new CacheCreation();
    RegionAttributesCreation attrs = new RegionAttributesCreation(cache);

    attrs.setLockGrantor(true);
    attrs.setScope(Scope.GLOBAL);
    attrs.setMirrorType(MirrorType.KEYS_VALUES);

    cache.createRegion("root", attrs);

    testXml(cache);
    assertEquals(true, cache.getRegion("root").getAttributes().isLockGrantor());
  }

  /**
   * Tests a cache listener with no parameters
   *
   * @since 4.0
   */
  public void testTransactionListener() {
    CacheCreation cache = new CacheCreation();
    CacheTransactionManagerCreation txMgrCreation = new CacheTransactionManagerCreation();
    txMgrCreation.setListener(new MyTestTransactionListener());
    cache.addCacheTransactionManagerCreation(txMgrCreation);
    testXml(cache);
  }

  /**
   * Tests transaction manager with no listener
   *
   * @since 4.0
   */
  public void testCacheTransactionManager() {
    CacheCreation cache = new CacheCreation();
    CacheTransactionManagerCreation txMgrCreation = new CacheTransactionManagerCreation();
    cache.addCacheTransactionManagerCreation(txMgrCreation);
    testXml(cache);
  }

  /**
   * Tests the value constraints region attribute that was added in
   * GemFire 4.0.
   *
   * @since 4.1
   */
  public void testConstrainedValues() throws CacheException {
    CacheCreation cache = new CacheCreation();
    RegionAttributesCreation attrs = new RegionAttributesCreation(cache);
    attrs.setValueConstraint(String.class);

    cache.createRegion("root", attrs);

    testXml(cache);
  }

}
