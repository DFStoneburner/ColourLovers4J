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

package stone.colour.test;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import stone.colour.models.Stats;
import stone.colour.services.StatsService;
import stone.colour.services.StatsServiceImpl;
import stone.colour.test.categories.IntegrationTest;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Daniel Stoneburner on 9/5/2015.
 */
public class StatsServiceTests {
    @Test
    @Category(IntegrationTest.class)
    public void getColorsStats() throws IOException {
        StatsService statsService = new StatsServiceImpl();

        Stats colorStats = statsService.getColorsStats();

        assertNotNull(colorStats);
    }

    @Test
    @Category(IntegrationTest.class)
    public void getLoversStats() throws IOException {
        StatsService statsService = new StatsServiceImpl();

        Stats loverStats = statsService.getLoversStats();

        assertNotNull(loverStats);
    }

    @Test
    @Category(IntegrationTest.class)
    public void getPalettesStats() throws IOException {
        StatsService statsService = new StatsServiceImpl();

        Stats palettesStats = statsService.getPalettesStats();

        assertNotNull(palettesStats);
    }

    @Test
    @Category(IntegrationTest.class)
    public void getPatternsStats() throws IOException {
        StatsService statsService = new StatsServiceImpl();

        Stats patternsStats = statsService.getPatternsStats();

        assertNotNull(patternsStats);
    }
}
