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
import stone.colour.requests.*;
import stone.colour.requests.core.ColourLoverRequest;

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
                .setValue(hexId);

        Color[] colorsResponse = executeRequest(colorRequest);

        return colorsResponse != null && colorsResponse.length > 0
                ? colorsResponse[0]
                : null;
    }

    @Override
    public Color getRandomColor() throws IOException {
        RandomColorRequest colorRequest = new RandomColorRequest();

        Color[] colorsResponse = executeRequest(colorRequest);

        return colorsResponse != null && colorsResponse.length > 0
                ? colorsResponse[0]
                : null;
    }

    @Override
    public Color[] getTopColors() throws IOException {
        return getNewColors(0);
    }

    @Override
    public Color[] getTopColors(int page) throws IOException {
        TopColorsRequest colorRequest = new TopColorsRequest()
                .setNumResults(pageSize)
                .setResultOffset(page * pageSize);

        return executeRequest(colorRequest);
    }

    @Override
    public Color[] getNewColors() throws IOException {
        return getNewColors(0);
    }

    @Override
    public Color[] getNewColors(int page) throws IOException {
        NewColorsRequest colorRequest = new NewColorsRequest()
                .setNumResults(pageSize)
                .setResultOffset(page * pageSize);

        return executeRequest(colorRequest);
    }

    @Override
    public Color[] getColorsWithBrightness(int minBri, int maxBri) throws IOException {
        return getColorsWithBrightness(minBri, maxBri, 0);
    }

    @Override
    public Color[] getColorsWithBrightness(int minBri, int maxBri, int page) throws IOException {
        ColorsRequest colorsRequest = new ColorsRequest()
                .setBriRange(minBri, maxBri)
                .setNumResults(pageSize)
                .setResultOffset(page * pageSize);

        return executeRequest(colorsRequest);
    }

    public Color[] executeRequest(ColourLoverRequest colorRequest) throws IOException {
        try {
            colorRequest.setFormat("json");
            String response = ColourLoverClient.executeRequest(colorRequest);
            return gson.fromJson(response, Color[].class);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
