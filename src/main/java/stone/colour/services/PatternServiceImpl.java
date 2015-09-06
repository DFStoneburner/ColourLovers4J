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
import stone.colour.models.Pattern;
import stone.colour.requests.*;
import stone.colour.requests.core.ColourLoverRequest;

import java.io.IOException;

/**
 * Created by Daniel Stoneburner on 9/4/2015.
 */
public class PatternServiceImpl implements PatternService {
    private Gson gson;
    private int pageSize = 20;

    public PatternServiceImpl() {
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .registerTypeAdapter(Hex.class, new HexAdapter())
                .create();
    }

    @Override
    public Pattern getPattern(String hexId) throws IOException {
        PatternRequest patternRequest = new PatternRequest()
                .setValue(hexId);

        Pattern[] patternsResponse = executeRequest(patternRequest);

        return patternsResponse != null && patternsResponse.length > 0
                ? patternsResponse[0]
                : null;
    }

    @Override
    public Pattern getRandomPattern() throws IOException {
        RandomPatternRequest randomPatternRequest = new RandomPatternRequest();

        Pattern[] patternsResponse = executeRequest(randomPatternRequest);

        return patternsResponse != null && patternsResponse.length > 0
                ? patternsResponse[0]
                : null;
    }

    @Override
    public Pattern[] getNewPatterns() throws IOException {
        return getNewPatterns(0);
    }

    @Override
    public Pattern[] getTopPatterns() throws IOException {
        return getTopPatterns(0);
    }

    @Override
    public Pattern[] getPatternsWithColors(String... stringHexes) throws IOException {
        return getPatternsWithColors(0, stringHexes);
    }

    @Override
    public Pattern[] getPatternsWithColors(Hex... hexes) throws IOException {
        return getPatternsWithColors(0, hexes);
    }

    @Override
    public Pattern[] getPatternsWithHues(String... stringHues) throws IOException {
        return getPatternsWithHues(0, stringHues);
    }

    @Override
    public Pattern[] getPatternsWithHues(PatternsRequest.Hue... hues) throws IOException {
        return getPatternsWithHues(0, hues);
    }

    @Override
    public Pattern[] getNewPatterns(int page) throws IOException {
        NewPatternsRequest newPatternRequest = new NewPatternsRequest()
                .setNumResults(pageSize)
                .setResultOffset(page * pageSize);

        return executeRequest(newPatternRequest);
    }

    @Override
    public Pattern[] getTopPatterns(int page) throws IOException {
        TopPatternsRequest topPatternRequest = new TopPatternsRequest()
                .setNumResults(pageSize)
                .setResultOffset(page * pageSize);

        return executeRequest(topPatternRequest);
    }

    @Override
    public Pattern[] getPatternsWithColors(int page, String... stringHexes) throws IOException {
        Hex[] hexes = new Hex[stringHexes.length];
        for(int i = 0; i < stringHexes.length; i++) {
            hexes [i] = new Hex(stringHexes[i]);
        }

        return getPatternsWithColors(0, hexes);
    }

    @Override
    public Pattern[] getPatternsWithColors(int page, Hex... hexes) throws IOException {
        PatternsRequest patternsRequest = new PatternsRequest()
                .setHexes(hexes)
                .setNumResults(pageSize)
                .setResultOffset(page * pageSize);

        return executeRequest(patternsRequest);
    }

    @Override
    public Pattern[] getPatternsWithHues(int page, String... stringHues) throws IOException {
        PatternsRequest.Hue[] hues = new PatternsRequest.Hue[stringHues.length];
        for(int i = 0; i < stringHues.length; i++) {
            hues [i] = PatternsRequest.Hue.valueOf(stringHues[i]);
        }

        return getPatternsWithHues(page, hues);
    }

    @Override
    public Pattern[] getPatternsWithHues(int page, PatternsRequest.Hue... hues) throws IOException {
        PatternsRequest patternsRequest = new PatternsRequest()
                .setHues(hues)
                .setNumResults(pageSize)
                .setResultOffset(page * pageSize);

        return executeRequest(patternsRequest);
    }

    @Override
    public Pattern[] executeRequest(ColourLoverRequest patternRequest) throws IOException {
        try {
            patternRequest.setFormat("json");
            String response = ColourLoverClient.executeRequest(patternRequest);
            return gson.fromJson(response, Pattern[].class);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
