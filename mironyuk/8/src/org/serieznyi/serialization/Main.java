package org.serieznyi.serialization;

import org.serieznyi.serialization.serializer.Serializer;
import org.serieznyi.serialization.serializer.exception.FormatNotSupportedException;

public class Main {
  private static final XmlPrettyFormatter xmlPrettyFormatter = new XmlPrettyFormatter();

  public static void main(String[] args) throws XmlPrettyFormatter.FormattingException {
    Person person = new Person("Василий", 22, "password123");
    person.friend = new Person("Алексей", 24, "password125");
    person.rating = 21.0F;
    person.favoriteChar = 'F';
    person.hasChildes = true;
    person.height = 181;
    person.phone = 783308165733L;

    System.out.println("Создали объект для сериализации\n");

    System.out.println(person);

    Serializer serializer = new Serializer();

    try {
      String xml = serializer.serialize(person, Serializer.Format.XML);

      System.out.println("\nСериализованный в XML объект\n");

      System.out.println(xmlPrettyFormatter.toPrettyView(xml));

      System.out.println("\nОбъект полученный из XML\n");

      Object objectFromXml = serializer.deserialize(xml, Person.class, Serializer.Format.XML);

      System.out.println(objectFromXml);
    } catch (FormatNotSupportedException e) {
      System.out.println("Сериализатор не смог найти подходящий кодировщик для выбранного формата");
    }
  }
}
