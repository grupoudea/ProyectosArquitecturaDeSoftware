/* Author: Oscar Darío Botero Vargas
 * Date:   Sábado 23 de enero de 2021
 * Notes:
 */

package co.edu.udea.casoPracticoMS.DTO;

public class ContactoDTO {

  public ContactoDTO() {
    id = -1L;
    firstName = "";
    lastName = "";
    phoneNumber = "";
    email = "";
  }

  public ContactoDTO(
    Long id,
    String nombre,
    String apellido,
    String numeroTelefonico,
    String correoElectronico
  ) {
    this.id = id;
    firstName = nombre;
    lastName = apellido;
    phoneNumber = numeroTelefonico;
    email = correoElectronico;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return '{' +
      "\"id\":\""          + id + "\"," +
      "\"firstName\":\""   + firstName + "\"," +
      "\"lastName\":\""    + lastName + "\"," +
      "\"phoneNumber\":\"" + phoneNumber + "\"," +
      "\"email\":\""       + email + '"' +
    '}';
  }

  private Long id;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String email;
}