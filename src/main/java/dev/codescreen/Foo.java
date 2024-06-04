package dev.codescreen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Dummy class with a dummy method.
 * Rename this class and method to a name that is more appropriate to your coding test.
 */
@SpringBootApplication
public class Foo {

  /**
   *
   *
   * @return
   */
  public static int bar() {
    return 1;
  }
  public static void main(String[] args) {
		SpringApplication.run(Foo.class, args);
	}
}
