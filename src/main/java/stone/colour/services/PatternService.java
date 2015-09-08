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

import stone.colour.models.Hex;
import stone.colour.models.Pattern;
import stone.colour.requests.core.ColourLoverRequest;
import stone.colour.requests.core.HexFilterableRequest;

import java.io.IOException;

/**
 * Service layer for single and multiple Pattern operations.
 *
 * Created by Daniel Stoneburner on 9/3/2015.
 *
 * @see ColourLoverService
 */
public interface PatternService extends ColourLoverService<Pattern[]> {

    /**
     * Gets a Pattern based on its ID.
     *
     * @param hexId the ColourLovers id of the pattern
     * @return the palette queried or null if it does not exist
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     */
    Pattern getPattern(String hexId) throws IOException;

    /**
     * Gets a random Pattern. Subsequent calls will return results from
     * subsequent calls to ColourLovers providing new results.
     *
     * @return the pattern provided by ColourLovers random endpoint
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     */
    Pattern getRandomPattern() throws IOException;

    /**
     * A wrapper for {@link #getNewPatterns(int)} which gets the first page.
     *
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getNewPatterns(int)
     */
    Pattern[] getNewPatterns() throws IOException;

    /**
     * A wrapper for {@link #getTopPatterns(int)} which gets the first page.
     *
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getTopPatterns(int)
     */
    Pattern[] getTopPatterns() throws IOException;

    /**
     * A wrapper for {@link #getPatternsWithColors(int, String...)} which creates Hex values
     * from their String representations.
     *
     * @param stringHexes
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getPatternsWithColors(int, String...)
     * @see #getPatternsWithColors(int, Hex...)
     */
    Pattern[] getPatternsWithColors(String... stringHexes) throws IOException;

    /**
     * A wrapper for {@link #getPatternsWithColors(int, Hex...)} (int)} which gets the first page.
     *
     * @param hexes
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getPatternsWithColors(int, Hex...)
     */
    Pattern[] getPatternsWithColors(Hex... hexes) throws IOException;

    /**
     * A wrapper for {@link #getPatternsWithHues(int, String...)} which creates Hue
     * values from their String representations.
     *
     * @param stringHues
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getPatternsWithHues(int, String...)
     * @see #getPatternsWithHues(int, HexFilterableRequest.Hue...)
     */
    Pattern[] getPatternsWithHues(String... stringHues) throws IOException;

    /**
     * A wrapper for {@link #getPatternsWithHues(int, HexFilterableRequest.Hue...)} which gets the first page.
     *
     * @param hues
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getPatternsWithHues(int, HexFilterableRequest.Hue...)
     */
    Pattern[] getPatternsWithHues(HexFilterableRequest.Hue... hues) throws IOException;

    /**
     * Gets the specified page of the most popular Patterns.
     *
     * @param page the page number that determines the offset to query
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getNewPatterns()
     */
    Pattern[] getNewPatterns(int page) throws IOException;

    /**
     * Gets the specified page of the latest Patterns.
     *
     * @param page the page number that determines the offset to query
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getTopPatterns()
     */
    Pattern[] getTopPatterns(int page) throws IOException;

    /**
     * A wrapper method for {@link #getPatternsWithColors(int, Hex...)} which first creates the Hex
     * equivalents of the String values.
     *
     * @param page the page number that determines the offset to query
     * @param stringHexes the string representation of the hex values the returned patterns must contain
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getPatternsWithColors(int, Hex...)
     */
    Pattern[] getPatternsWithColors(int page, String... stringHexes) throws IOException;

    /**
     * Gets the specified page of patterns that contain all of the specified colors.
     *
     * @param page the page number that determines the offset to query
     * @param hexes the hex values the returned patterns must contain
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getPatternsWithColors(int, String...)
     */
    Pattern[] getPatternsWithColors(int page, Hex... hexes) throws IOException;

    /**
     * A wrapper method for {@link #getPatternsWithHues(int, HexFilterableRequest.Hue...)} which first creates the Hex
     * equivalents of the String values.
     *
     * @param page the page number that determines the offset to query
     * @param stringHues the string representation of the hue values the returned patterns must contain
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getPatternsWithHues(int, HexFilterableRequest.Hue...)
     */
    Pattern[] getPatternsWithHues(int page, String... stringHues) throws IOException;

    /**
     * Gets the specified page of patterns that contain all of the specified hues.
     *
     * @param page the page number that determines the offset to query
     * @param hues the hex values the returned patterns must contain
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getPatternsWithHues(int, String...)
     */
    Pattern[] getPatternsWithHues(int page, HexFilterableRequest.Hue... hues) throws IOException;
}
