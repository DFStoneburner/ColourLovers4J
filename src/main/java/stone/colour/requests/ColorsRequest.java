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
import stone.colour.requests.core.SearchableRequest;

/**
 * Created by Daniel Stoneburner on 8/27/2015.
 */
public class ColorsRequest extends SearchableRequest {
    private int hueMinimum;
    private int hueMaximum;
    private int briMinimum;
    private int briMaximum;

    public ColorsRequest() {
        super(Endpoints.COLORS_ROOT.getRoot());
    }

    protected ColorsRequest(String root) {
        super(root);
    }

    public int getHueMinimum() {
        return hueMinimum;
    }

    public int getHueMaximum() {
        return hueMaximum;
    }

    public <T extends ColorsRequest> T setHueRange(int hueMaximum, int hueMinimum) {
        this.hueMaximum = hueMaximum;
        this.hueMinimum = hueMinimum;

        appendParam("hueRange", hueMinimum, hueMaximum);

        return (T) this;
    }

    public int getBriMinimum() {
        return briMinimum;
    }

    public int getBriMaximum() {
        return briMaximum;
    }

    public <T extends ColorsRequest> T setBriRange(int briMinimum, int briMaximum) {
        this.briMaximum = briMaximum;
        this.briMinimum = briMinimum;

        appendParam("briRange", briMinimum, briMaximum);

        return (T) this;
    }
}
