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
 * Created by Daniel Stoneburner on 9/4/2015.
 */
public abstract class SearchableRequest extends SortableRequest {
    private String lover;
    private String keywords;
    private boolean keywordsExact;

    protected SearchableRequest(String root) {
        super(root);
    }

    public String getLover() {
        return lover;
    }

    public <T extends SearchableRequest> T setLover(String lover) {
        this.lover = lover;
        appendParam("lover", lover);

        return (T) this;
    }

    public String getKeywords() {
        return keywords;
    }

    public <T extends SearchableRequest> T setKeywords(String... keywords) {
        StringBuilder keywordsBuilder = new StringBuilder();
        for(String keyword: keywords) {
            if(keywordsBuilder.length() > 0) {
                keywordsBuilder.append("+");
            }
            keywordsBuilder.append(keyword);
        }
        this.keywords = keywordsBuilder.toString();

        appendParam("keywords", keywordsBuilder.toString());

        return (T) this;
    }

    public boolean isKeywordsExact() {
        return keywordsExact;
    }

    public <T extends SearchableRequest> T setKeywordsExact(boolean keywordsExact) {
        this.keywordsExact = keywordsExact;

        appendParam("keywordsExact", keywordsExact ? "1" : "0");

        return (T) this;
    }
}
