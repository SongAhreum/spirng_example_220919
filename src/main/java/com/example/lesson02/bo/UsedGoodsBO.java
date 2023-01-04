package com.example.lesson02.bo;
//business object
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.lesson02.dao.UsedGoodsDAO;
import com.example.lesson02.model.UsedGoods;

@Service
public class UsedGoodsBO { //UsedGoodsService
//dao를 가져옴
	@Autowired //Spring bean을 주입받음 (DI)Dependency Injection
	//Spring bean을 가져오는 방법은 3가지정도 더있음
	private UsedGoodsDAO usedGoodsDAO;
	
	//메서드에서 가장중요한
	//input : X (controller로부터넘겨주게 없음)
	//output : List<UsedGoods>
	public List<UsedGoods> getUsedGoodsList(){
		//List<UsedGoods> usedGoodsList = usedGoodsDAO.selectUsedGoodsList();
		//return usedGoodsList;
		
		
		return usedGoodsDAO.selectUsedGoodsList();
	}
}
