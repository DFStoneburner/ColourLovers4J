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
import stone.colour.models.Color;
import stone.colour.models.Hex;
import stone.colour.requests.ColorRequest;
import stone.colour.requests.ColourLoverRequest;
import stone.colour.requests.RandomColorRequest;
import stone.colour.requests.TopColorsRequest;

import java.io.IOException;

/**
 * Created by Daniel Stoneburner on 8/27/2015.
 */
public class ColorServiceImpl implements ColorService {
    private Gson gson;
    private int pageSize = 20;

    public ColorServiceImpl() {
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .registerTypeAdapter(Hex.class, new HexAdapter())
                .create();
    }

    @Override
    public Color getColor(String hexId) throws IOException {
        ColorRequest colorRequest = new ColorRequest()
                .setHexValue(hexId)
                .setFormat("json");

        Color[] colorsResponse = executeRequest(colorRequest);

        return colorsResponse != null && colorsResponse.length > 0
                ? colorsResponse[0]
                : null;
    }

    @Override
    public Color getRandomColor() throws IOException {
        RandomColorRequest colorRequest = new RandomColorRequest()
                .setFormat("json");

        Color[] colorsResponse = executeRequest(colorRequest);

        return colorsResponse != null && colorsResponse.length > 0
                ? colorsResponse[0]
                : null;
    }

    @Override
    public Color[] getTopColors(int page) throws IOException {
        TopColorsRequest colorRequest = new TopColorsRequest()
                .setNumResults(pageSize)
                .setResultOffset(page * pageSize)
                .setFormat("json");

        Color[] colorsResponse = executeRequest(colorRequest);

        return colorsResponse;
    }

    public Color[] executeRequest(ColourLoverRequest colorRequest) throws IOException {
        try {
            String response = ColourLoverClient.executeRequest(colorRequest);
            return gson.fromJson(response, Color[].class);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
