package service;

import java.util.Map;

public interface payService {

	int setPayInfo(Map<String, Object> paramMap, int payWay);

	int getSeatPrice(Map<String, Object> param);

}
