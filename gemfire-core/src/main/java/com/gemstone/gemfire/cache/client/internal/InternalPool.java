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
package com.gemstone.gemfire.cache.client.internal;

import java.util.Map;

import java.util.concurrent.ScheduledExecutorService;
import com.gemstone.gemfire.CancelCriterion;
import com.gemstone.gemfire.cache.client.Pool;
import com.gemstone.gemfire.i18n.LogWriterI18n;
import com.gemstone.gemfire.internal.cache.PoolStats;

/**
 * The contract between a connection source and a connection pool.
 * Provides methods for the connection source to access the cache
 * and update the list of endpoints on the connection pool.
 * @author dsmith
 * @since 5.7
 *
 */
public interface InternalPool extends Pool, ExecutablePool {
  LogWriterI18n getLoggerI18n();
  PoolStats getStats();
  Map getEndpointMap();
  EndpointManager getEndpointManager();
  ScheduledExecutorService getBackgroundProcessor();
  CancelCriterion getCancelCriterion();
  boolean isDurableClient();
  void detach();
  String getPoolOrCacheCancelInProgress();
}
