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

package stone.colour.models;

import java.net.URL;

/**
 * Created by Daniel Stoneburner on 8/27/2015.
 */
public class Color extends ImageBase {

    Hex hex;
    RGB rgb;
    HSV hsv;

    public Hex getHex() {
        return hex;
    }

    public void setHex(Hex hex) {
        this.hex = hex;
    }

    public RGB getRgb() {
        return rgb;
    }

    public void setRgb(RGB rgb) {
        this.rgb = rgb;
    }

    public HSV getHsv() {
        return hsv;
    }

    public void setHsv(HSV hsv) {
        this.hsv = hsv;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
