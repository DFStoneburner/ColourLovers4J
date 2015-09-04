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

package stone.colour;

/**
 * Created by Daniel Stoneburner on 8/27/2015.
 */
public enum Endpoints {

    COLOR("http://www.colourlovers.com/api/color"),
    COLORS(COLOR.getRoot() + "s"),
    COLOR_RANDOM(COLORS.getRoot() + "/random"),
    COLORS_NEW(COLORS.getRoot() + "/new"),
    COLORS_TOP(COLORS.getRoot() + "/top"),
    PALETTE("http://www.colourlovers.com/api/palette"),
    PALETTES(PALETTE + "s"),
    PALETTE_RANDOM(PALETTES + "/random"),
    PALETTES_NEW(PALETTES + "/new"),
    PALETTES_TOP(PALETTES + "/top");

    private String root;

    Endpoints(String root) {
        this.root = root;
    }

    public String getRoot() {
        return root;
    }

    @Override
    public String toString() {
        return "Endpoints{" +
                "root='" + root + '\'' +
                '}';
    }
}
