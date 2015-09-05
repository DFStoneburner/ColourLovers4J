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

import java.util.Date;
import java.util.List;

/**
 *
 * Created by Daniel Stoneburner on 9/5/2015.
 */
public class Lover extends Base {
    Date dateRegistered;
    Date dateLastActive;
    long rating;
    String location;
    long numColors;
    long numPalettes;
    long numPatterns;
    long numCommentsMade;
    long numLovers;
    long numCommentsOnProfile;
    List<Comment> comments;

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Date getDateLastActive() {
        return dateLastActive;
    }

    public void setDateLastActive(Date dateLastActive) {
        this.dateLastActive = dateLastActive;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getNumColors() {
        return numColors;
    }

    public void setNumColors(long numColors) {
        this.numColors = numColors;
    }

    public long getNumPalettes() {
        return numPalettes;
    }

    public void setNumPalettes(long numPalettes) {
        this.numPalettes = numPalettes;
    }

    public long getNumPatterns() {
        return numPatterns;
    }

    public void setNumPatterns(long numPatterns) {
        this.numPatterns = numPatterns;
    }

    public long getNumCommentsMade() {
        return numCommentsMade;
    }

    public void setNumCommentsMade(long numCommentsMade) {
        this.numCommentsMade = numCommentsMade;
    }

    public long getNumLovers() {
        return numLovers;
    }

    public void setNumLovers(long numLovers) {
        this.numLovers = numLovers;
    }

    public long getNumCommentsOnProfile() {
        return numCommentsOnProfile;
    }

    public void setNumCommentsOnProfile(long numCommentsOnProfile) {
        this.numCommentsOnProfile = numCommentsOnProfile;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
