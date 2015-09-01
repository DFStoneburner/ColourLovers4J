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

package stone.colour.requests;

import stone.colour.Endpoints;

/**
 * Created by Daniel Stoneburner on 8/27/2015.
 */
public class ColorsRequest extends ColourLoverRequest {
    public enum OrderByCol {
        DATE_CREATED("dateCreated"),
        SCORE("score"),
        NAME("name"),
        NUM_VOTES("numVotes"),
        NUM_VIEWS("numViews");

        private String value;

        OrderByCol(String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }

    public enum SortBy {
        ASC,
        DESC;
    }

    private String lover;
    private int hueMinimum;
    private int hueMaximum;
    private int briMinimum;
    private int briMaximum;
    private String keywords;
    private boolean keywordsExact;
    private OrderByCol orderByCol;
    private SortBy sortBy;
    private int numResults;
    private int resultOffset;

    public ColorsRequest() {
        super(Endpoints.COLORS.getRoot());
    }

    protected ColorsRequest(String root) {
        super(root);
    }

    public String getLover() {
        return lover;
    }

    public <T extends ColorsRequest> T setLover(String lover) {
        this.lover = lover;
        appendParam("lover", lover);

        return (T) this;
    }

    public int getHueMinimum() {
        return hueMinimum;
    }

    public int getHueMaximum() {
        return hueMaximum;
    }

    public <T extends ColorsRequest> T setHueRange(int hueMaximum, int hueMinimum) {
        this.hueMaximum = hueMaximum;
        this.hueMinimum = hueMinimum;

        appendParam("hueRange", hueMinimum, hueMaximum);

        return (T) this;
    }

    public int getBriMinimum() {
        return briMinimum;
    }

    public int getBriMaximum() {
        return briMaximum;
    }

    public <T extends ColorsRequest> T setBriRange(int briMaximum, int briMinimum) {
        this.briMaximum = briMaximum;
        this.briMinimum = briMinimum;

        appendParam("briRange", briMinimum, briMaximum);

        return (T) this;
    }

    public String getKeywords() {
        return keywords;
    }

    public <T extends ColorsRequest> T setKeywords(String... keywords) {
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

    public <T extends ColorsRequest> T setKeywordsExact(boolean keywordsExact) {
        this.keywordsExact = keywordsExact;

        appendParam("keywordsExact", keywordsExact ? "1" : "0");

        return (T) this;
    }

    public OrderByCol getOrderByCol() {
        return orderByCol;
    }

    public <T extends ColorsRequest> T setOrderByCol(OrderByCol orderByCol) {
        this.orderByCol = orderByCol;

        appendParam("orderCol", orderByCol);

        return (T) this;
    }

    public SortBy getSortBy() {
        return sortBy;
    }

    public <T extends ColorsRequest> T setSortBy(SortBy sortBy) {
        this.sortBy = sortBy;

        appendParam("sortBy", sortBy);

        return (T) this;
    }

    public int getNumResults() {
        return numResults;
    }

    public <T extends ColorsRequest> T setNumResults(int numResults) {
        this.numResults = numResults;

        appendParam("numResults", numResults);

        return (T) this;
    }

    public int getResultOffset() {
        return resultOffset;
    }

    public <T extends ColorsRequest> T setResultOffset(int resultOffset) {
        this.resultOffset = resultOffset;

        appendParam("resultOffset", resultOffset);

        return (T) this;
    }
}
