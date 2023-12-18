# Expectation

Expectation is a versatile Java validation library designed to simplify and enhance the validation process in your projects. With Expectation, validating objects becomes an intuitive and expressive experience, allowing you to create clear and concise validation rules.

## Key Features

- Fluent API: Build expressive validation rules using a fluent and chainable syntax.
- Comprehensive Conditions: A rich set of conditions such as notNull, isEmpty, isEqual, isGreaterThan, isLessThan, and many more, providing flexibility in defining your validation criteria.
- Extensibility: Easily extend the library with custom conditions to suit your specific validation needs.
- Readable Code: Improve the readability of your validation logic by chaining conditions together, making it easy to understand and maintain.

## Usage

Get started with Expectation by creating an Expect instance with your object and chaining various conditions:

### Validations

```java
String text = "hello from the other side";
Expect.of(text)
    .notNull()
    .lengthGt(8,"I think %s is less than 8.",text.length)
    .lowercase("Value must be lowercase");

int number = 10;
Expect.of(number)
    .notNull()
    .greaterThan(5, "Number should be greater than 5")
    .lessThan(20, "Number should be less than 20");

boolean value = true;
Expect.of(value)
    .notNull()
    .isTrue("Value should be true");

Object obj = new Object();
Expect.of(obj)
    .notNull();

Object obj = Expect.of(obj)
    .ifNotNull(() -> objRepository.save(obj));

Optional<String> optional = Optional.of("hello");
Expect.of(optional)
    .notNull()
    .isPresent("Optional should be present");

LocalDateTime dateTime = LocalDateTime.now();
Expect.of(dateTime)
    .notNull()
    .isAfter(LocalDateTime.of(2020, 1, 1, 0, 0), "DateTime should be after 2020-01-01T00:00");
```

and a lot more...

### Classes

- Expect: The main class that users of the library will interact with. It provides methods for chaining conditions and performing the validation.
- ExpectationFailedException: This exception is thrown when a validation fails.
- Constraint: This is an interface that all conditions implements.
- ObjectConstraint: This class provides methods for validating object values.
- BooleanConstraint: This class provides methods for validating boolean values.
- NumberConstraint: This class provides methods for validating numeric values.
- StringConstraint: This class provides methods for validating string values.
- OptionalConstraint: This class provides methods for validating Optional values.
- ChronoLocalDateTimeConstraint: This class provides methods for validating ChronoLocalDateTime values.

### Building

To run the tests, use the following command:

```
mvn test
```

To create a JAR file in target directory:

```
mvn package
```

### License

This project is licensed under the Apache License, Version 2.0. See the LICENSE file for details.
