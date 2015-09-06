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

import stone.colour.models.Stats;
import stone.colour.requests.core.ColourLoverRequest;

import java.io.IOException;

/**
 * Created by Daniel Stoneburner on 9/5/2015.
 */
public interface StatsService extends ColourLoverService<Stats> {

    /**
     * Gets the current statistics on Colors from ColourLovers.
     *
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     */
    Stats getColorsStats() throws IOException;

    /**
     * Gets the current statistics on Lovers from ColourLovers.
     *
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     */
    Stats getLoversStats() throws IOException;

    /**
     * Gets the current statistics on Palettes from ColourLovers.
     *
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     */
    Stats getPalettesStats() throws IOException;

    /**
     * Gets the current statistics on Patterns from ColourLovers.
     *
     * @return
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     * @see #executeRequest
     */
    Stats getPatternsStats() throws IOException;
}
