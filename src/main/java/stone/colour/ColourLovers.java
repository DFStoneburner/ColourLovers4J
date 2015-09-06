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

package stone.colour;

import stone.colour.models.*;
import stone.colour.requests.core.ColourLoverRequest;
import stone.colour.requests.core.HexFilterableRequest;
import stone.colour.services.*;

import java.io.IOException;

/**
 * A wrapping facade that delegates all requests and serves
 * as a middle man to provide ease of use in consuming code.
 *
 * Created by Daniel Stoneburner on 9/6/2015.
 */
public class ColourLovers {
    private ColorService colorService;
    private LoverService loverService;
    private PaletteService paletteService;
    private PatternService patternService;
    private StatsService statsService;

    public ColourLovers() {
        colorService = new ColorServiceImpl();
        loverService = new LoverServiceImpl();
        paletteService = new PaletteServiceImpl();
        patternService = new PatternServiceImpl();
        statsService = new StatsServiceImpl();
    }

    public Color getColor(String hexId) throws IOException {
        return colorService.getColor(hexId);
    }

    public Color getRandomColor() throws IOException {
        return colorService.getRandomColor();
    }

    public Color[] getTopColors() throws IOException {
        return colorService.getTopColors();
    }

    public Color[] getTopColors(int page) throws IOException {
        return colorService.getTopColors(page);
    }

    public Color[] getColorsWithBrightness(int minBri, int maxBri, int page) throws IOException {
        return colorService.getColorsWithBrightness(minBri, maxBri, page);
    }

    public Color[] getNewColors() throws IOException {
        return colorService.getNewColors();
    }

    public Color[] getColorsWithBrightness(int minBri, int maxBri) throws IOException {
        return colorService.getColorsWithBrightness(minBri, maxBri);
    }

    public Color[] getNewColors(int page) throws IOException {
        return colorService.getNewColors(page);
    }

    public Lover[] getTopLovers(int page) throws IOException {
        return loverService.getTopLovers(page);
    }

    public Lover getLover(String user) throws IOException {
        return loverService.getLover(user);
    }

    public Lover[] getNewLovers() throws IOException {
        return loverService.getNewLovers();
    }

    public Lover[] getNewLovers(int page) throws IOException {
        return loverService.getNewLovers(page);
    }

    public Lover[] getTopLovers() throws IOException {
        return loverService.getTopLovers();
    }

    public Palette getPalette(String hexId) throws IOException {
        return paletteService.getPalette(hexId);
    }

    public Palette[] getTopPalettes(int page) throws IOException {
        return paletteService.getTopPalettes(page);
    }

    public Palette[] getPalettesWithHues(int page, HexFilterableRequest.Hue... hues) throws IOException {
        return paletteService.getPalettesWithHues(page, hues);
    }

    public Palette[] getNewPalettes() throws IOException {
        return paletteService.getNewPalettes();
    }

    public Palette[] getPalettesWithColors(Hex... hexes) throws IOException {
        return paletteService.getPalettesWithColors(hexes);
    }

    public Palette[] getPalettesWithColors(int page, Hex... hexes) throws IOException {
        return paletteService.getPalettesWithColors(page, hexes);
    }

    public Palette[] getPalettesWithHues(int page, String... stringHues) throws IOException {
        return paletteService.getPalettesWithHues(page, stringHues);
    }

    public Palette[] getTopPalettes() throws IOException {
        return paletteService.getTopPalettes();
    }

    public Palette[] getPalettesWithColors(String... stringHexes) throws IOException {
        return paletteService.getPalettesWithColors(stringHexes);
    }

    public Palette[] getPalettesWithHues(HexFilterableRequest.Hue... hues) throws IOException {
        return paletteService.getPalettesWithHues(hues);
    }

    public Palette getRandomPalette() throws IOException {
        return paletteService.getRandomPalette();
    }

    public Palette[] getPalettesWithColors(int page, String... stringHexes) throws IOException {
        return paletteService.getPalettesWithColors(page, stringHexes);
    }

    public Palette[] getNewPalettes(int page) throws IOException {
        return paletteService.getNewPalettes(page);
    }

    public Palette[] getPalettesWithHues(String... stringHues) throws IOException {
        return paletteService.getPalettesWithHues(stringHues);
    }

    public Pattern getPattern(String hexId) throws IOException {
        return patternService.getPattern(hexId);
    }

    public Pattern[] getPatternsWithColors(Hex... hexes) throws IOException {
        return patternService.getPatternsWithColors(hexes);
    }

    public Pattern[] getTopPatterns(int page) throws IOException {
        return patternService.getTopPatterns(page);
    }

    public Pattern[] getPatternsWithHues(int page, String... stringHues) throws IOException {
        return patternService.getPatternsWithHues(page, stringHues);
    }

    public Pattern[] getPatternsWithHues(String... stringHues) throws IOException {
        return patternService.getPatternsWithHues(stringHues);
    }

    public Pattern[] getPatternsWithColors(String... stringHexes) throws IOException {
        return patternService.getPatternsWithColors(stringHexes);
    }

    public Pattern[] getPatternsWithColors(int page, Hex... hexes) throws IOException {
        return patternService.getPatternsWithColors(page, hexes);
    }

    public Pattern[] getNewPatterns() throws IOException {
        return patternService.getNewPatterns();
    }

    public Pattern[] getTopPatterns() throws IOException {
        return patternService.getTopPatterns();
    }

    public Pattern[] getPatternsWithColors(int page, String... stringHexes) throws IOException {
        return patternService.getPatternsWithColors(page, stringHexes);
    }

    public Pattern[] getPatternsWithHues(int page, HexFilterableRequest.Hue... hues) throws IOException {
        return patternService.getPatternsWithHues(page, hues);
    }

    public Pattern[] getPatternsWithHues(HexFilterableRequest.Hue... hues) throws IOException {
        return patternService.getPatternsWithHues(hues);
    }

    public Pattern[] getNewPatterns(int page) throws IOException {
        return patternService.getNewPatterns(page);
    }

    public Pattern getRandomPattern() throws IOException {
        return patternService.getRandomPattern();
    }

    public Stats getColorsStats() throws IOException {
        return statsService.getColorsStats();
    }

    public Stats getPatternsStats() throws IOException {
        return statsService.getPatternsStats();
    }

    public Stats getPalettesStats() throws IOException {
        return statsService.getPalettesStats();
    }

    public Stats getLoversStats() throws IOException {
        return statsService.getLoversStats();
    }

    public Color[] executeColorRequest(ColourLoverRequest request) throws IOException {
        return colorService.executeRequest(request);
    }

    public Lover[] executeLoverRequest(ColourLoverRequest request) throws IOException {
        return loverService.executeRequest(request);
    }

    public Palette[] executePaletteRequest(ColourLoverRequest request) throws IOException {
        return paletteService.executeRequest(request);
    }

    public Pattern[] executePatternRequest(ColourLoverRequest request) throws IOException {
        return patternService.executeRequest(request);
    }

    public Stats executeStatsRequest(ColourLoverRequest request) throws IOException {
        return statsService.executeRequest(request);
    }
}
