package JavaSBAProject_03;

public class Course {
	
	int id;
	String name;
	String description;
	
	public Course() {
		
	}
	
	public Course(int id, String name, String description){
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		String output = "\n" + "Course ID: " + this.id + "\n" +
				"Course name: " + this.name +"\n" +
				"Course description: " + this.description;
		
		return output;
	}
	
	
	
	
	
	
}
