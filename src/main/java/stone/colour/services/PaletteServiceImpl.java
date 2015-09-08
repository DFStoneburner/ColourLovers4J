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
import stone.colour.requests.*;
import stone.colour.requests.core.ColourLoverRequest;
import stone.colour.requests.core.HexFilterableRequest;

import java.io.IOException;

/**
 * Created by Daniel Stoneburner on 9/3/2015.
 */
public class PaletteServiceImpl implements PaletteService {
    private Gson gson;
    private int pageSize = 20;

    public PaletteServiceImpl() {
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .registerTypeAdapter(Hex.class, new HexAdapter())
                .create();
    }

    @Override
    public Palette getPalette(String hexId) throws IOException {
        PaletteRequest paletteRequest = new PaletteRequest()
                    .setValue(hexId);

            Palette[] palettesResponse = executeRequest(paletteRequest);

            return palettesResponse != null && palettesResponse.length > 0
                    ? palettesResponse[0]
                    : null;
    }

    @Override
    public Palette getRandomPalette() throws IOException {
        RandomPaletteRequest randomPaletteRequest = new RandomPaletteRequest();

        Palette[] palettesResponse = executeRequest(randomPaletteRequest);

        return palettesResponse != null && palettesResponse.length > 0
                ? palettesResponse[0]
                : null;
    }

    @Override
    public Palette[] getTopPalettes() throws IOException {
        return getTopPalettes(0);
    }

    @Override
    public Palette[] getTopPalettes(int page) throws IOException {
        TopPalettesRequest topPalettesRequest = new TopPalettesRequest()
                .setNumResults(pageSize)
                .setResultOffset(page * pageSize);

        return executeRequest(topPalettesRequest);
    }

    @Override
    public Palette[] getNewPalettes() throws IOException {
        return getNewPalettes(0);
    }

    @Override
    public Palette[] getNewPalettes(int page) throws IOException {
        NewPalettesRequest newPalettesRequest = new NewPalettesRequest()
                .setNumResults(pageSize)
                .setResultOffset(page * pageSize);

        return executeRequest(newPalettesRequest);
    }

    @Override
    public Palette[] getPalettesWithColors(String... stringHexes) throws IOException {
        return getPalettesWithColors(0, stringHexes);
    }

    @Override
    public Palette[] getPalettesWithColors(Hex... hexes) throws IOException {
        return getPalettesWithColors(0, hexes);
    }

    @Override
    public Palette[] getPalettesWithHues(String... stringHues) throws IOException {
        return getPalettesWithHues(0, stringHues);
    }

    @Override
    public Palette[] getPalettesWithHues(PalettesRequest.Hue... hues) throws IOException {
        return getPalettesWithHues(0, hues);
    }

    @Override
    public Palette[] getPalettesWithColors(int page, String... stringHexes) throws IOException {
        Hex[] hexes = new Hex[stringHexes.length];
        for(int i = 0; i < stringHexes.length; i++) {
            hexes [i] = new Hex(stringHexes[i]);
        }

        return getPalettesWithColors(hexes);
    }

    @Override
    public Palette[] getPalettesWithColors(int page, Hex... hexes) throws IOException {
        PalettesRequest palettesRequest = new PalettesRequest()
                .setHexes(hexes)
                .setNumResults(pageSize)
                .setResultOffset(page * pageSize);

        return executeRequest(palettesRequest);
    }

    @Override
    public Palette[] getPalettesWithHues(int page, String... stringHues) throws IOException {
        PalettesRequest.Hue[] hues = new PalettesRequest.Hue[stringHues.length];
        for(int i = 0; i < stringHues.length; i++) {
            hues [i] = HexFilterableRequest.Hue.valueOf(stringHues[i]);
        }

        return getPalettesWithHues(hues);
    }

    @Override
    public Palette[] getPalettesWithHues(int page, HexFilterableRequest.Hue... hues) throws IOException {
        PalettesRequest palettesRequest = new PalettesRequest()
                .setHues(hues)
                .setNumResults(pageSize)
                .setResultOffset(page * pageSize);

        return executeRequest(palettesRequest);
    }

    public Palette[] executeRequest(ColourLoverRequest colorRequest) throws IOException {
        try {
            colorRequest.setFormat("json");
            String response = ColourLoverClient.executeRequest(colorRequest);
            return gson.fromJson(response, Palette[].class);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
