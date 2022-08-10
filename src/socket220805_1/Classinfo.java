package socket220805_1;

import java.io.Serializable;

public class Classinfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	int kor;
	int eng;
	int math;
	
	public Classinfo() {
		
	}

	public Classinfo(String id, String name, int kor, int eng, int math) {
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Classinfo [id=" + id + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}
	
}
