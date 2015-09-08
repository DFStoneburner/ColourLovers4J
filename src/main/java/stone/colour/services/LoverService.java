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

import stone.colour.models.Lover;
import stone.colour.requests.core.ColourLoverRequest;

import java.io.IOException;

/**
 * Service layer for single and multiple Lover operations.
 *
 * Created by Daniel Stoneburner on 9/5/2015.
 *
 * @see ColourLoverService
 */
public interface LoverService extends ColourLoverService<Lover[]> {

    /**
     * Gets a Lover based on their username
     *
     * @param user the username to search for
     * @return the lover queried for or null if they do not exist
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     */
    Lover getLover(String user) throws IOException;

    /**
     * A wrapper for {@link #getNewLovers(int)} which gets the first page.
     *
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getNewLovers(int)
     */
    Lover[] getNewLovers() throws IOException;

    /**
     * Gets the specified page of the newest Lovers.
     *
     * @param page the page number that determines the offset to query
     * @return when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @throws IOException
     */
    Lover[] getNewLovers(int page) throws IOException;

    /**
     * A wrapper for {@link #getTopLovers(int)} which gets the first page.
     *
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getTopLovers(int)
     */
    Lover[] getTopLovers() throws IOException;

    /**
     * Gets the specified page of the most popular Lovers.
     *
     * @param page the page number that determines the offset to query
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     */
    Lover[] getTopLovers(int page) throws IOException;
}
