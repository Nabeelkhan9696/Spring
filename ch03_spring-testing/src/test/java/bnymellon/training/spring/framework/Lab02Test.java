/*
 * Copyright 2021 The Bank of New York Mellon.
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

package bnymellon.training.spring.framework;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bnymellon.training.spring.framework.model.BulkVehicleOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;


//TODO: Run this test with the right runner.
//TODO: custom XML context configuration to configure an order of 7 count of 2016 pickup.
public class Lab02Test {

    @Autowired
    private BulkVehicleOrder bulkVehicleOrder;
    private ApplicationContext context;

    @Test
    public void customXmlContextPath() {
    	context = new ClassPathXmlApplicationContext("classpath:/ex02.xml");

        // TODO: Add a vehicle XML bean definition with id=vehicle as a 2016 pickup.
        // TODO: Add a bulkVehicleOrder XML bean definition with the above vehicle and quantity of 7.
        // UNCOMMENT BELOW CODE AND TEST.

    	BulkVehicleOrder bulkVehicleOrder = (BulkVehicleOrder) context.getBean("bulkVehicleOrder");

        assertEquals(
                7,
                bulkVehicleOrder.getQuantity(),
                "The quantity of vehicles should be [7]"
        );

        assertEquals(
                "2016 pickup",
                bulkVehicleOrder.getVehicle().toString(),
                "The shape should be [2016 pickup]"
        );

    }

}
