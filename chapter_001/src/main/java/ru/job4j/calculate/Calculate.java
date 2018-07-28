package ru.parsentev;
/**
* Calculate.
*
* @author Trishin Ivan (rbhorses@mail.ru)
*/
public class Calculate {
/**
* Method echo.
* @param value
* @return "%s"
*/
public String echo(String value) {
return String.format("%s %s %s", value, value, value);
}
/**
* Main.
* @param args - args
*/
public static void main(String[] args){
Calculate calc = new Calculate();
System.out.println(calc.echo("aah"));
}
}
