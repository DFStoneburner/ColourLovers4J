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

import java.util.List;

public class Palette extends ImageBase {
    List<Hex> colors;
    List<Double> colorWidths;

    public List<Hex> getColors() {
        return colors;
    }

    public void setColors(List<Hex> colors) {
        this.colors = colors;
    }

    public List<Double> getColorWidths() {
        return colorWidths;
    }

    public void setColorWidths(List<Double> colorWidths) {
        this.colorWidths = colorWidths;
    }
}
