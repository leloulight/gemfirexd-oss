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
package com.gemstone.gemfire.management.internal.cli;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.shell.event.ParseResult;

import com.gemstone.gemfire.management.cli.CliMetaData;
import com.gemstone.gemfire.management.internal.cli.shell.GfshExecutionStrategy;
import com.gemstone.gemfire.management.internal.cli.shell.OperationInvoker;

/**
 * Immutable representation of the outcome of parsing a given shell line. *
 * Extends {@link ParseResult} to add a field to specify the command string that
 * was input by the user.
 * 
 * <p>
 * Some commands are required to be executed on a remote GemFire managing
 * member. These should be marked with the annotation
 * {@link CliMetaData#shellOnly()} set to <code>false</code>.
 * {@link GfshExecutionStrategy} will detect whether the command is a remote
 * command and send it to ManagementMBean via {@link OperationInvoker}.
 * 
 * @author Abhishek Chaudhari
 * 
 * @since 7.0
 */
public class GfshParseResult extends ParseResult {
  private String userInput;
  private Map<String, String> paramValueStringMap;

  /**
   * Creates a GfshParseResult instance to represent parsing outcome.
   * 
   * @param method
   *          Method associated with the command
   * @param instance
   *          Instance on which this method has to be executed
   * @param arguments
   *          arguments of the method
   * @param userInput
   *          user specified commands string
   */
  protected GfshParseResult(final Method method, final Object instance, 
                            final Object[] arguments, final String userInput, 
                            final Map<String, String> parametersAsString) {
    super(method, instance, arguments);
    this.userInput = userInput;
    this.paramValueStringMap = new HashMap<String, String>(parametersAsString);
  }
  
  /**
   * @return the userInput
   */
  public String getUserInput() {
    return userInput;
  }
  

  /**
   * @return the unmodifiable paramValueStringMap
   */
  public Map<String, String> getParamValueStrings() {
    return Collections.unmodifiableMap(paramValueStringMap);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(GfshParseResult.class.getSimpleName());
    builder.append(" [method=").append(getMethod());
    builder.append(", instance=").append(getInstance());
    builder.append(", arguments=").append(CliUtil.arrayToString(getArguments()));
    builder.append("]");
    return builder.toString();
  }
}
