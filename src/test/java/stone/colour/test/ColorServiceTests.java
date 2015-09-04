package stone.colour.test;/*
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

import org.junit.Assert;
import org.junit.Test;
import stone.colour.models.Color;
import stone.colour.services.ColorServiceImpl;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Daniel Stoneburner on 8/27/2015.
 */
public class ColorServiceTests {

    @Test
    public void testGet() throws IOException {
        ColorServiceImpl colorServiceImpl = new ColorServiceImpl();
        Color color = colorServiceImpl.getColor("6B4106");

        assertNotNull(
                color
        );
    }

    @Test
    public void testGetRandomColors() throws IOException {
        ColorServiceImpl colorServiceImpl = new ColorServiceImpl();
        Color color = colorServiceImpl.getRandomColor();

        assertNotNull(color);
    }

    @Test
    public void testGetTopColors() throws IOException {
        ColorServiceImpl colorServiceImpl = new ColorServiceImpl();
        Color[] firstPage = colorServiceImpl.getTopColors(0);

        assertNotNull(firstPage);

        Color[] secondPage = colorServiceImpl.getTopColors(1);

        assertNotNull(secondPage);
    }

}
