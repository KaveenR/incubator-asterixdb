/*
 * Copyright 2009-2010 by The Regents of the University of California
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * you may obtain a copy of the License from
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.uci.ics.asterix.runtime.accessors.base;

import edu.uci.ics.asterix.common.exceptions.AsterixException;
import edu.uci.ics.asterix.runtime.accessors.visitor.IBinaryAccessorVisitor;
import edu.uci.ics.hyracks.dataflow.common.data.accessors.IValueReference;

public interface IBinaryAccessor extends IValueReference {

    public void reset(byte[] b, int start, int len);

    public <R, T> R accept(IBinaryAccessorVisitor<R, T> vistor, T tag) throws AsterixException;
}