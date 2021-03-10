import java.util.Scanner;

interface Shape
{
  public double getPerimeter ();

  public double getArea ();

  public void getDetails ();
}

class Circle implements Shape
{
  String Type = "Circle";
  float PI = 3.14f;
  int Radius;

  public Circle (int r)
  {
    Radius = r;
  }

  public double getPerimeter ()
  {
    return 2 * PI * Radius;
  }

  public double getArea ()
  {
    return PI * Math.pow (Radius, 2);
  }

  public void getDetails ()
  {
    System.out.println ("\n");
    System.out.println ("Type: " + Type);
    System.out.println ("Radius: " + Radius);
    System.out.println ("Perimeter: " +
			String.format ("%.1f", getPerimeter ()));
    System.out.println ("Area: " + String.format ("%.1f", getArea ()));
  }
}

class Rectangle implements Shape
{
  String Type = "Rectangle";
  int Length;
  int Width;

  public Rectangle (int w, int l)
  {
    Width = w;
    Length = l;
  }

  public double getPerimeter ()
  {
    return Width + Width + Length + Length;
  }

  public double getArea ()
  {
    return Length * Width;
  }

  public void getDetails ()
  {
    System.out.println ("\n");
    System.out.println ("Type: " + Type);
    System.out.println ("Width: " + Width);
    System.out.println ("Length: " + Length);
    System.out.println ("Perimeter: " +
			String.format ("%.1f", getPerimeter ()));
    System.out.println ("Area: " + String.format ("%.1f", getArea ()));
  }
}

class Square implements Shape
{
  String Type = "Square";
  int Side;

  public Square (int s)
  {
    Side = s;
  }

  public double getPerimeter ()
  {
    return Side * 4;
  }

  public double getArea ()
  {
    return Math.pow (Side, 2);
  }

  public void getDetails ()
  {
    System.out.println ("\n");
    System.out.println ("Type: " + Type);
    System.out.println ("Side: " + Side);
    System.out.println ("Perimeter: " +
			String.format ("%.1f", getPerimeter ()));
    System.out.println ("Area: " + String.format ("%.1f", getArea ()));
  }
}

class Triangle implements Shape
{
  String Type = "Triangle";
  int SideA;
  int SideB;
  int SideC;

  public Triangle (int a, int b, int c)
  {
    SideA = a;
    SideB = b;
    SideC = c;
  }

  public double getPerimeter ()
  {
    return SideA + SideB + SideC;
  }

  public double getArea ()
  {

    boolean ABC = (SideA + SideB) > SideC;
    boolean ACB = (SideA + SideC) > SideB;
    boolean BCA = (SideB + SideC) > SideA;

    if (ABC && ACB && BCA)
      {

	int s = (SideA + SideB + SideC) / 2;

	return Math.sqrt (s * (s - SideA) * (s - SideB) * (s - SideC));

      }
    else
      {
	return 0;
      }

  }

  public void getDetails ()
  {
    System.out.println ("\n");
    System.out.println ("Type: " + Type);
    System.out.println ("Sides: " + SideA + ", " + SideB + ", " + SideC);
    System.out.println ("Perimeter: " +
			String.format ("%.1f", getPerimeter ()));
    System.out.println ("Area: " + String.format ("%.1f", getArea ()));
  }
}

public class Main
{

  public static void main (String[]args)
  {

    DisplayTable ();

    Scanner inputScanner = new Scanner (System.in);

      System.out.print ("Enter a Code: ");

    int shape = inputScanner.nextInt ();

    String selectedShape = getShape (shape);

    if (selectedShape != "non-shape")
      {
	System.out.println ("You selected shape : " + selectedShape);

	CallByName (selectedShape);

      }
    else
      {
	System.out.println ("Opps,that option is not available!");
      }

  }

  public static void DisplayTable ()
  {

    String Shapes[] = { "Circle", "Square", "Rectangle", "Triangle" };

    String leftAlignFormat = "| %-15s | %-4d |%n";
    System.out.format ("+-----------------+------+%n");
    System.out.format ("| Shape Name      | Code |%n");
    System.out.format ("+-----------------+------+%n");

    for (int index = 0; index < Shapes.length; index++)
      {
	System.out.format (leftAlignFormat, Shapes[index], index + 1);
      }

    System.out.format ("+-----------------+------+%n");
  }

  public static String getShape (int target)
  {

    String selected = "non-shape";

    if (target == 1)
      {
	selected = "Circle";
      }
    else if (target == 2)
      {
	selected = "Square";
      }
    else if (target == 3)
      {
	selected = "Rectangle";
      }
    else if (target == 4)
      {
	selected = "Triangle";
      }

    return selected;
  }

  public static void CallByName (String Name)
  {
    switch (Name)
      {
      case "Circle":
	Circle ();
	break;
      case "Rectangle":
	Rectangle ();
	break;
      case "Triangle":
	Triangle ();
	break;
      case "Square":
	Square ();
	break;
      }
  }

  public static void Circle ()
  {
    Scanner inputScanner = new Scanner (System.in);
    System.out.print ("Enter Circle Radius: ");

    int Radius = inputScanner.nextInt ();

    Circle circle = new Circle (Radius);

    circle.getDetails ();
  }

  public static void Rectangle ()
  {
    int Width = 1;
    int Length = 0;
    int Flag = 0;

    while (Width > Length)
      {
	Scanner inputScanner = new Scanner (System.in);
	System.out.print ("Enter Width and Length: ");

	String Lines = inputScanner.nextLine ();
	String Values[] = Lines.split (" ");

	Width = Integer.parseInt (Values[0]);
	Length = Integer.parseInt (Values[1]);

	Flag++;

	if (Flag != 0)
	  {
	    System.out.println
	      ("Length should be greater than Width, Please Try again!");
	  }

      }

    Rectangle rectangle = new Rectangle (Width, Length);

    rectangle.getDetails ();
  }

  public static void Square ()
  {
    Scanner inputScanner = new Scanner (System.in);
    System.out.print ("Enter Triangle Side: ");

    int Side = inputScanner.nextInt ();

    Square square = new Square (Side);

    square.getDetails ();
  }

  public static void Triangle ()
  {
    Scanner inputScanner = new Scanner (System.in);
    System.out.print ("Enter Sides A B C: ");

    String Lines = inputScanner.nextLine ();
    String Values[] = Lines.split (" ");
    int a = Integer.parseInt (Values[0]);
    int b = Integer.parseInt (Values[1]);
    int c = Integer.parseInt (Values[2]);

    Triangle triangle = new Triangle (a, b, c);

    triangle.getDetails ();
  }
}
