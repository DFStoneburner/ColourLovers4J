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
import stone.colour.requests.PatternRequest;
import stone.colour.requests.RandomPatternRequest;
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
                .setHexValue(hexId);

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
