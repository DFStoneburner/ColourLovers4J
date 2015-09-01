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
import stone.colour.Endpoints;
import stone.colour.requests.ColorRequest;

import static org.junit.Assert.assertEquals;


/**
 * Created by Daniel on 8/29/2015.
 */
public class ColorRequestTests {

    @Test
    public void testNoParams() {
        ColorRequest colorRequest = new ColorRequest();

        assertEquals(Endpoints.COLOR.getRoot(), colorRequest.getAbsoluteUrl());
    }


    @Test
    public void testHexValue() {
        ColorRequest colorRequest = new ColorRequest().setHexValue("000000");

        assertEquals(Endpoints.COLOR.getRoot() + "/000000", colorRequest.getAbsoluteUrl());
    }
}
