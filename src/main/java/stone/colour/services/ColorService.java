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

import stone.colour.models.Color;
import stone.colour.requests.core.ColourLoverRequest;

import java.io.IOException;

/**
 * Service layer for single and multiple Color operations.
 *
 * Created by Daniel Stoneburner on 9/3/2015.
 *
 * @see ColourLoverService
 */
public interface ColorService extends ColourLoverService<Color[]> {

    /**
     * Gets a Color based on its ID.
     *
     * @param hexId the ColourLovers id of the color
     * @return the color queried or null if it does not exist
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     */
    Color getColor(String hexId) throws IOException;

    /**
     * Gets a random Color. Subsequent calls will return results from
     * subsequent calls to ColourLovers providing new results.
     *
     * @return the color provided by ColourLovers random endpoint
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     */
    Color getRandomColor() throws IOException;

    /**
     * A wrapper method for {@link #getTopColors(int page)} which gets the first
     * page of results.
     *
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getTopColors(int)
     */
    Color[] getTopColors() throws IOException;

    /**
     * Gets the specified page of the most popular Colors.
     *
     * @param page the page number that determines the offset to query
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     */
    Color[] getTopColors(int page) throws IOException;

    /**
     * A wrapper method for {@link #getNewColors(int page)} which gets the first
     * page of results.
     *
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getNewColors(int)
     */
    Color[] getNewColors() throws IOException;

    /**
     * Gets the specified page of the most recent Colors.
     *
     * @param page the page number that determines the offset to query
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     */
    Color[] getNewColors(int page) throws IOException;

    /**
     * A wrapper method for {@link #getColorsWithBrightness(int, int, int)} which gets
     * the first page of results.
     *
     * @param minBri minimum brightness, must be gt 0
     * @param maxBri maximum brightness, must be lt 99
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getColorsWithBrightness(int, int, int)
     */
    Color[] getColorsWithBrightness(int minBri, int maxBri) throws IOException;

    /**
     * Gets the specified page of Colors with specified brightness.
     *
     * @param minBri minimum brightness, must be gt 0
     * @param maxBri maximum brightness, must be lt 99
     * @param page the page number that determines the offset to query
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     */
    Color[] getColorsWithBrightness(int minBri, int maxBri, int page) throws IOException;
}
