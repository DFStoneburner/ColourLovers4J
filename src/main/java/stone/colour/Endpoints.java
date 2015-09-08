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

    COLOR_ROOT("http://www.colourlovers.com/api/color"),
    COLORS_ROOT(COLOR_ROOT.getRoot() + "s"),
    COLOR_RANDOM(COLORS_ROOT.getRoot() + "/random"),
    COLORS_NEW(COLORS_ROOT.getRoot() + "/new"),
    COLORS_TOP(COLORS_ROOT.getRoot() + "/top"),
    LOVER_ROOT("http://www.colourlovers.com/api/lover"),
    LOVERS_ROOT(LOVER_ROOT.getRoot() + "s"),
    LOVERS_NEW(LOVERS_ROOT.getRoot() + "/new"),
    LOVERS_TOP(LOVERS_ROOT.getRoot() + "/top"),
    PALETTE_ROOT("http://www.colourlovers.com/api/palette"),
    PALETTES_ROOT(PALETTE_ROOT.getRoot() + "s"),
    PALETTE_RANDOM(PALETTES_ROOT.getRoot() + "/random"),
    PALETTES_NEW(PALETTES_ROOT.getRoot() + "/new"),
    PALETTES_TOP(PALETTES_ROOT.getRoot() + "/top"),
    PATTERN_ROOT("http://www.colourlovers.com/api/pattern"),
    PATTERNS_ROOT(PATTERN_ROOT.getRoot() + "s"),
    PATTERN_RANDOM(PATTERNS_ROOT.getRoot() + "/random"),
    PATTERNS_NEW(PATTERNS_ROOT.getRoot() + "/new"),
    PATTERNS_TOP(PATTERNS_ROOT.getRoot() + "/top"),
    STATS_COLORS("http://www.colourlovers.com/api/stats/colors"),
    STATS_PALETTES("http://www.colourlovers.com/api/stats/palettes"),
    STATS_PATTERNS("http://www.colourlovers.com/api/stats/patterns"),
    STATS_LOVERS("http://www.colourlovers.com/api/stats/lovers");

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
