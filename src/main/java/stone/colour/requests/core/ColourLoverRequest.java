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

/**
 * Created by Daniel Stoneburner on 8/27/2015.
 */
public abstract class ColourLoverRequest {
    private StringBuilder paramsBuilder;
    private StringBuilder rootBuilder;
    private String format;
    private String callback;

    protected ColourLoverRequest(String root) {
        paramsBuilder = new StringBuilder();
        rootBuilder = new StringBuilder(root);
    }

    public String getFormat() {
        return format;
    }

    public <T extends ColourLoverRequest> T setFormat(String format) {
        this.format = format;
        appendParam("format", format);
        return (T) this;
    }

    public String getCallback() {
        return callback;
    }

    public ColourLoverRequest setCallback(String callback) {
        this.callback = callback;
        appendParam("jsonCallback", callback);
        return this;
    }

    protected void appendParam(String key, Object... values) {
        if(paramsBuilder.length() == 0) {
            paramsBuilder.append("?");
        } else {
            paramsBuilder.append("&");
        }
        paramsBuilder.append(key).append("=");
        for(int i = 0; i < values.length; i++) {
            if(i > 0) {
                paramsBuilder.append(",");
            }
            paramsBuilder.append(values[i]);
        }
    }

    protected void appendUrl(Object value) {
        rootBuilder.append("/").append(value);
    }

    public String getAbsoluteUrl() {
        StringBuilder urlBuilder = new StringBuilder(rootBuilder);
        urlBuilder.append(paramsBuilder);
        return urlBuilder.toString();
    }
}
