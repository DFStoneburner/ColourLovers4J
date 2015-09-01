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

package stone.colour.client;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import stone.colour.requests.ColourLoverRequest;

import java.io.IOException;

/**
 * Created by Daniel Stoneburner on 8/29/2015.
 */
public class ColourLoverClient {
    static {
        okHttpClient = new OkHttpClient();
    }

    private static OkHttpClient okHttpClient;

    public static String executeRequest(ColourLoverRequest colourLoverRequest) throws IOException {
        Request request = new Request.Builder()
                .url(colourLoverRequest.getAbsoluteUrl())
                .build();

        Response response = okHttpClient
                .newCall(request)
                .execute();

        return response.body().string();
    }
}
