package com.ashish.utilities.pan.service;

import java.util.List;

import javax.inject.Named;

import com.ashish.utilities.pan.dao.PANDetailsDAOImpl;
import com.ashish.utilities.pan.vo.PANDetailsVO;
import com.ashish.utilities.serviceinterface.IUtilitiesService;


@Named("PANDetailsFetchService")
public class PANDetailsFetchService implements IUtilitiesService {
	
	private PANDetailsDAOImpl panDetailsDAOImpl;
	public  List<PANDetailsVO> retrievePANDetails(){
		panDetailsDAOImpl = new PANDetailsDAOImpl();
		return panDetailsDAOImpl.fetchPANDetails();
	}
}
