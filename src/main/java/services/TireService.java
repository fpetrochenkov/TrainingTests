package services;

import java.util.ArrayList;
import java.util.List;
import com.qaprosoft.models.Tire;
import com.qaprosoft.pages.TiresCatalogPage;

public class TireService {
	
	TiresCatalogPage tireCatalog = new TiresCatalogPage(null);
	
	public List<Tire> fillList() {
		List<Tire> tires = new ArrayList<>();
		for(int i = 0; i<tireCatalog.getTireTitles().size(); i++) {
			Tire tire = new Tire();
			tire.setName(tireCatalog.getTireTitles().get(i).getText());
			tire.setPrice(tireCatalog.getTireCosts().get(i).getText());
			tire.setType(tireCatalog.getTireTypes().get(i).getText());
			tire.setCarType(tireCatalog.getTireCarType().getText());
			tire.setDiameter(tireCatalog.getTireDiameter().getText());
			tire.setParams(tireCatalog.getTireParams().getText());
		}
		return tires;
	}
	
	

}
