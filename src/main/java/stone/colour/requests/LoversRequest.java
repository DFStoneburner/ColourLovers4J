/*
 *    Copyright 2015 Daniel Stoneburner
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package stone.colour.requests;

import stone.colour.Endpoints;
import stone.colour.requests.core.SortableRequest;

/**
 * Created by Daniel Stoneburner on 9/5/2015.
 */
public class LoversRequest extends SortableRequest {
    public LoversRequest() {
        super(Endpoints.LOVERS_ROOT.getRoot());
    }

    protected LoversRequest(String root) {
        super(root);
    }
}
