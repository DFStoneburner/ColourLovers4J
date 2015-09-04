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
public abstract class SortableRequest extends ColourLoverRequest {
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

    private OrderByCol orderByCol;
    private SortBy sortBy;
    private int numResults;
    private int resultOffset;

    protected SortableRequest(String root) {
        super(root);
    }
    public OrderByCol getOrderByCol() {
        return orderByCol;
    }

    public <T extends SortableRequest> T setOrderByCol(OrderByCol orderByCol) {
        this.orderByCol = orderByCol;

        appendParam("orderCol", orderByCol);

        return (T) this;
    }

    public SortBy getSortBy() {
        return sortBy;
    }

    public <T extends SortableRequest> T setSortBy(SortBy sortBy) {
        this.sortBy = sortBy;

        appendParam("sortBy", sortBy);

        return (T) this;
    }

    public int getNumResults() {
        return numResults;
    }

    public <T extends SortableRequest> T setNumResults(int numResults) {
        this.numResults = numResults;

        appendParam("numResults", numResults);

        return (T) this;
    }

    public int getResultOffset() {
        return resultOffset;
    }

    public <T extends SortableRequest> T setResultOffset(int resultOffset) {
        this.resultOffset = resultOffset;

        appendParam("resultOffset", resultOffset);

        return (T) this;
    }
}
