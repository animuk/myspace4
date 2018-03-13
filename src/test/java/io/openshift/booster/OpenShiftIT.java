/*
 * Copyright 2016-2017 Red Hat, Inc, and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.openshift.booster;

import java.net.URL;

import com.jayway.restassured.RestAssured;
import io.openshift.booster.service.GreetingProperties;
import org.arquillian.cube.openshift.impl.enricher.AwaitRoute;
import org.arquillian.cube.openshift.impl.enricher.RouteURL;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class OpenShiftIT extends AbstractBoosterApplicationTest {

    @AwaitRoute(path = "/health")
    @RouteURL("${app.name}")
    private URL baseURL;

    @Before
    public void setup() throws Exception {
        RestAssured.baseURI = baseURL + "api/greeting";
    }

    protected GreetingProperties getProperties() {
        return new GreetingProperties();
    }

}
