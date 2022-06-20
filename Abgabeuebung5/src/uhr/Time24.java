package uhr;


import utilities.TastaturEingabe;

public class Time24 {
	//a)
		int hour, minute;

		public Time24(int hour, int minute) {
			setHour(hour);
			setMinute(minute);
		}

		public Time24() {
			hour = 0;
			minute = 0;
		}

		public Time24(Time24 obj) {
			this.hour = obj.getHour();
			this.minute = obj.getMinute();
		}

		public int getHour() {
			return hour;
		}

		public void setHour(int hour) {
			if (hour >= 0)
				this.hour = hour;
			else
				System.out.println("Stunden m�ssen positiv sein!");
		}

		public int getMinute() {
			return minute;
		}

		public void setMinute(int minute) {
			if (minute >= 0)
				this.minute = minute;
			else
				System.out.println("Minuten m�ssen positiv sein!");
		}

		public void readTime() {
			hour = TastaturEingabe.readInt("Stunden einlesen:\t");
			minute = TastaturEingabe.readInt("Minuten einlesen:\t");
			normalize();
		}

		public void writeTime() {
			System.out.println(toString());
		}

		public void addTime(int intervall) {
			if (intervall >= 0) {
				minute += intervall;
			} else {
				System.out.println("Negative Zahl konnte nicht hinzuaddiert werden");
			}
			normalize();
		}

		public String toString() {
			String time;
			if (getHour() < 10 && getMinute() < 10) {
				time = "0" + getHour() + ":" + "0" + getMinute();
			} else if (getHour() < 10) {
				time = "0" + getHour() + ":" + getMinute();
			} else if (getMinute() < 10) {
				time = getHour() + ":" + "0" + getMinute();
			} else {
				time = +getHour() + ":" + getMinute();
			}
			return time;
		}

		public void normalize() {
			if (this.minute > 59) {
				this.hour += this.minute / 60;
				this.minute = this.minute % 60;
			}
			if (this.hour > 23) {
				this.hour = this.hour % 24;
			}
		}

	//b)
		public static void main(String[] args) {
			Time24 sanfrancisco, frankfurt, melbourne;
			sanfrancisco = new Time24();
			sanfrancisco.setHour(0);
			sanfrancisco.setMinute(0);
			sanfrancisco.readTime();
			frankfurt = new Time24(sanfrancisco);
			frankfurt.addTime(9 * 60);
			melbourne = new Time24(sanfrancisco);
			melbourne.addTime(17 * 60);
			sanfrancisco.writeTime();
			frankfurt.writeTime();
			melbourne.writeTime();

		}

}
