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

import org.junit.Assert;
import org.junit.Test;
import stone.colour.models.Color;
import stone.colour.services.ColorService;

import java.io.IOException;

/**
 * Created by Daniel Stoneburner on 8/27/2015.
 */
public class ColorRepositoryTests {

    @Test
    public void testGet() throws IOException {
        ColorService colorService = new ColorService();
        Color color = colorService.getColor("6B4106");

        Assert.assertNotNull(
                color
        );
    }

    @Test
    public void testGetRandomColors() throws IOException {
        ColorService colorService = new ColorService();
        Color color = colorService.getRandomColor();

        Assert.assertNotNull(color);
    }

    @Test
    public void testGetTopColors() throws IOException {
        ColorService colorService = new ColorService();
        Color[] firstPage = colorService.getTopColors(0);

        Assert.assertNotNull(firstPage);

        Color[] secondPage = colorService.getTopColors(1);

        Assert.assertNotNull(secondPage);
    }

}
