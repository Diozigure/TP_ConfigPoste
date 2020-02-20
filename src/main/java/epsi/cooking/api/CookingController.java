package epsi.cooking.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import epsi.cooking.entities.Recette;
import epsi.cooking.utils.DataUtils;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CookingController {
	@GetMapping("/recettes")
	public List<Recette> getRecette(){
		return DataUtils.getRecettes();
	}
}
