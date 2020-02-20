package epsi.cooking.api;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import epsi.cooking.entities.Recette;
import epsi.cooking.utils.DataUtils;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CookingController {
	@GetMapping("/recettes")
	public String getRecette(){
		JSONArray json = new JSONArray();
		for (Recette recette : DataUtils.getRecettes()) {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("ID", recette.getId());
			jsonObj.put("NAME", recette.getName());
			jsonObj.put("DESCRIPTION", recette.getDescription());
			json.put(jsonObj);
		}
		
		return json.toString();
	}
}
