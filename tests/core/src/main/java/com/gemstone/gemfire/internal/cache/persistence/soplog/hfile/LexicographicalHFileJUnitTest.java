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
package com.gemstone.gemfire.internal.cache.persistence.soplog.hfile;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import junit.framework.TestCase;

import com.gemstone.gemfire.internal.cache.persistence.soplog.ComparisonTestCase;
import com.gemstone.gemfire.internal.cache.persistence.soplog.LexicographicalComparator;
import com.gemstone.gemfire.internal.cache.persistence.soplog.SortedOplog.SortedOplogWriter;
import com.gemstone.gemfire.internal.cache.persistence.soplog.SortedOplogFactory.SortedOplogConfiguration;
import com.gemstone.gemfire.internal.cache.persistence.soplog.SortedReader;
import com.gemstone.gemfire.internal.cache.persistence.soplog.SortedReaderTestCase;

public class LexicographicalHFileJUnitTest extends TestCase {
  private HFileSortedOplog hfile;

  public void testReadAndWrite() throws Exception {
    SortedOplogConfiguration config = new SortedOplogConfiguration("lex")
      .setComparator(new LexicographicalComparator());
    
    hfile = new HFileSortedOplog(new File("lexi.soplog"), config);

    SortedOplogWriter wtr = hfile.createWriter();
    for (int i = -100; i < 100; i++) {
      wtr.append(ComparisonTestCase.convert(i), ComparisonTestCase.convert(i));
    }
    wtr.close(null);

    SortedReader<ByteBuffer> rdr = hfile.createReader();
    for (int i = -100; i < 100; i++) {
      byte[] key = ComparisonTestCase.convert(i);
      assertTrue(rdr.mightContain(key));
      
      ByteBuffer val = rdr.read(key);
      assertEquals(i, ComparisonTestCase.recover(val.array(), val.arrayOffset(), val.remaining()));
    }
    
    rdr.close();
  }
  
  @Override 
  protected void tearDown() throws IOException {
    for (File f : SortedReaderTestCase.getSoplogsToDelete()) {
      f.delete();
    }
  }
}