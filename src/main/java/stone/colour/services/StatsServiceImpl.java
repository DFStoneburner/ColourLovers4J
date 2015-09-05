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
import stone.colour.client.ColourLoverClient;
import stone.colour.models.Stats;
import stone.colour.requests.StatsColorsRequest;
import stone.colour.requests.StatsLoversRequest;
import stone.colour.requests.StatsPalettesRequest;
import stone.colour.requests.StatsPatternsRequest;
import stone.colour.requests.core.ColourLoverRequest;

import java.io.IOException;

/**
 * Created by Daniel Stoneburner on 9/5/2015.
 */
public class StatsServiceImpl implements StatsService {
    private Gson gson;

    public StatsServiceImpl() {
        gson = new GsonBuilder()
                .create();
    }

    @Override
    public Stats getColorsStats() throws IOException {
        StatsColorsRequest statsColorsRequest = new StatsColorsRequest();

        Stats statsResponse = executeRequest(statsColorsRequest);

        return statsResponse;
    }

    @Override
    public Stats getLoversStats() throws IOException {
        StatsLoversRequest statsLoversRequest = new StatsLoversRequest();

        Stats statsResponse = executeRequest(statsLoversRequest);

        return statsResponse;
    }

    @Override
    public Stats getPalettesStats() throws IOException {
        StatsPalettesRequest statsPalettesRequest = new StatsPalettesRequest();

        Stats statsResponse = executeRequest(statsPalettesRequest);

        return statsResponse;
    }

    @Override
    public Stats getPatternsStats() throws IOException {
        StatsPatternsRequest statsPatternsRequest = new StatsPatternsRequest();

        Stats statsResponse = executeRequest(statsPatternsRequest);

        return statsResponse;
    }

    public Stats executeRequest(ColourLoverRequest colorRequest) throws IOException {
        try {
            colorRequest.setFormat("json");
            String response = ColourLoverClient.executeRequest(colorRequest);
            return gson.fromJson(response, Stats.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
