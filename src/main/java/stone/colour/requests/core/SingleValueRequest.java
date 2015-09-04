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

package stone.colour.requests.core;

import stone.colour.requests.ColorRequest;

/**
 * Created by Daniel Stoneburner on 9/4/2015.
 */
public abstract class SingleValueRequest extends ColourLoverRequest {
    private String hexValue;

    protected SingleValueRequest(String root) {
        super(root);
    }

    public String getHexValue() {
        return hexValue;
    }

    public <T extends SingleValueRequest> T setHexValue(String hexValue) {
        this.hexValue = hexValue;
        appendUrl(hexValue);
        return (T) this;
    }
}
