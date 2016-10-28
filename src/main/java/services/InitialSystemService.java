package services;

import java.util.ArrayList;
import java.util.List;

import com.qaprosoft.dao.mybatis.TireDaoImpl;
import com.qaprosoft.models.Tire;

public class InitialSystemService {

	public void fillTires() {
		List<Tire> tires = new ArrayList<>();
		TireService service = new TireService();
		tires.addAll(service.fillList());
		TireDaoImpl tireDao = new TireDaoImpl();
		for(Tire tire: tires) {
			tireDao.insertTire(tire);
		}
	}
	
}
