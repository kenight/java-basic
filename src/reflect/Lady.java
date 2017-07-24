package reflect;

import java.util.List;

public class Lady {

	public String name;
	private int age;
	public List<String> friend;

	public String toString() {
		return "name:" + name + " age:" + age + " friend:" + friend;
	}

	public Lady() {
		super();
	}

	public Lady(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Lady(String name, List<String> friend) {
		super();
		this.name = name;
		this.friend = friend;
	}

	public Lady(String name, int age, List<String> friend) {
		super();
		this.name = name;
		this.age = age;
		this.friend = friend;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getFriend() {
		return friend;
	}

	public void setFriend(List<String> friend) {
		this.friend = friend;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lady other = (Lady) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
