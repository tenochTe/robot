package com.robot;

public class RobotMain {

	public static void main(String[] args) {
		RobotMain.Robot secondRobot =new RobotMain.Robot(2,1);
			secondRobot.printCurrentCoordinates();
			secondRobot.moveX(1);
			secondRobot.printLastMove();
			secondRobot.printCurrentCoordinates();
			secondRobot.moveY(1);
			secondRobot.printLastCoordinates();
			secondRobot.printCurrentCoordinates();
	}
	
	// Remove Static nestad class if it's using from a method
	public static class Robot {
		private Integer corrienteX;
		private Integer actualY;
		private Integer anteriorX;
		private Integer anteriorY;
		private boolean moveX;
		private boolean moveY;
		
		public Robot() {
			this.corrienteX=0;
			this.actualY=5;
		}
		
		public Robot(Integer corrienteX, Integer actualY) {
			this.corrienteX=corrienteX;
			this.actualY=actualY;
		}
		
		public Integer getCorrienteX() {
			return corrienteX;
		}

		public void setCorrienteX(Integer corrienteX) {
			this.corrienteX = corrienteX;
		}

		public Integer getActualY() {
			return actualY;
		}

		public void setActualY(Integer actualY) {
			this.actualY = actualY;
		}

		public Integer getAnteriorX() {
			return anteriorX;
		}

		public void setAnteriorX(Integer anteriorX) {
			this.anteriorX = anteriorX;
		}

		public Integer getAnteriorY() {
			return anteriorY;
		}

		public void setAnteriorY(Integer anteriorY) {
			this.anteriorY = anteriorY;
		}

		public void moveX(Integer dx) {
			setAnteriorX(getCorrienteX());
			setCorrienteX(getCorrienteX()+dx);
			setMoveX(true);
			setMoveY(false);
		}
		
		public void moveY(Integer dy) {
			setAnteriorY(getActualY());
			setActualY(getActualY()+dy);
			setMoveX(false);
			setMoveY(true);
		}
		
		public boolean isMoveX() {
			return moveX;
		}

		public void setMoveX(boolean moveX) {
			this.moveX = moveX;
		}

		public boolean isMoveY() {
			return moveY;
		}

		public void setMoveY(boolean moveY) {
			this.moveY = moveY;
		}

		public void printCurrentCoordinates() {
			System.out.println(getCorrienteX() +" "+ getActualY());
		}
		
		public void printLastCoordinates() {
			if (isMoveX())
				System.out.println( (getCorrienteX()-getAnteriorX()) +" "+ getActualY());
			else
				System.out.println( getCorrienteX() +" "+ (getActualY()- getAnteriorY()) );
		}
		
		public void printLastMove() {
			if (isMoveX())
				System.out.println( (getCorrienteX()-getAnteriorX()) );
			else
				System.out.println( (getAnteriorY()-getActualY()) );
		}
		
	}

}
