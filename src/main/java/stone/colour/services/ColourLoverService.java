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

import stone.colour.requests.core.ColourLoverRequest;

import java.io.IOException;

/**
 * Base interface that defines a common pattern for centralizing the call logic
 * within the implementing services.
 *
 * Created by Daniel Stoneburner on 9/3/2015.
 */
public interface ColourLoverService<T> {
    /**
     * The common call that each implementing service will make to create
     * compatibility between the services and the requests pattern.
     *
     * @param request request to be executed with variables all defined
     * @return the parsed/deserialized response from the request
     * @throws IOException when underlying {@link #executeRequest(ColourLoverRequest)} encounters an exception
     */
    T executeRequest(ColourLoverRequest request) throws IOException;
}
