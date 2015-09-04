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

package stone.colour.models;

/**
 * Created by Daniel Stoneburner on 9/3/2015.
 */
public class Hex {
    private String raw;

    public Hex(String raw) {
        if(raw == null || raw.length() != 6)
            throw new IllegalArgumentException("Hex value must be a String with length of 6");
        this.raw = raw;
    }

    public String getRaw() {
        return raw;
    }

    public String getRed() {
        return raw.substring(1,3);
    }

    public int getRedInt() {
        return Integer.valueOf(getRed(), 16);
    }

    public String getGreen() {
        return raw.substring(3,5);
    }

    public int getGreenInt() {
        return Integer.valueOf(getGreen(), 16);
    }

    public String getBlue() {
        return raw.substring(5,7);
    }

    public int getBlueInt() {
        return Integer.valueOf(getBlue(), 16);
    }

    public RGB getRGB() {
        return convertHexToRGB(this);
    }

    public HSV getHSV() {
        return convertHexToHSV(this);
    }


    public static RGB convertHexToRGB(Hex hex) {
        RGB rgb = new RGB();
        rgb.setRed(hex.getRedInt());
        rgb.setGreen(hex.getGreenInt());
        rgb.setBlue(hex.getBlueInt());
        return rgb;
    }

    public static HSV convertHexToHSV(Hex hex) {
        HSV hsv = new HSV();
        int red = hex.getRedInt();
        int green = hex.getGreenInt();
        int blue = hex.getBlueInt();
        int min;
        int max;
        if (red < green)
        {
            min = red;
            max = green;
        }
        else
        {
            min = green;
            max = red;
        }
        if (blue > max)
            max = blue;
        else if (blue < min)
            min = blue;
        hsv.setValue(max / 255f);
        if (max == 0)
            hsv.setSaturation(0);
        else
        hsv.setSaturation(((float) (max - min)) / ((float) max));
        if (hsv.getSaturation() == 0)
            hsv.setHue(0);
        else
        {
            float delta = (max - min) * 6;
            if (red == max)
                hsv.setHue((green - blue) / delta);
            else if (green == max)
                hsv.setHue(1f / 3 + (blue - red) / delta);
            else
                hsv.setHue(2f / 3 + (red - green) / delta);
            if (hsv.getHue() < 0)
                hsv.setHue(hsv.getHue() + 1);
        }
        return hsv;
    }
}
