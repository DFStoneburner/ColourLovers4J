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
import stone.colour.models.Palette;
import stone.colour.requests.core.ColourLoverRequest;
import stone.colour.requests.core.HexFilterableRequest;

import java.io.IOException;

/**
 * Created by Daniel Stoneburner on 9/4/2015.
 */
public interface PaletteService  extends ColourLoverService<Palette[]> {

    /**
     * Gets a Palette based on its ID.
     *
     * @param hexId the ColourLovers id of the palette
     * @return the palette queried or null if it does not exist
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     */
    Palette getPalette(String hexId) throws IOException;

    /**
     * Gets a random Palette. Subsequent calls will return results from
     * subsequent calls to ColourLovers providing new results.
     *
     * @return the palette provided by ColourLovers random endpoint
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     */
    Palette getRandomPalette() throws IOException;

    /**
     * A wrapper method for {@link #getTopPalettes(int page)} which gets the first
     * page of results.
     *
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getTopPalettes(int)
     */
    Palette[] getTopPalettes() throws IOException;

    /**
     * Gets the specified page of the most popular Palettes.
     *
     * @param page the page number that determines the offset to query
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getTopPalettes()
     */
    Palette[] getTopPalettes(int page) throws IOException;

    /**
     * A wrapper method for {@link #getNewPalettes(int page)} which gets the first
     * page of results.
     *
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getNewPalettes(int)
     */
    Palette[] getNewPalettes() throws IOException;

    /**
     * Gets the specified page of the latest Palettes.
     *
     * @param page the page number that determines the offset to query
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getNewPalettes()
     */
    Palette[] getNewPalettes(int page) throws IOException;

    /**
     * A wrapper method for {@link #getPalettesWithColors(int, String...)} which gets the first
     * page of results.
     *
     * @param stringHexes
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getPalettesWithColors(int, String...)
     */
    Palette[] getPalettesWithColors(String... stringHexes) throws IOException;

    /**
     * A wrapper method for {@link #getPalettesWithColors(int, Hex...)} which gets the first
     * page of results.
     *
     * @param hexes
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getPalettesWithColors(int, Hex...)
     */
    Palette[] getPalettesWithColors(Hex... hexes) throws IOException;

    /**
     * A wrapper method for {@link #getPalettesWithColors(int, String...)} which gets the first
     * page of results.
     *
     * @param stringHues
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getPalettesWithColors(int, String...)
     */
    Palette[] getPalettesWithHues(String... stringHues) throws IOException;

    /**
     * A wrapper method for {@link #getPalettesWithHues(int, HexFilterableRequest.Hue...)} which gets the first
     * page of results.
     *
     * @param hues
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getPalettesWithHues(int, HexFilterableRequest.Hue...)
     */
    Palette[] getPalettesWithHues(HexFilterableRequest.Hue... hues) throws IOException;

    /**
     * A wrapper method for {@link #getPalettesWithColors(int, Hex...)} which first creates the Hex
     * equivalents of the String values.
     *
     * @param page the page number that determines the offset to query
     * @param stringHexes the string representation of the hex values the returned palettes must contain
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getPalettesWithColors(int, Hex...)
     */
    Palette[] getPalettesWithColors(int page, String... stringHexes) throws IOException;

    /**
     * Gets the specified page of palettes that contain all of the specified colors.
     *
     * @param page the page number that determines the offset to query
     * @param hexes the hex values the returned palettes must contain
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getPalettesWithColors(int, String...)
     */
    Palette[] getPalettesWithColors(int page, Hex... hexes) throws IOException;

    /**
     * A wrapper method for {@link #getPalettesWithHues(int, HexFilterableRequest.Hue...)} which first creates the Hex
     * equivalents of the String values.
     *
     * @param page the page number that determines the offset to query
     * @param stringHues the string representation of the hue values the returned palettes must contain
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getPalettesWithHues(int, HexFilterableRequest.Hue...)
     */
    Palette[] getPalettesWithHues(int page, String... stringHues) throws IOException;

    /**
     * Gets the specified page of palettes that contain all of the specified hues.
     *
     * @param page the page number that determines the offset to query
     * @param hues the hex values the returned palettes must contain
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     * @see #getPalettesWithHues(int, String...)
     */
    Palette[] getPalettesWithHues(int page, HexFilterableRequest.Hue... hues) throws IOException;
}
