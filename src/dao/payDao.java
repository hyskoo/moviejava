package dao;

import java.util.ArrayList;
import java.util.Map;

public interface payDao {
	
	int setPayInfo(Map<String, Object> param, String sway);

	int getSeatPrice(Map<String, Object> param);

}
