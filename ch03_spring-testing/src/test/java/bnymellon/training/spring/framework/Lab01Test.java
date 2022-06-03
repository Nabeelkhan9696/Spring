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
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import bnymellon.training.spring.framework.model.BulkVehicleOrder;
import bnymellon.training.spring.framework.model.Vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;

//TODO: Run this test with the right runner.
//TODO: Use default XML context configuration to configure an order of 10 count of 2017 car.
public class Lab01Test {

    @Autowired
    private BulkVehicleOrder bulkVehicleOrder;
    private ApplicationContext context;


    @Test
    public void defaultXmlContextPath() {
    	context = new ClassPathXmlApplicationContext("classpath:/bnymellon/training/spring/framework/Ex01_DefaultXMLContextConfiguration-context.xml");

        // TODO: Add a vehicle XML bean definition with id=vehicle as a 2017 car.
        // TODO: Add a bulkVehicleOrder XML bean definition with the above vehicle and quantity of 10.
        // UNCOMMENT BELOW CODE AND TEST.
    	
    	BulkVehicleOrder bulkVehicleOrder = (BulkVehicleOrder) context.getBean("bulkVehicleOrder");

        assertEquals(
                10,
                bulkVehicleOrder.getQuantity(),
                "The quantity of vehicles should be [10]"
        );

        assertEquals(
                "2017 car",
                bulkVehicleOrder.getVehicle().toString(),
                "The shape should be [2017 car]"
        );

    }

}
