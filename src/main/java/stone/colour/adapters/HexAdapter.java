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

package stone.colour.adapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import stone.colour.models.Hex;

import java.io.IOException;

/**
 * Created by Daniel Stoneburner on 9/3/2015.
 */
public class HexAdapter extends TypeAdapter<Hex> {
    @Override
    public void write(JsonWriter out, Hex value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        out.value(value.getRaw());
    }

    @Override
    public Hex read(JsonReader in) throws IOException {
        if(in.peek() == null) {
            in.nextNull();
            return null;
        }
        return new Hex(in.nextString());
    }
}
