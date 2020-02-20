package epsi.cooking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Recette")
public class Recette {
	private Integer _id;
	private String _name;
	private String _description;
	
	public Recette() {
	}
	
	public Recette(Integer id, String name, String description){
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
	}

	@Id
	@Column(name = "ID")
	public int getId() {
		return _id;
	}

	public void setId(int _id) {
		this._id = _id;
	}
	
	@Column(name = "NAME")
	public String getName() {
		return _name;
	}

	public void setName(String _name) {
		this._name = _name;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return _description;
	}

	public void setDescription(String _description) {
		this._description = _description;
	}
	
	@Override
	public String toString() {
		return "Recette{id=" + this._id + ", name=" + this._name + ", description=" + this._description + "}";
	}
}
