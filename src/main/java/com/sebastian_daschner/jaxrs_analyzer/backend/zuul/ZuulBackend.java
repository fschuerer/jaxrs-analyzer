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
package com.sebastian_daschner.jaxrs_analyzer.backend.zuul;

import com.sebastian_daschner.jaxrs_analyzer.backend.swagger.SwaggerBackend;
import com.sebastian_daschner.jaxrs_analyzer.model.rest.ResourceMethod;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author XLKAFR
 */
public abstract class ZuulBackend extends SwaggerBackend {

    @Override
    public abstract String getName();

    @Override
    protected JsonObject renderInternal() {
        appendHeader();
        appendPaths();

        return builder.build();
    }

    @Override
    protected JsonObjectBuilder buildForMethod(final ResourceMethod method, final String s) {
        final JsonArrayBuilder consumes = Json.createArrayBuilder();
        method.getRequestMediaTypes().stream().sorted().forEach(consumes::add);

        final JsonArrayBuilder produces = Json.createArrayBuilder();
        method.getResponseMediaTypes().stream().sorted().forEach(produces::add);

        final JsonObjectBuilder builder = Json.createObjectBuilder();

        return builder;
    }
}
