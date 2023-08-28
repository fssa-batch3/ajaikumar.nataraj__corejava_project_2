package com.fssa.rishi.services;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.rishi.dao.UserDAO;

 class TestReadBuyerFeature {

    @Test
    void testReadBuyer(){
    	try {
			UserDAO.readUser();
		} catch (Exception e) {
			e.printStackTrace();  
			fail();
		}

    }
	 
	
}

