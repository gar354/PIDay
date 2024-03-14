String[] piData;
String piDigits;
String bDay = "";
String bDayUK = "";

public void setup() {
  piData = loadStrings("pi-million.txt");
  piDigits = piData[0].replace(".", "");
  
  MyPI.setPIString(piDigits);
  size(400, 400);
  background(0);
}

void draw() {}

void keyTyped() {
  if (key == ENTER && bDay.length() == 10) {
      System.out.println("Finding birthday: " + bDay);
      MyPI.findInPI(bDay.replace("/", ""));
      
      bDayUK = bDay.substring(3,6) + bDay.substring(0, 3) + bDay.substring(6);
      System.out.println("Finding UK birthday: " + bDayUK);
      MyPI.findInPI(bDayUK.replace("/", ""));
  } else if (key == BACKSPACE && bDay != "") {
      bDay = bDay.substring(0, bDay.length() - 1);
  } else if (Character.isDigit(key) && bDay.length() < 10) {
    if (checkDigitInterval(bDay.length())) {
      bDay = bDay + '/';
    } else {
      bDay = bDay + key;
    }
  }
  background(0);
  textSize(40);
  textAlign(CENTER);
  text(bDay, 200, 200);
}

boolean checkDigitInterval(int digit) {
  return (2 == digit || 5 == digit);
}
