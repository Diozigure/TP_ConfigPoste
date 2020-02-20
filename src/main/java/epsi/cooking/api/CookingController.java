package epsi.cooking.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import epsi.cooking.entities.Recette;
import epsi.cooking.utils.DataUtils;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class CookingController {
	
	@GetMapping("/recettes")
	public String getRecette() {
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

	@GetMapping("/exportPDF")
	public ResponseEntity<InputStreamResource> exportPDF(@RequestParam String idRecettes) {
		
		String[] ids = idRecettes.split(",");
		File file = DataUtils.getPDF(ids);
		InputStreamResource resource = null;
		try {
			resource = new InputStreamResource(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			Logger.getLogger(CookingController.class).log(Level.ERROR, e.getMessage());
		}

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
				.contentType(MediaType.APPLICATION_PDF).contentLength(file.length())
				.body(resource);
	}
	
}
