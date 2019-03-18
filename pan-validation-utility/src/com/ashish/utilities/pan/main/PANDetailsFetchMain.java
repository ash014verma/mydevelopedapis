package com.ashish.utilities.pan.main;

import com.ashish.utilities.pan.service.PANDetailsFetchService;

public class PANDetailsFetchMain {
	
	public static void main(String[] args) {
		PANDetailsFetchService pANDetailsFetchService = new PANDetailsFetchService();
		pANDetailsFetchService.retrievePANDetails();
	}

}
