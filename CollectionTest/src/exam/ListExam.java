package exam;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListExam {
	

 public static void main(String[] args) {
	List exam = new ArrayList<>();
	
	exam.add(10);
	exam.add(20);
	exam.add(30);
	exam.add(40);
	exam.add(50);
	exam.add(60);
	
	//void add(int index, Object element), boolean addAll(int index,Collection C)
	//지정된 위치(index)에 객체(element)또는 컬렉션에 포함된 객체들을 추가한다.
	
	List list1 = new ArrayList<>();

	
	list1.add(0, exam);
	list1.addAll(1, exam);
	System.out.println(list1);
	System.out.println("-------------------------------------------------");
	
	//Object get(int index)
	//지정된 위치(index)에 있는 객체를 반환한다.
	System.out.println(list1.get(3));
	System.out.println("-------------------------------------------------");
	
	//Object remove(int index)
	//지정된 위치(index)에 있는 객체를 삭제하고 삭제된 객체를 반환한다.
	int temp = (int)list1.remove(2);
	System.out.println(temp);
	System.out.println(list1);
	System.out.println("-------------------------------------------------");
	
	list1.clear();
	
	
	list1.add(10);
	list1.add(20);
	list1.add(30);
	list1.add(40);
	list1.add(50);
	list1.add(60);
	
	System.out.println(list1);
	
	//int indexOf(Object o)
	//지정된 객체의 위치(index)를 반환한다.(List의 첫 번째 요소부터 순방향으로 찾는다.)
	System.out.println(list1.indexOf(30));
	System.out.println("-------------------------------------------------");
	
	//int lastIndexOf(Object o)
	//지정된 객체의 위치(index)를 반환한다.(List의 마지막 요소부터 역방향으로 찾는다.)
	System.out.println(list1.lastIndexOf(40));
	System.out.println("-------------------------------------------------");
	
	//ListIterator listIterator(), ListIterator listIterator(int index)
	//List의 객체에 접근할 수 있는 ListIterator를 반환한다.
	
	ListIterator li = list1.listIterator();
	ListIterator lindex = list1.listIterator(3);
	
	System.out.println(li.next());
	System.out.println(lindex.next());
	System.out.println("-------------------------------------------------");
	
	//Object set(int index, Object element)
	//지정된 위치(index)에 객체(element)를 저장한다.
	
	temp = (int)list1.set(2, 90);
	System.out.println(temp);
	System.out.println(list1);
	System.out.println("-------------------------------------------------");
	
	//List subList(int fromIndex, int toIndex)
	//지정된 범위(fromIndex부터 toIndex)에 있는 객체를 반환한다.
	
	System.out.println(list1.subList(2, 5));
	System.out.println("-------------------------------------------------");
 	}

}
