/*
 * Copyright 2009-2012 by The Regents of the University of California
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

package edu.uci.ics.hyracks.storage.am.lsm.btree.impls;

import edu.uci.ics.hyracks.storage.am.btree.impls.BTree;
import edu.uci.ics.hyracks.storage.am.common.api.IndexException;
import edu.uci.ics.hyracks.storage.am.lsm.common.api.ILSMComponent;
import edu.uci.ics.hyracks.storage.am.lsm.common.api.ILSMComponentFactory;
import edu.uci.ics.hyracks.storage.am.lsm.common.impls.LSMComponentFileReferences;
import edu.uci.ics.hyracks.storage.am.lsm.common.impls.TreeIndexFactory;
import edu.uci.ics.hyracks.storage.common.buffercache.IBufferCache;

public class LSMBTreeComponentFactory implements ILSMComponentFactory {
    private final TreeIndexFactory<BTree> btreeFactory;

    public LSMBTreeComponentFactory(TreeIndexFactory<BTree> btreeFactory) {
        this.btreeFactory = btreeFactory;
    }

    @Override
    public ILSMComponent createLSMComponentInstance(LSMComponentFileReferences cfr) throws IndexException {
        return new LSMBTreeComponent(btreeFactory.createIndexInstance(cfr.getInsertIndexFileReference()));
    }

    @Override
    public IBufferCache getBufferCache() {
        return btreeFactory.getBufferCache();
    }
}
