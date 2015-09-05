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
import stone.colour.models.Lover;
import stone.colour.requests.LoverRequest;
import stone.colour.requests.NewLoversRequest;
import stone.colour.requests.TopLoversRequest;
import stone.colour.requests.core.ColourLoverRequest;

import java.io.IOException;

/**
 * Created by Daniel Stoneburner on 9/5/2015.
 */
public class LoverServiceImpl implements LoverService {
    private Gson gson;
    private int pageSize = 20;

    public LoverServiceImpl() {
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
    }

    @Override
    public Lover getLover(String user) throws IOException {
        LoverRequest loverRequest = new LoverRequest()
                .setValue(user);

        Lover[] loversResponse = executeRequest(loverRequest);

        return loversResponse != null && loversResponse.length > 0
                ? loversResponse[0]
                : null;
    }

    @Override
    public Lover[] getNewLovers(int page) throws IOException {
        NewLoversRequest loversRequest = new NewLoversRequest()
                .setNumResults(pageSize)
                .setResultOffset(page * pageSize);

        Lover[] loversResponse = executeRequest(loversRequest);

        return loversResponse;
    }

    @Override
    public Lover[] getTopLovers(int page) throws IOException {
        TopLoversRequest loversRequest = new TopLoversRequest()
                .setNumResults(pageSize)
                .setResultOffset(page * pageSize);

        Lover[] loversResponse = executeRequest(loversRequest);

        return loversResponse;
    }

    @Override
    public Lover[] executeRequest(ColourLoverRequest loverRequest) throws IOException {
        try {
            loverRequest.setFormat("json");
            String response = ColourLoverClient.executeRequest(loverRequest);
            return gson.fromJson(response, Lover[].class);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
