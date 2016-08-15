package site.nebulas.entity;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class Person {
	private String name;
	private Integer age;
	private List<Person> children;
	public Person() {
	}
	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	public Person(String name, Integer age, List<Person> children) {
		this.name = name;
		this.age = age;
		this.children = children;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public List<Person> getChildren() {
		return children;
	}
	public void setChildren(List<Person> children) {
		this.children = children;
	}
	
	
	public static void main(String[] args) {
		Person child11 = new Person("child11",11);
		Person child12 = new Person("child12",12);
		List<Person> childList = new ArrayList<Person>();
		childList.add(child11);
		childList.add(child12);
		Person person = new Person("person",1,childList);
		
		System.out.println(JSONArray.toJSON(person));
		//输出
		//{"name":"person","children":[{"name":"child11","age":11},{"name":"child12","age":12}],"age":1}

	}
}
