## Description:

Expectation is a versatile Java validation library designed to simplify and enhance the validation process in your
projects. With Expectation, validating objects becomes an intuitive and expressive experience, allowing you to create
clear and concise validation rules.

## Key Features:

- Fluent API: Build expressive validation rules using a fluent and chainable syntax.
- Somewhat comprehensive Conditions: A rich set of conditions such as notNull, isEmpty, isEqual, isGreaterThan,
  isLessThan, and many more, providing flexibility in defining your validation criteria.
- [future]Extensibility: Easily extend the library with custom conditions to suit your specific validation needs.
- Readable Code: Improve the readability of your validation logic by chaining conditions together, making it easy to
  understand and maintain.

## Usage:

Get started with Expectation by creating an Expect instance with your object and chaining various conditions:

```java
String text = "hello from the other side";

Expect.of(text)
    .notNull()
    .lengthGt(8,"I think %s is less than 8.",text.length)
    .lowercase("Value must be lowercase");
```
