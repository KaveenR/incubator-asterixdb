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
package edu.uci.ics.hyracks.dataflow.common.data.accessors;

import edu.uci.ics.hyracks.api.comm.IFrameTupleAccessor;
import edu.uci.ics.hyracks.data.std.api.IValueReference;

public class FrameTupleFieldValueReference implements IValueReference {
    private IFrameTupleAccessor fta;
    private int tupleIndex;
    private int fieldIndex;

    public FrameTupleFieldValueReference() {
    }

    public void reset(IFrameTupleAccessor fta, int tupleIndex, int fieldIndex) {
        this.fta = fta;
        this.tupleIndex = tupleIndex;
        this.fieldIndex = fieldIndex;
    }

    @Override
    public byte[] getByteArray() {
        return fta.getBuffer().array();
    }

    @Override
    public int getStartOffset() {
        return fta.getFieldStartOffset(tupleIndex, fieldIndex);
    }

    @Override
    public int getLength() {
        return fta.getFieldLength(tupleIndex, fieldIndex);
    }
}