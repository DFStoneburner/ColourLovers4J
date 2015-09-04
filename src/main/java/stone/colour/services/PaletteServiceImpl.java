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

package stone.colour.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import stone.colour.adapters.HexAdapter;
import stone.colour.client.ColourLoverClient;
import stone.colour.models.Hex;
import stone.colour.models.Palette;
import stone.colour.requests.ColourLoverRequest;
import stone.colour.requests.PaletteRequest;

import java.io.IOException;

/**
 * Created by Daniel Stoneburner on 9/3/2015.
 */
public class PaletteServiceImpl {
    private Gson gson;
    private int pageSize = 20;

    public PaletteServiceImpl() {
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .registerTypeAdapter(Hex.class, new HexAdapter())
                .create();
    }

    public Palette getPalette(String hexId) throws IOException {
        PaletteRequest paletteRequest = new PaletteRequest()
                    .setHexValue(hexId)
                    .setFormat("json");

            Palette[] colorsResponse = executeRequest(paletteRequest);

            return colorsResponse != null && colorsResponse.length > 0
                    ? colorsResponse[0]
                    : null;
    }

    public Palette[] executeRequest(ColourLoverRequest colorRequest) throws IOException {
        try {
            String response = ColourLoverClient.executeRequest(colorRequest);
            return gson.fromJson(response, Palette[].class);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
