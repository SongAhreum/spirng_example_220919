package com.example.lesson02.dao;
//data access object
import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.lesson02.model.UsedGoods;

@Repository
//interface는 객체가 생성안됨 -> MyBatis프레임워크가 객체를 만들어주고 빈을 만들어줌
//(실질적으로 객체를 생성하는게아니라 MyBatis가 채워넣어주는) 
public interface UsedGoodsDAO {
	//메서드에서 가장중요한
	//input : X (Service(BO)로부터넘겨주게 없음)
	//output : List<UsedGoods>
	public List<UsedGoods> selectUsedGoodsList();
}
