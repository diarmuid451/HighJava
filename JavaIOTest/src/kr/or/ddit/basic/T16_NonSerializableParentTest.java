package kr.or.ddit.basic;

import java.io.*;

/**
 * 부모클래스가 Serializable 인터페이스를 구현하고 있지 않을 경우 부모객체의 필드값 처리 방법
 * 
 * 1. 부모클래스가 Serializable 인터페이스를 구현하도록 해야 한다.
 * 2. 자식클래스에 writeObject()와 readObject()메서드를 이용하여 부모객체의 필드값을 처리할 수 있도록 직접 구현한다.
 */
public class T16_NonSerializableParentTest {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("E:/D_Other/NonSerializableTest.bin"); 
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Child child = new Child();
		child.setParentName("부모");
		child.setChildName("자식");
		oos.writeObject(child); 		//직렬화
		oos.flush(); 		//생략 가능
		oos.close();
		
		FileInputStream fis = new FileInputStream("E:/D_Other/NonSerializableTest.bin");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Child child2 = (Child) ois.readObject(); 		//역 직렬화
		System.out.println("parentName : "+child2.getParentName());
		System.out.println("childName : "+child2.getChildName());
	}
}


/**
 * Serializable을 구현화 하지 않은 부모 클래스
 */
class Parent {
	private String parentName;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
}

class Child extends Parent implements Serializable {
	private String childName;

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}
	
	/**
	 * 직렬화 될 때 자동으로 호출된다.(접근 제한자가 private이 아니면 자동 호출되지 않는다.)
	 * @param out
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream out) throws IOException{
		//ObjectOutputStream객체의 메서드를 이용하여 부모객체 필드값 처리
		out.writeUTF(getChildName());
		out.defaultWriteObject();
	}

	
	/**
	 * 역질렬화 될때 자동으로 호출된다.(접근 제한자가 private이 아니면 자동호출되지 않는다.)
	 * @param in
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
		//ObjectOutputStream객체의 메서드를 이용하여 부모객체 필드값 처리
		setParentName(in.readUTF());
		in.defaultReadObject();
	}
}
