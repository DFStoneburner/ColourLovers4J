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

import stone.colour.models.Hex;
import stone.colour.requests.PalettesRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Stoneburner on 9/4/2015.
 */
public abstract class HexFilterableRequest extends SearchableRequest {
    protected List<Hue> hues;
    protected List<Hex> hexes;
    private HexLogic hexLogic;

    protected HexFilterableRequest(String root) {
        super(root);
        hexes = new ArrayList<>();
        hues = new ArrayList<>();
    }

    public List<Hue> getHues() {
        return hues;
    }

    public <T extends PalettesRequest> T setHues(Hue... hues) {
        StringBuilder huesBldr = new StringBuilder();
        for (Hue hue:hues) {
            this.hues.add(hue);

            if(huesBldr.length() != 0) {
                huesBldr.append(",");
            }
            huesBldr.append(hue.name().toLowerCase());
        }
        appendParam("hueOption",huesBldr.toString());

        return (T) this;
    }

    public List<Hex> getHexes() {
        return hexes;
    }

    public <T extends PalettesRequest> T setHexes(Hex... hexes) {
        StringBuilder hexesBldr = new StringBuilder();
        for(Hex hex:hexes) {
            this.hexes.add(hex);

            if(hexesBldr.length() != 0) {
                hexesBldr.append(",");
            }
            hexesBldr.append(hex.getRaw());
        }
        appendParam("hex",hexesBldr.toString());

        return (T) this;
    }

    public HexLogic getHexLogic() {
        return hexLogic;
    }

    public <T extends PalettesRequest> T setHexLogic(HexLogic hexLogic) {
        this.hexLogic = hexLogic;

        appendParam("hex_logic", hexLogic.name());

        return (T) this;
    }

    public enum Hue {
        RED,
        ORANGE,
        YELLOW,
        GREEN,
        AQUA,
        BLUE,
        VIOLET,
        FUCHSIA;
    }

    public enum HexLogic {
        AND,
        OR;
    }
}
