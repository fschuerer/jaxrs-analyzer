/*
 * Copyright 2018 XLKAFR.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sebastian_daschner.jaxrs_analyzer.model.swagger;

import com.sebastian_daschner.jaxrs_analyzer.model.rest.HttpMethod;
import java.util.HashSet;
import java.util.Set;
import javax.json.JsonObject;

/**
 *
 * @author XLKAFR
 */
public class Path {

    public JsonObject get;
    public JsonObject put;
    public JsonObject post;
    public JsonObject head;
    public JsonObject delete;
    public JsonObject patch;
    public JsonObject options;

    public Set<HttpMethod> getHttpMethods() {
        Set<HttpMethod> result = new HashSet<>();

        if (delete != null) {
            result.add(HttpMethod.DELETE);
        }
        if (get != null) {
            result.add(HttpMethod.GET);
        }
        if (head != null) {
            result.add(HttpMethod.HEAD);
        }
        if (options != null) {
            result.add(HttpMethod.OPTIONS);
        }
        if (patch != null) {
            result.add(HttpMethod.PATCH);
        }
        if (post != null) {
            result.add(HttpMethod.POST);
        }
        if (put != null) {
            result.add(HttpMethod.PUT);
        }

        return result;
    }
}
