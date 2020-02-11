package kr.or.ddit.structural.decorator;

public class RedShapeDecorator extends ShapeDecorator{

	public RedShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}

	@Override
	public void draw() {
		decoratedShape.draw(); 	// 기본 기능
		setRedBorder(decoratedShape);  // 경계선 빨간색 칠하기 기능 추가
		
	}

	private void setRedBorder(Shape decoratedShape) {
		System.out.println("경계선 색을 빨강으로 칠하기");
	}
}
