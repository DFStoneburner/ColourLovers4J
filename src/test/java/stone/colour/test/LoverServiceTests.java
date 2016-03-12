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
import stone.colour.models.Lover;
import stone.colour.services.LoverService;
import stone.colour.services.LoverServiceImpl;
import stone.colour.test.categories.IntegrationTest;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Daniel Stoneburner on 9/5/2015.
 */
public class LoverServiceTests {

    @Test
    @Category(IntegrationTest.class)
    public void testGetLover() throws IOException {
        LoverService loverService = new LoverServiceImpl();
        Lover lover = loverService.getLover("dfstoneburner");

        assertNotNull(lover);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetNewLovers() throws IOException {
        LoverService loverService = new LoverServiceImpl();
        Lover[] lovers = loverService.getNewLovers(0);

        assertNotNull(lovers);
        assertTrue(lovers.length > 0);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetTopLovers() throws IOException {
        LoverService loverService = new LoverServiceImpl();
        Lover[] lovers = loverService.getTopLovers(0);

        assertNotNull(lovers);
        assertTrue(lovers.length > 0);
    }
}
